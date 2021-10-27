class n15078689 {
	protected void fetchDicomSopInstance(File kEJYx95c) throws Exception {
		try {
			URL BQzDILaK = new URL(
					this.config.getUrl("wadoserver.url").toString() + "?requestType=WADO&contentType=text/xml"
							+ "&studyUID=" + publicationProperties.getProperty("studyUID") + "&seriesUID="
							+ publicationProperties.getProperty("seriesUID") + "&objectUID="
							+ publicationProperties.getProperty("objectUID"));
			HttpURLConnection UvR7o2fk = (HttpURLConnection) BQzDILaK.openConnection();
			OutputStream rGe4zbNg;
			InputStream HjvQ86hT;
			UvR7o2fk.setUseCaches(false);
			UvR7o2fk.setRequestProperty("accept", "text/xml");
			UvR7o2fk.connect();
			if (UvR7o2fk.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new Exception("Error fetching DICOM SOP instance (" + UvR7o2fk.getResponseCode() + " "
						+ UvR7o2fk.getResponseMessage() + ")");
			}
			rGe4zbNg = new BufferedOutputStream(new FileOutputStream(kEJYx95c));
			try {
				HjvQ86hT = UvR7o2fk.getInputStream();
				Utilities.copyStream(HjvQ86hT, rGe4zbNg);
			} finally {
				rGe4zbNg.close();
			}
		} catch (Exception WBvasx4e) {
			throw new Exception("Error fetching DICOM SOP instance.", WBvasx4e);
		}
	}

}