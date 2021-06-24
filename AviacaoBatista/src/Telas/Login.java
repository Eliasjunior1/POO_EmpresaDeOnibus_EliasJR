package Telas;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Persistentes.Gerente;
import model.dao.Gerentedao;

public class Login {
	
	public static ArrayList<Gerente> gerente_ = new ArrayList<Gerente>();

	private JFrame EmpresaDeOnibus;
	
	public static float salario_minimo = (float) 1.045;
	private JTextField text_user;
	private JPasswordField passwordField;

	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.EmpresaDeOnibus.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		initialize();
	}


	private void initialize() {
		EmpresaDeOnibus = new JFrame();
		EmpresaDeOnibus.setBounds(new Rectangle(0, 0, 300, 400));
	
		EmpresaDeOnibus.setBounds(100, 100, 300, 400);
		EmpresaDeOnibus.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		EmpresaDeOnibus.getContentPane().setLayout(null);
		EmpresaDeOnibus.setResizable(false);
		EmpresaDeOnibus.setLocationRelativeTo(null);
		EmpresaDeOnibus.setUndecorated(true);
		
		Gerentedao dao = new Gerentedao();
		
		
		JLabel lblclose = new JLabel("");
		lblclose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		lblclose.setBounds(276, 0, 24, 24);
		EmpresaDeOnibus.getContentPane().add(lblclose);
		
		lblclose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
		passwordField = new JPasswordField();
		passwordField.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		passwordField.setBorder(null);
		passwordField.setOpaque(false);
		passwordField.setFont(new Font("Constantia", Font.PLAIN, 14));
		passwordField.setForeground(Color.WHITE);
		passwordField.setBounds(48, 216, 208, 20);
		EmpresaDeOnibus.getContentPane().add(passwordField);
		
		text_user = new JTextField();
		text_user.setBorder(null);
		text_user.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		text_user.setOpaque(false);
		text_user.setForeground(Color.WHITE);
		
		text_user.setFont(new Font("Constantia", Font.PLAIN, 14));
		text_user.setBounds(48, 136, 208, 20);
		EmpresaDeOnibus.getContentPane().add(text_user);
		text_user.setColumns(10);
		
		
		JLabel lbl_erro = new JLabel("");
		lbl_erro.setFont(new Font("Constantia", Font.PLAIN, 14));
		lbl_erro.setForeground(Color.RED);
		lbl_erro.setBounds(48, 235, 208, 20);
		EmpresaDeOnibus.getContentPane().add(lbl_erro);
		
		
		JLabel lbl_entrar = new JLabel("");
		lbl_entrar.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = 0;
				
				dao.read();
				String id = gerente_.get(i).getId_gerente();
				String nome = gerente_.get(i).getNome();
				String cpf = gerente_.get(i).getCpf();
				int idade = gerente_.get(i).getIdade();
				String telefone = gerente_.get(i).getTelefone();
				float salario = gerente_.get(i).getSalario();
				String senha = gerente_.get(i).getSenha();
				String cargo = gerente_.get(i).getCargo();
				
				Gerente ger = new Gerente(id,nome,cpf,idade,telefone,salario,senha,cargo);
				
				
				
				if(ger.getNome().equalsIgnoreCase(text_user.getText())) {
					if(ger.getSenha().equalsIgnoreCase(passwordField.getText())) {
						TelaPrincipal.main(null);
						EmpresaDeOnibus.dispose();
					}else {
						lbl_erro.setText("Credenciais incorretas!");
					}
				}else {
					lbl_erro.setText("Credenciais incorretas!");
				}
				
			}
		});
		
		lbl_entrar.setBounds(100, 277, 104, 39);
		lbl_entrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		EmpresaDeOnibus.getContentPane().add(lbl_entrar);
		
		
		JLabel lbl_model = new JLabel("");
		lbl_model.setIcon(new ImageIcon("C:\\Users\\elias\\eclipse-workspace\\AviacaoBatista\\src\\images\\LOGIN.jpg"));
		lbl_model.setBounds(0, 0, 300, 400);
		EmpresaDeOnibus.getContentPane().add(lbl_model);
		
		
		
		
		
		
		
	}
}
