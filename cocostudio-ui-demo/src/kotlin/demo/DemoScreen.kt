package kotlin.demo

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.InputMultiplexer

/**
 *
 * @author i see
 *
 */
public class DemoScreen : MyScreen() {

    override fun show() {

        stage = DemoStage.create()

        val inputMultiplexer = InputMultiplexer()
        inputMultiplexer.addProcessor(stage)
        Gdx.input.setInputProcessor(inputMultiplexer)
    }

}
