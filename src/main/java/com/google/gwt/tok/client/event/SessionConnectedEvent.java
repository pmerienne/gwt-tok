package com.google.gwt.tok.client.event;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.tok.client.Connection;
import com.google.gwt.tok.client.Stream;
import com.google.gwt.tok.client.handler.SessionHandler;

public class SessionConnectedEvent extends GwtEvent<SessionHandler> {

	private JavaScriptObject obj;

	public SessionConnectedEvent(JavaScriptObject jso) {
		this.obj = jso;
	}

	@Override
	protected void dispatch(SessionHandler handler) {
		handler.onSessionConnected(this);
	}

	@Override
	public GwtEvent.Type<SessionHandler> getAssociatedType() {
		return SessionHandler.TYPE;
	}

	// archives, targets, type, group

	/**
	 * A list of Connection, representing connections to the session. (Note that
	 * each connection can publish multiple streams.)
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
		return this.@com.google.gwt.tok.client.event.SessionConnectedEvent::obj.connections;
	}-*/;

	/**
	 * A list of Stream objects corresponding to the streams currently available
	 * in the session that has connected.
	 * 
	 * @return
	 */
	public List<Stream> getStreams() {
		List<Stream> streams = new ArrayList<Stream>();
		JsArray<JavaScriptObject> jsStreams = this._getStreams();
		for (int i = 0; i < jsStreams.length(); i++) {
			streams.add(new Stream(jsStreams.get(i)));
		}
		return streams;
	}

	private native JsArray<JavaScriptObject> _getStreams() /*-{
		return this.@com.google.gwt.tok.client.event.SessionConnectedEvent::obj.streams;
	}-*/;
}
