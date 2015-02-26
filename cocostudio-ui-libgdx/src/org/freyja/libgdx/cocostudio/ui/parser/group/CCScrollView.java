package org.freyja.libgdx.cocostudio.ui.parser.group;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane.ScrollPaneStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import org.freyja.libgdx.cocostudio.ui.CocoStudioUIEditor;
import org.freyja.libgdx.cocostudio.ui.model.CCOption;
import org.freyja.libgdx.cocostudio.ui.model.CCWidget;
import org.freyja.libgdx.cocostudio.ui.parser.GroupParser;

/**
 * @tip 滚动方向,回弹滚动支持不是很好
 * @author i see
 * 
 */
public class CCScrollView extends GroupParser {

	@Override
	public String getClassName() {
		return "ScrollView";
	}

	@Override
	public Actor parse(CocoStudioUIEditor editor, CCWidget widget,
			CCOption option) {
		ScrollPaneStyle style = new ScrollPaneStyle();

		if (option.getBackGroundImageData() != null) {

			style.background = editor.findDrawable(option, option
					.getBackGroundImageData().getPath());
		}
		return new ScrollPane(null, style);
	}

	@Override
	public Group groupChildrenParse(CocoStudioUIEditor editor, CCWidget widget,
			CCOption option, Group parent, Actor actor) {
		ScrollPane scrollPane = (ScrollPane) actor;
		Table table = new Table();
		for (CCWidget childrenWidget : widget.getChildren()) {
            Actor childrenActor = editor.parseWidget(table, childrenWidget);
			if (childrenActor == null) {
				continue;
			}
            childrenActor.setPosition(0,0);
			table.add(childrenActor).fillX().expandX().size(childrenActor.getWidth(), childrenActor.getHeight());
            table.row();
        }

		scrollPane.setWidget(table);

		return scrollPane;
	}

}
