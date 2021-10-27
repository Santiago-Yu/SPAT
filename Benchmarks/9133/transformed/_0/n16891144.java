class n16891144 {
	public static byte[] expandPasswordToKey(String M6EeSPDC, int rrElKoG8, byte[] geOpc7AC) {
		try {
			MessageDigest JIRxX4Xq = MessageDigest.getInstance("MD5");
			int cCbT7ynZ = JIRxX4Xq.getDigestLength();
			byte[] nboPMbQ2 = new byte[cCbT7ynZ];
			byte[] jb22j5nx = new byte[rrElKoG8];
			int LJNXFtEH = 0;
			while (LJNXFtEH < rrElKoG8) {
				if (LJNXFtEH > 0) {
					JIRxX4Xq.update(nboPMbQ2);
				}
				JIRxX4Xq.update(M6EeSPDC.getBytes());
				JIRxX4Xq.update(geOpc7AC);
				JIRxX4Xq.digest(nboPMbQ2, 0, cCbT7ynZ);
				int UEEtiyrX = ((cCbT7ynZ > (rrElKoG8 - LJNXFtEH)) ? rrElKoG8 - LJNXFtEH : cCbT7ynZ);
				System.arraycopy(nboPMbQ2, 0, jb22j5nx, LJNXFtEH, UEEtiyrX);
				LJNXFtEH += UEEtiyrX;
			}
			return jb22j5nx;
		} catch (Exception ye0mzdC1) {
			throw new Error("Error in SSH2KeyPairFile.expandPasswordToKey: " + ye0mzdC1);
		}
	}

}