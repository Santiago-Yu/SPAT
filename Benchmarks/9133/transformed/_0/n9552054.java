class n9552054 {
	public static void copy(String QQtxSps9, String gA4wg76w) throws IOException {
		File GFftL0nD = new File(QQtxSps9);
		File Mu3sHMhu = new File(gA4wg76w);
		if (!GFftL0nD.exists())
			throw new IOException("FileCopy: " + "no such source file: " + QQtxSps9);
		if (!GFftL0nD.isFile())
			throw new IOException("FileCopy: " + "can't copy directory: " + QQtxSps9);
		if (!GFftL0nD.canRead())
			throw new IOException("FileCopy: " + "source file is unreadable: " + QQtxSps9);
		if (Mu3sHMhu.isDirectory())
			Mu3sHMhu = new File(Mu3sHMhu, GFftL0nD.getName());
		if (Mu3sHMhu.exists()) {
			if (!Mu3sHMhu.canWrite())
				throw new IOException("FileCopy: " + "destination file is unwriteable: " + gA4wg76w);
		} else {
			String IPZc0YLB = Mu3sHMhu.getParent();
			if (IPZc0YLB == null)
				IPZc0YLB = System.getProperty("user.dir");
			File A7TafWGt = new File(IPZc0YLB);
			if (!A7TafWGt.exists())
				A7TafWGt.mkdir();
			if (A7TafWGt.isFile())
				throw new IOException("FileCopy: " + "destination is not a directory: " + IPZc0YLB);
			if (!A7TafWGt.canWrite())
				throw new IOException("FileCopy: " + "destination directory is unwriteable: " + IPZc0YLB);
		}
		FileInputStream WWccW4nE = null;
		FileOutputStream RTQ6P6IC = null;
		try {
			WWccW4nE = new FileInputStream(GFftL0nD);
			RTQ6P6IC = new FileOutputStream(Mu3sHMhu);
			byte[] EqJDPYYg = new byte[4096];
			int UKhBZhbt;
			while ((UKhBZhbt = WWccW4nE.read(EqJDPYYg)) != -1)
				RTQ6P6IC.write(EqJDPYYg, 0, UKhBZhbt);
		} finally {
			if (WWccW4nE != null)
				try {
					WWccW4nE.close();
				} catch (IOException wNthhmgC) {
					;
				}
			if (RTQ6P6IC != null)
				try {
					RTQ6P6IC.close();
				} catch (IOException qtYSCNzG) {
					;
				}
		}
	}

}