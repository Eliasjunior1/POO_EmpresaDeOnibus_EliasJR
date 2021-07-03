package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Persistentes.Onibus;
import Telas.TelaPrincipal;
import connection.BancoDeDados;
import model.bean.Onibusbean;

public class Onibusdao {
	public void create(Onibusbean o){
		Connection con = BancoDeDados.getConnection();
		PreparedStatement stmt = null;
	
		try {
			stmt = con.prepareStatement("INSERT INTO onibus (placa,motorista,cobrador,fiscal) VALUES(?,?,?,?)");
			stmt.setString(1, o.getPlaca());
			stmt.setString(2, o.getMotorista());
			stmt.setString(3, o.getCobrador());
			stmt.setString(4, o.getFiscal());
			

			
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			System.out.println("Erro ao salvar! " + e);
		}finally {
			BancoDeDados.closeConnection(con, stmt);
		}
	}
	
	public void read() {
		TelaPrincipal.onibus_.clear();
		
		Connection con = BancoDeDados.getConnection();
		PreparedStatement stmt = null;
		
		ResultSet rs = null;
		
		try {
			stmt = con.prepareStatement("SELECT * FROM onibus");
			rs = stmt.executeQuery();
			
			
			while(rs.next()) {
				
				Onibus o = new Onibus(rs.getString("placa"));
				o.setMotorista(rs.getString("motorista")); 
				o.setCobrador(rs.getString("cobrador")); 
				o.setFiscal(rs.getString("fiscal"));
				
				
				TelaPrincipal.onibus_.add(o);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao salvar! " + e);
		}finally {
			BancoDeDados.closeConnection(con, stmt);
		}
		
	}
	
	public void update(Onibusbean o){
		Connection con = BancoDeDados.getConnection();
		PreparedStatement stmt = null;
	
		try {
			stmt = con.prepareStatement("UPDATE onibus SET placa = ? ,motorista = ?,cobrador = ?,fiscal = ? WHERE placa = ?");
			stmt.setString(1, o.getPlaca());
			stmt.setString(2, o.getMotorista());
			stmt.setString(3, o.getCobrador());
			stmt.setString(4, o.getFiscal());
			
			
			stmt.setString(5, o.getPlaca());

			
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar! " + e);
		}finally {
			BancoDeDados.closeConnection(con, stmt);
		}
	}
	
	public void delete(Onibusbean o){
		Connection con = BancoDeDados.getConnection();
		PreparedStatement stmt = null;
	
		try {
			stmt = con.prepareStatement("DELETE FROM onibus WHERE placa = ?");
			stmt.setString(1, o.getPlaca());
			
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			System.out.println("Erro ao deletar " + e);
		}finally {
			BancoDeDados.closeConnection(con, stmt);
		}
	}
}
