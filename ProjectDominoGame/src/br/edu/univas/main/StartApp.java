package br.edu.univas.main;


import java.util.Scanner;

import br.edu.univas.list.List;
import br.edu.univas.list.Piece;

public class StartApp {
	
	
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("::::: JOGO DE DOMINÓ :::::");
	
		List allPieces = new List();
		List player1 = new List();
		List player2 = new List();
		List board = new List();
		
		
		allPieces.createPieces();
		allPieces.setPieces(player2,allPieces);
		allPieces.setPieces(player1, allPieces);
		
		boolean endMacth = false;
					
			do {
				
				endMacth = playerPlay(player2, board, allPieces);
				
				if (endMacth == false) { 
				
					endMacth = computerPlay(player1, board, allPieces);
					
					if (endMacth == true) { 
						System.out.println("::::: VOCÊ PERDEU :::::");									
					}
					
				}else {
					System.out.println("::::: VOCÊ GANHOU :::::");
					
				}
													
			}while(endMacth != true);
			
		System.out.println("::::: FIM DO JOGO :::::");
		
	}
	
	private static boolean computerPlay(List list, List piecesBoard, List allPiece) {
		
		String verify = "SEM PEÇAS";
		Piece piece;
		int choise = 0;
		boolean endMacth = false;
		boolean aux = false;
			
		while (true) {
			
			int verified = list.listLength(list);
			
			if (choise <= verified) {
				
				piece = list.getElement(choise);
				aux = piecesBoard.movePiece(piecesBoard, piece);
				
				if (aux == true) {
					piece = list.remove(piece.toString());
					break;
				
				}else {
				
					choise++;
				}
			
			}else {
				System.out.println("::::: COMPUTADOR PASSOU A RODADA :::::");
				insertRandom(list, allPiece);
				break;
			
			}
					
		}
		pieceBoard(piecesBoard);
		
		if (verify.equals(list.getAsString())) {
			
			endMacth = true;
			
		}
		
		return endMacth;
	}

	public static int readInteger () {
		
		int number = input.nextInt();
		input.nextLine();		
		return number;
	}
	
	public static boolean playerPlay (List list, List piecesBoards, List allPiece) {
		
		String verify = "SEM PEÇAS";
		boolean endGame = false;
		Piece piece;
		int choise;
		
		System.out.printf("\n::::: SELECIONE A POSIÇÃO DA PEÇA PARA JOGAR :::::"
						+ "\n::::: 30 - COMPRAR PEÇA :::::\n");
		
		
		while(true) {
			
			System.out.printf("\n::::: SUA MÃO :::::\n");
			System.out.println(list.getAsString());
			choise = readInteger();
			
			if (choise == 30) {
				
				ShopPiece(allPiece);
				
				choise = readInteger();
				
				if (choise == 40) {
					
					newPiece(list, allPiece);
					System.out.println("PASSOU A VEZ");
					break;
				
				}else if (choise == 50) {
					
					newPiece(list,allPiece);
					continue;
					
				}else {
		
					System.out.println("::::: DIGITE NOVAMENTE :::::");				
				}
			}
			
			choise--;
			int verified = list.listLength(list);
			
			if (choise <= verified && choise >= 0) {
				
				piece = list.getElement(choise);
				boolean aux = piecesBoards.movePiece(piecesBoards, piece);
				
				if (aux == true) {
					
					piece = list.remove(piece.toString());
					
					if (verify.equals(list.getAsString())) {
						
						endGame = true;		
					}
					
					break;
				
				}else {
					System.out.printf("\n::::: PEÇA INVÁLIDA :::::\n");
					continue;
				}
			}
			
			System.out.printf("\n::::: SELEÇÃO INVÁLIDA :::::\n");
		}
		pieceBoard(piecesBoards);
	
		return endGame;
	}
	
	public static void insertRandom (List list, List allPiece) {
		
		int aux = allPiece.listLength(allPiece);;
		Piece piece;
		aux = 1 + (int) (Math.random() * aux);
		piece = allPiece.getElement(aux);
		piece = allPiece.remove(piece.toString());
		list.insert(piece);
		
		
	}
	
	public static void newPiece (List list, List allPiece) {
		
		Piece piece;
		int aux;

		System.out.printf("\n::::: SELECIONE A POSIÇÃO DA PEÇA PARA COMPRAR :::::\n");
		
		aux = readInteger();
		aux--;
		piece = allPiece.getElement(aux);
		piece = allPiece.remove(piece.toString());
		list.insert(piece);		
	
	}public static void pieceBoard (List pieceBoard) {
		System.out.printf("\n::::: MESA :::::\n");
		System.out.println(pieceBoard.getAsString());
			
	}public static void ShopPiece (List list) {
		System.out.printf("\n::::: SELECIONE A POSIÇÃO DA PEÇA PARA COMPRAR :::::"
						+ "\n:::::40 - COMPRAR E PASSA VEZ:::::"
						+ "\n:::::50 - COMPRAR E JOGAR :::::\n");
		System.out.println(list.getAsString());
			
	}
	
}
