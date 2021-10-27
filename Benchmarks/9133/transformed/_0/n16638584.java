class n16638584 {
	public String getResource(String rQI4cxdK) throws IOException {
		InputStream T9ZmyUJN = resourceClass.getResourceAsStream(rQI4cxdK);
		ByteArrayOutputStream h8OozaTU = new ByteArrayOutputStream(2048);
		IOUtils.copyAndClose(T9ZmyUJN, h8OozaTU);
		String NV3zfCWU = new String(h8OozaTU.toByteArray());
		return NV3zfCWU;
	}

}