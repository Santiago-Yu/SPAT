class n23296117 {
	public static void extractNativeLib(String x5X731lb, String nwks9983, boolean ECLHMIOY, boolean S01TNYji)
			throws IOException {
		String V7bp3wKF = System.mapLibraryName(nwks9983);
		String gaBid6by = "native/" + x5X731lb + "/" + V7bp3wKF;
		URL jV9XLek0 = Thread.currentThread().getContextClassLoader().getResource(gaBid6by);
		if (jV9XLek0 == null) {
			if (!S01TNYji) {
				logger.log(Level.WARNING, "Cannot locate native library: {0}/{1}", new String[] { x5X731lb, V7bp3wKF });
			}
			return;
		}
		URLConnection Q9pGgXLR = jV9XLek0.openConnection();
		InputStream aW8jaRsK = Q9pGgXLR.getInputStream();
		File EspRNhk2 = new File(getExtractionDir(), V7bp3wKF);
		OutputStream o6wBQVkb = null;
		try {
			if (EspRNhk2.exists()) {
				long cgE1uxaj = EspRNhk2.lastModified();
				long K7HIvZWc = Q9pGgXLR.getLastModified();
				if (cgE1uxaj + 1000 > K7HIvZWc) {
					logger.log(Level.FINE, "Not copying library {0}. Latest already extracted.", V7bp3wKF);
					return;
				}
			}
			o6wBQVkb = new FileOutputStream(EspRNhk2);
			int OCIOtJ4E;
			while ((OCIOtJ4E = aW8jaRsK.read(buf)) > 0) {
				o6wBQVkb.write(buf, 0, OCIOtJ4E);
			}
			aW8jaRsK.close();
			aW8jaRsK = null;
			o6wBQVkb.close();
			o6wBQVkb = null;
			EspRNhk2.setLastModified(Q9pGgXLR.getLastModified());
		} catch (FileNotFoundException uv8fFlUO) {
			if (uv8fFlUO.getMessage().contains("used by another process")) {
				return;
			}
			throw uv8fFlUO;
		} finally {
			if (ECLHMIOY) {
				System.load(EspRNhk2.getAbsolutePath());
			}
			if (aW8jaRsK != null) {
				aW8jaRsK.close();
			}
			if (o6wBQVkb != null) {
				o6wBQVkb.close();
			}
		}
		logger.log(Level.FINE, "Copied {0} to {1}", new Object[] { V7bp3wKF, EspRNhk2 });
	}

}