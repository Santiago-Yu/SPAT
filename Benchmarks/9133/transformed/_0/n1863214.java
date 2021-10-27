class n1863214 {
	public static final void copyFile(File Wv4gAY5e, File SipMbsWZ) {
		try {
			FileChannel qLep70y0 = new FileInputStream(Wv4gAY5e).getChannel();
			FileChannel WfKLpgaw = new FileOutputStream(SipMbsWZ).getChannel();
			WfKLpgaw.transferFrom(qLep70y0, 0, qLep70y0.size());
			qLep70y0.close();
			WfKLpgaw.close();
		} catch (java.io.IOException NJPDs90t) {
		}
	}

}