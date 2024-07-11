/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package taller;

/**
 *
 * @author nicol
 */
public interface IOperacion {
    double calcularOperacion(double num1, double num2) throws NicolasRecaldeException;
    void mostrarResultado(double resultado);
}