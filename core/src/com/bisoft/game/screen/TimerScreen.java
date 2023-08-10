package com.bisoft.game.screen;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class TimerScreen {
    static int interval;
    static Timer timer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input seconds => : ");
        String secs = sc.nextLine();
        int delay = 1000;
        int period = 1000;
        timer = new Timer();
        interval = Integer.parseInt(secs);
        System.out.println(secs);
        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                System.out.println(setInterval());

            }
        }, delay, period);
    }

    private static final int setInterval() {
        if (interval == 1)
            timer.cancel();
        return --interval;
    }
}























//package com.bisoft.game.screen;
//
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Screen;
//import com.badlogic.gdx.graphics.g2d.BitmapFont;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.bisoft.game.elements.Text;
//import com.bisoft.game.utils.Render;
//import com.bisoft.game.utils.Resources;
//
//import java.util.Timer;
//
//public class TimerScreen implements Screen{
//
//    private int delay;
//    private int elapsed;
//    private boolean running;
//
//    public TimerScreen(int delay, boolean running) {
//
//        this.delay = delay;
//        this.running = running;
//    }
//
//    public boolean tick(float delta) {
//
//        if(running) {
//            elapsed += delta * 1000;
//            if(elapsed > delay) {
//                elapsed = elapsed - delay;
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public void start() {
//
//        this.running = true;
//    }
//
//    public void stop() {
//
//        this.running = false;
//    }
//
//    public void reset() {
//
//        this.elapsed = 0;
//    }
//
//    public int getElapsed() {
//
//        return this.elapsed;
//    }
//
//    public void setElapsed(int elapsed) {
//
//        this.elapsed = elapsed;
//    }
//
//    public int getDelay() {
//
//        return delay;
//    }
//
//    public void setDelay(int delay) {
//
//        this.delay = delay;
//    }
//
//    public boolean isRunning() {
//
//        return running;
//    }
//
//    public float percent() {
//
//        return elapsed / (float) delay;
//    }
//
//
//    SpriteBatch batch;
//    private BitmapFont font;
//    private float deltaTime = 0;
//    CharSequence str;
//
//    public TimerScreen() {
//        font = new BitmapFont();
//        batch = new SpriteBatch();
//    }
//    public void drawTime() {
//        deltaTime += Gdx.graphics.getDeltaTime();
//        str = Float.toString(deltaTime);
//        font.draw(batch, str, 0, 0);
//    }
//
//    @Override
//    public void show() {
//
//    }
//
//    @Override
//    public void render(float delta) {
//
//        Render.Batch.begin();
//        Resources.MAIN.setScreen(new TimerScreen());
//        Render.Batch.end();
//    }
//
//    @Override
//    public void resize(int width, int height) {
//
//    }
//
//    @Override
//    public void pause() {
//
//    }
//
//    @Override
//    public void resume() {
//
//    }
//
//    @Override
//    public void hide() {
//
//    }
//
//    @Override
//    public void dispose() {
//
//    }
//}
