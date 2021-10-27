class n19498550 {
	public Constructor run() throws Exception {
		String eOBCCac4 = "META-INF/services/" + ComponentApplicationContext.class.getName();
		ClassLoader xdZvHjCV = Thread.currentThread().getContextClassLoader();
		final Enumeration<URL> oAsA9279;
		if (xdZvHjCV == null) {
			oAsA9279 = ComponentApplicationContext.class.getClassLoader().getResources(eOBCCac4);
		} else {
			oAsA9279 = xdZvHjCV.getResources(eOBCCac4);
		}
		while (oAsA9279.hasMoreElements()) {
			URL lBE1w0f6 = oAsA9279.nextElement();
			BufferedReader MZBg7yaB = new BufferedReader(new InputStreamReader(lBE1w0f6.openStream()));
			try {
				String QTWVhw9q = null;
				while ((QTWVhw9q = MZBg7yaB.readLine()) != null) {
					final String aLYzEyuQ = QTWVhw9q.trim();
					if (!aLYzEyuQ.startsWith("#") && !aLYzEyuQ.startsWith(";") && !aLYzEyuQ.startsWith("//")) {
						final Class<?> UKcxK394;
						if (xdZvHjCV == null) {
							UKcxK394 = Class.forName(aLYzEyuQ);
						} else {
							UKcxK394 = Class.forName(aLYzEyuQ, true, xdZvHjCV);
						}
						int bF7KH2YT = UKcxK394.getModifiers();
						if (ComponentApplicationContext.class.isAssignableFrom(UKcxK394)
								&& !Modifier.isAbstract(bF7KH2YT) && !Modifier.isInterface(bF7KH2YT)) {
							Constructor BiSrBRgV = UKcxK394.getDeclaredConstructor();
							if (!Modifier.isPublic(BiSrBRgV.getModifiers())) {
								BiSrBRgV.setAccessible(true);
							}
							return BiSrBRgV;
						} else {
							throw new ClassCastException(UKcxK394.getName());
						}
					}
				}
			} finally {
				MZBg7yaB.close();
			}
		}
		throw new ComponentApplicationException("No " + "ComponentApplicationContext implementation " + "found.");
	}

}