package com.google.gwt.tok.client.event;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.tok.client.handler.SessionHandler;

public class SessionDisconnectedEvent extends GwtEvent<SessionHandler> {

	private JavaScriptObject obj;

	public SessionDisconnectedEvent(JavaScriptObject jso) {
		this.obj = jso;
	}

	@Override
	protected void dispatch(SessionHandler handler) {
		handler.onSessionDisconnected(this);
	}

	@Override
	public GwtEvent.Type<SessionHandler> getAssociatedType() {
		return SessionHandler.TYPE;
	}

}
