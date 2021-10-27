class n17944692 {
	@Override
	public void run() {
		try {
			if (!Util.isSufficienDataForUpload(recordedGeoPoints))
				return;
			final InputStream Z26zO2pZ = new ByteArrayInputStream(
					RecordedRouteGPXFormatter.create(recordedGeoPoints).getBytes());
			final HttpClient WW7ZbDPM = new DefaultHttpClient();
			final HttpPost dC2ygpmn = new HttpPost(UPLOADSCRIPT_URL);
			final MultipartEntity UGdNXxjw = new MultipartEntity();
			UGdNXxjw.addPart("gpxfile", new InputStreamBody(Z26zO2pZ, "" + System.currentTimeMillis() + ".gpx"));
			WW7ZbDPM.getParams().setBooleanParameter("http.protocol.expect-continue", false);
			dC2ygpmn.setEntity(UGdNXxjw);
			final HttpResponse gdVjvtlJ = WW7ZbDPM.execute(dC2ygpmn);
			final int aKmfClpX = gdVjvtlJ.getStatusLine().getStatusCode();
			if (aKmfClpX != HttpStatus.SC_OK) {
				logger.error("GPXUploader", "status != HttpStatus.SC_OK");
			} else {
				final Reader PRGcpzuz = new InputStreamReader(
						new BufferedInputStream(gdVjvtlJ.getEntity().getContent()));
				final char[] Z4SMh8AK = new char[8 * 1024];
				int WF2rTmJl;
				final StringBuilder wRgkdjVJ = new StringBuilder();
				while ((WF2rTmJl = PRGcpzuz.read(Z4SMh8AK)) != -1)
					wRgkdjVJ.append(Z4SMh8AK, 0, WF2rTmJl);
				logger.debug("GPXUploader", "Response: " + wRgkdjVJ.toString());
			}
		} catch (final Exception YkdyLQe3) {
		}
	}

}