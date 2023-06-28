package com.OnitoTechnologies.Assessment.DTO;

import com.OnitoTechnologies.Assessment.Enums.Genre;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MovieResponse {

    String tconst;

    String primaryTitle;

    Integer runtime;
    
    Genre genre;
}
