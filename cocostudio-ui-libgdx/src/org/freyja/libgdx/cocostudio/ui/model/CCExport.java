package org.freyja.libgdx.cocostudio.ui.model;

import org.freyja.libgdx.cocostudio.ui.model.animation.CCAnimation;

import java.util.List;

/**
 * ui json结构
 * 
 * @author i see
 * 
 */
public class CCExport {

	String classname;

	String name;

	CCAnimation animation;

	int dataScale;

	float designHeight;

	float designWidth;

	List<String> textures;

	String version;

	CCWidget nodeTree;

	CCWidget widgetTree;

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDataScale() {
		return dataScale;
	}

	public void setDataScale(int dataScale) {
		this.dataScale = dataScale;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public List<String> getTextures() {
		return textures;
	}

	public void setTextures(List<String> textures) {
		this.textures = textures;
	}

	public CCWidget getNodeTree() {
		if(nodeTree != null) {
			return nodeTree;
		}else if(widgetTree != null){
			return widgetTree;
		}
		return null;
	}

	public void setNodeTree(CCWidget widgetTree) {
		this.nodeTree = widgetTree;
	}

	public CCWidget getWidgetTree() {
		if(widgetTree != null) {
			return widgetTree;
		}else if(nodeTree != null){
			return nodeTree;
		}
		return null;
	}

	public void setWidgetTree(CCWidget widgetTree) {
		this.widgetTree = widgetTree;
	}

	public float getDesignHeight() {
		return designHeight;
	}

	public void setDesignHeight(float designHeight) {
		this.designHeight = designHeight;
	}

	public float getDesignWidth() {
		return designWidth;
	}

	public void setDesignWidth(float designWidth) {
		this.designWidth = designWidth;
	}

	public CCAnimation getAnimation() {
		return animation;
	}

	public void setAnimation(CCAnimation animation) {
		this.animation = animation;
	}

}
