package com.google.gwt.tok.client.event;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.tok.client.Connection;
import com.google.gwt.tok.client.handler.SessionHandler;

public class ConnectionCreatedEvent extends GwtEvent<SessionHandler> {

	private JavaScriptObject obj;

	public ConnectionCreatedEvent(JavaScriptObject jso) {
		this.obj = jso;
	}

	@Override
	protected void dispatch(SessionHandler handler) {
		handler.onConnectionCreated(this);
	}

	@Override
	public GwtEvent.Type<SessionHandler> getAssociatedType() {
		return SessionHandler.TYPE;
	}

	/**
	 * A list of Connection objects for the connections that were created.
	 * 
	 * @return
	 */
	public List<Connection> getConnections() {
		List<Connection> connections = new ArrayList<Connection>();
		JsArray<JavaScriptObject> jsConnections = this._getConnections();
		for (int i = 0; i < jsConnections.length(); i++) {
			connections.add(new Connection(jsConnections.get(i)));
		}
		return connections;
	}

	private native JsArray<JavaScriptObject> _getConnections() /*-{
		return this.@com.google.gwt.tok.client.event.ConnectionCreatedEvent::obj.connections;
	}-*/;

}
