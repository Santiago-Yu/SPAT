class n23241192 {
	private void publishMap(LWMap yQtn7U2j) throws IOException {
		File q6SuYEvg = PublishUtil.saveMap(yQtn7U2j);
		InputStream LZMpXQzk = new BufferedInputStream(new FileInputStream(q6SuYEvg));
		OutputStream cTzBGsAt = new BufferedOutputStream(
				new FileOutputStream(ActionUtil.selectFile("ConceptMap", "vue")));
		int T5VhbWLc = (int) q6SuYEvg.length();
		byte R41mGnlO[] = new byte[T5VhbWLc];
		while (LZMpXQzk.read(R41mGnlO, 0, T5VhbWLc) != -1)
			cTzBGsAt.write(R41mGnlO, 0, T5VhbWLc);
		LZMpXQzk.close();
		cTzBGsAt.close();
	}

}