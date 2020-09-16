import java.util.ArrayList;
import java.util.Scanner;

public class LaberintProcediments {
	ArrayList<String> Moviments = new ArrayList<String>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LaberintProcediments programa = new LaberintProcediments();
		programa.inici();
	}
	
	private void inici(){
		Scanner teclat = new Scanner(System.in);
		
		int fila = 0;
		int columna = 0;
		int filaSalida = 6;
		int columnaSalida = 28;
		int filaPersona = 1;
		int columnaPersona = 1;
		String movimiento = null;

		
		char [][] laberint= {{'$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$'}, /*30 columnas*/
			  				 {'$', ' ', ' ', '#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', '#', ' ', ' ', ' ', ' ', '#', '$'},
			  				 {'$', ' ', '#', '#', ' ', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', ' ', '#', ' ', '#', '#', ' ', '#', '#', '#', '#', '$'},
			  				 {'$', ' ', '#', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '$'},
			  				 {'$', ' ', ' ', ' ', '#', '#', ' ', '#', '#', '#', ' ', '#', ' ', '#', ' ', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '$'},
			  				 {'$', ' ', '#', '#', ' ', ' ', ' ', ' ', '#', ' ', ' ', '#', ' ', ' ', ' ', '#', '#', '#', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', '$'},
			  				 {'$', ' ', ' ', ' ', ' ', '#', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', '#', '#', '#', ' ', '#', '#', ' ', '#', ' ', '#', ' ', '#', ' ', ' ', '$'},
			  				 {'$', '#', ' ', '#', ' ', '#', '#', '#', ' ', '#', '#', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', '#', '#', ' ', '#', ' ', '#', ' ', '#', ' ', '#', '$'},
			  				 {'$', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', '#', '#', ' ', ' ', ' ', ' ', ' ', '#', '#', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '$'},
			  				 {'$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$'}, /*10 filas*/
							 };
		
		char[][] laberintMostrar = {{'$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$'},
								   {'$', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '$'},
								   {'$', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '$'},
								   {'$', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '$'},
								   {'$', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '$'},
								   {'$', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '$'},
								   {'$', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '$'},
								   {'$', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '$'},
								   {'$', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '$'},
								   {'$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$'},
								   };
		
		laberint[filaSalida][columnaSalida] = 'S';
		laberintMostrar[filaPersona][columnaPersona] = 'P';
		
		randomPiqueta(laberint);
		randomBombes(laberint);
		mostrarLaberint(laberintMostrar, fila, columna);
		persona(laberint, laberintMostrar, movimiento, filaSalida, columnaSalida, fila, columna);
		
	}
	
	private static char [][] mostrarLaberint(char [][] laberintTabla, int laberintFila, int laberintColumna) {
		
		for (laberintFila = 0; laberintFila < laberintTabla.length; laberintFila++) {
			for (laberintColumna = 0; laberintColumna < laberintTabla[laberintFila].length; laberintColumna++) {
				System.out.print(laberintTabla[laberintFila][laberintColumna] + " "); System.out.print(" ");
			}
			System.out.println();
		}
		return laberintTabla;
	}
	
	public static char [][] randomBombes(char taula [][]) {
			
			int randomBomba = 0;
			int numBomba = 0;
			
			for(int fila = 0; fila < 10; fila++) {
				
				for(int columna = 0; columna < 30; columna++) {
					
					if (taula[fila][columna] == ' ') {
						randomBomba = (int)(Math.random() * 20);
						if (randomBomba == 1 && numBomba<=7) {
							taula[fila][columna] = '@';
							numBomba++;
						}
					}
				}
			}
			
			return taula;
			
	}
	
	public static char [][] randomPiqueta(char taula [][]) {
		int randomPiqueta = 0;
		int numPiqueta = 0;
		
		while(numPiqueta < 1) {
			for(int fila = 0; fila < 10; fila++) {
				
				for(int columna = 0; columna < 30; columna++) {
					
					if (taula[fila][columna] == ' ') {
						randomPiqueta = (int)(Math.random() * 50);
						if (randomPiqueta == 1 && numPiqueta<1) {
							taula[fila][columna] = '/';
							numPiqueta++;
						}
					}
				}
			}
		}
		
		return taula;
		
	}
	
	
	public char [][] persona(char laberint[][], char laberintMostrar[][], String movimiento, int filaSalida, int columnaSalida, int fila, int columna){
		Scanner teclat = new Scanner(System.in);
		
		int filaPersona = 1;
		int columnaPersona = 1;
		int fila2 = 1;
		int columna2 = 1;
		boolean piqueta = false;
		int vidas = 5;
		
		while(vidas != 0 && (laberint[filaSalida][columnaSalida] != laberint[filaPersona][columnaPersona])) {
			System.out.println("Número de vidas: " + vidas);
			System.out.println("Que quieres hacer?");
			System.out.println("arriba(w), abajo(s), derecha(d), izquierda(a), ayuda(y):");
			movimiento = teclat.nextLine().toLowerCase();
			Moviments.add(movimiento);
		
			//laberintMostrar[filaPersona][columnaPersona] = ' ';
			switch (movimiento) {
			case "w":
				fila2 = filaPersona - 1;
				columna2 = columnaPersona;
				break;
			case "s":
				fila2 = filaPersona + 1;
				columna2 = columnaPersona;
				break;
			case "d":
				fila2 = filaPersona;
				columna2 = columnaPersona + 1;
				break;
			case "a":
				fila2 = filaPersona;
				columna2 = columnaPersona - 1;
				break;
			case "y":
				botonAyuda (fila2, columna2, filaSalida, columnaSalida);
				break;
			}
			
				if(laberint[fila2][columna2] == '$') {
					System.out.println("Lo siento, no puedes salir del laberinto. Vuelve a intentarlo.");
					
				}
				else if((laberint[fila2][columna2] == '#') && (piqueta == false)) {
					System.out.println("Lo siento, hay un muro. Vuelve a intentarlo.");
					laberintMostrar[fila2][columna2] = '#';
				}
				else if(laberint[fila2][columna2] == '/'){
					System.out.println("Muy bien!! Has encontrado un pico y ahora puedes atravesar los muros (#) hasta la salida.");
					piqueta = true;
					
					laberintMostrar[filaPersona][columnaPersona] = ' ';
					laberintMostrar[fila2][columna2] = 'P';
					filaPersona = fila2;
					columnaPersona = columna2;
				}
				else if((laberint[fila2][columna2] == '#') && (piqueta == true)) {
					
					laberintMostrar[filaPersona][columnaPersona] = ' ';
					laberintMostrar[fila2][columna2] = 'P';
					filaPersona = fila2;
					columnaPersona = columna2;
				}
				else {
					laberintMostrar[filaPersona][columnaPersona] = ' ';
					
					if(laberint[fila2][columna2] == '@') {
						System.out.println("Oh no! Has hecho explotar una bomba y has perdido una vida!!");
						vidas = vidas-1;
						laberint[fila2][columna2] = ' ';
					}
					laberintMostrar[fila2][columna2] = 'P';
					filaPersona = fila2;
					columnaPersona = columna2;
				}
			
				//separacion -----------------------------------------------
			
			
		
		laberintMostrar[filaPersona][columnaPersona] = 'P';
		
		mostrarLaberint(laberintMostrar, fila, columna);
		}
		
		if(laberint[filaSalida][columnaSalida] == laberint[filaPersona][columnaPersona]) {
			System.out.println("Felicidades!! Has encontrado la salida!!");
			System.out.println("Aquí tienes los movimientos que has hecho.");
			MostrarLlista();
		}
		else if(vidas == 0) {
			System.out.println("Oh no! Te has quedado sin vidas!!");
			System.out.println("Fin del juego.");
			System.out.println("Aquí tienes los movimientos que has hecho.");
			MostrarLlista();
		}
		
		return laberintMostrar;
	}
	
	public static void botonAyuda (int filaPersona, int columnaPersona, int filaSalida, int columnaSalida) {
		
		if((filaPersona == filaSalida) && (columnaPersona < columnaSalida)){
			System.out.println("La salida está en la misma fila a la derecha.");
		}
		else if((filaPersona < filaSalida) && (columnaPersona == columnaSalida)){
			System.out.println("Encontrarás la salida más abajo en la misma columna");
		}
		else if((filaPersona > filaSalida) && (columnaPersona == columnaSalida)){
			System.out.println("Encontrarás la salida más arriba en la misma columna");
		}
		else if((filaPersona < filaSalida) && (columnaPersona < columnaSalida)){
			System.out.println("Encontraras la salida si vas a la derecha y buscas más abajo de tu posición actual.");
		}
		else if((filaPersona > filaSalida) && (columnaPersona < columnaSalida)){
			System.out.println("Encontraras la salida si vas a la derecha y buscas más arriba de tu posición actual.");
		}
		else if((filaPersona < filaSalida) && (columnaPersona > columnaSalida)){
			System.out.println("Encontraras la salida si vas a la izquierda y buscas más abajo de tu posición actual.");
		}
		else if((filaPersona > filaSalida) && (columnaPersona > columnaSalida)){
			System.out.println("Encontraras la salida si vas a la izquierda y buscas más arriba de tu posición actual.");
		}
	}
	
	public void MostrarLlista() {
		for(int a = 0; a < Moviments.size();a++) {
			System.out.print(Moviments.get(a));
			System.out.print(" - ");
		}
	}

}