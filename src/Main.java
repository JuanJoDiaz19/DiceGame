import java.util.Scanner;

public class Main {
    public static Scanner sc;
    public static Table table;
    public static Dice dice;
    public static int answer;

    public static void main(String[] args) {
        answer = -1;
        dice = new Dice();
        sc = new Scanner(System.in);
        table = new Table();
        System.out.println("Binevenido al juego de APO 1 2022 - 2: ");
        System.out.println("Escribe el numero de columnas: ");
        int columns = sc.nextInt();
        System.out.println("Escribe el numero de filas: ");
        int rows = sc.nextInt();
        sc.nextLine();
        System.out.println("Escribe el nombre del primer jugador: ");
        String name1 = sc.nextLine();
        System.out.println("Escribe el nombre del segundo jugador: ");
        String name2 = sc.nextLine();
        table.create(columns * rows, name1, name2 );
        //table.print();
        while (answer != 3){
            System.out.println("Menú del programa: " + "\n1. Tirar dado\n2. Ver tablero\n3. Salir" );
            answer = sc.nextInt();
            sc.nextLine();
            execute(answer);
        }

    }

    private static void execute(int option) {
        switch (option) {
            case 1:
                int diceMove = dice.diceMove();
                System.out.println("El dado salió: " + diceMove);
                if(table.move(diceMove)) {
                    System.out.println("El juego se acabó :)");
                    answer = 3;
                }

                break;
            case 2:
                table.print();
                break;

        }
    }
}
