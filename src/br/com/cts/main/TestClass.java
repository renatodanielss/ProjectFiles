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

public class TestClass {
	public static void main(String[] args){
		/*String dir = "D:/D/Mùsicas/Ozzy Osbourne/1983 - Bark At The Moon";
		dir = dir.replaceFirst("/", "//");
		filesList(dir);*/
		
		String dir = JOptionPane.showInputDialog("Digite o diretório:"); //Chama inputbox para inserir diretório
		String alterTag = JOptionPane.showInputDialog("Digite as alterações que deseja fazer:"); //Chama inputbox para informar as alterações que se deseja realizar
		
		//Teste se o diretório foi digitado
		if (!dir.equals(null) && !alterTag.equals(null) && !dir.equals("") && !alterTag.equals("")){
			dir = dir.replace("\\", "//"); //Substitui toda barra invertida (padrão de diretório do Windows) por barra (padrão de diretório do Java)
			try {
				//Opção 1: realizar as substituições no nome do arquivo musical
				if (alterTag.indexOf('1') > -1){
					startSetFileChar(dir);
					Thread.sleep(2000);
				}
				//Opção 2: colocar primeira letra de cada palavra do nome do arquivo musical em maiúscula
				if (alterTag.indexOf('2') > -1){
					startSetFileUpper(dir);
					Thread.sleep(2000);
				}
				//Opção 3: colocar primeira letra de cada palavra da tag title em maiúscula
				if (alterTag.indexOf('3') > -1){
					startSetEachTitleFirstLetter(dir);
					Thread.sleep(2000);
				}
				//Opção 4: setar o atributo title
				if (alterTag.indexOf('4') > -1){
					startSetEmptyName(dir);
					Thread.sleep(2000);
				}
				//Opção 5: setar o atributo number
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
	
	//Chama o método replaceStringInFiles da classe FileHandler
	public static void startSetFileChar(String dir){
		FileHandler fileHandler = new FileHandler(dir);
		fileHandler.replaceStringInFiles();
		System.out.println("startSetFileChar Finished");
	}
	
	//Chama o método eachFirstLetterUpperCase da classe FileHandler
	public static void startSetFileUpper(String dir){
		FileHandler fileHandler = new FileHandler(dir);
		fileHandler.eachFirstLetterUpperCase();
		System.out.println("startSetFileUpper Finished");
	}
	
	//Chama o método eachSongTitleFirstLetterUpperCase da classe FileHandler
	public static void startSetEachTitleFirstLetter(String dir) throws IOException, TagException{
		FileHandler fileHandler = new FileHandler(dir);
		fileHandler.eachSongTitleFirstLetterUpperCase();
		System.out.println("startSetEachTitleFirstLetter Finished");
	}
	
	//Chama o método eachSongTitleFromFileName da classe FileHandler
	public static void startSetEmptyName(String dir) throws IOException, TagException{
		FileHandler fileHandler = new FileHandler(dir);
		fileHandler.eachSongTitleFromFileName();
		System.out.println("startSetEmptyName Finished");
	}
	
	//Chama o método eachSongNumber da classe FileHandler
	public static void startSetSongNumber(String dir) throws IOException, TagException{
		FileHandler fileHandler = new FileHandler(dir);
		fileHandler.eachSongNumber();
		System.out.println("startSetSongNumber Finished");
	}
}