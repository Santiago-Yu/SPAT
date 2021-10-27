class n11358360 {
	private boolean readRemoteFile() {
		Concept concept = new Concept();
		InputStream inputstream;
		try {
			inputstream = url.openStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputstream);
			String s4;
			BufferedReader bufferedreader = new BufferedReader(inputStreamReader);
			while ((s4 = bufferedreader.readLine()) != null && s4.length() > 0) {
				if (!parseLine(s4, concept)) {
					return false;
				}
			}
		} catch (MalformedURLException e) {
			logger.fatal("malformed URL, trying to read local file");
			return readLocalFile();
		} catch (IOException e1) {
			logger.fatal("Error reading URL file, trying to read local file");
			return readLocalFile();
		} catch (Exception x) {
			logger.fatal("Failed to readRemoteFile " + x.getMessage() + ", trying to read local file");
			return readLocalFile();
		}
		return true;
	}

}