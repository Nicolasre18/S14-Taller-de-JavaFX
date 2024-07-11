package taller;

public class Multiplicacion implements IOperacion {
    //Clase para la operación de multiplicacion que implementa la interfaz IOperacion
    @Override
    public double calcularOperacion(double num1, double num2) {
        return num1 * num2;
    }

    @Override
    public void mostrarResultado(double resultado) {
        System.out.println("El resultado de la multiplicación es: " + resultado);//Muestra el resultado en la consola
    }
}