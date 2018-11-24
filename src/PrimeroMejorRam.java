import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import org.jgrapht.*;
import org.jgrapht.graph.*;
import org.jgrapht.io.*;
import org.jgrapht.traverse.*;

public class PrimeroMejorRam {

	public static void main(String[] args) {
		//Graph<Integer, DefaultWeightedEdge> grafo = crearGrafo();
		/*

		  System.out.println(grafo.toString());
		  Integer IntegerActual = obtenerIntegerInicial(grafo);

		  for(int i=0;i<adyacentes.size();i++) {
			  System.out.println(adyacentes.get(i).getLlave());
			  System.out.println(adyacentes.get(i).getValor());
		  }

		 List<Integer> adyacentes = new ArrayList<>();
		  Integer IntegerActual = obtenerIntegerInicial(grafo);
		  adyacentes = Graphs.successorListOf(grafo, IntegerActual);
		  //adyacentes = Graphs.neighborListOf(grafo, IntegerActual);
		  Integer a = new Integer();
		  //a = obtenerIntegerMayorEuristica(IntegerActual, adyacentes);
		 //Set<DefaultWeightedEdge> aristas =  grafo.edgesOf(IntegerActual);
		// for (DefaultWeightedEdge arista : aristas) {
			// double costo = grafo.getEdgeWeight(arista);
			 //System.out.println(costo);
			for(int i= 0 ; i<adyacentes.size(); i++){
				System.out.println(adyacentes.get(i).getLlave());
			}

		 
		
		List<Integer> vertexes = new ArrayList<Integer>();
        Graph<Integer, DefaultWeightedEdge> grafo = GenerateRandomGraph(vertexes);
       
        int source =  ThreadLocalRandom.current().nextInt(0,  vertexes.size()-1) ;
        int destiny=0;
       
        boolean repeat = true;
       
        while(repeat) {
            destiny = ThreadLocalRandom.current().nextInt(0,  vertexes.size()-1);
            repeat = source == destiny;
        }
       
        long startTime = System.nanoTime();
        AlgoritmnAStar.BeamSearch(grafo, vertexes.get(source), vertexes.get(destiny),10);
        long endTime = System.nanoTime();
 
        System.out.println("Tomo: "+(endTime - startTime)+" Nanosegundos");
		*/
	//primeroMejor(grafo);
	}

	/*
	private static Graph<Integer, DefaultWeightedEdge> crearGrafo(){
		Graph<Integer, DefaultWeightedEdge> grafo = new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);
		
        Integer a = new Integer("A", 5, false, true);
        Integer b = new Integer("B",10);
        Integer c = new Integer("C",12);
        Integer d = new Integer("D",8);
        Integer e = new Integer("E",15);
        Integer f = new Integer("F",20);
        Integer g = new Integer("G",38);
        Integer h = new Integer("H",25);
        Integer i = new Integer("I",30);
        Integer j = new Integer("J",27);
        Integer k = new Integer("K",55);
        Integer l = new Integer("L",65);
        Integer m = new Integer("M",58);
        Integer n = new Integer("N",62);
        Integer enie = new Integer("enie",110);
        Integer o = new Integer("O",120);
        Integer p = new Integer("P",200,true, false);

        grafo.addVertex(a);
        grafo.addVertex(b);
        grafo.addVertex(c);
        grafo.addVertex(d);
        grafo.addVertex(e);
        grafo.addVertex(f);
        grafo.addVertex(g);
        grafo.addVertex(h);
        grafo.addVertex(i);
        grafo.addVertex(j);
        grafo.addVertex(k);
        grafo.addVertex(l);
        grafo.addVertex(m);
        grafo.addVertex(n);
        grafo.addVertex(enie);
        grafo.addVertex(o);
        grafo.addVertex(p);

        DefaultWeightedEdge edge1 = new DefaultWeightedEdge();
        DefaultWeightedEdge edge2 = new DefaultWeightedEdge();
        DefaultWeightedEdge edge3 = new DefaultWeightedEdge();
        DefaultWeightedEdge edge4 = new DefaultWeightedEdge();
        DefaultWeightedEdge edge5 = new DefaultWeightedEdge();
        DefaultWeightedEdge edge6 = new DefaultWeightedEdge();
        DefaultWeightedEdge edge7 = new DefaultWeightedEdge();
        DefaultWeightedEdge edge8 = new DefaultWeightedEdge();
        DefaultWeightedEdge edge9 = new DefaultWeightedEdge();
        DefaultWeightedEdge edge10 = new DefaultWeightedEdge();
        DefaultWeightedEdge edge11 = new DefaultWeightedEdge();
        DefaultWeightedEdge edge12 = new DefaultWeightedEdge();
        DefaultWeightedEdge edge13 = new DefaultWeightedEdge();
        DefaultWeightedEdge edge14 = new DefaultWeightedEdge();
        DefaultWeightedEdge edge15 = new DefaultWeightedEdge();
        DefaultWeightedEdge edge16 = new DefaultWeightedEdge();
        DefaultWeightedEdge edge17 = new DefaultWeightedEdge();
        DefaultWeightedEdge edge18 = new DefaultWeightedEdge();
        DefaultWeightedEdge edge19 = new DefaultWeightedEdge();

        grafo.addEdge(a, b, edge1);
        grafo.addEdge(a, c, edge2);
        grafo.addEdge(a, d, edge3);
        grafo.addEdge(b, e, edge4);
        grafo.addEdge(b, f, edge5);
        grafo.addEdge(e, k, edge6);
        grafo.addEdge(f, l, edge7);
        grafo.addEdge(k, enie, edge8);
        grafo.addEdge(l, enie, edge9);
        grafo.addEdge(c, g, edge10);
        grafo.addEdge(c, h, edge11);
        grafo.addEdge(g, o, edge12);
        grafo.addEdge(h, m, edge13);
        grafo.addEdge(m, o, edge14);
        grafo.addEdge(m, p, edge15);
        grafo.addEdge(d, i, edge16);
        grafo.addEdge(d, j, edge17);
        grafo.addEdge(j, n, edge18);
        grafo.addEdge(i, p, edge19);


        grafo.setEdgeWeight(edge1, 2);
        grafo.setEdgeWeight(edge2, 3);
        grafo.setEdgeWeight(edge3, 4);
        grafo.setEdgeWeight(edge4, 1);
        grafo.setEdgeWeight(edge5, 5);
        grafo.setEdgeWeight(edge6, 10);
        grafo.setEdgeWeight(edge7, 12);
        grafo.setEdgeWeight(edge8, 15);
        grafo.setEdgeWeight(edge9, 20);
        grafo.setEdgeWeight(edge10, 2);
        grafo.setEdgeWeight(edge11, 3);
        grafo.setEdgeWeight(edge12, 25);
        grafo.setEdgeWeight(edge13, 12);
        grafo.setEdgeWeight(edge14, 20);
        grafo.setEdgeWeight(edge15, 25);
        grafo.setEdgeWeight(edge16, 4);
        grafo.setEdgeWeight(edge17, 5);
        grafo.setEdgeWeight(edge18, 10);
        grafo.setEdgeWeight(edge19, 25);
        
        
		Integer a = new Integer("A", 10, false, true);
		Integer b = new Integer("B",25);
		Integer c = new Integer("C",15);
		Integer d = new Integer("D",23);
		Integer e = new Integer("E",10);
		Integer f = new Integer("F",15);
		Integer g = new Integer("G",90, true, false);
		Integer h = new Integer("H",2);
		Integer i = new Integer("I",27);

		grafo.addVertex(a);
		grafo.addVertex(b);
		grafo.addVertex(c);
		grafo.addVertex(d);
		grafo.addVertex(e);
		grafo.addVertex(f);
		grafo.addVertex(g);
		grafo.addVertex(h);
		grafo.addVertex(i);

		DefaultWeightedEdge edge1 = new DefaultWeightedEdge();
		DefaultWeightedEdge edge2 = new DefaultWeightedEdge();
		DefaultWeightedEdge edge3 = new DefaultWeightedEdge();
		DefaultWeightedEdge edge4 = new DefaultWeightedEdge();
		DefaultWeightedEdge edge5 = new DefaultWeightedEdge();
		DefaultWeightedEdge edge6 = new DefaultWeightedEdge();
		DefaultWeightedEdge edge7 = new DefaultWeightedEdge();
		DefaultWeightedEdge edge8 = new DefaultWeightedEdge();
		DefaultWeightedEdge edge9 = new DefaultWeightedEdge();

		grafo.addEdge(a, b, edge1);
		grafo.addEdge(a, c, edge2);
		grafo.addEdge(a, d, edge3);
		grafo.addEdge(b, e, edge4);
		grafo.addEdge(b, f, edge5);
		grafo.addEdge(c, g, edge6);
		grafo.addEdge(d, h, edge7);
		grafo.addEdge(d, i, edge8);

		grafo.setEdgeWeight(edge1, 1);
		grafo.setEdgeWeight(edge2, 1);
		grafo.setEdgeWeight(edge3, 1);
		grafo.setEdgeWeight(edge4, 1);
		grafo.setEdgeWeight(edge5, 1);
		grafo.setEdgeWeight(edge6, 1);
		grafo.setEdgeWeight(edge7, 1);
		grafo.setEdgeWeight(edge8, 1);
		
		
		
		Integer a = new Integer("A", 5, false, true);
		Integer b = new Integer("B",9);
		Integer c = new Integer("C",50);
		Integer d = new Integer("D",120);
		Integer e = new Integer("E",8);
		Integer f = new Integer("F",25,true, false);
		Integer g = new Integer("G",12);
		Integer h = new Integer("H",500);
		Integer i = new Integer("I",2);

		grafo.addVertex(a);
		grafo.addVertex(b);
		grafo.addVertex(c);
		grafo.addVertex(d);
		grafo.addVertex(e);
		grafo.addVertex(f);
		grafo.addVertex(g);
		grafo.addVertex(h);
		grafo.addVertex(i);

		DefaultWeightedEdge edge1 = new DefaultWeightedEdge();
		DefaultWeightedEdge edge2 = new DefaultWeightedEdge();
		DefaultWeightedEdge edge3 = new DefaultWeightedEdge();
		DefaultWeightedEdge edge4 = new DefaultWeightedEdge();
		DefaultWeightedEdge edge5 = new DefaultWeightedEdge();
		DefaultWeightedEdge edge6 = new DefaultWeightedEdge();
		DefaultWeightedEdge edge7 = new DefaultWeightedEdge();
		DefaultWeightedEdge edge8 = new DefaultWeightedEdge();
		DefaultWeightedEdge edge9 = new DefaultWeightedEdge();

		grafo.addEdge(a, b, edge1);
		grafo.addEdge(a, c, edge2);
		grafo.addEdge(a, d, edge3);
		grafo.addEdge(b, e, edge4);
		grafo.addEdge(b, f, edge5);
		grafo.addEdge(c, g, edge6);
		grafo.addEdge(d, h, edge7);
		grafo.addEdge(d, i, edge8);

		grafo.setEdgeWeight(edge1, 1);
		grafo.setEdgeWeight(edge2, 1);
		grafo.setEdgeWeight(edge3, 1);
		grafo.setEdgeWeight(edge4, 1);
		grafo.setEdgeWeight(edge5, 1);
		grafo.setEdgeWeight(edge6, 1);
		grafo.setEdgeWeight(edge7, 1);
		grafo.setEdgeWeight(edge8, 1);

 
		return grafo;
	}
*/
	/*private static Integer obtenerIntegerInicial(Graph<Integer, DefaultWeightedEdge> grafo) {
		Integer Integer = new Integer();
		for(Integer item : grafo.vertexSet()) {
			if(item.isIntegerSalida()) {
				Integer = item;
				return Integer;
			}
		}
		return Integer;
	}*/

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
						System.out.println("Esta mierda no encontro nada");
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
						System.out.println("SOLO HAY UN Integer Y NO HAY SOLUCION");
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
								System.out.println("No se encontro una posible solucion");
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
	
	private static boolean verificarTodosSucesoresVisitados(List<Integer> visitados, List<Integer> sucesores){
		boolean todosVisitados = true;
		for(int i=0;i<sucesores.size();i++){
			if(!visitados.contains(sucesores.get(i))){
				todosVisitados = false;
			}
		}
		return todosVisitados;
	}

	public static Graph<Integer, DefaultWeightedEdge> GenerateRandomGraph(List<Integer> vertexes )
    {
        Graph<Integer, DefaultWeightedEdge> grafo = new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);
       
        //RANDOM DE MAXIMOS VERTICES , VA DE MAXIMO 100 A 200
        int maxVertexes = ThreadLocalRandom.current().nextInt(100,  200);
       
        for(int i = 0 ; i <= maxVertexes ; i++)
        {
            int random = ThreadLocalRandom.current().nextInt(0,  1000);
            if( !vertexes.contains(random))
            {
                Integer value = new Integer(random);
                vertexes.add(value);
                grafo.addVertex(value);
            }
        }
        //EN ESTA PARTE AGREGO UN CAMINO QUE LLEVE A TODO , YO QUERIA SER UN MAESTRO POKEMON , NO PUDE SERLO , POR ESO HICE ESTA BOSTA :D
        List<Integer> open = new ArrayList<Integer>(vertexes);
       
        int current = 0;
        int next = 0;
        while( open.size() != 2 )
        {
            boolean repeat = true;
           
            while(repeat) {
                next = ThreadLocalRandom.current().nextInt(0,  open.size()-1);
                repeat = current == next;
            }
           
            DefaultWeightedEdge edge = new DefaultWeightedEdge();
 
            grafo.addEdge( open.get(current) , open.get(next) , edge);
           
            int cost = ThreadLocalRandom.current().nextInt(0, 1000);
           
            grafo.setEdgeWeight(edge, cost);
           
            open.remove(current);
            if(current < next) {
                current = next == 0 ? 0 : next-1;
            }
            else
            {
                current = next;
            }
           
        }
        //ACA ESTA LAS ARISTAS EXTRA A AGREGAR , ES UN RANDOM DEL 200 AL 300
        int addingEdges = ThreadLocalRandom.current().nextInt(200,  300);
       
        for(int i = 0 ; i <= addingEdges ; i++ )
        {
            int source = ThreadLocalRandom.current().nextInt(0,  vertexes.size()-1);
            int destiny = 0;
            boolean repeat = true;
           
            while(repeat)
            {
                destiny = ThreadLocalRandom.current().nextInt(0,  vertexes.size()-1);
                repeat = source == destiny;
            }
           
            DefaultWeightedEdge edge = new DefaultWeightedEdge();
           
            grafo.addEdge( vertexes.get(source) , vertexes.get(destiny) , edge);
        }
       
        return grafo;
    }
	
}