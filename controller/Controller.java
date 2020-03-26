package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;


public class Controller implements Initializable {

	
  @FXML
  private ChoiceBox<String> medidas1 = new ChoiceBox<>();  //Escolhedor de medidas, para escolher a medida que será convertida

  @FXML
  private ChoiceBox<String> medidas2 = new ChoiceBox<>();  //Escolhedor de medidas, para escolher a medida para qual será convertido o valor

  @FXML
  private TextField campo1, campo2;  //Campos de texto digita o valor a ser convertido e o resultado da conversão

  private ObservableList<String> observableTipo;  //List observadora para mandar para o escolher os itens para serem vistos

  /* ***************************************************************
  *  Metodo: limpar
  *  Funcao: Limpa os campos de texto quando muda a unidade de
  *    conversao
  *  Parametros: *sem parametros*
  *  Retorno: *sem retorno*
  *************************************************************** */
	@FXML
	public void limpar(){
	  campo1.clear();
	  campo2.clear();
  }

  /* ***************************************************************
  *  Metodo: campoCorreto
  *  Funcao: Verifica se os caracteres digitados estao corretos
  *  Parametros: KeyEvent event, evento de teclado no campo1
  *  Retorno: *sem retorno*
  *************************************************************** */
  @FXML
    public void campoCorreto(KeyEvent event) {
        int cont = 0;
        //Converte se apertar 'Enter'
        if(event.getCode().equals(KeyCode.ENTER)){
        	conversoes();
        	return;
        }
        String texto = campo1.getText();
        for(int i = 0; i < campo1.getText().length(); i++){
          int caractere = texto.charAt(i);
          if((caractere >= 32 && caractere <= 47) ||
              (caractere >= 58 && caractere <= 64) ||
              (caractere >= 91 && caractere <= 96) ||
              (caractere >= 123 && caractere <= 126) ||
              (caractere >= 128)){
            campo1.deleteText(i, i+1);
          }
        }
        

        String tipo = medidas1.getSelectionModel().getSelectedItem();
        switch(tipo){
        	case "Binario":
        		if(event.getText().equals("2")
        		||event.getText().equals("3")
        		||event.getText().equals("4")
        		||event.getText().equals("5")
        		||event.getText().equals("6")
        		||event.getText().equals("7")
        		||event.getText().equals("8")
        		||event.getText().equals("9")
        		||event.getText().equals("A")
                ||event.getText().equals("a")
                ||event.getText().equals("B")
                ||event.getText().equals("b")
                ||event.getText().equals("C")
                ||event.getText().equals("c")
                ||event.getText().equals("D")
                ||event.getText().equals("d")
                ||event.getText().equals("E")
                ||event.getText().equals("e")
                ||event.getText().equals("F")
                ||event.getText().equals("f")){
        			campo1.deletePreviousChar();
        		}
        		break;
        	case "Octadecimal":
        		if(event.getText().equals("8")
        		||event.getText().equals("9")
        		||event.getText().equals("A")
                ||event.getText().equals("a")
                ||event.getText().equals("B")
                ||event.getText().equals("b")
                ||event.getText().equals("C")
                ||event.getText().equals("c")
                ||event.getText().equals("D")
                ||event.getText().equals("d")
                ||event.getText().equals("E")
                ||event.getText().equals("e")
                ||event.getText().equals("F")
                ||event.getText().equals("f")){
        			campo1.deletePreviousChar();
        		}
        		break;
        	case "Decimal":
        		if(event.getText().equals("A")
                || event.getText().equals("a")
                || event.getText().equals("B")
                || event.getText().equals("b")
                || event.getText().equals("C")
                || event.getText().equals("c")
                || event.getText().equals("D")
                || event.getText().equals("d")
                || event.getText().equals("E")
                || event.getText().equals("e")
                || event.getText().equals("F")
                || event.getText().equals("f")){
        			campo1.deletePreviousChar();
        		}
        		break;
        	default:
        		break;
        }
    }	

	/* ***************************************************************
  *  Metodo: converter
  *  Funcao: Tenta abrir o metodo de conversoes, se der erro ele
  *    limpa o campo1
  *  Parametros: ActionEvent event, evento de clique no botao 
  *    "Converter"
  *  Retorno: *sem retorno*
  *************************************************************** */
	@FXML
	public void converter(ActionEvent event){
		try{
			conversoes();
		}catch(NumberFormatException e){
			campo1.clear();
		}
	}
	
	/* ***************************************************************
  *  Metodo: conversoes
  *  Funcao: Verifica as medidas de conversao e converter o valor
  *  Parametros: *sem parametro*
  *  Retorno: *sem retorno*
  *************************************************************** */
    public void conversoes(){
    	String m1 = "", m2 = "";
		m1 = medidas1.getSelectionModel().getSelectedItem();
		m2 = medidas2.getSelectionModel().getSelectedItem();
		if(m1.equals("") || m2.equals("")){
			return;
		}
		
		if(m1.equals("Decimal")){
			int c1 = Integer.parseInt(campo1.getText());
			if(m2.equals("Hexadecimal")){
				campo2.setText(Integer.toHexString(c1)); 	//Convertendo Decimal para Hexadecimal
			}else if(m2.equals("Binario")){
				campo2.setText(Integer.toBinaryString(c1)); //Convertendo Decimal para Binario
			}else if(m2.equals("Octadecimal")){
				campo2.setText(Integer.toOctalString(c1)); 	//Convertendo Decimal para Octadecimal
			}else if(m2.equals("Decimal")){
				campo2.setText(c1 + "");					 //Convertendo Decimal para Decimal
			}
		}else if(m1.equals("Hexadecimal")){
			String c1 = campo1.getText();
			if(m2.equals("Decimal")){
				campo2.setText(Integer.parseInt(c1, 16) + "");	//Convertendo Hexadecimal para Decimal
			}else if(m2.equals("Binario")){
				campo2.setText(Integer.toBinaryString(Integer.parseInt(c1, 16)) + ""); //Convertendo Hexadecimal para Binario
			}else if(m2.equals("Octadecimal")){
				campo2.setText(Integer.toOctalString(Integer.parseInt(c1, 16)) + ""); //Convertendo Hexadecimal para Octadecimal
			}else if(m2.equals("Hexadecimal")){
				campo2.setText(c1);	//Convertendo Hexadecimal para Hexadecimal
			}
		}
		else if(m1.equals("Octadecimal")){
			String c1 = campo1.getText();
			if(m2.equals("Decimal")){
				campo2.setText(Integer.parseInt(c1, 8) + "");	//Convertendo Octadecimal para Decimal
			}else if(m2.equals("Binario")){
				campo2.setText(Integer.toBinaryString(Integer.parseInt(c1, 8)) + "");	//Convertendo Octadecimal para Binario
			}else if(m2.equals("Hexadecimal")){
				campo2.setText(Integer.toHexString(Integer.parseInt(c1, 8)) + "");	//Convertendo Octadecimal para Hexadecimal
			}else if(m2.equals("Octadecimal")){
				campo2.setText(c1);	//Convertendo Octadecimal para Octadecimal
			}
		}else if(m1.equals("Binario")){
			String c1 = campo1.getText();
			if(m2.equals("Decimal")){
				campo2.setText(Integer.parseInt(c1, 2) + "");	//Convertendo Binario para Decimal
			}else if(m2.equals("Hexadecimal")){
				campo2.setText(Integer.toHexString(Integer.parseInt(c1, 2)) + "");	//Convertendo Binario para Hexadecimal
			}else if(m2.equals("Octadecimal")){
				campo2.setText(Integer.toOctalString(Integer.parseInt(c1, 2)) + "");	//Convertendo Binario para Octadecimal
			}else if(m2.equals("Binario")){
				campo2.setText(c1);	//Convertendo Binario para Binario
			}
		}
  }

  /* ***************************************************************
  *  Metodo: initialize
  *  Funcao: Inicializa o aplicativo
  *  Parametros: URL url, ResourceBundle rb
  *  Retorno: *sem retorno*
  *************************************************************** */
  @Override
  public void initialize(URL url, ResourceBundle rb){
    carregarChoiceBox();
  }

	/* ***************************************************************
  *  Metodo: carregarChoiceBox
  *  Funcao: Carrega os itens de String no ChoiceBox
  *  Parametros: *sem parametros*
  *  Retorno: *sem retorno*
  *************************************************************** */
	public void carregarChoiceBox(){
        observableTipo = FXCollections.observableArrayList("Decimal", 
                "Hexadecimal",
                "Binario",
                "Octadecimal");
        medidas1.setItems(observableTipo);
        medidas1.getSelectionModel().selectFirst();
        medidas2.setItems(observableTipo);
        medidas2.getSelectionModel().selectFirst();
        medidas2.getSelectionModel().selectNext();
    }
}