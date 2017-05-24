package br.com.cts.files;

import java.io.File;
import java.io.IOException;

import org.farng.mp3.MP3File;
import org.farng.mp3.TagException;

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

	public void filesList(String dir){
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				System.out.println("File: " + listOfFiles[i].getName());
			} else if (listOfFiles[i].isDirectory()) {
				System.out.println("Directory: " + listOfFiles[i].getName());
			}
		}
	}
	
	public void replaceStringInFiles(){
		for (int i = 0; i < listOfFiles.length; i++) {
			String musica = "";
			musica = listOfFiles[i].getName();
			
			//BEGIN - REPLACES
			//musica = musica.replaceFirst(musica.substring(0), "0");
			//musica = musica.replaceFirst(musica.substring(0, 2), "");
			//musica = musica.replaceFirst("Led Zeppelin - ", "");
			musica = musica.replaceFirst(" ", " ");
			//musica = musica.replaceAll("_", " ");
			//musica = musica.replaceFirst("-Wyse", "");
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
		}
	}
	
	public void eachFirstLetterUpperCase(){
		for (int i = 0; i < listOfFiles.length; i++){
			String newName = listOfFiles[i].getName();
			for (int j = 0; j < listOfFiles[i].getName().length(); j++){
				if (listOfFiles[i].getName().substring(j, j+1).equals(" ") && !listOfFiles[i].getName().substring(j+1, j+2).equals("(")){
					String replaceString = newName.substring(j, j+2);
					System.out.println(replaceString);
					newName = newName.replaceFirst(replaceString, replaceString.toUpperCase());
					File newNameFile = new File(stringPath + newName);
					listOfFiles[i].renameTo(newNameFile);
				}
			}
		}
	}
	
	public void eachSongTitleFirstLetterUpperCase() throws IOException, TagException{
		for (int i = 0; i < listOfFiles.length; i++) {
			String musica = "";
			musica = listOfFiles[i].getName();
			String fullFilePath = stringPath + musica;
			
			if (listOfFiles[i].getName().substring(listOfFiles[i].getName().length()-3).toLowerCase().equals("mp3")){
				MP3File mp3 = new MP3File(fullFilePath);
				String newName = mp3.getID3v2Tag().getSongTitle();
				for (int j = 0; j < mp3.getID3v2Tag().getSongTitle().length(); j++){
					
					if (mp3.getID3v2Tag().getSongTitle().substring(j, j+1).equals(" ") && !mp3.getID3v2Tag().getSongTitle().substring(j+1, j+2).equals("(")){
						String replaceString = mp3.getID3v2Tag().getSongTitle().substring(j, j+2);
						newName = newName.replaceFirst(replaceString, replaceString.toUpperCase());
						mp3.getID3v2Tag().setSongTitle(newName);
						mp3.save();
					}
				}
			}
		}
	}
	
	public void eachSongTitleFromFileName() throws IOException, TagException{
		for (int i = 0; i < listOfFiles.length; i++) {
			String musica = "";
			musica = listOfFiles[i].getName();
			String fullFilePath = stringPath + musica;
			
			if (listOfFiles[i].getName().substring(listOfFiles[i].getName().length()-3).toLowerCase().equals("mp3")){
				MP3File mp3 = new MP3File(fullFilePath);

				String newName = listOfFiles[i].getName().substring(5, listOfFiles[i].getName().length()-4);
				mp3.getID3v2Tag().setSongTitle(newName);
				mp3.save();
			}
		}
	}
	
	public void eachSongNumber() throws IOException, TagException{
		int songNumber = 1;
		for (int i = 0; i < listOfFiles.length; i++) {
			String musica = "";
			musica = listOfFiles[i].getName();
			String fullFilePath = stringPath + musica;
			
			if (listOfFiles[i].getName().substring(listOfFiles[i].getName().length()-3).toLowerCase().equals("mp3")){
				MP3File mp3 = new MP3File(fullFilePath);

				mp3.getID3v2Tag().setTrackNumberOnAlbum(String.valueOf(songNumber));
				mp3.save();
				songNumber++;
			}
		}
	}
}