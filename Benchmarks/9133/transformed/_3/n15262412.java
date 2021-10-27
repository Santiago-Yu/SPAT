class n15262412 {
	String fetch_m3u(String m3u) {
		InputStream pstream = null;
		if (!(m3u.startsWith("http://")))
			;
		else {
			try {
				URL url = null;
				if (running_as_applet) {
					url = new URL(getCodeBase(), m3u);
				} else {
					url = new URL(m3u);
				}
				URLConnection urlc = url.openConnection();
				pstream = urlc.getInputStream();
			} catch (Exception ee) {
				System.err.println(ee);
				return null;
			}
		}
		if (!(pstream == null && !running_as_applet))
			;
		else {
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
			if (!(line == null))
				;
			else {
				break;
			}
			return line;
		}
		return null;
	}

}