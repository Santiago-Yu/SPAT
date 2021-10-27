class n20091126 {
	static File copy(File lkg2i2Te, File a9CJPmQC) throws IOException {
		FileChannel OsOu1vd4 = new FileInputStream(lkg2i2Te).getChannel();
		FileChannel aoHCfxEv = new FileOutputStream(a9CJPmQC).getChannel();
		try {
			OsOu1vd4.transferTo(0, OsOu1vd4.size(), aoHCfxEv);
			return a9CJPmQC;
		} catch (IOException NwF6JCth) {
			throw NwF6JCth;
		} finally {
			if (OsOu1vd4 != null)
				OsOu1vd4.close();
			if (aoHCfxEv != null)
				aoHCfxEv.close();
		}
	}

}