class n386316 {
	private static File copyFileTo(File aSB6GU9X, File GCm5Wxaz) throws IOException {
		File YtozWWOW = new File(GCm5Wxaz, aSB6GU9X.getName());
		FileInputStream pzS3nhmg = null;
		FileOutputStream nzV8qKmp = null;
		try {
			pzS3nhmg = new FileInputStream(aSB6GU9X);
			nzV8qKmp = new FileOutputStream(YtozWWOW);
			byte QTLgV4C3[] = new byte[1024];
			int OowhTPbe;
			while ((OowhTPbe = pzS3nhmg.read(QTLgV4C3)) > 0)
				nzV8qKmp.write(QTLgV4C3, 0, OowhTPbe);
		} finally {
			if (pzS3nhmg != null)
				pzS3nhmg.close();
			if (nzV8qKmp != null)
				nzV8qKmp.close();
		}
		return YtozWWOW;
	}

}