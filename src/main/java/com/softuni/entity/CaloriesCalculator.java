package com.softuni.entity;

public class CaloriesCalculator {
    private double weight;
    private double height;
    private double age;
    private String activity;

    public CaloriesCalculator() {
    }

    public CaloriesCalculator(double weight, double height, double age, String activity) {
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.activity = activity;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public double getAge() {
        return age;
    }

    public String getActivity() {
        return activity;
    }
//    Формула за изчисляване на калорийния минимум при жени:
// 655 + (9.6 X тегло в кг) + (1.8 X височина в см) - (4.7 X възраст в години)

    public double getSumFemale() {
        return 655 + (9.6 * this.weight) + (1.8 * this.height) - (4.7 * this.age);
    }

    //     Формула за изчисляване на калорийния минимум при мъже:
//    66 + (13.7 X тегло в кг) + (5 X височина в см) - (6.8 X възраст в години)
    public double getSumMale() {
        return 66 + (13.7 * this.weight) + (5 * this.height) - (6.8 * this.age);
    }

    public double activityChoose(double sum) {
        double result = 0;
        switch (this.activity) {
            case "1":
                return sum * 1.2;
            case "2":
                return sum * 1.375;
            case "3":
                return sum * 1.55;
            case "4":
                return sum * 1.725;
            case "5":
                return sum * 1.9;
                default:
                    return 0;
        }
    }
}
