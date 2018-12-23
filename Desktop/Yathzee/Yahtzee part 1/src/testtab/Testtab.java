/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testtab;        //include the class DICE

import java.util.Scanner;
//import java.io.*;
//import dice;

/**
 *
 * @author Nicolas
 */
public class Testtab {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int choice, choice1, choice2, choice3, choice4, choice5;
        int array[] = new int[5];       //array of the results of all 5 dices
        int arrayScore[] = new int[6];  //Results of the once, two, three, four, five, six
        for (int n = 0; n < arrayScore.length; n++) {       //initialisation
            arrayScore[n] = -1;     // -1 and not 0 because if one score is 0, it make problem
        }

        System.out.println(" *****  Welcome to the YATHZEE Game  *****");       //MENU
        System.out.println("* What do you want ? *");
        System.out.println("1) Play the game ?");
        System.out.println("2) Rules");
        System.out.println("3) Exit");
        Scanner pp = new Scanner(System.in);
        choice5 = pp.nextInt();

        switch (choice5) {
            case 1:

                dice DE1 = new dice(1);     //Initialisation of all dices
                dice DE2 = new dice(2);
                dice DE3 = new dice(3);
                dice DE4 = new dice(4);
                dice DE5 = new dice(5);

                for (int p = 1; p < 7; p++) {
                    System.out.println("Tour " + p);
                    System.out.println("LAUNCH THE DICE :");
                    DE1.launch();
                    DE2.launch();
                    DE3.launch();
                    DE4.launch();
                    DE5.launch();

                    array[0] = DE1.getNumber();     //Initialisation of the array of results
                    array[1] = DE2.getNumber();
                    array[2] = DE3.getNumber();
                    array[3] = DE4.getNumber();
                    array[4] = DE5.getNumber();

                    for (int i = 0; i < array.length; i++) {        //Print the array
                        System.out.println(" [" + array[i] + "]");
                    }

                    for (int u = 0; u < 2; u++) {       //loop to choice if the user want to mix or not his dices
                        System.out.println("1) Continue ?");
                        System.out.println("2) Exit ?");
                        Scanner keybo = new Scanner(System.in);
                        choice5 = keybo.nextInt();

                        if (choice5 == 1) {
                            System.out.println("How many dice do you want to change ?");       //How many dice he want mix
                            Scanner keyboard = new Scanner(System.in);
                            choice = keyboard.nextInt();

                            for (int j = 0; j < choice; j++) {
                                System.out.println("wich one?");     //user choice which one he want
                                Scanner key = new Scanner(System.in);
                                choice1 = key.nextInt();

                                if (choice1 == DE1.id) {     //Condition to Launch the id of dice that user has decided for all dice
                                    DE1.launch();
                                }
                                if (choice1 == DE2.id) {
                                    DE2.launch();
                                }
                                if (choice1 == DE3.id) {
                                    DE3.launch();
                                }
                                if (choice1 == DE4.id) {
                                    DE4.launch();
                                }
                                if (choice1 == DE5.id) {
                                    DE5.launch();
                                }
                            }

                            array[0] = DE1.getNumber();     //Re-Initialisation of the results array with the new number of the dices
                            array[1] = DE2.getNumber();
                            array[2] = DE3.getNumber();
                            array[3] = DE4.getNumber();
                            array[4] = DE5.getNumber();

                            System.out.println("Result Array: ");
                            for (int k = 0; k < array.length; k++) {
                                System.out.println(" [" + array[k] + "]");
                            }
                        } else if (choice5 == 2) //Let to the user to stop the launch and quit the loop 
                        {
                            break;
                        }
                    }

                    System.out.println("Final Results array: ");            //print of the final result array
                    for (int a = 0; a < array.length; a++) {
                        System.out.println(" [" + array[a] + "]");
                    }

                    System.out.println("1) Once");      //Menu; user choice which number of dice he want to sum 
                    System.out.println("2) Two");
                    System.out.println("3) Three");
                    System.out.println("4) Four");
                    System.out.println("5) Five");
                    System.out.println("6) Six");
                    System.out.println("What do you want ?");

                    Scanner k = new Scanner(System.in);
                    choice4 = k.nextInt();

                    if (arrayScore[choice4 - 1] != -1) {        //Indeed, if the user has already did one of this, it's not possible to restart 
                        System.out.println("Already did that one");
                        System.out.println("Choose another one");
                        System.out.println("1) Once");
                        System.out.println("2) Two");
                        System.out.println("3) Three");
                        System.out.println("4) Four");
                        System.out.println("5) Five");
                        System.out.println("6) Six");
                        System.out.println("What do you want ?");

                        Scanner ko = new Scanner(System.in);
                        choice4 = ko.nextInt();
                        int somme1 = 0;         //initialisation of the sum 
                        for (int f = 0; f < array.length; f++) {        //course the array, and if the dice equal the choice of the user, we sum it
                            if (array[f] == choice4) {
                                somme1 = somme1 + array[f]; //sum it
                            }
                            arrayScore[choice4 - 1] = somme1;   // -1 because an array start at 0
                        }

                    } else {        //else if the user hasn't do this case, same thing that before
                        int somme = 0;
                        for (int i = 0; i < array.length; i++) {
                            if (array[i] == choice4) {
                                somme = somme + array[i];
                            }
                            arrayScore[choice4 - 1] = somme;
                        }

                    }
                    System.out.println(" Score Array : ");      //Print the array of score
                    for (int i = 0; i < arrayScore.length; i++) {
                        System.out.println(" [" + arrayScore[i] + "]");
                    }

                }
                int sommeTOTAL = 0;         //Sum of all the score from the array of score
                for (int e = 0; e < arrayScore.length; e++) {
                    sommeTOTAL = sommeTOTAL + arrayScore[e];
                }

                if (sommeTOTAL > 63) {          //Bonus 
                    sommeTOTAL = sommeTOTAL + 35;
                }

                System.out.println(" FINAL SCORE :       " + sommeTOTAL);       //print the final score
                System.exit(0);
                break;

            case 2:     //rules of the games
                System.out.println("In each turn a player may throw the dice up to three times. A player doesn't have to roll all five dice"
                        + " on the second and third throw of a round, he may put as many dice as he wants to the side and only throw the "
                        + "ones that don't have the numbers he's trying to get. For example, a player throws and gets 1,3,3,4,6. He decides "
                        + "he want to try for the large straight, 1,2,3,4,5. So, he puts 1,3,4 to the side and only throws 3 and 6 again, "
                        + "hoping to get 2 and 5.\n"
                        + "\n" + "In this game you click on the dice you want to keep. They will be moved down and will not be thrown the next "
                        + "time you press the 'Roll Dice' button. If you decide after the second throw in a turn that you don't want to keep"
                        + " the same dice before the third throw then you can click them again and they will move back to the table and be "
                        + "thrown in the third throw.");
                break;

            case 3:
                System.exit(0);
                break;

            default:
                System.exit(-1);
                break;
        }

    }

}
