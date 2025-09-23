package com.example.projet2javafx.model;

import java.time.LocalDate;

public class Rdv
{
    private int  rdvPersonneCivilite;
    private String   rdvPersonneNom;
    private String   rdvPersonnePrenom;
    private String   rdvPersonNumSs;
    private String  rdvSujet;
    private boolean  rdvReponseDemandee;
    private LocalDate rdvDate;
    private int  rdvHeureDebut;
    private int  rdvMinuteDebut;
    private int  rdvHeureFin;
    private int  rdvMinuteFin;
    private String  rdvCommentaires;

    public Rdv(
            int rdvPersonneCivilite,
            String rdvPersonneNom,
            String rdvPersonnePrenom,
            String rdvPersonNumSs,
            String rdvSujet,
            boolean rdvReponseDemandee,
            LocalDate rdvDate,
            int rdvHeureDebut,
            int rdvMinuteDebut,
            int rdvHeureFin,
            int rdvMinuteFin,
            String rdvCommentaires
    )
    {
        this.rdvPersonneCivilite = rdvPersonneCivilite;
        this.rdvPersonneNom = rdvPersonneNom;
        this.rdvPersonnePrenom = rdvPersonnePrenom;
        this.rdvPersonNumSs = rdvPersonNumSs;
        this.rdvSujet = rdvSujet;
        this.rdvReponseDemandee = rdvReponseDemandee;
        this.rdvDate = rdvDate;
        this.rdvHeureDebut = rdvHeureDebut;
        this.rdvMinuteDebut = rdvMinuteDebut;
        this.rdvHeureFin = rdvHeureFin;
        this.rdvMinuteFin = rdvMinuteFin;
        this.rdvCommentaires = rdvCommentaires;
    }

    @Override
    public String toString()
    {
        return "Rdv{" +
                "Civilité=" + rdvPersonneCivilite +
                ", Nom='" + rdvPersonneNom + '\'' +
                ", Prénom='" + rdvPersonnePrenom + '\'' +
                ", NumSs='" + rdvPersonNumSs + '\'' +
                ", Sujet='" + rdvSujet + '\'' +
                ", ReponseDemandée=" + rdvReponseDemandee +
                ", Date=" + rdvDate +
                ", HeureDebut=" + rdvHeureDebut +
                ", MinuteDebut=" + rdvMinuteDebut +
                ", HeureFin=" + rdvHeureFin +
                ", MinuteFin=" + rdvMinuteFin +
                ", Commentaires='" + rdvCommentaires + '\'' +
                '}';
    }

}
