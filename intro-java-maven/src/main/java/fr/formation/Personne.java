package fr.formation;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@Builder
@NoArgsConstructor @AllArgsConstructor
public class Personne {
    private String nom;
    private String prenom;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateNaissance;
}
