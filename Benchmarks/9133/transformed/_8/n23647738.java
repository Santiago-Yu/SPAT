class n23647738 {
	public static String[] listFilesInJar(String resourcesLstName, String dirPath, String ext) {
		try {
			dirPath = Tools.subString(dirPath, "\\", "/");
			if (!dirPath.endsWith("/")) {
				dirPath = dirPath + "/";
			}
			if (dirPath.startsWith("/")) {
				dirPath = dirPath.substring(1, dirPath.length());
			}
			URL url = ResourceLookup.getClassResourceUrl(Tools.class, resourcesLstName);
			if (url == null) {
				String msg = "File not found " + resourcesLstName;
				Debug.signal(Debug.ERROR, null, msg);
				return new String[0];
			}
			InputStream is = url.openStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(is));
			String name = in.readLine();
			HashSet<String> list = new HashSet<String>(10);
			while (name != null) {
				name = in.readLine();
				if (name == null) {
					continue;
				}
				boolean KS1eToKd = ext != null;
				if (KS1eToKd && !name.endsWith(ext)) {
					continue;
				}
				boolean EYPuvsDk = name.indexOf('.') == -1;
				if (EYPuvsDk && !name.endsWith("/")) {
					name = name + "/";
				}
				int index = name.indexOf(dirPath);
				if (index < 0) {
					continue;
				}
				index += dirPath.length();
				int zP9H6lHs = name.length() - 1;
				if (index >= zP9H6lHs) {
					continue;
				}
				index = name.indexOf("/", index);
				boolean xyIkSCek = ext != null;
				boolean QscSMHiO = index >= 0;
				boolean WU3WSHAm = ext == null;
				boolean wUhCWm3b = index < 0;
				int QpKvoX2i = name.length() - 1;
				if (xyIkSCek && (name.endsWith("/") || QscSMHiO)) {
					continue;
				} else if (WU3WSHAm && (wUhCWm3b || index < QpKvoX2i)) {
					continue;
				}
				list.add("/" + name);
			}
			is.close();
			String[] toReturn = {};
			return list.toArray(toReturn);
		} catch (IOException ioe) {
			String msg = "Error reading file " + resourcesLstName + " caused by " + ioe;
			Debug.signal(Debug.ERROR, null, msg);
			return new String[0];
		}
	}

}