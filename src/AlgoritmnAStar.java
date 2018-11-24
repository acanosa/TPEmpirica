
import java.util.*;
import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;

public class AlgoritmnAStar {
	
	/*Algoritmos*/
	public static <T,E> void AStar(Graph<T,E> graph , T start , T destiny)
	{
		BeamSearch(graph , start , destiny , 0);
	}
	
	public static <T,E> void BeamSearch(Graph<T,E> graph , T start , T destiny , int maxStack) 
	{
		List<SearchAStar<T>> open = new ArrayList<SearchAStar<T>>();
		List<T> closed = new ArrayList<T>();

		open.add( new SearchAStar<T>( start , 0 ));
		
		boolean finded = false;
		
		while(open.size() != 0 && !finded) 
		{
			SearchAStar<T>current = open.get(0);
			open.remove(0);
			closed.add( current.getValue() ); 
			if(current.getValue().equals(destiny)) 
			{
				finded = true;
			}
			else
			{
				List<SearchAStar<T>> adjacents = AllAdjacentNotRepeted(graph , current , closed);
				InsertAdjacent(open , adjacents ,maxStack);
			}
		}
	}
	
	public static <T,E> void resolverEscaladaSimple(Graph<T, E> grafo, T inicial, T llegada) {
    	List<T> visitados = new ArrayList<>();
		List<T> adyacentes = new ArrayList<>();
		boolean nodoEncontrado = false;
		boolean maximoLocal = false;
		T nodoActual = null;
		T nodoAux = null;
		while(!nodoEncontrado && !maximoLocal) {
			if(nodoActual == null) {
				nodoActual = inicial;
			}else {
				adyacentes = Graphs.successorListOf(grafo, nodoActual);
				//Guardamos el actual en una variable auxiliar para luego saber
				//si de verdad avanzamos o nos trabamos a un maximo local
				nodoAux = nodoActual;
				for(int i=0;i<adyacentes.size();i++) {
					//agarro los nodos adyacentes que no visite
					if((Integer) nodoActual < (Integer) adyacentes.get(i) 
							&& !visitados.contains(adyacentes.get(i))) {
						//System.out.println("Se encontro un nodo con una heuristica superior al actual (act: " + nodoActual + " vs nuev: " + adyacentes.get(i));
						nodoActual = adyacentes.get(i);
						//si saco el break va a saltar al ultimo nodo que tenga mejor heuristica, eso no sirve.
						if(((Integer) nodoActual).equals((Integer) llegada)) {
							//System.out.println("El nodo " + nodoActual + " es nodo llegada :D");
							nodoEncontrado = true;
							break;
						}
						break;
					}
				}
				//encontre nodo llegada
				
				//estoy en un maximo local
				if((Integer) nodoAux == (Integer) nodoActual) {
					maximoLocal = true;
				}
				
			}
			//Si esto se imprime 2 veces con el mismo nodo, maximo local
			//System.out.println("Nodo actual: " + nodoActual.toString());
			//marco el nodo como visitado
			visitados.add(nodoActual);
		}
//		if(maximoLocal) {
//			System.out.println("Se llego a un maximo Local :C");
//		}
//		if(nodoEncontrado) {
//			System.out.println("Se llego a un nodo solucion :D");
//		}
    }
	
	public static void primeroMejor(Graph<Integer, DefaultWeightedEdge> grafo , Integer inicio , Integer llegada) {
		
		List<Integer> visitados = new ArrayList<>();
		List<Integer> sucesores = new ArrayList<>();
		List<Integer> predecesores = new ArrayList<>();
		boolean IntegerEncontrado = false;
		boolean hayCaminos = true;
		Integer IntegerActual = null;
		Integer IntegerAux = null;
		boolean terminado = false;
		boolean sinSucesorRestantes = false;
		while(!IntegerEncontrado && hayCaminos && terminado != true) {//Todavia no llegue al Integer destino y quedan caminos por recorrer
			if(IntegerActual == null) {// Si todavia no tengo el Integer donde empezar la busqueda
				IntegerActual = inicio;
				//System.out.println("Integer: " + IntegerActual.getLlave() +" Contiene el Comienzo");
				visitados.add(IntegerActual); //AGREGO a la lista de visitados por donde comienzo
			}else {// Ya tengo el Integer donde empezar
				sucesores = Graphs.successorListOf(grafo, IntegerActual); //VEO si el Integer tiene sucesores
				
				if(sucesores.isEmpty() == false){    //SI encontramos Integers sucesores 
					if(!verificarTodosSucesoresVisitados(visitados, sucesores)){ //reviso todos los hijos si estan en la lista de visitados
						IntegerActual = obtenerIntegerPredecesorVisitado(IntegerActual, Graphs.predecessorListOf(grafo,IntegerActual), visitados); 
					}else if(IntegerActual == inicio){
//						System.out.println("Esta mierda no encontro nada");
						break;
					}
					IntegerAux = IntegerActual;
					IntegerActual = obtenerIntegerMayorEuristica(IntegerActual, sucesores,visitados);//agarro el Integer con mejor Euristica
					if(IntegerActual != null && IntegerActual == llegada  ) {
						visitados.add(IntegerActual);
						IntegerEncontrado = true;
						//System.out.println("Integer: " + IntegerActual.getLlave() +" Contiene el destino final con valor de: " + IntegerActual.getValor());
					}
						else{
						//System.out.println("Integer: " + IntegerActual.getLlave() +" con valor de: " + IntegerActual.getValor() + " No es la llegada, se vera el siguiente" );
						visitados.add(IntegerActual);
						IntegerAux = IntegerActual;
					}
				}else{//SI NO QUEDAN SUCESORES; VUELVO A LA LISTA DE VISITADOS
					if(visitados.size() == 1  ){
//						System.out.println("SOLO HAY UN Integer Y NO HAY SOLUCION");
						terminado = true;
						hayCaminos = false;
					}else{//Si hay mas de uno visitado significa que hay mas de un Integer...
						//System.out.println("OBTENDREMOS Integer PREDECESOR DE " + IntegerActual.getLlave());
						IntegerActual = obtenerIntegerPredecesorVisitado(IntegerActual, Graphs.predecessorListOf(grafo,IntegerActual), visitados);
						//System.out.println(IntegerActual.getLlave());
						// IntegerAux = visitados.get(visitados.size()-2); //Agarro el ultimo de los visitados y chequeo si hay otro hijo.
						IntegerAux = IntegerActual;
						sucesores = Graphs.successorListOf(grafo, IntegerActual); //VEO si el Integer tiene sucesores
						IntegerActual = obtenerIntegerMayorEuristica(IntegerAux, sucesores,visitados);


						if(IntegerActual == null){//Si busco los sucesores y no hay ninguno, vuelvo a retroceder a un predecesor
							IntegerActual = obtenerIntegerPredecesorVisitado(IntegerAux, Graphs.predecessorListOf(grafo,IntegerAux), visitados);
							if(visitados.size() == grafo.vertexSet().size() || inicio == IntegerActual){//Si la lista de visitados es la misma que la cant de Integers, no hay solucion
//								System.out.println("No se encontro una posible solucion");
								terminado = true;
							}
						}else{
							if(IntegerActual == llegada) {
								visitados.add(IntegerActual);
								IntegerEncontrado = true;
								//System.out.println("Integer: " + IntegerActual.getLlave() +" Contiene el destino final con valor de: " + IntegerActual.getValor());
							}
							else{
								//System.out.println("Integer: " + IntegerActual.getLlave() +" con valor de: " + IntegerActual.getValor() + " No es la llegada, se vera el siguiente" );
								visitados.add(IntegerActual);
								IntegerAux = IntegerActual;
							}
						}
					}
				}
			}
		}
	}

	public static void resolverEscaladaMaximaPendiente(Graph<Integer, DefaultWeightedEdge> grafo , Integer inicio , Integer llegada) {
		List<Integer> visitados = new ArrayList<>();
		List<Integer> sucesor = new ArrayList<>();
		List<Integer> predecesores = new ArrayList<>();
		List<Integer> adyacentes = new ArrayList<>();
		boolean nodoEncontrado = false;
		boolean maximoLocal = false;
		Integer IntegerActual = null;
		Integer IntegerAux = null;
		while (!nodoEncontrado && !maximoLocal) {
			if (IntegerActual == null) {
				IntegerActual = inicio;
			} else {
				sucesor = Graphs.successorListOf(grafo, IntegerActual);
				IntegerAux = IntegerActual;
				for (int i = 0; i < sucesor.size(); i++) {
					if (IntegerActual < sucesor.get(i)
							&& !visitados.contains((Integer) sucesor.get(i))
						) {
						//System.out.println("Se encontro un nodo con una heuristica superior al actual (act: "
							//	+ IntegerActual + " vs nuev: " + sucesor.get(i));
						IntegerActual = obtenerIntegerMayorEuristica(IntegerActual, sucesor, visitados);
//						System.out.println(IntegerActual);
						
					if (IntegerActual.equals(llegada)) {
						nodoEncontrado = true;
//						System.out.println("Llego a Destino, nodo= "+IntegerActual.toString());
					}
					break;
					}
			}
				if (IntegerAux.equals(IntegerActual)) {
					maximoLocal = true;
				}
			}
//			System.out.println("Nodo actual: " + IntegerActual.toString());
			visitados.add(IntegerActual);
		}
//		if (nodoEncontrado) {
//			System.out.println("Se llego a un nodo solucion");
//		}
//		if (maximoLocal) {
//			System.out.println("Se llego a un maximo Local");
//		}
	}
	
	/*Utils*/
	private static Integer obtenerIntegerMayorEuristica(Integer IntegerActual,List<Integer> sucesores,List<Integer> visitados ){
		/* DefaultWeightedEdge edge;
		 List<DefaultWeightedEdge> aristas = (List<DefaultWeightedEdge>) grafo.edgesOf(IntegerActual);
		 for(int i= 0 ; i<aristas.size(); i++){
		 	aristas.get(i).toString();
		 }*/
		Integer IntegerMax = null;
		double maximo = -1;
		for(int i=0; i<sucesores.size(); i++){
			if(sucesores.get(i)>= maximo && !visitados.contains((Integer) sucesores.get(i))){
				maximo = sucesores.get(i);
				IntegerMax = sucesores.get(i);
			}
		}
		return IntegerMax;
	}

	private static Integer obtenerIntegerPredecesorVisitado(Integer IntegerActual,List<Integer> predecesores,List<Integer> visitados ){
		Integer IntegerPredecesor = null;
		for(int i=0; i<predecesores.size(); i++){
			if(visitados.contains((Integer) predecesores.get(i))){
				IntegerPredecesor = predecesores.get(i);
			}
		}
		return IntegerPredecesor;
	}
	
	private static boolean verificarTodosSucesoresVisitados(List<Integer> visitados, List<Integer> sucesores){
		boolean todosVisitados = true;
		for(int i=0;i<sucesores.size();i++){
			if(!visitados.contains(sucesores.get(i))){
				todosVisitados = false;
			}
		}
		return todosVisitados;
	}

	public static <T,E> List<SearchAStar<T>> AllAdjacentNotRepeted(Graph<T,E> graph , SearchAStar<T> source , List<T> visited)
	{
		List<SearchAStar<T>> ret= new ArrayList<SearchAStar<T>>();
		List<T>adjacents = Graphs.neighborListOf(graph, source.getValue());
		
		for(int i = 0 ; i < adjacents.size() ; i++)
		{
			if( !visited.contains(adjacents.get(i) ) ) 
			{
				Set<E> edgeDest = graph.getAllEdges(source.getValue(), adjacents.get(i));
				if( edgeDest.size() != 0) {
					E edge = graph.getEdge(source.getValue(), adjacents.get(i));
					double cost = graph.getEdgeWeight(edge);
					ret.add( new SearchAStar<T> (adjacents.get(i) , source.getCost() + cost)  );
				}
			}
			
		}
		
		return ret;
	}
	
	
	public static <T> void InsertAdjacent(List<SearchAStar<T>> open , List<SearchAStar<T>> adjacents ,int maxStack)
	{
		
		int encounter = -1;
		
		int i= 0;
		while( i < adjacents.size())
		{
			if(maxStack == 0 || open.size() <= maxStack ) {
				boolean finded = false;
				boolean remove = false;
				int insertOn = -1;
				int j=0;
				
				
				while( j < open.size() && !finded)
				{
					if(open.get(j).getValue() == adjacents.get(i).getValue())
					{
						finded = true;
						encounter = j;
						if( open.get(j).getCost() >= adjacents.get(i).getCost() )
						{
							remove = true;
						}
					}
					if( ( (int)open.get(j).getValue() - open.get(j).getCost() ) <= ( (int)adjacents.get(i).getValue() - adjacents.get(i).getCost()) && insertOn == -1 )
					{
						insertOn = j;
					}
					j++;
				}
				if(finded && remove)
				{
					open.remove(encounter);
				}
				if(insertOn != -1)
				{
					open.add(insertOn, adjacents.get(i));
				}
				else
				{
					if(open.size() != 0) {
						open.add( open.size() , adjacents.get(i));	
					}
					else
					{
						open.add( adjacents.get(i));
						
					}
				}
			}
			i++;
		}
	}

}
