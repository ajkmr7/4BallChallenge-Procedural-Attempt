import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

public class TryProcessing extends PApplet {

    public static final int WIDTH = 640;
    public static final int HEIGHT = 480;
    public static final int DIAMETER = 15;

    List<Integer> balls = new ArrayList<>();
    int ballCount = 4;

    int frameRate=0;
    float posX;

    @Override
    public void settings() {
        super.settings();
        size(WIDTH, HEIGHT);
    }

    @Override
    public void setup() {
        for(int ballId = 1; ballId <= ballCount ; ballId++){
            balls.add(ballId);
        }

        for(Integer ballId:balls){
            ellipse(0, getBallYCoords(ballId), DIAMETER, DIAMETER);
        }
    }

    @Override
    public void draw() {
        for(Integer ballId:balls){
            ellipse(getBallXCoords(frameRate, ballId), getBallYCoords(ballId), DIAMETER, DIAMETER);
            frameRate++;
        }
    }

    private float getBallXCoords(int currentPos, Integer ballId) {
        posX = (float) currentPos / (ballCount+1- ballId);
        return posX;
    }

    private int getBallYCoords(Integer ballId) {
        return ballId * HEIGHT / 5;
    }

    public static void main(String[] args) {
        PApplet.main("TryProcessing", args);
    }

}
