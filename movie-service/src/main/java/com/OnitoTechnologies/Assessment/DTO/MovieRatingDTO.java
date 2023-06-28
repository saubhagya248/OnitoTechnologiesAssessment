package com.OnitoTechnologies.Assessment.DTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MovieRatingDTO {
    String tconst;
    String primaryTitle;
    String genres;
    Double averageRating;

}
