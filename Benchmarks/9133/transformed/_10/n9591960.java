class n9591960 {
	protected Object serveFile(MyServerSocket socket, String filenm, URL url) {
		InputStream in = null;
		PrintStream out = null;
		long len = 0;
		try {
			out = new PrintStream(socket.getOutputStream());
			in = url.openStream();
			len = in.available();
		} catch (IOException e) {
			HttpHelper.httpWrap(HttpHelper.EXC, e.toString(), 0);
		}
		if (HttpHelper.isImage(filenm)) {
			out.print(HttpHelper.httpWrapPic(filenm, len));
		} else if (filenm.endsWith(".html")) {
			Comms.copyStreamSED(in, out, MPRES);
		} else if (HttpHelper.isOtherFile(filenm)) {
			out.print(HttpHelper.httpWrapOtherFile(filenm, len));
		} else {
			String type = MimeUtils.getMimeType(filenm);
			if (type.equals(MimeUtils.UNKNOWN_MIME_TYPE)) {
				out.print(HttpHelper.httpWrapMimeType(type, len));
			} else {
				out.print(HttpHelper.httpWrapMimeType(type, len));
			}
		}
		if (in == null) {
			Log.logThis("THE INPUT STREAM IS NULL...url=" + url);
		} else
			Files.copyStream(in, out);
		return null;
	}

}