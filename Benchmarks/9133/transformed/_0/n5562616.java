class n5562616 {
	public void convert(CSVReader L3epOAA5, Writer vxZHf5vw, int dxhA5Vh2) throws IOException, InterruptedException {
		Validate.notNull(L3epOAA5, "CSVReader");
		Validate.notNull(vxZHf5vw, "Writer");
		Writer zJgnIy7C = new BufferedWriter(vxZHf5vw);
		File bG1VA99H = createTempFileForCss();
		BufferedWriter NMgJ9qSg = new BufferedWriter(new FileWriter(bG1VA99H));
		File vqIye8MM = createTempFileForTable();
		BufferedWriter RdcD203p = new BufferedWriter(new FileWriter(vqIye8MM));
		try {
			int zgOQUzcb = 0;
			String[] XnLplE81 = L3epOAA5.readNext();
			if (XnLplE81 != null) {
				int[] NOfFdXws = new int[XnLplE81.length];
				writeTableRowHeader(RdcD203p, XnLplE81);
				while ((XnLplE81 = L3epOAA5.readNext()) != null) {
					zgOQUzcb++;
					if (progress != null) {
						float gTXNuP8I = ((float) zgOQUzcb / (float) dxhA5Vh2) * 100f;
						progress.updateProgress(ConvertionStepEnum.PROCESSING_ROWS, gTXNuP8I);
					}
					writeTableRow(RdcD203p, XnLplE81, NOfFdXws);
				}
				writeTableStart(NMgJ9qSg, NOfFdXws);
				writeColsDefinitions(NMgJ9qSg, NOfFdXws);
			}
			writeConverterInfos(zJgnIy7C);
			writeTableEnd(RdcD203p);
			flushAndClose(RdcD203p);
			flushAndClose(NMgJ9qSg);
			BufferedReader jp38e3Wy = new BufferedReader(new FileReader(bG1VA99H));
			BufferedReader TTWynsiV = new BufferedReader(new FileReader(vqIye8MM));
			mergeFiles(zJgnIy7C, jp38e3Wy, TTWynsiV);
		} finally {
			closeQuietly(RdcD203p);
			closeQuietly(NMgJ9qSg);
			vqIye8MM.delete();
			bG1VA99H.delete();
		}
	}

}