package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Persistentes.Rotas;
import Telas.TelaPrincipal;
import connection.BancoDeDados;
import model.bean.Rotasbean;

public class Rotasdao {
	public void create(Rotasbean r){
		Connection con = BancoDeDados.getConnection();
		PreparedStatement stmt = null;
	
		try {
			stmt = con.prepareStatement("INSERT INTO rota (id_rota,origem,destino,onibus) VALUES(?,?,?,?)");
			stmt.setInt(1, r.getId_rota());
			stmt.setString(2, r.getOrigem());
			stmt.setString(3, r.getDestino());
			stmt.setString(4, r.getOnibus());
			

			
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			System.out.println("Erro ao salvar! " + e);
		}finally {
			BancoDeDados.closeConnection(con, stmt);
		}
	}
	
	public void read() {
		TelaPrincipal.rotas_.clear();
		
		Connection con = BancoDeDados.getConnection();
		PreparedStatement stmt = null;
		
		ResultSet rs = null;
		
		try {
			stmt = con.prepareStatement("SELECT * FROM rota");
			rs = stmt.executeQuery();
			
			
			while(rs.next()) {
				
				Rotas r = new Rotas(rs.getString("origem"),rs.getString("destino") , rs.getInt("id_rota"));
				r.setOnibus(rs.getString("onibus"));
				
				
				TelaPrincipal.rotas_.add(r);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao salvar! " + e);
		}finally {
			BancoDeDados.closeConnection(con, stmt);
		}
		
	}
	
	public void update(Rotasbean r){
		Connection con = BancoDeDados.getConnection();
		PreparedStatement stmt = null;
	
		try {
			stmt = con.prepareStatement("UPDATE rota SET id_rota = ?,origem = ?,destino = ?,onibus = ? WHERE id_rota = ?");
			stmt.setInt(1, r.getId_rota());
			stmt.setString(2, r.getOrigem());
			stmt.setString(3, r.getDestino());
			stmt.setString(4, r.getOnibus());
			
			
			stmt.setInt(5, r.getId_rota());

			
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar! " + e);
		}finally {
			BancoDeDados.closeConnection(con, stmt);
		}
	}
	
	public void delete(Rotasbean r){
		Connection con = BancoDeDados.getConnection();
		PreparedStatement stmt = null;
	
		try {
			stmt = con.prepareStatement("DELETE FROM rota WHERE onibus = ?");
			stmt.setInt(1, r.getId_rota());
				
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			System.out.println("Erro ao deletar! " + e);
		}finally {
			BancoDeDados.closeConnection(con, stmt);
		}
	}
}
