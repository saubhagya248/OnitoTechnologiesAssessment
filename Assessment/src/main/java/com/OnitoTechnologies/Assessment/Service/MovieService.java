package com.OnitoTechnologies.Assessment.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.OnitoTechnologies.Assessment.DTO.MovieResponse;
import com.OnitoTechnologies.Assessment.DTO.MovieRequest;

@Service
public interface MovieService {

    public List<MovieResponse> longestRuntimeMovies();

    public String newMovie(MovieRequest movieRequest);

    public List<MovieResponse> topRatedMovies();

    public 
}
