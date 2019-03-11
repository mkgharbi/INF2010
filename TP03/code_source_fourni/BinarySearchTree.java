import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BinarySearchTree<T extends Comparable<? super T> > {

    private BinaryNode<T> root;

    public BinarySearchTree() { }

    // TODO: initialisation
    public BinarySearchTree(T item) {
    	root = new BinaryNode<T>(item);

    }

    // TODO: on insere un nouvel item a partir de la racine
    // O(log(n))
    public void insert(T item) {
    	root.insert(item);
    }

    // TODO: est-ce qu'un item fais partie de l'arbre
    // O(log(n))
    public boolean contains(T item) {

        if(item==null)
        {
        	return false;
        }
        else
        {
        	return root.contains(item);
        }
    }

    // TODO: trouver la hauteur de l'arbre
    // O(n)
    public int getHeight() {
        int height = root.getHeight();
        return height;
    }

    // TODO: placer dans une liste les items de l'arbre en ordre
    // O(n)
    public List<BinaryNode<T>> getItemsInOrder() {
        List<BinaryNode<T>> newList=new LinkedList<BinaryNode<T>>();
        root.fillListInOrder(newList);
        return newList;
    }

    // TODO: retourner la liste d'item en String selon le bon format
    // O(n)
    public String toStringInOrder() {
    	String stringOrdered= "[";
        List<BinaryNode<T>> newList = getItemsInOrder();
        for (int i=0; i<(newList.size()-1);i++)
        {
        	stringOrdered=newList.get(i).getData()+ ","+stringOrdered;
        	stringOrdered= newList.get(newList.size() -1).getData()+stringOrdered;
        }
        stringOrdered += "]";
        return  stringOrdered;
    }
}
