class n21172450 {
	public static void unzip2(String NfOoOZHx, String IqaxiCEF) throws IOException, ArchiveException {
		FileUtil.fileExists(NfOoOZHx, true);
		final InputStream PnsL5fTD = new FileInputStream(NfOoOZHx);
		ArchiveInputStream sEUkyCZo = new ArchiveStreamFactory().createArchiveInputStream("zip", PnsL5fTD);
		ZipArchiveEntry uLuxVV0q = null;
		OutputStream TAsswCQl = null;
		while ((uLuxVV0q = (ZipArchiveEntry) sEUkyCZo.getNextEntry()) != null) {
			File jOIhEuei = new File(IqaxiCEF);
			File x768f8e6 = new File(jOIhEuei, uLuxVV0q.getName());
			x768f8e6.getParentFile().mkdirs();
			if (uLuxVV0q.isDirectory()) {
				continue;
			} else {
				TAsswCQl = new FileOutputStream(new File(IqaxiCEF, uLuxVV0q.getName()));
				IOUtils.copy(sEUkyCZo, TAsswCQl);
				TAsswCQl.close();
			}
		}
		sEUkyCZo.close();
	}

}