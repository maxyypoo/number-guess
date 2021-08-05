//Doga Akpinaroglu


import java.util.Scanner;
import java.lang.Math;
import java.util.Random;

public class numberGuess {


    public static int randMidPoint(int high, int low)
    {
        Random rand = new Random();
        int randMidPoint = rand.nextInt(high + 1);
        if (randMidPoint < high - low)
        {
            randMidPoint += low;
        }
        return randMidPoint;
    }


    public static char getUserResponseToGuess (int guess)
    {
        Scanner input = new Scanner(System.in);
        char userConfirm;

        System.out.print("Is it " + guess + "?(use h for higher, l for lower, c for confirmation): ");
        userConfirm = input.next().charAt(0);
        
        
            while(userConfirm != 'l' && userConfirm != 'h' && userConfirm != 'c')
            {
                //for some reason, my ide doesn't like it if i dont empty out the input
                //userConfirm = '\n';
                System.out.print("Please enter h for higher, l for lower, c for confirmation: ");
                userConfirm = input.next().charAt(0);
                //debug
                //System.out.println (userConfirm);
            
        }
        //ide doesnt like resource leaks
        //input.close();

        return userConfirm;
    }


    public static int getMidPoint(int high, int low)
    {
        int midPoint;

        midPoint = (int) Math.floor((float)((high + low)/2));

        return midPoint;
    }


    public static void playOneGame ()
    {
        Scanner input = new Scanner(System.in);
        char guessToken;
        int high = 100;
        int low = 1;
        do
        {   
            System.out.print("Guess a number from 1 - 100 ");
            guessToken = getUserResponseToGuess(getMidPoint(low, high));
            //guessToken = getUserResponseToGuess(randMidPoint(low, high));
            if (guessToken == 'h')
            {
                low = getMidPoint(high, low);
                //low = randMidPoint(high, low);
            }
            else if (guessToken == 'l')
            {
                high = getMidPoint(high, low);
                //high = randMidPoint(high, low);
            }
            else;

        }while(guessToken != 'c');

        //input.close();
    }



    static public boolean shouldPlayAgain ()
    {
        Scanner input = new Scanner(System.in);
        boolean play = true;
        char goAgain;
        boolean wrongChar = true;

        System.out.print("Would you like to go again? (y/n): ");
        goAgain = input.next().charAt(0);
        
        do
        {
        if(goAgain == 'y')
        {
            play = true;
        }
        else if (goAgain == 'n')
        {
            play = false;
        }
        else
        {
            wrongChar = false;
        }
        } while (wrongChar == false);

        input.close();
        return play;
    }



    public static void main(String[] args) {


        do {
        
        playOneGame();
        
        } while (shouldPlayAgain());
        
        }




}