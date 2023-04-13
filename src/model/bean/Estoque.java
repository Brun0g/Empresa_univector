/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.bean;

/**
 *
 * @author Lari
 */
public class Estoque {

    private int id_material;
    private String nome_material;
    private int estoque_atual;

    public int getId_material() {
        return id_material;
    }

    public void setId_material(int id_material) {
        this.id_material = id_material;
    }

    public String getNome_material() {
        return nome_material;
    }

    public void setNome_material(String nome_material) {
        this.nome_material = nome_material;
    }

    public int getEstoque_atual() {
        return estoque_atual;
    }

    public void setEstoque_atual(int estoque_atual) {
        this.estoque_atual = estoque_atual;
    }
    
    
}