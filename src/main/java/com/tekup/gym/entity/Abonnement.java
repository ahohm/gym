package com.tekup.gym.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Abonnement {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn
    private Abonne abonne;

    @ManyToOne
    @JoinColumn
    private Category category;

    private LocalDate startDate;
    private LocalDate endDate;

    public Abonnement(Abonne abonne, Category category, LocalDate startDate, LocalDate endDate) {
        this.abonne = abonne;
        this.category = category;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    //    @OneToMany
//    private List<Descipline> desciplineList;

}
