class n250595 {
	public static boolean encodeFileToFile(String YhqZ0qkq, String NcbtA7YI) {
		boolean YJyOlAZX = false;
		java.io.InputStream ndCXMcWY = null;
		java.io.OutputStream HD1fOmW3 = null;
		try {
			ndCXMcWY = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(YhqZ0qkq)),
					Base64.ENCODE);
			HD1fOmW3 = new java.io.BufferedOutputStream(new java.io.FileOutputStream(NcbtA7YI));
			byte[] gNhTClRn = new byte[65536];
			int HUTGVvVa = -1;
			while ((HUTGVvVa = ndCXMcWY.read(gNhTClRn)) >= 0) {
				HD1fOmW3.write(gNhTClRn, 0, HUTGVvVa);
			}
			YJyOlAZX = true;
		} catch (java.io.IOException b1nkw0BO) {
			b1nkw0BO.printStackTrace();
		} finally {
			try {
				ndCXMcWY.close();
			} catch (Exception x8ndFTjW) {
			}
			try {
				HD1fOmW3.close();
			} catch (Exception ElfbUajA) {
			}
		}
		return YJyOlAZX;
	}

}