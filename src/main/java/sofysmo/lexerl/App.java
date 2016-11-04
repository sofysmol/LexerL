package sofysmo.lexerl;

import sofysmo.lexerl.exceptions.TokenException;
import sofysmo.lexerl.tokens.CommentToken;
import sofysmo.lexerl.tokens.Yytoken;
import java.io.*;

/**
 * Created by sofysmo on 03.10.16.
 */
public class App {
    public static void main(String[] argv){
        try {
            boolean filter = false;
            String filename = argv[0];
            if(argv[0].equals("-filter")) {
                filter = true;
                filename = argv[1];
            }
            Yylex lex = new Yylex(new FileReader(filename));
            Yytoken token;
            do {
                token = lex.yylex();
                if(token != null) {
                    if (filter) {
                        if (!(token instanceof CommentToken))
                            System.out.print(token);
                    }else System.out.print(token);
                }
                else break;
            } while(true);
        }catch (IOException e) {
            System.out.println("Ошибка: Файл "+argv[0]+" не найден");
        }
        catch (TokenException e) {
            System.out.println("Ошибка: "+e.getMessage());
        }
        catch (ArrayIndexOutOfBoundsException e){
            if(argv.length == 0)
                System.out.println("Ошибка: отсутсвует параметр входной файл");
            else System.out.println("Ошибка");
        }
        catch (Exception e){
            System.out.println("Ошибка");
        }
    }
}
