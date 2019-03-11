import java.util.List;

public class CompanyNode implements Comparable<CompanyNode> {
    private Integer money;
    private BinarySearchTree<CompanyNode> childs;
    public CompanyNode worstChild;

    // TODO: initialisation
    // O(1)
    public CompanyNode(Integer data) {
    	this.money=data;
    	this.worstChild=null;
    	this.childs= new BinarySearchTree<CompanyNode>(this);

    }

    // TODO: la compagnie courante achete une autre compagnie
    // O(log(n))
    public void buy(CompanyNode item) {
    	//Verification si l'item a ajouter n est pas NULL
    	if(item==null)
          return;
    	else 
    		this.childs.insert(item);
    	
    }

    // TODO: on retourne le montant en banque de la compagnie
    // O(1)
    public Integer getMoney() {
        return money;
    }

    // TODO: on rempli le builder de la compagnie et de ses enfants avec le format
    //A
    // > A1
    // > A2
    // >  > A21...
    // les enfants sont afficher du plus grand au plus petit (voir TestCompany.testPrint)
    // O(n)
    public void fillStringBuilderInOrder(StringBuilder builder, String prefix) {

    }

    // TODO: on override le comparateur pour defenir l'ordre
    @Override
    public int compareTo(CompanyNode item) {

        return this.money.compareTo(item.getMoney());
    }
}
