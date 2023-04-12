/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import model.bean.Estoques;
import connection.ConnectionFactory;
import java.sql.*;
import java.sql.PreparedStatement;

/**
 *
 * @author Lari
 */
public class EstoqueDAO {
    private Connection connection;
    String item;
    int quantidade;
    
    public EstoqueDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void adiciona(Estoques e){
        String sql = "INSERT INTO estoque(nome_material, estoque_atual) VALUES(?,?)";
        
        try{
            
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString (1, e.getItem());
            stmt.setInt (2, e.getQuantidade());
            
            stmt.execute();
            stmt.close();
        }
        catch(SQLException excecao){
            throw new RuntimeException(excecao);
        }
    }
}

