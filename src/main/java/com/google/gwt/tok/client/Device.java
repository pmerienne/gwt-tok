package com.google.gwt.tok.client;

import com.google.gwt.core.client.JavaScriptObject;

public abstract class Device {

	private JavaScriptObject obj;

	public Device(JavaScriptObject obj) {
		this.obj = obj;
	}

	/**
	 * 
	 * @return The name identifying the camera.
	 */
	public native String getName() /*-{
		return this.@com.google.gwt.tok.client.Device::obj.name;
	}-*/;

	/**
	 * The status of the client device : either {@link Status#ACTIVE},
	 * {@link Status#INACTIVE}, or {@link Status#UNKNOWN}. If the value is
	 * {@link Status#UNKNOWN}, the user has not granted permission to use the
	 * camera (in the Flash Player Settings dialog box).
	 * 
	 * @author pmerienne
	 * 
	 */
	public native String getStatus() /*-{
		return this.@com.google.gwt.tok.client.Device::obj.status;
	}-*/;

}
