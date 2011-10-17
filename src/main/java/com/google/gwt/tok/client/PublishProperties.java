package com.google.gwt.tok.client;

import com.google.gwt.core.client.JavaScriptObject;

public class PublishProperties extends JavaScriptObject {

	// TODO style

	public static PublishProperties get() {
		return JavaScriptObject.createObject().cast();
	}

	protected PublishProperties() {

	}

	public final native String getCameraName() /*-{
		return this.cameraName;
	}-*/;

	/**
	 * The name of a camera to use. You can obtain an array of Camera objects by
	 * calling the DeviceManager.detectDevices() method. The DeviceManager
	 * dispatches a devicesDetected event, which includes an array of Camera
	 * objects. Each Camera object has a name property. The application throws
	 * an error if it cannot use the specified camera.
	 */
	public final native void setCameraName(String cameraName) /*-{
		this.cameraName = cameraName;
	}-*/;

	public final native int getHeight() /*-{
		return this.height;
	}-*/;

	/**
	 * The desired height in pixels of the displayed Publisher video stream
	 * (default: 198). Note: Use the height and width properties to set the
	 * dimensions of the publisher video; do not set the height and width of the
	 * container element (using CSS).
	 */
	public final native void setHeight(Integer height) /*-{
		this.height = height;
	}-*/;

	public final native int getWidth() /*-{
		return this.width;
	}-*/;

	/**
	 * The desired width in pixels of the displayed Publisher video stream
	 * (default: 264). Note: Use the height and width properties to set the
	 * dimensions of the publisher video; do not set the height and width of the
	 * container element (using CSS).
	 */
	public final native void setWidth(int width) /*-{
		this.width = width;
	}-*/;

	public final native int getMicrophoneGain() /*-{
		return this.microphoneGain;
	}-*/;

	/**
	 * The desired microphone gain, between 0 and 100, when the Publisher is
	 * first published (default: 50). After you publish the stream, you can
	 * adjust the microphone gain by calling the setMicrophoneGain() method of
	 * the Publisher object.
	 */
	public final native void setMicrophoneGain(Integer microphoneGain) /*-{
		this.microphoneGain = microphoneGain;
	}-*/;

	public final native String getMicrophoneName() /*-{
		return this.microphoneName;
	}-*/;

	/**
	 * The name of a microphone to use. You can obtain an array of Microphone
	 * objects by calling the DeviceManager.detectDevices() method. The
	 * DeviceManager dispatches a devicesDetected event, which includes an array
	 * of Microphone objects. Each Microphone object has a name property. The
	 * application throws an error if it cannot use the specified microphone.
	 */
	public final native void setMicrophoneName(String microphoneName) /*-{
		this.microphoneName = microphoneName;
	}-*/;

	public final native boolean isMirror() /*-{
		return this.mirror;
	}-*/;

	/**
	 * Whether the publisher's video image is mirrored in the publisher's page.
	 * The default value is true (the video image is mirrored). This property
	 * does not affect the display on other subscribers' web pages .
	 */
	public final native void setMirror(Boolean mirror) /*-{
		this.mirror = mirror;
	}-*/;

	public final native String getName() /*-{
		return this.name;
	}-*/;

	/**
	 * the name for this stream. The default value is "" (an empty string).
	 */
	public final native void setName(String name) /*-{
		this.name = name;
	}-*/;

	public final native boolean isPublishAudio() /*-{
		return this.publishAudio;
	}-*/;

	/**
	 * Whether to initially publish audio for the stream (default: true)
	 */
	public final native void setPublishAudio(Boolean publishAudio) /*-{
		this.publishAudio = publishAudio;
	}-*/;

	public final native boolean isPublishVideo() /*-{
		return this.publishVideo;
	}-*/;

	/**
	 * Whether to initially publish video for the stream (default: true).
	 */
	public final native void setPublishVideo(Boolean publishVideo) /*-{
		this.publishVideo = publishVideo;
	}-*/;

	public final Wmode getWmode() {
		return Wmode.valueOf(this._getWmode());
	}

	private native String _getWmode() /*-{
		return this.cameraName;
	}-*/;

	/**
	 * Set this property to set the transparency of the SWF object used to
	 * display the stream.
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
