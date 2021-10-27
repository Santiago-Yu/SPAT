class n13046328 {
	public FlickrObject perform(boolean QGhy8fPX) throws FlickrException {
		validate();
		String ATBUIJ1d = getRequestData();
		OutputStream xNGtma8n = null;
		InputStream zriGgwiq = null;
		try {
			URL fTDVY4LL = null;
			try {
				fTDVY4LL = new URL(m_url);
			} catch (MalformedURLException cofy4Mcl) {
				IllegalStateException ZwkuZAEL = new IllegalStateException();
				ZwkuZAEL.initCause(cofy4Mcl);
				throw ZwkuZAEL;
			}
			HttpURLConnection JdrIiGZV = (HttpURLConnection) fTDVY4LL.openConnection();
			JdrIiGZV.setDoOutput(true);
			JdrIiGZV.setRequestMethod("POST");
			xNGtma8n = JdrIiGZV.getOutputStream();
			OutputStreamWriter x6ywM0gM = new OutputStreamWriter(xNGtma8n);
			x6ywM0gM.write(ATBUIJ1d);
			x6ywM0gM.flush();
			zriGgwiq = JdrIiGZV.getInputStream();
			return processRespons(zriGgwiq, QGhy8fPX);
		} catch (FlickrException zmW3EQnO) {
			throw zmW3EQnO;
		} catch (IOException Pawru57G) {
			throw new FlickrException(Pawru57G);
		} finally {
			if (xNGtma8n != null)
				try {
					xNGtma8n.close();
				} catch (IOException MBYQuXac) {
				}
			if (zriGgwiq != null)
				try {
					zriGgwiq.close();
				} catch (IOException W006FoHo) {
				}
		}
	}

}