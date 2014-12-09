package org.freyja.libgdx.cocostudio.ui.parser.group;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import org.freyja.libgdx.cocostudio.ui.CocoStudioUIEditor;
import org.freyja.libgdx.cocostudio.ui.model.CCOption;
import org.freyja.libgdx.cocostudio.ui.model.CCWidget;
import org.freyja.libgdx.cocostudio.ui.parser.GroupParser;
import org.freyja.libgdx.cocostudio.ui.widget.TTFLabel;
import org.freyja.libgdx.cocostudio.ui.widget.TTFLabelStyle;

public class CCButton extends GroupParser {

	@Override
	public String getClassName() {
		return "Button";
	}

	@Override
	public Actor parse(CocoStudioUIEditor editor, CCWidget widget,
			CCOption option) {

		ImageButtonStyle style = new ImageButtonStyle(null, null, null,
				editor.findDrawable(option, option.getNormalData().getPath()),
				editor.findDrawable(option, option.getPressedData().getPath()),
				null);
		style.imageDisabled = editor.findDrawable(option, option
				.getDisabledData().getPath());
		ImageButton button = new ImageButton(style);

		button.setOrigin(button.getWidth()/button.getScaleX(), button.getHeight()/button.getScaleY());
		if (option.getText() != null && !option.getText().equals("")) {
			TTFLabelStyle labelStyle = editor.createLabelStyle(option);
			TTFLabel label = new TTFLabel(option.getText(), labelStyle);
			label.setPosition((button.getWidth() - label.getWidth()) / 2,
					(button.getHeight() - label.getHeight()) / 2);
			button.addActor(label);
		}
		return button;
	}

}
