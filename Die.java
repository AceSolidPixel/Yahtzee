/** 
* Prince Angulo
* Jafet Oidor Ortega
* Lab 5
* Die Class - representation of a single die
*/
public class Die 
{
   /** The number of sides of this die */
   private int sides;
   
   /** The value of this die */
   private int dieValue;
   
   /** Default Constructor – creates a six-sided die.
   */
   public Die( ) 
   {
      sides = 6;
      roll();
   }
   
   /** Constructor - rolls to give the die an initial value
   * @param s sets the number of sides of this die
   */
   public Die( int s ) 
   {
      if( s > 1 ) 
      {
         sides = s;
      } 
      else 
      {
         sides = 6;
      }
      roll();
   }
   
   /** Rolls the die
   * @return the die's value
   */
   public int roll() 
   {
      dieValue = (int)( Math.random() * sides ) + 1;
      return dieValue;
   }
   
   /** Retrieve the die's value
   * @return the die's value
   */
   public int getDieValue() 
   {
      return dieValue;
   }
   
   /** Allows the value of the die to be set to a particular
   * value as long as it is within the number of sides.
   * @param value the value the die will be set to
   * @return true if the value could be set, false otherwise
   */
   public boolean setDieValue( int value ) 
   {
      if( value > 0 && value <= sides ) 
      {
         dieValue = value;
         return true;
      } 
      else
      {
         return false;
      }
   }
   
   /** String representation of a Die object
   * @return string representation of this Die
   */
   public String toString() 
   {
      return " " + dieValue;
   }
   
   /** Check to see if rolled number is the same
   *   between the die calling the method, and 
   *   the passed die object.
   *   @param otherDie - a separate who's dieValue will be comapred
   */
   public boolean equals(Die otherDie)
   {
      if(dieValue == otherDie.getDieValue())
         return true;
      else
         return false;
   }
   
   /** Check to see if rolled number stored in the die
   *   calling the method in less than the number rolled 
   *   by the passed die.
   *   @param otherDie - a separate who's dieValue will be comapred
   */
   public boolean lessThan(Die otherDie)
   {
      if(this.dieValue < otherDie.getDieValue())
         return true;
      else
         return false;
   }
}