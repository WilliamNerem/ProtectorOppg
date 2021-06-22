import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    static boolean checkIfAnagram(String str1, String str2){
        if (str1.length() != str2.length()){
            return false;
        }
        char[] tempArr1 = str1.toCharArray();
        char[] tempArr2 = str2.toCharArray();
        Arrays.sort(tempArr1);
        Arrays.sort(tempArr2);

        for (int i = 0; i < tempArr1.length; i++){
            if (tempArr1[i] != tempArr2[i]){
                return false;
            }
        }
        return true;
    }

    static void readFile() throws FileNotFoundException {
        Scanner s = new Scanner(new File("ordbok-utf8[1347].txt"));
        ArrayList<String> list = new ArrayList<String>();
        while (s.hasNextLine()){
            String word = s.nextLine();
            if (word.length() == 0){
                continue;
            }
            list.add(word);
        }
        s.close();

        printAnagrams(list);
    }

    static void printAnagrams(ArrayList<String> list){
        for (int i = 0; i < list.size(); i++){
            StringBuilder out = new StringBuilder();
            for (int j = 0; j < list.size(); j++){
                if ((checkIfAnagram(list.get(i), list.get(j))) && (i != j)){
                    out.append(" ").append(list.get(j));
                }
            }
            if (out.length() != 0){
                System.out.print(list.get(i));
                System.out.println(out);
            }
        }
    }

    public static void main(String[]args) throws FileNotFoundException {
        readFile();
    }
}
