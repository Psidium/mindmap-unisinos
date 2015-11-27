package br.unisinos.lab2.mindmap;

public class MindMapWriter<E> {
	private StringBuffer xml;
	private int currentStringIndex = 0;
	
	public void write(MindMap<E> mindMap) {
		DNode<E> root = mindMap.getRoot();
		String out = "<?xml version=\"1.0\"?>\n";
		out += makeInnerXML(root, 0);
		System.out.println(out);
		//TODO: MAKE WRITE THE XML STRING TO FILE
	}
	
	private String makeInnerXML(DNode <E> node, int tabNumber) {
		tabNumber += 1;
		String sNode = "<node>\n";
		E elem = node.getElement();
		sNode += "<"+elem.getClass().getSimpleName() +">\n"+elem.toString()+"\n</"+elem.getClass().getSimpleName()+">\n";
		
        DNode<E> nextSon = node.getSon();
        DNode<E> nextBrother = node.getBro();
        
        if (nextSon != null) {
        	sNode += sNode + makeInnerXML(nextSon, tabNumber) + "</node>\n";
        	if (nextBrother != null) {
        		return sNode + "</node>\n" + makeInnerXML(nextBrother, tabNumber);
        	} else {
        		return sNode + "</node>\n";
        	}
        } else {
        	if (nextBrother != null) {
        		return sNode + "</node>\n" + makeInnerXML(nextBrother, tabNumber); 
        	} else {
        		return sNode + "</node>\n";
        	}
        }
	}
}
