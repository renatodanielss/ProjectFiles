package br.com.cts.view;

import java.awt.EventQueue;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import br.com.cts.model.ReplaceString;

public class FormReplaceStrings extends JFrame {
	private JFrame formReplaceStrings;
	private JPanel contentPane;
	private JTextField txtReplaceString;
	private ReplaceString replaceString;
	private List<ReplaceString> replaceStrings;
	private static final long serialVersionUID = 1L;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormReplaceStrings frame = new FormReplaceStrings();
					frame.formReplaceStrings.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormReplaceStrings() {
		this.formReplaceStrings = new JFrame();
		replaceStrings = new ArrayList<ReplaceString>();
		formReplaceStrings.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent arg0) {
				FormMp3.getInstance().setEnabled(true);
				FormMp3.getInstance().setVisible(true);
			}
		});
		this.formReplaceStrings.setTitle("Inserir textos que serão substituídos");
		this.formReplaceStrings.setBounds(100, 100, 450, 212);
		contentPane = new JPanel();
		this.formReplaceStrings.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtReplaceString = new JTextField();
		txtReplaceString.setBounds(26, 34, 384, 20);
		contentPane.add(txtReplaceString);
		txtReplaceString.setColumns(10);
		
		Label lblReplaceString = new Label("Insira o texto a ser substituído:");
		lblReplaceString.setBounds(26, 10, 227, 22);
		contentPane.add(lblReplaceString);
		
		JRadioButton rdbtnReplaceFirst = new JRadioButton("Primeira Incidência");
		rdbtnReplaceFirst.setBounds(26, 61, 136, 23);
		contentPane.add(rdbtnReplaceFirst);
		
		JRadioButton rdbtnReplaceAll = new JRadioButton("Todas as Incidências");
		rdbtnReplaceAll.setBounds(178, 61, 190, 23);
		contentPane.add(rdbtnReplaceAll);
		
		JButton btnAddAndNew = new JButton("Inserir texto e adicionar novo");
		btnAddAndNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				replaceString = new ReplaceString();
				replaceString.setReplaceString(txtReplaceString.getText());
				if (rdbtnReplaceFirst.isSelected())
					replaceString.setTypeOfReplace("ReplaceFirst");
				else if (rdbtnReplaceAll.isSelected())
					replaceString.setTypeOfReplace("ReplaceAll");
				else{
					JOptionPane.showMessageDialog(null, "Selecione uma opção de substituição!");
					return;
				}
				
				replaceStrings.add(replaceString);
				for (int i = 0; i < replaceStrings.size(); i++){
					System.out.println("String: " + replaceStrings.get(i).getReplaceString() + "; Tipo de Replace: " + replaceStrings.get(i).getTypeOfReplace());
				}
			}
		});
		
		ButtonGroup bgReplace = new ButtonGroup();
		bgReplace.add(rdbtnReplaceFirst);
		bgReplace.add(rdbtnReplaceAll);
		btnAddAndNew.setBounds(26, 91, 207, 23);
		contentPane.add(btnAddAndNew);
		
		JButton btnAddAndEnd = new JButton("Inserir texto e encerrar");
		btnAddAndEnd.setBounds(244, 91, 166, 23);
		contentPane.add(btnAddAndEnd);
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}

	public JFrame getFormReplaceStrings() {
		return formReplaceStrings;
	}
}