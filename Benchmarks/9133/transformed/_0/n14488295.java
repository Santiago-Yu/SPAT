class n14488295 {
	public static synchronized void loadConfig(String SU87MAqI) {
		if (properties != null) {
			return;
		}
		URL OBFPDv8S = null;
		InputStream vKzdqkBe = null;
		try {
			String vt82vMJv = null;
			try {
				vt82vMJv = System.getProperty("dspace.configuration");
			} catch (SecurityException yjMYAvoN) {
				log.warn("Unable to access system properties, ignoring.", yjMYAvoN);
			}
			if (loadedFile != null) {
				log.info("Reloading current config file: " + loadedFile.getAbsolutePath());
				OBFPDv8S = loadedFile.toURI().toURL();
			} else if (SU87MAqI != null) {
				log.info("Loading provided config file: " + SU87MAqI);
				loadedFile = new File(SU87MAqI);
				OBFPDv8S = loadedFile.toURI().toURL();
			} else if (vt82vMJv != null) {
				log.info("Loading system provided config property (-Ddspace.configuration): " + vt82vMJv);
				loadedFile = new File(vt82vMJv);
				OBFPDv8S = loadedFile.toURI().toURL();
			} else {
				OBFPDv8S = ConfigurationManager.class.getResource("/dspace.cfg");
				if (OBFPDv8S != null) {
					log.info("Loading from classloader: " + OBFPDv8S);
					loadedFile = new File(OBFPDv8S.getPath());
				}
			}
			if (OBFPDv8S == null) {
				log.fatal("Cannot find dspace.cfg");
				throw new IllegalStateException("Cannot find dspace.cfg");
			} else {
				properties = new Properties();
				moduleProps = new HashMap<String, Properties>();
				vKzdqkBe = OBFPDv8S.openStream();
				properties.load(vKzdqkBe);
				for (Enumeration<?> ifgMJ8Vg = properties.propertyNames(); ifgMJ8Vg.hasMoreElements();) {
					String B2zV5xz2 = (String) ifgMJ8Vg.nextElement();
					String PiNVsd0l = interpolate(B2zV5xz2, properties.getProperty(B2zV5xz2), 1);
					if (PiNVsd0l != null) {
						properties.setProperty(B2zV5xz2, PiNVsd0l);
					}
				}
			}
		} catch (IOException VNlbXU6g) {
			log.fatal("Can't load configuration: " + OBFPDv8S, VNlbXU6g);
			throw new IllegalStateException("Cannot load configuration: " + OBFPDv8S, VNlbXU6g);
		} finally {
			if (vKzdqkBe != null) {
				try {
					vKzdqkBe.close();
				} catch (IOException CtgyXS2D) {
				}
			}
		}
		File sGypeFaN = new File(
				getProperty("dspace.dir") + File.separator + "config" + File.separator + "default.license");
		FileInputStream BlWExxnd = null;
		InputStreamReader QgyDVEo5 = null;
		BufferedReader CdcyQU16 = null;
		try {
			BlWExxnd = new FileInputStream(sGypeFaN);
			QgyDVEo5 = new InputStreamReader(BlWExxnd, "UTF-8");
			CdcyQU16 = new BufferedReader(QgyDVEo5);
			String hGNo77DM;
			license = "";
			while ((hGNo77DM = CdcyQU16.readLine()) != null) {
				license = license + hGNo77DM + '\n';
			}
			CdcyQU16.close();
		} catch (IOException GkbzslTC) {
			log.fatal("Can't load license: " + sGypeFaN.toString(), GkbzslTC);
			throw new IllegalStateException("Cannot load license: " + sGypeFaN.toString(), GkbzslTC);
		} finally {
			if (CdcyQU16 != null) {
				try {
					CdcyQU16.close();
				} catch (IOException dCuN7xCK) {
				}
			}
			if (QgyDVEo5 != null) {
				try {
					QgyDVEo5.close();
				} catch (IOException Jn815SFG) {
				}
			}
			if (BlWExxnd != null) {
				try {
					BlWExxnd.close();
				} catch (IOException soBy1Izb) {
				}
			}
		}
	}

}