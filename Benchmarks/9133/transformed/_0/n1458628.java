class n1458628 {
	public static boolean encodeFileToFile(String NvCUu4nK, String gtcroRz1) {
		boolean yG5b3BwJ = false;
		java.io.InputStream B0OLlUb2 = null;
		java.io.OutputStream frTxKExG = null;
		try {
			B0OLlUb2 = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(NvCUu4nK)),
					Base64.ENCODE);
			frTxKExG = new java.io.BufferedOutputStream(new java.io.FileOutputStream(gtcroRz1));
			byte[] Qf6QBgM6 = new byte[65536];
			int ececVeuj = -1;
			while ((ececVeuj = B0OLlUb2.read(Qf6QBgM6)) >= 0) {
				frTxKExG.write(Qf6QBgM6, 0, ececVeuj);
			}
			yG5b3BwJ = true;
		} catch (java.io.IOException uAuidK5G) {
			uAuidK5G.printStackTrace();
		} finally {
			try {
				B0OLlUb2.close();
			} catch (Exception liHboveA) {
			}
			try {
				frTxKExG.close();
			} catch (Exception ZqkjNK6w) {
			}
		}
		return yG5b3BwJ;
	}

}