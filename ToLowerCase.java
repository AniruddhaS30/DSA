/*
Example 1:
Input: s = "Hello"
Output: "hello"
Example 2:
Input: s = "here"
Output: "here"
Example 3:
Input: s = "LOVELY"
Output: "lovely" */
public class ToLowerCase{
    public static String LowerCase(String s){
        StringBuilder result = new StringBuilder();//StringBuilder: strings can't be changed in place, so we collect characters here
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isUpperCase(ch)){
                result.append(Character.toLowerCase(ch));
            }
            else{
                result.append(ch);
            }
        }
         String finalString = result.toString();// Convert the StringBuilder back into a String, since the method must return a String
            return finalString;
    }
    public static void main(String[] args){
        String s = "ImMoRtAlS";
        System.out.println(LowerCase(s));
    }
}
