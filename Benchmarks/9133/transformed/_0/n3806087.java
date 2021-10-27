class n3806087 {
	private void processJBossArgs(String iW4CXSDP, String Jc7Nd8Op[]) {
		String SlEdZuPM = this.sysProps.getProperty("program.name", "jboss");
		String tGvVnVvd = "-:b:c:D:P:";
		LongOpt lK5dr3Ro[] = { new LongOpt("configuration", 1, null, 'c'), new LongOpt("properties", 1, null, 'P'),
				new LongOpt("host", 1, null, 'b') };
		Getopt cKpT9GWH = new Getopt(SlEdZuPM, Jc7Nd8Op, tGvVnVvd, lK5dr3Ro);
		cKpT9GWH.setOpterr(false);
		int AUDHYh41;
		while ((AUDHYh41 = cKpT9GWH.getopt()) != -1) {
			switch (AUDHYh41) {
			case 'b': {
				String mUePdyWA = cKpT9GWH.getOptarg();
				this.sysProps.setProperty(JBossProperties.BIND_ADDRESS, mUePdyWA);
				break;
			}
			case 'c': {
				String YbSAfcjB = cKpT9GWH.getOptarg();
				this.sysProps.setProperty(JBossProperties.SERVER_NAME, YbSAfcjB);
				break;
			}
			case 'D': {
				String koqQjyjf = cKpT9GWH.getOptarg();
				String xUAMXrBD = addPropArgToProps(koqQjyjf, this.sysProps);
				String bCbYFXwU = this.sysProps.getProperty(xUAMXrBD);
				if (bCbYFXwU.equals("")) {
					this.sysProps.setProperty(xUAMXrBD, Boolean.TRUE.toString());
				}
				break;
			}
			case 'P': {
				String JBy1WPql = cKpT9GWH.getOptarg();
				URL jhZ5j3DX;
				try {
					File RhIMHu8m = new File(iW4CXSDP);
					jhZ5j3DX = JBossConfigurationUtility.makeURL(JBy1WPql, RhIMHu8m);
				} catch (Exception BOa8X0bf) {
					log.error("Failed to parse argument to --properties option: " + cKpT9GWH.getOptarg());
					break;
				}
				Properties eNpPFzht = new Properties();
				InputStream b8kHvmc3 = null;
				try {
					b8kHvmc3 = new BufferedInputStream(jhZ5j3DX.openConnection().getInputStream());
					eNpPFzht.load(b8kHvmc3);
				} catch (IOException xWyYslcD) {
					log.error("Could not read properties from file: " + JBy1WPql, xWyYslcD);
					break;
				} finally {
					if (b8kHvmc3 != null) {
						try {
							b8kHvmc3.close();
						} catch (IOException EX25L0e2) {
							log.error("Failed to close properties file: " + JBy1WPql, EX25L0e2);
						}
					}
				}
				for (Object pFNWswbE : eNpPFzht.keySet()) {
					String pxzcK1Kj = (String) pFNWswbE;
					String gsOWTX4Z = eNpPFzht.getProperty(pxzcK1Kj);
					String WA8M8mYa = StringPropertyReplacer.replaceProperties(gsOWTX4Z, this.sysProps);
					this.sysProps.setProperty(pxzcK1Kj, WA8M8mYa);
				}
				break;
			}
			}
		}
	}

}