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

    public boolean isCheckBoxTrue(boolean rdvReponseDemandee)
    {
        return rdvReponseDemandee;
    }

}
