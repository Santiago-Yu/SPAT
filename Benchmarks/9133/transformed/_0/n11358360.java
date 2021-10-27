class n11358360 {
	private boolean readRemoteFile() {
		InputStream t1HRyB2R;
		Concept qze11t9d = new Concept();
		try {
			t1HRyB2R = url.openStream();
			InputStreamReader qGvjwNvd = new InputStreamReader(t1HRyB2R);
			BufferedReader CiArytWq = new BufferedReader(qGvjwNvd);
			String zOpsYpah;
			while ((zOpsYpah = CiArytWq.readLine()) != null && zOpsYpah.length() > 0) {
				if (!parseLine(zOpsYpah, qze11t9d)) {
					return false;
				}
			}
		} catch (MalformedURLException eaBuHbi4) {
			logger.fatal("malformed URL, trying to read local file");
			return readLocalFile();
		} catch (IOException xgJB0Aks) {
			logger.fatal("Error reading URL file, trying to read local file");
			return readLocalFile();
		} catch (Exception xpYASFCM) {
			logger.fatal("Failed to readRemoteFile " + xpYASFCM.getMessage() + ", trying to read local file");
			return readLocalFile();
		}
		return true;
	}

}