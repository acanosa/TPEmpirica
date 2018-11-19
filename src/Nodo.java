
public class Nodo {
	
	private Integer valor;
	private String llave;
	private boolean nodoLlegada;
	private boolean nodoSalida;
	
	public Nodo() {
		super();
		this.nodoLlegada = false;
		this.nodoSalida = false;
	}
	
	public Nodo(String llave, Integer valor, boolean llegada, boolean salida) {
		super();
		this.valor = valor;
		this.llave = llave;
		this.nodoLlegada = llegada;
		this.nodoSalida = salida;
	}
	
	public Nodo(String llave, Integer valor) {
		super();
		this.valor = valor;
		this.llave = llave;
		this.nodoLlegada = false;
		this.nodoSalida = false;
	}
	
	public Nodo(Integer valor, String llave) {
		super();
		this.valor = valor;
		this.llave = llave;
	}

	public Integer getValor() {
		return valor;
	}
	
	public void setValor(Integer valor) {
		this.valor = valor;
	}
	
	public String getLlave() {
		return llave;
	}
	
	public void setLlave(String llave) {
		this.llave = llave;
	}
	
	public boolean isNodoLlegada() {
		return nodoLlegada;
	}

	public void setNodoLlegada(boolean nodoLlegada) {
		this.nodoLlegada = nodoLlegada;
	}

	public boolean isNodoSalida() {
		return nodoSalida;
	}

	public void setNodoSalida(boolean nodoSalida) {
		this.nodoSalida = nodoSalida;
	}

	@Override
	public String toString() {
		return "Nodo " + this.llave + " - " + this.valor;
	}
	
	public boolean equals(Nodo nodo) {
		return nodo.getLlave().equalsIgnoreCase(this.llave);
	}

}
