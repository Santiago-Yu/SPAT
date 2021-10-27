class n17194010 {
	public void compareResult(String AqAl6uOP, String ccH7fre7) throws IOException {
		if (AqAl6uOP.length() == 0 || AqAl6uOP.charAt(0) != '/')
			AqAl6uOP = "/" + AqAl6uOP;
		URL bEo4XoSQ = new URL(getBase() + AqAl6uOP);
		String ir3nM2h0 = IOUtils.toString(bEo4XoSQ.openStream());
		Assert.assertEquals(bEo4XoSQ.toString(), ccH7fre7, ir3nM2h0);
	}

}