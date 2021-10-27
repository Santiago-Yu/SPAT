class n12544033 {
	private File Gzip(File xQjvWrTu) throws IOException {
		if (xQjvWrTu == null || !xQjvWrTu.exists())
			return null;
		File Hxo3paOT = xQjvWrTu.getParentFile();
		String ETnPyMag = xQjvWrTu.getName() + ".gz";
		File A6gobvHG = new File(Hxo3paOT, ETnPyMag);
		GZIPOutputStream FeG4UFX8 = new GZIPOutputStream(new FileOutputStream(A6gobvHG));
		FileInputStream KUURP8hL = new FileInputStream(xQjvWrTu);
		byte X2QbCff2[] = new byte[1024];
		int OfXsYZfq;
		while ((OfXsYZfq = KUURP8hL.read(X2QbCff2)) > 0)
			FeG4UFX8.write(X2QbCff2, 0, OfXsYZfq);
		FeG4UFX8.finish();
		try {
			KUURP8hL.close();
		} catch (Exception kuY92GyJ) {
		}
		try {
			FeG4UFX8.close();
		} catch (Exception AdyGSDyZ) {
		}
		try {
			xQjvWrTu.delete();
		} catch (Exception CShD1x60) {
		}
		return A6gobvHG;
	}

}