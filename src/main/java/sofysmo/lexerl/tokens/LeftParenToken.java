package sofysmo.lexerl.tokens;

/**
 * Created by sofysmo on 03.10.16.
 */
public class LeftParenToken implements Yytoken {
    public int line;
    public int charBegin;
    public int charEnd;
    public LeftParenToken(int line, int charBegin, int charEnd)
    {
        this.line = line;
        this.charBegin = charBegin;
        this.charEnd = charEnd;
    }
    @Override
    public String toString()
    {
        return "LeftParen(" + line + ";"+charBegin + ";" + charEnd;
    }
}
