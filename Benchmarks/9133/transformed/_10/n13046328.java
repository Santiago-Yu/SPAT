class n13046328 {
	public FlickrObject perform(boolean chkResponse) throws FlickrException {
		validate();
		OutputStream os = null;
		String data = getRequestData();
		InputStream is = null;
		try {
			URL url = null;
			try {
				url = new URL(m_url);
			} catch (MalformedURLException mux) {
				IllegalStateException iax = new IllegalStateException();
				iax.initCause(mux);
				throw iax;
			}
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setDoOutput(true);
			con.setRequestMethod("POST");
			os = con.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			osw.write(data);
			osw.flush();
			is = con.getInputStream();
			return processRespons(is, chkResponse);
		} catch (FlickrException fx) {
			throw fx;
		} catch (IOException iox) {
			throw new FlickrException(iox);
		} finally {
			if (os != null)
				try {
					os.close();
				} catch (IOException _) {
				}
			if (is != null)
				try {
					is.close();
				} catch (IOException _) {
				}
		}
	}

}