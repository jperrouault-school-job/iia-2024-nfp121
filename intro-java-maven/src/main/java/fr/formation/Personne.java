package fr.formation;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class Personne {
    private String nom;
    private String prenom;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateNaissance;
}
