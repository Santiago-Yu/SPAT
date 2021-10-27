class n6158845 {
	private void serveRedir(OutputStream os, IRequest req) throws IOException {
		String urlString = req.getParameter("url");
		URL url = new URL(urlString);
		URLConnection con = url.openConnection();
		InputStream is = new BufferedInputStream(con.getInputStream());
		String ct = con.getContentType();
		String jsLink = "<script language=\"JavaScript1.2\" src=\"/tddt.js\" type='text/javascript'></script>\n";
		int cl = con.getContentLength();
		String head = getHead("HTTP/1.0 200 OK", "Content-Type: " + ct + "\nContent-Length: -1");
		int i;
		os.write(head.getBytes());
		if (ct != null && ct.indexOf("html") != -1) {
			os.write(jsLink.getBytes());
			NetUtils.saveChangeLink(url, os);
		} else {
			byte[] b = new byte[1024];
			int len;
			while ((len = is.read(b)) >= 0) {
				os.write(b, 0, len);
			}
		}
		os.flush();
	}

}