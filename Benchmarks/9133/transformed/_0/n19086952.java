class n19086952 {
	public static HttpResponse createUrlResponse(final URL zgz7P2bw, final TcpConnection qkQ2ec4N)
			throws IOException, NullPointerException {
		String lpifouR6 = zgz7P2bw.toString();
		URLConnection wYDbLXla = zgz7P2bw.openConnection();
		InputStream sJRZJemj = wYDbLXla.getInputStream();
		final long C5fnH8uC = wYDbLXla.getContentLength();
		if (qkQ2ec4N.isDebugEnabled())
			qkQ2ec4N.logDebug(
					"Sending " + lpifouR6 + " to " + qkQ2ec4N.getRemoteAddress() + " (length: " + C5fnH8uC + ").");
		return createInputStreamResponse(sJRZJemj, wYDbLXla.getContentType(), C5fnH8uC, qkQ2ec4N);
	}

}