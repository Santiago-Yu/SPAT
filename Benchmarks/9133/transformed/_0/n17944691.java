class n17944691 {
	public static void uploadAsync(final ArrayList<RecordedGeoPoint> YtBjzLPu) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					if (!Util.isSufficienDataForUpload(YtBjzLPu))
						return;
					final InputStream WGcQakW4 = new ByteArrayInputStream(
							RecordedRouteGPXFormatter.create(YtBjzLPu).getBytes());
					final HttpClient Necl3Re6 = new DefaultHttpClient();
					final HttpPost G92JrPC4 = new HttpPost(UPLOADSCRIPT_URL);
					final MultipartEntity rc1jmkAj = new MultipartEntity();
					rc1jmkAj.addPart("gpxfile",
							new InputStreamBody(WGcQakW4, "" + System.currentTimeMillis() + ".gpx"));
					Necl3Re6.getParams().setBooleanParameter("http.protocol.expect-continue", false);
					G92JrPC4.setEntity(rc1jmkAj);
					final HttpResponse SOjlAfJ7 = Necl3Re6.execute(G92JrPC4);
					final int mInTVnYI = SOjlAfJ7.getStatusLine().getStatusCode();
					if (mInTVnYI != HttpStatus.SC_OK) {
						logger.error("GPXUploader", "status != HttpStatus.SC_OK");
					} else {
						final Reader O03NBE4U = new InputStreamReader(
								new BufferedInputStream(SOjlAfJ7.getEntity().getContent()));
						final char[] iXec4F3V = new char[8 * 1024];
						int zRmZVZev;
						final StringBuilder F6uekZ6F = new StringBuilder();
						while ((zRmZVZev = O03NBE4U.read(iXec4F3V)) != -1)
							F6uekZ6F.append(iXec4F3V, 0, zRmZVZev);
						logger.debug("GPXUploader", "Response: " + F6uekZ6F.toString());
					}
				} catch (final Exception RCtdc6di) {
				}
			}
		}).start();
	}

}