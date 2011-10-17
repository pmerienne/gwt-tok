package com.google.gwt.tok.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * The Subscriber object references a stream that you have subscribed to. The Subscriber object includes methods that
 * let you disable and enable local audio playback for the subscribed stream.
 * 
 * The subscribe() method of the Session object returns a Subscriber object. The subscribers property of the Session
 * object is an array of Subscriber objects.
 * 
 * @author pmerienne
 * 
 */
public class Subscriber {

	// TODO
	// getStyle():Object Gets an object that has properties that define the
	// current appearance of user interface controls of the Publisher.
	// setStyle(style:Object, [value:Object]):Subscriber Sets properties that
	// define the appearance of some user interface controls of the Subscriber.

	protected JavaScriptObject obj;

	public Subscriber(JavaScriptObject obj) {
		this.obj = obj;
	}

	/**
	 * @return The stream to which you are subscribing.
	 */
	public Stream getStream() {
		return new Stream(this._getStream());
	}

	public native JavaScriptObject _getStream() /*-{
		return this.@com.google.gwt.tok.client.Subscriber::obj.stream;
	}-*/;

	/**
	 * Starts subscribing audio (if it is available and currently not being subscribed to) when the value is true; stops
	 * subscribing to audio (if it is currently being subscribed to) when the value is false.
	 * 
	 * @param subscribe
	 *            Whether to start subscribing to audio (true) or not (false).
	 */
	public native void subscribeToAudio(boolean subscribe) /*-{
		this.@com.google.gwt.tok.client.Subscriber::obj
				.subscribeToAudio(subscribe);
	}-*/;

	/**
	 * Starts subscribing to video (if it is available and currently not being subscribed to) when the value is true;
	 * stops subscribing to video (if it is currently being subscribed to) when the value is false.
	 * 
	 * @param subscribe
	 *            Whether to start subscribing to video (true) or not (false).
	 */
	public native void subscribeToVideo(boolean subscribe) /*-{
		this.@com.google.gwt.tok.client.Subscriber::obj
				.subscribeToVideo(subscribe);
	}-*/;

	/**
	 * Gets the current audio volume, between 0 and 100, of the Subscriber.
	 * 
	 * @return
	 */
	public native int getAudioVolume() /*-{
		return this.@com.google.gwt.tok.client.Subscriber::obj.getAudioVolume();
	}-*/;

	/**
	 * Sets the desired audio volume, between 0 and 100, of the Subscriber.
	 * 
	 * @param audioVolume
	 */
	public native void setAudioVolume(int audioVolume) /*-{
		this.@com.google.gwt.tok.client.Subscriber::obj
				.setAudioVolume(audioVolume);
	}-*/;

	/**
	 * <p>
	 * Returns a base-64-encoded string of PNG data representing the Subscriber video. Returns an empty string if there
	 * is no video.
	 * </p>
	 * <p>
	 * You can use the string as the value for a data URL scheme passed to the src parameter of an image file
	 * </p>
	 * 
	 * @return
	 */
	public native String getImgData() /*-{
		return this.@com.google.gwt.tok.client.Subscriber::obj.getImgData();
	}-*/;
}
