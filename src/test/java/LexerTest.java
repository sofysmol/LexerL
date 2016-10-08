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
    public void testOneline() throws IOException, TokenException {
        test("src/test/resources/tests/test_oneline.txt",
                "src/test/resources/results/res_oneline.txt");
    }

    @Test
    public void testMultiline() throws IOException, TokenException {
        test("src/test/resources/tests/test_multiline.txt",
                "src/test/resources/results/res_multiline.txt");
    }

    @Test
    public void testMultilineComment() throws IOException, TokenException {
        test("src/test/resources/tests/test_multiline_comment.txt",
                "src/test/resources/results/res_multiline_comment.txt");
    }

    @Test
    public void testOnelineComment() throws IOException, TokenException {
        test("src/test/resources/tests/test_oneline_comment.txt",
                "src/test/resources/results/res_oneline_comment.txt");
    }

    @Test(expected = TokenException.class)
    public void testBadSymbol() throws IOException, TokenException {
        test("src/test/resources/tests/test_bad_symbol.txt",
                "src/test/resources/results/res_bad_symbol.txt");
    }

    @Test(expected = TokenException.class)
    public void testBadComment() throws IOException, TokenException {
        test("src/test/resources/tests/test_bad_comment.txt",
                "src/test/resources/results/res_bad_comment.txt");
    }

    @Test
    public void testPower() throws IOException, TokenException {
        test("src/test/resources/tests/test_power.txt",
                "src/test/resources/results/res_power.txt");
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
        String res = Files.lines(path).collect(Collectors.joining("\n"));
        assertEquals(tokens, res);
    }
}
