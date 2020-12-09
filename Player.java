/**
* Prince Angulo
* Jafet Oidor Ortega
* Lab 5
* Player Class - Set of 3 dice that may be rolled and 
* will accumulate points according to what they roll
*/
import java.util.Scanner;
import java.util.InputMismatchException;

public class Player 
{
   /** The number of dice used in this game */
   private final int NUM_DICE = 3;
   
   /** An array to store the rolled numbers */
   private Die [] dice;
   
   /** A variable to keep track of the player's points*/
   private int points = 0;
   
   /**
   * Constructor - initializes each of the dice
   */
   public Player() 
   {
      dice = new Die[NUM_DICE];
      for( int d = 0; d < dice.length; d++ ) 
      {
         dice[d] = new Die();
      }
   }
   
   /**
   *  Sorts the values of each rolled die 
   *  in ascending order
   */
   public void sort()
   {
      for(int i = 1; i < dice.length; i++)
      {
         Die key = new Die();
         key = dice[i];
         int j = i - 1; 
         while (j >= 0 && !(dice[j].lessThan(key)))
         {
            dice[j+1] = dice[j];
            j--;
            dice[j+1] = key;
         }   
      }
   }
   
   /**
   *  Checks to see if any of the three rolls was a pair
   *  @return - returns true if only two match
   */
   public boolean isPair()
   {
      if(dice[0].equals(dice[1]) || dice[0].equals(dice[2]) || dice[1].equals(dice[2]))
      {
         return true;
      }
      return false;
   }
   
   /**
   *  Checks to see if all three rolls are identical
   *  @return - returns true if all three rolls match
   */
   public boolean isThreeOfKind()
   {
      if(dice[0].equals(dice[1]) && dice[0].equals(dice[2]))
      {
         return true;
      }
      else 
         return false;   
   }
   
   /*
   *  Ckecks to see if the three numbers are in a seres such as 1-2-3
   *  @return - returns true if the numbers are in a series
   */
   public boolean isSeries()
   {
      if(((dice[0].getDieValue() == (dice[1].getDieValue() - 1)) && (dice[0].getDieValue() == (dice[2].getDieValue() - 2))))
      {
         return true;
      }
      else
         return false;
   }
   
   /*
   *  Returns the amount of points accumulated by the player
   *  @return - returns the points accumulated by the player
   */
   public int getPoints()
   {
      return points;
   }
   
   /*
   *  Assembles all of the methods so that the user may actually take a turn
   */
   public void takeTurn()
   {  
      boolean playAgain = true; /** Variable used for the while loop  */ 
      while(playAgain)
      { 
         for( int d = 0; d < dice.length; d++ ) 
         {
            dice[d].roll(); /** Rolls the die 3 times */
         }  
         sort(); /** Sorts the rolls in ascending order */
         
         System.out.println(toString()); /** Prints out the rolls */
         if(isThreeOfKind()) /** Three of a kind is checked first to avoid issues with pairs */
         {
            System.out.println("You got a 3 of a kind!"); 
            points += 3;
         }  
         else if(isPair())
         {
            System.out.println("You got a pair!");
            points +=1;
         }   
         else if(isSeries())
         {  
            System.out.println("You got a series of 3!"); 
            points += 2;    
         }
         else
            System.out.println("Aww. Too bad");
            
         System.out.println("Score = " + getPoints() + " points.");
         System.out.println("Play again? Y/N");
         char input = validateInput();
         switch(input) /** Check to see if player wants to stop */
         {
            case 'N':
            case 'n':
               playAgain = false;
               break;
         }
      }
      System.out.println("Game Over.");
      System.out.println("Final Score = " + points + " points.");
   }
   
   /*
   *  Validates input, making sure that the user inputs either 'Y' or 'N' regardless of capitalization
   *  @return - returns the char variable so that the TakeTurn may check to see if the player wants to stop or not
   */  
   public static char validateInput()
   {
      Scanner input = new Scanner(System.in);
      boolean repeat = true;
      char returnVal = ' ';
      while (repeat)
      {
         returnVal = ' ';
         try
         {
            returnVal = input.next().charAt(0);
            switch(returnVal)
            {
               case 'N':
               case 'n':
               case 'Y':
               case 'y':
                  repeat = false;
                  break;
                  
               default:
                     System.out.println("Invalid Input!");
                     System.out.println("Play again? Y/N");
                     break;
            }
         }catch(InputMismatchException e)
          {
            System.out.println("Invalid Input");
          }
       }
      return returnVal; 
   } 
   
   
   /**
   * String representation of the YahtzeeDice object.
   * @return a string representation of the dice
   */
   @Override
   public String toString() 
   {
      String values = "Rollong Dice... ";
      for( int d = 0; d < dice.length; d++ ) 
      {
         values += "D" + (d+1) + ": " + dice[d] + " ";
      }
         return values;
   }
}

