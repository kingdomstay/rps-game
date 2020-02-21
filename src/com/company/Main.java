package com.company;


import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Locale;
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
    public static Scanner selectLocaleScanner = new Scanner(System.in);

    // Localization
    public static String locale;
    public static HashMap<String, HashMap<String, String>> localeData = new HashMap();
    public static HashMap<String, String> localeRU = new HashMap();
    public static HashMap<String, String> localeEN = new HashMap();
    /*
    # ----
    # Soon
    # ----
     */

    public static void main(String[] args) {

//        MenuGUI menuGUI = new MenuGUI();
//        menuGUI.init();

        MenuGUI menuGUI = new MenuGUI();

        // Init localization (import soon)
        localeData.put("RU", localeRU);
        localeData.put("EN", localeEN);
        localeRU.put("startGame", "Для начала игры выберите один из режимов игры: \n 1. Игра с другом \n 2. Игра с компьютером");
        localeEN.put("startGame", "To start the game, select one of the game modes:\n 1. Play with a friend\n 2. Game with a computer");

        localeRU.put("selectedGM1", "Выбран режим игры с другом");
        localeEN.put("selectedGM1", "Game mode with friend selected");
        localeRU.put("selectedGM2", "Выбран режим игры с компьютером");
        localeEN.put("selectedGM2", "Game mode with computer selected");

        localeRU.put("replayGame", "Хотите сыграть ещё раз?");
        localeEN.put("replayGame", "Want to play again?");
        localeRU.put("gameOver", "Игра завершена");
        localeEN.put("gameOver", "Game over");
        localeRU.put("gameOverSelectAction", "Выполните одно из следующих действий\n 1. Вернуться к меню игры \n 2. Выйти из игры");
        localeEN.put("gameOverSelectAction", "Perform one of the following actions\n 1. Return to the game menu\n 2. Quit the game");
        localeRU.put("redirectToMenu", "Переход в меню..");
        localeEN.put("redirectToMenu", "Go to menu..");

        localeRU.put("enterName", "Введите имя для начала игры");
        localeEN.put("enterName", "Enter name to start the game");

        localeRU.put("p1", "Первый игрок");
        localeEN.put("p1", "First player");
        localeRU.put("p2", "Второй игрок");
        localeEN.put("p2", "Second player");

        localeRU.put("computer", "Компьютер");
        localeEN.put("computer", "Computer");

        localeRU.put("takePart", "В игре принимают участие два игрока - "+ p1_name + " и " + p2_name);
        localeEN.put("takePart", "Two players take part in the game - " + p1_name + " and " + p2_name);

        localeRU.put("p1Walks", "Ходит " + p1_name);
        localeEN.put("p1Walks", p1_name + " walks");
        localeRU.put("p2Walks", "Ходит " + p2_name);
        localeEN.put("p2Walks", p2_name + " walks");

        localeRU.put("FAQ", "Для игры в RPS используйте значения \n R(камень), P(бумага), S(ножницы)");
        localeEN.put("FAQ", "To play RPS, use the values \n R (stone), P (paper), S (scissors)");

        localeRU.put("FAQ", "Для игры в RPS используйте значения \n R(камень), P(бумага), S(ножницы)");
        localeEN.put("FAQ", "To play RPS, use the values \n R (stone), P (paper), S (scissors)");

        localeRU.put("FAQ", "Для игры в RPS используйте значения \n R(камень), P(бумага), S(ножницы)");
        localeEN.put("FAQ", "To play RPS, use the values \n R (stone), P (paper), S (scissors)");

        localeRU.put("enterToContinue", "Введите любой символ чтобы продолжить..");
        localeEN.put("enterToContinue", "Enter any character to continue ..");

        // Variations

        localeRU.put("draw", "Ничья");
        localeEN.put("draw", "Draw");
        localeRU.put("win1", "Победил " + p1_name);
        localeEN.put("win1", p1_name + " won");
        localeRU.put("win2", "Победил " + p2_name);
        localeEN.put("win2", p2_name + " won");

        // Errors
        localeRU.put("incorrectValue", "\u001B[31mВведено некорректное значение, попробуйте ещё раз\u001B[0m");
        localeEN.put("incorrectValue", "\u001B[31mIncorrect value entered, try again\u001B[0m");

        localeRU.put("emptyValue", "\u001B[31mВведено пустое значение\u001B[0m");
        localeEN.put("emptyValue", "\u001B[31mNull value entered\u001B[0m");

        localeRU.put("doesNotMatchValue", "\u001B[31mВведите имя, не совпадающее с вашим противником\u001B[0m");
        localeEN.put("doesNotMatchValue", "\u001B[31mEnter a name that does not match your opponent\u001B[0m");

        localeRU.put("errorAndFAQ", "\u001B[31mОшибка \nДля игры в RPS используйте значения \n R(камень), P(ножницы), S(бумага)\u001B[0m");
        localeEN.put("errorAndFAQ", "\u001B[31mError \nTo play RPS, use the values \n R (stone), P (paper), S (scissors)\u001B[0m");
        localeRU.put("replayGameFAQ", "\u001B[31mОшибка \n Используйте слова да или нет для выбора ответа\u001B[0m");
        localeEN.put("replayGameFAQ", "\u001B[31mError \n Use yes or no to select an answer\u001B[0m");

        localeRU.put("error", "\u001B[31mОшибка\u001B[0m");
        localeEN.put("error", "\u001B[31mError\u001B[0m");

        // Statistic

        localeRU.put("statistic", "----- Статистика игры -----");
        localeEN.put("statistic", "----- Game stats -----");
        localeRU.put("youPlayedWithComputer", "Вы играли с компьютером");
        localeEN.put("youPlayedWithComputer", "You played with the computer");
        localeRU.put("score", "Счёт: \n " + p1_name + ": "+ scores1 + " \n " + p2_name + ": " + scores2);
        localeEN.put("score", "Score: \n " + p1_name + ": "+ scores1 + " \n " + p2_name + ": " + scores2);
        localeRU.put("gamesPlayed", "Сыграно партий: " + rounds);
        localeEN.put("gamesPlayed", "Games played: " + rounds);
        localeRU.put("endGameP1", "По итогам игры выиграл " + p1_name);
        localeEN.put("endGameP1", "At the end of the game, " + p1_name + " won");
        localeRU.put("endGameP2", "По итогам игры выиграл " + p2_name);
        localeEN.put("endGameP2", "At the end of the game, " + p2_name + " won");


        System.out.println("---------------- ✊ ✌ ✋ Game ----------------");
        locale = selectLocale();
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
        sendText("startGame");
        type = typeScanner.next();
        gameMode(type);
    }

    private static void sendText(String key) {
        System.out.println(localeData.get(locale).get(key));
    }

    private static String selectLocale (){
        boolean valide;
        do {
            System.out.println("Select a game language to continue:\n 1. Russian(Русский) \n 2. English");
            switch (selectLocaleScanner.nextLine()){
                case "1":
                    valide = true;
                    return "RU";
                case "2":
                    valide = true;
                    return "EN";
                default:
                    sendText("error");
                    valide = false;
                    break;
            }
        } while (valide = true);
        return "";
    }

    private static void gameMode(String type){
        int player1;
        int player2;
        switch (type) {
            case "1":
                sendText("selectedGM1");
                if(!nameInit){
                    sendText("enterName");
                    sendText("p1");
                    p1_name = setName();
                    sendText("p2");
                    p2_name = setName();
                    // Update players
                    localeRU.put("takePart", "В игре принимают участие два игрока - "+ p1_name + " и " + p2_name);
                    localeEN.put("takePart", "Two players take part in the game - " + p1_name + " and " + p2_name);
                    localeRU.put("p1Walks", "Ходит " + p1_name);
                    localeEN.put("p1Walks", p1_name + " walks");
                    localeRU.put("p2Walks", "Ходит " + p2_name);
                    localeEN.put("p2Walks", p2_name + " walks");
                    localeRU.put("win1", "Победил " + p1_name);
                    localeEN.put("win1", p1_name + " won");
                    localeRU.put("win2", "Победил " + p2_name);
                    localeEN.put("win2", p2_name + " won");
                    sendText("takePart");
                    nameInit = true;
                }
                sendText("FAQ");
                sendText("p1Walks");
                player1 = playerWalks(1);
                sendText("p2Walks");
                player2 = playerWalks(2);
                checkResults(player1, player2);
                break;
            case "2":
                sendText("selectedGM2");
                if(!nameInit){
                    sendText("enterName");
                    p1_name = setName();
                    p2_name = localeData.get(locale).get("computer");
                    // Update players
                    localeRU.put("p1Walks", "Ходит " + p1_name);
                    localeEN.put("p1Walks", p1_name + " walks");
                    localeRU.put("p2Walks", "Ходит " + p2_name);
                    localeEN.put("p2Walks", p2_name + " walks");
                    localeRU.put("win1", "Победил " + p1_name);
                    localeEN.put("win1", p1_name + " won");
                    localeRU.put("win2", "Победил " + p2_name);
                    localeEN.put("win2", p2_name + " won");
                    nameInit = true;
                }
                sendText("FAQ");
                sendText("p1Walks");
                player1 = playerWalks(1);
                sendText("p2Walks");
                checkResults(player1, playerWalks(0));
                break;
            default:
                sendText("incorrectValue");
                startGame();
                break;
        }
    }

    private static String setName(){
        boolean valide;

        do {
            String name = nameScanner.nextLine();
            if(name.equals("")){
                sendText("emptyValue");
                valide = false;
            }
            else {
                if(p1_name.equals(name) || p2_name.equals(name)){
                    sendText("doesNotMatchValue");
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
                sendText("errorAndFAQ");
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
            sendText("draw");
            scores1++;
            scores2++;
        }
        else {
            switch (p1){
                case 1:
                    switch (p2){
                        case 2:
                            sendText("win1");
                            scores1++;
                            break;
                        case 3:
                            sendText("win2");
                            scores2++;
                            break;
                    }
                break;
                case 2:
                    switch (p2){
                        case 1:
                            sendText("win2");
                            scores2++;
                            break;
                        case 3:
                            sendText("win1");
                            scores1++;
                            break;
                    }
                    break;
                case 3:
                    switch (p2){
                        case 1:
                            sendText("win1");
                            scores1++;
                            break;
                        case 2:
                            sendText("win2");
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
        sendText("replayGame");
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
                    sendText("replayGameFAQ");
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
        sendText("statistic");
        // Update Variables
        localeRU.put("gamesPlayed", "Сыграно партий: " + rounds);
        localeEN.put("gamesPlayed", "Games played: " + rounds);
        localeRU.put("score", "Счёт: \n " + p1_name + ": "+ scores1 + " \n " + p2_name + ": " + scores2);
        localeEN.put("score", "Score: \n " + p1_name + ": "+ scores1 + " \n " + p2_name + ": " + scores2);
        localeRU.put("endGameP1", "По итогам игры выиграл " + p1_name);
        localeEN.put("endGameP1", "At the end of the game, " + p1_name + " won");
        localeRU.put("endGameP2", "По итогам игры выиграл " + p2_name);
        localeEN.put("endGameP2", "At the end of the game, " + p2_name + " won");

        switch (type){
            case "1":
                // winrate1 = scores1 / ((rounds - scores1) + scores1);
                sendText("score");
                sendText("gamesPlayed");
                if(scores1 == scores2) {
                    sendText("draw");
                }
                else {
                    if(scores1 > scores2) {
                        sendText("endGameP1");
                    }
                    else {
                        sendText("endGameP2");
                    }
                }
                break;
            case "2":
                sendText("youPlayedWithComputer");
                // winrate2 = scores2 / ((rounds - scores2) + scores2);
                sendText("score");
                sendText("gamesPlayed");
                if(scores1 == scores2) {
                    sendText("draw");
                }
                else {
                    if(scores1 > scores2) {
                        sendText("endGameP1");
                    }
                    else {
                        sendText("endGameP2");
                    }
                }
                break;
        }
        sendText("enterToContinue");
        String resume = resumeScanner.nextLine();
        replayGame();
    }
    private static void replayGame(){
        boolean valide;
        String type;

        sendText("gameOver");
        do {
            sendText("gameOverSelectAction");
            type = replayGameScanner.nextLine();
            switch (type) {
                case "1":
                    valide = true;
                    sendText("redirectToMenu");
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
                    sendText("error");
                    valide = false;
                    break;
            }
        } while (valide = true);
    }
}
