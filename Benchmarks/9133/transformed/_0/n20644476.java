class n20644476 {
	private static AtomContainer askForMovieSettings() throws IOException, QTException {
		final InputStream QHkMvJpR = QuickTimeFormatGenerator.class.getResourceAsStream(REFERENCE_MOVIE_RESOURCE);
		final ByteArrayOutputStream Mv9u7rbN = new ByteArrayOutputStream(1024 * 100);
		IOUtils.copy(QHkMvJpR, Mv9u7rbN);
		final byte[] DDMvDC4y = Mv9u7rbN.toByteArray();
		final QTHandle r5V1NpmQ = new QTHandle(DDMvDC4y);
		final DataRef lKXMfZqf = new DataRef(r5V1NpmQ, StdQTConstants.kDataRefFileExtensionTag, ".mov");
		final Movie oiQuHqVM = Movie.fromDataRef(lKXMfZqf,
				StdQTConstants.newMovieActive | StdQTConstants4.newMovieAsyncOK);
		final MovieExporter KfHXHYP0 = new MovieExporter(StdQTConstants.kQTFileTypeMovie);
		KfHXHYP0.doUserDialog(oiQuHqVM, null, 0, oiQuHqVM.getDuration());
		return KfHXHYP0.getExportSettingsFromAtomContainer();
	}

}