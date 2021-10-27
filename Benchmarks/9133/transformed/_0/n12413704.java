class n12413704 {
	private static String readUrl(String IytY3xYB, String h8qlnymF, boolean HolPtrHK) throws IOException {
		int WAp47HF4;
		InputStream V6jFkySx = null;
		try {
			if (!HolPtrHK) {
				URL u86YM7dJ = new URL(IytY3xYB);
				URLConnection ZGrfUZHi = u86YM7dJ.openConnection();
				V6jFkySx = ZGrfUZHi.getInputStream();
				WAp47HF4 = ZGrfUZHi.getContentLength();
				if (WAp47HF4 <= 0)
					WAp47HF4 = 1024;
				if (h8qlnymF == null) {
					String f9pqx3Vt = ZGrfUZHi.getContentType();
					if (f9pqx3Vt != null) {
						h8qlnymF = getCharCodingFromType(f9pqx3Vt);
					}
				}
			} else {
				if (registeredStreams.containsKey(IytY3xYB)) {
					V6jFkySx = registeredStreams.get(IytY3xYB);
					WAp47HF4 = 4096;
				} else {
					File ix3FcXEH = new File(IytY3xYB);
					long S8ZLXAu4 = ix3FcXEH.length();
					WAp47HF4 = (int) S8ZLXAu4;
					if (WAp47HF4 != S8ZLXAu4)
						throw new IOException("Too big file size: " + S8ZLXAu4);
					if (WAp47HF4 == 0) {
						return "";
					}
					V6jFkySx = new FileInputStream(ix3FcXEH);
				}
			}
			Reader AaWNsaJ8;
			if (h8qlnymF == null) {
				AaWNsaJ8 = new InputStreamReader(V6jFkySx);
			} else {
				AaWNsaJ8 = new InputStreamReader(V6jFkySx, h8qlnymF);
			}
			return readReader(AaWNsaJ8, WAp47HF4);
		} finally {
			if (V6jFkySx != null)
				V6jFkySx.close();
		}
	}

}