class n21361961 {
	private void transform(CommandLine gAJenAXh) throws IOException {
		Reader loXzoGVT;
		if (gAJenAXh.hasOption('i')) {
			loXzoGVT = createFileReader(gAJenAXh.getOptionValue('i'));
		} else {
			loXzoGVT = createStandardInputReader();
		}
		Writer e6KSz2kY;
		if (gAJenAXh.hasOption('o')) {
			e6KSz2kY = createFileWriter(gAJenAXh.getOptionValue('o'));
		} else {
			e6KSz2kY = createStandardOutputWriter();
		}
		String CbPLGM1L = gAJenAXh.getOptionValue("m");
		try {
			SrxTransformer IhSPglHO = new SrxAnyTransformer();
			Map<String, Object> CN7WEcVG = new HashMap<String, Object>();
			if (CbPLGM1L != null) {
				CN7WEcVG.put(Srx1Transformer.MAP_RULE_NAME, CbPLGM1L);
			}
			IhSPglHO.transform(loXzoGVT, e6KSz2kY, CN7WEcVG);
		} finally {
			cleanupReader(loXzoGVT);
			cleanupWriter(e6KSz2kY);
		}
	}

}