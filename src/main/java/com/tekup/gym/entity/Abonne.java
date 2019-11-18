package com.tekup.gym.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Abonne {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String firsNname;
    private String lastName;

    private String cin;
    private String photo;
    private String certifMed;

    @OneToMany(mappedBy = "abonne", cascade = CascadeType.ALL)
    private List<Abonnement> subscriptionList;


}
