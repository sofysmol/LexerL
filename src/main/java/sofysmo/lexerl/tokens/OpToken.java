package sofysmo.lexerl.tokens;

/**
 * Created by sofysmo on 03.10.16.
 */
public class OpToken implements Yytoken {
    private String op;
    private int line;
    private int charBegin;
    private int charEnd;
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

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
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
