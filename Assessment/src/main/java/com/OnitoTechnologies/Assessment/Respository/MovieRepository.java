package com.OnitoTechnologies.Assessment.Respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OnitoTechnologies.Assessment.Model.Movie;

public interface MovieRepository extends JpaRepository<Movie, String> {
    
}
