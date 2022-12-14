
package polish;

import java.util.Scanner;
import java.util.Stack;


public class Polish {


    static Stack yigin = new Stack();
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sr = new Scanner(System.in);
        String text=sr.nextLine();
        System.out.println("Sonuc: "+polishNotation(text));
    }
    public static int polishNotation(String txt)
    {
        String birlesim="";
        for(int i=txt.length()-1; i>=0;i--)
        {
            char ch=txt.charAt(i);
            int ascii = ch;
            if(ascii <= 57 && ascii >=48)
                birlesim = ch+birlesim;
            else if(ch == ' ')
            {
                if(birlesim != "")
                {
                    yigin.push(birlesim);
                    birlesim ="";
                }
            }
            else if (ascii == 43 || ascii == 45 || ascii == 42 || ascii == 47)
            {
                int islem=Integer.parseInt(yigin.pop().toString());
                int islem2=Integer.parseInt(yigin.pop().toString());
                if(ascii == 43)
                    yigin.push(islem+islem2);
                else if(ascii == 45)
                    yigin.push(islem-islem2);
                else if (ascii == 42)
                    yigin.push(islem*islem2);
                else if (ascii == 47)
                    yigin.push(islem/islem2);
            }
        }
        int sonuc=Integer.parseInt(yigin.pop().toString());
        if(yigin.isEmpty() == true)
            return sonuc;
        else { System.out.println("Hatalı İfade Girildi.");
        return 0;
        }
        
        
    }
    
}
