package br.edu.up.dominio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cardapio {
	
	
	private static List<Item> listaDePratos;
	private static List<Item> listaDebebidas;
	private static List<Item> listaDeVinhos;
	
	private static String arquivoPratos = "C:\\Users\\PICHAU\\Desktop\\teste java\\DSI-AT5-Cardapio-exemplo-master\\Aula12 - CRUDs\\arquivos\\pratos.txt";
	private static String arquivoBebidas = "C:\\Users\\PICHAU\\Desktop\\teste java\\DSI-AT5-Cardapio-exemplo-master\\Aula12 - CRUDs\\arquivos\\bebidas-tabuladas.txt";
	private static String arquivoVinhos = "C:\\Users\\PICHAU\\Desktop\\teste java\\DSI-AT5-Cardapio-exemplo-master\\Aula12 - CRUDs\\arquivos\\vinhos-tabulados.txt";
	
	static {
		listaDePratos = new ArrayList<Item>();
		listaDePratos = carregarListaDePratos();
		listaDebebidas = new ArrayList<Item>();
		listaDebebidas = carregarListaDebebidas();
		listaDeVinhos = new ArrayList<Item>();
		listaDeVinhos = carregarListaDeVinhos();
	}
	
	private static List<Item> carregarListaDePratos() {
		
		List<Item> listaDeRetornoPrato = new ArrayList<>();

		try {
			File arquivopratos = new File(arquivoPratos);
			Scanner leitor = new Scanner(new FileInputStream(arquivopratos), "UTF-8");
			leitor.nextLine();
			
			while (leitor.hasNext()) {
				String linha = leitor.nextLine();
				String[] partes = linha.split(";");
				Item item = new Item(partes[0], partes[1]);
				listaDeRetornoPrato.add(item);
				
			}			
			
		} catch (FileNotFoundException e) {
			System.out.println ("ocorreu um erro na leitura do arquivo");
			//e.printStackTrace();
		}
	
		return listaDeRetornoPrato;
	}
	
	private static List<Item> carregarListaDeVinhos() {
		List<Item> listaDeRetornoVinho = new ArrayList<>();

		try {
			File arquivovinhos = new File(arquivoVinhos);
			Scanner leitor = new Scanner(new FileInputStream(arquivovinhos), "UTF-8");
			leitor.nextLine();
			
			while (leitor.hasNext()) {
				String linha = leitor.nextLine();
				String[] partes = linha.split("\t");
				Item item = new Item(partes[1], partes[0]);
				listaDeRetornoVinho.add(item);
			}			
			
		} catch (FileNotFoundException e) {
			System.out.println ("ocorreu um erro na leitura do arquivo");
			//e.printStackTrace();
		}
	
		return listaDeRetornoVinho;
	}

	private static List<Item> carregarListaDebebidas() {
		
		List<Item> listaDeRetornoBeb = new ArrayList<>();

		try {
			File arquivobeb = new File(arquivoBebidas);
			Scanner leitor = new Scanner(new FileInputStream(arquivobeb), "UTF-8");
			leitor.nextLine();
			
			while (leitor.hasNext()) {
				String linha = leitor.nextLine();
				String[] partes = linha.split("\t");
				Item item = new Item(partes[1], partes[0]);
				listaDeRetornoBeb.add(item);
			}			
			
		} catch (FileNotFoundException e) {
			System.out.println ("ocorreu um erro na leitura do arquivo");
			//e.printStackTrace();
		}
	
		return listaDeRetornoBeb;
	}
	
	
	public static List<Item> listarpratos() {
		return listaDePratos;
	}
	
	public static List<Item> listarbebidas() {
		return listaDebebidas;
	}
	
	public static List<Item> listarvinhos() {
		return listaDeVinhos;
	}
	
	
	public static void incluirprato(Item item) {
		listaDePratos.add(item);
		incluirNoArquivoPrato(item);
	}
	
	public static void incluirbebida(Item item) {
		listaDebebidas.add(item);
		incluirNoArquivoBebida(item);
		
	}
	
	public static void incluirvinho(Item item) {
		listaDeVinhos.add(item);
		incluirNoArquivoVinho(item);
		
	}

	private static void incluirNoArquivoPrato(Item item) {
		try {
			FileWriter arquivo = new FileWriter(arquivoPratos, true);
			PrintWriter gravador = new PrintWriter(arquivo);
			gravador.println (item);
			gravador.close();
			arquivo.close();
			
		} catch (IOException e) {
			System.out.println ("Erro do arquivo!");
			//e.printStackTrace();
		}
	}
	
   private static void incluirNoArquivoBebida(Item item) {
		try {
			FileWriter arquivo = new FileWriter(arquivoBebidas, true);
			PrintWriter gravador = new PrintWriter(arquivo);
			gravador.println (item);
			gravador.close();
			arquivo.close();
			
		} catch (IOException e) {
			System.out.println ("Erro do arquivo!");
			//e.printStackTrace();
		}
	}

   private static void incluirNoArquivoVinho(Item item) {
		try {
			FileWriter arquivo = new FileWriter(arquivoVinhos, true);
			PrintWriter gravador = new PrintWriter(arquivo);
			gravador.println  (item);
			gravador.close();
			arquivo.close();
			
		} catch (IOException e) {
			System.out.println ("Erro do arquivo!");
			//e.printStackTrace();
		}
	}

		
   
	public static void excluirprato(Item item) {
		listaDePratos.remove(item);
		gravarListarAtualizadaPratos(listaDePratos);
		
	}
	
	public static void excluirbebida(Item item) {
		listaDebebidas.remove(item);
		gravarListarAtualizadaBebidas(listaDebebidas);
		
	}

	public static void excluirvinho(Item item) {
		listaDeVinhos.remove(item);
		gravarListarAtualizadaVinhos(listaDeVinhos);
		
	}	
	
	public static void gravarListarAtualizadaPratos(List<Item> listaDeItem) {
		try {
			FileWriter arquivo = new FileWriter(arquivoPratos);
			PrintWriter gravador = new PrintWriter(arquivo);
			for (Item item : listaDePratos) {
					gravador.println (item);
			}
			
			gravador.close();
			arquivo.close();
			
		} catch (IOException e) {
			System.out.println ("Erro do arquivo!");
			//e.printStackTrace();
		}
	}
	
	public static void gravarListarAtualizadaBebidas(List<Item> listaDeItem) {
		try {
			FileWriter arquivo = new FileWriter(arquivoBebidas);
			PrintWriter gravador = new PrintWriter(arquivo);
			for (Item item : listaDebebidas) {
					gravador.println (item);
			}
			
			gravador.close();
			arquivo.close();
			
		} catch (IOException e) {
			System.out.println ("Erro do arquivo!");
			//e.printStackTrace();
		}
	}
	
	public static void gravarListarAtualizadaVinhos(List<Item> listaDeItem) {
		try {
			FileWriter arquivo = new FileWriter(arquivoVinhos);
			PrintWriter gravador = new PrintWriter(arquivo);
			for (Item item : listaDeVinhos) {
					gravador.println (item);
			}
			
			gravador.close();
			arquivo.close();
			
		} catch (IOException e) {
			System.out.println ("Erro do arquivo!");
			//e.printStackTrace();
		}
	}


	public static void atualizarprato(Item item) {
		for (Item itemAtualizar : listaDePratos) {
			if (itemAtualizar.getNome().equals(item.getNome())) {
				itemAtualizar.setNome(item.getNome());
				itemAtualizar.setPreco(item.getPreco());
				break;
			}
		}
		gravarListarAtualizadaPratos(listaDePratos);
	}

	public static void atualizarbebida(Item item) {
		for (Item itemAtualizar : listaDebebidas) {
			if (itemAtualizar.getNome().equals(item.getNome())) {
				itemAtualizar.setNome(item.getNome());
				itemAtualizar.setPreco(item.getPreco());
				break;
			}
		}
		gravarListarAtualizadaBebidas(listaDebebidas);
	}
	
	public static void atualizarvinho(Item item) {
		for (Item itemAtualizar : listaDeVinhos) {
			if (itemAtualizar.getNome().equals(item.getNome())) {
				itemAtualizar.setNome(item.getNome());
				itemAtualizar.setPreco(item.getPreco());
				break;
			}
		}
		gravarListarAtualizadaVinhos(listaDeVinhos);
	}
	
	
	public static Item buscarPorNomePrato(String query) {
		Item itemRetornar = null;
		
		for (Item item : listaDePratos) {
		//	if (item.getNome().contains(query)) {
		//		itemRetornar = item;
		//		break;
		//	}
		}
		System.out.println(listaDePratos.removeIf(e -> e.getNome().contains(query)) ? "função realizada, prato deletado!": "item não encontrado");
		
		return itemRetornar;
	}
		public static Item buscarPorNomeBebida(String query) {
			Item itemRetornar = null;
			
			for (Item item : listaDebebidas) {
			//	if (item.getNome().contains(query)) {
			//		itemRetornar = item;
		//			break;
		//		}
			}
			System.out.println(listaDebebidas.removeIf(e -> e.getNome().contains(query)) ? "função realizada, bebida deletada!": "item não encontrado");	
			return itemRetornar;
	}
		
		public static Item buscarPorNomeVinho(String query) {
			Item itemRetornar = null;
			
			for (Item item : listaDeVinhos) {
				if  (item.getNome().contains(query)) {
									itemRetornar = item;
					break;
				}
				
			}
			System.out.println(listaDeVinhos.removeIf(e -> e.getNome().contains(query)) ? "função realizada, vinho deletado!": "item não encontrado");
			
			return itemRetornar;
		
		}
		
		public static Item pesquisarvinho(String query) {
			Item itemRetornar = null;
			
			for (Item item : listaDeVinhos) {
				if  (item.getNome().contains(query)) {
									itemRetornar = item;
					break;
				}
					}
		
		return itemRetornar;
			
}
		
		public static Item pesquisarprato(String query) {
			Item itemRetornar = null;
			
			for (Item item : listaDePratos) {
				if  (item.getNome().contains(query)) {
									itemRetornar = item;
					break;
				}
					}
		
		return itemRetornar;
		}
		
		public static Item pesquisarbebida(String query) {
			Item itemRetornar = null;
			
			for (Item item : listaDebebidas) {
				if  (item.getNome().contains(query)) {
									itemRetornar = item;
					break;
				}
					}
		
		return itemRetornar;
		}
}

