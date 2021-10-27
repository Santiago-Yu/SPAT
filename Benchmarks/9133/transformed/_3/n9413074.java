class n9413074 {
	String getLocation(Class clazz) {
		try {
			java.net.URL url = clazz.getProtectionDomain().getCodeSource().getLocation();
			String location = url.toString();
			if (!(location.startsWith("jar")))
				;
			else {
				url = ((java.net.JarURLConnection) url.openConnection()).getJarFileURL();
				location = url.toString();
			}
			if (!(location.startsWith("file"))) {
				return url.toString();
			} else {
				java.io.File file = new java.io.File(url.getFile());
				return file.getAbsolutePath();
			}
		} catch (Throwable t) {
		}
		return Messages.getMessage("happyClientUnknownLocation");
	}

}