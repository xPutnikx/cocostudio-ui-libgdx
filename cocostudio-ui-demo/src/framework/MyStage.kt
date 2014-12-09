package framework


import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.Stage



open class MyStage(width: Float, height: Float, keepAspectRatio: Boolean) : Stage(width, height, keepAspectRatio) {

    public var game: Game

    {
        game = Gdx.app.getApplicationListener() as Game
    }

    /** 居中对齐 */
    public fun layerCenter(actor: Actor) {
        actor.setPosition((getWidth() - actor.getWidth()) / 2, (getHeight() - actor.getHeight()) / 2)
    }

    /** X轴中间对齐 */
    public fun layerXCenter(actor: Actor) {
        actor.setX((getWidth() - actor.getWidth()) / 2)
    }

    /** X轴中间对齐 */
    public fun layerYCenter(actor: Actor) {
        actor.setY((getHeight() - actor.getHeight()) / 2)
    }

    /** 右顶端对齐 */
    public fun layerTopRight(actor: Actor) {
        actor.setPosition((getWidth() - actor.getWidth()), (getHeight() - actor.getHeight()))
    }

    public fun getScreen(): Screen {
        return game.getScreen()
    }

}
