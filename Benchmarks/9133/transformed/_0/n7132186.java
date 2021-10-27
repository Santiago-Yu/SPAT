class n7132186 {
	public static boolean decodeFileToFile(String yGMwubtT, String yTS3z9sR) {
		boolean DcEae8LL = false;
		java.io.InputStream MuAhGTKG = null;
		java.io.OutputStream ydlt8ebX = null;
		try {
			MuAhGTKG = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(yGMwubtT)),
					Base64.DECODE);
			ydlt8ebX = new java.io.BufferedOutputStream(new java.io.FileOutputStream(yTS3z9sR));
			byte[] d8s6cCDj = new byte[65536];
			int sLjUijH6 = -1;
			while ((sLjUijH6 = MuAhGTKG.read(d8s6cCDj)) >= 0) {
				ydlt8ebX.write(d8s6cCDj, 0, sLjUijH6);
			}
			DcEae8LL = true;
		} catch (java.io.IOException MpZScqbA) {
			MpZScqbA.printStackTrace();
		} finally {
			try {
				MuAhGTKG.close();
			} catch (Exception zRH7MGQ7) {
			}
			try {
				ydlt8ebX.close();
			} catch (Exception azzku4Vc) {
			}
		}
		return DcEae8LL;
	}

}