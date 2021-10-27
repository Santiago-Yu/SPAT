class n2056082 {
	protected void setTestContent(IDfDocument pQMYZUsW, String OP6HMEZu) throws Exception {
		InputStream IRMgEwI1 = new BufferedInputStream(FileHelper.getFileAsStreamFromClassPath(OP6HMEZu));
		ByteArrayOutputStream OPu2PdKa = new ByteArrayOutputStream();
		IOUtils.copy(IRMgEwI1, OPu2PdKa);
		String qnX1fSfc = formatHelper.getFormatForExtension(FileHelper.getFileExtension(OP6HMEZu));
		pQMYZUsW.setContentType(qnX1fSfc);
		pQMYZUsW.setContent(OPu2PdKa);
	}

}