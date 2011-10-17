package com.google.gwt.tok.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * <p>
 * The Publisher object provides the mechanism through which control of the published stream is accomplished. Calling
 * the publish() method of a Session object returns a Publisher object.
 * </p>
 * <p>
 * A session can instantiate multiple publishers (through multiple calls to the publish method. The publishers property
 * of the Session object is an array of local Publisher objects.
 * </p>
 * 
 * @author pmerienne
 * 
 */
public class Publisher {

	// TODO getStyle():Object Gets an object that has properties that define the
	// current appearance of user interface controls of the Publisher.
	// setStyle(style:Object, [value:Object]):Publisher Sets properties that
	// define the appearance of some user interface controls of the Publisher.

	protected JavaScriptObject obj;

	public Publisher(JavaScriptObject obj) {
		this.obj = obj;
	}

	/**
	 * @return The ID of the DOM element through which the Publisher stream is displayed on the local web page.
	 */
	public native String getId() /*-{
		return this.@com.google.gwt.tok.client.Publisher::obj.id;
	}-*/;

	/**
	 * @return The ID of the DOM element that was replaced when the Publisher video stream was inserted into the local
	 *         web page.
	 */
	public native String getReplaceElementId() /*-{
		return this.@com.google.gwt.tok.client.Publisher::obj.replaceElementId;
	}-*/;

	/**
	 * Starts publishing audio (if it is currently not being published) when the value is true; stops publishing audio
	 * (if it is currently being published) when the value is false.
	 * 
	 * @param publish
	 *            Whether to start publishing audio (true) or not (false).
	 */
	public native void publishAudio(boolean publish) /*-{
		this.@com.google.gwt.tok.client.Publisher::obj.publishAudio(publish);
	}-*/;

	/**
	 * Starts publishing video (if it is currently not being published) when the value is true; stops publishing video
	 * (if it is currently being published) when the value is false.
	 * 
	 * @param publish
	 *            Whether to start publishing video (true) or not (false).
	 */
	public native void publishVideo(boolean publish) /*-{
		this.@com.google.gwt.tok.client.Publisher::obj.publishVideo(publish);
	}-*/;

	/**
	 * Gets the microphone gain, between 0 and 100, of the Publisher
	 * 
	 * @return
	 */
	public native int getMicrophoneGain() /*-{
		return this.@com.google.gwt.tok.client.Publisher::obj
				.getMicrophoneGain();
	}-*/;

	/**
	 * Sets the microphone gain, between 0 and 100, of the Publisher.
	 * 
	 * @param microphoneGain
	 */
	public native void setMicrophoneGain(int microphoneGain) /*-{
		this.@com.google.gwt.tok.client.Publisher::obj
				.setMicrophoneGain(microphoneGain);
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
		return this.@com.google.gwt.tok.client.Publisher::obj.getImgData();
	}-*/;

	/**
	 * <p>
	 * Returns a string corresponding to the echo cancellation mode of the Publisher. The string can be one of the
	 * following values:
	 * <p>
	 * </p>
	 * {@link EchoCancellationMode#UNKNOW} — The echo cancellation mode is unknown (the initial state).
	 * 
	 * {@link EchoCancellationMode#NONE} — The Publisher is not using acoustic echo cancellation.
	 * 
	 * {@link EchoCancellationMode#FULLDUPLEX} — The Publisher is using acoustic echo cancellation.
	 * <p>
	 * </p>
	 * You should check this property after the Publisher dispatches the echoCancellationModeChanged event. Until this
	 * event is dispatched, the Publisher will not use echo cancellation; however, the method returns "unknown" (not
	 * "none") until the event is dispatched.
	 * <p>
	 * </p>
	 * The Publisher dispatches the echoCancellationModeChanged event after the Publisher is first created (by calling
	 * the publish() method) when the TokBox code can determine the correct echo cancellation mode. After that, the
	 * Publisher dispatches the event again whenever the setting changes. The setting may change because of the
	 * following reasons:
	 * <ul>
	 * <li>
	 * The user switches to a microphone that changes the setting. (For example, the user switches from a USB mic, which
	 * does not support AEC, to a mic that supports AEC — or vice versa.)</li>
	 * <li>
	 * Device Panel is opened or closed, changing the setting. (For example, the Publisher is using a microphone that
	 * supports AEC, and the Device Panel is displayed, which disables AEC for the mic. When the Device Panel is closed,
	 * the Publisher dispatches the event again, indicating that the Publisher is once again in AEC mode.)does not
	 * support AEC, to a mic that supports AEC — or vice versa.)</li>
	 * <li>
	 * A new Publisher that publishes audio is added, which changes the echo cancellation mode to "none" (if it is not
	 * already that).does not support AEC, to a mic that supports AEC — or vice versa.)</li>
	 * <li>
	 * A Publisher that publishes audio is removed so that there is now only one Publisher, which may change the echo
	 * cancellation mode to "fullDuplex" (if acoustic echo suppression is supported).</li>
	 * </ul>
	 * </p> Acoustic echo cancellation was added in OpenTok v0.91.18. Acoustic echo cancellation is available in clients
	 * running Flash Player 10.3.
	 * <p>
	 * </p>
	 * A Publisher will not use acoustic echo cancellation if any of the following is true:
	 * <p>
	 * </p>
	 * The client has an older version of Flash Player (10.0 through 10.2). The Publisher uses a USB microphone.
	 * (Acoustic echo cancellation is not supported for USB microphones.) The client is publishing audio in another
	 * Publisher. The user has prevented storage of Flash Player local shared objects.
	 * <p>
	 * </p>
	 * If a Publisher does not use acoustic echo cancellation, it may echo back a subscribed audio stream. Use this
	 * method, along with the echoCancellationModeChanged, to configure your app in the case where acoustic echo
	 * cancellation is not supported.
	 * <p>
	 * 
	 * @return
	 */
	public EchoCancellationMode getEchoCancellationMode() {
		String echoCancellationMode = this._getEchoCancellationMode();
		return EchoCancellationMode.valueOf(echoCancellationMode.toUpperCase());
	}

	private native String _getEchoCancellationMode() /*-{
		return this.@com.google.gwt.tok.client.Publisher::obj
				.getEchoCancellationMode();
	}-*/;

	public static enum EchoCancellationMode {
		UNKNOW, NONE, FULLDUPLEX;
	}
}
