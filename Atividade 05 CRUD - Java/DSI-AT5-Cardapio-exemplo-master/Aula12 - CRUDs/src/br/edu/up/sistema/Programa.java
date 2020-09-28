package br.edu.up.sistema;

import java.awt.event.ItemEvent;
import java.util.List;
import java.util.Scanner;

import br.edu.up.dominio.Cardapio;
import br.edu.up.dominio.Item;



public class Programa {

	public static void main(String[] args) {
//		
//		List<Item> listavinhos = Cardapio.listarvinhos();
		
//		System.out.println ("---------------------");
//		System.out.println ("Tamanho da lista " + listavinhos.size());
		
//		for (Item item : listavinhos) {
//			System.out.println (item);
		
		
//	}
		
		Scanner leitor = new Scanner (System.in);
		int opcao = 0;
		String opcaoinc;
		String novovinhonome;
		String novovinhopreco;
		Item novovinho = new Item();
		String novopratopreco;
		String novopratonome;
		Item novoprato = new Item();
		String novabebnome;
		String novabebpreco;
		Item novabeb = new Item();		
		String query;
		String teste;
		String atualiza;
		String novoprecoat;
do {
	
System.out.println("--------Atividade 5--------");
System.out.println("-------Menu CRUD-------");
System.out.println("\nDigite o número da função que deseja executar");
System.out.println("Digite 1 - Incluir item em um cardápio");
System.out.println("Digite 2 - Excluir item de um cardápio");
System.out.println("Digite 3 - Buscar ou listar item em um cardápio");
System.out.println("Digite 4 - Atualizar item em um cardápio");
System.out.println("");
System.out.println("Digite 0 para sair.");	
	opcao = leitor.nextInt();
	
	
	
	
	switch (opcao) {
	
	case 1: 
		
	System.out.println("Digite o nome do cardápio que deseja incluir item");	
	System.out.println("Bebidas");	
	System.out.println("Pratos");	
	System.out.println("Vinhos");	
	opcaoinc = leitor.next();
	
	if (opcaoinc.equals("Vinhos")) {
		
		System.out.println("Digite o nome do vinho que deseja incluir: ");
		novovinhonome= leitor.next();
		System.out.println("Digite o preço do vinho que deseja incluir");
		novovinhopreco= leitor.next();
		
		novovinho = new Item(novovinhopreco, novovinhonome);
		Cardapio.incluirvinho(novovinho);
		
		System.out.println("Vinho adicionado com sucesso!");
		
	}	
	
	else if (opcaoinc.equals("Pratos")) {
		
		System.out.println("Digite o nome do prato que deseja incluir: ");
		novopratonome= leitor.next();
		System.out.println("Digite o preço do prato que deseja incluir");
		novopratopreco= leitor.next();
		
		novoprato = new Item(novopratonome, novopratopreco);
		Cardapio.incluirprato(novoprato);
		
		System.out.println("Prato adicionado com sucesso!");
		
	}
	
	else if (opcaoinc.equals("Bebidas")) {
		
		System.out.println("Digite o nome da bebida que deseja incluir: ");
		novabebnome= leitor.next();
		System.out.println("Digite o preço da bebida que deseja incluir");
		novabebpreco= leitor.next();
		
		novabeb = new Item(novabebpreco, novabebnome);
		Cardapio.incluirbebida(novabeb);
		
		System.out.println("Bebida adicionada com sucesso!");
		
	}
	else {
		
		System.out.println("Opção inválida! Tente novamente!");
	}
	System.out.println ("\n\nDigite 0 para voltar ao MENU: ");
	opcao = leitor.nextInt();

break;
	
	case 2:	

		
		System.out.println("Digite o nome do cardápio que deseja excluir um item");	
		System.out.println("Bebidas");	
		System.out.println("Pratos");	
		System.out.println("Vinhos");	
		opcaoinc = leitor.next();
		
		if (opcaoinc.equals("Vinhos")) {
			
			System.out.println("Digite o nome do vinho que deseja excluir: ");
			teste = leitor.next();
			
            query = teste;
			
			Item itemRetornado = Cardapio.buscarPorNomeVinho(query);
			Cardapio.excluirvinho(itemRetornado);
			
		}
			

			else if (opcaoinc.equals("Pratos")) {
				
				System.out.println("Digite o nome do prato que deseja excluir: ");
				teste = leitor.next();
				
	            query = teste;
				
				Item itemRetornado = Cardapio.buscarPorNomePrato(query);
				Cardapio.excluirprato(itemRetornado);
				

	}

			else if (opcaoinc.equals("Bebidas")) {
				
				System.out.println("Digite o nome da bebida que deseja excluir: ");
				teste = leitor.next();
				
	            query = teste;
				
				Item itemRetornado = Cardapio.buscarPorNomeBebida(query);
				Cardapio.excluirbebida(itemRetornado);	
			}
	
			else {
				
				System.out.println("Opção inválida! Tente novamente!");
			}
			System.out.println ("\n\nDigite 0 para voltar ao MENU: ");
			opcao = leitor.nextInt();

		break;
	
	case 3: 
		
		System.out.println("Digite o nome do cardápio que deseja mostrar um item específico: ");	
		System.out.println("Bebidas");	
		System.out.println("Pratos");	
		System.out.println("Vinhos");	
		opcaoinc = leitor.next();
		

		if (opcaoinc.equals("Vinhos")) {
			
		
			 List<Item> lista = Cardapio.listarvinhos();


			    for (Item item : lista) {
			        System.out.println (item);
			    }
			
		}
		else if (opcaoinc.equals("Pratos")) { 
			
			
			List<Item> lista = Cardapio.listarpratos();
		
		

	    for (Item item : lista) {
	        System.out.println (item); }    
	    }
		
		else if (opcaoinc.equals("Bebidas")) {
			
			
			 List<Item> lista = Cardapio.listarbebidas();


			    for (Item item : lista) {
			        System.out.println (item);
			
			    }	
			
		}
		
		else {
			
			System.out.println("Opção inválida! Tente novamente!");
		}
		System.out.println ("\n\nDigite 0 para voltar ao MENU: ");
		opcao = leitor.nextInt();

			
	
	break;
	
	case 4:
	
		System.out.println("Digite o nome do cardápio que deseja atualizar um item: ");	
		System.out.println("Bebidas");	
		System.out.println("Pratos");	
		System.out.println("Vinhos");	
		opcaoinc = leitor.next();
		
		if (opcaoinc.equals("Vinhos")) {
			
			System.out.println("Digite o nome do vinho que deseja atualizar: ");
			atualiza = leitor.next();
		    query = atualiza;
		    Item itemRetornar = Cardapio.pesquisarvinho(query);
		    System.out.println("item retornado: " + itemRetornar);
		    System.out.println("Defina um preço novo para " + itemRetornar + ": ");
		    novoprecoat = leitor.next();
		    itemRetornar.setPreco(novoprecoat);
		    Cardapio.atualizarvinho(itemRetornar);
			
		 
			
		}
	
		else if (opcaoinc.equals("Pratos")) {
			
			System.out.println("Digite o nome do prato que deseja atualizar: ");
			atualiza = leitor.next();
		    query = atualiza;
		    Item itemRetornar = Cardapio.pesquisarprato(query);
		    System.out.println("item retornado: " + itemRetornar);
		    System.out.println("Defina um preço novo para " + itemRetornar + ": ");
		    novoprecoat = leitor.next();
		    itemRetornar.setPreco(novoprecoat);
		    Cardapio.atualizarprato(itemRetornar);
			
		 
		}
	
		else if (opcaoinc.equals("Bebidas")) {
			
			System.out.println("Digite o nome da bebida que deseja atualizar: ");
			atualiza = leitor.next();
		    query = atualiza;
		    Item itemRetornar = Cardapio.pesquisarbebida(query);
		    System.out.println("item retornado: " + itemRetornar);
		    System.out.println("Defina um preço novo para " + itemRetornar + ": ");
		    novoprecoat = leitor.next();
		    itemRetornar.setPreco(novoprecoat);
		    Cardapio.atualizarbebida(itemRetornar);
			
		}
		

		else {
			
			System.out.println("Opção inválida! Tente novamente!");
		}
		System.out.println ("\n\nDigite 0 para voltar ao MENU: ");
		opcao = leitor.nextInt();
		
		default:
			
			System.out.println("Opção inválida, tente novamente!");
			break;
	}
	
	
}  while (opcao == 0);

System.out.println("finalizando programa...");
	
}
}	
	

