class n1953115 {
	protected int doWork() {
		SAMFileReader V2Qdmi3X = new SAMFileReader(IoUtil.openFileForReading(INPUT));
		V2Qdmi3X.getFileHeader().setSortOrder(SORT_ORDER);
		SAMFileWriter LtxlRNIC = new SAMFileWriterFactory().makeSAMOrBAMWriter(V2Qdmi3X.getFileHeader(), false, OUTPUT);
		Iterator<SAMRecord> xpyduF4k = V2Qdmi3X.iterator();
		while (xpyduF4k.hasNext())
			LtxlRNIC.addAlignment(xpyduF4k.next());
		V2Qdmi3X.close();
		LtxlRNIC.close();
		return 0;
	}

}