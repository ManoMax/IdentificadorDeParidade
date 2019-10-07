package circuitoCombinacional;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author ManoMax 
 */

public class ParidadePar {

	private static int verificadorDeParidade(LinkedList<Integer> bits) {
		
		int bit1, bit2;
		LinkedList<Integer> rec = new LinkedList<>();

		if (bits.size() % 2 == 1) {
			rec.add(bits.get(0));
			for(int i = 1; i < bits.size(); i+=2) {
				bit1 = bits.get(i); bit2 = bits.get(i+1);
				if (bit1 != bit2) rec.add(1);
				else rec.add(0);
			}
		} else {
			for(int i = 0; i < bits.size(); i+=2) {
				bit1 = bits.get(i); bit2 = bits.get(i+1);
				if (bit1 != bit2) rec.add(1);
				else rec.add(0);
			}
		}
		
		int exit;
		if (rec.size() >= 2) exit = verificadorDeParidade(rec);
		else {
			if (bits.size() % 2 == 1) {
				if (rec.get(0) != bits.get(0)) exit = 1;
				else exit = 0;
			}
			else exit = rec.get(0);
		}
		return exit;
		
	}
	
	private static LinkedList<Integer> geradorDeParidade(LinkedList<Integer> bits) {
		
		LinkedList<Integer> result = new LinkedList<>();
		
		int bitDeParidade = verificadorDeParidade(bits);
		
		result.add(bitDeParidade);
		for (int i = 0; i < bits.size(); i++) result.add(bits.get(i));
		
		return result;
		
	}
		
	public static void main(String[] args) {

		while(true) {
			System.out.println("\nDigite uma sequencia de bits: ");
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			String bitsStr = sc.next();
			
			if(verificaEntrada(bitsStr)) {
				LinkedList<Integer> bits = new LinkedList<>();
				for (int i = 1; i <= bitsStr.length(); i++) {
					int bit = Integer.parseInt(bitsStr.substring(i-1, i));
					bits.add(bit);
				}
				
				if (verificadorDeParidade(bits) == 1) {
		        	System.out.println("Erro de Paridade.");
					bits = geradorDeParidade(bits);
					System.out.println("Para corrigir, a sequencia de bits ficará: " + bits);
				} else 
		        	System.out.println("Essa sequencia de bits não possui erro de Paridade.");
				bitsStr = "";
			} else {
				System.out.println("Entrada Invalida. Por favor, digite uma sequencia de 0 ou 1.");
			}
		}
	}

	private static boolean verificaEntrada(String bitsStr) {
		boolean exit = true;
		for(int i = 1; i < bitsStr.length(); i++) {
			if (!bitsStr.substring(i-1, i).equals("1")) {
				if (!bitsStr.substring(i-1, i).equals("0")) {
					exit = false;
					break;
				}
			}
		}
		return exit;
	}

}
