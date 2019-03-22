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
    	this.childs=new BinarySearchTree<CompanyNode>(); 
    }
    // TODO: la compagnie courante achete une autre compagnie
    // O(log(n))
    public void buy(CompanyNode item) {  	
    	if(childs!=null) 
    		this.childs.insert(item);
    	
    	money += item.getMoney();
    	if (item.worstChild.getMoney() < this.worstChild.getMoney())
    		this.worstChild = item.worstChild;
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
    public void fillStringBuilderInOrder(StringBuilder builder, String prefix) 
    {
		builder.append(prefix + money + "\n");	
		if(childs!=null )
		{
			List<BinaryNode<CompanyNode>>newList = childs.getItemsInOrder();
			for (BinaryNode<CompanyNode> node : newList)
				node.getData().fillStringBuilderInOrder(builder, prefix + " > ");
		}
    }
    // TODO: on override le comparateur pour defenir l'ordre
    @Override
    public int compareTo(CompanyNode item) {
        if (this.money > item.getMoney())
        	return -1; 
        else if (this.money < item.getMoney())
        	return 1;
        else 
        	return 0 ; 
    }
}