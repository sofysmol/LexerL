package sofysmo.lexerl.tokens;

/**
 * Created by sofysmo on 08.10.16.
 */
public class CommentToken implements Yytoken {
    private String text;
    private int lineBegin;
    private int lineEnd;
    private int charBegin;
    private int charEnd;
    public CommentToken(String text, int lineBegin, int charBegin, int lineEnd, int charEnd)
    {
        this.text = text;
        this.lineBegin = lineBegin;
        this.charBegin = charBegin;
        this.charEnd = charEnd;
        this.lineEnd = lineEnd;
    }
    @Override
    public String toString()
    {
        return "Comment(\"" + text + "\";"+ lineBegin + ";"+charBegin + ";" + lineEnd +";"+ charEnd+");";
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getLineBegin() {
        return lineBegin;
    }

    public void setLineBegin(int lineBegin) {
        this.lineBegin = lineBegin;
    }

    public int getLineEnd() {
        return lineEnd;
    }

    public void setLineEnd(int lineEnd) {
        this.lineEnd = lineEnd;
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
