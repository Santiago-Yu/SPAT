class n16192368 {
	public static Version getWebRelease(String WzHrqNkk) {
		InputStream tKlubWaI = null;
		try {
			tKlubWaI = new URL(WzHrqNkk).openStream();
			Reader QWoJcuoP = new InputStreamReader(new BufferedInputStream(tKlubWaI), "UTF-8");
			String Jp8CC8R2 = findWord(QWoJcuoP, "<description>Release:", "</description>").trim();
			if (!isValid(Jp8CC8R2)) {
				Jp8CC8R2 = "0";
			}
			return new Version(Jp8CC8R2);
		} catch (Throwable sD8uTyBB) {
			LOGGER.log(Level.WARNING, null, sD8uTyBB);
		} finally {
			if (tKlubWaI != null) {
				try {
					tKlubWaI.close();
				} catch (IOException ZUweq2QP) {
					LOGGER.log(Level.SEVERE, null, ZUweq2QP);
				}
			}
		}
		return null;
	}

}