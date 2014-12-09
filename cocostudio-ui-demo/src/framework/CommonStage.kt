package framework

import demo.MyGame

/** 游戏场景,封装一些公共组件 */
abstract class CommonStage(width: Float, height: Float, keepAspectRatio: Boolean) : MyStage(width, height, keepAspectRatio) {

    fun getGame(): MyGame {
        return super.game as MyGame
    }

    public abstract fun init()

}
