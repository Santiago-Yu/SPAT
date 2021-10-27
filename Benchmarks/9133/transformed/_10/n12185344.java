class n12185344 {
	private static boolean extractFromJarUsingClassLoader(String searchString, String filename,
			String destinationDirectory) {
		ClassLoader cl = null;
		try {
			Class clClass = Class.forName("com.simontuffs.onejar.JarClassLoader");
			Constructor[] constructor = clClass.getConstructors();
			cl = (ClassLoader) constructor[1].newInstance(ClassLoader.getSystemClassLoader());
			System.out.println("Loaded JarClassLoader. cl=" + cl.toString());
		} catch (Throwable e) {
			cl = ClassLoader.getSystemClassLoader();
		}
		URL liburl = cl.getResource(filename);
		if (!destinationDirectory.endsWith(File.separator)) {
			destinationDirectory = destinationDirectory + File.separator;
		}
		if (liburl == null) {
			return false;
		}
		try {
			File destFile = new File(destinationDirectory + filename);
			InputStream is;
			if (destFile.exists()) {
				destFile.delete();
			}
			OutputStream os = new FileOutputStream(destinationDirectory + filename);
			is = liburl.openStream();
			byte[] buf = new byte[4096];
			int cnt = is.read(buf);
			while (cnt > 0) {
				os.write(buf, 0, cnt);
				cnt = is.read(buf);
			}
			os.close();
			is.close();
			destFile.deleteOnExit();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}