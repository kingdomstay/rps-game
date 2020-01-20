package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    // Statistics
    public static int scores1;
    public static int scores2;
    public static String type;
    public static int rounds;

    // Scanners
    public static Scanner typeScanner = new Scanner(System.in);
    public static Scanner p1Scanner = new Scanner(System.in);
    public static Scanner p2Scanner = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("------------------ RPS Game ------------------");
        startGame();
    }

    private static void startGame(){
        System.out.println("Для начала игры выберите один из режимов игры: \n 1. Игра с другом \n 2. Игра с компьютером");
        type = typeScanner.next();
        gameMode(type);
    }

    private static void gameMode(String type){
        int player1;
        int player2;
        switch (type) {
            case "1":
                System.out.println("Выбран режим игры с другом");
                System.out.println("Для игры в RPS используйте значения \n R(камень), P(бумага), S(ножницы)");
                System.out.println("Ходит первый игрок:");
                player1 = playerWalks(1);
                System.out.println("Ходит второй игрок");
                player2 = playerWalks(2);
                checkResults(player1, player2);
                break;
            case "2":
                System.out.println("Выбран режим игры с компьютером");
                System.out.println("Для игры в RPS используйте значения \n R(камень), P(ножницы), S(бумага)");
                System.out.println("Ходит игрок:");
                player1 = playerWalks(1);
                System.out.println("Ходит компьютер");
                checkResults(player1, playerWalks(0));
                break;
            default:
                System.out.println("Введено некорректное значение, попробуйте ещё раз");
                startGame();
                break;
        }
    }

    private static int playerWalks(int player){
        String player1;
        int newPlayer1;
        String player2;
        int newPlayer2;
        int player0; // Компьютер

        Random random = new Random();
        switch (player){
            case 0:
                player0 = random.nextInt(2);
                player0++;
                return player0;
            case 1:
                /*for(boolean validated = false; validated = false;){
                    player1 = p1Scanner.nextLine();
                    newPlayer1 = validateRequest(player1);
                    if(newPlayer1 == 0){

                    }
                    else {
                        return newPlayer1;
                    }
                }*/
               /*
                Рабочая версия

                player1 = p1Scanner.nextLine();
                newPlayer1 = validateRequest(player1);
                if(newPlayer1 == 0){
                    p1Scanner.nextLine();
                }
                else {
                    return newPlayer1;
                }*/
                break;
            case 2:
                player2 = p2Scanner.nextLine();
                newPlayer2 = validateRequest(player2);
                if(newPlayer2 == 0){
                    p2Scanner.nextLine();
                }
                else {
                    return newPlayer2;
                }
                break;
        }
        return 0;
    }

    private static int validateRequest(String req){
        switch (req.toLowerCase()){
            case "r":
            case "камень":
            case "rock":
                return 1;

            case "s":
            case "ножницы":
            case "scissors":
                return 2;

            case "p":
            case "бумага":
            case "paper":
                return 3;

            default:
                System.out.println("Ошибка \n Для игры в RPS используйте значения \n R(камень), P(ножницы), S(бумага)");
                return 0;
        }
    }

    public static void checkResults(int p1, int p2){
        /*
        *  return 0 | поражение 1 игрока
        *  return 1 | победа 1 игрока
        *  return 2 | ничья
        * */
        if(p1 == p2){
            System.out.println("Ничья");
            scores1++;
            scores2++;
        }
        else {
            switch (p1){
                case 1:
                    switch (p2){
                        case 2:
                            System.out.println("Победил первый игрок");
                            scores1++;
                            break;
                        case 3:
                            System.out.println("Победил второй игрок");
                            scores2++;
                            break;
                    }
                break;
                case 2:
                    switch (p2){
                        case 1:
                            System.out.println("Победил второй игрок");
                            scores2++;
                            break;
                        case 3:
                            System.out.println("Победил первый игрок");
                            scores1++;
                            break;
                    }
                    break;
                case 3:
                    switch (p2){
                        case 1:
                            System.out.println("Победил первый игрок");
                            scores1++;
                            break;
                        case 2:
                            System.out.println("Победил второй игрок");
                            scores2++;
                            break;
                    }
                    break;
            }
        }
        rounds++;
        replay();
    }

    private static void replay(){
        String replay;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Хотите сыграть ещё раз?");
        replay = scanner.nextLine();
        switch (replay.toLowerCase()){
            case "да":
                gameMode(type);
                break;
            case "нет":
                showResults();
                break;
            default:
                System.out.println("Так всё таки да или нет?");
                scanner.nextLine();
                break;
        }

    }

    private static void showResults(){
        //float winrate1;
        //float winrate2;
        System.out.println("--- Статистика игры ---");
        switch (type){
            case "1":
                System.out.println("Вы играли с другом");
                // winrate1 = scores1 / ((rounds - scores1) + scores1);
                System.out.println("Счёт: \n " + "Первый игрок: "+ scores1 + " \n Второй игрок: " + scores2);
                System.out.println("Сыграно партий: " + rounds);
                if(scores1 > scores2){
                    System.out.println("По итогам игры первый игрок обыграл второго игрока");
                }
                else {
                    System.out.println("По итогам игры второй игрок обыграл первого игрока");
                }
                break;
            case "2":
                System.out.println("Вы играли с компьютером");
                // winrate2 = scores2 / ((rounds - scores2) + scores2);
                System.out.println("Счёт: \n " + "Игрок: "+ scores1 + " \n Компьютер: " + scores2);
                System.out.println("Сыграно партий: " + rounds);
                if(scores1 > scores2){
                    System.out.println("По итогам игры игрок обыграл компьютер");
                }
                else {
                    System.out.println("По итогам игры компьютер обыграл игрока");
                }
                break;
        }

    }
}
