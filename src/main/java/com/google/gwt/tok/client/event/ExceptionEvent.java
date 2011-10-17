package com.google.gwt.tok.client.event;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.tok.client.handler.ExceptionHandler;

/**
 * TokBox dispatches exception events when the TokBox encounters an exception
 * (error). The ExeptionEvent object defines the properties of the event object
 * that is dispatched.
 * 
 * @author pmerienne
 * 
 */
public class ExceptionEvent extends GwtEvent<ExceptionHandler> {

	public static Type<ExceptionHandler> TYPE;

	public static Type<ExceptionHandler> getType() {
		return TYPE != null ? TYPE : (TYPE = new Type<ExceptionHandler>());
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<ExceptionHandler> getAssociatedType() {
		return getType();
	}

	@Override
	protected void dispatch(ExceptionHandler handler) {
		handler.onException(this);
	}

	private JavaScriptObject obj;

	public ExceptionEvent(JavaScriptObject obj) {
		this.obj = obj;
	}

	/**
	 * The error code.
	 * 
	 * See http://www.tokbox.com/opentok/api/tools/js/documentation/api/
	 * ExceptionEvent.html for list of error codes
	 */
	public native int getCode() /*-{
		return this.@com.google.gwt.tok.client.event.ExceptionEvent::obj.code;
	}-*/;

	/**
	 * The error message.
	 */
	public native String getMesage() /*-{
		return this.@com.google.gwt.tok.client.event.ExceptionEvent::obj.message;
	}-*/;

	/**
	 * The error title.
	 */
	public native String getTitle() /*-{
		return this.@com.google.gwt.tok.client.event.ExceptionEvent::obj.title;
	}-*/;

	/**
	 * The error title.
	 */
	public native String getErrorType() /*-{
		return this.@com.google.gwt.tok.client.event.ExceptionEvent::obj.type;
	}-*/;

}
