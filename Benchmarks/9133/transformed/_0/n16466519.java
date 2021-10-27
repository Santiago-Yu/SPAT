class n16466519 {
	public static boolean encodeFileToFile(String cSxvgpMc, String iD8at7WI) {
		boolean odNMKOFP = false;
		java.io.InputStream DIdWNHRZ = null;
		java.io.OutputStream PVghVErA = null;
		try {
			DIdWNHRZ = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(cSxvgpMc)),
					Base64.ENCODE);
			PVghVErA = new java.io.BufferedOutputStream(new java.io.FileOutputStream(iD8at7WI));
			byte[] o0GS8tsi = new byte[65536];
			int qubQ3VtV = -1;
			while ((qubQ3VtV = DIdWNHRZ.read(o0GS8tsi)) >= 0) {
				PVghVErA.write(o0GS8tsi, 0, qubQ3VtV);
			}
			odNMKOFP = true;
		} catch (java.io.IOException ciDTFJva) {
			ciDTFJva.printStackTrace();
		} finally {
			try {
				DIdWNHRZ.close();
			} catch (Exception a3KVwFng) {
			}
			try {
				PVghVErA.close();
			} catch (Exception S8FfcR5X) {
			}
		}
		return odNMKOFP;
	}

}