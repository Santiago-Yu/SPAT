class n17984312 {
	public static void copyFile(File PPi6Zvpw, File Yl7MRdcT) throws IOException {
		FileChannel yJJe4y5B = new FileInputStream(PPi6Zvpw).getChannel();
		FileChannel ShYSknFv = new FileOutputStream(Yl7MRdcT).getChannel();
		try {
			yJJe4y5B.transferTo(0, yJJe4y5B.size(), ShYSknFv);
		} catch (IOException DIzruLrc) {
			throw DIzruLrc;
		} finally {
			if (yJJe4y5B != null)
				yJJe4y5B.close();
			if (ShYSknFv != null)
				ShYSknFv.close();
		}
	}

}