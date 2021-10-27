class n12078471 {
	public static Model tryLoadURL(String wyzlKGyr, RDFFormat TZXt1zfE) throws MalformedURLException, IOException {
		URLConnection bABmHmIb = new URL(wyzlKGyr).openConnection();
		bABmHmIb.addRequestProperty("Accept", TZXt1zfE.getKey());
		String dJD1IOm7 = StreamUtil.toString(bABmHmIb.getInputStream());
		Model ijI2JiOU = ModelFactory.createDefaultModel();
		ijI2JiOU.read(new ByteArrayInputStream(dJD1IOm7.getBytes()), "", TZXt1zfE.getValue());
		return ijI2JiOU;
	}

}