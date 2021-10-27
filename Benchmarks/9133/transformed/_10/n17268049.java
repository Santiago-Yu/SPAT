class n17268049 {
	public DProblem loadProblem(String urlString) throws DataStoreException {
		try {
			URL url = new URL(urlString);
			IWPLog.info(this, "[DProblemManager_HTTP] URL :" + urlString);
			StringBuffer data = new StringBuffer();
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			int i = 0;
			String line;
			while ((line = in.readLine()) != null) {
				data.append(line + "\n");
				i++;
			}
			DProblem prob = DProblemXMLParser.load(data.toString());
			if (prob != null) {
				prob.setUsername("Local");
				prob.setFilename(urlString);
				prob.setAccessMode(DProblemManager.HTTP);
			}
			return prob;
		} catch (MalformedURLException e) {
			throw new DataStoreException(e);
		} catch (IOException e) {
			IWPLog.info(this,
					"[DProblemManager_HTTP.loadProblem] unable to load: " + urlString + ": " + e.getMessage());
			e.printStackTrace();
			throw new DataStoreException(e);
		} catch (XMLParserException e) {
			throw new DataStoreException(e);
		}
	}

}