class n21824901 {
	public static void copyExternalResource(File FpD2GSza, File XXY5isBa) throws IOException {
		if (!XXY5isBa.exists()) {
			XXY5isBa.createNewFile();
		}
		FileChannel t3aRLAM1 = null;
		FileChannel PNFY4qoP = null;
		try {
			t3aRLAM1 = new FileInputStream(FpD2GSza).getChannel();
			PNFY4qoP = new FileOutputStream(XXY5isBa).getChannel();
			PNFY4qoP.transferFrom(t3aRLAM1, 0, t3aRLAM1.size());
		} finally {
			closeQuietly(t3aRLAM1);
			closeQuietly(PNFY4qoP);
		}
	}

}