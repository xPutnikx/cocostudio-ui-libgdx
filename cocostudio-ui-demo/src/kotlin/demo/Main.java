package kotlin.demo;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

/**
 * Created by vladimirhudnitsky on 12/11/14.
 */
public class Main {
    public static void main(String[] args) {
        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
        cfg.title = "UI_COCOS_DEMO2";
        cfg.useGL20 = true;
        cfg.width = 614;
        cfg.height = 1024;

        cfg.resizable = true;
        new LwjglApplication(new MyGame(), cfg);
    }
}
