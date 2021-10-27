class n22093912 {
	private byte[] getResponseFromHttp(byte[] Kmk5iCTf, URL q90kf13i) throws IOException {
		HttpURLConnection sJ9H1D3d = (HttpURLConnection) q90kf13i.openConnection();
		sJ9H1D3d.setDoOutput(true);
		try {
			sJ9H1D3d.setRequestMethod(OCSPLoginModule.POST);
		} catch (ProtocolException k6BVukcF) {
			throw new IOException(k6BVukcF.getMessage(), k6BVukcF);
		}
		sJ9H1D3d.setRequestProperty(OCSPLoginModule.CONTENT_TYPE, OCSPLoginModule.APPLICATION_OCSP_REQUEST);
		OutputStream CW1oIw5h = null;
		try {
			CW1oIw5h = sJ9H1D3d.getOutputStream();
			CW1oIw5h.write(Kmk5iCTf);
		} catch (IOException DlziYeJE) {
			logger.error(DlziYeJE.getMessage());
			throw DlziYeJE;
		} finally {
			CW1oIw5h.close();
		}
		InputStream YYdGmtYb = null;
		byte[] xfpWI51C = null;
		ByteArrayOutputStream T3qn6gy9 = null;
		try {
			T3qn6gy9 = new ByteArrayOutputStream();
			YYdGmtYb = sJ9H1D3d.getInputStream();
			int iiuDRf2J = YYdGmtYb.read();
			while (iiuDRf2J != -1) {
				T3qn6gy9.write(iiuDRf2J);
				iiuDRf2J = YYdGmtYb.read();
			}
			T3qn6gy9.flush();
		} finally {
			YYdGmtYb.close();
			sJ9H1D3d.disconnect();
		}
		xfpWI51C = T3qn6gy9.toByteArray();
		return xfpWI51C;
	}

}