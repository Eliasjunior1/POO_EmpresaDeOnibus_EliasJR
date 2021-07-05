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
import java.awt.Toolkit;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

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
		EmpresaDeOnibus.getContentPane().setBackground(new Color(55, 33, 89));
		EmpresaDeOnibus.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\images\\journey_120px.png"));
		EmpresaDeOnibus.setBounds(new Rectangle(0, 0, 300, 400));
	
	
		EmpresaDeOnibus.setBounds(100, 100, 300, 400);
		EmpresaDeOnibus.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		EmpresaDeOnibus.getContentPane().setLayout(null);
		EmpresaDeOnibus.setResizable(false);
		EmpresaDeOnibus.setLocationRelativeTo(null);
		EmpresaDeOnibus.setUndecorated(true);
		
		Gerentedao dao = new Gerentedao();
		
		JLabel lblclose_1 = new JLabel("");
		lblclose_1.setIcon(new ImageIcon("src\\images\\male_user_92px.png"));
		lblclose_1.setBounds(104, 26, 97, 92);
		EmpresaDeOnibus.getContentPane().add(lblclose_1);
		
		
		JLabel lbl_erro = new JLabel("");
		lbl_erro.setFont(new Font("Constantia", Font.PLAIN, 14));
		lbl_erro.setForeground(Color.RED);
		lbl_erro.setBounds(48, 271, 208, 20);
		EmpresaDeOnibus.getContentPane().add(lbl_erro);
		
		
		JLabel lblclose = new JLabel("");
		lblclose.setIcon(new ImageIcon("src\\images\\close_window_32px.png"));
		lblclose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		lblclose.setBounds(273, 0, 28, 24);
		EmpresaDeOnibus.getContentPane().add(lblclose);
		
		lblclose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
		text_user = new JTextField();
		text_user.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(255, 255, 255)));
		text_user.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		text_user.setOpaque(false);
		text_user.setForeground(Color.WHITE);
		
		text_user.setFont(new Font("Arial", Font.PLAIN, 14));
		text_user.setBounds(48, 185, 208, 20);
		EmpresaDeOnibus.getContentPane().add(text_user);
		text_user.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		passwordField.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(255, 255, 255)));
		passwordField.setOpaque(false);
		passwordField.setFont(new Font("Arial", Font.PLAIN, 16));
		passwordField.setForeground(Color.WHITE);
		passwordField.setBounds(48, 249, 208, 20);
		EmpresaDeOnibus.getContentPane().add(passwordField);
		
		JLabel lbl_nome = new JLabel("Nome");
		lbl_nome.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_nome.setForeground(Color.WHITE);
		lbl_nome.setBounds(48, 160, 46, 14);
		EmpresaDeOnibus.getContentPane().add(lbl_nome);
		
		JLabel lbl_nome_1 = new JLabel("Senha");
		lbl_nome_1.setForeground(Color.WHITE);
		lbl_nome_1.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_nome_1.setBounds(48, 228, 46, 14);
		EmpresaDeOnibus.getContentPane().add(lbl_nome_1);
		
		
		JLabel lbl_entrar = new JLabel("      Entrar");
		lbl_entrar.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		lbl_entrar.setFont(new Font("Arial", Font.BOLD, 14));
		lbl_entrar.setForeground(Color.WHITE);
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
		
		lbl_entrar.setBounds(104, 325, 97, 35);
		lbl_entrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		EmpresaDeOnibus.getContentPane().add(lbl_entrar);
		
		
		
		
		
		
		
	}
}
