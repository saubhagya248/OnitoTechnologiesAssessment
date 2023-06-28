package com.OnitoTechnologies.Assessment.Respository;

import com.OnitoTechnologies.Assessment.DTO.MovieRatingDTO;
import com.OnitoTechnologies.Assessment.DTO.MovieResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.OnitoTechnologies.Assessment.Model.Movie;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, String> {



    @Query(value = "SELECT * FROM onito.movies ORDER BY runtime_minutes DESC limit 10;", nativeQuery = true)
    public List<Movie> longestDurationMovies();

    @Query(value = "SELECT m.tconst, m.primary_title, m.genres, r.average_rating " +
            "FROM onito.movies as m " +
            "join onito.ratings as r " +
            "on r.tconst = m.tconst " +
            "where r.average_rating > 6.0 order by r.average_rating asc;", nativeQuery = true)
    public List<Object[]> topRatedMovies();

    @Query(value = "select movie.genres, IF(movie.primary_title is NULL, 'TOTAL', movie.primary_title) as primary_title, " +
            "sum(rating.num_votes) as numVotes from onito.movies as movie " +
            "join onito.ratings as rating on rating.tconst = movie.tconst " +
            "group by movie.genres, movie.primary_title  with rollup " +
            "order by movie.genres, movie.primary_title desc;", nativeQuery = true)
    public List<Object[]> movieWithSubtotals();


    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE onito.movies" +
            "SET runtime_minutes = CASE" +
            "    WHEN genres = 'DOCUMENTARY' THEN runtime_minutes + 15" +
            "    WHEN genres = 'ANIMATION' THEN runtime_minutes + 30" +
            "    ELSE runtime_minutes + 45 END;", nativeQuery = true)
    public int updateRuntime() throws RuntimeException;
}
