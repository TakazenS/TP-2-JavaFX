package com.example.projet2javafx.model;

import java.time.LocalDate;

public class Rdv
{
    final int rdvCivilite;
    final String rdvNom;
    final String rdvPrenom;
    final String rdvNumSs;
    final String rdvSujet;
    final boolean rdvReponseDemandee;
    final LocalDate rdvDate;
    final int rdvHeureDebut;
    final int rdvMinuteDebut;
    final int rdvHeureFin;
    final int rdvMinuteFin;
    final String rdvCommentaires;

    public Rdv(
            int rdvCivilite,
            String rdvNom,
            String rdvPrenom,
            String rdvNumSs,
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
        this.rdvCivilite = rdvCivilite;
        this.rdvNom = rdvNom;
        this.rdvPrenom = rdvPrenom;
        this.rdvNumSs = rdvNumSs;
        this.rdvSujet = rdvSujet;
        this.rdvReponseDemandee = rdvReponseDemandee;
        this.rdvDate = rdvDate;
        this.rdvHeureDebut = rdvHeureDebut;
        this.rdvMinuteDebut = rdvMinuteDebut;
        this.rdvHeureFin = rdvHeureFin;
        this.rdvMinuteFin = rdvMinuteFin;
        this.rdvCommentaires = rdvCommentaires;
    }

    public int getRdvCivilite()
    {
        return rdvCivilite;
    }

    public String getRdvNom()
    {
        return rdvNom;
    }

    public String getRdvPrenom()
    {
        return rdvPrenom;
    }

    public String getRdvNumSs()
    {
        return rdvNumSs;
    }

    public String getRdvSujet()
    {
        return rdvSujet;
    }

    public boolean isRdvReponseDemandee()
    {
        return rdvReponseDemandee;
    }

    public LocalDate getRdvDate()
    {
        return rdvDate;
    }

    public int getRdvHeureDebut()
    {
        return rdvHeureDebut;
    }

    public int getRdvMinuteDebut()
    {
        return rdvMinuteDebut;
    }

    public int getRdvHeureFin()
    {
        return rdvHeureFin;
    }

    public int getRdvMinuteFin()
    {
        return rdvMinuteFin;
    }

    public String getRdvCommentaires()
    {
        return rdvCommentaires;
    }

    @Override
    public String toString()
    {
        return "Rdv{" +
                "rdvCivilite=" + rdvCivilite +
                ", rdvNom='" + rdvNom + '\'' +
                ", rdvPrenom='" + rdvPrenom + '\'' +
                ", rdvNumSs='" + rdvNumSs + '\'' +
                ", rdvSujet='" + rdvSujet + '\'' +
                ", rdvReponseDemandee=" + rdvReponseDemandee +
                "\n" +
                ", rdvDate=" + rdvDate +
                ", rdvHeureDebut=" + rdvHeureDebut +
                ", rdvMinuteDebut=" + rdvMinuteDebut +
                ", rdvHeureFin=" + rdvHeureFin +
                ", rdvMinuteFin=" + rdvMinuteFin +
                ", rdvCommentaires='" + rdvCommentaires + '\'' +
                '}';
    }

}
