package TP1.StrcutresDeDonneesSequentielles;



public class Main {
public static void main(String[] args) {
	Sac<Integer> sac = new Sac<Integer>();
	System.out.println("le sac est vide ?" + sac.isEmpty());
	sac.push_back(55);
	sac.push_back(12);
	sac.push_back(-24);
	sac.push_front(7);
	System.out.println("Le sac est vide ? " + sac.isEmpty());

	sac.insertElementByIndex(2, 33);
	System.out.println(sac.getElementByIndex(2)==33);
	System.out.println(" 33 est la ?" + sac.isHere(33));
	System.out.println(sac.getElementByIndex(2)==12);
	System.out.println("33 est la ?" + sac.isHere(33));
	System.out.println("Le sac est vide ? " + sac.isEmpty());
	System.out.println("==END TESTS SAC==");
	//////////////////////////////////////////////////
	System.out.println("==END TESTS FILE==");
	Pile<Integer> pile = new Pile<Integer>();
	System.out.println("La pile est vide " + pile.isEmpty());
	pile.push(11);
	pile.push(123);
	pile.push(-55);
	System.out.println(pile.pop()==-55);
	System.out.println(pile.pop()==123);
	System.out.println("11 est la " + pile.isHere(11));
	System.out.println(pile.pop()==11);
	System.out.println("11 est la : " + pile.isHere(11));
	System.out.println("La pile est vide : " + pile.isEmpty());
	System.out.println("==END TESTS PILE==");
	///////////////////////////////////////////////////
	File<Integer> file = new File<Integer>();
	System.out.println("La File est vide ? " + file.isEmpty());
	file.push(11);
	file.push(123);
	file.push(-55);
	System.out.println(file.pop()==11);
	System.out.println(file.pop()==123);
	System.out.println("-55 est La ? " + file.isHere(-55));
	System.out.println(file.pop()==-55);
	System.out.println("-55 est la ? " + file.isHere(-55));
	System.out.println("La file est vide ? " + file.isEmpty());
}
}