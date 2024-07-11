package taller;

public class Division implements IOperacion {
    //Clase para la operación de división que implementa la interfaz IOperacion
    @Override
    public double calcularOperacion(double num1, double num2) throws NicolasRecaldeException {
        if (num2 == 0) {
            throw new NicolasRecaldeException("El denominador no puede ser cero."); //Utilizamos throws para 
            //lanzar la excepcion que hicimos si el denominador es cero
        }
        return num1 / num2;
    }

    @Override
    public void mostrarResultado(double resultado) {
        System.out.println("El resultado de la división es: " + resultado);//Muestra el resultado en la consola
    }
}
