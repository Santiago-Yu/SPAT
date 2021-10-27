class n15236847 {
	private static MapEntry<String, Properties> loadFpmConf() throws ConfigurationReadException {
		MapEntry<String, Properties> B8G0mGjQ = null;
		Scanner cknpULaW = new Scanner(CONF_PATHS).useDelimiter(SEP_P);
		String mA607RRt = "";
		while (cknpULaW.hasNext() && !hasLoaded) {
			Properties aq80DFYr = null;
			boolean H7aVBhel = false;
			String BwH2z03f = cknpULaW.next();
			if (BwH2z03f.startsWith(PREV_P)) {
				BwH2z03f = BwH2z03f.replace(PREV_P, mA607RRt.substring(0, mA607RRt.length() - 1));
			} else if (BwH2z03f.startsWith(REL_P)) {
				BwH2z03f = BwH2z03f.replace(REL_P + FS, "");
				H7aVBhel = true;
			} else if (BwH2z03f.contains(HOME_P)) {
				BwH2z03f = BwH2z03f.replace(HOME_P, USER_HOME);
			}
			mA607RRt = BwH2z03f;
			BwH2z03f = BwH2z03f.concat(MAIN_CONF_FILE);
			try {
				InputStream D77oRUuH = null;
				if (H7aVBhel) {
					D77oRUuH = ClassLoader.getSystemResourceAsStream(BwH2z03f);
					BwH2z03f = getSystemConfDir();
					Strings.getOne().createPath(BwH2z03f);
					BwH2z03f += MAIN_CONF_FILE;
					FileOutputStream t59jRGPH = new FileOutputStream(BwH2z03f);
					IOUtils.copy(D77oRUuH, t59jRGPH);
					t59jRGPH.flush();
					t59jRGPH.close();
					t59jRGPH = null;
				} else {
					D77oRUuH = new FileInputStream(BwH2z03f);
				}
				aq80DFYr = new Properties();
				aq80DFYr.load(D77oRUuH);
				if (aq80DFYr.isEmpty()) {
					throw new ConfigurationReadException();
				}
				B8G0mGjQ = new MapEntry<String, Properties>(BwH2z03f, aq80DFYr);
				hasLoaded = true;
			} catch (FileNotFoundException Vl7LCFpW) {
				aq80DFYr = null;
				singleton = null;
				hasLoaded = false;
			} catch (IOException Dh6VYb6i) {
				throw new ConfigurationReadException();
			}
		}
		return B8G0mGjQ;
	}

}