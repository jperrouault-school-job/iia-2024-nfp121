package fr.formation;

import java.time.LocalDate;

public class Personne {
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private String email;
    private String username;
    private String password;

    public Personne(String nom, String prenom, LocalDate dateNaissance, String email, String username, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public Personne() { }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void parler() {
        System.out.println("La personne parle ...");
    }

    @Override
    public String toString() {
        String stringMere = super.toString(); // Rappeler le toString de la première classe mère qui a cette méthode
        return stringMere + " - Babar";
    }





    // Builder V1
    public static class PersonneBuilderV1 {
        private String nom;
        private String prenom;
        private LocalDate dateNaissance;
        private String email;
        private String username;
        private String password;

        public PersonneBuilderV1 withNom(String nom) {
            this.nom = nom;
            return this;
        }

        public PersonneBuilderV1 withPrenom(String prenom) {
            this.prenom = prenom;
            return this;
        }

        public PersonneBuilderV1 withDateNaissance(LocalDate dateNaissance) {
            this.dateNaissance = dateNaissance;
            return this;
        }

        public PersonneBuilderV1 withEmail(String email) {
            this.email = email;
            return this;
        }

        public PersonneBuilderV1 withUsername(String username) {
            this.username = username;
            return this;
        }

        public PersonneBuilderV1 withPassword(String password) {
            this.password = password;
            return this;
        }

        public Personne build() {
            return new Personne(this.nom, this.prenom, this.dateNaissance, this.email, this.username, this.password);
        }

        public PersonneBuilderV1 reset() {
            this.nom = null;
            this.prenom = null;
            this.dateNaissance = null;
            this.email = null;
            this.username = null;
            this.password = null;

            return this;
        }
    }

    // Builder V2
    public static class PersonneBuilderV2 {
        private Personne personne;

        public PersonneBuilderV2() {
            this.personne = new Personne();
        }

        public PersonneBuilderV2 withNom(String nom) {
            this.personne.nom = nom;
            return this;
        }

        public PersonneBuilderV2 withPrenom(String prenom) {
            this.personne.prenom = prenom;
            return this;
        }

        public PersonneBuilderV2 withDateNaissance(LocalDate dateNaissance) {
            this.personne.dateNaissance = dateNaissance;
            return this;
        }

        public PersonneBuilderV2 withEmail(String email) {
            this.personne.email = email;
            return this;
        }

        public PersonneBuilderV2 withUsername(String username) {
            this.personne.username = username;
            return this;
        }

        public PersonneBuilderV2 withPassword(String password) {
            this.personne.password = password;
            return this;
        }

        public Personne build() {
            return this.personne;
        }

        public PersonneBuilderV2 reset() {
            this.personne = new Personne();

            return this;
        }
    }
}
