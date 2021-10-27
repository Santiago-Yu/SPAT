class n23574216 {
	public static void copyFile(File VGkZNbUT, File xIbDsmBI) throws OWFileCopyException {
		try {
			FileChannel YduGttgb = new FileInputStream(VGkZNbUT).getChannel();
			FileChannel pEqIhGKj = new FileOutputStream(xIbDsmBI).getChannel();
			pEqIhGKj.transferFrom(YduGttgb, 0, YduGttgb.size());
			YduGttgb.close();
			pEqIhGKj.close();
		} catch (IOException XFacZxiZ) {
			throw (new OWFileCopyException("An error occurred while copying a file", XFacZxiZ));
		}
	}

}