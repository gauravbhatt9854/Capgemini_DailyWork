package com.gal.March7;

import com.gal.EntityManaagerFactoryProvider;
import com.gal.model.Item;
import com.gal.model.Supplier;
import com.gal.model.Supply;
import com.gal.model.Type;
import jakarta.persistence.CascadeType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class Main {

    private final static EntityManager em = EntityManaagerFactoryProvider.getEntityManager();

    public static List<String> getAllSupplier()
    {
        Query query = em.createQuery("select s.name from Supplier s", String.class);
        List<String> list = query.getResultList();
        return list;
    }


    public static List<String> getAllSupplierFromCity(String city)
    {
        Query query = em.createQuery("select s.name from Supplier s where s.city = :city", String.class);
        query.setParameter("city", city);
        List<String> list = query.getResultList();
        return list;
    }

    public static List<String> getItemBySuppierId(Long id)
    {
        Query query = em.createQuery("select s.item.name from Supply s where s.supplier.id = :id ", String.class);
        query.setParameter("id", id);
        List<String> list = query.getResultList();
        return list;
    }

    public static void main(String[] args) {

        EntityTransaction entityTransaction =  em.getTransaction();

        entityTransaction.begin();

        Item item = new Item("Tomato" , Type.VEG);
        Item item1 = new Item("Onion" , Type.VEG);
        Item item2 = new Item("Suger" , Type.GROC);
//
////        em.persist(item);
////        em.persist(item1);
////        em.persist(item2);
//
        Supplier supplier = new Supplier("Delhi" , "Rajan enterprices" , 4.5);
        Supplier supplier1 = new Supplier("Gurugram" , "Indian supply" , 3.4);
//
////        em.persist(supplier);
////        em.persist(supplier1);
//
        Supply supply = new Supply(
                Date.valueOf(LocalDate.of(2019,3,3)),
                item1,36L , supplier,50L
        );

        Supply supply1 = new Supply(
                Date.valueOf(LocalDate.of(2019,5,5)),
                item2,10L , supplier,45L
        );

        Supply supply2 = new Supply(
                Date.valueOf(LocalDate.of(2019,8,15)),
                item,50L , supplier1,10L
        );
//
        em.persist(supply);
        em.persist(supply1);
        em.persist(supply2);

//        List<String> str =  getAllSupplier();
//        System.out.println(str);
//
//        List<String> str1 =  getAllSupplierFromCity("Delhi");
//        System.out.println(str1);
//
//        List<String> str2 =  getItemBySuppierId(1L);
//        System.out.println(str2);

        entityTransaction.commit();
    }
}
