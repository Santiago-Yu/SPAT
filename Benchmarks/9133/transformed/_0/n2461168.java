class n2461168 {
	public static boolean encodeFileToFile(String L8jcG1Z6, String evw2S746) {
		boolean xEHEGL2V = false;
		java.io.InputStream T0Yi6p97 = null;
		java.io.OutputStream IyF4gX7r = null;
		try {
			T0Yi6p97 = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(L8jcG1Z6)),
					Base64.ENCODE);
			IyF4gX7r = new java.io.BufferedOutputStream(new java.io.FileOutputStream(evw2S746));
			byte[] sUXDK2tN = new byte[65536];
			int TcFWffpn = -1;
			while ((TcFWffpn = T0Yi6p97.read(sUXDK2tN)) >= 0) {
				IyF4gX7r.write(sUXDK2tN, 0, TcFWffpn);
			}
			xEHEGL2V = true;
		} catch (java.io.IOException vRcBZKIy) {
			vRcBZKIy.printStackTrace();
		} finally {
			try {
				T0Yi6p97.close();
			} catch (Exception eeUcT3q2) {
			}
			try {
				IyF4gX7r.close();
			} catch (Exception Zt7ALUBT) {
			}
		}
		return xEHEGL2V;
	}

}