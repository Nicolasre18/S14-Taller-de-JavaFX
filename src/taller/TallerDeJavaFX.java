/*
Nombre: Nicolas Recalde
Taller: S14 - Taller de JavaFX, polimorfismo, excepciones e interfaces
Comentario: es complicado hacer en NeatBeans, toca cargar todas las librerias de fx tu mismo,
pero yo creo que esta un buen trabajo, espero que le agrade profe.
*/

package taller;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * @author nicol
 */
public class TallerDeJavaFX extends Application {
    private TextField Layout1;  //Campo de texto para el primer número
    private TextField Layout2;  //Campo de texto para el segundo número
    private Label Layout4; //Etiqueta para mostrar el resultado
    private ImageView imageView;  // Vista de la imagen
    private Label descripcionLabel;

    public static void main(String[] args) {
        launch(args); 
    }
    
    //Sobrescribimos el metodo start de Aplication 
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Calculadora");

        //Como la actividad especificaba que minimo dos layouts yo le quise hacer 5 para que se viera mejor la interfaz grafica 
        
        //Aqui esta el layout 1: en este hago que se ingrese el primer numero 
        Layout1 = new TextField();  // Inicialización del campo de texto para el primer número
        HBox num1Layout = new HBox(10);  // Crear un HBox para organizar los nodos de manera horizontal con un espacio de 10 pixeles
        num1Layout.getChildren().addAll(new Label("Número 1:"), Layout1);  //Añadimos una etiqueta y el campo de texto al HBox 
        //Con el metodo getChildren() obtenemos una lista de los nodos del Hbox 
        num1Layout.setPadding(new Insets(10));  // Añadimos un padding de 10 pixeles para que se vea mejor la intefaz y no muy pegado

        //Aqui esta el layout 2: en este hago que se ingrese el segundo numero, utilizamos los mismos principios que en el layout 1 
        Layout2 = new TextField();  
        HBox num2Layout = new HBox(10);  
        num2Layout.getChildren().addAll(new Label("Número 2:"), Layout2);  
        num2Layout.setPadding(new Insets(10));  

        /*Aqui esta el layout 3: En este layout se encuentra la selección de la operación que queremos realizar, 
        pienso que esta es una forma eficiente de usar el espacio y ademas se ve bien 
        */
        ComboBox<String> Layout3 = new ComboBox<>();  //Creamos un ComboBox para poder seleccionar la operación
        Layout3.getItems().addAll("Suma", "Resta", "Multiplicación", "División");  // Añadimos las opciones del ComboBox
        Button calcular = new Button("Calcular");  //Creamos un botón para calcular la operación una vez esta se escoja
        HBox operacionLayout = new HBox(10);  //Crear un HBox para organizar los nodos de manera horizontal 
        operacionLayout.getChildren().addAll(new Label("Operación:"), Layout3, calcular);  // Añadimos una etiqueta 
        operacionLayout.setPadding(new Insets(10));  //Añadir un padding de 10 píxeles alrededor del HBox

        //Layout 4: En este layout se muestr el resultado de la operacion que se escogio 
        Layout4 = new Label();  //Inicialización de la etiqueta para mostrar el resultado
        VBox resultadoLayout = new VBox(10);  //Crear un VBox para organizar los nodos verticalmente con un espacio de 10 pixeles
        resultadoLayout.getChildren().addAll(new Label("Resultado:"), Layout4);  // Añadir una etiqueta y el resultado al VBox
        resultadoLayout.setPadding(new Insets(10));  //Al igual que el layout 1 añadimos un padding de 10 pixeles para que se vea mejor la intefaz y no muy pegado

        // Layout 5: Aqui se va a ver la Imagen y descripción
        imageView = new ImageView();  //Creamos un ImageView 
        imageView.setFitWidth(200);  //Establecemo el ancho de la imagen
        imageView.setFitHeight(200); //Establecemos la altura de la imagen 
        imageView.setPreserveRatio(true);  //Mantenemos la proporción de la imagen
        descripcionLabel = new Label();  //Creamos una etiqueta vacía para la descripción
        VBox imagenLayout = new VBox(10);  //Creamos un VBox para organizar la imagen y el texto
        imagenLayout.getChildren().addAll(imageView, descripcionLabel);  //Añadimos la imagen y la etiqueta al VBox
        imagenLayout.setPadding(new Insets(5));  //Añadimos un padding de 5 píxeles 
        
        //Botón para mostrar la imagen
        Button mostrarImagenButton = new Button("Mostrar Imagen");  // Crear un botón para mostrar la imagen
        mostrarImagenButton.setOnAction(event -> {
            Image image = loadImage();  //Cargar la imagen
            imageView.setImage(image);  //Establecer la imagen en el ImageView
            descripcionLabel.setText("Messi me representa porque es un poco autista pero es feliz"); 
        });
        
        //Creamos el contenedor principal
        VBox LayoutPrincipal = new VBox(20);  //Creamos un VBox para poder organizar los layouts que creamos de manera vertical 
        LayoutPrincipal.getChildren().addAll(num1Layout, num2Layout, operacionLayout, resultadoLayout, mostrarImagenButton, imagenLayout);  // Añadimos todos los layouts al VBox principal

        //La configuracion del boton calcular
        Calculadora calculadora = new Calculadora(Layout1, Layout2, Layout4);
        calcular.setOnAction(event -> calculadora.calcular(Layout3.getValue()));//Le damos una acción al botón para calcular la operación seleccionada

        Scene scene = new Scene(LayoutPrincipal, 340, 540);//Creamos la escena principal y le damos su formato 
        primaryStage.setScene(scene);//Establecer la escena en el escenario principal
        primaryStage.show();//Mostramos el esceneario 
    }
    
    //Tuve que buscar en youtube porque ni chatgpt podia hacer esto, pero a la final sirvio, no se si es lo que ud esperaba profe
    //pero es trabajo honesto 
    private Image loadImage() {
        return new Image(getClass().getResource("/Imagen/messirve.jpg").toExternalForm());
    }
}
