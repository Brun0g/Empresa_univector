package model.dao;


import model.bean.Clientes;

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
 * @author Bruno
 */
public class ClientesDAO {
    public void create(Clientes c){

    Connection con = ConnectionFactory.getConnection();
    
    
    PreparedStatement stmt = null;
    
        try {
            stmt = con.prepareCall("INSERT INTO clientes (nome, endereco, telefone, email, cpf)VALUES(?,?,?,?,?)");
            
           
            stmt.setString(1,c.getNome());
            stmt.setString(2,c.getEndereco());
            stmt.setString(3,c.getTelefone());
            stmt.setString(4,c.getEmail());
            stmt.setString(5,c.getCpf());

            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        
   
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        
        }
    
    }
    public List<Clientes> read(){
    
    
       Connection con = ConnectionFactory.getConnection();
       
       PreparedStatement stmt = null;
       ResultSet rs = null;
       
       List<Clientes> clientes = new ArrayList<>();
       
        try {
            stmt = con.prepareStatement("SELECT * FROM clientes");
            rs = stmt.executeQuery();
            
            while(rs.next()){
            Clientes _cliente = new Clientes();
            
            _cliente.setId_clientes(rs.getInt("id_clientes"));
            _cliente.setNome(rs.getString("nome"));
            _cliente.setEndereco(rs.getString("endereco"));
            _cliente.setTelefone(rs.getString("telefone"));
            _cliente.setEmail(rs.getString("email"));
            _cliente.setCpf(rs.getString("cpf"));
            clientes.add(_cliente);
            
            JOptionPane.showMessageDialog(null, "Salvo na lista com sucesso!");

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorre um erro na lista!: "+ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return clientes;
    }
    
    public List<Clientes> readForDesc(String desc) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Clientes> clientes = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM clientes WHERE nome LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Clientes _cliente = new Clientes();

                _cliente.setId_clientes(rs.getInt("id_clientes"));
                _cliente.setNome(rs.getString("nome"));
                _cliente.setEndereco(rs.getString("endereco"));
                _cliente.setTelefone(rs.getString("telefone"));
                _cliente.setEmail(rs.getString("email"));
                _cliente.setCpf(rs.getString("cpf"));
                clientes.add(_cliente);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return clientes;

    }
    public void update(Clientes c) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE clientes SET nome = ? ,endereco = ? ,telefone = ? ,email = ? ,cpf = ? WHERE id_clientes = ?");

            stmt.setString(1,c.getNome());
            stmt.setString(2,c.getEndereco());
            stmt.setString(3,c.getTelefone());
            stmt.setString(4,c.getEmail());
            stmt.setString(5,c.getCpf());
            stmt.setInt(6, c.getId_clientes());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    public void delete(Clientes c) {
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM clientes WHERE id_clientes = ?");
            stmt.setInt(1, c.getId_clientes());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
        
             
} // FINAL

