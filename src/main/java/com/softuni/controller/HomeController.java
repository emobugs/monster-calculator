package com.softuni.controller;

import com.softuni.entity.Calculator;
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
                                   Model model){
        model.addAttribute("view","percent");

        double num1;
        double num2;

        try {
            num1 = Double.parseDouble(firstNumber);
        } catch (NumberFormatException ex){
            num1 = 0;
        }

        try {
            num2 = Double.parseDouble(secondNumber);
        } catch (NumberFormatException ex){
            num2 = 0;
        }

        PercentCalculator pcalc = new PercentCalculator();

       double result =  pcalc.calculatePercent(num1,num2);
        DecimalFormat df = new DecimalFormat("#.############");

        model.addAttribute("firstNum",df.format(num1));
        model.addAttribute("secondNum",df.format(num2));
        model.addAttribute("result",df.format(result));
        model.addAttribute("view","percent");
        return "base-layout";
    }


}
