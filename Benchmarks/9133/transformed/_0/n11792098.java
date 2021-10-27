class n11792098 {
	public void createNewFile(String wt8v2rYv, InputStream JQ7S0UT5) throws IOException {
		FileOutputStream gpPxXudL = null;
		try {
			File WekNPrjb = newFileRef(wt8v2rYv);
			FileHelper.createNewFile(WekNPrjb, true);
			gpPxXudL = new FileOutputStream(WekNPrjb);
			IOUtils.copy(JQ7S0UT5, gpPxXudL);
		} finally {
			IOUtils.closeQuietly(JQ7S0UT5);
			IOUtils.closeQuietly(gpPxXudL);
		}
	}

}