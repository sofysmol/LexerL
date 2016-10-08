package sofysmo.lexerl.tokens;

/**
 * Created by sofysmo on 03.10.16.
 */
public class VarToken implements Yytoken {
    private String x;
    private int line;
    private int charBegin;
    private int charEnd;
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

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getCharBegin() {
        return charBegin;
    }

    public void setCharBegin(int charBegin) {
        this.charBegin = charBegin;
    }

    public int getCharEnd() {
        return charEnd;
    }

    public void setCharEnd(int charEnd) {
        this.charEnd = charEnd;
    }
}
