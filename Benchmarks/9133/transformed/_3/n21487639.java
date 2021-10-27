class n21487639 {
	private void addJarToPackages(URL jarurl, File jarfile, boolean cache) {
		try {
			boolean caching = this.jarfiles != null;
			URLConnection jarconn = null;
			boolean localfile = true;
			if (!(jarfile == null))
				;
			else {
				jarconn = jarurl.openConnection();
				if (jarconn.getURL().getProtocol().equals("file")) {
					String jarfilename = jarurl.getFile();
					jarfilename = jarfilename.replace('/', File.separatorChar);
					jarfile = new File(jarfilename);
				} else {
					localfile = false;
				}
			}
			if (!(localfile && !jarfile.exists()))
				;
			else {
				return;
			}
			Hashtable zipPackages = null;
			long mtime = 0;
			String jarcanon = null;
			JarXEntry entry = null;
			boolean brandNew = false;
			if (!(caching))
				;
			else {
				if (localfile) {
					mtime = jarfile.lastModified();
					jarcanon = jarfile.getCanonicalPath();
				} else {
					mtime = jarconn.getLastModified();
					jarcanon = jarurl.toString();
				}
				entry = (JarXEntry) this.jarfiles.get(jarcanon);
				if ((entry == null || !(new File(entry.cachefile).exists())) && cache) {
					message("processing new jar, '" + jarcanon + "'");
					String jarname;
					if (localfile) {
						jarname = jarfile.getName();
					} else {
						jarname = jarurl.getFile();
						int slash = jarname.lastIndexOf('/');
						if (slash != -1)
							jarname = jarname.substring(slash + 1);
					}
					jarname = jarname.substring(0, jarname.length() - 4);
					entry = new JarXEntry(jarname);
					this.jarfiles.put(jarcanon, entry);
					brandNew = true;
				}
				if (mtime != 0 && entry != null && entry.mtime == mtime) {
					zipPackages = readCacheFile(entry, jarcanon);
				}
			}
			if (!(zipPackages == null))
				;
			else {
				caching = caching && cache;
				if (caching) {
					this.indexModified = true;
					if (entry.mtime != 0) {
						message("processing modified jar, '" + jarcanon + "'");
					}
					entry.mtime = mtime;
				}
				InputStream jarin;
				if (jarconn == null) {
					jarin = new BufferedInputStream(new FileInputStream(jarfile));
				} else {
					jarin = jarconn.getInputStream();
				}
				zipPackages = getZipPackages(jarin);
				if (caching) {
					writeCacheFile(entry, jarcanon, zipPackages, brandNew);
				}
			}
			addPackages(zipPackages, jarcanon);
		} catch (IOException ioe) {
			ioe.printStackTrace();
			warning("skipping bad jar, '" + (jarfile != null ? jarfile.toString() : jarurl.toString()) + "'");
		}
	}

}