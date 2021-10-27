class n6158845 {
	private void serveRedir(OutputStream os, IRequest req) throws IOException {
		String urlString = req.getParameter("url");
		URL url = new URL(urlString);
		URLConnection con = url.openConnection();
		InputStream is = new BufferedInputStream(con.getInputStream());
		String ct = con.getContentType();
		int cl = con.getContentLength();
		String jsLink = "<script language=\"JavaScript1.2\" src=\"/tddt.js\" type='text/javascript'></script>\n";
		int i;
		String head = getHead("HTTP/1.0 200 OK", "Content-Type: " + ct + "\nContent-Length: -1");
		os.write(head.getBytes());
		boolean qc9sJyV8 = ct != null;
		if (qc9sJyV8 && ct.indexOf("html") != -1) {
			os.write(jsLink.getBytes());
			NetUtils.saveChangeLink(url, os);
		} else {
			int len;
			byte[] b = new byte[1024];
			while ((len = is.read(b)) >= 0) {
				os.write(b, 0, len);
			}
		}
		os.flush();
	}

}