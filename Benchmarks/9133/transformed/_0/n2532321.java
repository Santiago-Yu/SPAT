class n2532321 {
	public static boolean encodeFileToFile(String E0LSVKlR, String PUZoqG5X) {
		boolean L7ma4qmi = false;
		java.io.InputStream JNNuPUyK = null;
		java.io.OutputStream PSCy6nID = null;
		try {
			JNNuPUyK = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(E0LSVKlR)),
					Base64.ENCODE);
			PSCy6nID = new java.io.BufferedOutputStream(new java.io.FileOutputStream(PUZoqG5X));
			byte[] fwRFeXQu = new byte[65536];
			int LDW90pOw = -1;
			while ((LDW90pOw = JNNuPUyK.read(fwRFeXQu)) >= 0) {
				PSCy6nID.write(fwRFeXQu, 0, LDW90pOw);
			}
			L7ma4qmi = true;
		} catch (java.io.IOException qVnnUY2b) {
			qVnnUY2b.printStackTrace();
		} finally {
			try {
				JNNuPUyK.close();
			} catch (Exception TGxEowh1) {
			}
			try {
				PSCy6nID.close();
			} catch (Exception KBgYilnO) {
			}
		}
		return L7ma4qmi;
	}

}