package Telas;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Persistentes.Cobrador;
import Persistentes.Fiscal;
import Persistentes.Gerente;
import Persistentes.Motorista;
import Persistentes.Onibus;
import Persistentes.Rotas;
import model.bean.Cobradorbean;
import model.bean.Fiscalbean;
import model.bean.Motoristabean;
import model.bean.Onibusbean;
import model.bean.Rotasbean;
import model.dao.Cobradordao;
import model.dao.Fiscaldao;
import model.dao.Motoristadao;
import model.dao.Onibusdao;
import model.dao.Rotasdao;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import java.awt.Dimension;
import javax.swing.border.EmptyBorder;
import java.awt.Component;
import javax.swing.AbstractListModel;
import javax.swing.JSplitPane;
import javax.swing.JLayeredPane;
import javax.swing.JSeparator;
import java.awt.Toolkit;

public class TelaPrincipal {
	
	public static ArrayList<Motorista> motorista_ = new ArrayList<Motorista>();
	public static ArrayList<Fiscal> fiscal_ = new ArrayList<Fiscal>();
	public static ArrayList<Cobrador> cobrador_ = new ArrayList<Cobrador>();
	public static ArrayList<Onibus> onibus_ = new ArrayList<Onibus>();
	public static ArrayList<Rotas> rotas_ = new ArrayList<Rotas>();
	public static ArrayList<Object> dados = new ArrayList<Object>();
	
	
	
	private JFrame EmpresaDeOnibus;
	private JPanel panel_2;
	private JTextField text_name;
	private JTextField text_cpf;
	private JTextField text_telefone;
	private JTextField text_idade;
	private JTextField text_cnh;
	public static float salario_minimo = (float) 1.045;
	private JTable table;
	private JTextField text_placa;
	private JTextField text_origem;
	private JTextField text_destino;
	private JTextField text_id;
	private JTextField text_id_demissao;
	private JPanel panelRotas;
	private JTextField textid;
	private JTextField textplaca;
	
	
	public void carregarLista_demissao(JList lista_id, JList lista_nome, String cargo) {
		
		DefaultListModel modelo_id = new DefaultListModel();
		
		DefaultListModel modelo_nome = new DefaultListModel();
		
		Motoristadao dao = new Motoristadao();
		dao.read();
		Cobradordao daoo = new Cobradordao();
		daoo.read();
		Fiscaldao daooo = new Fiscaldao();
		daooo.read();
		
		if(cargo.equalsIgnoreCase("Motorista")) {
			if(motorista_.isEmpty()) {
				
			}else {
				for(int i = 0; i < motorista_.size(); i++) {
					modelo_id.addElement(motorista_.get(i).getId_motorista());
					modelo_nome.addElement(motorista_.get(i).getNome());
				}
			}
			
			
			lista_id.setModel(modelo_id);
			lista_nome.setModel(modelo_nome);
		}else {
			if(cargo.equalsIgnoreCase("Cobrador")) {
				if(cobrador_.isEmpty()) {
					
				}else {
					for(int i = 0; i < cobrador_.size(); i++) {
						modelo_id.addElement(cobrador_.get(i).getId_cobrador());
						modelo_nome.addElement(cobrador_.get(i).getNome());
					}
				}
				
				
				lista_id.setModel(modelo_id);
				lista_nome.setModel(modelo_nome);
			}else {
				if(fiscal_.isEmpty()) {
					
				}else {
					for(int i = 0; i < fiscal_.size(); i++) {
						modelo_id.addElement(fiscal_.get(i).getId_fiscal());
						modelo_nome.addElement(fiscal_.get(i).getNome());
					}
				}
				
				
				lista_id.setModel(modelo_id);
				lista_nome.setModel(modelo_nome);
			}
		}
		
		
		
		
	}
	
	public void carregarLista_orgRota(JList lista_id, JList lista_onibus) {
		DefaultListModel modelo_id = new DefaultListModel();
		
		DefaultListModel modelo_placa = new DefaultListModel();
		
		Onibusdao dao = new Onibusdao();
		dao.read();
		Rotasdao daoo = new Rotasdao();
		daoo.read();
		
		
		if(rotas_.isEmpty()) {
			
		}else {
			for(int i = 0; i < rotas_.size(); i++) {
				
				StringBuffer id = new StringBuffer();
				id.append(rotas_.get(i).getId_rota());
				
				String id_rota = id.toString();
				modelo_id.addElement(id_rota);
			}
		}
		
		if(onibus_.isEmpty()) {
			
		}else {
			for(int i = 0; i < onibus_.size(); i++) {
				modelo_placa.addElement(onibus_.get(i).getPlaca());
			}
			
		}
		
		lista_id.setModel(modelo_id);
		lista_onibus.setModel(modelo_placa);
		
	}
	
	public void carregarLista_orgFunci(JList lista_id, JList lista_nome, JList lista_cargo, JList lista_onibus) {
		
		DefaultListModel modelo_id = new DefaultListModel();
		DefaultListModel modelo_nome = new DefaultListModel();
		DefaultListModel modelo_cargo = new DefaultListModel();
		DefaultListModel modelo_placa = new DefaultListModel();
		
		Motoristadao dao = new Motoristadao();
		dao.read();
		Cobradordao daoo = new Cobradordao();
		daoo.read();
		Fiscaldao daooo = new Fiscaldao();
		daooo.read();
		Onibusdao daoooo = new Onibusdao();
		daoooo.read();
		
		for(int i = 0; i < motorista_.size(); i++) {
			
			modelo_id.addElement(motorista_.get(i).getId_motorista());
			modelo_nome.addElement(motorista_.get(i).getNome() );
			modelo_cargo.addElement(motorista_.get(i).getCargo());
		}
		
		for(int i = 0; i < cobrador_.size(); i++) {
			
			modelo_id.addElement(cobrador_.get(i).getId_cobrador());
			modelo_nome.addElement(cobrador_.get(i).getNome() );
			modelo_cargo.addElement(cobrador_.get(i).getCargo());
		}
		
		for(int i = 0; i < fiscal_.size(); i++) {
			
			modelo_id.addElement(fiscal_.get(i).getId_fiscal());
			modelo_nome.addElement(fiscal_.get(i).getNome() );
			modelo_cargo.addElement(fiscal_.get(i).getCargo());
		}
		

		if(onibus_.isEmpty()) {
			
		}else {
			for(int i = 0; i < onibus_.size(); i++) {
				modelo_placa.addElement(onibus_.get(i).getPlaca());
			}
			
		}
		lista_id.setModel(modelo_id);
		lista_nome.setModel(modelo_nome);
		lista_cargo.setModel(modelo_cargo);
		lista_onibus.setModel(modelo_placa);
		
	}
	
	public void carregarTable(String tipo) {
		
		DefaultTableModel dtmFuncionarios = new DefaultTableModel();
		
		if(tipo.equalsIgnoreCase("")) {
			table.setModel(dtmFuncionarios);
			
		}else {
			if(tipo.equalsIgnoreCase("Funcionarios")) {
				
				dtmFuncionarios.addColumn("Nome");
				dtmFuncionarios.addColumn("CPF");
				dtmFuncionarios.addColumn("Idade");
				dtmFuncionarios.addColumn("CNH");
				dtmFuncionarios.addColumn("Telefone");
				dtmFuncionarios.addColumn("Salário");
				dtmFuncionarios.addColumn("Cargo");
				dtmFuncionarios.addRow(new String[] {"Nome", "CPF", "Idade", "CNH", "Telefone", "Salário","Cargo"});
				
				
				Motoristadao dao = new Motoristadao();
				dao.read();
				Cobradordao daoo = new Cobradordao();
				daoo.read();
				Fiscaldao daooo = new Fiscaldao();
				daooo.read();
				
				if(motorista_.isEmpty() == false) {
					for(int i = 0; i < motorista_.size(); i++) {
						
						StringBuffer idade = new StringBuffer();
						StringBuffer salario = new StringBuffer();
						
						idade.append(motorista_.get(i).getIdade());
						salario.append(motorista_.get(i).getSalario());
						
						
						String auxiliar = idade.toString();
						String auxiliar2 = salario.toString();
						
						dtmFuncionarios.addRow(new String[] {motorista_.get(i).getNome(), motorista_.get(i).getCpf(), auxiliar, motorista_.get(i).getCnh(), motorista_.get(i).getTelefone(), auxiliar2, motorista_.get(i).getCargo()});
						
					}
					
				}
				
				if(cobrador_.isEmpty() == false) {
					
					for(int i = 0; i < cobrador_.size(); i++) {
						
						StringBuffer idade = new StringBuffer();
						StringBuffer salario = new StringBuffer();
						idade.append(cobrador_.get(i).getIdade());
						salario.append(cobrador_.get(i).ajuste_salario());
						String auxiliar = idade.toString();
						String auxiliar2 = salario.toString();
						dtmFuncionarios.addRow(new String[] {cobrador_.get(i).getNome(), cobrador_.get(i).getCpf(), auxiliar, "S/CNH", cobrador_.get(i).getTelefone(), auxiliar2, cobrador_.get(i).getCargo()});
						
					}
					
				}
				
				if(fiscal_.isEmpty() == false) {
					for(int i = 0; i < fiscal_.size(); i++) {
						
						StringBuffer idade = new StringBuffer();
						StringBuffer salario = new StringBuffer();
						idade.append(fiscal_.get(i).getIdade());
						salario.append(fiscal_.get(i).ajuste_salario());
						String auxiliar = idade.toString();
						String auxiliar2 = salario.toString();
						dtmFuncionarios.addRow(new String[] {fiscal_.get(i).getNome(), fiscal_.get(i).getCpf(), auxiliar, "S/CNH", fiscal_.get(i).getTelefone(), auxiliar2, fiscal_.get(i).getCargo()});
						
					}
					
				}
				
				table.setModel(dtmFuncionarios);
			}
			
			if(tipo.equalsIgnoreCase("Onibus")) {
				dtmFuncionarios.addColumn("Placa");
				dtmFuncionarios.addColumn("Motorista");
				dtmFuncionarios.addColumn("Cobrador");
				dtmFuncionarios.addColumn("Fiscal");

				dtmFuncionarios.addRow(new String[] {"Placa", "Motorista", "Cobrador", "Fiscal"});
				
				Onibusdao dao = new Onibusdao();
				dao.read();
				
				for(int i = 0; i < onibus_.size(); i++) {
					dtmFuncionarios.addRow(new String[] {onibus_.get(i).getPlaca(), onibus_.get(i).getMotorista(), onibus_.get(i).getCobrador(), onibus_.get(i).getFiscal()});
				}
				
				table.setModel(dtmFuncionarios);
			}
			
			if(tipo.equalsIgnoreCase("Rotas")) {
				
				dtmFuncionarios.addColumn("ID_Rota");
				dtmFuncionarios.addColumn("Origem");
				dtmFuncionarios.addColumn("Destino");
				dtmFuncionarios.addColumn("Onibus");

				dtmFuncionarios.addRow(new String[] {"ID_Rota", "Origem", "Destino", "Onibus"});
				
				Rotasdao dao = new Rotasdao();
				dao.read();
				
				for(int i = 0; i < rotas_.size(); i++) {
					
					StringBuffer id_rota = new StringBuffer();
					
					id_rota.append(rotas_.get(i).getId_rota() );
					String auxiliar = id_rota.toString();
					
					dtmFuncionarios.addRow(new String[] {auxiliar, rotas_.get(i).getOrigem() , rotas_.get(i).getDestino() , rotas_.get(i).getOnibus()});
				}
				
				table.setModel(dtmFuncionarios);
			}
			
		}	
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.EmpresaDeOnibus.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public TelaPrincipal() {
		initialize();
	}

	private void initialize() {
		
		EmpresaDeOnibus = new JFrame();
		EmpresaDeOnibus.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\images\\journey_120px.png"));
		EmpresaDeOnibus.getContentPane().setBackground(Color.WHITE);
		EmpresaDeOnibus.setTitle("Empresa de Onibus");
		EmpresaDeOnibus.setBounds(100, 100, 1041, 620);
		EmpresaDeOnibus.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		EmpresaDeOnibus.setResizable(false);
		EmpresaDeOnibus.setLocationRelativeTo(null);
		EmpresaDeOnibus.getContentPane().setLayout(null);
		
		
		JLabel lbl_minimizar = new JLabel("");
		lbl_minimizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_minimizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			EmpresaDeOnibus.setState(Frame.ICONIFIED);
			}
		});
		
		JLabel lbl_NomeEmpresa = new JLabel("Avia\u00E7\u00E3o Batista");
		lbl_NomeEmpresa.setForeground(Color.WHITE);
		lbl_NomeEmpresa.setFont(new Font("Arial", Font.PLAIN, 20));
		lbl_NomeEmpresa.setBounds(113, 48, 159, 98);
		EmpresaDeOnibus.getContentPane().add(lbl_NomeEmpresa);
		
		JLabel Logo = new JLabel("");
		Logo.setIcon(new ImageIcon("src\\images\\journey_48px.png"));
		Logo.setBounds(48, 56, 55, 69);
		EmpresaDeOnibus.getContentPane().add(Logo);
		
		JLabel lblNewLabel_7 = new JLabel("___________________________________");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setBounds(30, 125, 264, 14);
		EmpresaDeOnibus.getContentPane().add(lblNewLabel_7);
		
		lbl_minimizar.setBounds(992, 0, 25, 25);
		EmpresaDeOnibus.getContentPane().add(lbl_minimizar);
		
		
		JLabel lblclose = new JLabel("");
		lblclose.setIcon(new ImageIcon("src\\images\\close_window_32pxss.png"));
		lblclose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblclose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
		lblclose.setBounds(1014, 0, 29, 23);	
		EmpresaDeOnibus.getContentPane().add(lblclose);
		
		JPanel panel_abstract = new JPanel();
		panel_abstract.setBounds(312, 170, 729, 26);
		panel_abstract.setBackground(new Color(111, 89, 222));
		EmpresaDeOnibus.getContentPane().add(panel_abstract);
		
		JTabbedPane central_Pane = new JTabbedPane(JTabbedPane.TOP);
		central_Pane.setBackground(Color.WHITE);
		central_Pane.setBounds(312, 173, 729, 448);
		EmpresaDeOnibus.getContentPane().add(central_Pane);
		
		JPanel panel_home = new JPanel();
		panel_home.setBackground(Color.WHITE);
		panel_home.setLayout(null);
		central_Pane.addTab("", null, panel_home, null);
		
		JLabel lbl_logo_1_1 = new JLabel("");
		lbl_logo_1_1.setIcon(new ImageIcon("src\\images\\journey_120px.png"));
		lbl_logo_1_1.setForeground(new Color(55, 33, 89));
		lbl_logo_1_1.setFont(new Font("Arial", Font.PLAIN, 31));
		lbl_logo_1_1.setBounds(309, 117, 147, 120);
		panel_home.add(lbl_logo_1_1);
		
		JLabel lblAviaoBatista_1_1 = new JLabel("Avia\u00E7\u00E3o Batista");
		lblAviaoBatista_1_1.setForeground(new Color(55, 33, 89));
		lblAviaoBatista_1_1.setFont(new Font("Arial", Font.PLAIN, 31));
		lblAviaoBatista_1_1.setBounds(258, 248, 251, 60);
		panel_home.add(lblAviaoBatista_1_1);
		
		JPanel panel_contratar = new JPanel();
		panel_contratar.setLayout(null);
		panel_contratar.setBackground(Color.WHITE);
		central_Pane.addTab("New tab", null, panel_contratar, null);
		
		JLabel lblcnh = new JLabel("CNH");
		lblcnh.setVisible(false);
		
		JLabel lbl_n = new JLabel("Preenchimento Obrigat\u00F3rio");
		lbl_n.setVisible(false);
		lbl_n.setFont(new Font("Tahoma", Font.BOLD, 9));
		lbl_n.setForeground(Color.RED);
		lbl_n.setBounds(71, 106, 167, 14);
		panel_contratar.add(lbl_n);
		
		JLabel lbl_car = new JLabel("Preenchimento Obrigat\u00F3rio");
		lbl_car.setVisible(false);
		lbl_car.setForeground(Color.RED);
		lbl_car.setFont(new Font("Tahoma", Font.BOLD, 9));
		lbl_car.setBounds(549, 108, 167, 14);
		panel_contratar.add(lbl_car);
		
		JLabel lbl_i = new JLabel("Preenchimento Obrigat\u00F3rio");
		lbl_i.setVisible(false);
		lbl_i.setForeground(Color.RED);
		lbl_i.setFont(new Font("Tahoma", Font.BOLD, 9));
		lbl_i.setBounds(557, 205, 167, 14);
		panel_contratar.add(lbl_i);
		
		JLabel lbl_c = new JLabel("Preenchimento Obrigat\u00F3rio");
		lbl_c.setVisible(false);
		lbl_c.setForeground(Color.RED);
		lbl_c.setFont(new Font("Tahoma", Font.BOLD, 9));
		lbl_c.setBounds(71, 205, 167, 14);
		panel_contratar.add(lbl_c);
		
		JLabel lbl_t = new JLabel("Preenchimento Obrigat\u00F3rio");
		lbl_t.setVisible(false);
		lbl_t.setForeground(Color.RED);
		lbl_t.setFont(new Font("Tahoma", Font.BOLD, 9));
		lbl_t.setBounds(363, 205, 167, 14);
		panel_contratar.add(lbl_t);
		
		JLabel lbl_cn = new JLabel("Preenchimento Obrigat\u00F3rio");
		lbl_cn.setVisible(false);
		lbl_cn.setForeground(Color.RED);
		lbl_cn.setFont(new Font("Tahoma", Font.BOLD, 9));
		lbl_cn.setBounds(283, 292, 167, 14);
		panel_contratar.add(lbl_cn);
		lblcnh.setBounds(248, 272, 25, 14);
		panel_contratar.add(lblcnh);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String cargo = (String) comboBox.getSelectedItem();
				if(cargo.equalsIgnoreCase("Motorista")) {
					text_cnh.setVisible(true);
					lblcnh.setVisible(true);
				}else {
					text_cnh.setVisible(false);
					lblcnh.setVisible(false);
				}
			}
		});
		
		text_cnh = new JTextField();
		text_cnh.setVisible(false);
		
		text_name = new JTextField();
		text_name.setHorizontalAlignment(SwingConstants.LEFT);
		text_name.setBounds(71, 84, 197, 20);
		panel_contratar.add(text_name);
		text_name.setColumns(10);
		
		
		text_cnh.setBounds(283, 269, 167, 20);
		panel_contratar.add(text_cnh);
		text_cnh.setColumns(10);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Motorista", "Cobrador", "Fiscal"}));
		comboBox.setEditable(true);
		comboBox.setBounds(584, 83, 93, 22);
		panel_contratar.add(comboBox);
		
		text_cpf = new JTextField();
		text_cpf.setBounds(71, 182, 167, 20);
		panel_contratar.add(text_cpf);
		text_cpf.setColumns(10);
		
		text_telefone = new JTextField();
		text_telefone.setBounds(363, 182, 128, 20);
		panel_contratar.add(text_telefone);
		text_telefone.setColumns(10);
		
		JLabel lbl_nome = new JLabel("Nome");
		lbl_nome.setBounds(36, 87, 35, 14);
		panel_contratar.add(lbl_nome);
		
		JLabel lblcpf = new JLabel("CPF");
		lblcpf.setBounds(36, 185, 25, 14);
		panel_contratar.add(lblcpf);
		
		JLabel lbltel = new JLabel("Telefone");
		lbltel.setBounds(295, 185, 58, 14);
		panel_contratar.add(lbltel);
		
		text_idade = new JTextField();
		text_idade.setBounds(631, 182, 46, 20);
		panel_contratar.add(text_idade);
		text_idade.setColumns(10);
		
		JLabel lblidade = new JLabel("Idade");
		lblidade.setBounds(586, 185, 35, 14);
		panel_contratar.add(lblidade);
		
		JLabel lblcargo = new JLabel("Cargo");
		lblcargo.setBounds(539, 87, 35, 14);
		panel_contratar.add(lblcargo);
		
		JButton btn_Contratar = new JButton("Contratar");
		btn_Contratar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				lbl_n.setVisible(false);
				lbl_t.setVisible(false);
				lbl_c.setVisible(false);
				lbl_cn.setVisible(false);
				lbl_car.setVisible(false);
				
				String cargo = (String) comboBox.getSelectedItem();
				
				String auxiliar;
				auxiliar = "";
				
				if(cargo.equalsIgnoreCase("") == false) {
					
					if(auxiliar.equalsIgnoreCase(text_name.getText())) {
						lbl_n.setVisible(true);
					}
					if(auxiliar.equalsIgnoreCase(text_telefone.getText())) {
						lbl_t.setVisible(true);
					}
					if(auxiliar.equalsIgnoreCase(text_cpf.getText())) {
						lbl_c.setVisible(true);
					}
					if(auxiliar.equalsIgnoreCase(text_idade.getText())) {
						lbl_i.setVisible(true);
					}
					
					if(cargo.equalsIgnoreCase("Motorista")) {
						
						if(auxiliar.equalsIgnoreCase(text_cnh.getText())) {
							lbl_cn.setVisible(true);
						}else {
							if(cargo.equalsIgnoreCase("Motorista")) {
								int idade = Integer.parseInt(text_idade.getText());
								String cargoo = "Motorista";
								
								Motorista motorista = new Motorista(text_name.getText(),text_cpf.getText(),idade,text_cnh.getText(),text_telefone.getText(), salario_minimo, cargoo);
								
								Motoristadao dao = new Motoristadao();
								Motoristabean m = new Motoristabean();
								
								m.setId_motorista(motorista.getId_motorista());
								m.setNome(motorista.getNome());
								m.setCpf(motorista.getCpf());
								m.setIdade(motorista.getIdade());
								m.setCnh(motorista.getCnh());
								m.setTelefone(motorista.getTelefone());
								m.setSalario(motorista.getSalario());
								m.setCargo(motorista.getCargo());
								dao.create(m);
								
								
								
								text_name.setText("");
								text_cpf.setText("");
								text_idade.setText("");
								text_telefone.setText("");
								text_cnh.setText("");
								
							}
						}
					}
					
					if(cargo.equalsIgnoreCase("Cobrador")){
						
						int idade = Integer.parseInt(text_idade.getText());
						String cargoo = "Cobrador";
						
						Cobrador cobrador = new Cobrador(text_name.getText(),text_cpf.getText(), idade,text_telefone.getText(), (float) salario_minimo, cargoo);
						
						
						Cobradordao dao = new Cobradordao();
						Cobradorbean c = new Cobradorbean();
						
						c.setId_cobrador(cobrador.getId_cobrador());
						c.setNome(cobrador.getNome());
						c.setCpf(cobrador.getCpf());
						c.setIdade(cobrador.getIdade());
						c.setTelefone(cobrador.getTelefone());
						c.setSalario((float) cobrador.getSalario());
						c.setCargo(cobrador.getCargo());
						dao.create(c);
						
						text_name.setText("");
						text_cpf.setText("");
						text_idade.setText("");
						text_telefone.setText("");
						
					}
					
					if(cargo.equalsIgnoreCase("Fiscal")) {
						int idade = Integer.parseInt(text_idade.getText());
						String cargoo = "Fiscal";
						Fiscal fiscal = new Fiscal(text_name.getText(),text_cpf.getText(), idade,text_telefone.getText(), (float) salario_minimo, cargoo);
	
						
						Fiscaldao dao = new Fiscaldao();
						Fiscalbean f = new Fiscalbean();
						
						f.setId_fiscal(fiscal.getId_fiscal());
						f.setNome(fiscal.getNome());
						f.setCpf(fiscal.getCpf());
						f.setIdade(fiscal.getIdade());
						f.setTelefone(fiscal.getTelefone());
						f.setSalario((float) fiscal.getSalario());
						f.setCargo(fiscal.getCargo());
						dao.create(f);
						
						text_name.setText("");
						text_cpf.setText("");
						text_idade.setText("");
						text_telefone.setText("");
					
					}
													
				}else {
					String auxiliarr = "";
					lbl_car.setVisible(true);
					
					if(auxiliarr.equalsIgnoreCase(text_name.getText())) {
						lbl_n.setVisible(true);
					}
					if(auxiliarr.equalsIgnoreCase(text_telefone.getText())) {
						lbl_t.setVisible(true);
					}
					if(auxiliarr.equalsIgnoreCase(text_cpf.getText())) {
						lbl_c.setVisible(true);
					}
					if(auxiliarr.equalsIgnoreCase(text_idade.getText())) {
						lbl_i.setVisible(true);
					}
				}
			}
		});
		
		btn_Contratar.setBounds(307, 348, 89, 23);
		panel_contratar.add(btn_Contratar);
		
		JPanel panel_organizacao = new JPanel();
		panel_organizacao.setBackground(Color.WHITE);
		panel_organizacao.setLayout(null);
		central_Pane.addTab("", null, panel_organizacao, null);
		
		JList list_cargo = new JList();
		list_cargo.setVisible(false);
		
		JLabel lbl_cargo = new JLabel("Cargo");
		lbl_cargo.setVisible(false);
		lbl_cargo.setBounds(265, 68, 35, 14);
		panel_organizacao.add(lbl_cargo);
		list_cargo.setBounds(234, 93, 77, 301);
		panel_organizacao.add(list_cargo);
		
		JLabel lbl_title1 = new JLabel("\u00D4nibus => Rota");
		lbl_title1.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_title1.setBounds(10, 0, 104, 35);
		panel_organizacao.add(lbl_title1);
		
		JLabel lbl_title2 = new JLabel("Funcion\u00E1rios => \u00D4nibus");
		lbl_title2.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_title2.setBounds(569, 0, 155, 35);
		panel_organizacao.add(lbl_title2);
		
		JList list_1 = new JList();
		list_1.setVisible(false);
		list_1.setModel(new AbstractListModel() {
			String[] values = new String[] {""};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list_1.setBounds(20, 93, 63, 301);
		panel_organizacao.add(list_1);
		
		JList list_2 = new JList();
		list_2.setVisible(false);
		list_2.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list_2.setBounds(93, 93, 131, 301);
		panel_organizacao.add(list_2);
		
		JLabel lbl_op2_id = new JLabel("ID");
		lbl_op2_id.setVisible(false);
		lbl_op2_id.setBounds(45, 68, 11, 14);
		panel_organizacao.add(lbl_op2_id);
		
		JLabel lbl_op2_nome = new JLabel("Nome");
		lbl_op2_nome.setVisible(false);
		lbl_op2_nome.setBounds(140, 68, 35, 14);
		panel_organizacao.add(lbl_op2_nome);
		
		JList list_op11 = new JList();
		list_op11.setVisible(false);
		list_op11.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list_op11.setBounds(420, 93, 63, 301);
		panel_organizacao.add(list_op11);
		
		JLabel lbl_fixo = new JLabel("Placa do \u00D4nibus");
		lbl_fixo.setVisible(false);
		lbl_fixo.setBounds(410, 69, 95, 14);
		panel_organizacao.add(lbl_fixo);
		
		JList list_op1 = new JList();
		list_op1.setVisible(false);
		list_op1.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list_op1.setBounds(321, 93, 57, 301);
		panel_organizacao.add(list_op1);
		
		JLabel lbl_op1_id = new JLabel("ID_Rota");
		lbl_op1_id.setVisible(false);
		lbl_op1_id.setBounds(310, 68, 46, 14);
		panel_organizacao.add(lbl_op1_id);
		
		textid = new JTextField();
		textid.setVisible(false);
		textid.setBackground(Color.WHITE);
		textid.setBounds(556, 222, 120, 23);
		panel_organizacao.add(textid);
		textid.setColumns(10);
		
		textplaca = new JTextField();
		textplaca.setVisible(false);
		textplaca.setBackground(Color.WHITE);
		textplaca.setBounds(556, 153, 120, 20);
		panel_organizacao.add(textplaca);
		textplaca.setColumns(10);
		
		JLabel lbl_text1 = new JLabel("Placa do \u00D4nibus");
		lbl_text1.setVisible(false);
		lbl_text1.setBounds(556, 128, 102, 14);
		panel_organizacao.add(lbl_text1);
		
		JLabel lbl_text2 = new JLabel("ID");
		lbl_text2.setVisible(false);
		lbl_text2.setBounds(556, 197, 89, 14);
		panel_organizacao.add(lbl_text2);
		
		JLabel lblNewLabel_5 = new JLabel("Preenchimento Obrigat\u00F3rio");
		lblNewLabel_5.setVisible(false);
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblNewLabel_5.setBounds(554, 176, 139, 14);
		panel_organizacao.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Preenchimento Obrigat\u00F3rio");
		lblNewLabel_6.setVisible(false);
		lblNewLabel_6.setForeground(Color.RED);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblNewLabel_6.setBounds(554, 253, 139, 14);
		panel_organizacao.add(lblNewLabel_6);
		
		
		JButton btn_escalar = new JButton("Escalar");
		btn_escalar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String auxiliar = "";
				String auxiliar2;
				int auxiliar3;
				String auxiliar4;
				
				
				
				Motoristadao dao = new Motoristadao();
				dao.read();
				Cobradordao daoo = new Cobradordao();
				daoo.read();
				Fiscaldao daooo = new Fiscaldao();
				daooo.read();
				Onibusdao daoooo = new Onibusdao();
				daoooo.read();
				
				Rotasdao daooooo = new Rotasdao();
				daooooo.read();
				
				
				if(auxiliar.equalsIgnoreCase(textplaca.getText())) {
					lblNewLabel_5.setVisible(true);
					if(auxiliar.equalsIgnoreCase(textid.getText())) {
						lblNewLabel_6.setVisible(true);
						
					}
				}
				
				if(auxiliar.equalsIgnoreCase(textplaca.getText()) == false) {
					if(auxiliar.equalsIgnoreCase(textid.getText()) == false) {
						
						if(list_2.isVisible()) {
							
							auxiliar2 = textplaca.getText();
							auxiliar4 = textid.getText();
							
							for(int i = 0; i < onibus_.size(); i++) {
								if(auxiliar2.equalsIgnoreCase(onibus_.get(i).getPlaca())) {
									
									for(int j = 0; j < motorista_.size();j++) {
										
										if(auxiliar4.equalsIgnoreCase(motorista_.get(j).getId_motorista())) {
											onibus_.get(i).setMotorista(auxiliar4);
											
											Onibusbean o = new Onibusbean();
											o.setPlaca(onibus_.get(i).getPlaca());
											o.setMotorista(onibus_.get(i).getMotorista());
											o.setCobrador(onibus_.get(i).getCobrador());
											o.setFiscal(onibus_.get(i).getFiscal());
											daoooo.update(o);
											
											
											
										}
									}
									
									for(int j = 0; j < fiscal_.size();j++) {
										if(auxiliar4.equalsIgnoreCase(fiscal_.get(j).getId_fiscal())) {
											onibus_.get(i).setFiscal(auxiliar4);
											
											Onibusbean o = new Onibusbean();
											o.setPlaca(onibus_.get(i).getPlaca());
											o.setMotorista(onibus_.get(i).getMotorista());
											o.setCobrador(onibus_.get(i).getCobrador());
											o.setFiscal(onibus_.get(i).getFiscal());
											daoooo.update(o);
										}
									}
									
									for(int j = 0; j < cobrador_.size();j++) {
										if(auxiliar4.equalsIgnoreCase(cobrador_.get(j).getId_cobrador())) {
											onibus_.get(i).setCobrador(auxiliar4);
											
											Onibusbean o = new Onibusbean();
											o.setPlaca(onibus_.get(i).getPlaca());
											o.setMotorista(onibus_.get(i).getMotorista());
											o.setCobrador(onibus_.get(i).getCobrador());
											o.setFiscal(onibus_.get(i).getFiscal());
											daoooo.update(o);
										}
									}
									
								}
							}
							textid.setText("");
							textplaca.setText("");
						}else {
							
							auxiliar3 = Integer.parseInt(textid.getText());
							
							for(int i = 0; i < rotas_.size(); i++) {
								int aux = rotas_.get(i).getId_rota();
								if(auxiliar3 == aux) {
									rotas_.get(i).setOnibus(textplaca.getText());
									
									Rotasbean r = new Rotasbean();
									
									r.setOrigem(rotas_.get(i).getOrigem());
									r.setDestino(rotas_.get(i).getDestino());
									r.setOnibus(rotas_.get(i).getOnibus());
									r.setId_rota(rotas_.get(i).getId_rota());
									daooooo.update(r);
									
									textid.setText("");
									textplaca.setText("");
								}
							}
							
							
						}
					}
				}
				
			}
		});
		
		btn_escalar.setVisible(false);
		btn_escalar.setBounds(569, 278, 89, 23);
		panel_organizacao.add(btn_escalar);
		
		JButton btn_escalar2 = new JButton("Listar");
		btn_escalar2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String auxiliar = "";
				if(auxiliar.equalsIgnoreCase(textplaca.getText())) {
					lblNewLabel_5.setVisible(true);
				}
				if(auxiliar.equalsIgnoreCase(textid.getText())) {
					lblNewLabel_6.setVisible(true);
				}
				lblNewLabel_6.setVisible(false);
				lblNewLabel_5.setVisible(false);
				lbl_op1_id.setVisible(false);
				lbl_fixo.setVisible(false);
				list_op1.setVisible(false);
				list_op11.setVisible(false);
				lbl_text1.setVisible(false);
				lbl_text2.setVisible(false);
				textplaca.setVisible(false);
				textid.setVisible(false);
				btn_escalar.setVisible(false);
				
				textplaca.setText("");
				textid.setText("");
				
				carregarLista_orgFunci(list_1,list_2,list_cargo,list_op11);
				
				lbl_op2_id.setVisible(true);
				lbl_op2_nome.setVisible(true);
				lbl_fixo.setVisible(true);
				list_1.setVisible(true);
				list_2.setVisible(true);
				list_cargo.setVisible(true);
				lbl_cargo.setVisible(true);
				list_op11.setVisible(true);
				lbl_text1.setVisible(true);
				lbl_text2.setText("ID");
				lbl_text2.setVisible(true);
				textplaca.setVisible(true);
				textid.setVisible(true);
				btn_escalar.setVisible(true);
			}
		});
		btn_escalar2.setBounds(604, 35, 89, 23);
		panel_organizacao.add(btn_escalar2);
		
		JButton btn_escalar1 = new JButton("Listar");
		btn_escalar1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String auxiliar = "";
				if(auxiliar.equalsIgnoreCase(textplaca.getText())) {
					lblNewLabel_5.setVisible(true);
				}
				if(auxiliar.equalsIgnoreCase(textid.getText())) {
					lblNewLabel_6.setVisible(true);
					
				}
				lblNewLabel_6.setVisible(false);
				lblNewLabel_5.setVisible(false);
				lbl_op2_id.setVisible(false);
				lbl_op2_nome.setVisible(false);
				lbl_fixo.setVisible(false);
				list_1.setVisible(false);
				list_2.setVisible(false);
				list_op11.setVisible(false);
				lbl_text1.setVisible(false);
				lbl_text2.setVisible(false);
				textplaca.setVisible(false);
				textid.setVisible(false);
				btn_escalar.setVisible(false);
				list_cargo.setVisible(false);
				lbl_cargo.setVisible(false);
				
				carregarLista_orgRota(list_op1,list_op11);
				lbl_op1_id.setVisible(true);
				lbl_fixo.setVisible(true);
				list_op1.setVisible(true);
				list_op11.setVisible(true);
				lbl_text1.setVisible(true);
				lbl_text2.setText("ID da Rota");
				lbl_text2.setVisible(true);
				textplaca.setVisible(true);
				textid.setVisible(true);
				btn_escalar.setVisible(true);
			}
		});
		btn_escalar1.setBounds(10, 35, 95, 23);
		panel_organizacao.add(btn_escalar1);
		central_Pane.setBackgroundAt(2, Color.WHITE);
		central_Pane.setBackgroundAt(2, Color.WHITE);
		
		JPanel panel_rotas = new JPanel();
		panel_rotas.setLayout(null);
		panel_rotas.setBackground(Color.WHITE);
		central_Pane.addTab("New tab", null, panel_rotas, null);
		
		text_origem = new JTextField();
		text_origem.setBounds(145, 123, 139, 20);
		panel_rotas.add(text_origem);
		text_origem.setColumns(10);
		
		JLabel lbl_origem = new JLabel("Origem");
		lbl_origem.setBounds(146, 98, 46, 14);
		panel_rotas.add(lbl_origem);
		
		text_destino = new JTextField();
		text_destino.setBounds(364, 123, 139, 20);
		panel_rotas.add(text_destino);
		text_destino.setColumns(10);
		
		JLabel lbl_destino = new JLabel("Destino");
		lbl_destino.setBounds(364, 98, 46, 14);
		panel_rotas.add(lbl_destino);
		
		JLabel lbl_o = new JLabel("Preenchimento Obrigat\u00F3rio");
		lbl_o.setVisible(false);
		lbl_o.setForeground(Color.RED);
		lbl_o.setFont(new Font("Tahoma", Font.BOLD, 9));
		lbl_o.setBounds(146, 154, 150, 14);
		panel_rotas.add(lbl_o);
		
		JLabel lbl_d = new JLabel("Preenchimento Obrigat\u00F3rio");
		lbl_d.setVisible(false);
		lbl_d.setForeground(Color.RED);
		lbl_d.setFont(new Font("Tahoma", Font.BOLD, 9));
		lbl_d.setBounds(364, 154, 150, 14);
		panel_rotas.add(lbl_d);
		
		JLabel lbl_rota = new JLabel("ID Rota");
		lbl_rota.setBounds(221, 221, 46, 14);
		panel_rotas.add(lbl_rota);
		
		JLabel lbl_id = new JLabel("Preenchimento Obrigat\u00F3rio");
		lbl_id.setVisible(false);
		lbl_id.setForeground(Color.RED);
		lbl_id.setFont(new Font("Tahoma", Font.BOLD, 9));
		lbl_id.setBounds(280, 246, 150, 14);
		panel_rotas.add(lbl_id);
		
		
		
		text_id = new JTextField();
		text_id.setBounds(280, 218, 86, 20);
		panel_rotas.add(text_id);
		text_id.setColumns(10);
		
		
		JButton btn_cad = new JButton("Cadastrar");
		btn_cad.setBounds(280, 302, 103, 23);
		panel_rotas.add(btn_cad);
		
		btn_cad.addMouseListener(new MouseAdapter() {
			String auxiliar = "";
			@Override
			public void mouseClicked(MouseEvent e) {
				lbl_o.setVisible(false);
				lbl_d.setVisible(false);
				lbl_id.setVisible(false);
				
				if(auxiliar.equalsIgnoreCase(text_destino.getText())) {
					lbl_d.setVisible(true);
					
				}
				if(auxiliar.equalsIgnoreCase(text_origem.getText())) {
						lbl_o.setVisible(true);
				}
				
				if(auxiliar.equalsIgnoreCase(text_id.getText())) {
							lbl_id.setVisible(true);
				}
				
				if(auxiliar.equalsIgnoreCase(text_destino.getText()) == false) {
					
					if(auxiliar.equalsIgnoreCase(text_origem.getText()) == false) {
						if(auxiliar.equalsIgnoreCase(text_id.getText()) == false) {
							
							int id_rotas = Integer.parseInt(text_id.getText());
							
							Rotas rota = new Rotas(text_origem.getText(), text_destino.getText(), id_rotas);
							
							Rotasdao dao = new Rotasdao();
							Rotasbean r = new Rotasbean();
							
							r.setId_rota(rota.getId_rota());
							r.setOrigem(rota.getOrigem());
							r.setDestino(rota.getDestino());
							
							dao.create(r);
							
							text_origem.setText("");
							text_destino.setText("");
							text_id.setText("");
							
						}
					}
				}
				
			}
		});
		
		JPanel panel_add_bus = new JPanel();
		panel_add_bus.setBackground(Color.WHITE);
		panel_add_bus.setLayout(null);
		central_Pane.addTab("", null, panel_add_bus, null);
		
		new JTextField();
		
		text_placa = new JTextField();
		text_placa.setBounds(303, 148, 128, 20);
		panel_add_bus.add(text_placa);
		text_placa.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Placa");
		lblNewLabel.setBounds(305, 123, 46, 14);
		panel_add_bus.add(lblNewLabel);
		
		
		JLabel lbl_p = new JLabel("Preenchimento Obrigat\u00F3rio");
		lbl_p.setVisible(false);
		lbl_p.setForeground(Color.RED);
		lbl_p.setFont(new Font("Tahoma", Font.BOLD, 9));
		lbl_p.setBounds(303, 175, 167, 14);
		panel_add_bus.add(lbl_p);
		
		JButton button_cad = new JButton("Cadastrar");
		button_cad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String auxiliar = "";
				
				lbl_p.setVisible(false);

				
				if(auxiliar.equalsIgnoreCase(text_placa.getText())) {
					lbl_p.setVisible(true);
				}else {
					Onibus onibus = new Onibus(text_placa.getText());
					
					Onibusdao dao = new Onibusdao();
					Onibusbean o = new Onibusbean();
					
					o.setPlaca(onibus.getPlaca());					
			
					dao.create(o);
					
					text_placa.setText("");
				}
			}
		});
		button_cad.setBounds(316, 307, 104, 23);
		panel_add_bus.add(button_cad);
		
		JPanel panel_relatorio = new JPanel();
		panel_relatorio.setLayout(null);
		panel_relatorio.setBackground(Color.WHITE);
		central_Pane.addTab("New tab", null, panel_relatorio, null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"nome", "cpf", "idade", "cnh", "telefone", "salario","cargo",
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(141);
		table.getColumnModel().getColumn(1).setPreferredWidth(93);
		table.getColumnModel().getColumn(2).setPreferredWidth(39);
		table.getColumnModel().getColumn(3).setPreferredWidth(88);
		table.getColumnModel().getColumn(4).setPreferredWidth(90);
		table.getColumnModel().getColumn(5).setPreferredWidth(63);
		table.getColumnModel().getColumn(6).setPreferredWidth(43);
		table.setSize(new Dimension(600, 800));
		table.setBounds(0, 22, 724, 398);
		table.setLayout(null);
		table.setVisible(true);
		panel_relatorio.add(table);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String auxiliar = (String) comboBox_1.getSelectedItem();
				if(auxiliar.equalsIgnoreCase("")) {
					carregarTable(auxiliar);
				}else {
					carregarTable(auxiliar);
				}
			}
		});
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"", "Funcionarios", "Onibus", "Rotas"}));
		comboBox_1.setBounds(609, 0, 115, 22);
		panel_relatorio.add(comboBox_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(-3, 0, 615, 22);
		panel_relatorio.add(panel);
		panel.setBackground(new Color(57,40,92));
		
		JPanel panel_demissao = new JPanel();
		panel_demissao.setLayout(null);
		panel_demissao.setBackground(Color.WHITE);
		central_Pane.addTab("New tab", null, panel_demissao, null);
		
		JLabel lbl_comboBox = new JLabel("Preenchimento Obrigat\u00F3rio");
		lbl_comboBox.setVisible(false);
		lbl_comboBox.setFont(new Font("Tahoma", Font.BOLD, 9));
		lbl_comboBox.setForeground(Color.RED);
		lbl_comboBox.setBounds(564, 58, 160, 14);
		panel_demissao.add(lbl_comboBox);
		
		JList list_id = new JList();
		list_id.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list_id.setBounds(142, 95, 59, 237);
		panel_demissao.add(list_id);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(161, 70, 16, 14);
		panel_demissao.add(lblNewLabel_1);
		
		JList list_nome = new JList();
		list_nome.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list_nome.setBounds(252, 95, 155, 237);
		panel_demissao.add(list_nome);
		
		JComboBox comboBox_demissao = new JComboBox();
		comboBox_demissao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cargo = (String) comboBox_demissao.getSelectedItem();
				carregarLista_demissao(list_id,list_nome, cargo);
				list_nome.setVisible(true);
				
			}
		});
		comboBox_demissao.setModel(new DefaultComboBoxModel(new String[] {"", "Motorista", "Fiscal", "Cobrador"}));
		comboBox_demissao.setBounds(591, 30, 89, 22);
		panel_demissao.add(comboBox_demissao);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("NOME");
		lblNewLabel_2.setBounds(304, 70, 46, 14);
		panel_demissao.add(lblNewLabel_2);
		
		text_id_demissao = new JTextField();
		text_id_demissao.setBounds(280, 374, 100, 20);
		panel_demissao.add(text_id_demissao);
		text_id_demissao.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("ID do funcion\u00E1rio:");
		lblNewLabel_3.setBounds(142, 377, 128, 14);
		panel_demissao.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Preenchimento Obrigat\u00F3rio");
		lblNewLabel_4.setVisible(false);
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblNewLabel_4.setBounds(280, 395, 150, 14);
		panel_demissao.add(lblNewLabel_4);
		
		JButton btnNewButton_5 = new JButton("Demitir");
		
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String cargo = (String) comboBox_demissao.getSelectedItem();
				String auxiliar = "";
				
				Motoristadao dao = new Motoristadao();
				dao.read();
				Cobradordao daoo = new Cobradordao();
				daoo.read();
				Fiscaldao daooo = new Fiscaldao();
				daooo.read();
				
				lblNewLabel_4.setVisible(false);
				lbl_comboBox.setVisible(false);
				
				if(auxiliar.equalsIgnoreCase(text_id_demissao.getText())) {
					lblNewLabel_4.setVisible(true);
					
					if(auxiliar.equalsIgnoreCase(cargo)) {
						lbl_comboBox.setVisible(true);
					}
				}
				
				if(cargo.equalsIgnoreCase("Motorista")) {
					for(int i = 0; i < motorista_.size(); i++) {
						String aux = text_id_demissao.getText();
						if(aux.equalsIgnoreCase(motorista_.get(i).getId_motorista())) {
							Motoristabean m = new Motoristabean();

							m.setId_motorista(motorista_.get(i).getId_motorista());
							dao.delete(m);
							motorista_.remove(i);
							
							
							
							text_id_demissao.setText("");
						}
					}
				}
				if(cargo.equalsIgnoreCase("Cobrador")) {
					for(int i = 0; i < cobrador_.size(); i++) {
						String aux = text_id_demissao.getText();
						if(aux.equalsIgnoreCase(cobrador_.get(i).getId_cobrador())) {
							
							Cobradorbean c = new Cobradorbean();

							c.setId_cobrador(cobrador_.get(i).getId_cobrador());
							daoo.delete(c);
							cobrador_.remove(i);
							text_id_demissao.setText("");
						}
					}
				}
				if(cargo.equalsIgnoreCase("Fiscal")) {
					for(int i = 0; i < fiscal_.size(); i++) {
						String aux = text_id_demissao.getText();
						if(aux.equalsIgnoreCase(fiscal_.get(i).getId_fiscal())) {
							Fiscalbean f = new Fiscalbean();

							f.setId_fiscal(fiscal_.get(i).getId_fiscal());
							daooo.delete(f);
							
							fiscal_.remove(i);
							text_id_demissao.setText("");
						}
					}
				}
					
					
				
				
			}
		});
		btnNewButton_5.setBounds(440, 373, 89, 23);
		panel_demissao.add(btnNewButton_5);
		
		
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_1.setBackground(new Color(85, 65, 118));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_1.setBackground(new Color(57, 40, 92));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				central_Pane.removeAll();
				central_Pane.add(panel_home);
				central_Pane.repaint();
				central_Pane.revalidate();
			}
		});
		
		panel_1.setBounds(0, 185, 312, 63);
		EmpresaDeOnibus.getContentPane().add(panel_1);
		panel_1.setBackground(new Color(57, 40, 92));
		panel_1.setLayout(null);
		
		
		JLabel lbl_home = new JLabel("");
		lbl_home.setIcon(new ImageIcon("src\\images\\home_18px.png"));
		lbl_home.setBounds(29, 0, 18, 63);
		panel_1.add(lbl_home);
		
		JLabel lblhome = new JLabel("Home");
		lblhome.setFont(new Font("Arial", Font.PLAIN, 17));
		lblhome.setForeground(Color.WHITE);
		lblhome.setBounds(79, 11, 59, 41);
		panel_1.add(lblhome);
		
		JPanel panel_5 = new JPanel();
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_5.setBackground(new Color(85, 65, 118));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_5.setBackground(new Color(57, 40, 92));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				central_Pane.removeAll();
				central_Pane.add(panel_rotas);
				central_Pane.repaint();
				central_Pane.revalidate();
			}
		});
		
		panel_2 = new JPanel();
		panel_2.setBounds(0, 248, 312, 63);
		EmpresaDeOnibus.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2.setBackground(new Color(85, 65, 118));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2.setBackground(new Color(57, 40, 92));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				central_Pane.removeAll();
				central_Pane.add(panel_contratar);
				central_Pane.repaint();
				central_Pane.revalidate();
			}
		});
		panel_2.setBackground(new Color(57, 40, 92));
		
		JLabel lbl_folder = new JLabel("");
		lbl_folder.setIcon(new ImageIcon("src\\images\\new_copy_18px.png"));
		lbl_folder.setBounds(28, 11, 23, 41);
		panel_2.add(lbl_folder);
		
		JLabel lblContratar = new JLabel("Contratar");
		lblContratar.setForeground(Color.WHITE);
		lblContratar.setFont(new Font("Arial", Font.PLAIN, 17));
		lblContratar.setBounds(79, 11, 100, 41);
		panel_2.add(lblContratar);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 310, 312, 63);
		EmpresaDeOnibus.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_3.setBackground(new Color(85, 65, 118));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_3.setBackground(new Color(57, 40, 92));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				central_Pane.removeAll();
				central_Pane.add(panel_organizacao);
				central_Pane.repaint();
				central_Pane.revalidate();
			}
		});
		panel_3.setBackground(new Color(57, 40, 92));
		
		JLabel lbl_folder_1 = new JLabel("");
		lbl_folder_1.setIcon(new ImageIcon("src\\images\\mind_map_18px.png"));
		lbl_folder_1.setBounds(29, 11, 23, 41);
		panel_3.add(lbl_folder_1);
		
		JLabel lblOrganizao = new JLabel("Organiza\u00E7\u00E3o");
		lblOrganizao.setForeground(Color.WHITE);
		lblOrganizao.setFont(new Font("Arial", Font.PLAIN, 17));
		lblOrganizao.setBounds(78, 11, 100, 41);
		panel_3.add(lblOrganizao);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 373, 312, 63);
		EmpresaDeOnibus.getContentPane().add(panel_4);
		panel_4.setBackground(new Color(57, 40, 92));
		panel_4.setLayout(null);
		
		panel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_4.setBackground(new Color(85, 65, 118));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_4.setBackground(new Color(57, 40, 92));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				central_Pane.removeAll();
				central_Pane.add(panel_add_bus);
				central_Pane.repaint();
				central_Pane.revalidate();
			}
		});
		panel_4.setBackground(new Color(57, 40, 92));
		panel_4.setLayout(null);
		
		
		JLabel lbl_cadastrar = new JLabel("");
		lbl_cadastrar.setBounds(29, 0, 18, 63);
		lbl_cadastrar.setIcon(new ImageIcon("src\\images\\bus_18px.png"));
		panel_4.add(lbl_cadastrar);
		
		JLabel lblcadastrar = new JLabel("Cadastrar \u00D4nibus");
		lblcadastrar.setBounds(79, 11, 152, 41);
		lblcadastrar.setForeground(Color.WHITE);
		lblcadastrar.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_4.add(lblcadastrar);
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(57, 40, 92));
		panel_5.setBounds(0, 435, 312, 63);
		EmpresaDeOnibus.getContentPane().add(panel_5);
		
		JLabel lbl_bus = new JLabel("");
		lbl_bus.setIcon(new ImageIcon("src\\images\\road_18px.png"));
		lbl_bus.setBounds(29, 11, 23, 41);
		panel_5.add(lbl_bus);
		
		JLabel lblRotas = new JLabel("Rotas");
		lblRotas.setForeground(Color.WHITE);
		lblRotas.setFont(new Font("Arial", Font.PLAIN, 17));
		lblRotas.setBounds(79, 11, 100, 41);
		panel_5.add(lblRotas);
		
		JPanel panel_6 = new JPanel();
		panel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_6.setBackground(new Color(85, 65, 118));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_6.setBackground(new Color(57, 40, 92));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				String auxiliar = (String) comboBox_1.getSelectedItem();
					
				carregarTable(auxiliar);
				
				
				central_Pane.removeAll();
				central_Pane.add(panel_relatorio);
				central_Pane.repaint();
				central_Pane.revalidate();
			}
		});
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(57, 40, 92));
		panel_6.setBounds(0, 497, 312, 63);
		EmpresaDeOnibus.getContentPane().add(panel_6);
		
		JLabel lbl_relatorio = new JLabel("");
		lbl_relatorio.setIcon(new ImageIcon("src\\images\\file_invoice_18px.png"));
		lbl_relatorio.setBounds(29, 11, 23, 41);
		panel_6.add(lbl_relatorio);
		
		JLabel lblrelatorio = new JLabel("Relat\u00F3rio");
		lblrelatorio.setForeground(Color.WHITE);
		lblrelatorio.setFont(new Font("Arial", Font.PLAIN, 17));
		lblrelatorio.setBounds(79, 11, 100, 41);
		panel_6.add(lblrelatorio);
		
		JPanel panel_7 = new JPanel();
		panel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_7.setBackground(new Color(85, 65, 118));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_7.setBackground(new Color(57, 40, 92));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				central_Pane.removeAll();
				central_Pane.add(panel_demissao);
				central_Pane.repaint();
				central_Pane.revalidate();
			}
		});
		panel_7.setBounds(0, 558, 312, 63);
		EmpresaDeOnibus.getContentPane().add(panel_7);
		panel_7.setLayout(null);
		panel_7.setBackground(new Color(57, 40, 92));
		
		JLabel lbl_demitir = new JLabel("");
		lbl_demitir.setIcon(new ImageIcon("src\\images\\import_18px.png"));
		lbl_demitir.setBounds(30, 11, 23, 41);
		panel_7.add(lbl_demitir);
		
		JLabel lbldemitir = new JLabel("Demiss\u00E3o");
		lbldemitir.setForeground(Color.WHITE);
		lbldemitir.setFont(new Font("Arial", Font.PLAIN, 17));
		lbldemitir.setBounds(79, 11, 100, 41);
		panel_7.add(lbldemitir);
		
		
		JLabel lblmodel2 = new JLabel("");
		lblmodel2.setIcon(new ImageIcon("src\\images\\segundatela.jpg"));
		lblmodel2.setBounds(0, 0, 1041, 620);
		EmpresaDeOnibus.getContentPane().add(lblmodel2);
		EmpresaDeOnibus.setUndecorated(true);
	
	}
}

