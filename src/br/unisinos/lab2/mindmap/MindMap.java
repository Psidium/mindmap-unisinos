package br.unisinos.lab2.mindmap;

/**
 *
 * @author Cassia
 * @param <E>
 */
public class MindMap<E> {
    private String descricao;
    private DNode<E> root;

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

    public void remove(E element){

    }

    public DNode<E> getElement(E element){
        
        return null;
    }

    private DNode<E> findNodeForElement(E element, DNode<E> node) {
        if (node.getElement().equals(element)) { //guard: if found, return it
            return node;
        }
        DNode<E> nextSon = node.getSon(); 
        if (nextSon != null) { //is there any son to look for? (I'm not a leaf)
            DNode<E> nodeSon = findNodeForElement(element, nextSon);
            if (node != null) { //did the element was in one of my sons?
                return node;
            } else { //no it wasn't, go to a brother
                DNode<E> nextBrother = nodeSon.getBro();
                if (nextBrother != null) {
                    return findNodeForElement(element, nextBrother);
                } else { //I don't have a brother and it wasn't in my sons
                    return null;
                }

            }
        } else { //I don't have a son, search for my brother
            DNode<E> nextBrother = node.getBro();
            if (nextBrother != null) {
                return findNodeForElement(element, nextBrother);
            } else { //I don't have a brother and it wasn't in my sons
                return null;
            }
        }
    }

    public void insertSibling(DNode<E> daddy, E element){
        insert(daddy, element);
    }
}
