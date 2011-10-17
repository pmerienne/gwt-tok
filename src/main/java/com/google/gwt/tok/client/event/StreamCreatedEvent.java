package com.google.gwt.tok.client.event;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.tok.client.Stream;
import com.google.gwt.tok.client.handler.SessionHandler;

public class StreamCreatedEvent extends GwtEvent<SessionHandler> {

	private JavaScriptObject obj;

	public StreamCreatedEvent(JavaScriptObject jso) {
		this.obj = jso;
	}

	@Override
	protected void dispatch(SessionHandler handler) {
		handler.onStreamCreated(this);
	}

	@Override
	public GwtEvent.Type<SessionHandler> getAssociatedType() {
		return SessionHandler.TYPE;
	}

	/**
	 * An array of Stream objects corresponding to the streams to which this
	 * event refers. This is usually an array containing only one Stream object
	 * (the added one)
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
		return this.@com.google.gwt.tok.client.event.StreamCreatedEvent::obj.streams;
	}-*/;
}
