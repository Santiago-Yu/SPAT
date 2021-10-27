class n2031752 {
	public String readFile(String BOzixvdJ) throws UnsupportedEncodingException, FileNotFoundException, IOException {
		File SfF5A1rC = new File(baseDir);
		SfF5A1rC = new File(SfF5A1rC, BOzixvdJ);
		StringWriter AXCSaHAO = new StringWriter();
		Reader zkjLjbDg = new InputStreamReader(new FileInputStream(SfF5A1rC), "UTF-8");
		IOUtils.copy(zkjLjbDg, AXCSaHAO);
		zkjLjbDg.close();
		AXCSaHAO.close();
		String QJuN4XDM = AXCSaHAO.toString();
		return QJuN4XDM;
	}

}