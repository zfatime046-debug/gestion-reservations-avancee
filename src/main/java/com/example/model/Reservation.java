package com.example.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "La date de début est obligatoire")
    @Column(name = "date_debut", nullable = false)
    private LocalDateTime dateDebut;

    @NotNull(message = "La date de fin est obligatoire")
    @Column(name = "date_fin", nullable = false)
    private LocalDateTime dateFin;

    @Size(max = 500, message = "Le motif ne peut pas dépasser 500 caractères")
    @Column(length = 500)
    private String motif;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private Utilisateur utilisateur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "salle_id", nullable = false)
    private Salle salle;
    public Reservation() {
    }

    public Reservation(Long id, LocalDateTime dateDebut, LocalDateTime dateFin, String motif, Utilisateur utilisateur, Salle salle) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.motif = motif;
        this.utilisateur = utilisateur;
        this.salle = salle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull(message = "La date de début est obligatoire") LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(@NotNull(message = "La date de début est obligatoire") LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public @NotNull(message = "La date de fin est obligatoire") LocalDateTime getDateFin() {
        return dateFin;
    }

    public void setDateFin(@NotNull(message = "La date de fin est obligatoire") LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }

    public @Size(max = 500, message = "Le motif ne peut pas dépasser 500 caractères") String getMotif() {
        return motif;
    }

    public void setMotif(@Size(max = 500, message = "Le motif ne peut pas dépasser 500 caractères") String motif) {
        this.motif = motif;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }
    public Reservation(LocalDateTime debut, LocalDateTime fin, String statut) {
        this.dateDebut = debut;
        this.dateFin= fin;
        this.motif = getMotif();
    }

}