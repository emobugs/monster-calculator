package com.softuni.entity;

public class PercentCalculator {
private double firstNum;
private double secondNum;

    public PercentCalculator() {
    }

    public PercentCalculator(double firstNum, double secondNum) {
        this.firstNum = firstNum;
        this.secondNum = secondNum;
    }

    public double getFirstNum() {
        return firstNum;
    }

    public void setFirstNum(double firstNum) {
        this.firstNum = firstNum;
    }

    public double getSecondNum() {
        return secondNum;
    }

    public void setSecondNum(double secondNum) {
        this.secondNum = secondNum;
    }

    public double calculatePercent(double n1, double n2){
        return (n1 / 100)*n2;
    }
}
