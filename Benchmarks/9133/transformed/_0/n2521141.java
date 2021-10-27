class n2521141 {
	public static void copy(String vqgssiDd, String f1AJWdsX) throws IOException {
		File Q1qnJ1tG = new File(vqgssiDd);
		File pWJtdVgB = new File(f1AJWdsX);
		if (!Q1qnJ1tG.exists())
			abort("FileCopy: no such source file: " + vqgssiDd);
		if (!Q1qnJ1tG.isFile())
			abort("FileCopy: can't copy directory: " + vqgssiDd);
		if (!Q1qnJ1tG.canRead())
			abort("FileCopy: source file is unreadable: " + vqgssiDd);
		if (pWJtdVgB.isDirectory())
			pWJtdVgB = new File(pWJtdVgB, Q1qnJ1tG.getName());
		if (pWJtdVgB.exists()) {
			if (!pWJtdVgB.canWrite())
				abort("FileCopy: destination file is unwriteable: " + f1AJWdsX);
		} else {
			String J8QG5Y8E = pWJtdVgB.getParent();
			if (J8QG5Y8E == null)
				J8QG5Y8E = System.getProperty("user.dir");
			File v8uj0ulD = new File(J8QG5Y8E);
			if (!v8uj0ulD.exists())
				abort("FileCopy: destination directory doesn't exist: " + J8QG5Y8E);
			if (v8uj0ulD.isFile())
				abort("FileCopy: destination is not a directory: " + J8QG5Y8E);
			if (!v8uj0ulD.canWrite())
				abort("FileCopy: destination directory is unwriteable: " + J8QG5Y8E);
		}
		FileInputStream ikCepbuq = null;
		FileOutputStream hvGOzUQV = null;
		try {
			ikCepbuq = new FileInputStream(Q1qnJ1tG);
			hvGOzUQV = new FileOutputStream(pWJtdVgB);
			byte[] dTp8uhnd = new byte[4096];
			int stRfJPZ2;
			while ((stRfJPZ2 = ikCepbuq.read(dTp8uhnd)) != -1) {
				hvGOzUQV.write(dTp8uhnd, 0, stRfJPZ2);
			}
		} finally {
			if (ikCepbuq != null) {
				try {
					ikCepbuq.close();
				} catch (IOException eVr6ingz) {
					eVr6ingz.printStackTrace();
				}
			}
			if (hvGOzUQV != null) {
				try {
					hvGOzUQV.close();
				} catch (IOException DOcB8BKM) {
					DOcB8BKM.printStackTrace();
				}
			}
		}
	}

}