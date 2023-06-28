package com.OnitoTechnologies.Assessment.DTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MoviesWithSubtotalDTO {
    String genre;
    String primaryTitle;
    BigDecimal numVotes;
}
