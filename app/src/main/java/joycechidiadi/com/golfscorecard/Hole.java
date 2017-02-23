package joycechidiadi.com.golfscorecard;

public class Hole {
    private String Label;
    private int StrokeCount;

    public Hole (String label, int strokeCount) {
        Label = label;
        StrokeCount = strokeCount;
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String label) {
        Label = label;
    }

    public int getStrokeCount() {
        return StrokeCount;
    }

    public void setStrokeCount(int strokeCount) {
        StrokeCount = strokeCount;
    }
}
