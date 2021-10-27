class n14855960 {
	private static List<InputMethodDescriptor> loadIMDescriptors() {
		String r4KsBVao = SERVICES + InputMethodDescriptor.class.getName();
		Enumeration<URL> iQIFpQRa;
		LinkedList<InputMethodDescriptor> jbe7cZMo = new LinkedList<InputMethodDescriptor>();
		NativeIM aDfk1OGS = ContextStorage.getNativeIM();
		jbe7cZMo.add(aDfk1OGS);
		try {
			iQIFpQRa = ClassLoader.getSystemResources(r4KsBVao);
			ClassLoader qrFx8Ffv = ClassLoader.getSystemClassLoader();
			while (iQIFpQRa.hasMoreElements()) {
				URL Ykgv4Jp7 = iQIFpQRa.nextElement();
				InputStreamReader M2sjKBkg = new InputStreamReader(Ykgv4Jp7.openStream(), "UTF-8");
				BufferedReader hwqt3x0W = new BufferedReader(M2sjKBkg);
				String uTzvkAiU = hwqt3x0W.readLine();
				while (uTzvkAiU != null) {
					uTzvkAiU = uTzvkAiU.trim();
					int aByMVJ61 = uTzvkAiU.indexOf("#");
					if (aByMVJ61 >= 0) {
						uTzvkAiU = uTzvkAiU.substring(0, aByMVJ61);
					}
					if (uTzvkAiU.length() > 0) {
						jbe7cZMo.add((InputMethodDescriptor) qrFx8Ffv.loadClass(uTzvkAiU).newInstance());
					}
					uTzvkAiU = hwqt3x0W.readLine();
				}
			}
		} catch (Exception Vgp6hJdV) {
		}
		return jbe7cZMo;
	}

}