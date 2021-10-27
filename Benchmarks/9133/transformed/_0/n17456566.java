class n17456566 {
	public static boolean decodeFileToFile(String J9UHYtd0, String j3t2NBD0) {
		boolean LKVyWckp = false;
		java.io.InputStream OJh50UzR = null;
		java.io.OutputStream VUMo9fLN = null;
		try {
			OJh50UzR = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(J9UHYtd0)),
					Base64.DECODE);
			VUMo9fLN = new java.io.BufferedOutputStream(new java.io.FileOutputStream(j3t2NBD0));
			byte[] SE1Er19s = new byte[65536];
			int Jt3ZmDDM = -1;
			while ((Jt3ZmDDM = OJh50UzR.read(SE1Er19s)) >= 0) {
				VUMo9fLN.write(SE1Er19s, 0, Jt3ZmDDM);
			}
			LKVyWckp = true;
		} catch (java.io.IOException zDdUmpl5) {
			zDdUmpl5.printStackTrace();
		} finally {
			try {
				OJh50UzR.close();
			} catch (Exception rjnY2MqM) {
			}
			try {
				VUMo9fLN.close();
			} catch (Exception TXs47ZFe) {
			}
		}
		return LKVyWckp;
	}

}