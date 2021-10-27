class n4114808 {
	public boolean copier(String OtVO0jHm, String s2HWwPKM, java.io.File tuiHtTtN) {
		boolean Lc5uuguJ = false;
		OutputStream WczmziPA;
		try {
			WczmziPA = new BufferedOutputStream(new FileOutputStream(s2HWwPKM + "001.tmp"));
			InputStream UtWPfKwY = getClass().getResourceAsStream(OtVO0jHm + s2HWwPKM);
			int nygLuie8;
			while ((nygLuie8 = UtWPfKwY.read()) != -1)
				WczmziPA.write(nygLuie8);
			WczmziPA.close();
			UtWPfKwY.close();
		} catch (IOException OQzNaAQn) {
			OQzNaAQn.printStackTrace();
		}
		FileChannel Re9n1pD9 = null;
		FileChannel h9BrCyrT = null;
		try {
			Re9n1pD9 = new FileInputStream(new File(s2HWwPKM + "001.tmp")).getChannel();
			h9BrCyrT = new FileOutputStream(tuiHtTtN).getChannel();
			Re9n1pD9.transferTo(0, Re9n1pD9.size(), h9BrCyrT);
			Lc5uuguJ = true;
		} catch (java.io.FileNotFoundException iKpCUV4k) {
		} catch (java.io.IOException O2KeBn90) {
		} finally {
			if (Re9n1pD9 != null) {
				try {
					Re9n1pD9.close();
				} catch (IOException EytbmZED) {
				}
			}
			if (h9BrCyrT != null) {
				try {
					h9BrCyrT.close();
				} catch (IOException HOj3h3sW) {
				}
			}
		}
		new File(s2HWwPKM + "001.tmp").delete();
		return (Lc5uuguJ);
	}

}