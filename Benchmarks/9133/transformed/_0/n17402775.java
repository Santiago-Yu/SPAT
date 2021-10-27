class n17402775 {
	public String getResourceAsString(String Tk6CNNHj) throws IOException {
		String vNZrEi0C = null;
		InputStream Sq6afAYt = aClass.getResourceAsStream(Tk6CNNHj);
		if (Sq6afAYt != null) {
			ByteArrayOutputStream DBTXb72d = new ByteArrayOutputStream();
			IOUtils.copyAndClose(Sq6afAYt, DBTXb72d);
			vNZrEi0C = DBTXb72d.toString();
		} else {
			Assert.fail("Resource not available: " + Tk6CNNHj);
		}
		return vNZrEi0C;
	}

}