class n21870536 {
	public static boolean encodeFileToFile(String poYb6b5u, String G0Gkp3Nz) {
		boolean OLnTumEr = false;
		java.io.InputStream BrcVaAzw = null;
		java.io.OutputStream Y13sU53P = null;
		try {
			BrcVaAzw = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(poYb6b5u)),
					Base64.ENCODE);
			Y13sU53P = new java.io.BufferedOutputStream(new java.io.FileOutputStream(G0Gkp3Nz));
			byte[] Txhcq8za = new byte[65536];
			int yEc3a1tb = -1;
			while ((yEc3a1tb = BrcVaAzw.read(Txhcq8za)) >= 0) {
				Y13sU53P.write(Txhcq8za, 0, yEc3a1tb);
			}
			OLnTumEr = true;
		} catch (java.io.IOException USyIkObq) {
			USyIkObq.printStackTrace();
		} finally {
			try {
				BrcVaAzw.close();
			} catch (Exception QBPHMLAd) {
			}
			try {
				Y13sU53P.close();
			} catch (Exception frDgddru) {
			}
		}
		return OLnTumEr;
	}

}