package br.unisinos.lab2.mindmap;

public class MindMapWriter<E> {
	private StringBuffer xml;
	private int currentStringIndex = 0;
	
	public void write(MindMap<E> mindMap) {
		DNode<E> root = mindMap.getRoot();
		xml = new StringBuffer("<?xml version=\"1.0\"?>\n");
		currentStringIndex = xml.length();
		makeInnerXML(root);
		System.out.println(xml);
	}
	
	private DNode<E> makeInnerXML(DNode <E> node) {
		xml.insert(currentStringIndex, "<node>\n</node>\n");
		currentStringIndex += 7;
		E elem = node.getElement();
		String toInsert = "<"+elem.getClass()+">\n"+elem.toString()+"\n</"+elem.getClass()+">\n";
		xml.insert(currentStringIndex, toInsert);
		currentStringIndex+= toInsert.length();
		
        DNode<E> nextSon = node.getSon();
        DNode<E> nextBrother = node.getBro();

        if (nextSon != null) { //is there any son to look for? (I'm not a leaf)
            DNode<E> nodeSon = makeInnerXML(nextSon);
            if (nodeSon != null) { //did the element was in one of my sons?
                return nodeSon;
            } else { //no it wasn't, go to a brother
                if (nextBrother != null) {
                    return makeInnerXML(nextBrother); 
                } else { //I don't have a brother and it wasn't in my sons
                    return null;
                }
            }
        } else { //I don't have a son, search for my brother
            if (nextBrother != null) {
                return makeInnerXML(nextBrother);
            } else { //I don't have a brother neither a son and I'm not it, return null
                return null;
            }
        }
	}
}
