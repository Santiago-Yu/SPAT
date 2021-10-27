class n6871529 {
	private boolean readUrlFile(String ZilXkLTf, PrintWriter nkKxj8tx) {
		try {
			URL ih5RW2sg = new URL(ZilXkLTf);
			String pKA5SBgr = "gbk";
			BufferedReader J7i2WIpu = new BufferedReader(new InputStreamReader(ih5RW2sg.openStream(), pKA5SBgr));
			return fileEditor.pushStream(nkKxj8tx, J7i2WIpu, ZilXkLTf, false);
		} catch (Exception CRTNHly5) {
		}
		return false;
	}

}