package com.google.gwt.tok.client;

import java.util.Date;

import com.google.gwt.core.client.JavaScriptObject;

public class Stream {

	protected JavaScriptObject obj;

	public Stream(JavaScriptObject obj) {
		this.obj = obj;
	}

	// TODO startRecording(archive:Archive) [Archiving beta] Starts recording
	// the stream to an archive.
	// stopRecording(archive:Archive) [Archiving beta] Stops recording the
	// stream to an archive.

	/**
	 * @return The Connection object corresponding to the connection that is publishing the stream. You can compare this
	 *         to to the connection property of the Session object to see if the stream is being published by the local
	 *         web page.
	 */
	public Connection getConnection() {
		return new Connection(this._getConnection());
	}

	private native JavaScriptObject _getConnection() /*-{
		return this.@com.google.gwt.tok.client.Stream::obj.connection;
	}-*/;

	public Date getCreationTime() {
		return new Date(this._getCreationTime());
	}

	private native int _getCreationTime() /*-{
		return this.@com.google.gwt.tok.client.Stream::obj.creationTime;
	}-*/;

	/**
	 * Whether the stream has audio published.
	 * 
	 * @return
	 */
	public native boolean hasAudio() /*-{
		return this.@com.google.gwt.tok.client.Stream::obj.hasAudio;
	}-*/;

	/**
	 * Whether the stream has video published.
	 * 
	 * @return
	 */
	public native boolean hasVideo() /*-{
		return this.@com.google.gwt.tok.client.Stream::obj.hasVideo;
	}-*/;

	/**
	 * The name of the stream. Publishers can specify a name when publishing a stream (using the publish() method of the
	 * publisher's Session object).
	 * 
	 * @return
	 */
	public native String getName() /*-{
		return this.@com.google.gwt.tok.client.Stream::obj.name;
	}-*/;

	/**
	 * @return The ID of the stream.
	 */
	public native String getStreamId() /*-{
		return this.@com.google.gwt.tok.client.Stream::obj.streamId;
	}-*/;

	public Type getType() {
		String type = this._getType();
		return Type.valueOf(type);
	}

	private native String _getType() /*-{
		return this.@com.google.gwt.tok.client.Stream::obj.type;
	}-*/;

	public enum Type {
		BASIC, MULTIPLEXED, ARCHIVE;
	}
}
