class n3078767 {
	public static void copyFile(File YwRFaTYY, File cQvYeylh) throws IOException {
		FileChannel tOF23VZb = null, Mm58hJL5 = null;
		try {
			tOF23VZb = new FileInputStream(YwRFaTYY).getChannel();
			Mm58hJL5 = new FileOutputStream(cQvYeylh).getChannel();
			tOF23VZb.transferTo(0, tOF23VZb.size(), Mm58hJL5);
		} catch (FileNotFoundException yEcZ7FGO) {
			Log.debug(yEcZ7FGO);
		} finally {
			if (tOF23VZb != null)
				tOF23VZb.close();
			if (Mm58hJL5 != null)
				Mm58hJL5.close();
		}
	}

}