class n9413074 {
	String getLocation(Class r39bpY2v) {
		try {
			java.net.URL WrUKHYBK = r39bpY2v.getProtectionDomain().getCodeSource().getLocation();
			String Armp1pCL = WrUKHYBK.toString();
			if (Armp1pCL.startsWith("jar")) {
				WrUKHYBK = ((java.net.JarURLConnection) WrUKHYBK.openConnection()).getJarFileURL();
				Armp1pCL = WrUKHYBK.toString();
			}
			if (Armp1pCL.startsWith("file")) {
				java.io.File lBnXM4aw = new java.io.File(WrUKHYBK.getFile());
				return lBnXM4aw.getAbsolutePath();
			} else {
				return WrUKHYBK.toString();
			}
		} catch (Throwable kwBlMjQq) {
		}
		return Messages.getMessage("happyClientUnknownLocation");
	}

}