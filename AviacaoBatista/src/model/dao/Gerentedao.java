package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Persistentes.Gerente;
import Telas.Login;
import connection.BancoDeDados;
import model.bean.Gerentebean;

public class Gerentedao {
	
	public void create(Gerentebean g){
		Connection con = BancoDeDados.getConnection();
		PreparedStatement stmt = null;
	
		try {
			stmt = con.prepareStatement("INSERT INTO gerente (id_gerente,nome,cpf,idade,telefone,salario,cargo,senha) VALUES(?,?,?,?,?,?,?,?)");
			stmt.setString(1, g.getId_gerente());
			stmt.setString(2, g.getNome());
			stmt.setString(3, g.getCpf());
			stmt.setInt(4, g.getIdade());
			stmt.setString(5, g.getTelefone());
			stmt.setFloat(6, g.getSalario());
			stmt.setString(7, g.getCargo());
			stmt.setString(8, g.getSenha());
			
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			System.out.println("Erro ao salvar! " + e);
		}finally {
			BancoDeDados.closeConnection(con, stmt);
		}
	}
	public void read() {
		Login.gerente_.clear();
		
		Connection con = BancoDeDados.getConnection();
		PreparedStatement stmt = null;
		
		ResultSet rs = null;
		
		try {
			stmt = con.prepareStatement("SELECT * FROM gerente");
			rs = stmt.executeQuery();
			
			
			while(rs.next()) {
				
				Gerente g = new Gerente(rs.getString("id_gerente"),rs.getString("nome"), rs.getString("cpf"), rs.getInt("idade"), rs.getString("telefone"), rs.getFloat("salario"), rs.getString("senha"), rs.getString("cargo"));
				Login.gerente_.add(g);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao salvar! " + e);
		}finally {
			BancoDeDados.closeConnection(con, stmt);
		}
		
	}
}

