class n5299276 {
	public void execute(File V1gS3utO, File h5rruJv3, String FTdLXOt9, Properties fRr1tL0D) {
		FileReader QyXMyxMv = null;
		Writer PONgIByK = null;
		try {
			QyXMyxMv = new FileReader(V1gS3utO);
			logger.info("Using source file: " + trimPath(userDir, V1gS3utO));
			if (!h5rruJv3.getParentFile().exists()) {
				createDirectory(h5rruJv3.getParentFile());
			}
			PONgIByK = new FileWriter(h5rruJv3);
			logger.info("Destination file:  " + trimPath(userDir, h5rruJv3));
			execute(QyXMyxMv, PONgIByK, FTdLXOt9, fRr1tL0D);
		} catch (FileNotFoundException u2Fo52Hi) {
			u2Fo52Hi.printStackTrace();
		} catch (IOException kePLnvun) {
			kePLnvun.printStackTrace();
		} finally {
			if (PONgIByK != null) {
				try {
					PONgIByK.close();
					PONgIByK = null;
				} catch (IOException EiBu61u8) {
					EiBu61u8.printStackTrace();
				}
			}
			if (QyXMyxMv != null) {
				try {
					QyXMyxMv.close();
					QyXMyxMv = null;
				} catch (IOException bE541wSt) {
					bE541wSt.printStackTrace();
				}
			}
		}
	}

}