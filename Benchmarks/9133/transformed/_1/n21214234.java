class n21214234 {
	private PluginInfo loadPluginInfo(URL filename) throws PluginNotFoundException {
		if (filename == null)
			return null;
		BufferedReader in = null;
		InputStream is = null;
		String mainClass = null;
		String u = filename.toString();
		PluginInfo pi = new PluginInfo();
		URL url;
		try {
			url = new URL("jar:" + u + "!/");
		} catch (MalformedURLException mue) {
			throw new PluginNotFoundException(mue);
		}
		pi.setURL(filename);
		HashMap names = new HashMap();
		boolean seemsOK = false;
		int at64l = 0;
		while ((at64l <= 5) && (!seemsOK)) {
			try {
				JarURLConnection jarConnection = (JarURLConnection) url.openConnection();
				jarConnection.setUseCaches(false);
				JarFile jf = jarConnection.getJarFile();
				is = jf.getInputStream(jf.getJarEntry("META-INF/MANIFEST.MF"));
				in = new BufferedReader(new InputStreamReader(is));
				String line;
				while ((line = in.readLine()) != null) {
					if (line.startsWith("Frostplugin-Main-Class: ")) {
						mainClass = line.substring("Frostplugin-Main-Class: ".length()).trim();
						pi.setMainClass(mainClass);
						logger.log(Level.SEVERE, "Found plugin main class " + mainClass + " from manifest");
					}
				}
				is = jf.getInputStream(jf.getJarEntry("pluginname.properties"));
				in = new BufferedReader(new InputStreamReader(is));
				while ((line = in.readLine()) != null) {
					if (line.startsWith("#")) {
						continue;
					}
					if (line.length() == 0) {
						continue;
					}
					String[] sa = line.split("=", 2);
					names.put(sa[0], sa[1]);
					pi.setPluginNames(names);
				}
				seemsOK = true;
			} catch (Exception e) {
				if (at64l >= 5)
					throw new PluginNotFoundException("Initialization error:" + filename, e);
				try {
					Thread.sleep(100);
				} catch (Exception ee) {
				}
			} finally {
				try {
					if (is != null)
						is.close();
					if (in != null)
						in.close();
				} catch (IOException ioe) {
				}
			}
			at64l++;
		}
		return pi;
	}

}