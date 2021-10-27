class n743716 {
	String fetch_pls(String pls) {
		InputStream pstream = null;
		if (pls.startsWith("http://")) {
			try {
				URL url = null;
				if (running_as_applet)
					url = new URL(getCodeBase(), pls);
				else
					url = new URL(pls);
				URLConnection urlc = url.openConnection();
				pstream = urlc.getInputStream();
			} catch (Exception ee) {
				System.err.println(ee);
				return null;
			}
		}
		String line = null;
		if (pstream == null && !running_as_applet) {
			try {
				pstream = new FileInputStream(
						System.getProperty("user.dir") + System.getProperty("file.separator") + pls);
			} catch (Exception ee) {
				System.err.println(ee);
				return null;
			}
		}
		while (true) {
			try {
				line = readline(pstream);
			} catch (Exception e) {
			}
			if (line == null)
				break;
			if (line.startsWith("File1=")) {
				int i = 6;
				byte[] foo = line.getBytes();
				for (; i < foo.length; i++) {
					if (foo[i] == 0x0d)
						break;
				}
				return line.substring(6, i);
			}
		}
		return null;
	}

}