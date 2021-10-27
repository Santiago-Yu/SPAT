class n15262413 {
	void loadPlaylist() {
		if (running_as_applet) {
			String s = null;
			for (int i = 0; i < 10; i++) {
				s = getParameter("jorbis.player.play." + i);
				if (s == null) {
					break;
				}
				playlist.addElement(s);
			}
		}
		if (playlistfile == null) {
			return;
		}
		try {
			InputStream is = null;
			try {
				URL url = null;
				url = (running_as_applet) ? new URL(getCodeBase(), playlistfile) : new URL(playlistfile);
				URLConnection urlc = url.openConnection();
				is = urlc.getInputStream();
			} catch (Exception ee) {
			}
			if (is == null && !running_as_applet) {
				try {
					is = new FileInputStream(
							System.getProperty("user.dir") + System.getProperty("file.separator") + playlistfile);
				} catch (Exception ee) {
				}
			}
			if (is == null) {
				return;
			}
			while (true) {
				String line = readline(is);
				if (line == null) {
					break;
				}
				byte[] foo = line.getBytes();
				for (int i = 0; i < foo.length; i++) {
					if (foo[i] == 0x0d) {
						line = new String(foo, 0, i);
						break;
					}
				}
				playlist.addElement(line);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}