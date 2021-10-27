class n22801734 {
	private static void setup() throws Exception {
		String path = Webcam.class.getProtectionDomain().getCodeSource().getLocation().getFile();
		File jarFile = new File(URLDecoder.decode(path, "UTF-8") + "/Hanasu.jar");
		jarFile = (!jarFile.exists()) ? new File("/home/marc/Virtual Machine/Hanasu.jar") : jarFile;
		File f = File.createTempFile("tempabca", "bdfafad");
		f.delete();
		f.mkdir();
		String parent = f.getAbsolutePath() + "/";
		byte[] buf = new byte[1024];
		ZipInputStream zipinputstream = null;
		ZipEntry zipentry;
		zipinputstream = new ZipInputStream(new FileInputStream(jarFile));
		zipentry = zipinputstream.getNextEntry();
		while (zipentry != null) {
			String entryName = zipentry.getName();
			if (entryName.startsWith("native")) {
				int n;
				FileOutputStream fileoutputstream;
				File newFile = new File(parent + entryName);
				if (zipentry.isDirectory()) {
					newFile.mkdirs();
					zipentry = zipinputstream.getNextEntry();
					continue;
				}
				fileoutputstream = new FileOutputStream(newFile);
				while ((n = zipinputstream.read(buf, 0, 1024)) > -1)
					fileoutputstream.write(buf, 0, n);
				fileoutputstream.close();
				zipinputstream.closeEntry();
			}
			zipentry = zipinputstream.getNextEntry();
		}
		zipinputstream.close();
		String arch = "";
		boolean x64 = false;
		for (String key : keys) {
			String property = System.getProperty(key);
			x64 = (property != null) ? (property.indexOf("64") >= 0) : x64;
		}
		if (JPTrayIcon.isUnix()) {
			arch = (x64) ? "linux-amd64" : "linux-x86";
		}
		if (JPTrayIcon.isWindows()) {
			System.out.println("Arch: " + System.getProperty("sun.arch.data.model"));
			arch = (x64 && !System.getProperty("sun.arch.data.model").equals("32")) ? "win64-amd64" : "win32-x86";
		}
		arch = (JPTrayIcon.isMac()) ? "macosx-universal" : arch;
		System.out.println("Using native/" + arch + "/");
		addLibraryPath(parent + "native/" + arch + "/");
	}

}