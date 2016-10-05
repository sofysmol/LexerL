package sofysmo.lexerl.tokens;

/**
 * Created by sofysmo on 03.10.16.
 */
public class NumToken implements Yytoken {
    public String num;
    public int line;
    public int charBegin;
    public int charEnd;
    public NumToken(String num, int line, int charBegin, int charEnd)
    {
        this.num = num;
        this.line = line;
        this.charBegin = charBegin;
        this.charEnd = charEnd;
    }
    @Override
    public String toString()
    {
        return "Num(" + num + ";" + line + ";"+charBegin + ";" + charEnd+");";
    }
}
