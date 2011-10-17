package com.google.gwt.tok.client;

import com.google.gwt.core.client.JavaScriptObject;

public class SubscriberProperties extends JavaScriptObject {

	public static SubscriberProperties get() {
		return JavaScriptObject.createObject().cast();
	}

	protected SubscriberProperties() {

	}

	// TODO style

	public final native int getHeight() /*-{
		return this.height;
	}-*/;

	/**
	 * The desired height in pixels of the displayed Publisher video stream (default: 198). Note: Use the height and
	 * width properties to set the dimensions of the publisher video; do not set the height and width of the container
	 * element (using CSS).
	 */
	public final native void setHeight(Integer height) /*-{
		this.height = height;
	}-*/;

	public final native int getWidth() /*-{
		return this.width;
	}-*/;

	/**
	 * The desired audio volume, between 0 and 100, when the Subscriber is first opened (default: 50). After you
	 * subscribe to the stream, you can adjust the volume by calling the setAudioVolume() method of the Subscriber
	 * object. This volume setting affects local playback only; it does not affect the stream's volume on other clients.
	 */
	public final native void setAudioVolume(int audioVolume) /*-{
		this.audioVolume = audioVolume;
	}-*/;

	/**
	 * The desired audio volume, between 0 and 100, when the Subscriber is first opened (default: 50). After you
	 * subscribe to the stream, you can adjust the volume by calling the setAudioVolume() method of the Subscriber
	 * object. This volume setting affects local playback only; it does not affect the stream's volume on other clients.
	 * 
	 * @return
	 */
	public final native int getAudioVolume() /*-{
		return this.audioVolume;
	}-*/;

	/**
	 * The desired width in pixels of the displayed Publisher video stream (default: 264). Note: Use the height and
	 * width properties to set the dimensions of the publisher video; do not set the height and width of the container
	 * element (using CSS).
	 */
	public final native void setWidth(int width) /*-{
		this.width = width;
	}-*/;

	/**
	 * Whether to initially subscribe to audio (if available) for the stream (default: true)
	 */
	public final native boolean isSubscribeToAudio() /*-{
		return this.subscribeToAudio;
	}-*/;

	/**
	 * Whether to initially subscribe to audio (if available) for the stream (default: true)
	 */
	public final native void setSubscribeToAudio(Boolean subscribeToAudio) /*-{
		this.subscribeToAudio = subscribeToAudio;
	}-*/;

	/**
	 * Whether to initially subscribe to video (if available) for the stream (default: true)
	 */
	public final native boolean isSubscribeToVideo() /*-{
		return this.subscribeToVideo;
	}-*/;

	/**
	 * Whether to initially subscribe to video (if available) for the stream (default: true)
	 */
	public final native void setSubscribeToVideo(Boolean subscribeToVideo) /*-{
		this.subscribeToVideo = subscribeToVideo;
	}-*/;

	public final Wmode getWmode() {
		return Wmode.valueOf(this._getWmode());
	}

	private native String _getWmode() /*-{
		return this.cameraName;
	}-*/;

	/**
	 * Set this property to set the transparency of the SWF object used to display the stream.
	 */
	public final void setWmode(Wmode wmode) {
		this._setWmode(wmode.name());
	}

	private native void _setWmode(String wmode) /*-{
		this.wmode = wmode;
	}-*/;

	public enum Wmode {
		WINDOW, TRANSPARENT, OPAQUE;
	}
}
