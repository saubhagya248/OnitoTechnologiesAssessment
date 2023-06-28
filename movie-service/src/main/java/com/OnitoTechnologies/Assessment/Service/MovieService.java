package com.OnitoTechnologies.Assessment.Service;

import java.util.List;

import com.OnitoTechnologies.Assessment.DTO.MovieRatingDTO;
import com.OnitoTechnologies.Assessment.DTO.MoviesWithSubtotalDTO;

import com.OnitoTechnologies.Assessment.DTO.MovieResponse;
import com.OnitoTechnologies.Assessment.DTO.MovieRequest;


public interface MovieService {

    public List<MovieResponse> getLongestRuntimeMovies();

    public String addNewMovie(MovieRequest movieRequest);

    public List<MovieRatingDTO> getTopRatedMovies();

    public List<MoviesWithSubtotalDTO> getMoviesWithSubtotals();

    public String updateRuntime();

}
