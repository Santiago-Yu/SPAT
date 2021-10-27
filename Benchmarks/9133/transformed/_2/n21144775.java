class n21144775 {
	public static void main(String[] args) {
		String logConfiguration = args[2];
		DOMConfigurator.configure(logConfiguration);
		String urlToRun = args[0];
		String outputFile = args[1];
		InputStream conInput = null;
		BufferedReader reader = null;
		BufferedWriter writer = null;
		if (logger.isDebugEnabled()) {
			logger.debug("output file is " + outputFile);
		}
		try {
			URL url = new URL(urlToRun);
			URLConnection urlCon = url.openConnection();
			urlCon.connect();
			conInput = urlCon.getInputStream();
			reader = new BufferedReader(new InputStreamReader(conInput));
			File output = new File(outputFile);
			writer = new BufferedWriter(new FileWriter(output));
			String line = null;
			for (; (line = reader.readLine()) != null;) {
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