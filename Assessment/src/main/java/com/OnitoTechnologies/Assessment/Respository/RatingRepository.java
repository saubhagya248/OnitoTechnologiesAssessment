package com.OnitoTechnologies.Assessment.Respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OnitoTechnologies.Assessment.Model.Rating;

public interface RatingRepository extends JpaRepository<Rating, String> {
    
}
