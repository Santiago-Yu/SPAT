class n1037402 {
	public static final String getContent(String n3KlJhLh) {
		String WOjswoTk = "";
		OutputStream bA4cUB89 = null;
		URLConnection pcQYTMpo = null;
		InputStream LWRFAMjy = null;
		try {
			URL gHapPfbA = new URL(n3KlJhLh);
			bA4cUB89 = new ByteArrayOutputStream();
			pcQYTMpo = gHapPfbA.openConnection();
			LWRFAMjy = pcQYTMpo.getInputStream();
			byte[] t0azf2MY = new byte[1024];
			int gzK4cdRV;
			while ((gzK4cdRV = LWRFAMjy.read(t0azf2MY)) != -1) {
				bA4cUB89.write(t0azf2MY, 0, gzK4cdRV);
			}
			WOjswoTk = bA4cUB89.toString();
		} catch (Exception t6As8ThP) {
			t6As8ThP.printStackTrace();
		} finally {
			try {
				if (LWRFAMjy != null) {
					LWRFAMjy.close();
				}
				if (bA4cUB89 != null) {
					bA4cUB89.close();
				}
			} catch (IOException ogBO9F1k) {
			}
		}
		return WOjswoTk;
	}

}