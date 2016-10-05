package sofysmo.lexerl.tokens;

/**
 * Created by sofysmo on 03.10.16.
 */
public class SemicolonToken implements Yytoken {
    public int line;
    public int charBegin;
    public int charEnd;
    public SemicolonToken(int line, int charBegin, int charEnd)
    {
        this.line = line;
        this.charBegin = charBegin;
        this.charEnd = charEnd;
    }
    @Override
    public String toString()
    {
        return "Semicolon(" + line + ";"+charBegin + ";" + charEnd+");";
    }
}
