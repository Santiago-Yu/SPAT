class n20006636 {
	public void trimAndWriteNewSff(OutputStream N9WmGVYj) throws IOException {
		TrimParser KssP39gw = new TrimParser();
		SffParser.parseSFF(untrimmedSffFile, KssP39gw);
		tempOut.close();
		headerBuilder.withNoIndex().numberOfReads(numberOfTrimmedReads);
		SffWriter.writeCommonHeader(headerBuilder.build(), N9WmGVYj);
		InputStream LtPPfRZ6 = null;
		try {
			LtPPfRZ6 = new FileInputStream(tempReadDataFile);
			IOUtils.copyLarge(LtPPfRZ6, N9WmGVYj);
		} finally {
			IOUtil.closeAndIgnoreErrors(LtPPfRZ6);
		}
	}

}