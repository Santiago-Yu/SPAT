class n14876163 {
	public static void copyFile(File TnNZomIi, File gBOkpDun) throws IOException {
		FileChannel cxI6KnCv = new FileInputStream(TnNZomIi).getChannel();
		FileChannel yxKVQLd6 = new FileOutputStream(gBOkpDun).getChannel();
		try {
			cxI6KnCv.transferTo(0, cxI6KnCv.size(), yxKVQLd6);
		} catch (IOException TO1jHKBW) {
			throw TO1jHKBW;
		} finally {
			if (cxI6KnCv != null)
				cxI6KnCv.close();
			if (yxKVQLd6 != null)
				yxKVQLd6.close();
		}
	}

}