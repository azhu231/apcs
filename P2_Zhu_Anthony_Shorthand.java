/** Anthony Zhu
 * October 28th 2018
 * Period 2 Ferrante
 * Time: 180 minutes 
 *This lab was the first very challenging lab that I had to complete. I used part of my code from CodingBat 
 *in order to separate the words but I was still unsuccesful in dealing with non-space word separators. I got
 *around this by treating every block of entirely nonletter characters or entirely letter characters as a 
 *"word" and then I processed each of those words with the specified rules. I still had a lot of index errors 
 * that I got around by placing saftey conditions in my helper method and regular method. This lab for me was a lot 
 * of trial and error, which is unlike what I was getting used to: knowing the code I wanted to write and 
 * writing it out on my first try. I think I need to understand loops and strings better so that I can write programs
 * like these without using trial and error.
 */

public class P2_Zhu_Anthony_Shorthand{
   
    public String translatesToShorthand(String str){
        String finalstring = "";
        int i = 0;
        while (i < str.length()){
            String str2 = getWord(str, i);
            if (str2.equalsIgnoreCase("and")){
                str2 = "&";
            }
            if (str2.equalsIgnoreCase("to")){
                str2 = "2";
            }
            if (str2.equalsIgnoreCase("you")){
                str2 = "u";
            }
            if (str2.equalsIgnoreCase("for")){
                str2 = "4";
            }
            if (str2.length() > 1){
                String str3 = "";
                for (int j = 0; j < str2.length(); j++){
                    if (str2.charAt(j) != 'a' && str2.charAt(j) != 'A' && str2.charAt(j) != 'e' && 
                    str2.charAt(j) != 'E' && str2.charAt(j) != 'i' && str2.charAt(j) != 'I' &&
                    str2.charAt(j) != 'o' && str2.charAt(j) != 'O' && str2.charAt(j) != 'u' && 
                    str2.charAt(j) != 'U'){
                        str3 = str3 + str2.charAt(j);
                    }
                }
                str2 = str3;
            }
            finalstring = finalstring + str2;
            int x = i;
            if (Character.isLetter(str.charAt(i))){
                while ( x < str.length() && Character.isLetter(str.charAt(x))){
                    x++;
                }
            }
            else if (!Character.isLetter(str.charAt(i))){
                while (x < str.length() && !Character.isLetter(str.charAt(x))){
                    x++;
                }
            }
            i = x;
        }
        
        return finalstring;
        
    }
    
    String getWord(String str, int startIndex) {
        String str1 = "" ;
        int searching = startIndex;
        if (Character.isLetter(str.charAt(startIndex))){
            while (searching < str.length() && Character.isLetter(str.charAt(searching))){
                str1 = str1 + str.charAt(searching) ;
                searching += 1;
            }
        }
        else{
            while (searching < str.length() && !Character.isLetter(str.charAt(searching))){
                str1 = str1 + str.charAt(searching);
                searching +=1;
            }
        } 
        return str1;
    }
    public static void main(String[] args){
        P2_Zhu_Anthony_Shorthand run = new P2_Zhu_Anthony_Shorthand();
        String finalstring = run.translatesToShorthand("And...nOW back $!to** you-->Andy.I.--aNd--Sandy.A. FoR tHe WEaTHer...fORtune...a ");
        System.out.println(finalstring);
    }
    
}