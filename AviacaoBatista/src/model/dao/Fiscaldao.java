package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Persistentes.Fiscal;
import Telas.TelaPrincipal;
import connection.BancoDeDados;
import model.bean.Fiscalbean;

public class Fiscaldao {
	public void create(Fiscalbean f){
		Connection con = BancoDeDados.getConnection();
		PreparedStatement stmt = null;
	
		try {
			stmt = con.prepareStatement("INSERT INTO fiscal (id_fiscal,nome,cpf,idade,telefone,salario,cargo) VALUES(?,?,?,?,?,?,?)");
			stmt.setString(1, f.getId_fiscal());
			stmt.setString(2, f.getNome());
			stmt.setString(3, f.getCpf());
			stmt.setInt(4, f.getIdade());
			stmt.setString(5, f.getTelefone());
			stmt.setFloat(6, f.getSalario());
			stmt.setString(7, f.getCargo());
			

			
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			System.out.println("Erro ao salvar! " + e);
		}finally {
			BancoDeDados.closeConnection(con, stmt);
		}
	}
	
	public void read() {
		TelaPrincipal.fiscal_.clear();
		
		Connection con = BancoDeDados.getConnection();
		PreparedStatement stmt = null;
		
		ResultSet rs = null;
		
		try {
			stmt = con.prepareStatement("SELECT * FROM motorista");
			rs = stmt.executeQuery();
			
			
			while(rs.next()) {
				
				Fiscal f = new Fiscal(rs.getString("nome"), rs.getString("cpf"), rs.getInt("idade"), rs.getString("telefone"), rs.getFloat("salario"), rs.getString("cargo"));
				f.setId_fiscal(rs.getString("id_fiscal"));
				
				TelaPrincipal.fiscal_.add(f);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao salvar! " + e);
		}finally {
			BancoDeDados.closeConnection(con, stmt);
		}
		
	}
	
	public void update(Fiscalbean f){
		Connection con = BancoDeDados.getConnection();
		PreparedStatement stmt = null;
	
		try {
			stmt = con.prepareStatement("UPDATE fiscal SET id_fiscal = ?, nome = ?,  cpf = ?, idade = ?, telefone = ?, salario = ?, cargo = ? WHERE id_fiscal = ?");
			stmt.setString(1, f.getId_fiscal());
			stmt.setString(2, f.getNome());
			stmt.setString(3, f.getCpf());
			stmt.setInt(4, f.getIdade());
			stmt.setString(5, f.getTelefone());
			stmt.setFloat(6, f.getSalario());
			stmt.setString(7, f.getCargo());
			
			
			stmt.setString(8, f.getId_fiscal());

			
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar! " + e);
		}finally {
			BancoDeDados.closeConnection(con, stmt);
		}
	}
	
	public void delete(Fiscalbean f){
		Connection con = BancoDeDados.getConnection();
		PreparedStatement stmt = null;
	
		try {
			stmt = con.prepareStatement("DELETE FROM fiscal WHERE id_fiscal = ?");
			stmt.setString(1, f.getId_fiscal());
	
			
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			System.out.println("Erro ao deletar " + e);
		}finally {
			BancoDeDados.closeConnection(con, stmt);
		}
	}
}
