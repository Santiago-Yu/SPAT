class n15203217 {
	static void getFileClient(String Xyo51eSh, String u1bQ5PcB, File[] uEmFreBA) throws IOException {
		byte[] OcHIwj6P = new byte[BUFFER_SIZE];
		StringBuffer KEZsWnc9 = new StringBuffer("http://" + Xyo51eSh + "/getimage?");
		KEZsWnc9.append(u1bQ5PcB);
		URL xYlGbnNB = new URL(KEZsWnc9.toString());
		URLConnection qlJVw8xL = xYlGbnNB.openConnection();
		InputStream YQ15mQkD = qlJVw8xL.getInputStream();
		FileOutputStream[] A75zDP3a = null;
		try {
			if (uEmFreBA != null) {
				A75zDP3a = new FileOutputStream[uEmFreBA.length];
				for (int HmEDCzIq = 0; HmEDCzIq < A75zDP3a.length; HmEDCzIq++) {
					A75zDP3a[HmEDCzIq] = new FileOutputStream(uEmFreBA[HmEDCzIq]);
				}
			}
			int A1JjBIXZ = 1;
			while (A1JjBIXZ > 0) {
				A1JjBIXZ = YQ15mQkD.read(OcHIwj6P);
				if (A1JjBIXZ > 0 && uEmFreBA != null) {
					for (int wErSjfMq = 0; wErSjfMq < A75zDP3a.length; wErSjfMq++) {
						A75zDP3a[wErSjfMq].write(OcHIwj6P, 0, A1JjBIXZ);
					}
				}
			}
		} finally {
			YQ15mQkD.close();
			if (A75zDP3a != null) {
				for (int gwGizOBQ = 0; gwGizOBQ < A75zDP3a.length; gwGizOBQ++) {
					if (A75zDP3a[gwGizOBQ] != null) {
						A75zDP3a[gwGizOBQ].close();
					}
				}
			}
		}
	}

}