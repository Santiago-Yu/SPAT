class n2711645 {
	public static boolean decodeFileToFile(String b9bMqPjl, String KuUAYj5x) {
		boolean JQf3H3DX = false;
		java.io.InputStream Cs3fWQ59 = null;
		java.io.OutputStream NVRQhcFB = null;
		try {
			Cs3fWQ59 = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(b9bMqPjl)),
					Base64.DECODE);
			NVRQhcFB = new java.io.BufferedOutputStream(new java.io.FileOutputStream(KuUAYj5x));
			byte[] qibElwOy = new byte[65536];
			int jOEwwOFA = -1;
			while ((jOEwwOFA = Cs3fWQ59.read(qibElwOy)) >= 0) {
				NVRQhcFB.write(qibElwOy, 0, jOEwwOFA);
			}
			JQf3H3DX = true;
		} catch (java.io.IOException xnrLpocq) {
			xnrLpocq.printStackTrace();
		} finally {
			try {
				Cs3fWQ59.close();
			} catch (Exception lxwBrpo4) {
			}
			try {
				NVRQhcFB.close();
			} catch (Exception yzVVjAgH) {
			}
		}
		return JQf3H3DX;
	}

}