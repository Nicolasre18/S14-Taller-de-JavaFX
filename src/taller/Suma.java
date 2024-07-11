package taller;

public class Suma implements IOperacion {
    //Clase para la operación de suma que implementa la interfaz IOperacion
    @Override
    public double calcularOperacion(double num1, double num2) {
        return num1 + num2;
    }
    
    @Override
    public void mostrarResultado(double resultado) {
        System.out.println("El resultado de la suma es: " + resultado); //Muestra el resultado en la consola
    }
}