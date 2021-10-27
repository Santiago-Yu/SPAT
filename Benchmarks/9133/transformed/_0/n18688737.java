class n18688737 {
	private void loadMascotLibrary() {
		if (isMascotLibraryLoaded)
			return;
		try {
			boolean puoNl6zz = false;
			boolean tUa8AK6J = false;
			String XsLNoq7N;
			if (Configurator.getOSName().toLowerCase().contains("linux")) {
				puoNl6zz = true;
			}
			if (Configurator.getOSArch().toLowerCase().contains("amd64")) {
				tUa8AK6J = true;
			}
			if (puoNl6zz) {
				if (tUa8AK6J) {
					XsLNoq7N = "libmsparserj-64.so";
				} else {
					XsLNoq7N = "libmsparserj-32.so";
				}
			} else {
				if (tUa8AK6J) {
					XsLNoq7N = "msparserj-64.dll";
				} else {
					XsLNoq7N = "msparserj-32.dll";
				}
			}
			logger.warn("Using: " + XsLNoq7N);
			URL xomPMagu = MascotDAO.class.getClassLoader().getResource(XsLNoq7N);
			if (xomPMagu != null) {
				logger.debug("Mascot library URL: " + xomPMagu);
				tmpMascotLibraryFile = File.createTempFile("libmascot.so.", ".tmp",
						new File(System.getProperty("java.io.tmpdir")));
				InputStream Ngzfanrr = xomPMagu.openStream();
				OutputStream jhYksj2G = new FileOutputStream(tmpMascotLibraryFile);
				IOUtils.copy(Ngzfanrr, jhYksj2G);
				Ngzfanrr.close();
				jhYksj2G.close();
				System.load(tmpMascotLibraryFile.getAbsolutePath());
				isMascotLibraryLoaded = true;
			} else {
				throw new ConverterException("Could not load Mascot Library for system: " + Configurator.getOSName()
						+ Configurator.getOSArch());
			}
		} catch (IOException RSwDZaPO) {
			throw new ConverterException("Error loading Mascot library: " + RSwDZaPO.getMessage(), RSwDZaPO);
		}
	}

}