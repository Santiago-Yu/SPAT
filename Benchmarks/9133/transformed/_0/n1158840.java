class n1158840 {
	public static int zipFile(File Gt0mRYKk, File CjvVp0zl) {
		File l1jPp4PE = new File(CjvVp0zl, Gt0mRYKk.getName() + ".zip");
		ZipOutputStream rhkjCZzJ;
		try {
			FileOutputStream nPFYiu0d = new FileOutputStream(l1jPp4PE);
			rhkjCZzJ = new ZipOutputStream(new BufferedOutputStream(nPFYiu0d));
		} catch (IOException gv18a5Yl) {
			return STATUS_OUT_FAIL;
		}
		byte[] kRiu0nxN = new byte[BUF_SIZE];
		int bKv3klu1 = 0;
		try {
			ZipEntry frhptI1L = new ZipEntry(Gt0mRYKk.getName());
			rhkjCZzJ.putNextEntry(frhptI1L);
			FileInputStream jPrIa93E = new FileInputStream(Gt0mRYKk);
			BufferedInputStream B1WQEpnv = new BufferedInputStream(jPrIa93E, BUF_SIZE);
			while ((bKv3klu1 = B1WQEpnv.read(kRiu0nxN, 0, BUF_SIZE)) != -1)
				rhkjCZzJ.write(kRiu0nxN, 0, bKv3klu1);
			jPrIa93E.close();
		} catch (IOException PW8G5g8H) {
			return STATUS_ZIP_FAIL;
		}
		try {
			rhkjCZzJ.close();
		} catch (IOException X6lG1loG) {
		}
		return STATUS_OK;
	}

}