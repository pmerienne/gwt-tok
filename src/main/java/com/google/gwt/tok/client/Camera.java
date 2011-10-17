package com.google.gwt.tok.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Specifies a camera on the client machine.
 * 
 * The DeviceManager object dispatches a deviceDetected event. This event object
 * includes a cameras property that is an array of Camera objects. It also
 * includes a selectedCamera object that is a Camera object.
 * 
 * @author pmerienne
 * 
 */
public class Camera extends Device {

	public Camera(JavaScriptObject obj) {
		super(obj);
	}

}
