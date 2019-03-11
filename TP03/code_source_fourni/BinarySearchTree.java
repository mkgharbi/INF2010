import java.util.ArrayList;
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
        	return flase;
        }
        else
        {
        	return root.conatins(item);
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
        List<BinaryNode<T>>NewList=new LinkedList<BinaryNode<T>>();
        root.fillListInOrder(NewList);
        return NewList;
    }

    // TODO: retourner la liste d'item en String selon le bon format
    // O(n)
    public String toStringInOrder() {
    	string A="["
        List<BinaryNode<T>>NEWlist = getItemsInOrder();
        for (int k=0;k<(liste.size()-1);i++)
        {
        	A=NEWlist.get(i).getData()+ ","+A;
        	A= NEWlist.get(NEWlist.size() -1).getData()+A;
        }
        retrun A+="]";
    }
}
