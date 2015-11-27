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

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof MindMapInfo)) {
			return false;
		}
		return description.equals(((MindMapInfo) obj).getDescription());
	}

	@Override
	public String toString() {
		return description;
	}
    
    
}
