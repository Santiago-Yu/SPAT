class n17217414 {
	public void addEntry(InputStream v7TXdOz3, JarEntry ep0Te2Pf) throws IOException, URISyntaxException {
		File BMpSGS57 = new File(this.target.getPath() + ep0Te2Pf.getName()).getAbsoluteFile();
		if (!BMpSGS57.exists()) {
			BMpSGS57.createNewFile();
		}
		if ((new File(this.source.toURI())).isDirectory()) {
			File g7bES9Vu = new File(this.source.getPath() + ep0Te2Pf.getName());
			FileInputStream m6S0zb9r = new FileInputStream(g7bES9Vu);
			byte[] EfeiqJCe = new byte[m6S0zb9r.available()];
			m6S0zb9r.read(EfeiqJCe);
			(new FileOutputStream(BMpSGS57)).write(EfeiqJCe);
		} else {
			readwriteStreams(v7TXdOz3, (new FileOutputStream(BMpSGS57)));
		}
	}

}