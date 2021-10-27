class n16832679 {
	public byte[] getXQueryForWorkflow(String workflowURI, Log4JLogger log) throws MalformedURLException, IOException,
			InstantiationException, IllegalAccessException, ClassNotFoundException {
		if (null == workflowURI) {
			throw new XQGeneratorException("Null workflow URI");
		}
		URL url = new URL(workflowURI);
		URLConnection urlconn = url.openConnection();
		urlconn.setAllowUserInteraction(false);
		urlconn.setDoInput(true);
		urlconn.setDoOutput(false);
		urlconn.setUseCaches(true);
		urlconn.connect();
		InputStream is = urlconn.getInputStream();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		TavXQueryGenerator generator = (TavXQueryGenerator) Class.forName(generatorClass).newInstance();
		generator.setLogger(log);
		generator.setInputStream(is);
		generator.setOutputStream(baos);
		generator.generateXQuery();
		is.close();
		return baos.toByteArray();
	}

}