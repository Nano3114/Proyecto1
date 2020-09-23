
	public interface GraphD<V,E> { 
		
		//Agrega el nodo �node� al grafo, si a�n no pertenec�a a la estructura
		public void addNode(int e);
		
		//agrega un arco entre el nodo �ant� y el nodo �sig�, si a�n no exist�a el arco y ambos par�metros son nodos pertenecientes a la estructura.
		public void addEdge(int ant ,int sig);
		
		// remueve el nodo �node� del grafo, si el par�metro es un nodo de la estructura.
		public void removeNode(int e);
		
		//remueve el arco entre el nodo �ant� y el nodo �sig�, si el arco formado por los par�metros pertenecen a la estructura.
		public void removeEdge(int ant, int sig);
	}