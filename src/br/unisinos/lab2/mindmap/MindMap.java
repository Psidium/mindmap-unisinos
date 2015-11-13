package br.unisinos.lab2.mindmap;

/**
 *
 * @author Cássia
 * @param <E>
 */
public class MindMap<E> {
    protected String descricao;
    protected DNode<E> root;
    
    public void insert(DNode<E> daddy, MindMapInfo element){
        //do
        DNode<MindMapInfo> newNode = new DNode<>(element);
    }
    
    public void remove(MindMapInfo element){
        //do
    }
    
    public DNode<E> getElement(MindMapInfo element){
        //return pos
        return null;
    }
    
    public void insertSibling(DNode<E> daddy, MindMapInfo element){
        //do
    }
}
