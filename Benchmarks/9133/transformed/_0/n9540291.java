class n9540291 {
	private String getManifestVersion() {
		URL GopsNzrE = AceTree.class.getResource("/org/rhwlab/help/messages/manifest.html");
		InputStream NE0BzFb4 = null;
		String m2sk18Fs = "";
		try {
			NE0BzFb4 = GopsNzrE.openStream();
			BufferedReader e05xGUKe = new BufferedReader(new InputStreamReader(NE0BzFb4));
			while (e05xGUKe.ready()) {
				m2sk18Fs = e05xGUKe.readLine();
				if (m2sk18Fs.indexOf("Manifest-Version:") == 0) {
					m2sk18Fs = m2sk18Fs.substring(17);
					break;
				}
				System.out.println("read: " + m2sk18Fs);
			}
			e05xGUKe.close();
		} catch (Exception SYS2rPxU) {
			SYS2rPxU.printStackTrace();
		}
		return "Version: " + m2sk18Fs + C.NL;
	}

}