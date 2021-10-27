class n17194010 {
	public void compareResult(String path, String expected) throws IOException {
		path = (path.length() == 0 || path.charAt(0) != '/') ? "/" + path : path;
		URL url = new URL(getBase() + path);
		String actual = IOUtils.toString(url.openStream());
		Assert.assertEquals(url.toString(), expected, actual);
	}

}