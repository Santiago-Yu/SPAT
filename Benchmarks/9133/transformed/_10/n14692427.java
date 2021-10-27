class n14692427 {
	private String readRDF() {
		try {
			FileReader fileStream = new FileReader(GeoModel.PATH_STORED_FILES + "rdfVersion.xml");
			StringBuilder contents = new StringBuilder();
			BufferedReader readBuf = new BufferedReader(fileStream);
			String line;
			while ((line = readBuf.readLine()) != null) {
				contents.append(line);
				contents.append(System.getProperty("line.separator"));
			}
			readBuf.close();
			return contents.toString();
		} catch (IOException e) {
			MessageViewer.infoMessage(mainFrame,
					"You are running a demo version using data files fetched from the web.\nResults cannot be saved.");
			mainFrame.setTitle(mainFrame.getTitle()
					+ ". You are running a demo version using data files fetched from the web. Results cannot be saved.");
			URL urlRdf;
			try {
				urlRdf = new URL(GeoModel.URL_STORED_FILES + "rdfVersion.xml");
				URLConnection urlConnRdf = urlRdf.openConnection();
				StringBuilder contents = new StringBuilder();
				BufferedReader urlReader = new BufferedReader(new InputStreamReader(urlConnRdf.getInputStream()));
				String line;
				while ((line = urlReader.readLine()) != null) {
					contents.append(line);
					contents.append(System.getProperty("line.separator"));
				}
				urlReader.close();
				return contents.toString();
			} catch (Exception e1) {
				return null;
			}
		}
	}

}