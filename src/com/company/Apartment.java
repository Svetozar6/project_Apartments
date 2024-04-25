package com.company;

public class Apartment {
    private String grad;
    private int broiStai;
    private int kvadratura;
    private double cena;
    private String telefon;

    public Apartment(String grad, int broiStai, int kvadratura, double cena, String telefon) {
        this.grad = grad;
        this.broiStai = broiStai;
        this.kvadratura = kvadratura;
        this.cena = cena;
        this.telefon = telefon;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public int getBroiStai() {
        return broiStai;
    }

    public void setBroiStai(int broiStai) {
        this.broiStai = broiStai;
    }

    public int getKvadratura() {
        return kvadratura;
    }

    public void setKvadratura(int kvadratura) {
        this.kvadratura = kvadratura;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
}
