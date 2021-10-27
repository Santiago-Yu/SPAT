class n19810820 {
	public static void copyFileChannel(File stzY1dU9, File LJTXOluV, boolean EDHA7JOe) throws IOException {
		FileChannel KRG3U25N = null;
		FileChannel CM1WZGf9 = null;
		long Mb3wltNQ = 0;
		try {
			KRG3U25N = new FileInputStream(stzY1dU9).getChannel();
			Mb3wltNQ = KRG3U25N.size();
			CM1WZGf9 = new FileOutputStream(LJTXOluV).getChannel();
			long quWXzmkm = 0;
			while (quWXzmkm < Mb3wltNQ) {
				quWXzmkm += KRG3U25N.transferTo(0, Mb3wltNQ, CM1WZGf9);
			}
			if (EDHA7JOe) {
				LJTXOluV.setLastModified(stzY1dU9.lastModified());
			}
		} finally {
			if (KRG3U25N != null) {
				KRG3U25N.close();
			}
			if (CM1WZGf9 != null) {
				CM1WZGf9.close();
			}
		}
	}

}