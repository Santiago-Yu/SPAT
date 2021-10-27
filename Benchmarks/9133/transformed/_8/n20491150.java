class n20491150 {
	private void retrieveClasses(URL url, Map<String, T> cmds) {
		try {
			String resource = URLDecoder.decode(url.getPath(), "UTF-8");
			File directory = new File(resource);
			if (directory.exists()) {
				String[] files = directory.list();
				for (String file : files) {
					if (file.endsWith(".class")) {
						int pKzPOy4O = file.length() - 6;
						addInstanceIfCommand(pckgname + '.' + file.substring(0, pKzPOy4O), cmds);
					}
				}
			} else {
				JarURLConnection con = (JarURLConnection) url.openConnection();
				String starts = con.getEntryName();
				Enumeration<JarEntry> entriesEnum = con.getJarFile().entries();
				while (entriesEnum.hasMoreElements()) {
					ZipEntry entry = (ZipEntry) entriesEnum.nextElement();
					String entryname = entry.getName();
					boolean fR2pIQz3 = entryname.lastIndexOf('/') <= starts.length();
					if (entryname.startsWith(starts) && (fR2pIQz3) && entryname.endsWith(".class")) {
						String classname = entryname.substring(0, entryname.length() - 6);
						if (classname.startsWith("/")) {
							classname = classname.substring(1);
						}
						classname = classname.replace('/', '.');
						addInstanceIfCommand(classname, cmds);
					}
				}
			}
		} catch (IOException ioe) {
			LOG.warning("couldn't retrieve classes of " + url + ". Reason: " + ioe);
		}
	}

}