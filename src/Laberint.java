import java.util.Scanner;

public class Laberint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner teclat = new Scanner(System.in);
		
		int fila = 0;
		int columna = 0;
		int filaSalida = 6;
		int columnaSalida = 28;
		int filaPersona = 1;
		int columnaPersona = 1;
	/*	char persona = 'P';
		char salida = 'S';*/
		int vidas = 5;
		boolean piqueta = false;
		String movimiento;
		
		
		
		char [][] laberint= {{'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}, /*30 columnas*/
			  				 {'#', ' ', '/', '#', ' ', ' ', '@', '#', ' ', ' ', ' ', '@', '#', '#', '@', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', '#', ' ', ' ', ' ', '@', '#', '#'},
			  				 {'#', ' ', '#', '#', ' ', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', ' ', '#', ' ', '#', '#', ' ', '#', '#', '#', '#', '#'},
			  				 {'#', ' ', '#', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
			  				 {'#', ' ', ' ', ' ', '#', '#', ' ', '#', '#', '#', ' ', '#', ' ', '#', ' ', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#'},
			  				 {'#', ' ', '#', '#', ' ', ' ', ' ', ' ', '#', ' ', ' ', '#', ' ', ' ', ' ', '#', '#', '#', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', '#'},
			  				 {'#', ' ', ' ', ' ', ' ', '#', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', '#', '#', '#', ' ', '#', '#', ' ', '#', ' ', '#', ' ', '#', ' ', ' ', '#'},
			  				 {'#', '#', ' ', '#', ' ', '#', '#', '#', ' ', '#', '#', ' ', '#', ' ', '#', ' ', ' ', '@', ' ', '#', '#', ' ', '#', ' ', '#', ' ', '#', ' ', '#', '#'},
			  				 {'#', '@', ' ', ' ', ' ', '#', '@', ' ', ' ', '#', '#', ' ', ' ', ' ', ' ', ' ', '#', '#', ' ', ' ', ' ', ' ', '#', '@', ' ', ' ', ' ', ' ', '@', '#'},
			  				 {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}, /*10 filas*/
							 };
		
		char[][] laberintMostrar = {{'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
								   {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
								   {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
								   {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
								   {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
								   {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
								   {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
								   {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
								   {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
								   {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
								   };
		
		laberint[filaSalida][columnaSalida] = 'S';
		laberintMostrar[filaPersona][columnaPersona] = 'P';
		/*
		for (fila = 0; fila < laberint.length; fila++) {
			for (columna = 0; columna < laberint[fila].length; columna++) {
				System.out.print(laberint[fila][columna] + " "); System.out.print(" ");
			}
			System.out.println();
		}
		*/
		for (fila = 0; fila < laberintMostrar.length; fila++) {
			for (columna = 0; columna < laberintMostrar[fila].length; columna++) {
				System.out.print(laberintMostrar[fila][columna] + " "); System.out.print(" ");
			}
			System.out.println();
		}
		
		while(vidas != 0 && (laberint[filaSalida][columnaSalida] != laberint[filaPersona][columnaPersona])) {
			System.out.println("Número de vidas: " + vidas);
			System.out.println("Hacia donde quieres moverte?");
			System.out.println("arriba, abajo, derecha, izquierda:");
			movimiento = teclat.nextLine().toLowerCase();
			
			laberintMostrar[filaPersona][columnaPersona] = ' ';
			
			if(movimiento.equals("w")) {
				if((laberint[filaPersona-1][columnaPersona] == '#') && (piqueta == false)) {
					System.out.println("Lo siento, hay un muro. Vuelve a intentarlo.");
					laberintMostrar[filaPersona-1][columnaPersona] = '#';
				}
				else if(laberint[filaPersona-1][columnaPersona] == '/'){
					System.out.println("Muy bien!! Has encontrado un pico y ahora puedes atravesar los muros (#) hasta la salida.");
					piqueta = true;
					filaPersona = filaPersona-1;
				}
				else if((laberint[filaPersona-1][columnaPersona] == '#') && (piqueta == true)) {
					filaPersona = filaPersona-1;
				}
				else {
					filaPersona = filaPersona-1;
					if(laberint[filaPersona][columnaPersona] == '@') {
						System.out.println("Oh no! Has hecho explotar una bomba y has perdido una vida!!");
						vidas = vidas-1;
						/*laberint[filaPersona][columnaPersona] = ' ';*/
					}
				}
			}
			else if(movimiento.equals("s")) {
				if((laberint[filaPersona+1][columnaPersona] == '#') && (piqueta == false)) {
					System.out.println("Lo siento, hay un muro. Vuelve a intentarlo.");
					laberintMostrar[filaPersona+1][columnaPersona] = '#';
				}
				else if(laberint[filaPersona+1][columnaPersona] == '/'){
					System.out.println("Muy bien!! Has encontrado un pico y ahora puedes atravesar los muros (#) hasta la salida.");
					piqueta = true;
					filaPersona = filaPersona+1;
				}
				else if((laberint[filaPersona+1][columnaPersona] == '#') && (piqueta == true)) {
					filaPersona = filaPersona+1;
				}
				else {
					filaPersona = filaPersona+1;
					if(laberint[filaPersona][columnaPersona] == '@') {
						System.out.println("Oh no! Has hecho explotar una bomba y has perdido una vida!!");
						vidas = vidas-1;
						/*laberint[filaPersona][columnaPersona] = ' ';*/
					}
				}
			}
			else if(movimiento.equals("d")) {
				if((laberint[filaPersona][columnaPersona+1] == '#') && (piqueta == false)) {
					System.out.println("Lo siento, hay un muro. Vuelve a intentarlo.");
					laberintMostrar[filaPersona][columnaPersona+1] = '#';
				}
				else if(laberint[filaPersona][columnaPersona+1] == '/'){
					System.out.println("Muy bien!! Has encontrado un pico y ahora puedes atravesar los muros (#) hasta la salida.");
					piqueta = true;
					columnaPersona = columnaPersona+1;
				}
				else if((laberint[filaPersona][columnaPersona+1] == '#') && (piqueta == true)) {
					columnaPersona = columnaPersona+1;
				}
				else {
					columnaPersona = columnaPersona+1;
					if(laberint[filaPersona][columnaPersona] == '@') {
						System.out.println("Oh no! Has hecho explotar una bomba y has perdido una vida!!");
						vidas = vidas-1;
						/*laberint[filaPersona][columnaPersona] = ' ';*/
					}
				}
			}
			else if(movimiento.equals("a")) {
				if((laberint[filaPersona][columnaPersona-1] == '#') && (piqueta == false)) {
					System.out.println("Lo siento, hay un muro. Vuelve a intentarlo.");
					laberintMostrar[filaPersona][columnaPersona-1] = '#';
				}
				else if(laberint[filaPersona][columnaPersona-1] == '/'){
					System.out.println("Muy bien!! Has encontrado un pico y ahora puedes atravesar los muros (#) hasta la salida.");
					piqueta = true;
					columnaPersona = columnaPersona-1;
				}
				else if((laberint[filaPersona][columnaPersona-1] == '#') && (piqueta == true)) {
					columnaPersona = columnaPersona-1;
				}
				else {
					columnaPersona = columnaPersona-1;
					if(laberint[filaPersona][columnaPersona] == '@') {
						System.out.println("Oh no! Has hecho explotar una bomba y has perdido una vida!!");
						vidas = vidas-1;
						/*laberint[filaPersona][columnaPersona] = ' ';*/
					}
				}
			}
			
			laberintMostrar[filaPersona][columnaPersona] = 'P';
			
			if(laberint[filaPersona][columnaPersona] == '@') {
				laberintMostrar[filaPersona][columnaPersona] = 'X';
				laberint[filaPersona][columnaPersona] = 'X';
			}
			
			for (fila = 0; fila < laberintMostrar.length; fila++) {
				for (columna = 0; columna < laberintMostrar[fila].length; columna++) {
					System.out.print(laberintMostrar[fila][columna] + " "); System.out.print(" ");
				}
				System.out.println();
			}
			
		} //Fin del while
		
		if(laberint[filaSalida][columnaSalida] == laberint[filaPersona][columnaPersona]) {
			System.out.println("Felicidades!! Has encontrado la salida!!");
		}
		else if(vidas == 0) {
			System.out.println("Oh no! Te has quedado sin vidas!!");
			System.out.println("Fin del juego.");
		}
		
	teclat.close();
	}
	

}
