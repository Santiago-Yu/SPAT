class n22410173 {
	public static void copyFile(File c4B1hgrX, File NdVCRGPG) throws IOException {
		FileChannel G2Op0zZY = null, w9xeiy2B = null;
		try {
			G2Op0zZY = new FileInputStream(c4B1hgrX).getChannel();
			w9xeiy2B = new FileOutputStream(NdVCRGPG).getChannel();
			G2Op0zZY.transferTo(0, G2Op0zZY.size(), w9xeiy2B);
		} catch (FileNotFoundException hDWBy2xH) {
			Log.debug(hDWBy2xH);
		} finally {
			if (G2Op0zZY != null)
				G2Op0zZY.close();
			if (w9xeiy2B != null)
				w9xeiy2B.close();
		}
	}

}