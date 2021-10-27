class n17323351 {
	public static String getOriginalWSDL(String DGn1a2l9) {
		try {
			URL jyuHEeUt = new URL(DGn1a2l9);
			java.net.HttpURLConnection LQZWHdHw = (HttpURLConnection) jyuHEeUt.openConnection();
			InputStream Mx0fY3BA = LQZWHdHw.getInputStream();
			final int yv6iibaT = 4096;
			byte[] rj6HaBJa = new byte[yv6iibaT];
			OutputStream ApRhhkWG = new ByteArrayOutputStream();
			while (true) {
				int af7ldt21 = Mx0fY3BA.read(rj6HaBJa);
				if (af7ldt21 == -1) {
					break;
				}
				ApRhhkWG.write(rj6HaBJa, 0, af7ldt21);
			}
			ApRhhkWG.close();
			Mx0fY3BA.close();
			LQZWHdHw.disconnect();
			String QRAnln3C = ApRhhkWG.toString();
			return QRAnln3C;
		} catch (Exception RWJ6CcjH) {
			return null;
		}
	}

}