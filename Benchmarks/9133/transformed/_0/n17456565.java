class n17456565 {
	public static boolean encodeFileToFile(String SqHXGjU8, String m1KowgLd) {
		boolean jqYsS0Bn = false;
		java.io.InputStream xIWOw7jM = null;
		java.io.OutputStream ht1s4rqz = null;
		try {
			xIWOw7jM = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(SqHXGjU8)),
					Base64.ENCODE);
			ht1s4rqz = new java.io.BufferedOutputStream(new java.io.FileOutputStream(m1KowgLd));
			byte[] DPSxO2YA = new byte[65536];
			int abKbKrPC = -1;
			while ((abKbKrPC = xIWOw7jM.read(DPSxO2YA)) >= 0) {
				ht1s4rqz.write(DPSxO2YA, 0, abKbKrPC);
			}
			jqYsS0Bn = true;
		} catch (java.io.IOException DIbzsiS5) {
			DIbzsiS5.printStackTrace();
		} finally {
			try {
				xIWOw7jM.close();
			} catch (Exception CJnjBYdB) {
			}
			try {
				ht1s4rqz.close();
			} catch (Exception mfg0Flnp) {
			}
		}
		return jqYsS0Bn;
	}

}