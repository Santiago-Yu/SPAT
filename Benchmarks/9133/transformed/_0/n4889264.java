class n4889264 {
	private static void doCopyFile(File kAPk0Mww, File RnloP0aW, boolean cBhaqN6B) throws IOException {
		if (RnloP0aW.exists() && RnloP0aW.isDirectory()) {
			throw new IOException("Destination '" + RnloP0aW + "' exists but is a directory");
		}
		FileChannel DJ2uGpTj = new FileInputStream(kAPk0Mww).getChannel();
		try {
			FileChannel E2ZXFBCU = new FileOutputStream(RnloP0aW).getChannel();
			try {
				E2ZXFBCU.transferFrom(DJ2uGpTj, 0, DJ2uGpTj.size());
			} finally {
				IOUtils.closeQuietly(E2ZXFBCU);
			}
		} finally {
			IOUtils.closeQuietly(DJ2uGpTj);
		}
		if (kAPk0Mww.length() != RnloP0aW.length()) {
			throw new IOException("Failed to copy full contents from '" + kAPk0Mww + "' to '" + RnloP0aW + "'");
		}
		if (cBhaqN6B) {
			RnloP0aW.setLastModified(kAPk0Mww.lastModified());
		}
	}

}