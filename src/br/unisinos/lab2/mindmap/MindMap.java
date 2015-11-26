package br.unisinos.lab2.mindmap;

/**
 *
 * @author C�ssia, Gabriel Borges, Gabriel Castro
 * @param <E>
 */
public class MindMap<E> {
    private String descricao;
    private DNode<E> root;
    
    //public String searchAll(){
    @Override
    public String toString(){
        String ret = null;
        DNode<E> searchDad = root;
        while(searchDad != null){
            ret += "+ " + searchDad.getElement() + ":\n     " + searchSons(searchDad,"") + "\n";
            searchDad = searchDad.getBro();
        }
        return ret;
    }
    
    public String searchSons(DNode<E> dad, String daddySons){
        DNode<E> sons = dad.getSon();
        while (sons != null){
            daddySons += "\n-" + sons.getElement() + ";";
            if(sons.getBro() != null)
                searchSons(sons.getBro(),"+ " + sons.getElement() + ":\n     " + daddySons);
            sons = sons.getBro();
        }
        return daddySons;
    }

    public void insert(DNode<E> daddy, E element){
        DNode<E> newNode = new DNode<>(element);
        DNode<E> insertable = daddy;
        DNode<E> sonOfInsertable = insertable.getSon();
        if (sonOfInsertable == null) {
            insertable.setSon(newNode);
        } else {
            insertable = getLastBrother(sonOfInsertable);
            insertable.setBro(newNode);
        }
    }

    private DNode<E> getLastBrother(DNode<E> node) {
        DNode<E> nextBrother = node.getBro();
        if (nextBrother == null) {
            return node;
        } else {
            return getLastBrother(nextBrother);
        }
    }

    public DNode<E> remove(E element){ //assuming that if I remove a trunk, the whole branch dies
    	return remove(element, root, root);
    }

    private DNode<E> remove(E element, DNode<E> referencerNode, DNode<E> elementNode) {
    	if (elementNode.getElement().equals(element)) { //guard: if it, delete everything to it
    		if(referencerNode.getBro().getElement().equals(elementNode.getElement())) {
    			referencerNode.setBro(elementNode.getBro());
    			//if this node is the last of brothers, the referencer becomes the last,
    			//if not, the brother of this will be his now
    		}
    		if(referencerNode.getSon().getElement().equals(elementNode.getElement())) {
    			referencerNode.setSon(elementNode.getBro());
    		}
    		purgeBranchStartingFrom(elementNode.getSon());
    		elementNode.setElement(null); //free element
    		elementNode.setSon(null);
    		elementNode.setBro(null); 
    		return elementNode;
        }

        DNode<E> nextSon = elementNode.getSon();
        DNode<E> nextBrother = elementNode.getBro();

        if (nextSon != null) { //is there any son to look for? (I'm not a leaf)
            DNode<E> nodeSon = remove(element, elementNode, nextSon);
            if (nodeSon != null) { //did the element was in one of my sons?
                return nodeSon;
            } else { //no it wasn't, go to a brother
                if (nextBrother != null) {
                    return remove(element, elementNode, nextBrother); 
                } else { //I don't have a brother and it wasn't in my sons
                    return null;
                }
            }
        } else { //I don't have a son, search for my brother
            if (nextBrother != null) {
                return remove(element, elementNode, nextBrother);
            } else { //I don't have a brother neither a son and I'm not it, return null
                return null;
            }
        }
    }
    
    private void purgeBranchStartingFrom(DNode<E> node) {
    	DNode<E> bro = node.getBro();
    	DNode<E> son = node.getSon();
    	node.setSon(null);
    	node.setBro(null);
    	node.setElement(null);
    	if (bro != null) {
    		purgeBranchStartingFrom(bro);
    	}
    	if (son != null) {
    		purgeBranchStartingFrom(son);
    	}
    }

    public DNode<E> getElement(E element){
        return findNodeForElement(element, root);
    }

    private DNode<E> findNodeForElement(E element, DNode<E> node) {
        if (node.getElement().equals(element)) { //guard: if found, return it
            return node;
        }

        DNode<E> nextSon = node.getSon();
        DNode<E> nextBrother = node.getBro();

        if (nextSon != null) { //is there any son to look for? (I'm not a leaf)
            DNode<E> nodeSon = findNodeForElement(element, nextSon);
            if (nodeSon != null) { //did the element was in one of my sons?
                return nodeSon;
            } else { //no it wasn't, go to a brother
                if (nextBrother != null) {
                    return findNodeForElement(element, nextBrother); 
                } else { //I don't have a brother and it wasn't in my sons
                    return null;
                }
            }
        } else { //I don't have a son, search for my brother
            if (nextBrother != null) {
                return findNodeForElement(element, nextBrother);
            } else { //I don't have a brother neither a son and I'm not it, return null
                return null;
            }
        }
    }

    public void insertSibling(DNode<E> brother, E element){
        getLastBrother(brother).setBro(new DNode<E>(element));
    }

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public DNode<E> getRoot() {
		return root;
	}

	public void setRoot(DNode<E> root) {
		this.root = root;
	}


    public MindMap(E firstElement, String description) {
        descricao = description;
        root = new DNode<E>(firstElement);
    }

    
}
