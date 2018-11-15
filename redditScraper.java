import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class redditScraper {


    public static void main(String[]args){
        String url = "http://api.pushshift.io/reddit/comment/search/?subreddit=health&after=1483228800&before=1514764800&limit=1000";
        final String regex = "(\"body\": \"(.+)\")";
        Pattern pattern = Pattern.compile(regex);
        TreeSet<String> links = new TreeSet<String>();
        LinkedList<String> linked = new LinkedList<>();

        try{
            URL site = new URL (url);
            BufferedReader bf = new BufferedReader(new InputStreamReader(site.openStream(), Charset.forName("UTF-8")));
            int ch;
            StringBuilder sb = new StringBuilder();
            while((ch = bf.read()) != -1){
                sb.append((char)ch);
            }
            bf.close();
            //System.out.println(sb.toString());
            Matcher match = pattern.matcher(sb.toString());
            while(match.find()){
                String w = match.group();
                //links.add(w);
                linked.add(w);
            }
            for(String str: linked){
                System.out.println(str);
            }
        }catch (Exception e){
            e.printStackTrace();
        }



    }

}
