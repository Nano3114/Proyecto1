
	public interface GraphD<V,E> { 
		
		//Agrega el nodo “node” al grafo, si aún no pertenecía a la estructura
		public void addNode(int e);
		
		//agrega un arco entre el nodo “ant” y el nodo “sig”, si aún no existía el arco y ambos parámetros son nodos pertenecientes a la estructura.
		public void addEdge(int ant ,int sig);
		
		// remueve el nodo “node” del grafo, si el parámetro es un nodo de la estructura.
		public void removeNode(int e);
		
		//remueve el arco entre el nodo “ant” y el nodo “sig”, si el arco formado por los parámetros pertenecen a la estructura.
		public void removeEdge(int ant, int sig);
	}