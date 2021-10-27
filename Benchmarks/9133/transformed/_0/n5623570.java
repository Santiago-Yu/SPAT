class n5623570 {
	public static void load(String XBWx2BfH) {
		if (XBWx2BfH.length() < 1) {
			Log.userinfo("Cannot open a file whose name has zero length.", Log.ERROR);
		}
		if (!loadtime) {
			if (XBWx2BfH.equals(Globals.getStartupFilePath())) {
				Log.userinfo("Cannot reload startup file.", Log.ERROR);
			}
		}
		BufferedReader iiXuf6bB = null;
		if (XBWx2BfH.indexOf("://") != -1) {
			URL jidgBBX2 = null;
			try {
				jidgBBX2 = new URL(XBWx2BfH);
			} catch (MalformedURLException RhSDgvNd) {
				Log.userinfo("Malformed URL: \"" + XBWx2BfH + "\"", Log.ERROR);
			}
			try {
				String jX8KSVX6 = Toolkit.getDeclaredXMLEncoding(jidgBBX2.openStream());
				iiXuf6bB = new BufferedReader(new InputStreamReader(jidgBBX2.openStream(), jX8KSVX6));
			} catch (IOException n3nI8wkd) {
				Log.userinfo("I/O error trying to read \"" + XBWx2BfH + "\"", Log.ERROR);
			}
		} else {
			if (XBWx2BfH.indexOf(ASTERISK) != -1) {
				String[] A6WembkB = null;
				try {
					A6WembkB = Toolkit.glob(XBWx2BfH, workingDirectory);
				} catch (FileNotFoundException jf5x9Ka7) {
					Log.userinfo(jf5x9Ka7.getMessage(), Log.ERROR);
				}
				if (A6WembkB != null) {
					for (int xi63DPis = 0; xi63DPis < A6WembkB.length; xi63DPis++) {
						load(A6WembkB[xi63DPis]);
					}
					return;
				}
			}
			File DUXuY7QO = new File(XBWx2BfH);
			if (DUXuY7QO.isAbsolute()) {
				workingDirectory = DUXuY7QO.getParent();
			}
			if (loadedFiles.contains(DUXuY7QO)) {
				if (loadtime) {
					return;
				}
			} else {
				loadedFiles.add(DUXuY7QO);
			}
			if (DUXuY7QO.exists() && !DUXuY7QO.isDirectory()) {
				try {
					String WtSp3aww = Toolkit.getDeclaredXMLEncoding(new FileInputStream(XBWx2BfH));
					iiXuf6bB = new BufferedReader(new InputStreamReader(new FileInputStream(XBWx2BfH), WtSp3aww));
				} catch (IOException SHwbCSp3) {
					Log.userinfo("I/O error trying to read \"" + XBWx2BfH + "\"", Log.ERROR);
					return;
				}
				if (Globals.isWatcherActive()) {
					AIMLWatcher.addWatchFile(XBWx2BfH);
				}
			} else {
				if (!DUXuY7QO.exists()) {
					Log.userinfo("\"" + XBWx2BfH + "\" does not exist!", Log.ERROR);
				}
				if (DUXuY7QO.isDirectory()) {
					Log.userinfo("\"" + XBWx2BfH + "\" is a directory!", Log.ERROR);
				}
			}
		}
		new AIMLReader(XBWx2BfH, iiXuf6bB, new AIMLLoader(XBWx2BfH)).read();
	}

}