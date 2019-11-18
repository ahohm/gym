package com.tekup.gym.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Abonnement implements Serializable {


    @Id
    private int id;

    @ManyToOne
    @JoinColumn
    private Abonne abonne;

    @ManyToOne
    @JoinColumn
    private Category category;

    private LocalDate startDate;
    private LocalDate endDate;

    @OneToMany
    private List<Descipline> desciplineList;

}
