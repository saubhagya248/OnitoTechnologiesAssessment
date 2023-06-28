package com.OnitoTechnologies.Assessment.Service.Impl;

import com.OnitoTechnologies.Assessment.DTO.MovieRatingDTO;
import com.OnitoTechnologies.Assessment.DTO.MovieRequest;
import com.OnitoTechnologies.Assessment.DTO.MovieResponse;
import com.OnitoTechnologies.Assessment.DTO.MoviesWithSubtotalDTO;
import com.OnitoTechnologies.Assessment.Exception.*;
import com.OnitoTechnologies.Assessment.Model.Movie;
import com.OnitoTechnologies.Assessment.Respository.MovieRepository;
import com.OnitoTechnologies.Assessment.Service.MovieService;
import com.OnitoTechnologies.Assessment.Transformer.MovieTransformer;
import com.OnitoTechnologies.Assessment.Util.Converter;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;



    @Override
    public List<MovieResponse> getLongestRuntimeMovies() throws NoDataFoundException{
        List<Movie> movieList = movieRepository.longestDurationMovies();

        //throw exception if no entries are there in the DB
        if(movieList.size()==0) throw new NoDataFoundException("No records to show");

        return Converter.movieListToMovieResponseList(movieList);
    }

    @Override
    public String addNewMovie(MovieRequest movieRequest) throws MovieAlreadyExistsException{
        Optional<Movie> movie = movieRepository.findById(movieRequest.getTconst());

        //throw exception if movie with same tconst already exists
        if(movie.isPresent()) throw new MovieAlreadyExistsException("Movie with same tconst already exists");

        movieRepository.save(MovieTransformer.movieRequestToMovie(movieRequest));
        return "success";
    }

    @Override
    public List<MovieRatingDTO> getTopRatedMovies() throws NoDataFoundException {
        List<Object[]> responseList = movieRepository.topRatedMovies();

        if(responseList.isEmpty()) throw new NoDataFoundException("No records to show");

        return Converter.resultSetToMovieRatingDto(responseList);
    }

    @Override
    public List<MoviesWithSubtotalDTO> getMoviesWithSubtotals() throws NoDataFoundException{
        List<Object[]> responseList = movieRepository.movieWithSubtotals();

        if(responseList.isEmpty()) throw new NoDataFoundException("No records to show");

        return Converter.resultSetToMovieWithSubtotalsDto(responseList);
    }

    @Override
    public String updateRuntime() throws RuntimeException{
        try{
            movieRepository.updateRuntime();
            return "Success";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
