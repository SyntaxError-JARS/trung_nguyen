package com.revature.comstar.models;

public class Transactions {

    private String datePosted;
    private String amount;

    private int financialsId;

    public Transactions(String datePosted, String amount, int financialsId) {
        this.datePosted = datePosted;
        this.amount = amount;
        this.financialsId = financialsId;
    }

    public Transactions() {

    }


    public String getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(String datePosted) {
        this.datePosted = datePosted;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public int getFinancialsId() {
        return financialsId;
    }

    public void setFinancialsId(int financialsId) {
        this.financialsId = financialsId;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                ", datePosted='" + datePosted + '\'' +
                ", amount='" + amount + '\'' +
                ", financialsId=" + financialsId +
                '}';
    }

}
