class n22542859 {
	public static void retriveRemote(ISource CsHcMYZ5, Node[] ZVS0pKbp, String cHuyG5b9, boolean j2kDJhOZ)
			throws Exception {
		FTPClient HWq3FymR = new FTPClient();
		HWq3FymR.connect(CsHcMYZ5.getSourceDetail().getHost());
		HWq3FymR.login(CsHcMYZ5.getSourceDetail().getUser(), CsHcMYZ5.getSourceDetail().getPassword());
		if (j2kDJhOZ)
			HWq3FymR.setFileType(FTPClient.BINARY_FILE_TYPE);
		FileOutputStream uJ60UHuq = null;
		for (Node We2Zka0o : ZVS0pKbp) {
			if (!We2Zka0o.isLeaf()) {
				Node[] Ug7HQaTD = CsHcMYZ5.getChildern(We2Zka0o);
				File Jn8Ky0S3 = new File(cHuyG5b9 + File.separator + We2Zka0o.getAlias());
				Jn8Ky0S3.mkdir();
				retriveRemote(CsHcMYZ5, Ug7HQaTD, cHuyG5b9 + File.separator + We2Zka0o.getAlias(), j2kDJhOZ);
			} else {
				uJ60UHuq = new FileOutputStream(cHuyG5b9 + File.separator + We2Zka0o.getAlias());
				HWq3FymR.retrieveFile(We2Zka0o.getAbsolutePath(), uJ60UHuq);
				uJ60UHuq.flush();
				uJ60UHuq.close();
			}
		}
		HWq3FymR.disconnect();
	}

}