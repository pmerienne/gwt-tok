package com.google.gwt.tok.client.handler;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.tok.client.event.ConnectionCreatedEvent;
import com.google.gwt.tok.client.event.ConnectionDestroyedEvent;
import com.google.gwt.tok.client.event.SessionConnectedEvent;
import com.google.gwt.tok.client.event.SessionDisconnectedEvent;
import com.google.gwt.tok.client.event.StreamCreatedEvent;
import com.google.gwt.tok.client.event.StreamDestroyedEvent;

public interface SessionHandler extends EventHandler {

	public final static Type<SessionHandler> TYPE = new Type<SessionHandler>();

	void onSessionConnected(SessionConnectedEvent event);

	void onSessionDisconnected(SessionDisconnectedEvent event);

	void onConnectionCreated(ConnectionCreatedEvent event);

	void onConnectionDestroyed(ConnectionDestroyedEvent event);

	void onStreamCreated(StreamCreatedEvent event);

	void onStreamDestroyed(StreamDestroyedEvent event);
}
