package com.OnitoTechnologies.Assessment.Controller;

import com.OnitoTechnologies.Assessment.DTO.MovieRatingDTO;
import com.OnitoTechnologies.Assessment.DTO.MovieRequest;
import com.OnitoTechnologies.Assessment.DTO.MovieResponse;
import com.OnitoTechnologies.Assessment.DTO.MoviesWithSubtotalDTO;
import com.OnitoTechnologies.Assessment.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.OnitoTechnologies.Assessment.Exception.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/new-movie")
    public ResponseEntity addMovie(@RequestBody MovieRequest movieRequest){
        try{
            String response = movieService.addNewMovie(movieRequest);
            return new ResponseEntity(response, HttpStatus.CREATED);
        } catch (MovieAlreadyExistsException e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/update-runtime-minutes")
    public ResponseEntity updateRuntime(){
        try{
            String response = movieService.updateRuntime();
            return new ResponseEntity(response,HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/longest-duration-movies")
    public ResponseEntity longestDurationMovies(){
        try{
            List<MovieResponse> responseList = movieService.getLongestRuntimeMovies();
            return new ResponseEntity(responseList, HttpStatus.OK);
        } catch (NoDataFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/top-rated-movies")
    public ResponseEntity topRatedMovies(){
        try{
            List<MovieRatingDTO> responseList = movieService.getTopRatedMovies();
            return new ResponseEntity(responseList,HttpStatus.OK);
        } catch (NoDataFoundException e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/genre-movies-with-subtotals")
    public ResponseEntity movieWithSubtotals(){
        try{
            List<MoviesWithSubtotalDTO> response = movieService.getMoviesWithSubtotals();
            return new ResponseEntity(response,HttpStatus.OK);
        } catch (NoDataFoundException e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }


    
}
