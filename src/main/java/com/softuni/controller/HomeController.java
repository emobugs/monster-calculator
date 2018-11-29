package com.softuni.controller;

import com.softuni.entity.Calculator;
import com.softuni.entity.CaloriesCalculator;
import com.softuni.entity.PercentCalculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DecimalFormat;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("view", "home");
        return "base-layout";
    }

    //    Calculator
    @GetMapping("/calculator")
    public String calculator(Model model) {
        model.addAttribute("operator", "+");
        model.addAttribute("view", "views/calculatorForm");
        return "base-layout";
    }

    @PostMapping("/calculator")
    public String calculate(@RequestParam("leftOperand") String leftOperand,
                            @RequestParam("operator") String operator,
                            @RequestParam("rightOperand") String rightOperand,
                            Model model) {
        double num1;
        double num2;

        try {
            num1 = Double.parseDouble(leftOperand);
        } catch (NumberFormatException ex) {
            num1 = 0;
        }

        try {
            num2 = Double.parseDouble(rightOperand);
        } catch (NumberFormatException ex) {
            num2 = 0;
        }
        Calculator calculator = new Calculator(num1, num2, operator);
        double result = calculator.calculateResult();
        DecimalFormat df = new DecimalFormat("#.############");
        String resultFinal = df.format(result);

        model.addAttribute("leftOperand", df.format(calculator.getLeftOperand()));
        model.addAttribute("operator", calculator.getOperator());
        model.addAttribute("rightOperand", df.format(calculator.getRightOperand()));
        model.addAttribute("result", resultFinal);

        model.addAttribute("view", "views/calculatorForm");
        return "base-layout";
    }

    //    Percent Calculator
    @GetMapping("/percent")
    public String percentPage(Model model) {
        model.addAttribute("view", "percent");
        return "base-layout";
    }

    @PostMapping("/percent")
    public String calculatePercent(@RequestParam("firstNum") String firstNumber,
                                   @RequestParam("secondNum") String secondNumber,
                                   Model model) {
        model.addAttribute("view", "percent");

        double num1;
        double num2;

        try {
            num1 = Double.parseDouble(firstNumber);
        } catch (NumberFormatException ex) {
            num1 = 0;
        }

        try {
            num2 = Double.parseDouble(secondNumber);
        } catch (NumberFormatException ex) {
            num2 = 0;
        }

        PercentCalculator pcalc = new PercentCalculator();

        double result = pcalc.calculatePercent(num1, num2);
        DecimalFormat df = new DecimalFormat("#.############");

        model.addAttribute("firstNum", df.format(num1));
        model.addAttribute("secondNum", df.format(num2));
        model.addAttribute("result", df.format(result));
        model.addAttribute("view", "percent");
        return "base-layout";
    }

    //    CaloriesCalculator Male
    @GetMapping("/calories")
    public String calories(Model model) {
        model.addAttribute("view", "views/calories");
        model.addAttribute("gender","Male");
        return "base-layout";
    }

    @PostMapping("/calories")
    public String calculateMale(@RequestParam("weight") double weight,
                                @RequestParam("height") double height,
                                @RequestParam("age") double age,
                                @RequestParam("activity") String activity,
                                Model model) {
        CaloriesCalculator calculateMale = new CaloriesCalculator(weight, height, age, activity);
        double sum = calculateMale.getSumMale();
        double result = calculateMale.activityChoose(sum);
        DecimalFormat df = new DecimalFormat("#.###");

        model.addAttribute("weight", df.format(weight));
        model.addAttribute("height", df.format(height));
        model.addAttribute("age", df.format(age));
        model.addAttribute("activity", activity);
        model.addAttribute("result", df.format(result));
        model.addAttribute("gender","Male");

        model.addAttribute("view", "views/calories");
        return "base-layout";

    }

    // Calories Calculator Female
    @GetMapping("/calories/female")
    public String caloriesForMale(Model model) {
        model.addAttribute("view", "views/calories-female");
        model.addAttribute("gender","Female");
        return "base-layout";
    }

    @PostMapping("/calories/female")
    public String calculateFemale(@RequestParam("weight") double weight,
                                  @RequestParam("height") double height,
                                  @RequestParam("age") double age,
                                  @RequestParam("activity") String activity,
                                  Model model) {
        CaloriesCalculator calculateMale = new CaloriesCalculator(weight, height, age, activity);
        double sum = calculateMale.getSumFemale();
        double result = calculateMale.activityChoose(sum);
        DecimalFormat df = new DecimalFormat("#.###");

        model.addAttribute("weight", df.format(weight));
        model.addAttribute("height", df.format(height));
        model.addAttribute("age", df.format(age));
        model.addAttribute("activity", activity);
        model.addAttribute("result", df.format(result));
        model.addAttribute("gender","Female");

        model.addAttribute("view", "views/calories-female");
        return "base-layout";
    }

    @GetMapping("/eror404")
    public String error404(Model model){
        model.addAttribute("view","eror404");
        return "eror404";
    }

}
