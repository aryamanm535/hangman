import java.util.*;
class hangman
{
    ArrayList <String> hang = new ArrayList();
    String word;

    hangman(String word)
    {
        this.word = word;
    }

    void setGame()
    {
        for(int i=0; i<word.length(); i++)
        {
            if(Character.toString(word.charAt(i)).equalsIgnoreCase("A")||Character.toString(word.charAt(i)).equalsIgnoreCase("E")||Character.toString(word.charAt(i)).equalsIgnoreCase("O")||Character.toString(word.charAt(i)).equalsIgnoreCase("U")||Character.toString(word.charAt(i)).equalsIgnoreCase("I"))
                hang.add("x");
            else
                hang.add("-");
        }
    }

    void playGame()
    {
        int tries = 0;
        Scanner g = new Scanner(System.in);
        for(int i=0; i<7;)
        {
            displayBoard();
            System.out.print("\n"+tries(tries));
            System.out.println("\nGuess a letter:");
            char x = g.next().charAt(0);
            x = Character.toLowerCase(x);
            if(inString(word,x) && !repeat(x))
                setLetter(x);
            else
            {
                i++;
                tries++;
            }
            if(tries == 7)
            {
                displayBoard();
                System.out.print("\n"+tries(tries));
                System.out.println("\nYou lose!");
                System.out.println("The word was "+word);
                break;
            }
            if(gameWon())
            {
                displayBoard();
                System.out.println("\nYou win!");
                break;
            }
        }
    }

    void setLetter(char x)
    {
        for(int i=0; i<word.length(); i++)
            if(word.charAt(i)==x)
            {
                hang.set(i, Character.toString(x)); 
            }
    }

    boolean inString(String s, char a)
    {
        for(int i=0; i<s.length(); i++)
            if(s.charAt(i) == a)
                return true;
        return false;
    }

    String tries(int x)
    {
        switch(x)
        {
            case 0: return "";
            case 1: return "H";
            case 2: return "HA";
            case 3: return "HAN";
            case 4: return "HANG";
            case 5: return "HANGM";
            case 6: return "HANGMA";
            case 7: return "HANGMAN";
            default: return "";
        }
    } 

    boolean repeat(char x)
    {
        for(int i=0; i<hang.size(); i++)
            if(hang.get(i).equals(Character.toString(x)))
                return true;
        return false;
    }

    boolean gameWon()
    {
        for(int i=0; i<hang.size(); i++)
            if(!Character.toString(word.charAt(i)).equals(hang.get(i)))
                return false;
        return true;
    }

    void displayBoard()
    {
        for(int i=0; i<hang.size(); i++)
            System.out.print(hang.get(i));
    }

    public static void main(String x)
    {
        hangman var1 = new hangman(x);
        var1.setGame();
        var1.playGame();
    }
}
