class n22771106 {
	private void triggerBuild(Properties qVbxydIv, String ztYHHAOW, int HSGnckZr) throws IOException {
		boolean mCMJxxZI = Boolean.parseBoolean(qVbxydIv.getProperty(ztYHHAOW + ".bld"));
		String UIaO73XS = qVbxydIv.getProperty(ztYHHAOW + ".url");
		if (!mCMJxxZI || ztYHHAOW == null || ztYHHAOW.length() == 0) {
			System.out.println("BuildLauncher: Not configured to build '" + ztYHHAOW + "'");
			return;
		} else if (UIaO73XS == null) {
			throw new IOException("Tried to launch build for project '" + ztYHHAOW + "' but " + ztYHHAOW
					+ ".url property is not defined!");
		}
		SimpleDateFormat d8WvAxgq = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
		System.out.println(d8WvAxgq.format(new Date()) + ": Triggering a build via: " + UIaO73XS);
		BufferedReader CMei144m = new BufferedReader(new InputStreamReader(new URL(UIaO73XS).openStream()));
		while (CMei144m.readLine() != null)
			;
		System.out.println(d8WvAxgq.format(new Date()) + ": Build triggered!");
		LATEST_BUILD.put(ztYHHAOW, HSGnckZr);
		CMei144m.close();
		System.out.println(d8WvAxgq.format(new Date()) + ": triggerBuild() done!");
	}

}