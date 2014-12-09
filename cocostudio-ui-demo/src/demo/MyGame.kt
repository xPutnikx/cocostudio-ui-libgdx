package demo

import com.badlogic.gdx.Application
import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.assets.AssetManager

public class MyGame : Game() {

    override fun create() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG)

        this.setScreen(DemoScreen())
    }

}
