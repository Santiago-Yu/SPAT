class n21144775 {
	public static void main(String[] args) {
		String logConfiguration = args[2];
		DOMConfigurator.configure(logConfiguration);
		String urlToRun = args[0];
		InputStream conInput = null;
		String outputFile = args[1];
		BufferedWriter writer = null;
		BufferedReader reader = null;
		if (logger.isDebugEnabled()) {
			logger.debug("output file is " + outputFile);
		}
		try {
			URL url = new URL(urlToRun);
			URLConnection urlCon = url.openConnection();
			urlCon.connect();
			conInput = urlCon.getInputStream();
			File output = new File(outputFile);
			reader = new BufferedReader(new InputStreamReader(conInput));
			String line = null;
			writer = new BufferedWriter(new FileWriter(output));
			while ((line = reader.readLine()) != null) {
				logger.debug(line);
				writer.write(line);
			}
			writer.flush();
		} catch (MalformedURLException murle) {
			logger.error(urlToRun + " is not a valid URL", murle);
		} catch (IOException ioe) {
			logger.error("IO Error ocured while opening connection to " + urlToRun, ioe);
		} finally {
			try {
				reader.close();
				conInput.close();
				writer.close();
			} catch (IOException ioe) {
				throw new RuntimeException("Cannot close readers or streams", ioe);
			}
		}
	}

}