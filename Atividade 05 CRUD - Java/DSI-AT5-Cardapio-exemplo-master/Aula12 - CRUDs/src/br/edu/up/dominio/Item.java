package br.edu.up.dominio;

public class Item {

	private String nome;
	private String preco;
	
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getPreco() {
		return preco;
	}


	public void setPreco(String preco) {
		this.preco = preco;
	}


	public Item(String nome, String preco) {
		this.nome = nome;
		this.preco = preco;
		
	}
	
public Item(){
}

public Item (String exclusor) {
	
	
	
}

    @Override
	public String toString() {
		return nome + ";" + preco;
	}
}
