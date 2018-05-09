/*
 * Classe: MainCLass
 * Descri��o: Classe de teste dos m�todos da classe FileHandler
 * Autor: Renato Daniel Santana Santos
 */

package br.com.cts.main;

import java.io.IOException;

import javax.swing.JOptionPane;

import org.farng.mp3.TagException;

import br.com.cts.model.FileHandler;

public class MainClass {
	public static void main(String[] args){
		/*String dir = "D:/D/M�sicas/Ozzy Osbourne/1983 - Bark At The Moon";
		dir = dir.replaceFirst("/", "//");
		filesList(dir);*/
		
		String dir = JOptionPane.showInputDialog("Digite o diret�rio:"); //Chama inputbox para inserir diret�rio
		String alterTag = JOptionPane.showInputDialog("Digite as altera��es que deseja fazer:"); //Chama inputbox para informar as altera��es que se deseja realizar
		
		//Teste se o diret�rio foi digitado
		if (!dir.equals(null) && !alterTag.equals(null) && !dir.equals("") && !alterTag.equals("")){
			dir = dir.replace("\\", "//"); //Substitui toda barra invertida (padr�o de diret�rio do Windows) por barra (padr�o de diret�rio do Java)
			try {
				//Op��o 1: realizar as substitui��es no nome do arquivo musical
				if (alterTag.indexOf('1') > -1){
					startSetFileChar(dir);
					Thread.sleep(2000);
				}
				//Op��o 2: colocar primeira letra de cada palavra do nome do arquivo musical em mai�scula
				if (alterTag.indexOf('2') > -1){
					startSetFileUpper(dir);
					Thread.sleep(2000);
				}
				//Op��o 3: colocar primeira letra de cada palavra da tag title em mai�scula
				if (alterTag.indexOf('3') > -1){
					startSetEachTitleFirstLetter(dir);
					Thread.sleep(2000);
				}
				//Op��o 4: setar o atributo title
				if (alterTag.indexOf('4') > -1){
					startSetEmptyName(dir);
					Thread.sleep(2000);
				}
				//Op��o 5: setar o atributo number
				if (alterTag.indexOf('5') > -1){
					startSetSongNumber(dir);
					Thread.sleep(2000);
				}
			} catch (IOException | TagException | InterruptedException e) {
				e.printStackTrace();
			}
			
			JOptionPane.showMessageDialog(null, "Fim dos Ajustes!");
		}
		else{
			JOptionPane.showMessageDialog(null, "Nenhum ajuste a ser realizado!");
		}
	}
	
	//Chama o m�todo replaceStringInFiles da classe FileHandler
	public static void startSetFileChar(String dir){
		FileHandler fileHandler = new FileHandler(dir);
		fileHandler.replaceStringInFiles();
		System.out.println("startSetFileChar Finished");
	}
	
	//Chama o m�todo eachFirstLetterUpperCase da classe FileHandler
	public static void startSetFileUpper(String dir){
		FileHandler fileHandler = new FileHandler(dir);
		fileHandler.eachFirstLetterUpperCase();
		System.out.println("startSetFileUpper Finished");
	}
	
	//Chama o m�todo eachSongTitleFirstLetterUpperCase da classe FileHandler
	public static void startSetEachTitleFirstLetter(String dir) throws IOException, TagException{
		FileHandler fileHandler = new FileHandler(dir);
		fileHandler.eachSongTitleFirstLetterUpperCase();
		System.out.println("startSetEachTitleFirstLetter Finished");
	}
	
	//Chama o m�todo eachSongTitleFromFileName da classe FileHandler
	public static void startSetEmptyName(String dir) throws IOException, TagException{
		FileHandler fileHandler = new FileHandler(dir);
		fileHandler.eachSongTitleFromFileName();
		System.out.println("startSetEmptyName Finished");
	}
	
	//Chama o m�todo eachSongNumber da classe FileHandler
	public static void startSetSongNumber(String dir) throws IOException, TagException{
		FileHandler fileHandler = new FileHandler(dir);
		fileHandler.eachSongNumber();
		System.out.println("startSetSongNumber Finished");
	}
}