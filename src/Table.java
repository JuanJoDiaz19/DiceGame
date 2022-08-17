public class Table {
    private Box head;
    private Box tail;
    private boolean turn;

    private Player player1;
    private Player player2;

    public void create(int numBoxes, String namePlayer1, String namePlayer2) {
        turn = true;
        create(numBoxes, 1);
        player1 = new Player(namePlayer1);
        player2 = new Player(namePlayer2);
        head.setPlayer1(player1);
        head.setPlayer2(player2);
    }

    private void create(int numBoxes, int indexBox) {
        if(head == null) {
            //Esto ocurre cuando la linked list esta vacia
            head = new Box(indexBox);
            tail = head;
            create(numBoxes-1, indexBox+1);
        } else if(numBoxes ==0 ) {
          return;
        } else {
            Box tempBox = new Box(indexBox);
            tail.setNext(tempBox);
            tail = tempBox;
            create(numBoxes-1, indexBox+1);
        }
    }

    public void print() {
        print(head);
        System.out.println("");
    }

    //Metodo recursivo
    private void print(Box current){
        //Caso base:
        if(current == null) {
            return;
        }
        //Llamado recursivo:
        System.out.print(current + " ");
        print(current.getNext());

    }

    public boolean move(int num) {
        if(turn) {
            Box box = search();
            Player player  = box.getPlayer1();
            box.setPlayer1(null);
            moveBoxes(num, box).setPlayer1(player);
        } else {
            Box box = search();
            Player player  = box.getPlayer2();
            box.setPlayer2(null);
            moveBoxes(num, box).setPlayer2(player);
        }
        turn = !turn;
        if(tail.getPlayer1() == player1) {
            System.out.println("El ganador del juego es: " + player1.toString());
            return true;
        } else if(tail.getPlayer2() == player2) {
            System.out.println("El ganador del juego es: " + player2.toString());
            return true;
        }else {
            return false;
        }


    }
    private Box moveBoxes(int num, Box box) {
        if (num == 0) {
            return box;
        }
        if(box == tail) {
            return box;
        }
        return moveBoxes(num-1, box.getNext());
    }

    public Box search() {
        if(turn) {
            //Caso cuando juega el J1
            return searchJ1(head);
        } else {
            //Caso cuando juega el J2
            return searchJ2(head);
        }
    }


    public Box searchJ1(Box current) {
        //Casos base

        if(current == null) {
            return null;
        }
        if(current.getPlayer1() != null) {
            return current;
        }
        //Llamados recursivos
        return searchJ1(current.getNext());

    }

    public Box searchJ2(Box current) {
        //Casos base

        if(current == null) {
            return null;
        }
        if(current.getPlayer2() != null) {
            return current;
        }
        //Llamados recursivos
        return searchJ2(current.getNext());

    }
}
