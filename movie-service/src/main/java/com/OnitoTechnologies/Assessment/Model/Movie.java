package com.OnitoTechnologies.Assessment.Model;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;
import com.OnitoTechnologies.Assessment.Enums.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "movies")
@Builder
public class Movie{

    @Id
    @Column(name = "tconst")
    String tconst;

    @Column(name="titleType")
    @Enumerated(EnumType.STRING)
    Type type;

    @Column(name="primaryTitle")
    String title;

    @Column(name="runtimeMinutes")
    Integer runtime;

    @Column(name="genres")
    @Enumerated(EnumType.STRING)
    Genre genre;
}