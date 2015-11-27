package br.unisinos.lab2.mindmap;

import java.text.ParseException;

import javax.swing.JOptionPane;

public final class MindMapTool {
	public static void main(String[] args) {
		MindMap<MindMapInfo> mm = new MindMap<MindMapInfo>(new MindMapInfo("Root"));
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
        		String pai = JOptionPane.showInputDialog("Digite o nome do nodo pai (Root se nao tiver): ");
        		MindMapInfo info = new MindMapInfo(pai);
        		DNode<MindMapInfo> father = mm.getElement(info);
        		if (father == null) {
        			JOptionPane.showMessageDialog(null, "nodo pai nao encontrado");
        			continue;
        		}
        		String elem = JOptionPane.showInputDialog("Digite o nome do elemento que queres inserir: ");
        		MindMapInfo filho = new MindMapInfo(elem);
        		mm.insert(father, filho);
        		break;
        	case 2:
        		String enc = JOptionPane.showInputDialog("Digite o nome do nodo que queres encontrar: ");
        		MindMapInfo inf = new MindMapInfo(enc);
        		DNode<MindMapInfo> search = mm.getElement(inf);
        		if (search == null) {
        			JOptionPane.showMessageDialog(null, "Nada encontrado");
        			continue;
        		}
        		JOptionPane.showMessageDialog(null, "Encontrado");
        		break;
        	case 3:
        		String remove = JOptionPane.showInputDialog("Digite o nome do nodo que queres remover ");
        		MindMapInfo rem = new MindMapInfo(remove);
        		DNode<MindMapInfo> removed = mm.remove(rem);
        		if (removed == null) {
        			JOptionPane.showMessageDialog(null, "Elemento nao encontrado!");
        			continue;
        		}
        		JOptionPane.showMessageDialog(null, "Removido");
        		break;
        	case 4:
        		MindMapWriter<MindMapInfo> writer = new MindMapWriter<>();
        		try {
        			writer.write(mm);
        			JOptionPane.showMessageDialog(null, "Gravou com sucesso");
        		} catch (Exception e) {
        			JOptionPane.showMessageDialog(null, "Nao foi possivel gravar o arquivo: " + e.getLocalizedMessage());
        		}
        		break;
        	case 5:
        		MindMapReader<MindMapInfo> reader = new MindMapReader<>();
                        try {
                        reader.read();
                    } catch (Exception e) {
                    }
        		break;
        	}
        }
            
            
            
	}

}
