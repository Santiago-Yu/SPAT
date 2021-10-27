class n15236847 {
	private static MapEntry<String, Properties> loadFpmConf() throws ConfigurationReadException {
		Scanner sc = new Scanner(CONF_PATHS).useDelimiter(SEP_P);
		MapEntry<String, Properties> ret = null;
		String prev = "";
		while (sc.hasNext() && !hasLoaded) {
			boolean relative = false;
			Properties fpmConf = null;
			String path = sc.next();
			if (path.startsWith(PREV_P)) {
				path = path.replace(PREV_P, prev.substring(0, prev.length() - 1));
			} else if (path.startsWith(REL_P)) {
				relative = true;
				path = path.replace(REL_P + FS, "");
			} else if (path.contains(HOME_P)) {
				path = path.replace(HOME_P, USER_HOME);
			}
			prev = path;
			path = path.concat(MAIN_CONF_FILE);
			try {
				InputStream is = null;
				fpmConf = new Properties();
				if (relative) {
					is = ClassLoader.getSystemResourceAsStream(path);
					path = getSystemConfDir();
					Strings.getOne().createPath(path);
					path += MAIN_CONF_FILE;
					FileOutputStream os = new FileOutputStream(path);
					IOUtils.copy(is, os);
					os.flush();
					os.close();
					os = null;
				} else {
					is = new FileInputStream(path);
				}
				fpmConf.load(is);
				if (fpmConf.isEmpty()) {
					throw new ConfigurationReadException();
				}
				hasLoaded = true;
				ret = new MapEntry<String, Properties>(path, fpmConf);
			} catch (FileNotFoundException e) {
				singleton = null;
				fpmConf = null;
				hasLoaded = false;
			} catch (IOException e) {
				throw new ConfigurationReadException();
			}
		}
		return ret;
	}

}