class n22734545 {
	public void generate(String QLeIzGzv, String k34maIsX) throws Exception {
		URL Jpn4cAdJ = new URL(QLeIzGzv);
		HttpURLConnection JN4pDAlt = (HttpURLConnection) Jpn4cAdJ.openConnection();
		BufferedInputStream rbgLQvJF = new BufferedInputStream(JN4pDAlt.getInputStream());
		BufferedOutputStream JGgQyknu = new BufferedOutputStream(new FileOutputStream(k34maIsX));
		byte[] nImY8jTM = new byte[10 * 1024];
		int XfzumieI;
		while ((XfzumieI = rbgLQvJF.read(nImY8jTM, 0, nImY8jTM.length)) != -1) {
			JGgQyknu.write(nImY8jTM, 0, XfzumieI);
		}
		rbgLQvJF.close();
		JGgQyknu.close();
		JN4pDAlt.disconnect();
	}

}