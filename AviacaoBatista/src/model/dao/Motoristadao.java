package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Persistentes.Motorista;
import Telas.TelaPrincipal;
import connection.BancoDeDados;
import model.bean.Motoristabean;

public class Motoristadao {
	
	public void create(Motoristabean m){
		Connection con = BancoDeDados.getConnection();
		PreparedStatement stmt = null;
	
		try {
			stmt = con.prepareStatement("INSERT INTO motorista (id_motorista,nome,cpf,idade,telefone,salario,cargo,cnh) VALUES(?,?,?,?,?,?,?,?)");
			stmt.setString(1, m.getId_motorista());
			stmt.setString(2, m.getNome());
			stmt.setString(3, m.getCpf());
			stmt.setInt(4, m.getIdade());
			stmt.setString(5, m.getTelefone());
			stmt.setFloat(6, m.getSalario());
			stmt.setString(7, m.getCargo());
			stmt.setString(8, m.getCnh());

			
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			System.out.println("Erro ao salvar! " + e);
		}finally {
			BancoDeDados.closeConnection(con, stmt);
		}
	}
	
	public void read() {
		TelaPrincipal.motorista_.clear();
		
		Connection con = BancoDeDados.getConnection();
		PreparedStatement stmt = null;
		
		ResultSet rs = null;
		
		try {
			stmt = con.prepareStatement("SELECT * FROM motorista");
			rs = stmt.executeQuery();
			
			
			while(rs.next()) {
				
				Motorista m = new Motorista(rs.getString("nome"), rs.getString("cpf"), rs.getInt("idade"), rs.getString("cnh"), rs.getString("telefone"), rs.getFloat("salario"), rs.getString("cargo"));
				m.setId_motorista(rs.getString("id_motorista"));
				
				TelaPrincipal.motorista_.add(m);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao salvar! " + e);
		}finally {
			BancoDeDados.closeConnection(con, stmt);
		}
		
	}
	
	public void update(Motoristabean m){
		Connection con = BancoDeDados.getConnection();
		PreparedStatement stmt = null;
	
		try {
			stmt = con.prepareStatement("UPDATE motorista SET id_motorista = ?, nome = ?,  cpf = ?, idade = ?, telefone = ?, salario = ?, cargo = ?, cnh = ? WHERE id_motorista = ?");
			stmt.setString(1, m.getId_motorista());
			stmt.setString(2, m.getNome());
			stmt.setString(3, m.getCpf());
			stmt.setInt(4, m.getIdade());
			stmt.setString(5, m.getTelefone());
			stmt.setFloat(6, m.getSalario());
			stmt.setString(7, m.getCargo());
			stmt.setString(8, m.getCnh());
			
			stmt.setString(9, m.getId_motorista());

			
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar! " + e);
		}finally {
			BancoDeDados.closeConnection(con, stmt);
		}
	}
	
	public void delete(Motoristabean m){
		Connection con = BancoDeDados.getConnection();
		PreparedStatement stmt = null;
	
		try {
			stmt = con.prepareStatement("DELETE FROM motorista WHERE id_motorista = ?");
			stmt.setString(1, m.getId_motorista());
			
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar! " + e);
		}finally {
			BancoDeDados.closeConnection(con, stmt);
		}
	}
}

