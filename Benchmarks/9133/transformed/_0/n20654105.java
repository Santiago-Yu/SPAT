class n20654105 {
	public static void copyFile(File uRbm6BQ8, File lht03nvo) throws IOException {
		FileChannel mEJVOt1Q = new FileInputStream(uRbm6BQ8).getChannel();
		FileChannel K3I19Vcr = new FileOutputStream(lht03nvo).getChannel();
		try {
			mEJVOt1Q.transferTo(0, mEJVOt1Q.size(), K3I19Vcr);
		} catch (IOException rGJvuyk9) {
			throw rGJvuyk9;
		} finally {
			if (mEJVOt1Q != null)
				mEJVOt1Q.close();
			if (K3I19Vcr != null)
				K3I19Vcr.close();
		}
	}

}