package model.dao;


import model.bean.Estoques;

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
    public void create(Estoques e){

    Connection con = ConnectionFactory.getConnection();
    
    
    PreparedStatement stmt = null;
    
        try {
            stmt = con.prepareCall("INSERT INTO estoque (id_material, nome_material, estoque_atual)VALUES(?,?,?)");
            
            stmt.setInt(1, e.getId_item());
            stmt.setString(2,e.getItem());
            stmt.setInt(3,e.getQuantidade());

            stmt.executeUpdate();
            
            // JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        
   
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt); 
        }
    
    }
    public List<Estoques> read(){
    
    
       Connection con = ConnectionFactory.getConnection();
       
       PreparedStatement stmt = null;
       ResultSet rs = null;
       
       List<Estoques> estoque = new ArrayList<>();
       
        try {
            stmt = con.prepareStatement("SELECT * FROM estoque");
            rs = stmt.executeQuery();
            
            while(rs.next()){
            Estoques _estoque = new Estoques();
            
            _estoque.setQuantidade(rs.getInt("id_material"));
            _estoque.setItem(rs.getString("nome_material"));
            _estoque.setQuantidade(rs.getInt("estoque_atual"));
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
    
    public List<Estoques> readForDesc(String desc) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Estoques> estoque = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM estoque WHERE nome_material LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Estoques _estoque = new Estoques();
                
                _estoque.setId_item(rs.getInt("id_material"));
                _estoque.setItem(rs.getString("nome_material"));
                _estoque.setQuantidade(rs.getInt("estoque_atual"));
                estoque.add(_estoque);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return estoque;

    }
    public void update(Estoques e) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE estoque SET id_material = ?, nome_material = ? ,estoque_material = ?");
            
            stmt.setInt(1, e.getId_item());
            stmt.setString(2,e.getItem());
            stmt.setInt(3,e.getQuantidade());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    public void delete(Estoques e) {
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM estoque WHERE id_material = ?");
            stmt.setInt(1, e.getId_item());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
        
             
} // FINAL

