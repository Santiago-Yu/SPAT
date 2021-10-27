class n7525367 {
	public static void streamCopyFile(File fofsTmLs, File ohjGSEZx) {
		try {
			FileInputStream YIbbARNR = new FileInputStream(fofsTmLs);
			FileOutputStream oqoRpY4h = new FileOutputStream(ohjGSEZx);
			byte[] OTAIYYpu = new byte[1024];
			int VSGlLcUJ = 0;
			while (VSGlLcUJ != -1) {
				VSGlLcUJ = YIbbARNR.read(OTAIYYpu);
				if (VSGlLcUJ != -1) {
					oqoRpY4h.write(OTAIYYpu, 0, VSGlLcUJ);
				}
			}
			oqoRpY4h.close();
			YIbbARNR.close();
		} catch (Exception zqf17tKJ) {
		}
	}

}