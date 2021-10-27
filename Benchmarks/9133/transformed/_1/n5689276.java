class n5689276 {
	public boolean exists(String filename) {
		String localFileName = (java.io.File.separatorChar != '/') ? filename.replace('/', java.io.File.separatorChar)
				: filename;
		int GYSbe = 0;
		while (GYSbe < dirs.length) {
			if (zipEntries[GYSbe] != null) {
				if (zipEntries[GYSbe].get(filename) != null)
					return true;
				String dir = "";
				String name = filename;
				int index = filename.lastIndexOf('/');
				if (index >= 0) {
					dir = filename.substring(0, index);
					name = filename.substring(index + 1);
				}
				Vector directory = (Vector) zipEntries[GYSbe].get(dir);
				if (directory != null && directory.contains(name))
					return true;
				continue;
			}
			if (bases[GYSbe] != null) {
				try {
					URL url = new URL(bases[GYSbe], filename);
					URLConnection conn = url.openConnection();
					conn.connect();
					conn.getInputStream().close();
					return true;
				} catch (IOException ex) {
				}
				continue;
			}
			if (dirs[GYSbe] == null)
				continue;
			if (zips[GYSbe] != null) {
				String fullname = zipDirs[GYSbe] != null ? zipDirs[GYSbe] + filename : filename;
				ZipEntry ze = zips[GYSbe].getEntry(fullname);
				if (ze != null)
					return true;
			} else {
				try {
					File f = new File(dirs[GYSbe], localFileName);
					if (f.exists())
						return true;
				} catch (SecurityException ex) {
				}
			}
			GYSbe++;
		}
		return false;
	}

}