class n12646521 {
	public boolean check(int ZVKwxps9) {
		StringBuilder XAc9MmCy = null;
		java.net.URL Mcfv59lA;
		java.io.InputStream Er4P53VG = null;
		try {
			Mcfv59lA = new java.net.URL(location + "/prisms?method=test");
			java.net.URLConnection FXdFsplw = Mcfv59lA.openConnection();
			FXdFsplw.setConnectTimeout(ZVKwxps9);
			Er4P53VG = FXdFsplw.getInputStream();
			java.io.Reader osnhgI26 = new java.io.InputStreamReader(Er4P53VG);
			XAc9MmCy = new StringBuilder();
			int BeNIa1MR = osnhgI26.read();
			while (BeNIa1MR >= 0) {
				XAc9MmCy.append((char) BeNIa1MR);
				BeNIa1MR = osnhgI26.read();
			}
		} catch (java.io.IOException kzq7bA1y) {
			log.error("Instance check failed", kzq7bA1y);
			if (Er4P53VG != null)
				try {
					Er4P53VG.close();
				} catch (java.io.IOException aEG5V1Qt) {
				}
		}
		return XAc9MmCy != null && XAc9MmCy.toString().startsWith("success");
	}

}