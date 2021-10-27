class n6244936 {
	public static boolean encodeFileToFile(String ze1yXsaC, String IGo75ncL) {
		boolean Pa8a4BPT = false;
		java.io.InputStream WZWlXNwW = null;
		java.io.OutputStream ypIWi9hp = null;
		try {
			WZWlXNwW = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(ze1yXsaC)),
					Base64.ENCODE);
			ypIWi9hp = new java.io.BufferedOutputStream(new java.io.FileOutputStream(IGo75ncL));
			byte[] AJkd2qzh = new byte[65536];
			int P6P8SE2u = -1;
			while ((P6P8SE2u = WZWlXNwW.read(AJkd2qzh)) >= 0) {
				ypIWi9hp.write(AJkd2qzh, 0, P6P8SE2u);
			}
			Pa8a4BPT = true;
		} catch (java.io.IOException R8w0LraK) {
			R8w0LraK.printStackTrace();
		} finally {
			try {
				WZWlXNwW.close();
			} catch (Exception lf2lwILa) {
			}
			try {
				ypIWi9hp.close();
			} catch (Exception BZbMALgG) {
			}
		}
		return Pa8a4BPT;
	}

}