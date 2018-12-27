/*
 * Classe: FileHandler
 * Descrição: Classe responsável por manusear arquivos de música em MP3,
 * editar tags e informações do arquivo.
 * Autor: Renato Daniel Santana Santos
 */

package br.com.cts.model;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.farng.mp3.MP3File;
import org.farng.mp3.TagException;
/*import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;*/

public class FileHandler {
	private String stringPath;
	private File folder;
	private File[] listOfFiles;
	
	public FileHandler(){
		
	}
	
	public FileHandler(String dir){
		this.stringPath = dir + "/";
		this.folder = new File(dir);
		this.listOfFiles = folder.listFiles();
	}
	
	public String getStringPath() {
		return stringPath;
	}

	public void setStringPath(String stringPath) {
		this.stringPath = stringPath;
	}

	public File getFolder() {
		return folder;
	}

	public void setFolder(File folder) {
		this.folder = folder;
	}

	public File[] getListOfFiles() {
		return listOfFiles;
	}

	public void setListOfFiles(File[] listOfFiles) {
		this.listOfFiles = listOfFiles;
	}

	
	//Método responsável por listar arquivos de música num pasta e exibir o nome dos arquivos
	public void filesList(String dir){
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				System.out.println("File: " + listOfFiles[i].getName());
			} else if (listOfFiles[i].isDirectory()) {
				System.out.println("Directory: " + listOfFiles[i].getName());
			}
		}
	}
	
	//Método responsável por substituir caracteres no nome do arquivos
	public void replaceStringInFiles(){
		//Laço responsável por realizar a iteração em cada arquivo de música e realizar as substitui��es
		for (int i = 0; i < listOfFiles.length; i++) {
			String musica = "";
			musica = listOfFiles[i].getName();
			if(musica.substring(musica.length()-4, musica.length()).toLowerCase().equals(".mp3")){
				//BEGIN - REPLACES
				//musica = musica.replaceFirst(musica.substring(0, 2), "");
//				musica = musica.replaceFirst("Cat Power -Clear the Room-Rarities- ", "");
				//musica = musica.replaceFirst("\\[", "\\(");
				//musica = musica.replaceFirst("\\]", "\\)");
//				musica = musica.replaceAll("_", " ");
				musica = musica.replaceFirst("Cat Power - Wanderer - ", "");
				//musica = musica.replaceFirst(musica.substring(musica.length()-13, musica.length()-4), "");
				//musica = musica.replaceFirst(musica.substring(0, 2), "");
				//Remover string no final do nome do arquivo
				
//				musica = musica.replaceFirst("-RCD", "");
				//musica = musica.replaceFirst("Deep Purple -", "");
				//musica = musica.replaceFirst("-deep_purple-", " - ");
				//musica = musica.replaceFirst(musica.substring(0, 1), "");
				//musica = musica.replaceFirst("Deep Purple -", "");
				//musica = musica.replaceFirst("Pato Fu -", "");
				
				//Inserir número no nome do arquivo que não o tem
				/*MP3File mp3;
				try {
					mp3 = new MP3File(stringPath + musica);
					String numero = mp3.getID3v2Tag().getTrackNumberOnAlbum();
					
					if (numero.length() > 1)
						musica = musica.replaceFirst(musica.substring(0, 1), numero + " - " + musica.substring(0, 1));
					else
						musica = musica.replaceFirst(musica.substring(0, 1), "0" + numero + " - " + musica.substring(0, 1));
				} catch (IOException e) {
					e.printStackTrace();
				} catch (TagException e) {
					e.printStackTrace();
				}*/
				
				//musica = musica.replaceFirst(" \\(Ao Vivo\\)", "");
				//musica = musica.replaceFirst(" ", " - ");
				//musica = musica.replaceFirst(" ", " - ");
				//musica = musica.replaceFirst(musica.substring(0, 2), musica.substring(0, 2) + " - ");
				//musica = musica.replaceFirst(" ", " - ");
				//musica = musica.replaceAll("_", " ");
				//musica = musica.replaceAll("-", " ");
				//musica = musica.replaceFirst("\\[", "\\(");
				//musica = musica.replaceFirst("\\]", "\\)");
				//musica = musica.replaceAll("_", " ");
				
				/*musica = musica.replaceFirst(musica.substring(musica.length() - 13, musica.length()), ".mp3");
				
				musica = musica.replaceFirst("-depeche_mode-", " - ");
				
				musica = musica.replaceAll("_", " ");*/
				
				//musica = musica.replaceFirst("\\- \\(Camenhas\\)", "");
				
				//Teste JTagger
				/*try {
					File testFile = new File(stringPath + musica);
					AudioFile f = AudioFileIO.read(testFile);
					Tag tag = f.getTag();
					tag.setField(FieldKey.ARTIST,"Kings of Leon");
					AudioFileIO.write(f);
				} catch (Exception e){
					e.printStackTrace();
				}*/
				
				//musica = musica.replaceFirst("\\(album_version\\)", "");
				//musica = musica.replaceAll("_", " ");
				
				//musica = musica.replaceFirst(" \\[Bonus Track\\]", "");
				//musica = musica.replaceAll("\\[", "\\(");
				//musica = musica.replaceAll("\\]", "\\)");
				//musica = musica.replaceFirst("_\\(remastered\\)", "");
				//musica = musica.replaceFirst("_\\(live\\)", "");
				
				//Substituir n�mero no in�cio do nome do arquivo
				/*if (Integer.valueOf(musica.substring(0, 2))-12 < 10)
					musica = musica.replaceFirst(musica.substring(0, 2), "0" + String.valueOf(Integer.valueOf(musica.substring(0, 2))-28));
				else
					musica = musica.replaceFirst(musica.substring(0, 2), String.valueOf(Integer.valueOf(musica.substring(0, 2))-28));
				musica = musica.replaceAll("_", " ");*/
				//Substituir n�mero no in�cio do nome do arquivo
				
				//musica = musica.replaceFirst("Mtv", "MTV".toUpperCase());
				//musica = musica.replace("Muse - ", "");
				//musica = musica.replace("In Flames-", "");
				//musica = musica.replace("dream theater  -  ", "");
				//musica = musica.replace("Pearl Jam - ", "");
				//musica = musica.replaceFirst("-ser", "");
				
				/*String fullFilePath = stringPath + musica;
				try {
					MP3File mp3 = new MP3File(fullFilePath);
					int track = 0;
					
					try{
						track = Integer.valueOf(mp3.getID3v2Tag().getTrackNumberOnAlbum().substring(0, 2));
					} catch (Exception e){
						track = Integer.valueOf(mp3.getID3v2Tag().getTrackNumberOnAlbum().substring(0, 1));
					}
					
					if (track < 10 && track > 0){
						musica = musica.replace(musica.substring(0, 2), "0" + String.valueOf(track));
					}
					else if (track >= 10 && track > 0) {
						musica = musica.replace(musica.substring(0, 2), String.valueOf(track));
					}
				} catch (IOException | TagException e) {
					e.printStackTrace();
				}*/
				
				//END - REPLACES
				
				
				File newNameFile = new File(stringPath + musica);
				listOfFiles[i].renameTo(newNameFile);
			} //fim do la�o for de itera��o das m�sicas
		}
	}
	
	//Método responsável por substituir caracteres no nome do arquivos
	public void replaceStringInFiles(List<ReplaceString> replaceStrings){
		//Laço responsável por realizar a iteração em cada arquivo de música e realizar as substitui��es
		for (int i = 0; i < listOfFiles.length; i++) {
			String musica = "";
			musica = listOfFiles[i].getName();
			//Verifica se é mp3
			if(musica.substring(musica.length()-4, musica.length()).toLowerCase().equals(".mp3")){
				//Laço para iterar entre as opções
				for (ReplaceString replaceString : replaceStrings){
					switch (replaceString.getTypeOfReplace()) {
					case "replaceFirst":
						musica = musica.replaceFirst(replaceString.getReplaceString(), replaceString.getNewString());
						break;
					case "replaceAll":
						musica = musica.replaceAll(replaceString.getReplaceString(), replaceString.getNewString());
						break;
					}
				}
				
				File newNameFile = new File(stringPath + musica);
				listOfFiles[i].renameTo(newNameFile);
			} //fim do laço for de iteração das músicas
		}
	}
	
	//Método responsável por tornar maiúscula, a primeira letra de cada palavra do nome do arquivo musical
	public void eachFirstLetterUpperCase(){
		//Laço responsável por iterar em cada arquivo de música
		for (int i = 0; i < listOfFiles.length; i++){
			String newName = listOfFiles[i].getName();
			if (listOfFiles[i].getName().substring(listOfFiles[i].getName().length()-4, listOfFiles[i].getName().length()).toLowerCase().equals(".mp3")){
				//Laço responsável por iterar em cada caracter de um arquivo de música determinado pelo índice do
				//do laço anterior
				File newNameFile = null;
				for (int j = 0; j < listOfFiles[i].getName().length(); j++){
					//Condicional responsável por procurar a primeira letra de uma palavra e se é um caracter válido
					if (listOfFiles[i].getName().substring(j, j+1).equals(" ") && !listOfFiles[i].getName().substring(j+1, j+2).equals("(") && !listOfFiles[i].getName().substring(j+1, j+2).equals("[")){
						String replaceString = newName.substring(j, j+2); //Obtendo a primeira letra da palavra
						newName = newName.replaceFirst(replaceString, replaceString.toUpperCase()); //tornando a primeira letra da palavra maiúscula
						newNameFile = new File(stringPath + newName); //Obtendo o caminho completo do arquivo
						//Se o caracter encontrado for um parênteses, tornar o próximo caracter maiúsculo
					} else if (listOfFiles[i].getName().substring(j, j+1).equals("(") && listOfFiles[i].getName().substring(j, j+1).equals("[")){
						String replaceString = newName.substring(j, j+2);
						newName = newName.replaceFirst('\\' + replaceString, '\\' + replaceString.toUpperCase());
						newNameFile = new File(stringPath + newName);
					}
				}
				if (newNameFile != null) {
					listOfFiles[i].renameTo(newNameFile); //renomeando o nome do arquivo
				}
			}
		}
	}
	
	//Método responsável por tornar maiúscula, a primeira letra de cada palavra da tag título do arquivo musical
	public void eachSongTitleFirstLetterUpperCase() throws IOException, TagException{
		//Laço responsável por iterar por cada arquivo musical da pasta
		for (int i = 0; i < listOfFiles.length; i++) {
			String musica = "";
			musica = listOfFiles[i].getName(); //obtém o nome do arquivo musical
			String fullFilePath = stringPath + musica; //concatena o caminho e o nome do arquivo musical
			
			//Testa se a extensão do arquivo é mp3
			if (listOfFiles[i].getName().substring(listOfFiles[i].getName().length()-4).toLowerCase().equals(".mp3")){
				MP3File mp3 = new MP3File(fullFilePath);
				String newName = mp3.getID3v2Tag().getSongTitle(); //Obtém o título atual da música
				//Laço responsável por iterar por cada letra do título de uma música
				for (int j = 0; j < mp3.getID3v2Tag().getSongTitle().length(); j++){
					//procura a primeira letra de cada palavra do título de uma música e verifica se
					//o caracter é um letra
					if (mp3.getID3v2Tag().getSongTitle().substring(j, j+1).equals(" ") && !mp3.getID3v2Tag().getSongTitle().substring(j+1, j+2).equals("(")){
						String replaceString = mp3.getID3v2Tag().getSongTitle().substring(j, j+2); //Obtém a primeira letra da palavra
						newName = newName.replaceFirst(replaceString, replaceString.toUpperCase()); //Substitui a letra pela versão maiúscula
						mp3.getID3v2Tag().setSongTitle(newName); //Renomeia o arquivo com as primeiras letras de cada palavra em maiúscula
						mp3.save(); //Salva as alterações realizadas nas tags
					}
				}
			}
		}
	}
	
	/*
	 * Método responsável por atribuir o nome do arquivo musical � tag title (título) em arquivos os quais
	 * a tag title não está preenchida
	 */
	public void eachSongTitleFromFileName() throws IOException, TagException{
		//Laço responsável por iterar em cada arquivo musical de uma pasta
		for (int i = 0; i < listOfFiles.length; i++) {
			String musica = "";
			musica = listOfFiles[i].getName(); //Obtém o nome de um arquivo músical
			String fullFilePath = stringPath + musica; //Concatena o nome do arquivo musical ao caminho completo até a pasta
			//Verifica se a extensão do arquivo é mp3
			if (listOfFiles[i].getName().substring(listOfFiles[i].getName().length()-4).toLowerCase().equals(".mp3")){
				MP3File mp3 = new MP3File(fullFilePath);
				//Testa se a tag Title (título) está preenchida
				if (mp3.getID3v2Tag().getSongTitle().isEmpty() || mp3.getID3v2Tag().getSongTitle().equals("") || mp3.getID3v2Tag().getSongTitle().equals(null)){
					String newName = listOfFiles[i].getName().substring(5, listOfFiles[i].getName().length()-4); //Obtém o nome do arquivos sem a extensão (.mp3) e sem o número da música
					mp3.getID3v2Tag().setSongTitle(newName); //Atribui o nome do arquivo à tag title
					mp3.save(); //Salva as alterações realizadas nas tags do arquivo musical
				}
			}
		}
	}
	
	/*
	 * Atribui um número à tag número dos arquivos de acordo com a ordem alfabética em que elas estão dispostas
	 * na pasta
	 */
	public void eachSongNumber() throws IOException, TagException{
		//Laço responsável por iterar cada arquivo musical
		for (int i = 0; i < listOfFiles.length; i++) {
			String musica = "";
			musica = listOfFiles[i].getName(); //Obtém o nome do arquivo musical
			String fullFilePath = stringPath + musica; //Concatena o nome do arquivo ao caminho do arquivo
			//Testa se a extensão do arquivo é mp3
			if (listOfFiles[i].getName().substring(listOfFiles[i].getName().length()-4).toLowerCase().equals(".mp3")){
				MP3File mp3 = new MP3File(fullFilePath);
				mp3.getID3v2Tag().setTrackNumberOnAlbum(String.valueOf(i+1)); //Atribui o número do índice do laço à tag número
				mp3.save(); //Salva as tags modificadas
			}
		}
	}
}