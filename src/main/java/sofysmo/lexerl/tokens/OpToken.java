package sofysmo.lexerl.tokens;

/**
 * Created by sofysmo on 03.10.16.
 */
public class OpToken implements Yytoken {
    public String op;
    public int line;
    public int charBegin;
    public int charEnd;
    public OpToken(String op, int line, int charBegin, int charEnd)
    {
        this.op = op;
        this.line = line;
        this.charBegin = charBegin;
        this.charEnd = charEnd;
    }
    @Override
    public String toString()
    {
        return "Op"+"(" +op+";"+ line + ";"+charBegin + ";" + charEnd+");";
    }
}
