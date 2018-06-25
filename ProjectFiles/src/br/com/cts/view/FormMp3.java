/*
 * Classe: FormMp3
 * Descri��o: Classe de interface gr�fica para comunica��o com a classe principal de manipula��o de arquivos MP3
 * Autor: Renato Daniel Santana Santos
 */

package br.com.cts.view;

import java.awt.EventQueue;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

import org.farng.mp3.TagException;

import br.com.cts.model.FileHandler;

public class FormMp3 extends JFrame {
	private JFrame formMp3;
	private static JFrame staticFormMp3;
	JCheckBox cbChangeFileName;
	JCheckBox cbFileFirstLetterUpperCase;
	JCheckBox cbTagFirstLetterUpperCase;
	JCheckBox cbSetTag;
	JCheckBox cbSetNumber;
	Label lblAlbum;
	private JProgressBar pbMp3;
	private static final long serialVersionUID = 1L;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormMp3 frame = new FormMp3();
					frame.formMp3.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormMp3() {
		formMp3 = new JFrame();
		FormMp3.staticFormMp3 = this.formMp3;
		this.formMp3.setTitle("Selecionar Pasta da Banda");
		this.formMp3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.formMp3.setBounds(100, 100, 865, 308);
		//getContentPane().setLayout(null);
		//setar tamanho mínimo do formnulário
		this.formMp3.setMinimumSize(this.getSize());
		this.formMp3.getContentPane().setLayout(null);
		
		JFileChooser fcBanda = new JFileChooser();
		fcBanda.setBounds(0, 0, 458, 268);
		fcBanda.setControlButtonsAreShown(false);
		this.formMp3.getContentPane().add(fcBanda);
		
		JButton btnAplicarAlteraes = new JButton("Aplicar Altera\u00E7\u00F5es");
		btnAplicarAlteraes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//System.out.println(fcBanda.getCurrentDirectory().getAbsolutePath().toString());
				pbMp3.setMaximum(fcBanda.getCurrentDirectory().listFiles().length);
				pbMp3.setVisible(true);
				pbMp3.setStringPainted(true);
				pbMp3.update(pbMp3.getGraphics());

				//Teste
				try{
					FormReplaceStrings window = new FormReplaceStrings();
					window.getFormReplaceStrings().setVisible(true);
					formMp3.setEnabled(false);
				}catch(Exception e){
					e.printStackTrace();
				}
				//Fim Teste
				
				for (int i = 0; i < fcBanda.getCurrentDirectory().listFiles().length; i++){
					
					System.out.println(fcBanda.getCurrentDirectory().listFiles()[i].getAbsolutePath().toString());
					
					String dir = fcBanda.getCurrentDirectory().listFiles()[i].getAbsolutePath();
					dir = dir.replace("\\", "//");
					FileHandler fileHandler = new FileHandler(dir);
					lblAlbum.setText("Alterando Álbum " + fcBanda.getCurrentDirectory().listFiles()[i].getName() + ", aguarde...");
					int lgth = lblAlbum.getText().length() * 10;
			        lblAlbum.setBounds(464, 189, lgth, 23);
					try{
						//Opção 1: realizar as substituições no nome do arquivo musical
						if (cbChangeFileName.isSelected()){
							fileHandler.replaceStringInFiles();
							fileHandler.setListOfFiles(fileHandler.getFolder().listFiles());
							Thread.sleep(2000);
						}
						//Opção 2: colocar primeira letra de cada palavra do nome do arquivo musical em maiúscula
						if (cbFileFirstLetterUpperCase.isSelected()){
							fileHandler.eachFirstLetterUpperCase();
							fileHandler.setListOfFiles(fileHandler.getFolder().listFiles());
							Thread.sleep(2000);
						}
						//Opção 3: colocar primeira letra de cada palavra da tag title em mai�scula
						if (cbTagFirstLetterUpperCase.isSelected()){
							fileHandler.eachSongTitleFirstLetterUpperCase();;
							Thread.sleep(2000);
						}
						//Opção 4: setar o atributo title
						if (cbSetTag.isSelected()){
							fileHandler.eachSongTitleFromFileName();
							Thread.sleep(2000);
						}
						//Opção 5: setar o atributo number
						if (cbSetNumber.isSelected()){
							fileHandler.eachSongNumber();
							Thread.sleep(2000);
						}
					} catch (IOException | TagException | InterruptedException e) {
						e.printStackTrace();
					}
					
					/*File musicas[] = fileHandler.getListOfFiles();
					for (int j = 0; j < musicas.length; j++){
						if (musicas[j].getName().substring(musicas[j].getName().length() - 4, musicas[j].getName().length()).equals(".mp3"))
							System.out.println("     " + musicas[j].getName());
					}*/
					pbMp3.setValue(i+1);
					pbMp3.update(pbMp3.getGraphics());
				}
				JOptionPane.showMessageDialog(null, "Alterações Finalizadas!");
				pbMp3.setVisible(false);
				lblAlbum.setText("");
			}
		});
		btnAplicarAlteraes.setBounds(468, 160, 156, 23);
		this.formMp3.getContentPane().add(btnAplicarAlteraes);
		
		cbChangeFileName = new JCheckBox("Alterar nome do arquivo");
		cbChangeFileName.setBounds(464, 7, 195, 23);
		this.formMp3.getContentPane().add(cbChangeFileName);
		
		cbFileFirstLetterUpperCase = new JCheckBox("Alterar primeiras letras para mai\u00FAscula");
		cbFileFirstLetterUpperCase.setBounds(464, 33, 268, 23);
		this.formMp3.getContentPane().add(cbFileFirstLetterUpperCase);
		
		cbTagFirstLetterUpperCase = new JCheckBox("Alterar primeiras letras da tag \"title\" para mai\u00FAscula");
		cbTagFirstLetterUpperCase.setBounds(464, 59, 334, 23);
		this.formMp3.getContentPane().add(cbTagFirstLetterUpperCase);
		
		cbSetTag = new JCheckBox("Atribuir nome do arquivo \u00E0 tag \"title\"");
		cbSetTag.setBounds(464, 85, 245, 23);
		this.formMp3.getContentPane().add(cbSetTag);
		
		cbSetNumber = new JCheckBox("Atribuir n\u00FAmero \u00E0 faixas");
		cbSetNumber.setBounds(464, 111, 175, 23);
		this.formMp3.getContentPane().add(cbSetNumber);
		
		lblAlbum = new Label("");
		lblAlbum.setBounds(464, 189, 309, 23);
		this.formMp3.getContentPane().add(lblAlbum);
		
		pbMp3 = new JProgressBar();
		pbMp3.setBounds(464, 218, 371, 27);
		pbMp3.setVisible(false);
		this.formMp3.getContentPane().add(pbMp3);
	}
	
	public static synchronized JFrame getInstance( ) {
	      if (staticFormMp3 == null)
	          staticFormMp3 = new FormMp3();
	      return staticFormMp3;
	   }
	/*private void displayGUI() {
    }*/
}