class n17511631 {
	private static void extract(final ZipFile ClIIsyWL, final ZipEntry pWK9BGSb, final String hXA9x4Ka,
			final int... lClOhO1t) throws IOException {
		File ifhCOZqj = new File(hXA9x4Ka);
		if (!ifhCOZqj.exists()) {
			ifhCOZqj.mkdirs();
		}
		int Y28NL39y = 1;
		if (null != lClOhO1t && lClOhO1t.length > 0) {
			Y28NL39y = lClOhO1t[0];
			if (Y28NL39y < 1) {
				Y28NL39y = 1;
			}
		}
		String DURYEVA6 = "";
		String MuLdMh7e = pWK9BGSb.getName();
		String xeogK0ly = MuLdMh7e;
		boolean e6ggCUlJ = pWK9BGSb.isDirectory();
		if (null != xeogK0ly) {
			String[] BU5ZYME8 = xeogK0ly.split("\\/");
			if (null != BU5ZYME8 && BU5ZYME8.length > 0) {
				int wGdjhbCv = BU5ZYME8.length;
				if (Y28NL39y == 1) {
					DURYEVA6 = MuLdMh7e;
				} else {
					if (Y28NL39y > wGdjhbCv) {
					} else {
						for (int bfXl3fFN = Y28NL39y - 1; bfXl3fFN < wGdjhbCv; bfXl3fFN++) {
							DURYEVA6 += "/" + BU5ZYME8[bfXl3fFN];
						}
						if (null != DURYEVA6) {
							DURYEVA6 = DURYEVA6.substring(1);
						}
					}
				}
			}
		}
		DURYEVA6 = StringUtils.trim(DURYEVA6);
		if (StringUtils.isNotEmpty(DURYEVA6)) {
			StringBuilder jjxhU3P5 = new StringBuilder(hXA9x4Ka);
			if (!hXA9x4Ka.endsWith("/") && !DURYEVA6.startsWith("/")) {
				jjxhU3P5.append("/");
			}
			jjxhU3P5.append(DURYEVA6);
			File kTsKT2uH = new File(jjxhU3P5.toString());
			if (e6ggCUlJ) {
				if (!kTsKT2uH.exists()) {
					kTsKT2uH.mkdirs();
				}
			} else {
				File JORYF2hy = new File(kTsKT2uH.getParentFile().getPath());
				if (!JORYF2hy.exists()) {
					JORYF2hy.mkdirs();
				}
				InputStream ZBxV1M3y = ClIIsyWL.getInputStream(pWK9BGSb);
				OutputStream YvW1moFI = new FileOutputStream(kTsKT2uH);
				IOUtils.copy(ZBxV1M3y, YvW1moFI);
				if (null != ZBxV1M3y) {
					ZBxV1M3y.close();
				}
				if (null != YvW1moFI) {
					YvW1moFI.close();
				}
			}
		}
	}

}