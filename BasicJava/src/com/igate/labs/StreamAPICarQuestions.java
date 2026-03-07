package com.igate.labs;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamAPICarQuestions {

	public static void main(String[] args) {
		List<Car> cars = CarRepository.getCars();
		List<Owner> owners = CarRepository.getOwners();
		// 1. Return the list of names of the owners currently having no cars
		List<String> list = owners.stream().filter(o -> o.getCars() == null).map(o -> o.getName())
				.collect(Collectors.toList());
		System.out.println(list);

		// 2. create a map of name of person and number of cars he/she owns
		Map<String, Integer> map = owners.stream().collect(Collectors.toMap(owner -> owner.getName(),
				owner -> owner.getCars() == null ? 0 : owner.getCars().size()));
		System.out.println(map);

		// 3. List cars not owned by any one
		List<Car> carsOwned = owners.stream().filter(ow -> ow.getCars() != null)
				.flatMap(owner -> owner.getCars().stream()).collect(Collectors.toList());
		List<Car> carsNotOwned = cars.stream().filter(car -> !carsOwned.contains(car)).collect(Collectors.toList());
		System.out.println(carsNotOwned);

	}

}
