package com.google.gwt.tok.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.tok.client.event.DeviceStatusEvent;
import com.google.gwt.tok.client.handler.DeviceStatusHandler;
import com.google.gwt.tok.client.handler.ExceptionHandler;
import com.google.gwt.tok.client.util.EventDispatcher;

/**
 * The DeviceManager class lets you select the camera and microphone to use for
 * a publisher stream. Calling the TokBox.initDeviceManager() method returns a
 * DeviceManager object.
 * 
 * @author pmerienne
 * 
 */
public class DeviceManager extends EventDispatcher {

	private JavaScriptObject obj;

	public DeviceManager(JavaScriptObject obj) {
		this.obj = obj;
		this.initEventListeners();
	}

	/**
	 * Whether to show microphone settings in device panels created by calling
	 * the displayPanel() method (true) or not (false). The default value is
	 * true.
	 * 
	 * @param show
	 */
	public native boolean showMicSettings() /*-{
		return this.@com.google.gwt.tok.client.DeviceManager::obj
				.showMicSettings();
	}-*/;

	/**
	 * Whether to show video settings in device panels created by calling the
	 * displayPanel() method (true) or not (false). The default value is true.
	 * 
	 * @param show
	 */
	public native void showVideoSettings(boolean show) /*-{
		this.@com.google.gwt.tok.client.DeviceManager::obj.showVideoSettings();
	}-*/;

	/**
	 * Has the OpenTok API detect connected cameras and microphones. This
	 * operation is asynchronous. The DeviceManager object dispatches a
	 * devicesDetected event when it detects the connected devices.
	 */
	public native void detectDevice() /*-{
		this.@com.google.gwt.tok.client.DeviceManager::obj.detectDevices();
	}-*/;

	// TODO displayPanel

	/**
	 * Event management
	 */

	public native void initEventListeners() /*-{
		var manager = this;
		this.@com.google.gwt.tok.client.DeviceManager::obj
				.addEventListener(
						"devicesDetected",
						function devicesDetectedHandler(event) {
							manager.@com.google.gwt.tok.client.DeviceManager::onDevicesDetected(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
						});
	}-*/;

	public HandlerRegistration addDeviceStatusHandler(DeviceStatusHandler handler) {
		return this.addHandler(DeviceStatusEvent.TYPE, handler);
	}

	/**
	 * Remove an {@link ExceptionHandler}
	 * 
	 * @param handler
	 */
	public void removeDeviceStatusHandler(DeviceStatusHandler handler) {
		this.removeHandler(DeviceStatusEvent.TYPE, handler);
	}

	private void onDevicesDetected(JavaScriptObject jso) {
		this.fireEvent(new DeviceStatusEvent(jso));
	}
}
