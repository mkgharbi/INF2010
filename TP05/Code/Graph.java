import java.util.ArrayList;
import java.util.List;

public class Graph {

	private List<Node> nodes; // Noeuds
	private List<Edge> edges; // Les arcs
	
	public Graph() {
		// A compléter 
		this.nodes = new ArrayList<Node>();
        this.edges = new ArrayList<Edge>();		
	}
	
	public List<Edge> getEdgesGoingFrom(Node source) {
		
		List<Edge> resultGoingFrom = new ArrayList<Edge>();
		
		for (Edge edge : edges) {
			if 	( source.equals(edge.getSource())) {
				resultGoingFrom.add(edge);
			}
		}
		return resultGoingFrom;
	}
	public List<Edge> getEdgesGoingTo(Node dest) {
		
		List<Edge> resultGoingTo = new ArrayList<Edge>();
		
		for (Edge edge : edges) {
			if 	( dest.equals(edge.getDestination())) {
				resultGoingTo.add(edge);
			}
		}
		
		return resultGoingTo;
	}
	
	// Accesseurs 
	public List<Node> getNodes() {
		return nodes;
	}
	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}
	public List<Edge> getEdges() {
		return edges;
	}
	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}
	
}
