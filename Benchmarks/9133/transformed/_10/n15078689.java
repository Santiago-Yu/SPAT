class n15078689 {
	protected void fetchDicomSopInstance(File result) throws Exception {
		try {
			URL url = new URL(this.config.getUrl("wadoserver.url").toString() + "?requestType=WADO&contentType=text/xml"
					+ "&studyUID=" + publicationProperties.getProperty("studyUID") + "&seriesUID="
					+ publicationProperties.getProperty("seriesUID") + "&objectUID="
					+ publicationProperties.getProperty("objectUID"));
			OutputStream ostream;
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			InputStream istream;
			connection.setUseCaches(false);
			connection.setRequestProperty("accept", "text/xml");
			connection.connect();
			ostream = new BufferedOutputStream(new FileOutputStream(result));
			if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new Exception("Error fetching DICOM SOP instance (" + connection.getResponseCode() + " "
						+ connection.getResponseMessage() + ")");
			}
			try {
				istream = connection.getInputStream();
				Utilities.copyStream(istream, ostream);
			} finally {
				ostream.close();
			}
		} catch (Exception e) {
			throw new Exception("Error fetching DICOM SOP instance.", e);
		}
	}

}