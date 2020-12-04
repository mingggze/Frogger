package frogActor;

import javafx.scene.image.Image;

public class BackgroundImage extends Actor{
	/**
	 * override act method and get now as parameter 
	 */

	@Override
	public void act(long now) {
		
		
	}
	
	/**
	 * Create BackgroundImage by getting parameter imagelink
	 * @param imageLink link of image
	 */
	public BackgroundImage(String imageLink) {
		setImage(new Image(imageLink, 600, 800, true, true));
		
	}

}
