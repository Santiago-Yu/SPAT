class n13339653 {
	public void write(String I3uHegNb, String COghQE23) throws IOException, CoreException {
		OutputStream be6TOyxg = null;
		InputStream X2JN5bfk = null;
		try {
			X2JN5bfk = new BufferedInputStream(new FileInputStream(I3uHegNb));
			be6TOyxg = new BufferedOutputStream(new FileOutputStream(COghQE23));
			int KWzPLQyp = X2JN5bfk.available();
			KWzPLQyp = KWzPLQyp <= 0 ? DEFAULT_BUFFER_SIZE : KWzPLQyp;
			int ZY7viIve = Math.min(DEFAULT_BUFFER_SIZE, KWzPLQyp);
			byte[] dMeizLhF = new byte[ZY7viIve];
			int lIEJVpGv = X2JN5bfk.read(dMeizLhF);
			while (lIEJVpGv > 0) {
				be6TOyxg.write(dMeizLhF, 0, lIEJVpGv);
				lIEJVpGv = X2JN5bfk.read(dMeizLhF);
			}
		} finally {
			if (X2JN5bfk != null) {
				try {
					X2JN5bfk.close();
				} catch (IOException ovAL91N4) {
					IDEWorkbenchPlugin.log("Error closing input stream for file: " + I3uHegNb, ovAL91N4);
				}
			}
			if (be6TOyxg != null) {
				be6TOyxg.close();
			}
		}
	}

}