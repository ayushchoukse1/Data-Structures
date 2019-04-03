package com.practice.algorithms.misc;
import java.util.Scanner;

public class HangmanTest2
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        int  noOfGuesses =0,lettersCorrect=0;
        String choiceToPlay, userGuess;
        char menuChoice, letter;
        char [] guessWord = {'h', 'e', 'l', 'l', 'o'};
        char [] correctLetter = {'-', '-', '-', '-', '-'};

        System.out.println("Hello and welcome to Hangman!");

        //main game menu
        do
        {  System.out.println("Do you want to play? Press Y/N\n");
            choiceToPlay = keyboard.next();
            menuChoice = choiceToPlay.charAt(0);

            if(!(menuChoice == 'y'||menuChoice == 'Y'||menuChoice == 'n'||menuChoice =='N'))
            {
                System.out.println("You have entered an invalid option. Try again!\n");
            }//if invalid

        }//do
        while (!(menuChoice =='Y' ||menuChoice=='y'||menuChoice == 'n'|| menuChoice =='N'));

        if(menuChoice == 'N'||menuChoice =='n')
        {
            System.out.println("You have chosen to leave the game.");
            System.out.println("Goodbye!");
            System.exit(0);
        }//if

        else
        {

            while(lettersCorrect <5)
            {
                //Getting users guess.
                System.out.println("\nThe guess word has 5 letters.");
                System.out.println("Enter a letter to guess: ");

                userGuess = keyboard.next();
                letter = userGuess.charAt(0);

                //Incrementing letters each time.
                noOfGuesses++;

                if(letter == guessWord[0])
                {
                    System.out.println("There is 1 H in the word");
                    System.out.println("You have guessed the first letter correctly.");
                    correctLetter[0] = letter;
                    System.out.println(correctLetter);
                    System.out.println("You have had " + noOfGuesses + " guesses, so far");

                    lettersCorrect++;

                    System.out.println("Letters correct so far: "+lettersCorrect);
                }//if first letter

                else if(letter==guessWord[1])
                {
                    System.out.println("There is 1 E in the word");
                    System.out.println("You have guessed the second letter correctly.");

                    correctLetter[1] = letter;
                    System.out.println(correctLetter);
                    System.out.println("You have had " + noOfGuesses + " guesses, so far");

                    lettersCorrect++;

                    System.out.println("Letters correct so far: "+lettersCorrect);
                }//if second letter

                else if(letter ==guessWord[2]||letter==guessWord[3])
                {
                    System.out.println("There are 2 L's in the word");
                    System.out.println("You have guessed the third and fourth letters correctly.");

                    correctLetter[2] = letter;
                    correctLetter[3]=letter;
                    System.out.println(correctLetter);
                    System.out.println("You have had " + noOfGuesses + " guesses, so far");

                    lettersCorrect+=2;

                    System.out.println("Letters correct so far: "+lettersCorrect);

                }//if third and fourth letters

                else if(letter ==guessWord[4])
                {
                    lettersCorrect++;
                    System.out.println("There is 1 O in the word");
                    System.out.println("You have guessed the fifth letter correctly.");
                    correctLetter[4] = letter;
                    System.out.println(correctLetter);
                    System.out.println("You have had " + noOfGuesses + " guesses, so far");
                    System.out.println("Letters correct so far: "+lettersCorrect);
                }//if fifth letter

                else
                {
                    System.out.println("The letter you guessed is not in the word.\n");
                    System.out.println("Guesses taken so far: "+noOfGuesses);
                    System.out.println("Letters correct so far: "+lettersCorrect);
                }//else incorrect letter

                if(noOfGuesses >= 3){
                    break;
                }

            }//while loop

            if(noOfGuesses >= 3){
                System.out.println("\nYou couldn't found the word!");
                System.out.println("It was hello.");
                System.out.println("Total guesses: " + noOfGuesses);
                System.exit(0);
            }else {
                System.out.println("\nYou found the word!");
                System.out.println("It was hello.");
                System.out.println("Total guesses: " + noOfGuesses);
                System.exit(0);
            }
        }//else
    }//main
}//class