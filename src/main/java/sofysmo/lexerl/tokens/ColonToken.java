package sofysmo.lexerl.tokens;

/**
 * Created by sofysmo on 03.10.16.
 */
public class ColonToken implements Yytoken {
    public int line;
    public int charBegin;
    public int charEnd;
    public ColonToken(int line, int charBegin, int charEnd)
    {
        this.line = line;
        this.charBegin = charBegin;
        this.charEnd = charEnd;
    }

    @Override
    public String toString()
    {
        return "Colon(" + line + ";"+charBegin + ";" + charEnd+");";
    }
}
