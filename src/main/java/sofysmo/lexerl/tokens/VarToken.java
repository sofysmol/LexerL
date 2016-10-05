package sofysmo.lexerl.tokens;

/**
 * Created by sofysmo on 03.10.16.
 */
public class VarToken implements Yytoken {
    public String x;
    public int line;
    public int charBegin;
    public int charEnd;
    public VarToken(String x, int line, int charBegin, int charEnd)
    {
        this.x = x;
        this.line = line;
        this.charBegin = charBegin;
        this.charEnd = charEnd;
    }
    @Override
    public String toString()
    {
        return "Var(\"" + x + "\";" + line + ";"+charBegin + ";" + charEnd+");";
    }
}
