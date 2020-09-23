public class Main {

	public static void main(String[] args) {
		
      GraphD grafo = new Graph();		
      
	  grafo.addNode(1);
	  grafo.addNode(2);
	  grafo.addNode(3);
	  grafo.addNode(1);//deberia salra warning por que ya existe "nodo 1"
	  grafo.addEdge(1, 2);
	  grafo.addEdge(2, 3);
	  grafo.addEdge(3, 1);
	  grafo.addEdge(1, 3);
	  
	  grafo.removeNode(1);
	  grafo.removeNode(1);//deberia lanzar 1 warning , ya que no deberia encontrar el "nodo1"
	}

}