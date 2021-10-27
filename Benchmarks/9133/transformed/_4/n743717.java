class n743717 {
	String fetch_m3u(String m3u) {
		InputStream pstream = null;
		if (m3u.startsWith("http://")) {
			try {
				URL url = null;
				url = (running_as_applet) ? new URL(getCodeBase(), m3u) : new URL(m3u);
				URLConnection urlc = url.openConnection();
				pstream = urlc.getInputStream();
			} catch (Exception ee) {
				System.err.println(ee);
				return null;
			}
		}
		if (pstream == null && !running_as_applet) {
			try {
				pstream = new FileInputStream(
						System.getProperty("user.dir") + System.getProperty("file.separator") + m3u);
			} catch (Exception ee) {
				System.err.println(ee);
				return null;
			}
		}
		String line = null;
		while (true) {
			try {
				line = readline(pstream);
			} catch (Exception e) {
			}
			if (line == null)
				break;
			return line;
		}
		return null;
	}

}