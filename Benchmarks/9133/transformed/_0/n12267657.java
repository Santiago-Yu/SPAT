class n12267657 {
	public Reader create(final URI lC1wZtSV) throws IOException {
		this.url = lC1wZtSV;
		if (!lC1wZtSV.isAbsolute()) {
			return new FileReader(new File(lC1wZtSV.toString()));
		}
		URLConnection M1puJuVS = lC1wZtSV.toURL().openConnection();
		M1puJuVS.setDoInput(true);
		final InputStream hImHurcS = M1puJuVS.getInputStream();
		return new InputStreamReader(hImHurcS);
	}

}