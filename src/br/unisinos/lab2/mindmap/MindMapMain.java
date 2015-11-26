package br.unisinos.lab2.mindmap;

public final class MindMapMain {
	public static void main(String[] args) {
            MindMap<String> mm = new MindMap<>();
           
            mm.insert(null, "Pai1");
            mm.insert(mm.getElement("Pai1"), "Pai2");
            mm.insertSibling(mm.getElement("Pai1"), "Filho1Pai1");
            mm.insertSibling(mm.getElement("Pai1"), "Filho1Pai2");
            mm.insertSibling(mm.getElement("Pai1"), "Filho1Pai3");
            mm.insertSibling(mm.getElement("Pai2"), "Filho2Pai1");
            mm.insertSibling(mm.getElement("Pai2"), "Filho2Pai2");
            
            System.out.println(mm);
	}

}
