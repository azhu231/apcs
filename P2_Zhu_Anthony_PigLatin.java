/* Anthony Zhu
 * November 7th 2018
 * Period 2 Ferrante
 * Time: 60 minutes 
 *This lab was generally easy to complete as it was similar to other labs such as big problem and shorthand
 *where we had to isolate words and alter them. I used to a lot of helper methods in my translate method in addition
 *to helper methods that helped my helper methods. By doing this, my work was much easier as I could organize 
 *the code and my thinking in a efficient/easy to understand way.
 */

public class P2_Zhu_Anthony_PigLatin{
    public String translateToPigLatin(String str){
        String finalstring = "";
        int i = 0;
        while (i < str.length()){
            String word = getWord(str, i);
            if (Character.isLetter(str.charAt(i))){
                finalstring = finalstring + wordPigLatin(word);
            }
            else{
                finalstring = finalstring + word;
            }
            i = i+word.length();
        }
        return finalstring;
    }
    
    String wordPigLatin(String str){
        if (indexFirstVowel(str) == -1){
            return str + "ay";
        }
        else if (indexFirstVowel(str) == 0){
            return str + "yay";
        }
        else{
            if ( str.charAt(0) <= 90 && str.charAt(0) >= 65){
                String start = str.substring(0, indexFirstVowel(str));
                return (char)(str.charAt(indexFirstVowel(str))-32) + str.substring(indexFirstVowel(str)
                + 1, str.length()) + start.toLowerCase() + "ay";
            }
            else{
                return "" + str.substring(indexFirstVowel(str), str.length()) + str.substring(0,
                indexFirstVowel(str)) + "ay";
            }
        }
    }
    
    public int indexFirstVowel(String str){
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i)
                == 'o' || str.charAt(i) == 'u' || str.charAt(i) == 'A' || str.charAt(i) == 'E' ||
                str.charAt(i) == 'I' || str.charAt(i) == 'O' || str.charAt(i) == 'U'){
                return i;
                }
        }
        return -1;
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
        P2_Zhu_Anthony_PigLatin fun = new P2_Zhu_Anthony_PigLatin();
        System.out.println(fun.translateToPigLatin("Wow! I am a master at Pig Latin teehee"));
    }
}