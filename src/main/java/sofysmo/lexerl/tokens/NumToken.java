package sofysmo.lexerl.tokens;

/**
 * Created by sofysmo on 03.10.16.
 */
public class NumToken implements Yytoken {
    private String num;
    private int line;
    private int charBegin;
    private int charEnd;
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

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
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
