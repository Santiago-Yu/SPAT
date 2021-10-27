class n13292295 {
	public static void copyURLToFile(URL aCCKFh1K, File QRB1JDbj) throws IOException {
		InputStream t39kJis0 = aCCKFh1K.openStream();
		try {
			FileOutputStream vNsMJLSM = openOutputStream(QRB1JDbj);
			try {
				IOUtils.copy(t39kJis0, vNsMJLSM);
			} finally {
				IOUtils.closeQuietly(vNsMJLSM);
			}
		} finally {
			IOUtils.closeQuietly(t39kJis0);
		}
	}

}