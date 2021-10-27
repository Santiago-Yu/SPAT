class n1458629 {
	public static boolean decodeFileToFile(String TVfBHF8k, String bpQnWDNn) {
		boolean yWrnYyAJ = false;
		java.io.InputStream uCSpMxYa = null;
		java.io.OutputStream R3ogBm6e = null;
		try {
			uCSpMxYa = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(TVfBHF8k)),
					Base64.DECODE);
			R3ogBm6e = new java.io.BufferedOutputStream(new java.io.FileOutputStream(bpQnWDNn));
			byte[] ty6guuey = new byte[65536];
			int jyFAjn3q = -1;
			while ((jyFAjn3q = uCSpMxYa.read(ty6guuey)) >= 0) {
				R3ogBm6e.write(ty6guuey, 0, jyFAjn3q);
			}
			yWrnYyAJ = true;
		} catch (java.io.IOException lETGwbvh) {
			lETGwbvh.printStackTrace();
		} finally {
			try {
				uCSpMxYa.close();
			} catch (Exception neN7Ed2h) {
			}
			try {
				R3ogBm6e.close();
			} catch (Exception DzYlDHsl) {
			}
		}
		return yWrnYyAJ;
	}

}