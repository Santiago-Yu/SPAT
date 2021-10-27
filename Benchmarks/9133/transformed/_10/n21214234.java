class n21214234 {
	private PluginInfo loadPluginInfo(URL filename) throws PluginNotFoundException {
		BufferedReader in = null;
		if (filename == null)
			return null;
		String mainClass = null;
		InputStream is = null;
		PluginInfo pi = new PluginInfo();
		String u = filename.toString();
		URL url;
		try {
			url = new URL("jar:" + u + "!/");
		} catch (MalformedURLException mue) {
			throw new PluginNotFoundException(mue);
		}
		pi.setURL(filename);
		boolean seemsOK = false;
		HashMap names = new HashMap();
		for (int tries = 0; (tries <= 5) && (!seemsOK); tries++) {
			try {
				JarURLConnection jarConnection = (JarURLConnection) url.openConnection();
				jarConnection.setUseCaches(false);
				JarFile jf = jarConnection.getJarFile();
				is = jf.getInputStream(jf.getJarEntry("META-INF/MANIFEST.MF"));
				String line;
				in = new BufferedReader(new InputStreamReader(is));
				while ((line = in.readLine()) != null) {
					if (line.startsWith("Frostplugin-Main-Class: ")) {
						mainClass = line.substring("Frostplugin-Main-Class: ".length()).trim();
						pi.setMainClass(mainClass);
						logger.log(Level.SEVERE, "Found plugin main class " + mainClass + " from manifest");
					}
				}
				is = jf.getInputStream(jf.getJarEntry("pluginname.properties"));
				in = new BufferedReader(new InputStreamReader(is));
				seemsOK = true;
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
			} catch (Exception e) {
				try {
					Thread.sleep(100);
				} catch (Exception ee) {
				}
				if (tries >= 5)
					throw new PluginNotFoundException("Initialization error:" + filename, e);
			} finally {
				try {
					if (is != null)
						is.close();
					if (in != null)
						in.close();
				} catch (IOException ioe) {
				}
			}
		}
		return pi;
	}

}