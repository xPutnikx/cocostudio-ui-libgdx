package framework


import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL10
import com.badlogic.gdx.scenes.scene2d.Stage

public open class MyScreen : Screen {

    public var game: Game
    public var stage: Stage? = null

    {
        this.game = Gdx.app.getApplicationListener() as Game
    }

    override fun render(delta: Float) {

        Gdx.gl.glClearColor(0.0F, 0.0F, 0.0F, 1.0F)
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT)

        stage!!.act()
        stage!!.draw()
    }

    override fun resize(width: Int, height: Int) {
    }

    override fun show() {
    }

    override fun hide() {
    }

    override fun pause() {
    }

    override fun resume() {
    }

    override fun dispose() {
        if (stage == null) {
            return
        }
        stage!!.dispose()
    }

}
