import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        System.out.println( "\n" + "************************** containsDuplicate Question ************************** ");
        int [] array  = {1,2,3,1};
        boolean  hasDuplicate  =  containsDuplicate(array);
        System.out.println(hasDuplicate + "\n");
        System.out.println("<><><><><><><>>><><><><><><>><><><><><><><><><><><><><><><><><><><><><><><><><><><>/\n\n");


        System.out.println("************************** isAnagram Question ************************** ");
        String   s = "anagram", t = "nagaram";
        boolean isAnagram = isAnagram(s,t);
        System.out.println(isAnagram + "\n");
        System.out.println("<><><><><><><>>><><><><><><>><><><><><><><><><><><><><><><><><><><><><><><><><><><>\n\n");


        System.out.println("************************** isValid Question ************************** ");
        String parentheses = "()[]{}" ;
        boolean isValid =  isValid(parentheses);
        System.out.println(isValid + "\n");
        System.out.println("<><><><><><><>>><><><><><><>><><><><><><><><><><><><><><><><><><><><><><><><><><><>\n\n");



        System.out.println("************************** findClosestNumber Question ************************** ");
        int [] nums = {-4,-2,1,1,4,8};
        int closet =   findClosestNumber(nums);
        System.out.println(closet + "\n");
        System.out.println("<><><><><><><>>><><><><><><>><><><><><><><><><><><><><><><><><><><><><><><><><><><>\n\n");




        System.out.println("************************** numJewelsInStones Question ************************** ");
        String jewels = "aAc", stones = "aAAbbbbc" ;
       int   numJewels = numJewelsInStones(jewels,stones);
       System.out.println(numJewels + "\n");
        System.out.println("<><><><><><><>>><><><><><><>><><><><><><><><><><><><><><><><><><><><><><><><><><><>\n\n");












    }


    public static boolean containsDuplicate(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {

            if (!(set.contains(num))) {
                set.add(num);
            } else {
                return true;
            }
        }
        return false  ;
    }


    public  static boolean isAnagram(String s, String t) {

        int [] array = new int[26];


        if(s.length() != t.length()){
            return false ;
        }

        for(int i= 0; i<s.length() ; i++){

            array[s.charAt(i) - 'a']++ ;
            array[t.charAt(i) - 'a']-- ;

        }


        for (int j : array) {
            if (j != 0) {
                return false;
            }
        }

        return true ;



    }



    public static boolean isValid(String s) {


        Stack<Character> stack = new Stack<>();



        for(int i = 0 ; i < s.length()  ;i++){



            char x = s.charAt(i);

            if(stack.isEmpty() &&  (  x == ')' || x == ']' | x == '}' )){
                return false ;
            }


            if(x == '('  || x == '{' || x == '['){
                stack.add(x);
            }

            if(x == ')' &&    stack.pop() != '(' ){
                return false ;
            }
            if(x == '}' &&    stack.pop() != '{' ){
                return false ;
            }
            if(x == ']' &&    stack.pop() != '[' ){
                return false ;
            }



        }
        return stack.isEmpty() ;

    }


    public static int findClosestNumber(int[] nums) {

        int cloestNumber =  Integer.MAX_VALUE - Math.abs(nums[0]) ;

        for (int num : nums) {

            int value = cloestNumber + num;


            if (value <= 0) {
                cloestNumber = Math.max(cloestNumber, num);
            }

            if (value > 0) {
                cloestNumber = Math.min(cloestNumber, num);

            }


        }


        return cloestNumber ;




    }

    public  static  int numJewelsInStones(String jewels, String stones) {

        int numberOfJewles=0;

        for(char c : stones.toCharArray()){
            if(jewels.indexOf(c)>-1) numberOfJewles +=1 ;
        }
        return numberOfJewles;
    }






}