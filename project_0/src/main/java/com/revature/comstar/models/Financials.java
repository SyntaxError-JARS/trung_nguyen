package com.revature.comstar.models;

public class Financials {

    private String userName;
    private String checking;
    private String savings;

    public Financials(String userName, String checking, String savings) {
        this.userName = userName;
        this.checking = checking;
        this.savings = savings;
    }

    public Financials() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getChecking() {
        return checking;
    }

    public void setChecking(String checking) {
        this.checking = checking;
    }

    public String getSavings() {
        return savings;
    }

    public void setSavings(String savings) {
        this.savings = savings;
    }

    @Override
    public String toString() {
        return "financials{" +
                "userName='" + userName + '\'' +
                ", checking='" + checking + '\'' +
                ", savings='" + savings + '\'' +
                '}';
    }
}



