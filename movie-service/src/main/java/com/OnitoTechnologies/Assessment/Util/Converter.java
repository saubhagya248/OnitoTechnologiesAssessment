package com.OnitoTechnologies.Assessment.Util;

import com.OnitoTechnologies.Assessment.DTO.MovieRatingDTO;
import com.OnitoTechnologies.Assessment.DTO.MovieResponse;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.OnitoTechnologies.Assessment.DTO.MoviesWithSubtotalDTO;
import com.OnitoTechnologies.Assessment.Model.*;
import com.OnitoTechnologies.Assessment.Transformer.MovieTransformer;

public class Converter {
    public static List<MovieResponse> movieListToMovieResponseList(List<Movie> movieList){
        //converting movie list to movie response list
        List<MovieResponse> responseList = new ArrayList<>();
        movieList.forEach((movie) ->
                responseList.add(MovieTransformer.movieToMovieResponse(movie))
        );
        return responseList;
    }

    public static List<MovieRatingDTO> resultSetToMovieRatingDto(List<Object[]> resultSet){
        List<MovieRatingDTO> responseList = new ArrayList<>();

        for(Object[] row: resultSet){
            responseList.add(
                    MovieRatingDTO.builder()
                            .tconst((String) row[0])
                            .primaryTitle((String) row[1])
                            .genres((String) row[2])
                            .averageRating((Double) row[3])
                            .build()
            );
        }

        return responseList;
    }
    public static List<MoviesWithSubtotalDTO> resultSetToMovieWithSubtotalsDto(List<Object[]> resultSet){
        List<MoviesWithSubtotalDTO> responseList = new ArrayList<>();

        for(Object[] row: resultSet){
            responseList.add(
                    MoviesWithSubtotalDTO.builder()
                            .genre((String) row[0])
                            .primaryTitle((String) row[1])
                            .numVotes((BigDecimal) row[2])
                            .build()
            );
        }

        return responseList;
    }
}
