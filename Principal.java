import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import controller.Controller;

/* ***************************************************************
*  Autor: Ricardo Rodrigues Neto
*  Matricula: 201710560
*  Inicio: 07/08/2018
*  Ultima alteracao: 10/07/2018 
*  Nome: Conversor para programadores
*  Funcao: Converte valores entre as unidades: binaria, octal,
*    decimal e hexadecimal
*************************************************************** */

public class Principal extends Application{
	
  /* ***************************************************************
  * Metodo: start
  * Funcao: Metodo que starta o programa
  * Parametros: Primeiro Stage
  * Retorno: Nao possui retorno
  *************************************************************** */
  @Override
  public void start(Stage palco) throws Exception{
    Parent root = FXMLLoader.load(getClass().getResource("/view/Tela.fxml"));
    Scene cena = new Scene(root);
    palco.setScene(cena);
    palco.show();
  }
  
  public static void main(String[] args){
    launch(args);
  }
}
