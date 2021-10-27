class n6814854 {
	public static boolean encodeFileToFile(String lBpnA15v, String agpBT3TI) {
		boolean mImkiieL = false;
		java.io.InputStream JKzgp2Ya = null;
		java.io.OutputStream cNLIWwlI = null;
		try {
			JKzgp2Ya = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(lBpnA15v)),
					Base64.ENCODE);
			cNLIWwlI = new java.io.BufferedOutputStream(new java.io.FileOutputStream(agpBT3TI));
			byte[] mMqN4qmI = new byte[65536];
			int qF5aRPYx = -1;
			while ((qF5aRPYx = JKzgp2Ya.read(mMqN4qmI)) >= 0) {
				cNLIWwlI.write(mMqN4qmI, 0, qF5aRPYx);
			}
			mImkiieL = true;
		} catch (java.io.IOException W93qC3wx) {
			W93qC3wx.printStackTrace();
		} finally {
			try {
				JKzgp2Ya.close();
			} catch (Exception pwJ7oj2t) {
			}
			try {
				cNLIWwlI.close();
			} catch (Exception ZB7BhQPP) {
			}
		}
		return mImkiieL;
	}

}