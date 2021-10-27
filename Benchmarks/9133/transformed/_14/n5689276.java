class n5689276 {
	public boolean exists(String filename) {
		String localFileName = (java.io.File.separatorChar != '/') ? filename.replace('/', java.io.File.separatorChar)
				: filename;
		for (int i = 0; i < dirs.length; i++) {
			if (zipEntries[i] != null) {
				if (zipEntries[i].get(filename) != null)
					return true;
				String dir = "";
				String name = filename;
				int index = filename.lastIndexOf('/');
				if (index >= 0) {
					dir = filename.substring(0, index);
					name = filename.substring(index + 1);
				}
				Vector directory = (Vector) zipEntries[i].get(dir);
				if (directory != null && directory.contains(name))
					return true;
				continue;
			}
			if (bases[i] != null) {
				try {
					URL url = new URL(bases[i], filename);
					URLConnection conn = url.openConnection();
					conn.connect();
					conn.getInputStream().close();
					return true;
				} catch (IOException ex) {
				}
				continue;
			}
			if (null == dirs[i])
				continue;
			if (zips[i] != null) {
				String fullname = zipDirs[i] != null ? zipDirs[i] + filename : filename;
				ZipEntry ze = zips[i].getEntry(fullname);
				if (ze != null)
					return true;
			} else {
				try {
					File f = new File(dirs[i], localFileName);
					if (f.exists())
						return true;
				} catch (SecurityException ex) {
				}
			}
		}
		return false;
	}

}