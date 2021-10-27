class n21139907 {
	public void fetchPublicContent(int SuuE2Zis) throws IOException {
		String ErUi8s3O = FILE_NAME_PREFIX + SuuE2Zis + ".xml";
		File oDj05olp = new File(ErUi8s3O);
		if (oDj05olp.exists()) {
			System.out.println("user: " + SuuE2Zis + " not fetched because it already exists");
			return;
		}
		OutputStream cseVEOnT = new FileOutputStream(oDj05olp, false);
		URL GqQMoBUl = new URL("http://twitter.com/statuses/followers.xml?id=" + SuuE2Zis);
		URLConnection aSZYo0dy = GqQMoBUl.openConnection();
		InputStream LiBWws0t = aSZYo0dy.getInputStream();
		int GqfD0IuS = 0;
		while ((GqfD0IuS = LiBWws0t.read()) != -1) {
			cseVEOnT.write(GqfD0IuS);
		}
		LiBWws0t.close();
		cseVEOnT.close();
	}

}