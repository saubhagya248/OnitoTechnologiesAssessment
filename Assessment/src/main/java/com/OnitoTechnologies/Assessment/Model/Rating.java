package com.OnitoTechnologies.Assessment.Model;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "ratings")
public class Rating{

    @Id
    @ManyToOne
    @JoinColumn(name="tconst")
    String id;

    @Column(name = "averageRating")
    Double avgRating;

    @Column(name = "numVotes")
    Long votes;

}