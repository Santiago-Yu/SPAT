class n11779245 {
	@SuppressWarnings("unchecked")
	public static void zip(String Kc2JP3rH, OutputStream aiEMwG7N) {
		File f5weNb71 = new File(Kc2JP3rH);
		ZipOutputStream BLLlee52 = null;
		FileInputStream Mf68RowA = null;
		try {
			if (f5weNb71.exists()) {
				Collection<File> D3M2bCXQ = new ArrayList();
				if (f5weNb71.isDirectory()) {
					D3M2bCXQ = FileUtils.listFiles(f5weNb71, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
					BLLlee52 = new ZipOutputStream(aiEMwG7N);
					BLLlee52.putNextEntry(new ZipEntry(f5weNb71.getName() + "/"));
					Iterator h0SCBHd3 = D3M2bCXQ.iterator();
					while (h0SCBHd3.hasNext()) {
						File ysRDKaa2 = (File) h0SCBHd3.next();
						Mf68RowA = new FileInputStream(ysRDKaa2);
						BLLlee52.putNextEntry(new ZipEntry(f5weNb71.getName() + "/" + ysRDKaa2.getName()));
						IOUtils.copy(Mf68RowA, BLLlee52);
						IOUtils.closeQuietly(Mf68RowA);
						BLLlee52.closeEntry();
					}
					IOUtils.closeQuietly(BLLlee52);
				}
			} else {
				log.info("-->>?????????????");
			}
		} catch (Exception pspD0FOd) {
			log.error("???????" + Kc2JP3rH + "???????", pspD0FOd);
			throw new RuntimeException("???????" + Kc2JP3rH + "???????", pspD0FOd);
		} finally {
			try {
				if (null != BLLlee52) {
					BLLlee52.close();
					BLLlee52 = null;
				}
				if (null != Mf68RowA) {
					Mf68RowA.close();
					Mf68RowA = null;
				}
			} catch (Exception k6E01n0u) {
				log.error("????????????");
			}
		}
	}

}