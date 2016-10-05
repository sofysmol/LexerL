package sofysmo.lexerl.tokens;

/**
 * Created by sofysmo on 03.10.16.
 */
public class RightParenToken {
    public int line;
    public int charBegin;
    public int charEnd;
    public RightParenToken(int line, int charBegin, int charEnd)
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
