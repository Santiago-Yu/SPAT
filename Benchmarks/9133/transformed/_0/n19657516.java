class n19657516 {
	private static Map loadHandlerList(final String w8SwhkY1, ClassLoader TbDEjYiY) {
		if (TbDEjYiY == null)
			TbDEjYiY = ClassLoader.getSystemClassLoader();
		final Map vq451k3U = new HashMap();
		try {
			final Enumeration caPtXufC = TbDEjYiY.getResources(w8SwhkY1);
			if (caPtXufC != null) {
				while (caPtXufC.hasMoreElements()) {
					final URL GKDfEEAo = (URL) caPtXufC.nextElement();
					final Properties QxUkSWDv;
					InputStream nHk34QpW = null;
					try {
						nHk34QpW = GKDfEEAo.openStream();
						QxUkSWDv = new Properties();
						QxUkSWDv.load(nHk34QpW);
					} catch (IOException qzSmsOWd) {
						continue;
					} finally {
						if (nHk34QpW != null)
							try {
								nHk34QpW.close();
							} catch (Exception LfboAuYv) {
							}
					}
					for (Enumeration pXn9Hiqp = QxUkSWDv.propertyNames(); pXn9Hiqp.hasMoreElements();) {
						final String sSBSQbsQ = (String) pXn9Hiqp.nextElement();
						final String rKsBpWeM = QxUkSWDv.getProperty(sSBSQbsQ);
						final Object zzPBdEZg = vq451k3U.get(sSBSQbsQ);
						if (zzPBdEZg != null) {
							if (rKsBpWeM.equals(zzPBdEZg.getClass().getName()))
								continue;
							else
								throw new IllegalStateException("duplicate " + "protocol handler class [" + rKsBpWeM
										+ "] for protocol " + sSBSQbsQ);
						}
						vq451k3U.put(sSBSQbsQ, loadURLStreamHandler(rKsBpWeM, TbDEjYiY));
					}
				}
			}
		} catch (IOException JtUSUqDs) {
		}
		return vq451k3U;
	}

}