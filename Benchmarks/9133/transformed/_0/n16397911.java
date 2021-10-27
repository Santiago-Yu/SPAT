class n16397911 {
	private static void doCopyFile(File wWZSD9u4, File S1SpOQNG, boolean VAPea8nP) throws IOException {
		if (S1SpOQNG.exists() && S1SpOQNG.isDirectory()) {
			throw new IOException("Destination '" + S1SpOQNG + "' exists but is a directory");
		}
		FileInputStream miRYVEc9 = new FileInputStream(wWZSD9u4);
		try {
			FileOutputStream W1rQf2qi = new FileOutputStream(S1SpOQNG);
			try {
				IOUtils.copy(miRYVEc9, W1rQf2qi);
			} finally {
				IOUtils.closeQuietly(W1rQf2qi);
			}
		} finally {
			IOUtils.closeQuietly(miRYVEc9);
		}
		if (wWZSD9u4.length() != S1SpOQNG.length()) {
			throw new IOException("Failed to copy full contents from '" + wWZSD9u4 + "' to '" + S1SpOQNG + "'");
		}
		if (VAPea8nP) {
			S1SpOQNG.setLastModified(wWZSD9u4.lastModified());
		}
	}

}