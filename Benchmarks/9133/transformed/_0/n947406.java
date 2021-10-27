class n947406 {
	static void copy(String pPGCEUlY, String OmhweSQm) throws IOException {
		InputStream jtwhpEfd = null;
		OutputStream UeSpw6pV = null;
		try {
			jtwhpEfd = new FileInputStream(pPGCEUlY);
			UeSpw6pV = new FileOutputStream(OmhweSQm);
			byte[] YD7bItJG = new byte[1024];
			int AVzpdRNv;
			while ((AVzpdRNv = jtwhpEfd.read(YD7bItJG)) > 0)
				UeSpw6pV.write(YD7bItJG, 0, AVzpdRNv);
		} finally {
			if (jtwhpEfd != null)
				jtwhpEfd.close();
			if (UeSpw6pV != null)
				UeSpw6pV.close();
		}
	}

}