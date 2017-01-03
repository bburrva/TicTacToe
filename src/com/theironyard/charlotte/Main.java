package com.theironyard.charlotte;

public class Main {

    public void start() {
        TicTacToe game = new TicTacToe();

        System.out.println("Hi! Tic Tac Toe is designed for two people. Unless you're a lonely soul.");
        System.out.println("What is Player 1's name?");
        game.setPlayer1(game.getInput());
        System.out.println("What is Player 2's name?");
        game.setPlayer2(game.getInput());

        boolean play = true;

        while (play) {
            game.init();
            System.out.println(game.drawBoard());

            String player = null;
            while (!game.winner() && game.getPlays() < 9) {
                player = game.getCurrentPlayer() == 1 ? game.getPlayer1() : game.getPlayer2();
                        boolean validPick = false;
                        while (!validPick) {
                            System.out.printf("It is %s's turn. Pick a square.", player);
                            String square = game.getInput();
                            if (square.length() == 1 && Character.isDigit(square.toCharArray() [0])) {
                                int pick = 0;
                                try {
                                    pick = Integer.parseInt(square);
                                } catch (NumberFormatException e) {

                                }
                                validPick = game.placeMarker(pick);
                            }
                            if (!validPick) {
                                System.out.println("That square can't be chosen. Pick a different one.");
                            }
                        }
                        game.switchPlayers();
                        System.out.println("\n" + game.drawBoard() + "\n");
            }
            if (game.winner()) {
                System.out.printf("Game over. %s wins!", player);
            } else {
                System.out.println("Game was a draw. Might I suggest using a different tactic next time?");
            }
            System.out.println("\n Play again? y/n");
            String choice = game.getInput();
            if (!choice.equalsIgnoreCase("y")) {
                play = false;
            }
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }
}
