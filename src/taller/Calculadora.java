package taller;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Calculadora {
    private TextField num1;  //Campo de texto para el primer número
    private TextField num2;  //Campo de texto para el segundo número
    private Label resultado; //Etiqueta para mostrar el resultado
    
    //El constructor de la clase Calculadora
    public Calculadora(TextField num1Field, TextField num2Field, Label resultadoLabel) {
        this.num1 = num1Field;
        this.num2 = num2Field;
        this.resultado = resultadoLabel;
    }

    //El método para calcular la operación que seleccionamos 
    public void calcular(String operacion) {
        try {
            //Obtenemos los numeros como doubles para no tener problemas a la hora de realizar ciertas operaciones 
            double num1 = Double.parseDouble(this.num1.getText());  // Obtener el primer número desde el campo de texto
            double num2 = Double.parseDouble(this.num2.getText());  // Obtener el segundo número desde el campo de texto
            IOperacion operacionObj;

            //Utilizamos un switch para seleccionar la operación basada en lo que se elija en el ComboBox
            switch (operacion) {
                case "Suma":
                    operacionObj = new Suma();
                    break;
                case "Resta":
                    operacionObj = new Resta();
                    break;
                case "Multiplicación":
                    operacionObj = new Multiplicacion();
                    break;
                case "División":
                    operacionObj = new Division();
                    break;
                default:
                    resultado.setText("Operación no válida.");
                    return;
            }

            //Calculamos el resultado y lo mostramos
            double resultado = operacionObj.calcularOperacion(num1, num2);
            operacionObj.mostrarResultado(resultado);
            this.resultado.setText(String.valueOf(resultado));

        } catch (NumberFormatException e) {
            resultado.setText("Por favor, ingrese números válidos.");  //Un catch por si acaso si los campos de texto no contienen números válidos
        } catch (NicolasRecaldeException e) {
            resultado.setText(e.getMessage());  //Aqui utilizamos la excepcion especifica que nos pedia el ejercicio, aunque podiamos
            //utilizar ArithmeticException pero bueno 
        }
    }
}