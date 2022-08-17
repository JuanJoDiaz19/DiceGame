public class Box {
    //Value:
    private int position;
    private Player player1;

    @Override
    public String toString() {
        String ans = "[ ";
        if(player1 != null) {
            ans += player1.toString();
        }
        if(player2 != null ) {
            if(ans.equals("[ ")) {
                ans+= player2.toString();
            } else {
                ans += " , " + player2.toString();
            }
        }
        if (player1 == null && player2 == null) {
            ans += position;
        }
        ans+= " ]";
        return ans;
    }

    public Box(int position) {
        this.position = position;
    }

    private Player player2;

    //Enlace:
    private Box next;

    //Getters and Setters
    public int getNumber() {
        return position;
    }

    public void setNumber(int number) {
        this.position = number;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Box getNext() {
        return next;
    }

    public void setNext(Box next) {
        this.next = next;
    }



}
