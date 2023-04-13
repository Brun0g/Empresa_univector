package model.dao;


import model.bean.Estoque;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lari
 */
public class EstoqueDAO {
    public void create(Estoque e){

    Connection con = ConnectionFactory.getConnection();
    
    
    PreparedStatement stmt = null;
    
        try {
            stmt = con.prepareCall("INSERT INTO estoque (nome_material, estoque_atual)VALUES(?,?)");
            
     
            stmt.setString(1,e.getNome_material());
            stmt.setInt(2,e.getEstoque_atual());

            stmt.executeUpdate();
            
            // JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        
   
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt); 
        }
    
    }
    public List<Estoque> read(){
    
    
       Connection con = ConnectionFactory.getConnection();
       
       PreparedStatement stmt = null;
       ResultSet rs = null;
       
       List<Estoque> estoque = new ArrayList<>();
       
        try {
            stmt = con.prepareStatement("SELECT * FROM estoque");
            rs = stmt.executeQuery();
            
            while(rs.next()){
            Estoque _estoque = new Estoque();
            
            _estoque.setId_material(rs.getInt("id_material"));
            _estoque.setNome_material(rs.getString("nome_material"));
            _estoque.setEstoque_atual(rs.getInt("estoque_atual"));
            estoque.add(_estoque);
            
            //JOptionPane.showMessageDialog(null, "Salvo na lista com sucesso!");

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na lista!: "+ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return estoque;
    }
    
    public List<Estoque> readForDesc(String desc) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Estoque> estoque = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM estoque WHERE nome_material LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Estoque _estoque = new Estoque();
                
                _estoque.setId_material(rs.getInt("id_material"));
                _estoque.setNome_material(rs.getString("nome_material"));
                _estoque.setEstoque_atual(rs.getInt("estoque_atual"));
                estoque.add(_estoque);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return estoque;

    }
    public void update(Estoque e) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE estoque SET nome_material = ?, estoque_atual = ? WHERE id_material = ?");
            
     
            stmt.setString(1,e.getNome_material());
            stmt.setInt(2,e.getEstoque_atual());
            stmt.setInt(3, e.getId_material());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    public void delete(Estoque e) {
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM estoque WHERE id_material = ?");
            stmt.setInt(1, e.getId_material());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
        
             
} // FINAL

