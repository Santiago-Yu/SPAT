class n11548511 {
	public static boolean decodeFileToFile(String LDz7CwEc, String eQHqnVJy) {
		boolean tOcarjY7 = false;
		java.io.InputStream Wp85J6lr = null;
		java.io.OutputStream junbeNK6 = null;
		try {
			Wp85J6lr = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(LDz7CwEc)),
					Base64.DECODE);
			junbeNK6 = new java.io.BufferedOutputStream(new java.io.FileOutputStream(eQHqnVJy));
			byte[] O5xehGxZ = new byte[65536];
			int FuO4Jdiq = -1;
			while ((FuO4Jdiq = Wp85J6lr.read(O5xehGxZ)) >= 0) {
				junbeNK6.write(O5xehGxZ, 0, FuO4Jdiq);
			}
			tOcarjY7 = true;
		} catch (java.io.IOException GcTvfZTu) {
			GcTvfZTu.printStackTrace();
		} finally {
			try {
				Wp85J6lr.close();
			} catch (Exception l71rbWPP) {
			}
			try {
				junbeNK6.close();
			} catch (Exception JvyC7ReZ) {
			}
		}
		return tOcarjY7;
	}

}