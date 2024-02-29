import java.util.*;

class Flappy3 {
    public static int bird_Position;
    public static int pipe_Position;
    public static int score;

    public static void main(String[] args) {
        initializegame(); // constructor
        runGameLoop(); // constructor

    }

    public static void initializegame() {
        bird_Position = 1;
        pipe_Position = 10;
        score = 0;

        System.out.println("***************************");
        System.out.println("WELCOME TO TEXT FLAPPY GAME");
        System.out.println("***************************");
    }

    public static void runGameLoop() {
        Scanner sc = new Scanner(System.in);
        boolean b = true;
        while (b) {
            displayGame();
            handleUserInput(sc);
            updateGame();
            checkCollisions();
        }
    }

    public static void displayGame() {
        System.out.println("score:" + " " + score);
        System.out.println("*********************");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                if (j == bird_Position && i == 1) {
                    System.out.print("B");
                } else if ((j == pipe_Position && i != 1 && i != 5 && i != 9)) {
                    System.out.print("P");
                } else {
                    System.out.print("-");
                }
            }
            if (i == 1 || i == 5 || i == 9) {
                if (bird_Position == pipe_Position && i == 1) {
                    System.out.print("X - COLLISION");
                } 
				else if (bird_Position == pipe_Position && i == 5) {
                    System.out.print("X - COLLISION");
                } else if (bird_Position == pipe_Position && i == 9) {
                    System.out.print("X - COLLISION");
                }
            }
            System.out.println();
        }
        System.out.println("Press *j* to jump");
    }

    public static void handleUserInput(Scanner sc) {
        char userInput = sc.next().charAt(0);
        if (userInput == 'j') {
            bird_Position--;
        } else if (userInput == 'k') {
            // Do nothing
        }
    }

    public static void updateGame() {
        bird_Position++;
        pipe_Position--;
        if (pipe_Position == -1) {
            pipe_Position = 20;
            score++;
        }
    }

    public static void checkCollisions() {
        if (bird_Position == pipe_Position) {
            System.out.println("GAME OVER! YOUR SCORE IS:" + " " + score);
            System.exit(0);
        }
    }
}

