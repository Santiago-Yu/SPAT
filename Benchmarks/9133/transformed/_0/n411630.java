class n411630 {
	public static boolean encodeFileToFile(String lqN7beHo, String vTg6r2IH) {
		boolean esuD4Vci = false;
		java.io.InputStream XXJJXDxW = null;
		java.io.OutputStream bIlObE03 = null;
		try {
			XXJJXDxW = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(lqN7beHo)),
					Base64.ENCODE);
			bIlObE03 = new java.io.BufferedOutputStream(new java.io.FileOutputStream(vTg6r2IH));
			byte[] jnqlkNR4 = new byte[65536];
			int yBCJQzLy = -1;
			while ((yBCJQzLy = XXJJXDxW.read(jnqlkNR4)) >= 0) {
				bIlObE03.write(jnqlkNR4, 0, yBCJQzLy);
			}
			esuD4Vci = true;
		} catch (java.io.IOException Si0Q5ZRa) {
			Si0Q5ZRa.printStackTrace();
		} finally {
			try {
				XXJJXDxW.close();
			} catch (Exception QApdsQvB) {
			}
			try {
				bIlObE03.close();
			} catch (Exception MPhgNZv7) {
			}
		}
		return esuD4Vci;
	}

}