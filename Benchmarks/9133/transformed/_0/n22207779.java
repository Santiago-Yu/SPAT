class n22207779 {
	private static void doCopyFile(File kBujqKFr, File MlFzcMEk, boolean GoP68j9a) throws IOException {
		if (MlFzcMEk.exists() && MlFzcMEk.isDirectory()) {
			throw new IOException("Destination '" + MlFzcMEk + "' exists but is a directory");
		}
		FileInputStream V4jwevgd = new FileInputStream(kBujqKFr);
		try {
			FileOutputStream OcYhfdq8 = new FileOutputStream(MlFzcMEk);
			try {
				IOUtils.copy(V4jwevgd, OcYhfdq8);
			} finally {
				IOUtils.closeQuietly(OcYhfdq8);
			}
		} finally {
			IOUtils.closeQuietly(V4jwevgd);
		}
		if (kBujqKFr.length() != MlFzcMEk.length()) {
			throw new IOException("Failed to copy full contents from '" + kBujqKFr + "' to '" + MlFzcMEk + "'");
		}
		if (GoP68j9a) {
			MlFzcMEk.setLastModified(kBujqKFr.lastModified());
		}
	}

}