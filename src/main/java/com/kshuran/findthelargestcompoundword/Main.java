package com.kshuran.findthelargestcompoundword;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Кулацкий
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        List<String> list = new ArrayList<>();
        list.add("five");
        list.add("fivetwo");
        list.add("fourfive");
        list.add("fourfivetwo");
        list.add("one");        
        list.add("onefive");
        list.add("onefivefourtwo");
        list.add("onefiveone");       
        list.add("two");
        list.add("twofivefourone");
        //list.add("fivetwotwofourfive");

        
        FindTheLargestCompoundWord f = new FindTheLargestCompoundWord(list);
        String str = f.findCompoundWord();
        System.out.println(str + " is the largest compound word in list" + 
                " and contain " + str.length() + " letters.");

    }
    
}
