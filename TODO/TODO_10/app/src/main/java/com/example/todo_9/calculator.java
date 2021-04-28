package com.example.todo_9;

public class calculator {
    public enum Operator {ADD, SUB,DIV, MUL}
    public double add(double operandOne, double operandTwo)
    {
        return operandOne + operandTwo;
    }
    public double sub(double operandOne, double operandTwo)
    {
        return operandOne - operandTwo;
    }
    public double mul(double operandOne, double operandTwo)
    {
        return operandOne * operandTwo;
    }
    public double div(double operandOne, double operandTwo)
    {
        return operandOne / operandTwo;
    }
}
