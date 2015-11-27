/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisinos.lab2.mindmap;

/**
 *
 * @author C�ssia
 */
public class MindMapInfo {
    protected String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public MindMapInfo(String descript) {
    	this.description = descript;
    }
    
}
