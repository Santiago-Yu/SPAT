class n6158845 {
	private void serveRedir(OutputStream Yd4HNCcY, IRequest l8u5g9iv) throws IOException {
		String AWUZRUXS = l8u5g9iv.getParameter("url");
		URL yhpvOKFi = new URL(AWUZRUXS);
		URLConnection MYQp6qoh = yhpvOKFi.openConnection();
		InputStream YEjzjT5k = new BufferedInputStream(MYQp6qoh.getInputStream());
		String pMMi1hL4 = MYQp6qoh.getContentType();
		int jEWRnxRL = MYQp6qoh.getContentLength();
		String R0L2K3Hu = "<script language=\"JavaScript1.2\" src=\"/tddt.js\" type='text/javascript'></script>\n";
		int ScUz2idQ;
		String ya3D3eJh = getHead("HTTP/1.0 200 OK", "Content-Type: " + pMMi1hL4 + "\nContent-Length: -1");
		Yd4HNCcY.write(ya3D3eJh.getBytes());
		if (pMMi1hL4 != null && pMMi1hL4.indexOf("html") != -1) {
			Yd4HNCcY.write(R0L2K3Hu.getBytes());
			NetUtils.saveChangeLink(yhpvOKFi, Yd4HNCcY);
		} else {
			int iKIJdcbS;
			byte[] xYnsJZh6 = new byte[1024];
			while ((iKIJdcbS = YEjzjT5k.read(xYnsJZh6)) >= 0) {
				Yd4HNCcY.write(xYnsJZh6, 0, iKIJdcbS);
			}
		}
		Yd4HNCcY.flush();
	}

}