class n2190569 {
	public static void copyFileStreams(File i1ThgGkR, File bWVcYC7i) throws IOException {
		if (!i1ThgGkR.exists()) {
			return;
		}
		FileInputStream DMDuygBa = new FileInputStream(i1ThgGkR);
		FileOutputStream DGgLNqLY = new FileOutputStream(bWVcYC7i);
		int vNT1ZK2x = 0;
		byte[] IhFqXJSO = new byte[1024];
		while (-1 != vNT1ZK2x) {
			vNT1ZK2x = DMDuygBa.read(IhFqXJSO);
			if (vNT1ZK2x >= 0) {
				DGgLNqLY.write(IhFqXJSO, 0, vNT1ZK2x);
			}
		}
		DGgLNqLY.close();
		DMDuygBa.close();
	}

}