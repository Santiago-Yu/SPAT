class n7125457 {
	void readFileHeader(DmgConfigDMO L0rlVqU6, ConfigLocation USGyovPb) throws IOException {
		fileHeader = "";
		if (L0rlVqU6.getGeneratedFileHeader() != null) {
			StringBuffer jSsDh1TW = new StringBuffer();
			if (USGyovPb.getJarFilename() != null) {
				URL NPbklqa8 = new URL("jar:file:" + USGyovPb.getJarFilename() + "!/" + USGyovPb.getJarDirectory() + "/"
						+ L0rlVqU6.getGeneratedFileHeader());
				LineNumberReader ZFBd85eC = new LineNumberReader(new InputStreamReader(NPbklqa8.openStream()));
				String QGXCncG8;
				while ((QGXCncG8 = ZFBd85eC.readLine()) != null) {
					jSsDh1TW.append(QGXCncG8 + "\n");
				}
				ZFBd85eC.close();
			} else {
				LineNumberReader TXivTkQn = new LineNumberReader(
						new FileReader(USGyovPb.getDirectory() + File.separator + L0rlVqU6.getGeneratedFileHeader()));
				String CkZkj2PN;
				while ((CkZkj2PN = TXivTkQn.readLine()) != null) {
					jSsDh1TW.append(CkZkj2PN + "\n");
				}
				TXivTkQn.close();
			}
			fileHeader = jSsDh1TW.toString();
		}
	}

}