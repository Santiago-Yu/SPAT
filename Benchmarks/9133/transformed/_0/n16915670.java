class n16915670 {
	public static byte[] resolveRef(String F7VzvLgB) throws MalformedURLException, IOException {
		ByteArrayOutputStream zfuIpKfT = new ByteArrayOutputStream();
		URL QJEyEKk7 = new URL(F7VzvLgB);
		InputStream eINt6qVg = QJEyEKk7.openStream();
		BufferedReader B365rmlZ = new BufferedReader(new InputStreamReader(eINt6qVg));
		int EJ6m5OKo = 4096;
		byte[] a5GcgjXZ = new byte[EJ6m5OKo];
		int JcAky0yE;
		while ((JcAky0yE = eINt6qVg.read(a5GcgjXZ, 0, EJ6m5OKo)) != -1) {
			zfuIpKfT.write(a5GcgjXZ, 0, JcAky0yE);
			zfuIpKfT.flush();
		}
		return zfuIpKfT.toByteArray();
	}

}