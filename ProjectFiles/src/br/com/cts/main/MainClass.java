package br.com.cts.main;

import java.io.IOException;

import javax.swing.JOptionPane;

import org.farng.mp3.TagException;

import br.com.cts.files.FileHandler;

public class MainClass {
	public static void main(String[] args){
		/*String dir = "D:/D/Músicas/Ozzy Osbourne/1983 - Bark At The Moon";
		dir = dir.replaceFirst("/", "//");
		filesList(dir);*/
		
		String dir = JOptionPane.showInputDialog("Digite o diretório:");
		String alterTag = JOptionPane.showInputDialog("Digite as alterações que deseja fazer:");
		
		dir = dir.replace("\\", "//");
		
		try {
			if (alterTag.indexOf('1') > -1){
				startSetFileChar(dir);
				Thread.sleep(2000);
			}
			if (alterTag.indexOf('2') > -1){
				startSetFileUpper(dir);
				Thread.sleep(2000);
			}
			if (alterTag.indexOf('3') > -1){
				startSetEachTitleFirstLetter(dir);
				Thread.sleep(2000);
			}
			if (alterTag.indexOf('4') > -1){
				startSetEmptyName(dir);
				Thread.sleep(2000);
			}
			if (alterTag.indexOf('5') > -1){
				startSetSongNumber(dir);
				Thread.sleep(2000);
			}
		} catch (IOException | TagException | InterruptedException e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Fim dos Ajustes!");
	}
	
	public static void startSetFileChar(String dir){
		FileHandler fileHandler = new FileHandler(dir);
		fileHandler.replaceStringInFiles();
		System.out.println("startSetFileChar Finished");
	}
	
	public static void startSetFileUpper(String dir){
		FileHandler fileHandler = new FileHandler(dir);
		fileHandler.eachFirstLetterUpperCase();
		System.out.println("startSetFileUpper Finished");
	}
	
	public static void startSetEachTitleFirstLetter(String dir) throws IOException, TagException{
		FileHandler fileHandler = new FileHandler(dir);
		fileHandler.eachSongTitleFirstLetterUpperCase();
		System.out.println("startSetEachTitleFirstLetter Finished");
	}
	
	public static void startSetEmptyName(String dir) throws IOException, TagException{
		FileHandler fileHandler = new FileHandler(dir);
		fileHandler.eachSongTitleFromFileName();
		System.out.println("startSetEmptyName Finished");
	}
	
	public static void startSetSongNumber(String dir) throws IOException, TagException{
		FileHandler fileHandler = new FileHandler(dir);
		fileHandler.eachSongNumber();
		System.out.println("startSetSongNumber Finished");
	}
}