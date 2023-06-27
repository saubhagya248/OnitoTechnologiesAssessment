package com.OnitoTechnologies.Assessment.DTO;

import com.OnitoTechnologies.Assessment.Enums.Genre;
import com.OnitoTechnologies.Assessment.Enums.Type;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class MovieRequest {
    
    String tconst;

    @Enumerated(EnumType.STRING)
    Type type;

    String title;

    Integer runtime;

    @Enumerated(EnumType.STRING)
    Genre genre;
}
