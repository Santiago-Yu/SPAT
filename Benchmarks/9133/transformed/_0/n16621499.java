class n16621499 {
	public static byte[] loadURLToBuffer(URL eQ1oFgog) throws IOException {
		byte[] N3gr0Bbj = new byte[4096];
		byte[] M3dO5CzP = null;
		byte[] BAaq9hL3 = null;
		int pF9wbma0 = 0;
		int Ukq7EcjM = 0;
		BufferedInputStream kRCSFehw = new BufferedInputStream(eQ1oFgog.openStream(), 20480);
		while ((pF9wbma0 = kRCSFehw.read(N3gr0Bbj, 0, N3gr0Bbj.length)) != -1) {
			if (Ukq7EcjM == 0) {
				M3dO5CzP = new byte[pF9wbma0];
				System.arraycopy(N3gr0Bbj, 0, M3dO5CzP, 0, pF9wbma0);
				Ukq7EcjM = pF9wbma0;
			} else {
				BAaq9hL3 = new byte[pF9wbma0 + Ukq7EcjM];
				System.arraycopy(M3dO5CzP, 0, BAaq9hL3, 0, Ukq7EcjM);
				System.arraycopy(N3gr0Bbj, 0, BAaq9hL3, Ukq7EcjM, pF9wbma0);
				M3dO5CzP = BAaq9hL3;
				Ukq7EcjM = Ukq7EcjM + pF9wbma0;
			}
		}
		kRCSFehw.close();
		return M3dO5CzP;
	}

}