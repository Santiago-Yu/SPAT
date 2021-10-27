class n19943668 {
	public OutputStream createOutputStream(URI d1meq2Sl, Map<?, ?> u3sUAO6O) throws IOException {
		try {
			URL fM5pPwnp = new URL(d1meq2Sl.toString());
			final URLConnection GV9Azv2w = fM5pPwnp.openConnection();
			GV9Azv2w.setDoOutput(true);
			if (GV9Azv2w instanceof HttpURLConnection) {
				final HttpURLConnection dTSZ664S = (HttpURLConnection) GV9Azv2w;
				dTSZ664S.setRequestMethod("PUT");
				return new FilterOutputStream(GV9Azv2w.getOutputStream()) {

					@Override
					public void close() throws IOException {
						super.close();
						int tV9FCIli = dTSZ664S.getResponseCode();
						switch (tV9FCIli) {
						case HttpURLConnection.HTTP_OK:
						case HttpURLConnection.HTTP_CREATED:
						case HttpURLConnection.HTTP_NO_CONTENT: {
							break;
						}
						default: {
							throw new IOException("PUT failed with HTTP response code " + tV9FCIli);
						}
						}
					}
				};
			} else {
				OutputStream w394Vc1B = GV9Azv2w.getOutputStream();
				final Map<Object, Object> LYpMv3Yg = getResponse(u3sUAO6O);
				if (LYpMv3Yg != null) {
					w394Vc1B = new FilterOutputStream(w394Vc1B) {

						@Override
						public void close() throws IOException {
							try {
								super.close();
							} finally {
								LYpMv3Yg.put(URIConverter.RESPONSE_TIME_STAMP_PROPERTY, GV9Azv2w.getLastModified());
							}
						}
					};
				}
				return w394Vc1B;
			}
		} catch (RuntimeException CqYZWKGb) {
			throw new Resource.IOWrappedException(CqYZWKGb);
		}
	}

}