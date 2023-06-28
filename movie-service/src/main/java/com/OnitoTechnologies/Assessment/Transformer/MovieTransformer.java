package com.OnitoTechnologies.Assessment.Transformer;

import com.OnitoTechnologies.Assessment.DTO.MovieRequest;
import com.OnitoTechnologies.Assessment.DTO.MovieResponse;
import com.OnitoTechnologies.Assessment.Model.Movie;

public class MovieTransformer {
    public static Movie movieRequestToMovie(MovieRequest movieRequest){
        return Movie.builder()
                .genre(movieRequest.getGenre())
                .title(movieRequest.getTitle())
                .type(movieRequest.getType())
                .runtime(movieRequest.getRuntime())
                .tconst(movieRequest.getTconst())
                .build();
    }

    public static MovieResponse movieToMovieResponse(Movie movie){
        return MovieResponse.builder()
                .runtime(movie.getRuntime())
                .genre(movie.getGenre())
                .primaryTitle(movie.getTitle())
                .tconst(movie.getTconst())
                .build();
    }
}
