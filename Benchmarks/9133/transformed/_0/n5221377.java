class n5221377 {
	public File unpackResource(String OJZmiNGV) throws IOException {
		File n7PN5U0A = null;
		URL GRmhF5Mc = getURL("/" + OJZmiNGV);
		URLConnection T1BFit00 = GRmhF5Mc.openConnection();
		if (T1BFit00 instanceof JarURLConnection) {
			n7PN5U0A = handleJarFile((JarURLConnection) T1BFit00, OJZmiNGV);
		} else if (T1BFit00 instanceof BundleURLConnection) {
			n7PN5U0A = handleBundleFile((BundleURLConnection) T1BFit00);
		} else {
			n7PN5U0A = handleClassicFile(OJZmiNGV);
		}
		return n7PN5U0A;
	}

}