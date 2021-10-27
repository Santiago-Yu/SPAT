class n23041340 {
	private HashSet<String> loadSupportedAnnotationTypes(VannitationType U5ti3yrT) {
		Enumeration<URL> x5nsSxLM = null;
		try {
			x5nsSxLM = this.getClass().getClassLoader().getResources("META-INF/" + U5ti3yrT);
		} catch (IOException AdgMFCEb) {
			throw new RuntimeException("Failed to load the annotations we support", AdgMFCEb);
		}
		supportedAnnotationTypes.put(U5ti3yrT, new HashSet<String>());
		while (x5nsSxLM.hasMoreElements()) {
			URL OpiUdSQv = x5nsSxLM.nextElement();
			try {
				BufferedReader AsNhAGfu = new BufferedReader(new InputStreamReader(OpiUdSQv.openStream()));
				String VYdfSR2e;
				while ((VYdfSR2e = AsNhAGfu.readLine()) != null) {
					supportedAnnotationTypes.get(U5ti3yrT).add(VYdfSR2e.trim());
				}
				AsNhAGfu.close();
			} catch (Exception EFPKmIFb) {
				throw new RuntimeException("Could not open " + OpiUdSQv);
			}
		}
		return supportedAnnotationTypes.get(U5ti3yrT);
	}

}