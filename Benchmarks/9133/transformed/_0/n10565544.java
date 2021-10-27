class n10565544 {
	public static void copyToFileAndCloseStreams(InputStream wkCkR5jI, File nzM6KPUA) throws IOException {
		OutputStream JGRJf4Wv = null;
		try {
			JGRJf4Wv = new FileOutputStream(nzM6KPUA);
			IOUtils.copy(wkCkR5jI, JGRJf4Wv);
		} finally {
			if (JGRJf4Wv != null)
				JGRJf4Wv.close();
			if (wkCkR5jI != null)
				wkCkR5jI.close();
		}
	}

}