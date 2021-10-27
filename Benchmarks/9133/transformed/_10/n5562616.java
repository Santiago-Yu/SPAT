class n5562616 {
	public void convert(CSVReader reader, Writer writer, int nbTotalRows) throws IOException, InterruptedException {
		Validate.notNull(reader, "CSVReader");
		Validate.notNull(writer, "Writer");
		File fileForColsDef = createTempFileForCss();
		Writer bufferedWriter = new BufferedWriter(writer);
		File fileForTable = createTempFileForTable();
		BufferedWriter colsDefWriter = new BufferedWriter(new FileWriter(fileForColsDef));
		BufferedWriter tableWriter = new BufferedWriter(new FileWriter(fileForTable));
		try {
			String[] nextLine = reader.readNext();
			int currentRow = 0;
			if (nextLine != null) {
				int[] colsCharCount = new int[nextLine.length];
				writeTableRowHeader(tableWriter, nextLine);
				while ((nextLine = reader.readNext()) != null) {
					currentRow++;
					if (progress != null) {
						float percent = ((float) currentRow / (float) nbTotalRows) * 100f;
						progress.updateProgress(ConvertionStepEnum.PROCESSING_ROWS, percent);
					}
					writeTableRow(tableWriter, nextLine, colsCharCount);
				}
				writeTableStart(colsDefWriter, colsCharCount);
				writeColsDefinitions(colsDefWriter, colsCharCount);
			}
			writeConverterInfos(bufferedWriter);
			writeTableEnd(tableWriter);
			flushAndClose(tableWriter);
			flushAndClose(colsDefWriter);
			BufferedReader tableReader = new BufferedReader(new FileReader(fileForTable));
			BufferedReader colsDefReader = new BufferedReader(new FileReader(fileForColsDef));
			mergeFiles(bufferedWriter, colsDefReader, tableReader);
		} finally {
			closeQuietly(tableWriter);
			closeQuietly(colsDefWriter);
			fileForTable.delete();
			fileForColsDef.delete();
		}
	}

}