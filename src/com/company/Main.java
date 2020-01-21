package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    // Statistics
    public static int scores1;
    public static int scores2;
    public static String type;
    public static int rounds;
    public static String p1_name = "player1";
    public static String p2_name = "player2";
    public static boolean nameInit;

    // Scanners
    public static Scanner typeScanner = new Scanner(System.in);
    public static Scanner p1Scanner = new Scanner(System.in);
    public static Scanner p2Scanner = new Scanner(System.in);
    public static Scanner nameScanner = new Scanner(System.in);
    public static Scanner replayScanner = new Scanner(System.in);
    public static Scanner replayGameScanner = new Scanner(System.in);
    public static Scanner resumeScanner = new Scanner(System.in);

    // Localization
    /*
    # ----
    # Soon
    # ----
     */


    public static void main(String[] args) {
        System.out.println("---------------- ✊ ✌ ✋ Game ----------------");
        startGame();
    }

    private static void startGame(){
        nameInit = false;
        scores1 = 0;
        scores2 = 0;
        p1_name = "player1";
        p2_name = "player2";
        type = null;
        rounds = 0;
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
                if(!nameInit){
                    System.out.println("Для старта игры необходимо ввести ваши имена");
                    System.out.println("Первый игрок");
                    p1_name = setName();
                    System.out.println("Второй игрок");
                    p2_name = setName();
                    System.out.println("В игре принимают участие два игрока - "+ p1_name + " и " + p2_name);
                    nameInit = true;
                }
                System.out.println("Для игры в RPS используйте значения \n R(камень), P(бумага), S(ножницы)");
                System.out.println("Ходит "+ p1_name +":");
                player1 = playerWalks(1);
                System.out.println("Ходит "+ p2_name +":");
                player2 = playerWalks(2);
                checkResults(player1, player2);
                break;
            case "2":
                System.out.println("Выбран режим игры с компьютером");
                if(!nameInit){
                    System.out.println("Для старта игры необходимо ввести ваше имя");
                    p1_name = setName();
                    p2_name = "Компьютер";
                    nameInit = true;
                }
                System.out.println("Для игры в RPS используйте значения \n R(камень), P(ножницы), S(бумага)");
                System.out.println("Ходит "+ p1_name +":");
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

    private static String setName(){
        boolean valide;

        do {
            System.out.println("Введите имя");
            String name = nameScanner.nextLine();
            if(name.equals("")){
                System.out.println("Введено пустое значение");
                valide = false;
            }
            else {
                if(p1_name.equals(name) || p2_name.equals(name)){
                    System.out.println("Введите имя, не совпадающее с вашим противником");
                    valide = false;
                }
                else {
                    return name;
                }
            }
        } while (valide = true);
        return "";
    }

    private static int playerWalks(int player){
        String player1;
        int newPlayer1;
        String player2;
        int newPlayer2;
        boolean valide;
        int player0; // Компьютер

        Random random = new Random();
        switch (player){
            case 0:
                player0 = random.nextInt(2);
                player0++;
                System.out.println(convertIntToSymbol(player0));
                return player0;
            case 1:
                do {
                    player1 = p1Scanner.nextLine();
                    newPlayer1 = validateRequest(player1);
                    if(newPlayer1 == 0){
                        valide = false;
                    }
                    else {
                        valide = true;
                        return newPlayer1;
                    }
                } while (valide = true);
                break;
            case 2:
                do {
                    player2 = p2Scanner.nextLine();
                    newPlayer2 = validateRequest(player2);
                    if(newPlayer2 == 0){
                        valide = false;
                    }
                    else {
                        valide = true;
                        return newPlayer2;
                    }
                } while (valide = true);
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
                            System.out.println("Победил "+ p1_name);
                            scores1++;
                            break;
                        case 3:
                            System.out.println("Победил "+ p2_name);
                            scores2++;
                            break;
                    }
                break;
                case 2:
                    switch (p2){
                        case 1:
                            System.out.println("Победил "+ p2_name);
                            scores2++;
                            break;
                        case 3:
                            System.out.println("Победил "+ p1_name);
                            scores1++;
                            break;
                    }
                    break;
                case 3:
                    switch (p2){
                        case 1:
                            System.out.println("Победил "+ p1_name);
                            scores1++;
                            break;
                        case 2:
                            System.out.println("Победил "+ p2_name);
                            scores2++;
                            break;
                    }
                    break;
            }
        }
        rounds++;
        replay();
    }

    private static String convertIntToSymbol (int req) {
        switch (req){
            case 1:
                return "✊";
            case 2:
                return "✌";
            case 3:
                return "✋";
            default:
                return "";
        }
    }

    private static void replay() {
        String replay;
        boolean valide;
        System.out.println("Хотите сыграть ещё раз?");
        do {
            replay = replayScanner.nextLine();
            switch (replay.toLowerCase()) {
                case "да":
                case "y":
                case "yes":
                case "+":
                    gameMode(type);
                    valide = true;
                    break;
                case "нет":
                case "n":
                case "no":
                case "-":
                    showResults();
                    valide = true;
                    break;
                default:
                    System.out.println("Так всё таки да или нет?");
                    valide = false;
                    break;
            }
        } while (valide = true);
    }

    private static void showResults(){
        //float winrate1;
        //float winrate2;
        /*
        ╔═════════════════════════════════════╗
        ║ Статистика текущей игры             ║
        ╠═══════╦══════════════╦══════════════╣
        ║       ║ Первый игрок ║ Второй игрок ║
        ╠═══════╬══════════════╬══════════════╣
        ║ Счёт  ║ 2            ║ 0            ║
        ╠═══════╩══════════════╩══════════════╣
        ║ Количество игр: 5                   ║
        ╠═════════════════════════════════════╣
        ║ Тип игры: с компьютером             ║
        ╚═════════════════════════════════════╝

        ╔═════════════════════════════════════╗
        ║ По итогам игры выиграл первый игрок ║
        ╚═════════════════════════════════════╝
        */
        System.out.println("--- Статистика игры ---");
        switch (type){
            case "1":
                System.out.println("Вы играли с другом");
                // winrate1 = scores1 / ((rounds - scores1) + scores1);
                System.out.println("Счёт: \n " + p1_name + ": "+ scores1 + " \n " + p2_name + ": "+ scores2);
                System.out.println("Сыграно партий: " + rounds);
                if(scores1 == scores2){
                    System.out.println("Победила дружба");
                }
                else {
                    if(scores1 > scores2) {
                        System.out.println("По итогам игры выиграл "+ p1_name);
                    }
                    else {
                        System.out.println("По итогам игры выиграл "+ p2_name);
                    }
                }
                break;
            case "2":
                System.out.println("Вы играли с компьютером");
                // winrate2 = scores2 / ((rounds - scores2) + scores2);
                System.out.println("Счёт: \n " + p1_name + ": "+ scores1 + " \n Компьютер: " + scores2);
                System.out.println("Сыграно партий: " + rounds);
                if(scores1 == scores2){
                    System.out.println("Победила дружба");
                }
                else {
                    if(scores1 > scores2) {
                        System.out.println("По итогам игры "+ p1_name + " обыграл компьютер");
                    }
                    else {
                        System.out.println(p1_name + " проиграл компьютеру");
                    }
                }
                break;
        }
        System.out.println("Введите любой символ чтобы продолжить..");
        String resume = resumeScanner.nextLine();
        replayGame();
    }
    private static void replayGame(){
        boolean valide;
        String type;

        System.out.println("Игра завершена");
        do {
            System.out.println("Выполните одно из следующих действий\n 1. Вернуться к меню игры \n 2. Выйти из игры");
            type = replayGameScanner.nextLine();
            switch (type) {
                case "1":
                    valide = true;
                    System.out.println("Переход в меню..");
                    startGame();
                    break;
                case "2":
                    valide = true;
                    System.out.println("✊ ✌ ✋ ✊ ✌ ✋ ✊ ✌ ✋ ✊ ✌ ✋");
                    System.out.println("✊ ✌ ✋ ✊ RPS  Game ✋ ✊ ✌ ✋");
                    System.out.println("✊ ✌ ✋ ✊ ✌ ✋ ✊ ✌ ✋ ✊ ✌ ✋");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Ошибка");
                    valide = false;
                    break;
            }
        } while (valide = true);
    }
}
