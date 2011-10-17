package com.google.gwt.tok.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * The Archive class defines an object that represents an OpenTok archive.
 * 
 * Note: The OpenTok archiving API is in a beta program. If you find any bugs,
 * have any feedback or any feature requests, please let us know in the OpenTok
 * Archiving forum.
 * 
 * You get a reference to an Archive object from an ArchiveEvent object or from
 * a SessionEvent object. These objects include an archives property, which is
 * an array of Archive objects.
 * 
 * @author pmerienne
 * 
 */
public class Archive {

	private JavaScriptObject obj;

	public Archive(JavaScriptObject obj) {
		this.obj = obj;
	}

	/**
	 * Starts playing back the archive.
	 */
	public native void startPlayback() /*-{
		this.@com.google.gwt.tok.client.Archive::obj.startPlayback();
	}-*/;

	/**
	 * Stops playing back the archive.
	 */
	public native void stopPlayback() /*-{
		this.@com.google.gwt.tok.client.Archive::obj.stopPlayback();
	}-*/;

	/**
	 * 
	 * @return The unique ID for the group.
	 */
	public native String getGroupId() /*-{
		return this.@com.google.gwt.tok.client.Archive::obj.groupId;
	}-*/;

	/**
	 * 
	 * @return A unique identifier for the archive. Note that you should store a
	 *         record of the archive IDs of archives you create, so that you can
	 *         reference them later when loading the archive for playback.
	 */
	public native String getArchiveId() /*-{
		return this.@com.google.gwt.tok.client.Archive::obj.archiveId;
	}-*/;

	/**
	 * 
	 * @return The title assigned to the archive when it was created (when the
	 *         createArchive() method of a Session object was called).
	 */
	public native String getTitle() /*-{
		return this.@com.google.gwt.tok.client.Archive::obj.title;
	}-*/;

	/**
	 * Defines an archive that records all streams in a session.
	 */
	public final static String PER_SESSSION = "perSession";

	/**
	 * Defines an archive that can be used to record selected streams in a
	 * session.
	 */
	public final static String PER_STREAM = "perStream";

	/**
	 * Defines an archive that is recorded using the Recorder class. (This is an
	 * archive of a single video, recorded independently from an OpenTok
	 * session.)
	 */
	public final static String INDIVIDUAL = "individual";

	/**
	 * 
	 * @return A string identifying the type of archive. This can be one of the
	 *         following values: {@link Archive#PER_SESSSION},
	 *         {@link Archive#PER_STREAM}, {@link Archive#INDIVIDUAL}
	 * 
	 */
	public native String getType() /*-{
		return this.@com.google.gwt.tok.client.Archive::obj.type;
	}-*/;
}
