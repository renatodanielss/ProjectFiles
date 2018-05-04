package br.com.cts.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.farng.mp3.TagException;

import br.com.cts.files.FileHandler;
import java.awt.Label;

public class FormMp3 extends JFrame {

	JCheckBox cbChangeFileName;
	JCheckBox cbFileFirstLetterUpperCase;
	JCheckBox cbTagFirstLetterUpperCase;
	JCheckBox cbSetTag;
	JCheckBox cbSetNumber;
	Label lblAlbum;
	private static final long serialVersionUID = 1L;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormMp3 frame = new FormMp3();
					frame.setVisible(true);
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
		setTitle("Selecionar Pasta da Banda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 865, 308);
		//getContentPane().setLayout(null);
		//setar tamanho mínimo do formnulário
		setMinimumSize(this.getSize());
		getContentPane().setLayout(null);
		
		JFileChooser fcBanda = new JFileChooser();
		fcBanda.setBounds(0, 0, 458, 268);
		fcBanda.setControlButtonsAreShown(false);
		getContentPane().add(fcBanda);
		
		JButton btnAplicarAlteraes = new JButton("Aplicar Altera\u00E7\u00F5es");
		btnAplicarAlteraes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(fcBanda.getCurrentDirectory().getAbsolutePath().toString());
				
				for (int i = 0; i < fcBanda.getCurrentDirectory().listFiles().length; i++){
					System.out.println(fcBanda.getCurrentDirectory().listFiles()[i].getAbsolutePath().toString());
					
					String dir = fcBanda.getCurrentDirectory().listFiles()[i].getAbsolutePath();
					dir = dir.replace("\\", "//");
					FileHandler fileHandler = new FileHandler(dir);
					lblAlbum.setText("Alterando álbum " + fcBanda.getCurrentDirectory().listFiles()[i].getName() + ", aguarde...");
					try{
						//Opção 1: realizar as substituições no nome do arquivo musical
						if (cbChangeFileName.isSelected()){
							fileHandler.replaceStringInFiles();
							Thread.sleep(2000);
						}
						//Opção 2: colocar primeira letra de cada palavra do nome do arquivo musical em maiúscula
						if (cbFileFirstLetterUpperCase.isSelected()){
							fileHandler.eachFirstLetterUpperCase();
							Thread.sleep(2000);
						}
						//Opção 3: colocar primeira letra de cada palavra da tag title em maiúscula
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
					fileHandler = null;
				}
				JOptionPane.showMessageDialog(null, "Alterações Finalizadas!");
			}
		});
		btnAplicarAlteraes.setBounds(468, 160, 156, 23);
		getContentPane().add(btnAplicarAlteraes);
		
		cbChangeFileName = new JCheckBox("Alterar nome do arquivo");
		cbChangeFileName.setBounds(464, 7, 195, 23);
		getContentPane().add(cbChangeFileName);
		
		cbFileFirstLetterUpperCase = new JCheckBox("Alterar primeiras letras para mai\u00FAscula");
		cbFileFirstLetterUpperCase.setBounds(464, 33, 268, 23);
		getContentPane().add(cbFileFirstLetterUpperCase);
		
		cbTagFirstLetterUpperCase = new JCheckBox("Alterar primeiras letras da tag \"title\" para mai\u00FAscula");
		cbTagFirstLetterUpperCase.setBounds(464, 59, 334, 23);
		getContentPane().add(cbTagFirstLetterUpperCase);
		
		cbSetTag = new JCheckBox("Atribuir nome do arquivo \u00E0 tag \"title\"");
		cbSetTag.setBounds(464, 85, 245, 23);
		getContentPane().add(cbSetTag);
		
		cbSetNumber = new JCheckBox("Atribuir n\u00FAmero \u00E0 faixas");
		cbSetNumber.setBounds(464, 111, 175, 23);
		getContentPane().add(cbSetNumber);
		
		lblAlbum = new Label("");
		lblAlbum.setBounds(464, 203, 309, 56);
		getContentPane().add(lblAlbum);
	}
}
