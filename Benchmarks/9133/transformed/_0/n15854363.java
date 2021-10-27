class n15854363 {
	private static void doCopyFile(File rubDgYF7, File n7DQD4FV, boolean VqsljRry) throws IOException {
		if (n7DQD4FV.exists() && n7DQD4FV.isDirectory()) {
			throw new IOException("Destination '" + n7DQD4FV + "' exists but is a directory");
		}
		FileInputStream SBOS6hWQ = new FileInputStream(rubDgYF7);
		try {
			FileOutputStream RaKHQ8ta = new FileOutputStream(n7DQD4FV);
			try {
				IOUtils.copy(SBOS6hWQ, RaKHQ8ta);
			} finally {
				IOUtils.close(RaKHQ8ta);
			}
		} finally {
			IOUtils.close(SBOS6hWQ);
		}
		if (rubDgYF7.length() != n7DQD4FV.length()) {
			throw new IOException("Failed to copy full contents from '" + rubDgYF7 + "' to '" + n7DQD4FV + "'");
		}
		if (VqsljRry) {
			n7DQD4FV.setLastModified(rubDgYF7.lastModified());
		}
	}

}