package br.unisinos.lab2.mindmap;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MindMapWriter<E> {
	private StringBuffer xml;
	private int currentStringIndex = 0;
	
	public void write(MindMap<E> mindMap) throws IOException {
		DNode<E> root = mindMap.getRoot();
		String out = "<?xml version=\"1.0\"?>\n";
		out += makeInnerXML(root, 0);
		System.out.println(out);

                String path = "fileMindMapXml.xml";
                BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
                buffWrite.append(out);
                buffWrite.close();

	}
	
	private String makeInnerXML(DNode <E> node, int tabNumber) {
		tabNumber += 1;
		String sNode = "<node>\n";
		E elem = node.getElement();
		sNode += "<"+elem.getClass().getSimpleName() +">\n"+elem.toString()+"\n</"+elem.getClass().getSimpleName()+">\n";
		
        DNode<E> nextSon = node.getSon();
        DNode<E> nextBrother = node.getBro();
        
        if (nextSon != null) {
        	sNode += makeInnerXML(nextSon, tabNumber) + "</node>\n";
        	if (nextBrother != null) {
        		return sNode + "</node>\n" + makeInnerXML(nextBrother, tabNumber);
        	} else {
        		return sNode + "</node>";
        	}
        } else {
        	if (nextBrother != null) {
        		return sNode + "</node>\n" + makeInnerXML(nextBrother, tabNumber); 
        	} else {
        		return sNode;
        	}
        }
	}
}
