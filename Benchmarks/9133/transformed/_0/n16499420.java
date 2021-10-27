class n16499420 {
	private void saveFile(InputStream aGMiCr57, String jj3oQ6Qn) {
		try {
			File bUK2sYVL = new File(jj3oQ6Qn);
			if (!bUK2sYVL.exists()) {
				bUK2sYVL.createNewFile();
			}
			java.io.OutputStream LqVYofJP = new FileOutputStream(bUK2sYVL);
			org.apache.commons.io.IOUtils.copy(aGMiCr57, LqVYofJP);
			LqVYofJP.close();
		} catch (Exception pBmWXxaw) {
			pBmWXxaw.printStackTrace();
		}
	}

}