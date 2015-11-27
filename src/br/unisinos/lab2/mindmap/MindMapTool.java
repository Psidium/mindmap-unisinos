package br.unisinos.lab2.mindmap;

import java.text.ParseException;

import javax.swing.JOptionPane;

public final class MindMapTool {
	public static void main(String[] args) {
		MindMap<MindMapInfo> reg = new MindMap<MindMapInfo>(new MindMapInfo("Root"));
        int controle = 7;
        while(controle!=0) {
        	try {
	        	controle = Integer.parseInt(JOptionPane.showInputDialog("selecione a opção: \n"
	        			+ "1. Inserir nodo filho \n"
	        			+ "2. Pesquisar\n"
	        			+ "3. Remover\n"
	        			+ "4. Gravar\n"
	        			+ "5. Carregar\n"
	        			+ "0. Sair"));
        	} catch (NumberFormatException n) {
        		JOptionPane.showMessageDialog(null, "escreva um número válido");
        		controle = -1;
        	}
        	switch (controle) {
        	case 0:
        		break;
        	case 1:
        		
        		break;
        	case 2:
        		
        		break;
        	case 3:
        		
        		break;
        	case 4:
        		
        		break;
        	case 5:
        		
        		break;
        	}
        }
            
            
            
	}

}
