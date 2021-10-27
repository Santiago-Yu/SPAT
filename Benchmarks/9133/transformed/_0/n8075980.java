class n8075980 {
	public byte[] getDataAsByteArray(String GJo8YgM8) {
		try {
			byte[] wkjX3F6f = null;
			URLConnection N9OZiMgS;
			if (!GJo8YgM8.toUpperCase().startsWith("HTTP://") && !GJo8YgM8.toUpperCase().startsWith("HTTPS://")) {
				N9OZiMgS = tryOpenConnection(GJo8YgM8);
			} else {
				N9OZiMgS = new URL(GJo8YgM8).openConnection();
			}
			N9OZiMgS.setUseCaches(false);
			N9OZiMgS.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			N9OZiMgS.setRequestProperty("User-Agent",
					"Mozilla/5.0 (X11; U; Linux x86_64; en-GB; rv:1.9.1.9) Gecko/20100414 Iceweasel/3.5.9 (like Firefox/3.5.9)");
			N9OZiMgS.setRequestProperty("Accept-Encoding", "gzip");
			InputStream rQmn9mpb = N9OZiMgS.getInputStream();
			int pIaBDEbW = N9OZiMgS.getContentLength();
			if (pIaBDEbW < 0) {
				ByteArrayOutputStream okdDJGhF = new ByteArrayOutputStream();
				byte[] kLznUP1h = new byte[4096];
				for (;;) {
					int GjaJ06eZ = rQmn9mpb.read(kLznUP1h);
					if (GjaJ06eZ <= 0)
						break;
					okdDJGhF.write(kLznUP1h, 0, GjaJ06eZ);
				}
				wkjX3F6f = okdDJGhF.toByteArray();
				okdDJGhF.close();
			} else {
				wkjX3F6f = new byte[pIaBDEbW];
				int GYKgaSVb = 0;
				while (GYKgaSVb < pIaBDEbW) {
					int CmrQQJ9L = rQmn9mpb.read(wkjX3F6f, GYKgaSVb, pIaBDEbW - GYKgaSVb);
					if (CmrQQJ9L <= 0)
						break;
					GYKgaSVb += CmrQQJ9L;
				}
			}
			rQmn9mpb.close();
			return wkjX3F6f;
		} catch (Exception LLsJu0L8) {
			throw new RuntimeException(LLsJu0L8);
		}
	}

}