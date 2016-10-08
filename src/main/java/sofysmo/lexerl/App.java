package sofysmo.lexerl;

import sofysmo.lexerl.tokens.Yytoken;
import java.io.*;

/**
 * Created by sofysmo on 03.10.16.
 */
//ONELINE_COMMENT_TEXT=([^/\n]|[^/\n]"/"[^/\n])+
//MULTILINE_COMMENT_TEXT=([^*/\n]|[^*\n]"/"[^*\n]|[^/\n]"*"[^/\n]|"*"[^/\n]|"/"[^*\n])+
public class App {
    public static void main(String[] argv){
        try {
            Yylex lex = new Yylex(new FileReader(argv[0]));
            Yytoken token;
            do {
                token = lex.yylex();
                if(token != null)
                    System.out.print(token);
                else break;
            } while(true);
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
