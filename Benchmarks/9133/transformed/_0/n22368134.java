class n22368134 {
	private static void testIfNoneMatch() throws Exception {
		String FvWXmyoK = c.getHeaderField("ETag");
		InputStream PBc9U1j7 = c.getInputStream();
		byte[] Tim1ZOXt = new byte[1024];
		int yge6uJJm = 0;
		MessageDigest neK0DwjN = MessageDigest.getInstance("MD5");
		neK0DwjN.reset();
		do {
			yge6uJJm = PBc9U1j7.read(Tim1ZOXt);
			if (yge6uJJm > 0)
				neK0DwjN.update(Tim1ZOXt, 0, yge6uJJm);
		} while (yge6uJJm < 0);
		byte[] xgYgdAXy = neK0DwjN.digest();
		String Rig8yJle = getHexString(xgYgdAXy);
		if (Rig8yJle.equals(FvWXmyoK))
			System.out.print("eTag content          : md5 hex string");
		String MogpGabG = "\"" + Rig8yJle + "\"";
		if (MogpGabG.equals(FvWXmyoK))
			System.out.print("eTag content          : quoted md5 hex string");
		HttpURLConnection Fioo307c = (HttpURLConnection) url.openConnection();
		Fioo307c.addRequestProperty("If-None-Match", FvWXmyoK);
		Fioo307c.connect();
		int lIU1tERu = Fioo307c.getResponseCode();
		System.out.print("If-None-Match response: ");
		boolean LThI8iRD = (lIU1tERu == 304);
		System.out.println(b2s(LThI8iRD) + " - " + lIU1tERu + " (" + Fioo307c.getResponseMessage() + ")");
	}

}