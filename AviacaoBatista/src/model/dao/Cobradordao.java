package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Persistentes.Cobrador;
import Telas.TelaPrincipal;
import connection.BancoDeDados;
import model.bean.Cobradorbean;



public class Cobradordao {
	public void create(Cobradorbean c){
		Connection con = BancoDeDados.getConnection();
		PreparedStatement stmt = null;
	
		try {
			stmt = con.prepareStatement("INSERT INTO cobrador (id_cobrador,nome,cpf,idade,telefone,salario,cargo) VALUES(?,?,?,?,?,?,?)");
			stmt.setString(1, c.getId_cobrador());
			stmt.setString(2, c.getNome());
			stmt.setString(3, c.getCpf());
			stmt.setInt(4, c.getIdade());
			stmt.setString(5, c.getTelefone());
			stmt.setFloat(6, c.getSalario());
			stmt.setString(7, c.getCargo());

			
			stmt.executeUpdate();
			
		
		} catch (SQLException e) {
			System.out.println("Erro ao salvar! " + e);
		}finally {
			BancoDeDados.closeConnection(con, stmt);
		}
	}
	
	public void read() {
		TelaPrincipal.cobrador_.clear();
		
		Connection con = BancoDeDados.getConnection();
		PreparedStatement stmt = null;
		
		ResultSet rs = null;
		
		try {
			stmt = con.prepareStatement("SELECT * FROM motorista");
			rs = stmt.executeQuery();
			
			
			while(rs.next()) {
				
				Cobrador c = new Cobrador(rs.getString("nome"), rs.getString("cpf"), rs.getInt("idade"), rs.getString("telefone"), rs.getFloat("salario"), rs.getString("cargo"));
				c.setId_cobrador(rs.getString("id_cobrador"));
				
				TelaPrincipal.cobrador_.add(c);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao salvar! " + e);
		}finally {
			BancoDeDados.closeConnection(con, stmt);
		}
		
	}
	
	public void update(Cobradorbean c){
		Connection con = BancoDeDados.getConnection();
		PreparedStatement stmt = null;
	
		try {
			stmt = con.prepareStatement("DELETE FROM cobrador WHERE id_cobrador = ?");
			stmt.setString(1, c.getId_cobrador());
			

			
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar! " + e);
		}finally {
			BancoDeDados.closeConnection(con, stmt);
		}
	}
	
	public void delete(Cobradorbean c){
		Connection con = BancoDeDados.getConnection();
		PreparedStatement stmt = null;
	
		try {
			stmt = con.prepareStatement("DELETE FROM cobrador WHERE id_cobrador = ?");
			stmt.setString(1, c.getId_cobrador());
			
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			System.out.println("Erro ao deletar " + e);
		}finally {
			BancoDeDados.closeConnection(con, stmt);
		}
	}
	
}
