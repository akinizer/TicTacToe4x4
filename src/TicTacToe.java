import javax.swing.*;
import java.util.Scanner;
class TicTacToe extends JFrame {

    private String[][] tictac = new String[4][4];


    TicTacToe() {

        Scanner scanner = new Scanner(System.in);
        int x,y;
        String s;

        build();

        boolean turn=true;
        while (true){
            int cnt=0;
            System.out.print("Enter x y sign: ");

            x = scanner.nextInt();
            y = scanner.nextInt();
            s = scanner.next();

            if( (1<=x && x<=4) && (1<=y && y<=4) && (s.equals("X") || s.equals("O")) ) {
                x=x-1;
                y=y-1;

                // Conditions to put
                if(tictac[y][x].equals(" ")){
                    tictac[y][x]=s;
                    printBoard();
                    if(tictac[y][x].equals("X")){
                        if( (y>=2)&&tictac[y-1][x].equals("O")&&tictac[y-2][x].equals("X")
                                || (y<2)&&tictac[y+1][x].equals("O")&&tictac[y+2][x].equals("X")
                                || (x>=2)&&tictac[y][x-1].equals("O")&&tictac[y][x-2].equals("X")
                                || (x<2)&&tictac[y][x+1].equals("O")&&tictac[y][x+2].equals("X")
                                || (y>=2&&x>=2)&&tictac[y-1][x-1].equals("O")&&tictac[y-2][x-2].equals("X")
                                || (y<2&&x<2)&&tictac[y+1][x+1].equals("O")&&tictac[y+2][x+2].equals("X")
                                || (y<2&&x>=2)&&tictac[y+1][x-1].equals("O")&&tictac[y+2][x-2].equals("X")
                                || (y>=2&&x<2)&&tictac[y-1][x+1].equals("O")&&tictac[y-2][x+2].equals("X")
                            )
                            {
                                if(turn)
                                    System.out.println("Congragulations! P1 won");
                                else
                                    System.out.println("Congragulations! P2 won");

                                break;
                            }
                    }
                    else if(tictac[y][x].equals("O")){
                        if( (y>=1&&y<=2)&&tictac[y-1][x].equals("X")&&tictac[y+1][x].equals("X")
                                || (x>=1&&x<=2)&&tictac[y][x-1].equals("X")&&tictac[y][x+1].equals("X")
                                || (y>=1&&y<=2)&&(x>=1&&x<=2)&&tictac[y-1][x-1].equals("X")&&tictac[y+1][x+1].equals("X")
                                || (y>=1&&y<=2)&&(x>=1&&x<=2)&&tictac[y-1][x+1].equals("X")&&tictac[y+1][x-1].equals("X")
                        )
                        {
                            if(turn)
                                System.out.println("Congragulations! P1 won");
                            else
                                System.out.println("Congragulations! P2 won");

                            break;
                        }
                    }

                    turn = !turn;
                }
            }

        }
    }

    private void printBoard(){

        for ( int i = 0; i < 4; i++ ){
            for ( int j = 0; j < 4; j++ ){
                System.out.print(tictac[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void build(){
        for ( int i = 0; i < 4; i++ ){
            for ( int j = 0; j < 4; j++ ){
                tictac[i][j] = " ";
            }
        }
    }


}
