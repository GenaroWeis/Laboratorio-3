package ar.edu.utn.frbb.tup.Inputs;

import java.util.Scanner;

public class BaseInputProcessor {
    
    protected Scanner scanner = new Scanner(System.in);//para el input


    protected static void clearScreen() {//limpia la pantalla
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
