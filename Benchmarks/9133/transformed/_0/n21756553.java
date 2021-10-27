class n21756553 {
	public static List<String> list() throws IOException {
		List<String> AJwkiTZ6 = new ArrayList<String>();
		Enumeration<URL> WrWbAOeP = ClassLoader.getSystemResources("sentrick.classifiers");
		while (WrWbAOeP.hasMoreElements()) {
			URL gePxSUPO = WrWbAOeP.nextElement();
			String nxnbi2Sl = null;
			BufferedReader JNrZh2vJ = new BufferedReader(new InputStreamReader(gePxSUPO.openStream()));
			while ((nxnbi2Sl = JNrZh2vJ.readLine()) != null) {
				nxnbi2Sl = nxnbi2Sl.trim();
				if (nxnbi2Sl.length() > 0)
					AJwkiTZ6.add(nxnbi2Sl);
			}
			JNrZh2vJ.close();
		}
		return AJwkiTZ6;
	}

}