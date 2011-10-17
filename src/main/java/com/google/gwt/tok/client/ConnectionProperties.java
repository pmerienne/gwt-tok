package com.google.gwt.tok.client;

import com.google.gwt.core.client.JavaScriptObject;

public class ConnectionProperties extends JavaScriptObject {

	public static ConnectionProperties get(String connectionData, boolean detectConnectionQuality) {
		ConnectionProperties connectionProperties = JavaScriptObject.createObject().cast();
		connectionProperties.setConnectionData(connectionData);
		connectionProperties.setDetectConnectionQuality(detectConnectionQuality);
		return connectionProperties;
	}

	public static ConnectionProperties get() {
		return JavaScriptObject.createObject().cast();
	}

	protected ConnectionProperties() {
	}

	/**
	 * <p>
	 * A string containing metadata describing the connection. For example, you can pass the user ID, name, or other
	 * data describing the connection. Set this string only when testing with the staging environment and using a test
	 * token string (such as 'devtoken') as the token parameter value. The length of the string is limited to 1000
	 * characters.
	 * </p>
	 * <p>
	 * Important: When you generate a user token string (as in the production environment), pass the connection data
	 * string to the generateToken() method of the OpenTok server-side library. Passing the data on the server prevents
	 * a client from sending data insecurely. The connectionData string passed to the client-side Session.connect()
	 * method is ignored.
	 * </p>
	 * <p>
	 * The data property of the Connection object is set to the connection data string.
	 * </p>
	 * <p>
	 * Clients can access the Connection object in event listeners for the sessionConnected event, the connectionCreated
	 * event, and the streamCreated event. The sessionCreated and connectionCreated events each have a connections
	 * property, which is an array of Connection objects. The sessionCreated and streamCreated events each have a
	 * streams property, which is an array of Stream objects. (Each Stream object has a connection property, which is a
	 * Connection object.)
	 * </p>
	 * 
	 * @return
	 */
	public native String getConnectionData() /*-{
		return this.connectionData;
	}-*/;

	/**
	 * <p>
	 * A string containing metadata describing the connection. For example, you can pass the user ID, name, or other
	 * data describing the connection. Set this string only when testing with the staging environment and using a test
	 * token string (such as 'devtoken') as the token parameter value. The length of the string is limited to 1000
	 * characters.
	 * </p>
	 * <p>
	 * Important: When you generate a user token string (as in the production environment), pass the connection data
	 * string to the generateToken() method of the OpenTok server-side library. Passing the data on the server prevents
	 * a client from sending data insecurely. The connectionData string passed to the client-side Session.connect()
	 * method is ignored.
	 * </p>
	 * <p>
	 * The data property of the Connection object is set to the connection data string.
	 * </p>
	 * <p>
	 * Clients can access the Connection object in event listeners for the sessionConnected event, the connectionCreated
	 * event, and the streamCreated event. The sessionCreated and connectionCreated events each have a connections
	 * property, which is an array of Connection objects. The sessionCreated and streamCreated events each have a
	 * streams property, which is an array of Stream objects. (Each Stream object has a connection property, which is a
	 * Connection object.)
	 * </p>
	 * 
	 * @param connectionData
	 */
	public final native void setConnectionData(String connectionData) /*-{
		this.connectionData = connectionData;
	}-*/;

	public boolean getDetectConnectionQuality() {
		int detectConnectionQuality = this._getDetectConnectionQuality();
		return detectConnectionQuality == 1;
	}

	/**
	 * Determines whether the connectionQuality property of the connection property of the Session object will be set.
	 * The connectionQuality property of the connection property of the Session object includes information about the
	 * downstream bandwith, the upstream bandwidth, and the latency at the time of the connection. (See the connection
	 * property.)
	 * 
	 * @return
	 */
	public native int _getDetectConnectionQuality() /*-{
		return this.detectConnectionQuality;
	}-*/;

	/**
	 * Determines whether the connectionQuality property of the connection property of the Session object will be set.
	 * The connectionQuality property of the connection property of the Session object includes information about the
	 * downstream bandwith, the upstream bandwidth, and the latency at the time of the connection. (See the connection
	 * property.)
	 * 
	 * @param detectConnectionQuality
	 */
	public void setDetectConnectionQuality(boolean detectConnectionQuality) {
		if (detectConnectionQuality) {
			this._setDetectConnectionQuality(1);
		} else {
			this._setDetectConnectionQuality(0);
		}
	}

	public final native void _setDetectConnectionQuality(int detectConnectionQuality) /*-{
		this.detectConnectionQuality = detectConnectionQuality;
	}-*/;

}
