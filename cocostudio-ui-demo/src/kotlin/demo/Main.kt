package kotlin.demo

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration

public class Main {
    class object {
        public fun main(args: Array<String>) {
            val cfg = LwjglApplicationConfiguration()
            cfg.title = "UI_COCOS_DEMO2"
            cfg.useGL20 = true
            //		cfg.width = 480;
            //		cfg.height = 320;

            cfg.width = 614
            cfg.height = 1024

            cfg.resizable = true
            LwjglApplication(MyGame(), cfg)
        }
    }
}

fun main(args: Array<String>) = Main.main(args)
