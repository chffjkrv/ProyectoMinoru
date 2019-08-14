package utilidades;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Searcher {



   
    public String[] search(String regex, String onText)
    {
        Pattern regPatt = Pattern.compile(regex);
        Matcher regMatch = regPatt.matcher(onText);
        ArrayList<String> matches = new ArrayList<>();
        String[] matchesArray;

        while(regMatch.find())
        {
            String match = regMatch.group();
            matches.add(match);
        }
       
        matchesArray = new String[matches.size()];
        matches.toArray(matchesArray);
        return matchesArray;
    }
   
    public void printMatches(String[] matches)
    {
        int matchesCount = matches.length;
       
        for(int i = 0; i < matchesCount; i++)
        {
            System.out.println(matches[i]);
        }
    }
   
}
