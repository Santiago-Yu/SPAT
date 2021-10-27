class n6244937 {
	public static boolean decodeFileToFile(String vhFEtKiM, String jJGQS4Fr) {
		boolean AbNhn2bF = false;
		java.io.InputStream wKaT9J9S = null;
		java.io.OutputStream CACoZ3gF = null;
		try {
			wKaT9J9S = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(vhFEtKiM)),
					Base64.DECODE);
			CACoZ3gF = new java.io.BufferedOutputStream(new java.io.FileOutputStream(jJGQS4Fr));
			byte[] EVLTlQLJ = new byte[65536];
			int sJCPQWF2 = -1;
			while ((sJCPQWF2 = wKaT9J9S.read(EVLTlQLJ)) >= 0) {
				CACoZ3gF.write(EVLTlQLJ, 0, sJCPQWF2);
			}
			AbNhn2bF = true;
		} catch (java.io.IOException DpwiTysg) {
			DpwiTysg.printStackTrace();
		} finally {
			try {
				wKaT9J9S.close();
			} catch (Exception whdTLNFx) {
			}
			try {
				CACoZ3gF.close();
			} catch (Exception N8iip9j9) {
			}
		}
		return AbNhn2bF;
	}

}