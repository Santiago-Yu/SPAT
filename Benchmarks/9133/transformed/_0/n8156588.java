class n8156588 {
	private static final BufferedInputStream createInputStreamFromRemoteUrl(String lT8zUbrm,
			ClientConnectionManager eaFZZF6t) {
		InputStream PPnizOGs = null;
		if (eaFZZF6t == null) {
			try {
				URL T7pWrdo0 = new URI(lT8zUbrm).toURL();
				URLConnection TnI8NCCL = T7pWrdo0.openConnection();
				TnI8NCCL.connect();
				PPnizOGs = TnI8NCCL.getInputStream();
			} catch (Exception noBqOZaG) {
				Log.w(TAG, "Request failed: " + lT8zUbrm);
				noBqOZaG.printStackTrace();
				return null;
			}
		} else {
			final DefaultHttpClient Y3MFBToO = new DefaultHttpClient(eaFZZF6t, HTTP_PARAMS);
			HttpUriRequest lAiB2g0o = new HttpGet(lT8zUbrm);
			HttpResponse hHlao8rs = null;
			try {
				hHlao8rs = Y3MFBToO.execute(lAiB2g0o);
				HttpEntity T3uFWPyD = hHlao8rs.getEntity();
				if (T3uFWPyD != null) {
					PPnizOGs = T3uFWPyD.getContent();
				}
			} catch (Exception VPdpjlCy) {
				Log.w(TAG, "Request failed: " + lAiB2g0o.getURI());
				return null;
			}
		}
		if (PPnizOGs != null) {
			return new BufferedInputStream(PPnizOGs, 4096);
		} else {
			return null;
		}
	}

}