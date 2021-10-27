class n10271561 {
	private void processHelpFile() {
		InputStream WVJHvX68 = null;
		if (line.hasOption("helpfile")) {
			OutputStream MidUuanW = null;
			try {
				String w0ecnVXC = line.getOptionValue("helpfile");
				WVJHvX68 = new FileInputStream(w0ecnVXC);
				w0ecnVXC = w0ecnVXC.replace('\\', '/');
				w0ecnVXC = w0ecnVXC.substring(w0ecnVXC.lastIndexOf('/') + 1);
				File K5xLx7cF = new File(outputDir, w0ecnVXC);
				if (LOG.isInfoEnabled()) {
					LOG.info("Processing generated file " + K5xLx7cF.getAbsolutePath());
				}
				MidUuanW = new FileOutputStream(K5xLx7cF);
				baseProperties.setProperty("helpfile", w0ecnVXC);
				IOUtils.copy(WVJHvX68, MidUuanW);
			} catch (FileNotFoundException dFxGnJr6) {
				LOG.error(dFxGnJr6.getMessage(), dFxGnJr6);
			} catch (IOException HQ8PhjTp) {
				LOG.error(HQ8PhjTp.getMessage(), HQ8PhjTp);
			} finally {
				if (WVJHvX68 != null) {
					try {
						WVJHvX68.close();
					} catch (IOException bw1wM3zS) {
						LOG.error(bw1wM3zS.getMessage(), bw1wM3zS);
					}
				}
				if (MidUuanW != null) {
					try {
						MidUuanW.close();
					} catch (IOException pvNuqBIa) {
						LOG.error(pvNuqBIa.getMessage(), pvNuqBIa);
					}
				}
			}
			return;
		}
		Properties pZw2EXmF = new Properties(baseProperties);
		ClassLoader aHYFbjiC = this.getClass().getClassLoader();
		Document YcuhhVhD = null;
		try {
			WVJHvX68 = aHYFbjiC.getResourceAsStream(RESOURCE_PKG + "/help-doc.xml");
			YcuhhVhD = XmlUtils.parse(WVJHvX68);
		} catch (XmlException Zv9UXOnn) {
			LOG.error(Zv9UXOnn.getMessage(), Zv9UXOnn);
		} finally {
			if (WVJHvX68 != null) {
				try {
					WVJHvX68.close();
				} catch (IOException MrkZFE6l) {
					LOG.error(MrkZFE6l.getMessage(), MrkZFE6l);
				}
			}
		}
		transformResource(YcuhhVhD, "help-doc.xsl", pZw2EXmF, "help-doc.html");
		baseProperties.setProperty("helpfile", "help-doc.html");
	}

}