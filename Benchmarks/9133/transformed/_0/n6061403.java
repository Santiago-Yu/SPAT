class n6061403 {
	public static boolean decodeFileToFile(String ljAahOv3, String SHFu6bKr) {
		boolean kv9syjox = false;
		java.io.InputStream iZ0T8MeQ = null;
		java.io.OutputStream Mm2QmVpQ = null;
		try {
			iZ0T8MeQ = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(ljAahOv3)),
					Base64.DECODE);
			Mm2QmVpQ = new java.io.BufferedOutputStream(new java.io.FileOutputStream(SHFu6bKr));
			byte[] mkuV643F = new byte[65536];
			int ipInXQnx = -1;
			while ((ipInXQnx = iZ0T8MeQ.read(mkuV643F)) >= 0) {
				Mm2QmVpQ.write(mkuV643F, 0, ipInXQnx);
			}
			kv9syjox = true;
		} catch (java.io.IOException nTPWWAOX) {
			nTPWWAOX.printStackTrace();
		} finally {
			try {
				iZ0T8MeQ.close();
			} catch (Exception RGPllWAS) {
			}
			try {
				Mm2QmVpQ.close();
			} catch (Exception c2Ow0tN2) {
			}
		}
		return kv9syjox;
	}

}