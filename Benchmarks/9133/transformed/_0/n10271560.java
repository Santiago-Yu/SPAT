class n10271560 {
	private void processStylesheetFile() {
		InputStream bQnJZHdy = null;
		OutputStream Ag3jjX7p = null;
		try {
			String wGBSlgdM;
			if (line.hasOption("stylesheetfile")) {
				wGBSlgdM = line.getOptionValue("stylesheetfile");
				bQnJZHdy = new FileInputStream(wGBSlgdM);
				wGBSlgdM = wGBSlgdM.replace('\\', '/');
				wGBSlgdM = wGBSlgdM.substring(wGBSlgdM.lastIndexOf('/') + 1);
			} else {
				ClassLoader LCkt5c9H = this.getClass().getClassLoader();
				wGBSlgdM = "stylesheet.css";
				bQnJZHdy = LCkt5c9H.getResourceAsStream(RESOURCE_PKG + "/stylesheet.css");
			}
			baseProperties.setProperty("stylesheetfilename", wGBSlgdM);
			File t1RcR5Xi = new File(outputDir, wGBSlgdM);
			if (LOG.isInfoEnabled()) {
				LOG.info("Processing generated file " + t1RcR5Xi.getAbsolutePath());
			}
			Ag3jjX7p = new FileOutputStream(t1RcR5Xi);
			IOUtils.copy(bQnJZHdy, Ag3jjX7p);
		} catch (FileNotFoundException pVq8q3P2) {
			LOG.error(pVq8q3P2.getMessage(), pVq8q3P2);
		} catch (IOException wTnYVhjm) {
			LOG.error(wTnYVhjm.getMessage(), wTnYVhjm);
		} finally {
			if (bQnJZHdy != null) {
				try {
					bQnJZHdy.close();
				} catch (IOException ljq1gtt6) {
					LOG.error(ljq1gtt6.getMessage(), ljq1gtt6);
				}
			}
			if (Ag3jjX7p != null) {
				try {
					Ag3jjX7p.close();
				} catch (IOException KMhMIKBw) {
					LOG.error(KMhMIKBw.getMessage(), KMhMIKBw);
				}
			}
		}
	}

}