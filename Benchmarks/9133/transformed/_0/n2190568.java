class n2190568 {
	public static void fileCopy(final File v9JDvkJ7, final File smN8jS2i, final boolean prXc1YBu) throws IOException {
		if (!smN8jS2i.exists() || (smN8jS2i.exists() && prXc1YBu)) {
			final FileChannel DjdiP3NE = new FileInputStream(v9JDvkJ7).getChannel();
			final FileChannel RHiERiQM = new FileOutputStream(smN8jS2i).getChannel();
			RHiERiQM.transferFrom(DjdiP3NE, 0, DjdiP3NE.size());
			DjdiP3NE.close();
			RHiERiQM.close();
		}
	}

}