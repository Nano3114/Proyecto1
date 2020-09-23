
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.Filter;
import java.util.logging.LogRecord;


public class Graph implements GraphD{
	
	private Map<Integer,Integer> nodos;
	private Map<String,Integer> arcos;
	private static Logger Logger;


	public Graph () {
		
		nodos = new HashMap<Integer,Integer>();
		arcos =  new HashMap<String,Integer>();

		if(Logger==null) {
			
			Logger = Logger.getLogger(Graph.class.getName());
			
			Handler hnd = new ConsoleHandler();
			hnd.setLevel(Level.FINE);	
    		Logger.addHandler(hnd);
    		
			Logger.setLevel(Level.FINE);
    		//Logger.setLevel(Level.WARNING); 
			Logger rootLogger = Logger.getParent();
			for(Handler h: rootLogger.getHandlers()) {
				h.setLevel(Level.OFF);
			}
		}
	}
	
	public void addNode(int nodo) {
		if(nodos.get(nodo)==null) {
			nodos.put(nodo,nodo);
			Logger.fine("El nodo  fue agregado al Grafo : "+nodo); 
		}
		else {
			Logger.warning("El nodo  "+nodo+" ya existe al Grafo");
		}
	}
	
	public void addEdge(int prev, int suc) {
		Integer previo = nodos.get(prev);
		Integer sucesor = nodos.get(suc);
		String clave = prev+","+suc;
		
		if(previo==null||sucesor==null) {
			if(previo==null)	{
				Logger.warning("El vertice previo: "+prev+" no existe en el Grafo");
			} 
			if(sucesor==null) {
				Logger.warning("El vertice sucesor: "+suc+" no existe en el Grafo");
			}
		}
		else {
			if(arcos.get(clave)==null) {
				arcos.put(clave,suc); 
				Logger.fine("El arco  fue agregado al Grafo : "+clave);
			}
			else {
				Logger.warning("El arco "+clave+" ya existe en el Grafo");
			}

		}

	}

	public void removeNode(int nodo) {
		Integer valor;
		String clave;
		if(nodos.get(nodo)!=null) {
			List<String> lista = new LinkedList<String>();
			Iterator<Integer> it = arcos.values().iterator();
			while(it.hasNext()) {
				valor= it.next();
				clave = nodo+","+valor;
				if(arcos.get(clave)!=null) {
					lista.add(clave);
				}
			}
			for(String claves: lista) {
				arcos.remove(claves);
				Logger.fine("Arco asociado "+claves+" borrado del Grafo");
			}

			nodos.remove(nodo);
			Logger.fine("Nodo borrado del Grafo"+nodo);
		}
		else {
			Logger.warning("El nodo "+nodo+" no existe en el Grafo");
		}

	}

	public void removeEdge(int anterior, int siguiente) {
		String key = anterior+"-"+siguiente;
		if(arcos.get(key)!=null) {
			arcos.remove(key);
			Logger.fine("El arco "+key+" fue eliminado del Grafo");
		}
		else
			Logger.warning("El arco "+key+" no existe en el Grafo" );
	}

}