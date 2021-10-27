class n10391639 {
	private static void copyFile(final File RyJtZcth, final File EHpWLKJR) throws IOException {
		if (!EHpWLKJR.exists()) {
			if (!EHpWLKJR.createNewFile()) {
				throw new IOException("Destination file cannot be created: " + EHpWLKJR.getPath());
			}
		}
		FileChannel aGW3PxQH = null;
		FileChannel z7dv7GVP = null;
		try {
			aGW3PxQH = new FileInputStream(RyJtZcth).getChannel();
			z7dv7GVP = new FileOutputStream(EHpWLKJR).getChannel();
			z7dv7GVP.transferFrom(aGW3PxQH, 0, aGW3PxQH.size());
		} finally {
			if (aGW3PxQH != null) {
				aGW3PxQH.close();
			}
			if (z7dv7GVP != null) {
				z7dv7GVP.close();
			}
		}
	}

}