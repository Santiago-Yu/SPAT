class n13292288 {
	private static void doCopyFile(File UXvBQPtc, File ngoZv7sG, boolean nSrnoRcc) throws IOException {
		if (ngoZv7sG.exists() && ngoZv7sG.isDirectory()) {
			throw new IOException("Destination '" + ngoZv7sG + "' exists but is a directory");
		}
		FileInputStream rpqYq08d = new FileInputStream(UXvBQPtc);
		try {
			FileOutputStream N7PdUPjC = new FileOutputStream(ngoZv7sG);
			try {
				IOUtils.copy(rpqYq08d, N7PdUPjC);
			} finally {
				IOUtils.closeQuietly(N7PdUPjC);
			}
		} finally {
			IOUtils.closeQuietly(rpqYq08d);
		}
		if (UXvBQPtc.length() != ngoZv7sG.length()) {
			throw new IOException("Failed to copy full contents from '" + UXvBQPtc + "' to '" + ngoZv7sG + "'");
		}
		if (nSrnoRcc) {
			ngoZv7sG.setLastModified(UXvBQPtc.lastModified());
		}
	}

}