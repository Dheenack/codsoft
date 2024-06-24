/*
 * Number game:
 * input: a integer between 1 to 100
 * output: a string message (won or lost)
 * Time complexity: O(nxm)
 */
import java.util.*;
//base class
public class task1 {
    public static void main(String...args){
        //required objects
        Random rand= new Random();
        Scanner scan=new Scanner(System.in);
        //required variables
        int random_no;
        int guess;
        boolean choice=true;
        //A game loop
        while(choice){
        //generating a random number between 0 to 100(both bounds are exclusive)
        random_no=rand.nextInt(100)+1;
        System.out.println(random_no);
        for(int i=0;i<5;i++){
            System.out.println("you have "+(5-i)+" chances left");
            System.out.println("Enter your guess:");
            guess = scan.nextInt();
            if(guess==random_no){
                System.out.println("correct guess");
                System.out.println("Your score is "+ ((5-i)*10));
                break;
            }
            else if(guess<random_no){
                System.out.println("Your guess is low...try again");
            }
            else if(random_no<guess){
                System.out.println("Your guess is high. try again.");
            }
            //if guess is wrong at last chance
            if(i==4 && guess!=random_no){
                System.out.println("You lose...! try again");
            }
        }
        
        System.out.println("Do you Want to play again:(true/false)");
        choice=scan.nextBoolean();
        System.out.println("End of while");
        }
        scan.close();
    }
}