import java.util.Hashtable;
public class Solution {
    Hashtable<Character, ArrayList<Character>> table;
    public Solution(){
        table = new Hashtable<Character, ArrayList<Character>>();
        ArrayList<Character> l = new ArrayList<Character>();
        l.add('a');
        l.add('b');
        l.add('c');
        table.put('2', l);
        l = new ArrayList<Character>();
        l.add('d');
        l.add('e');
        l.add('f');
        table.put('3', l);
        l = new ArrayList<Character>();
        l.add('g');
        l.add('h');
        l.add('i');
        table.put('4', l);
        l = new ArrayList<Character>();
        l.add('j');
        l.add('k');
        l.add('l');
        table.put('5', l);
        l = new ArrayList<Character>();
        l.add('m');
        l.add('n');
        l.add('o');
        table.put('6', l);
        l = new ArrayList<Character>();
        l.add('p');
        l.add('q');
        l.add('r');
        l.add('s');
        table.put('7', l);
        l = new ArrayList<Character>();
        l.add('t');
        l.add('u');
        l.add('v');
        table.put('8', l);
        l = new ArrayList<Character>();
        l.add('w');
        l.add('x');
        l.add('y');
        l.add('z');
        table.put('9', l);
    }
    
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> results = new ArrayList<String>();
        if(digits.length()==0||!table.containsKey(digits.charAt(0))){
            results.add("");
            return results;
        }
        ArrayList<String> recurr_results = letterCombinations(digits.substring(1));
        ArrayList<Character> letters = table.get(digits.charAt(0));
        for(int i=0;i<letters.size();i++){
            for(int j=0;j<recurr_results.size();j++){
                StringBuilder buffer = new StringBuilder();
                buffer.append(letters.get(i));
                buffer.append(recurr_results.get(j));
                results.add(buffer.toString());
            }
        }
        return results;
    }
}
