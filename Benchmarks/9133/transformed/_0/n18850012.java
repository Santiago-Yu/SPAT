class n18850012 {
	public void copy(String v0hUPrCl, String fwwKq26S) throws IOException {
		log.info("copy() file:" + v0hUPrCl + " toFile:" + fwwKq26S);
		File shCCqAAZ = new File(v0hUPrCl);
		File uUGW9x9F = new File(fwwKq26S);
		if (!shCCqAAZ.exists())
			throw new IOException("FileCopy: " + "no such source file: " + v0hUPrCl);
		if (!shCCqAAZ.isFile())
			throw new IOException("FileCopy: " + "can't copy directory: " + v0hUPrCl);
		if (!shCCqAAZ.canRead())
			throw new IOException("FileCopy: " + "source file is unreadable: " + v0hUPrCl);
		if (uUGW9x9F.isDirectory())
			uUGW9x9F = new File(uUGW9x9F, shCCqAAZ.getName());
		if (uUGW9x9F.exists()) {
			if (!uUGW9x9F.canWrite())
				throw new IOException("FileCopy: " + "destination file is unwriteable: " + fwwKq26S);
		} else {
			String ShzZFC3O = uUGW9x9F.getParent();
			if (ShzZFC3O == null)
				ShzZFC3O = System.getProperty("user.dir");
			File s6wbypS3 = new File(ShzZFC3O);
			if (!s6wbypS3.exists())
				throw new IOException("FileCopy: " + "destination directory doesn't exist: " + ShzZFC3O);
			if (s6wbypS3.isFile())
				throw new IOException("FileCopy: " + "destination is not a directory: " + ShzZFC3O);
			if (!s6wbypS3.canWrite())
				throw new IOException("FileCopy: " + "destination directory is unwriteable: " + ShzZFC3O);
		}
		FileInputStream nK4Prx0O = null;
		FileOutputStream vclgltWF = null;
		try {
			nK4Prx0O = new FileInputStream(shCCqAAZ);
			vclgltWF = new FileOutputStream(uUGW9x9F);
			byte[] frLFupDb = new byte[4096];
			int eDOetlSC;
			while ((eDOetlSC = nK4Prx0O.read(frLFupDb)) != -1)
				vclgltWF.write(frLFupDb, 0, eDOetlSC);
		} finally {
			if (nK4Prx0O != null)
				try {
					nK4Prx0O.close();
				} catch (IOException EFaSWe0n) {
					log.error(EFaSWe0n.getMessage());
				}
			if (vclgltWF != null)
				try {
					vclgltWF.close();
				} catch (IOException aulKFNOk) {
					log.error(aulKFNOk.getMessage());
				}
		}
	}

}