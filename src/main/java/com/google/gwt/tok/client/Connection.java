package com.google.gwt.tok.client;

import java.util.Date;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * The Connection object represents a connection to a TokBox session. The
 * Session object has a connection property that is a Connection object. It
 * represents the local user's connection. The Stream object has a connection
 * property that is a Connection object. It represents the stream publisher's
 * connection.
 * 
 * To initialize a session, call the TokBox.initSession() method, which returns
 * the Session object. Then call the connect() method of the Session object to
 * connect to a session.
 * 
 * @author pmerienne
 * 
 */
public class Connection {

	private JavaScriptObject obj;

	public Connection(JavaScriptObject obj) {
		this.obj = obj;
	}

	/**
	 * 
	 * @return The name identifying the camera.
	 */
	public native String getConnectionId() /*-{
		return this.@com.google.gwt.tok.client.Connection::obj.connectionId;
	}-*/;

	/**
	 * The creation date of the connection
	 * 
	 * @return
	 */
	public Date getCreationTime() {
		int dateInMilliSeconds = this._getCreationTime();
		return new Date(dateInMilliSeconds);
	}

	private native int _getCreationTime() /*-{
		return this.@com.google.gwt.tok.client.Connection::obj.creationTime;
	}-*/;

	/**
	 * 
	 * @return A string containing metadata describing the connection. You
	 *         define this string in one of two ways:
	 *         <ul>
	 *         <li>
	 *         When you generate a user token string (as in the production
	 *         environment), pass the connection data string to the
	 *         generateToken() method of the OpenTok server-side library.</li>
	 *         <li>
	 *         In the staging environment, if you call the Session.connect()
	 *         method with a test token string (such as 'dev_token'), you can
	 *         pass connection data as the connectionData property of the
	 *         properties parameter of the method.</li>
	 */
	public native String getData() /*-{
		return this.@com.google.gwt.tok.client.Connection::obj.data;
	}-*/;

	/**
	 * Includes information about the downstream bandwidth, the upstream
	 * bandwidth, and the latency of the connection at the time the connection
	 * is established. This information can help you to handle different network
	 * conditions (such as connections from mobile devices and on other
	 * low-bandwidth connections). Developers can subscribe to multiplexed
	 * streams and use audio-only mode to use less bandwidth.
	 * 
	 * The quality property is set only if you set the detectConnectionQuality
	 * property to true in the object you pass as the properties parameter of
	 * the connect() method of the Session object.
	 * 
	 * @return
	 */
	public ConnectionQuality getQuality() {
		return new ConnectionQuality(this._getQuality());
	}

	private native JavaScriptObject _getQuality() /*-{
		return this.@com.google.gwt.tok.client.Connection::obj.quality;
	}-*/;
}
