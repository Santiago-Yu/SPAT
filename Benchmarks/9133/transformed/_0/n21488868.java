class n21488868 {
	public static boolean encodeFileToFile(String MVlaY6JN, String V8qKYdAH) {
		boolean CFeFIp0E = false;
		java.io.InputStream xLBobkut = null;
		java.io.OutputStream UqZrGnCC = null;
		try {
			xLBobkut = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(MVlaY6JN)),
					Base64.ENCODE);
			UqZrGnCC = new java.io.BufferedOutputStream(new java.io.FileOutputStream(V8qKYdAH));
			byte[] BGECihf0 = new byte[65536];
			int IO9igBKf = -1;
			while ((IO9igBKf = xLBobkut.read(BGECihf0)) >= 0) {
				UqZrGnCC.write(BGECihf0, 0, IO9igBKf);
			}
			CFeFIp0E = true;
		} catch (java.io.IOException fBe6EgDb) {
			fBe6EgDb.printStackTrace();
		} finally {
			try {
				xLBobkut.close();
			} catch (Exception GdePd8UC) {
			}
			try {
				UqZrGnCC.close();
			} catch (Exception ltd8vGn5) {
			}
		}
		return CFeFIp0E;
	}

}