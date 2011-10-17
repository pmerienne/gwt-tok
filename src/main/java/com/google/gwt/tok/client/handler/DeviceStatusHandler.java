package com.google.gwt.tok.client.handler;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.tok.client.event.DeviceStatusEvent;

public interface DeviceStatusHandler extends EventHandler {

	void onDeviceStatus(DeviceStatusEvent event);
}
