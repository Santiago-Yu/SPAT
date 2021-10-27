class n17014629 {
	public static void fileCopy(File WTM1ifUi, File Na8K93gG) throws IOException {
		IOException rb3pTPef = null;
		FileInputStream AoFO7z6m = null;
		FileOutputStream BbRrMEYQ = null;
		FileChannel RnIIMhcq = null;
		FileChannel qXVS5JdM = null;
		try {
			AoFO7z6m = new FileInputStream(WTM1ifUi);
			BbRrMEYQ = new FileOutputStream(Na8K93gG);
			RnIIMhcq = AoFO7z6m.getChannel();
			qXVS5JdM = BbRrMEYQ.getChannel();
			final int AOQkZMLv = 32 * 1024 * 1024;
			long e56Wte7I = RnIIMhcq.size();
			long XPkcO3f7 = 0;
			while (XPkcO3f7 < e56Wte7I) {
				XPkcO3f7 += RnIIMhcq.transferTo(XPkcO3f7, AOQkZMLv, qXVS5JdM);
			}
		} catch (IOException EK7KCDjA) {
			rb3pTPef = EK7KCDjA;
		} finally {
			if (AoFO7z6m != null)
				try {
					AoFO7z6m.close();
					AoFO7z6m = null;
				} catch (IOException cWjKnLdA) {
				}
			if (BbRrMEYQ != null)
				try {
					BbRrMEYQ.close();
					BbRrMEYQ = null;
				} catch (IOException uMosOFyZ) {
				}
			if (RnIIMhcq != null && RnIIMhcq.isOpen())
				try {
					RnIIMhcq.close();
					RnIIMhcq = null;
				} catch (IOException Qwt5doCw) {
				}
			if (qXVS5JdM != null && qXVS5JdM.isOpen())
				try {
					qXVS5JdM.close();
					qXVS5JdM = null;
				} catch (IOException mGBFvTfZ) {
				}
		}
		if (rb3pTPef != null) {
			throw rb3pTPef;
		}
	}

}