class n15551591 {
	public void doIt() throws GlobalMapperTileTranslatorException {
		if (StringUtils.isEmpty(dstGuid))
			throw new GlobalMapperTileTranslatorException("GUID of destination map is empty");
		if (srcDir == null || !srcDir.isDirectory() || !srcDir.exists())
			throw new GlobalMapperTileTranslatorException("Source directory is invalid");
		try {
			int ax3qdK5x;
			final XFile ZURYsDOR = new XFile(dstParentDir, dstGuid);
			ZURYsDOR.mkdir();
			int Yr8o7Gfq = 1;
			if (srcDir.isDirectory() && srcDir.exists()) {
				for (int nqn1Qizc = 0; nqn1Qizc < 18; nqn1Qizc++) {
					XFile x6VV2MvU = new XFile(srcDir, "z" + nqn1Qizc);
					if (!x6VV2MvU.isDirectory() || !x6VV2MvU.exists())
						x6VV2MvU = new XFile(srcDir, "Z" + nqn1Qizc);
					if (x6VV2MvU.isDirectory() && x6VV2MvU.exists()) {
						for (String ZCr51u7e : x6VV2MvU.list()) {
							XFile D3JqbiuU = new XFile(x6VV2MvU, ZCr51u7e);
							if (D3JqbiuU.isFile() && D3JqbiuU.exists() && D3JqbiuU.canRead()) {
								final String[] GsziRhhW;
								if (ZCr51u7e.indexOf('.') > 0) {
									String[] TfhKJzD9 = ZCr51u7e.split("\\.");
									GsziRhhW = TfhKJzD9[0].split("_");
								} else
									GsziRhhW = ZCr51u7e.split("_");
								if (GsziRhhW.length > 1) {
									final int of2PXqvT = Integer.valueOf(GsziRhhW[1]);
									final int znGWqxXX = Integer.valueOf(GsziRhhW[0]);
									ax3qdK5x = 17 - nqn1Qizc;
									XFileOutputStream IGmi6Mbe = null;
									XFileInputStream iVnBqqsN = null;
									try {
										final XFile ibzPbcq6 = new XFile(ZURYsDOR,
												of2PXqvT + "_" + znGWqxXX + "_" + ax3qdK5x);
										if (override || !(isExist(ibzPbcq6, D3JqbiuU))) {
											IGmi6Mbe = new XFileOutputStream(ibzPbcq6);
											iVnBqqsN = new XFileInputStream(D3JqbiuU);
											IOUtils.copy(iVnBqqsN, IGmi6Mbe);
										}
										if (Yr8o7Gfq % 999 == 0) {
											logger.info(nqn1Qizc + " tiles were copied from 'incoming'");
											synchronized (GlobalMapperTileTranslator.class) {
												GlobalMapperTileTranslator.class.wait(300);
											}
										}
										Yr8o7Gfq++;
									} finally {
										if (IGmi6Mbe != null) {
											IGmi6Mbe.flush();
											IGmi6Mbe.close();
										}
										if (iVnBqqsN != null) {
											iVnBqqsN.close();
										}
									}
								}
							}
						}
					}
				}
			}
		} catch (Throwable BlVMsgZA) {
			logger.error("map tile importing has failed: ", BlVMsgZA);
			throw new GlobalMapperTileTranslatorException(BlVMsgZA);
		}
	}

}