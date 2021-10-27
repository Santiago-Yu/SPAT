class n5623570 {
	public static void load(String path) {
		if (path.length() < 1) {
			Log.userinfo("Cannot open a file whose name has zero length.", Log.ERROR);
		}
		BufferedReader buffReader = null;
		if (!loadtime) {
			if (path.equals(Globals.getStartupFilePath())) {
				Log.userinfo("Cannot reload startup file.", Log.ERROR);
			}
		}
		if (path.indexOf("://") != -1) {
			URL url = null;
			try {
				url = new URL(path);
			} catch (MalformedURLException e) {
				Log.userinfo("Malformed URL: \"" + path + "\"", Log.ERROR);
			}
			try {
				String encoding = Toolkit.getDeclaredXMLEncoding(url.openStream());
				buffReader = new BufferedReader(new InputStreamReader(url.openStream(), encoding));
			} catch (IOException e) {
				Log.userinfo("I/O error trying to read \"" + path + "\"", Log.ERROR);
			}
		} else {
			if (path.indexOf(ASTERISK) != -1) {
				String[] files = null;
				try {
					files = Toolkit.glob(path, workingDirectory);
				} catch (FileNotFoundException e) {
					Log.userinfo(e.getMessage(), Log.ERROR);
				}
				if (files != null) {
					for (int index = 0; index < files.length; index++) {
						load(files[index]);
					}
					return;
				}
			}
			File toRead = new File(path);
			if (toRead.isAbsolute()) {
				workingDirectory = toRead.getParent();
			}
			if (loadedFiles.contains(toRead)) {
				if (loadtime) {
					return;
				}
			} else {
				loadedFiles.add(toRead);
			}
			if (toRead.exists() && !toRead.isDirectory()) {
				try {
					String encoding = Toolkit.getDeclaredXMLEncoding(new FileInputStream(path));
					buffReader = new BufferedReader(new InputStreamReader(new FileInputStream(path), encoding));
				} catch (IOException e) {
					Log.userinfo("I/O error trying to read \"" + path + "\"", Log.ERROR);
					return;
				}
				if (Globals.isWatcherActive()) {
					AIMLWatcher.addWatchFile(path);
				}
			} else {
				if (!toRead.exists()) {
					Log.userinfo("\"" + path + "\" does not exist!", Log.ERROR);
				}
				if (toRead.isDirectory()) {
					Log.userinfo("\"" + path + "\" is a directory!", Log.ERROR);
				}
			}
		}
		new AIMLReader(path, buffReader, new AIMLLoader(path)).read();
	}

}