package kotlin.demo

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.scenes.scene2d.*
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.badlogic.gdx.utils.Array
import org.freyja.libgdx.cocostudio.ui.CocoStudioUIEditor

import java.util.ArrayList
import kotlin.framework.MyStage

/**
 * @author i see
 */
class DemoStage(width: Float, height: Float, keepAspectRatio: Boolean) : MyStage(width, height, keepAspectRatio) {

    {
        init()
    }

    class object {
        fun create() = DemoStage(Gdx.graphics.getWidth().toFloat(), Gdx.graphics.getHeight().toFloat(), true)
    }


    var listener = false

    public var i : Int = 11

    override fun init() {
        i = 11;
        when (i) {
            1 -> initHead()
            2 -> initShop()
            3 -> initUI()
            4 -> initDemo()
            5 -> initUI2()
            6 -> initLogin()
            7 -> initMap()
            8 -> initSampleChangeEquip()
            9 -> SampleUIAnimation()
            10 -> initTow()
            11 -> initTest()
            else -> {
                i = 1
                init()
            }
        }

        if (listener) {
            return
        }
        listener = addListener(object : ClickListener() {
            override fun keyDown(event: InputEvent?, keycode: Int): Boolean {
                getActors().clear()
                i++
                init()
                return super.keyDown(event, keycode)
            }
        })

    }

    private fun initTest() {

        val gui0 = TextureAtlas(Gdx.files.internal("tow/pack"))
        val list = ArrayList<TextureAtlas>()
        list.add(gui0)

        val editor = CocoStudioUIEditor(Gdx.files.internal("tow/mainScreen.ExportJson"), list)
        val group = editor.createGroup()
        addActor(group)

        val shopBtn = group.findActor("shop_btn")
        shopBtn.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent?, x: Float, y: Float) {
                super.clicked(event, x, y)
            }
        })
    }

    private fun initTow() {
        val editor = CocoStudioUIEditor(Gdx.files.internal("tow/mainScreen.json"), null)
        val group = editor.createGroup()
        addActor(group)
    }

    /**
     * 移植的简单动作编辑器功能
     */
    private fun SampleUIAnimation() {

        val editor = CocoStudioUIEditor(Gdx.files.internal("SampleUIAnimation/SampleUIAnimation.json"), null, null, null, null)
        val group = editor.createGroup()
        addActor(group)
        // 查找动画
        val actions = editor.getAction("Animation1")
        // 查找演员
        val actor = editor.findActor("ImageView")
        // 查找动作
        val action = actions.get(actor)

        val textButton = editor.findActor("TextButton")

        textButton.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent?, x: Float, y: Float) {

                // 点击的时候把动作添加到演员上去,然后play!!!
                actor.addAction(action)

                super.clicked(event, x, y)
            }
        })
    }

    /**
     * 头像Demo,使用小图片方式
     */
    private fun initHead() {

        val editor = CocoStudioUIEditor(Gdx.files.internal("head/DemoHead_UI.json"), null, null, null, null)
        val group = editor.createGroup()

        addActor(group)

        val head = editor.findActor("ImageView")

        val panel = editor.findActor("Panel")

        // head.setVisible(true);
        // head.setPosition(0, 0);
        // addActor(head);
        // System.out.println();
    }

    /**
     * 商店Demo,使用小图片方式
     */
    private fun initShop() {

        val list: Array<TextureAtlas>? = null
        val editor = CocoStudioUIEditor(Gdx.files.internal("shop/DemoShop1.json"), null)
        val group = editor.createGroup()
        addActor(group)
        val buy_panel = editor.findActor("buy_Panel")
        val close_button = editor.findActor("close_Button")

        close_button.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent?, x: Float, y: Float) {
                buy_panel.setVisible(false)
                super.clicked(event, x, y)
            }
        })

        val buy_buttons = editor.findActors("buy_Button")

        for (buy_button in buy_buttons) {
            buy_button.addListener(object : ClickListener() {

                override fun clicked(event: InputEvent?, x: Float, y: Float) {
                    buy_panel.setVisible(true)

                    super.clicked(event, x, y)
                }
            })

        }

        val back_Label = editor.findActor("back_LabelBMFont")

        back_Label.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent?, x: Float, y: Float) {

                System.out.println("点击2")
                super.clicked(event, x, y)
            }
        })
        val back_Button = editor.findActor("back_Button")

        back_Button.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent?, x: Float, y: Float) {

                System.out.println("点击")
                super.clicked(event, x, y)
            }
        })
    }

    /**
     * ui例子,使用小图片方式
     */
    fun initUI() {
        val editor = CocoStudioUIEditor(Gdx.files.internal("ui/ui.json"), null, null, null, null)
        val group = editor.createGroup()
        addActor(group)

    }

    /**
     * ui例子2,使用TextureAtlas方式
     */
    fun initUI2() {

        val gui = TextureAtlas(Gdx.files.internal("ui/gui.txt"))

        val list = ArrayList<TextureAtlas>()
        list.add(gui)

        val editor = CocoStudioUIEditor(Gdx.files.internal("ui/ui.ExportJson"), list)
        val group = editor.createGroup()
        addActor(group)
    }

    fun initDemo() {

        val gui = TextureAtlas(Gdx.files.internal("demo/gui.txt"))
        val list = ArrayList<TextureAtlas>()
        list.add(gui)
        val editor = CocoStudioUIEditor(Gdx.files.internal("demo/login.ExportJson"), list)
        val group = editor.createGroup()
        addActor(group)

    }

    fun initLogin() {

        val editor = CocoStudioUIEditor(Gdx.files.internal("DemoLogin/DemoLogin.json"), null, null, null, null)
        val group = editor.createGroup()
        addActor(group)

    }

    fun initMap() {

        val editor = CocoStudioUIEditor(Gdx.files.internal("DemoMap/DemoMap.json"), null, null, null, null)
        val group = editor.createGroup()
        addActor(group)

        val dragPanel = editor.findActor("DragPanel")

        // dragPanel.addListener(new ClickListener() {
        // @Override
        // public void clicked(InputEvent event, float x, float y) {
        //
        // System.out.println("click");
        //
        // super.clicked(event, x, y);
        // }
        // });

        val boxPanel = editor.findActor("box_Panel")

        // boxPanel.addListener(new ClickListener() {
        //
        // @Override
        // public boolean touchDown(InputEvent event, float x, float y,
        // int pointer, int button) {
        //
        // return super.touchDown(event, x, y, pointer, button);
        // }
        //
        // @Override
        // public void clicked(InputEvent event, float x, float y) {
        //
        // System.out.println("click2");
        //
        // super.clicked(event, x, y);
        // }
        // });

    }

    fun initSampleChangeEquip() {
        val editor = CocoStudioUIEditor(Gdx.files.internal("SampleChangeEquip/SampleChangeEquip_1.json"), null, null, null, null)
        val group = editor.createGroup()
        addActor(group)

        System.out.println()

    }

    override fun touchUp(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        return super.touchUp(screenX, screenY, pointer, button)
    }
}
