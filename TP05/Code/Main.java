import java.util.ArrayList;
import java.util.List;


public class Main {
	
	public static void main(String[] args) {
		Graph g = new Graph();
		
		
		// Partie 1: A completer : Création du graphe
		ArrayList<Node> nodes = new ArrayList<Node>();
		// Remplir les noeuds : A,B,C,D,E,F,G 
		Node A = new Node(0,"A");
		nodes.add(A);
		Node B = new Node(1,"B");
		nodes.add(B);
		Node C = new Node(2,"C");
		nodes.add(C);
		Node D = new Node(3,"D");
		nodes.add(D);
		Node E = new Node(4,"E");
		nodes.add(E);
		Node F = new Node(5,"F");
		nodes.add(F);
		Node G = new Node(6,"G");
		nodes.add(G);
		
		//Ecriture de la liste des noeuds dans 
		//l'instance g de la classe Graph.
		g.setNodes(nodes);
		
		//Creation de la liste des arcs : 
		ArrayList<Edge> edges = new ArrayList<Edge>();
		
		//Creation des arcs : 
		//Source node A : 
		Edge ab = new Edge(A,B,2);
		edges.add(ab);
		Edge ac = new Edge(A,C,1);
		edges.add(ac);

		//Source node B : 
		Edge ba = new Edge(B,A,2);
		edges.add(ba);
		Edge bc = new Edge(B,C,2);
		edges.add(bc);
		Edge bd = new Edge(B,D,1);
		edges.add(bd);
		Edge be = new Edge(B,E,3);
		edges.add(be);

		//Source node C :
		Edge ca = new Edge(C,A,1);
		edges.add(ca);
		Edge cb = new Edge(C,B,2);
		edges.add(cb);
		Edge cd = new Edge(C,D,4);
		edges.add(cd);
		Edge ce = new Edge(C,E,3);
		edges.add(ce);
		Edge cf = new Edge(C,F,5);
		edges.add(cf);
		//Source node D : 
		Edge db = new Edge(D,B,1);
		edges.add(db);
		Edge dc = new Edge(D,C,4);
		edges.add(dc);
		Edge df = new Edge(D,F,6);
		edges.add(df);
		Edge dg = new Edge(D,G,5);
		edges.add(dg);
		//Source node E : 
		Edge eb = new Edge(E,B,3);
		edges.add(eb);
		Edge ec = new Edge(E,C,3);
		edges.add(ec);
		Edge ef = new Edge(E,f,1);
		edges.add(ef);

		//Source node F :
		Edge fc = new Edge(F,C,5);
		edges.add(fc);
		Edge fe = new Edge(F,E,1);
		edges.add(fe);
		Edge fd = new Edge(F,D,6);
		edges.add(fd);
		Edge fg = new Edge(F,G,2);
		edges.add(fg);
		//Source node G : 
		Edge gf = new Edge(G,F,2);
		edges.add(gf);
		Edge gd = new Edge(G,D,5);
		edges.add(gd);
		
		//Ajouter a la liste des arcs dans l'instance g : 
		g.setEdges(edges);
		
		// Partie 2: A completer : Implémentation de l'algorithme Dijkstra
		
		Dijkstra d = new Dijkstra(g);
		
		d.findPath(/* Spécifiez les paramètres */);
		
		d.afficherTable();

		// Partie 3 : Afficher le chemin le plus court
		System.out.println(d.afficherCourtChemin(/* SpÃ©cifiez les paramÃ¨tres */));
	
	}
}
