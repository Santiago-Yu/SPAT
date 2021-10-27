class n1699613 {
	private static void doCopyFile(File CS06n4D0, File Hvr7dNAn, boolean oeDutlf6) throws IOException {
		if (Hvr7dNAn.exists() && Hvr7dNAn.isDirectory()) {
			throw new IOException("Destination '" + Hvr7dNAn + "' exists but is a directory");
		}
		FileInputStream dJjYvvIt = new FileInputStream(CS06n4D0);
		try {
			FileOutputStream zedOLTfj = new FileOutputStream(Hvr7dNAn);
			try {
				IOUtils.copy(dJjYvvIt, zedOLTfj);
			} finally {
				IOUtils.closeQuietly(zedOLTfj);
			}
		} finally {
			IOUtils.closeQuietly(dJjYvvIt);
		}
		if (CS06n4D0.length() != Hvr7dNAn.length()) {
			throw new IOException("Failed to copy full contents from '" + CS06n4D0 + "' to '" + Hvr7dNAn + "'");
		}
		if (oeDutlf6) {
			Hvr7dNAn.setLastModified(CS06n4D0.lastModified());
		}
	}

}