package com.google.gwt.tok.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * A class that defines properties of the quality property of a Connection
 * object.
 * 
 * @author pmerienne
 * 
 */
public class ConnectionQuality {

	private JavaScriptObject obj;

	public ConnectionQuality(JavaScriptObject obj) {
		this.obj = obj;
	}

	/**
	 * @return The downstream bandwidth, in kilobits per second. This is the
	 *         number of kilobits that can be sent to the OpenTok server each
	 *         second. Each subscribed audio-video stream requires from 150 to
	 *         200 kbps.
	 */
	public native int getDownBandwidth() /*-{
		return this.@com.google.gwt.tok.client.ConnectionQuality::obj.downBandwidth;
	}-*/;

	/**
	 * @return The connection latency, in milliseconds. This is time it takes
	 *         for a sent signal to go to the OpenTok server and return back to
	 *         the client. The acceptable values for latency depend on the
	 *         requirements of your application.
	 */
	public native int getLatency() /*-{
		return this.@com.google.gwt.tok.client.ConnectionQuality::obj.latency;
	}-*/;

	/**
	 * @return The upstream bandwidth, in kilobits per second. This is the
	 *         number of kilobits that can be received from the OpenTok server
	 *         each second. Each published audio-video stream requires from 150
	 *         to 200 kbps.
	 */
	public native int getUpBandwidth() /*-{
		return this.@com.google.gwt.tok.client.ConnectionQuality::obj.upBandwidth;
	}-*/;
}
