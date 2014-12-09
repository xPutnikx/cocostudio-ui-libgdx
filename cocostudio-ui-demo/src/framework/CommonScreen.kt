package framework

import demo.MyGame


/**
 * 加载战斗界面
 *
 * @author i see
 *
 */
public open class CommonScreen : MyScreen() {

    fun getGame(): MyGame {
        return super.game as MyGame
    }
}
