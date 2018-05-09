/*
 * Classe: FileHandler
 * Descri��o: Classe respons�vel por manusear arquivos de m�sica em MP3,
 * editar tags e informa��es do arquivo.
 * Autor: Renato Daniel Santana Santos
 */

package br.com.cts.model;

import java.io.File;
import java.io.IOException;

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
		super();
	}
	
	public FileHandler(String dir){
		super();
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

	
	//M�todo respons�vel por listar arquivos de m�sica num pasta e exibir o nome dos arquivos
	public void filesList(String dir){
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				System.out.println("File: " + listOfFiles[i].getName());
			} else if (listOfFiles[i].isDirectory()) {
				System.out.println("Directory: " + listOfFiles[i].getName());
			}
		}
	}
	
	//M�todo respons�vel por substituir caracteres no nome do arquivos
	public void replaceStringInFiles(){
		//La�o respons�vel por realizar a itera��o em cada arquivo de m�sica e realizar as substitui��es
		for (int i = 0; i < listOfFiles.length; i++) {
			String musica = "";
			musica = listOfFiles[i].getName();
			if(musica.substring(musica.length()-4, musica.length()).toLowerCase().equals(".mp3")){
				//BEGIN - REPLACES
				//musica = musica.replaceFirst(musica.substring(0, 2), "");
				//musica = musica.replaceFirst('\\' + musica.substring(2, 3), " - ");
				//musica = musica.replaceFirst(musica.substring(0, 2), "");
				//Remover string no final do nome do arquivo
				
				//musica = musica.replaceFirst(" \\(2012 - Remaster\\)", "");
				//musica = musica.replaceFirst("Deep Purple -", "");
				//musica = musica.replaceFirst("-deep_purple-", " - ");
				//musica = musica.replaceFirst(musica.substring(0, 1), "");
				//musica = musica.replaceFirst("Deep Purple -", "");
				//musica = musica.replaceFirst("Pato Fu -", "");
				
				//Inserir n�mero no nome do arquivo que n�o o tem
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
	
	//M�todo respons�vel por tornar mai�scula, a primeira letra de cada palavra do nome do arquivo musical
	public void eachFirstLetterUpperCase(){
		//La�o respons�vel por iterar em cada arquivo de m�sica
		for (int i = 0; i < listOfFiles.length; i++){
			String newName = listOfFiles[i].getName();
			//La�o respons�vel por iterar em cada caracter de um arquivo de m�sica determinado pelo �ndice do
			//do la�o anterior
			if (listOfFiles[i].getName().substring(listOfFiles[i].getName().length()-4, listOfFiles[i].getName().length()).toLowerCase().equals(".mp3")){
				for (int j = 0; j < listOfFiles[i].getName().length(); j++){
					//Condicional respons�vel por procurar a primeira letra de uma palavra e se� um caracter v�lido
					if (listOfFiles[i].getName().substring(j, j+1).equals(" ") && !listOfFiles[i].getName().substring(j+1, j+2).equals("(")){
						String replaceString = newName.substring(j, j+2); //Obtendo a primeira letra da palavra
						newName = newName.replaceFirst(replaceString, replaceString.toUpperCase()); //tornando a primeira letra da palavra mai�scula
						File newNameFile = new File(stringPath + newName); //Obtendo o caminho completo do arquivo
						listOfFiles[i].renameTo(newNameFile); //renomeando o nome do arquivo
						//Se o caracter encontrado for um par�nteses, tornar o pr�ximo caracter mai�sculo
					} else if (listOfFiles[i].getName().substring(j, j+1).equals("(")){
						String replaceString = newName.substring(j, j+2);
						newName = newName.replaceFirst('\\' + replaceString, '\\' + replaceString.toUpperCase());
						File newNameFile = new File(stringPath + newName);
						listOfFiles[i].renameTo(newNameFile);
					}
				}
			}
		}
	}
	
	//M�todo respons�vel por tornar mai�scula, a primeira letra de cada palavra da tag t�tulo do arquivo musical
	public void eachSongTitleFirstLetterUpperCase() throws IOException, TagException{
		//La�o respons�vel por iterar por cada arquivo musical da pasta
		for (int i = 0; i < listOfFiles.length; i++) {
			String musica = "";
			musica = listOfFiles[i].getName(); //obt�m o nome do arquivo musical
			String fullFilePath = stringPath + musica; //concatena o caminho e o nome do arquivo musical
			
			//Testa se a extens�o do arquivo � mp3
			if (listOfFiles[i].getName().substring(listOfFiles[i].getName().length()-4).toLowerCase().equals(".mp3")){
				MP3File mp3 = new MP3File(fullFilePath);
				String newName = mp3.getID3v2Tag().getSongTitle(); //Obt�m o t�tulo atual da m�sica
				//La�o respons�vel por iterar por cada letra do t�tulo de uma m�sica
				for (int j = 0; j < mp3.getID3v2Tag().getSongTitle().length(); j++){
					//procura a primeira letra de cada palavra do t�tulo de uma m�sica e verifica se
					//o caracter � um letra
					if (mp3.getID3v2Tag().getSongTitle().substring(j, j+1).equals(" ") && !mp3.getID3v2Tag().getSongTitle().substring(j+1, j+2).equals("(")){
						String replaceString = mp3.getID3v2Tag().getSongTitle().substring(j, j+2); //Obt�m a primeira letra da palavra
						newName = newName.replaceFirst(replaceString, replaceString.toUpperCase()); //Substitui a letra pela vers�o mai�scula
						mp3.getID3v2Tag().setSongTitle(newName); //Renomeia o arquivo com as primeiras letras de cada palavra em mai�scula
						mp3.save(); //Salva as altera��es realizadas nas tags
					}
				}
			}
		}
	}
	
	/*
	 * M�todo respons�vel por atribuir o nome do arquivo musical � tag title (t�tulo) em arquivos os quais
	 * a tag title n�o est� preenchida
	 */
	public void eachSongTitleFromFileName() throws IOException, TagException{
		//La�o respons�vel por iterar em cada arquivo musical de uma pasta
		for (int i = 0; i < listOfFiles.length; i++) {
			String musica = "";
			musica = listOfFiles[i].getName(); //Obt�m o nome de um arquivo m�sical
			String fullFilePath = stringPath + musica; //Concatena o nome do arquivo musical ao caminho completo at� a pasta
			//Verifica se a extens�o do arquivo � mp3
			if (listOfFiles[i].getName().substring(listOfFiles[i].getName().length()-4).toLowerCase().equals(".mp3")){
				MP3File mp3 = new MP3File(fullFilePath);
				//Testa se a tag Title (t�tulo) est� preenchida
				if (mp3.getID3v2Tag().getSongTitle().isEmpty() || mp3.getID3v2Tag().getSongTitle().equals("") || mp3.getID3v2Tag().getSongTitle().equals(null)){
					String newName = listOfFiles[i].getName().substring(5, listOfFiles[i].getName().length()-4); //Obt�m o nome do arquivos sem a extens�o (.mp3) e sem o n�mero da m�sica
					mp3.getID3v2Tag().setSongTitle(newName); //Atribui o nome do arquivo � tag title
					mp3.save(); //Salva as altera��es realizadas nas tags do arquivo musical
				}
			}
		}
	}
	
	/*
	 * Atribui um n�mero � tag n�mero dos arquivos de acordo com a ordem alfab�tica em que elas est�o dispostas
	 * na pasta
	 */
	public void eachSongNumber() throws IOException, TagException{
		//La�o respons�vel por iterar cada arquivo musical
		for (int i = 0; i < listOfFiles.length; i++) {
			String musica = "";
			musica = listOfFiles[i].getName(); //Obt�m o nome do arquivo musical
			String fullFilePath = stringPath + musica; //Concatena o nome do arquivo ao caminho do arquivo
			//Testa se a extens�o do arquivo � mp3
			if (listOfFiles[i].getName().substring(listOfFiles[i].getName().length()-4).toLowerCase().equals(".mp3")){
				MP3File mp3 = new MP3File(fullFilePath);
				mp3.getID3v2Tag().setTrackNumberOnAlbum(String.valueOf(i+1)); //Atribui o n�mero do �ndice do la�o � tag n�mero
				mp3.save(); //Salva as tags modificadas
			}
		}
	}
}