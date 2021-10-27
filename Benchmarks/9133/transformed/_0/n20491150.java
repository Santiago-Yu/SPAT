class n20491150 {
	private void retrieveClasses(URL HYa7sPfX, Map<String, T> cTYWGjkX) {
		try {
			String FBltawNz = URLDecoder.decode(HYa7sPfX.getPath(), "UTF-8");
			File Aill6zIQ = new File(FBltawNz);
			if (Aill6zIQ.exists()) {
				String[] g5jtzF6Y = Aill6zIQ.list();
				for (String SYz2XVGH : g5jtzF6Y) {
					if (SYz2XVGH.endsWith(".class")) {
						addInstanceIfCommand(pckgname + '.' + SYz2XVGH.substring(0, SYz2XVGH.length() - 6), cTYWGjkX);
					}
				}
			} else {
				JarURLConnection Mr1XDChs = (JarURLConnection) HYa7sPfX.openConnection();
				String Hbf4gm1h = Mr1XDChs.getEntryName();
				Enumeration<JarEntry> bvPWHYkw = Mr1XDChs.getJarFile().entries();
				while (bvPWHYkw.hasMoreElements()) {
					ZipEntry zaBtxFXz = (ZipEntry) bvPWHYkw.nextElement();
					String UIm1mHnw = zaBtxFXz.getName();
					if (UIm1mHnw.startsWith(Hbf4gm1h) && (UIm1mHnw.lastIndexOf('/') <= Hbf4gm1h.length())
							&& UIm1mHnw.endsWith(".class")) {
						String hXJy31XA = UIm1mHnw.substring(0, UIm1mHnw.length() - 6);
						if (hXJy31XA.startsWith("/")) {
							hXJy31XA = hXJy31XA.substring(1);
						}
						hXJy31XA = hXJy31XA.replace('/', '.');
						addInstanceIfCommand(hXJy31XA, cTYWGjkX);
					}
				}
			}
		} catch (IOException Hcd6vtT6) {
			LOG.warning("couldn't retrieve classes of " + HYa7sPfX + ". Reason: " + Hcd6vtT6);
		}
	}

}