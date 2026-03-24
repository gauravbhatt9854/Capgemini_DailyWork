package com.gal.repo;

import com.gal.model.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // converts sql exception to runTimeException
public interface TrainingRepo extends JpaRepository<Training , Long> {
}
