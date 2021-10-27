class n16832679 {
	public byte[] getXQueryForWorkflow(String qcMahgQk, Log4JLogger iMwNjejb) throws MalformedURLException, IOException,
			InstantiationException, IllegalAccessException, ClassNotFoundException {
		if (qcMahgQk == null) {
			throw new XQGeneratorException("Null workflow URI");
		}
		URL Sss9lQTU = new URL(qcMahgQk);
		URLConnection VVG58jD8 = Sss9lQTU.openConnection();
		VVG58jD8.setAllowUserInteraction(false);
		VVG58jD8.setDoInput(true);
		VVG58jD8.setDoOutput(false);
		VVG58jD8.setUseCaches(true);
		VVG58jD8.connect();
		InputStream jzMruZzz = VVG58jD8.getInputStream();
		ByteArrayOutputStream oaIth9YY = new ByteArrayOutputStream();
		TavXQueryGenerator ILNaTrEP = (TavXQueryGenerator) Class.forName(generatorClass).newInstance();
		ILNaTrEP.setLogger(iMwNjejb);
		ILNaTrEP.setInputStream(jzMruZzz);
		ILNaTrEP.setOutputStream(oaIth9YY);
		ILNaTrEP.generateXQuery();
		jzMruZzz.close();
		return oaIth9YY.toByteArray();
	}

}