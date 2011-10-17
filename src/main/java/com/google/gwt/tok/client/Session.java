package com.google.gwt.tok.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.tok.client.event.ConnectionCreatedEvent;
import com.google.gwt.tok.client.event.ConnectionDestroyedEvent;
import com.google.gwt.tok.client.event.SessionConnectedEvent;
import com.google.gwt.tok.client.event.SessionDisconnectedEvent;
import com.google.gwt.tok.client.event.StreamCreatedEvent;
import com.google.gwt.tok.client.event.StreamDestroyedEvent;
import com.google.gwt.tok.client.handler.ExceptionHandler;
import com.google.gwt.tok.client.handler.SessionHandler;
import com.google.gwt.tok.client.util.EventDispatcher;

public class Session extends EventDispatcher {

	private JavaScriptObject obj;

	public Session(JavaScriptObject obj) {
		this.obj = obj;
	}

	// TODO capabilities, closeArchive, createArchive, forceUnpublish,
	// getPublisherForStream, getSubscribersForStream, loadArchive, signal,
	// startRecording, stopRecording

	/**
	 * The Connection object for this session. The connection property is only available once the Session object
	 * dispatches the sessionConnected event. The Session object asynchronously dispatches a sessionConnected event in
	 * response to a successful call to connect() method.
	 * 
	 * @return
	 */
	public Connection getConnection() {
		return new Connection(this._getConnection());
	}

	private native JavaScriptObject _getConnection() /*-{
		return this.@com.google.gwt.tok.client.Session::obj.connection;
	}-*/;

	/**
	 * The session ID for this session. You obtain a session ID as a return value when connecting to the OpenTok session
	 * creation URL. You obtain a session object by supplying the session ID to the TB.initSession() method. (Note: a
	 * Session object is not connected to the TokBox server until you call the connect() method of the object and the
	 * object dispatches a connected event.
	 * 
	 * @return
	 */
	public native String getSessionId() /*-{
		return this.@com.google.gwt.tok.client.Session::obj.sessionId;
	}-*/;

	/**
	 * <p>
	 * Closes local publishers and subscribers, removing their video displays from the local web page DOM.
	 * </p>
	 * <p>
	 * Calling the cleanup() method stops all Publishers in the current session on the local web page from publishing,
	 * unsubscribes all Subscribers, and removes all associated displays from the local web page. Calling cleanup()
	 * method is equivalent to doing the following:
	 * </p>
	 * <p>
	 * Looping through the the publishers array of the Session object and calling the unpublish() method of the Session
	 * object for each Publisher object. Looping through the the subscribers array of the Session object and calling the
	 * unsubscribe() method of the Session object for each Subscriber object.
	 * </p>
	 * <p>
	 * You may call the cleanup() method in response to a sessionDisconnected event. In this case, the session has
	 * already been disconnected prior the call to the cleanup() method. Consequently, any local publishers and
	 * subscribers have already had their streams terminated. The cleanup() method simply removes their associated
	 * displays from the local web page. In this situation, calling the cleanup() method does not trigger a
	 * streamDestroyed event for any Publishers it cleans up. The Session object will have already dispatched this event
	 * as a result of the prior connection termination.
	 * </p>
	 * <p>
	 * StreamDestroyedEvent — Dispatched when a stream is destroyed as a result of the call to this method.
	 * </p>
	 */
	public native void cleanup() /*-{
		this.@com.google.gwt.tok.client.Session::obj.cleanup();
	}-*/;

	/**
	 * <p>
	 * Connects to an OpenTok session. Pass the API key as the apiKey parameter. You obtain a API key when you register
	 * with TokBox. Pass the token string as the token parameter.
	 * </p>
	 * <p>
	 * Before calling this method, obtain a Session object by calling the TokBox.initSession(), which creates a session
	 * object based on a session ID.
	 * </p>
	 * <p>
	 * Upon a successful connection, the Session object dispatches a SessionConnectedEvent.
	 * </p>
	 * <p>
	 * The Session object dispatches a ConnectionCreatedEvent when other clients create connections to the session.
	 * </p>
	 * <p>
	 * Calling this method creates a hidden controller object on the web page. The controller has no visual
	 * manifestation to the end user, so no explicit placement control is provided for it.
	 * </p>
	 * <p>
	 * The TokBox object dispatches an exception event if the session ID, API key, or token string are invalid.
	 * </p>
	 * <p>
	 * The application throws an error if the system requirements are not met (see TokBox.checkSystemRequirements()).
	 * The application also throws an error if the session has peer-to-peer streaming enabled and two clients are
	 * already connected to the session (see the OpenTok server-side libraries reference).
	 * </p>
	 * 
	 * @param apiKey
	 *            The API key that TokBox provided you when you registered for the OpenTok API.
	 * @param token
	 *            he session token. You generate a session token by connecting to the TokBox server using the OpenTok
	 *            server-side libraries. While using the staging environment, you can use the 'devtoken' or
	 *            'moderator_token' test token strings token in place of a proper server-generated token. Use the
	 *            'devtoken' test string to assign the role of a publisher. Use the 'moderator_token' test token string
	 *            to assign the role of a moderator. (The 'moderator_token' string was added in OpenTok v0.91.5.) For
	 *            more information, see Connection token creation, Moving from testing to production, and OpenTok
	 *            server-side libraries reference.
	 */
	public native void connect(String apiKey, String token) /*-{
		this.@com.google.gwt.tok.client.Session::obj.connect(apiKey, token);
	}-*/;

	public native void connect(String apiKey, String token, ConnectionProperties connectionProperties) /*-{
		this.@com.google.gwt.tok.client.Session::obj.connect(apiKey, token,
				connectionProperties);
	}-*/;

	/**
	 * <p>
	 * Disconnects from the OpenTok session.
	 * </p>
	 * <p>
	 * Calling the disconnect() method ends your connection with the session. In the course of terminating your
	 * connection, it also ceases publishing any stream(s) you were publishing.
	 * </p>
	 * <p>
	 * Session objects dispatch streamDestroyed events to all session connections for any stream you were publishing.
	 * The Session object dispatches a sessionDisconnected event locally. The Session objects on other (non-local)
	 * pages, dispatch connectionDestroyed events, letting other connections know you have left the session. The
	 * SessionDisconnectEvent and StreamEvent objects that define the sessionDisconnect and connectionDestroyed events
	 * each have a reason property. The reason property lets the developer determine whether the connection is being
	 * terminated voluntarily and whether any streams are being destroyed as a byproduct of the underlying connection's
	 * voluntary destruction.
	 * </p>
	 * <p>
	 * Note that while calling the disconnect() method ceases publishing and subscribing to streams, it does not remove
	 * Publisher and Subscriber objects from the local web page. Call the cleanup() method in conjunction with the
	 * disconnect() method to create a smooth user experience when disconnecting.
	 */
	public native void disconnect() /*-{
		this.@com.google.gwt.tok.client.Session::obj.disconnect();
	}-*/;

	/**
	 * <p>
	 * Forces a remote connection to leave the session.
	 * </p>
	 * <p>
	 * The forceDisconnect() method is normally used as a moderation tool to remove users from an ongoing session.
	 * </p>
	 * <p>
	 * When a connection is terminated using the forceDisconnect(), sessionDisconnected, connectionDestroyed and
	 * streamDestroyed events are dispatched in the same way as they would be if the connection had terminated itself
	 * using the disconnect() method. However,the reason property of a ConnectionEvent or StreamEvent object specifies
	 * "forceDisconnected" as the reason for the destruction of the connection and stream(s).
	 * </p>
	 * <p>
	 * While you can use the forceDisconnect() method to terminate your own connection, calling the disconnect() method
	 * is simpler.
	 * </p>
	 * <p>
	 * The TB object dispatches an exception event if the user's role does not include permissions required to force
	 * other users to disconnect. You define a user's role when you create the user token using the generate_token()
	 * method using the OpenTok server-side SDKs. You pass the token string as a parameter of the connect() method of
	 * the Session object. (In the test sandbox, you can also use the "moderator_token" test token string, which puts
	 * the user in the moderator role.).
	 * 
	 * @param connection
	 *            The connection to be disconnected from the session. This value can either be a Connection object or a
	 *            connection ID (which can be obtained from the connectionId property of the Connection object).
	 */
	public native void forceDisconnect(Connection connection) /*-{
		this.@com.google.gwt.tok.client.Session::obj
				.forceDisconnect(connection);
	}-*/;

	/**
	 * <p>
	 * The publish() method starts publishing an audio-video stream to the session. The audio-video stream is generally
	 * captured from a local microphone and webcam, depending on how camera and microphone acquisition have been
	 * configured. Upon successful publishing, the Session objects on all connected web pages dispatch streamCreated.
	 * </p>
	 * <p>
	 * A local display of the published stream is created on the web page by replacing the specified element in the DOM
	 * with a streaming video display. The video stream is automatically mirrored horizontally so that users see
	 * themselves and movement in their stream in a natural way. If the width and height of the display do not match the
	 * 4:3 aspect ratio of the video signal, the video stream is cropped to fit the display.
	 * </p>
	 * <p>
	 * If the OpenTok API does not have access to the camera or microphone, the Flash Player Settings dialog box may
	 * display immediately upon publishing the stream.
	 * </p>
	 * <p>
	 * The TB object dispatches an exception event if the user's role does not include permissions required to publish.
	 * For example, if the user's role is set to subscriber, then they cannot publish. You define a user's role when you
	 * create the user token using the generate_token() method using the OpenTok server-side SDKs. You pass the token
	 * string as a parameter of the connect() method of the Session object. (In the test sandbox, you can also use the
	 * "moderator_token" test token string, which puts the user in the moderator role.)
	 * 
	 * @param replaceElementId
	 *            The id attribute of the existing DOM element that the Publisher video replaces. If you do not specify
	 *            a replaceElementId, the application appends a new DOM element to the HTML body.
	 * @return
	 */
	public Publisher publish(String replaceElementId) {
		return new Publisher(this._publish(replaceElementId));
	}

	private native JavaScriptObject _publish(String replaceElementId) /*-{
		return this.@com.google.gwt.tok.client.Session::obj
				.publish(replaceElementId);
	}-*/;

	/**
	 * <p>
	 * The publish() method starts publishing an audio-video stream to the session. The audio-video stream is generally
	 * captured from a local microphone and webcam, depending on how camera and microphone acquisition have been
	 * configured. Upon successful publishing, the Session objects on all connected web pages dispatch streamCreated.
	 * </p>
	 * <p>
	 * A local display of the published stream is created on the web page by replacing the specified element in the DOM
	 * with a streaming video display. The video stream is automatically mirrored horizontally so that users see
	 * themselves and movement in their stream in a natural way. If the width and height of the display do not match the
	 * 4:3 aspect ratio of the video signal, the video stream is cropped to fit the display.
	 * </p>
	 * <p>
	 * If the OpenTok API does not have access to the camera or microphone, the Flash Player Settings dialog box may
	 * display immediately upon publishing the stream.
	 * </p>
	 * <p>
	 * The TB object dispatches an exception event if the user's role does not include permissions required to publish.
	 * For example, if the user's role is set to subscriber, then they cannot publish. You define a user's role when you
	 * create the user token using the generate_token() method using the OpenTok server-side SDKs. You pass the token
	 * string as a parameter of the connect() method of the Session object. (In the test sandbox, you can also use the
	 * "moderator_token" test token string, which puts the user in the moderator role.)
	 * 
	 * @param replaceElementId
	 *            The id attribute of the existing DOM element that the Publisher video replaces. If you do not specify
	 *            a replaceElementId, the application appends a new DOM element to the HTML body.
	 * 
	 * @param publishProperties
	 * @return
	 */
	public Publisher publish(String replaceElementId, PublishProperties publishProperties) {
		return new Publisher(this._publish(replaceElementId, publishProperties));
	}

	private native JavaScriptObject _publish(String replaceElementId, PublishProperties publishProperties) /*-{
		return this.@com.google.gwt.tok.client.Session::obj.publish(
				replaceElementId, publishProperties);
	}-*/;

	/**
	 * The unpublish() method ceases publishing the specified publisher's audio-video stream to the session. The local
	 * representation of the audio-video stream is removed from the web page. Upon successful termination, the Session
	 * object on every connected web page dispatches a streamDestroyed event.
	 * 
	 * @param publisher
	 *            The Publisher object to stop streaming.
	 */
	public void unpublish(Publisher publisher) {
		this._unpublish(publisher.obj);
	}

	public native void _unpublish(JavaScriptObject jso) /*-{
		this.@com.google.gwt.tok.client.Session::obj.unpublish(jso);
	}-*/;

	/**
	 * <p>
	 * Subscribes to a stream that is available to the session. You can get an array of available streams from the
	 * streams of the sessionConnect event object. The Session object dispatches this event in response to a successful
	 * call to the connect() method. As other publishers connect to the session, the Session object dispatches a
	 * streamCreated event. This event object has a streams property, which is an updated array of the Stream objects
	 * corresponding to streams connected to the session.
	 * </p>
	 * <p>
	 * Starts subscribing to the session's audio-video stream specified.
	 * </p>
	 * <p>
	 * The subscribed stream is displayed on the local web page by replacing the specified element in the DOM with a
	 * streaming video display. If the width and height of the display do not match the 4:3 aspect ratio of the video
	 * signal, the video stream is cropped to fit the display. If the stream lacks a video component, a blank screen
	 * with an audio indicator is displayed in place of the video stream.
	 * </p>
	 * <p>
	 * The application throws an error if the session is not connected or if the replaceElementId does not exist in the
	 * HTML DOM.
	 * </p>
	 * 
	 * @param stream
	 *            Stream object representing the stream to which we are trying to subscribe.
	 */
	public Subscriber subscribe(Stream stream) {
		return new Subscriber(this._subscribe(stream.obj));
	}

	private native JavaScriptObject _subscribe(JavaScriptObject stream) /*-{
		return this.@com.google.gwt.tok.client.Session::obj.subscribe(stream);
	}-*/;

	/**
	 * <p>
	 * Subscribes to a stream that is available to the session. You can get an array of available streams from the
	 * streams of the sessionConnect event object. The Session object dispatches this event in response to a successful
	 * call to the connect() method. As other publishers connect to the session, the Session object dispatches a
	 * streamCreated event. This event object has a streams property, which is an updated array of the Stream objects
	 * corresponding to streams connected to the session.
	 * </p>
	 * <p>
	 * Starts subscribing to the session's audio-video stream specified.
	 * </p>
	 * <p>
	 * The subscribed stream is displayed on the local web page by replacing the specified element in the DOM with a
	 * streaming video display. If the width and height of the display do not match the 4:3 aspect ratio of the video
	 * signal, the video stream is cropped to fit the display. If the stream lacks a video component, a blank screen
	 * with an audio indicator is displayed in place of the video stream.
	 * </p>
	 * <p>
	 * The application throws an error if the session is not connected or if the replaceElementId does not exist in the
	 * HTML DOM.
	 * </p>
	 * 
	 * @param stream
	 *            Stream object representing the stream to which we are trying to subscribe.
	 * @param replaceElementId
	 *            String ID of the existing DOM element that the Subscriber replaces. If you do not specify a
	 *            replaceElementId, the application appends a new DOM element to the HTML body.
	 */
	public Subscriber subscribe(Stream stream, String replaceElementId) {
		return new Subscriber(this._subscribe(stream.obj, replaceElementId));
	}

	private native JavaScriptObject _subscribe(JavaScriptObject stream, String replaceElementId) /*-{
		return this.@com.google.gwt.tok.client.Session::obj.subscribe(stream,
				replaceElementId);
	}-*/;

	/**
	 * <p>
	 * Subscribes to a stream that is available to the session. You can get an array of available streams from the
	 * streams of the sessionConnect event object. The Session object dispatches this event in response to a successful
	 * call to the connect() method. As other publishers connect to the session, the Session object dispatches a
	 * streamCreated event. This event object has a streams property, which is an updated array of the Stream objects
	 * corresponding to streams connected to the session.
	 * </p>
	 * <p>
	 * Starts subscribing to the session's audio-video stream specified.
	 * </p>
	 * <p>
	 * The subscribed stream is displayed on the local web page by replacing the specified element in the DOM with a
	 * streaming video display. If the width and height of the display do not match the 4:3 aspect ratio of the video
	 * signal, the video stream is cropped to fit the display. If the stream lacks a video component, a blank screen
	 * with an audio indicator is displayed in place of the video stream.
	 * </p>
	 * <p>
	 * The application throws an error if the session is not connected or if the replaceElementId does not exist in the
	 * HTML DOM.
	 * </p>
	 * 
	 * @param stream
	 *            Stream object representing the stream to which we are trying to subscribe.
	 * @param replaceElementId
	 *            String ID of the existing DOM element that the Subscriber replaces. If you do not specify a
	 *            replaceElementId, the application appends a new DOM element to the HTML body.
	 * @param subscriberProperties
	 */
	public Subscriber subscribe(Stream stream, String replaceElementId, SubscriberProperties subscriberProperties) {
		return new Subscriber(this._subscribe(stream.obj, replaceElementId, subscriberProperties));
	}

	private native JavaScriptObject _subscribe(JavaScriptObject stream, String replaceElementId,
			SubscriberProperties subscriberProperties) /*-{
		return this.@com.google.gwt.tok.client.Session::obj.subscribe(stream,
				replaceElementId, subscriberProperties);
	}-*/;

	/**
	 * <p>
	 * Subscribes to a stream that is available to the session. You can get an array of available streams from the
	 * streams of the sessionConnect event object. The Session object dispatches this event in response to a successful
	 * call to the connect() method. As other publishers connect to the session, the Session object dispatches a
	 * streamCreated event. This event object has a streams property, which is an updated array of the Stream objects
	 * corresponding to streams connected to the session.
	 * </p>
	 * <p>
	 * Starts subscribing to the session's audio-video stream specified.
	 * </p>
	 * <p>
	 * The subscribed stream is displayed on the local web page by replacing the specified element in the DOM with a
	 * streaming video display. If the width and height of the display do not match the 4:3 aspect ratio of the video
	 * signal, the video stream is cropped to fit the display. If the stream lacks a video component, a blank screen
	 * with an audio indicator is displayed in place of the video stream.
	 * </p>
	 * <p>
	 * The application throws an error if the session is not connected or if the replaceElementId does not exist in the
	 * HTML DOM.
	 * </p>
	 * 
	 * @param stream
	 *            Stream object representing the stream to which we are trying to subscribe.
	 * @param subscriberProperties
	 */
	public Subscriber subscribe(Stream stream, SubscriberProperties subscriberProperties) {
		return new Subscriber(this._subscribe(stream.obj, subscriberProperties));
	}

	private native JavaScriptObject _subscribe(JavaScriptObject stream, SubscriberProperties subscriberProperties) /*-{
		return this.@com.google.gwt.tok.client.Session::obj.subscribe(stream,
				subscriberProperties);
	}-*/;

	/**
	 * Stops subscribing to a stream in the session. The display of the audio-video stream is removed from the local web
	 * page.
	 * 
	 * @param subscriber
	 *            The Subscriber object to unsubcribe.
	 */
	public void unsubscribe(Subscriber subscriber) {
		this._unsubscribe(subscriber.obj);
	}

	private native JavaScriptObject _unsubscribe(JavaScriptObject jso) /*-{
		return this.@com.google.gwt.tok.client.Session::obj.unsubscribe(jso);
	}-*/;

	/**
	 * Event management
	 */

	public native void initEventListeners() /*-{
		var session = this;
		this.@com.google.gwt.tok.client.Session::obj
				.addEventListener(
						"sessionConnected",
						function sessionConnectedHandler(event) {
							session.@com.google.gwt.tok.client.Session::onSessionConnected(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
						});

		this.@com.google.gwt.tok.client.Session::obj
				.addEventListener(
						"sessionDisconnected",
						function sessionDisconnectedHandler(event) {
							session.@com.google.gwt.tok.client.Session::onSessionDisconnected(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
						});

		this.@com.google.gwt.tok.client.Session::obj
				.addEventListener(
						"connectionCreated",
						function connectionCreatedHandler(event) {
							session.@com.google.gwt.tok.client.Session::onConnectionCreated(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
						});

		this.@com.google.gwt.tok.client.Session::obj
				.addEventListener(
						"connectionDestroyed",
						function connectionDestroyedHandler(event) {
							session.@com.google.gwt.tok.client.Session::onConnectionDestroyed(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
						});

		this.@com.google.gwt.tok.client.Session::obj
				.addEventListener(
						"streamCreated",
						function streamCreatedHandler(event) {
							session.@com.google.gwt.tok.client.Session::onStreamCreated(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
						});

		this.@com.google.gwt.tok.client.Session::obj
				.addEventListener(
						"streamDestroyed",
						function streamDestroyedHandler(event) {
							session.@com.google.gwt.tok.client.Session::onStreamDestroyed(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
						});

	}-*/;

	public HandlerRegistration addSessionHandler(SessionHandler handler) {
		return this.addHandler(SessionHandler.TYPE, handler);
	}

	/**
	 * Remove an {@link ExceptionHandler}
	 * 
	 * @param handler
	 */
	public void removeSessionHandler(SessionHandler handler) {
		this.removeHandler(SessionHandler.TYPE, handler);
	}

	private void onSessionConnected(JavaScriptObject jso) {
		this.fireEvent(new SessionConnectedEvent(jso));
	}

	private void onSessionDisconnected(JavaScriptObject jso) {
		this.fireEvent(new SessionDisconnectedEvent(jso));
	}

	private void onConnectionCreated(JavaScriptObject jso) {
		this.fireEvent(new ConnectionCreatedEvent(jso));
	}

	private void onConnectionDestroyed(JavaScriptObject jso) {
		this.fireEvent(new ConnectionDestroyedEvent(jso));
	}

	private void onStreamCreated(JavaScriptObject jso) {
		this.fireEvent(new StreamCreatedEvent(jso));
	}

	private void onStreamDestroyed(JavaScriptObject jso) {
		this.fireEvent(new StreamDestroyedEvent(jso));
	}
}
