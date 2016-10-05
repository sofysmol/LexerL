/**
 * Created by sofysmo on 04.10.16.
 */
import org.junit.Test;
import sofysmo.lexerl.Yylex;
import sofysmo.lexerl.exceptions.TokenException;
import sofysmo.lexerl.tokens.Yytoken;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class LexerTest{

    @Test
    public void happyTest1() throws IOException, TokenException {
        test("src/test/resources/tests/test1.txt",
                "src/test/resources/results/res1.txt");
    }
    @Test
    public void happyTest2() throws IOException, TokenException {
        test("src/test/resources/tests/test2.txt",
                "src/test/resources/results/res2.txt");
    }

    @Test(expected = TokenException.class)
    public void badTest3() throws IOException, TokenException {
        test("src/test/resources/tests/test3.txt",
                "src/test/resources/results/res3.txt");
    }

    public void test(String testFilename, String resFilename) throws IOException, TokenException {
        Yylex lex = new Yylex(new FileReader(testFilename));
        Yytoken token;
        String tokens = "";
        do {
            token = lex.yylex();
            if(token != null)
                tokens += token;
        } while(token != null);
        Path path = Paths.get(resFilename);
        String res = Files.lines(path).collect(Collectors.toList()).get(0);
        assertEquals(tokens, res);
    }
}
