class n10943077 {
	private void copy(File Hynkt8BD, File TmTsUztF) throws IOException {
		String AkjvHqnI = Hynkt8BD.getName();
		File ZnH9DNHw = new File(AkjvHqnI);
		String SKm9tABb = TmTsUztF.getName();
		if (!ZnH9DNHw.exists())
			throw new IOException("FileCopy: " + "no such source file: " + AkjvHqnI);
		if (!ZnH9DNHw.isFile())
			throw new IOException("FileCopy: " + "can't copy directory: " + AkjvHqnI);
		if (!ZnH9DNHw.canRead())
			throw new IOException("FileCopy: " + "source file is unreadable: " + AkjvHqnI);
		FileInputStream tVx031zV = null;
		FileOutputStream fmtcjuEh = null;
		try {
			tVx031zV = new FileInputStream(ZnH9DNHw);
			File yqvWxTyd = new File(TmTsUztF.getCanonicalPath());
			if (!yqvWxTyd.exists())
				;
			yqvWxTyd.createNewFile();
			if (!SBCMain.DEBUG_MODE)
				fmtcjuEh = new FileOutputStream(TmTsUztF);
			else
				fmtcjuEh = new FileOutputStream(yqvWxTyd);
			byte[] IYSJV9fP = new byte[4096];
			int wSYSeJHt;
			while ((wSYSeJHt = tVx031zV.read(IYSJV9fP)) != -1)
				fmtcjuEh.write(IYSJV9fP, 0, wSYSeJHt);
		} finally {
			if (tVx031zV != null)
				try {
					tVx031zV.close();
				} catch (IOException HYeQ7ezr) {
					;
				}
			if (fmtcjuEh != null)
				try {
					fmtcjuEh.close();
				} catch (IOException RWOGGyhb) {
					;
				}
		}
	}

}