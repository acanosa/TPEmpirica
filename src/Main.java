
import org.jgrapht.*;
import org.jgrapht.graph.*;
import org.jgrapht.io.*;
import org.jgrapht.traverse.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {

		//Graph<Integer, DefaultWeightedEdge> integerGraph = crearGrafoEnteros();
		Graph<Integer, DefaultWeightedEdge> grafo = crearGrafo();
		/*
        System.out.println("-- toString output");
        System.out.println(integerGraph.toString());
        for(DefaultWeightedEdge edge : integerGraph.edgeSet()) {
        	double peso = integerGraph.getEdgeWeight(edge);
        	System.out.println(edge.toString() + " - " + peso);
        }
        System.out.println();
        */
		//resolverEscaladaSimple(grafo);
		AlgoritmnAStar.resolverEscaladaSimple(grafo, 5, 200);
	}
	
	// *************************GRAFOS DE PRUEBA**************************************
    private static Graph<String, DefaultEdge> createStringGraph()
    {
        Graph<String, DefaultEdge> g = new SimpleGraph<>(DefaultEdge.class);

        String v1 = "v1";
        String v2 = "v2";
        String v3 = "v3";
        String v4 = "v4";

        // add the vertices
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);

        // add edges to create a circuit
        g.addEdge(v1, v2);
        g.addEdge(v2, v3);
        g.addEdge(v3, v4);
        g.addEdge(v4, v1);

        return g;
    }
    
    private static Graph<Integer, DefaultWeightedEdge> crearGrafo(){
    	Graph<Integer, DefaultWeightedEdge> grafo = new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);
    	
    	Integer a = new Integer(5);
    	Integer b = new Integer(10);
    	Integer c = new Integer(12);
    	Integer d = new Integer(8);
    	Integer e = new Integer(15);
    	Integer f = new Integer(20);
    	Integer g = new Integer(11);
    	Integer h = new Integer(25);
    	Integer i = new Integer(30);
    	Integer j = new Integer(27);
    	Integer k = new Integer(55);
    	Integer l = new Integer(65);
    	Integer m = new Integer(58);
    	Integer n = new Integer(62);
    	Integer enie = new Integer(110);
    	Integer o = new Integer(120);
    	Integer p = new Integer(200);
    	
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
    	return grafo;
    }
    
    // ************************* FIN GRAFOS DE PRUEBA*********************************
    
 /*   //Este metodo crea el grafo con mi codigo
    private static Graph<Nodo, DefaultWeightedEdge> crearGrafo(){
    	Graph<Nodo, DefaultWeightedEdge> grafo = new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);
    	
    	Nodo a = new Nodo("A", 5, false, true);
    	Nodo b = new Nodo("B",10);
    	Nodo c = new Nodo("C",12);
    	Nodo d = new Nodo("D",8);
    	Nodo e = new Nodo("E",15);
    	Nodo f = new Nodo("F",20);
    	Nodo g = new Nodo("G",38);
    	Nodo h = new Nodo("H",25);
    	Nodo i = new Nodo("I",30);
    	Nodo j = new Nodo("J",27);
    	Nodo k = new Nodo("K",55);
    	Nodo l = new Nodo("L",65);
    	Nodo m = new Nodo("M",58);
    	Nodo n = new Nodo("N",62);
    	Nodo enie = new Nodo("enie",110);
    	Nodo o = new Nodo("O",120);
    	Nodo p = new Nodo("P",200, true, false);
    	
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
    	
    	DefaultWeightedEdge aristaAB = new DefaultWeightedEdge();
    	DefaultWeightedEdge aristaAC = new DefaultWeightedEdge();
    	DefaultWeightedEdge aristaAD = new DefaultWeightedEdge();
    	DefaultWeightedEdge aristaBE = new DefaultWeightedEdge();
    	DefaultWeightedEdge aristaBF = new DefaultWeightedEdge();
    	DefaultWeightedEdge aristaEK = new DefaultWeightedEdge();
    	DefaultWeightedEdge aristaFL = new DefaultWeightedEdge();
    	DefaultWeightedEdge aristaKEnie = new DefaultWeightedEdge();
    	DefaultWeightedEdge aristaLEnie = new DefaultWeightedEdge();
    	DefaultWeightedEdge aristaCG = new DefaultWeightedEdge();
    	DefaultWeightedEdge aristaCH = new DefaultWeightedEdge();
    	DefaultWeightedEdge aristaGO = new DefaultWeightedEdge();
    	DefaultWeightedEdge aristaHM = new DefaultWeightedEdge();
    	DefaultWeightedEdge aristaMO = new DefaultWeightedEdge();
    	DefaultWeightedEdge aristaMP = new DefaultWeightedEdge();
    	DefaultWeightedEdge aristaDI = new DefaultWeightedEdge();
    	DefaultWeightedEdge aristaDJ = new DefaultWeightedEdge();
    	DefaultWeightedEdge aristaJN = new DefaultWeightedEdge();
    	DefaultWeightedEdge aristaIP = new DefaultWeightedEdge();
    	
    	grafo.addEdge(a, b, aristaAB);
    	grafo.addEdge(a, c, aristaAC);
    	grafo.addEdge(a, d, aristaAD);
    	grafo.addEdge(b, e, aristaBE);
    	grafo.addEdge(b, f, aristaBF);
    	grafo.addEdge(e, k, aristaEK);
    	grafo.addEdge(f, l, aristaFL);
    	grafo.addEdge(k, enie, aristaKEnie);
    	grafo.addEdge(l, enie, aristaLEnie);
    	grafo.addEdge(c, g, aristaCG);
    	grafo.addEdge(c, h, aristaCH);
    	grafo.addEdge(g, o, aristaGO);
    	grafo.addEdge(h, m, aristaHM);
    	grafo.addEdge(m, o, aristaMO);
    	grafo.addEdge(m, p, aristaMP);
    	grafo.addEdge(d, i, aristaDI);
    	grafo.addEdge(d, j, aristaDJ);
    	grafo.addEdge(j, n, aristaJN);
    	grafo.addEdge(i, p, aristaIP);
    	
    	
    	grafo.setEdgeWeight(aristaAB, 2);
    	grafo.setEdgeWeight(aristaAC, 3);
    	grafo.setEdgeWeight(aristaAD, 4);
    	grafo.setEdgeWeight(aristaBE, 1);
    	grafo.setEdgeWeight(aristaBF, 5);
    	grafo.setEdgeWeight(aristaEK, 10);
    	grafo.setEdgeWeight(aristaFL, 12);
    	grafo.setEdgeWeight(aristaKEnie, 15);
    	grafo.setEdgeWeight(aristaLEnie, 20);
    	grafo.setEdgeWeight(aristaCG, 2);
    	grafo.setEdgeWeight(aristaCH, 3);
    	grafo.setEdgeWeight(aristaGO, 25);
    	grafo.setEdgeWeight(aristaHM, 12);
    	grafo.setEdgeWeight(aristaMO, 20);
    	grafo.setEdgeWeight(aristaMP, 25);
    	grafo.setEdgeWeight(aristaDI, 4);
    	grafo.setEdgeWeight(aristaDJ, 5);
    	grafo.setEdgeWeight(aristaJN, 10);
    	grafo.setEdgeWeight(aristaIP, 25);
    	return grafo;
    }
*/
    
//Mi version de escalada simplpe
/*    
    private static void resolverEscaladaSimple(Graph<Nodo, DefaultWeightedEdge> grafo) {
    	List<Nodo> visitados = new ArrayList<>();
		List<Nodo> adyacentes = new ArrayList<>();
		boolean nodoEncontrado = false;
		boolean maximoLocal = false;
		Nodo nodoActual = null;
		Nodo nodoAux = null;
		while(!nodoEncontrado && !maximoLocal) {
			if(nodoActual == null) {
				nodoActual = obtenerNodoInicial(grafo);
			}else {
				adyacentes = Graphs.neighborListOf(grafo, nodoActual);
				//Guardamos el actual en una variable auxiliar para luego saber
				//si de verdad avanzamos o nos trabamos a un maximo local
				nodoAux = nodoActual;
				for(int i=0;i<adyacentes.size();i++) {
					//agarro los nodos adyacentes que no visite
					if(nodoActual.getValor() < adyacentes.get(i).getValor() 
							&& !visitados.contains((Nodo) adyacentes.get(i))) {
						System.out.println("Se encontro un nodo con una heuristica superior al actual (act: " + nodoActual.getValor() + " vs nuev: " + adyacentes.get(i).getValor());
						nodoActual = adyacentes.get(i);
						//encontre el nodo llegada
						if(nodoActual.isNodoLlegada()) {
							System.out.println("El nodo " + nodoActual.getLlave() + " es nodo llegada :D");
							nodoEncontrado = true;
						}
						//si saco el break va a saltar al ultimo nodo que tenga mejor heuristica, eso no sirve.
						break;
					}
				}
				//estoy en un maximo local
				if(nodoAux.equals(nodoActual)) {
					maximoLocal = true;
				}
			}
			//Si esto se imprime 2 veces con el mismo nodo, maximo local
			System.out.println("Nodo actual: " + nodoActual.toString());
			//marco el nodo como visitado
			visitados.add(nodoActual);
		}
		if(maximoLocal) {
			System.out.println("Se llego a un maximo Local :C");
		}
		if(nodoEncontrado) {
			System.out.println("Se llego a un nodo solucion :D");
		}
    }
 */   
    
    /*
    private static void resolverEscaladaMaximaPendiente(Graph<Nodo, DefaultWeightedEdge> grafo) {
    	List<Nodo> visitados = new ArrayList<>();
		List<Nodo> adyacentes = new ArrayList<>();
		boolean nodoEncontrado = false;
		boolean maximoLocal = false;
		Nodo nodoActual = null;
		Nodo nodoAux = null;
		Nodo nodoMax = null;;
		while(!nodoEncontrado && !maximoLocal) {
			if(nodoActual == null) {
				nodoActual = obtenerNodoInicial(grafo);
			}else {
				adyacentes = Graphs.neighborListOf(grafo, nodoActual);
				//Guardamos el actual en una variable auxiliar para luego saber
				//si de verdad avanzamos o nos trabamos a un maximo local
				nodoAux = nodoActual;
				for(int i=0;i<adyacentes.size();i++) {
					//agarro los nodos adyacentes que no visite, y busco el valor maximo.
					 if(nodoActual.getValor() < adyacentes.get(i).getValor() 
							&& !visitados.contains((Nodo) adyacentes.get(i))) {
						 if(nodoMax == null) {
							 nodoMax = adyacentes.get(i);
						 }else if(nodoMax.getValor() < adyacentes.get(i).getValor()) {
							 nodoMax = adyacentes.get(i);
						 }
					 }
					 //encontre un nodo con la heuristica maxima
					 if(nodoMax != null) {
						 System.out.println("Se encontro un nodo con una heuristica superior al actual (act: " + nodoActual.getValor() + " vs nuev: " + adyacentes.get(i).getValor());
						 nodoActual = nodoMax;
							//encontre el nodo llegada
						 if(nodoActual.isNodoLlegada()) {
								System.out.println("El nodo " + nodoActual.getLlave() + " es nodo llegada :D");
								nodoEncontrado = true;
						 }
					 }
					 nodoMax = null;
				}
				//estoy en un maximo local
				if(nodoAux.equals(nodoActual)) {
					maximoLocal = true;
				}
			}
			//Si esto se imprime 2 veces con el mismo nodo, maximo local
			System.out.println("Nodo actual: " + nodoActual.toString());
			//marco el nodo como visitado
			visitados.add(nodoActual);
		}
		if(maximoLocal) {
			System.out.println("Se llego a un maximo Local :C");
		}
		if(nodoEncontrado) {
			System.out.println("Se llego a un nodo solucion :D");
		}
    }
    */
    /*
    private static Nodo obtenerNodoInicial(Graph<Nodo, DefaultWeightedEdge> grafo) {
    	Nodo nodo = new Nodo();
    	for(Nodo item : grafo.vertexSet()) {
    		if(item.isNodoSalida()) {
    			nodo = item;
    			break;
    		}
    	}
    	return nodo;
    }
    */
}
