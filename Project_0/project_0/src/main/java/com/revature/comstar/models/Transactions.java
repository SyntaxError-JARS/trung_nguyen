package com.revature.comstar.models;

public class Transactions {

    private String userName;
    private String datePosted;
    private String amount;

    private int financialsId;

    public Transactions(String userName, String datePosted, String amount, int financialsId) {
        this.userName = userName;
        this.datePosted = datePosted;
        this.amount = amount;
        this.financialsId = financialsId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
                "userName='" + userName + '\'' +
                ", datePosted='" + datePosted + '\'' +
                ", amount='" + amount + '\'' +
                ", financialsId=" + financialsId +
                '}';
    }

}
