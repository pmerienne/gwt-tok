package com.google.gwt.tok.client.handler;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.tok.client.event.ExceptionEvent;

public interface ExceptionHandler extends EventHandler {

	void onException(ExceptionEvent event);
}
