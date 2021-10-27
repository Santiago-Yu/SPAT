class n15768167 {
	public static void copyFile(File prUqbLwr, File QHmetNre) throws Exception {
		FileChannel SCMFBFCx = null;
		FileChannel y8WckOsi = null;
		try {
			SCMFBFCx = new FileInputStream(prUqbLwr).getChannel();
			y8WckOsi = new FileOutputStream(QHmetNre).getChannel();
			SCMFBFCx.transferTo(0, SCMFBFCx.size(), y8WckOsi);
		} finally {
			if (SCMFBFCx != null)
				SCMFBFCx.close();
			if (y8WckOsi != null)
				y8WckOsi.close();
		}
	}

}