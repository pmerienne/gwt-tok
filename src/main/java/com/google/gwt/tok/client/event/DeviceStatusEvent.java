package com.google.gwt.tok.client.event;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.tok.client.Camera;
import com.google.gwt.tok.client.Microphone;
import com.google.gwt.tok.client.handler.DeviceStatusHandler;

public class DeviceStatusEvent extends GwtEvent<DeviceStatusHandler> {

	public static Type<DeviceStatusHandler> TYPE = new Type<DeviceStatusHandler>();

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<DeviceStatusHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(DeviceStatusHandler handler) {
		handler.onDeviceStatus(this);
	}

	private JavaScriptObject obj;

	public DeviceStatusEvent(JavaScriptObject obj) {
		this.obj = obj;
	}

	/**
	 * The error title.
	 */
	public native String getEventType() /*-{
		return this.@com.google.gwt.tok.client.event.DeviceStatusEvent::obj.type;
	}-*/;

	/**
	 * A list of Camera objects corresponding to available cameras.
	 * 
	 * @return
	 */
	public List<Camera> getCameras() {
		List<Camera> cameras = new ArrayList<Camera>();
		JsArray<JavaScriptObject> jsCameras = this._getCameras();
		for (int i = 0; i < jsCameras.length(); i++) {
			cameras.add(new Camera(jsCameras.get(i)));
		}
		return cameras;
	}

	private native JsArray<JavaScriptObject> _getCameras() /*-{
		return this.@com.google.gwt.tok.client.event.DeviceStatusEvent::obj.cameras;
	}-*/;

	/**
	 * A list of Microphone objects corresponding to available microphones.
	 * 
	 * @return
	 */
	public List<Microphone> getMicrophones() {
		List<Microphone> microphones = new ArrayList<Microphone>();
		JsArray<JavaScriptObject> jsMicrophones = this._getMicrophones();
		for (int i = 0; i < jsMicrophones.length(); i++) {
			microphones.add(new Microphone(jsMicrophones.get(i)));
		}
		return microphones;
	}

	private native JsArray<JavaScriptObject> _getMicrophones() /*-{
		return this.@com.google.gwt.tok.client.event.DeviceStatusEvent::obj.microphones;
	}-*/;

	/**
	 * The selected camera.
	 * 
	 * @return
	 */
	public Camera getSelectedCamera() {
		return new Camera(obj);
	}

	public native JavaScriptObject _getSelectedCamera() /*-{
		return this.@com.google.gwt.tok.client.event.DeviceStatusEvent::obj.selectedCamera;
	}-*/;

	/**
	 * The selected microphone.
	 * 
	 * @return
	 */
	public Microphone getSelectedMicrophone() {
		return new Microphone(obj);
	}

	public native JavaScriptObject _getSelectedMicrophone() /*-{
		return this.@com.google.gwt.tok.client.event.DeviceStatusEvent::obj.selectedMicrophone;
	}-*/;
}
