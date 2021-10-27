class n15262413 {
	void loadPlaylist() {
		if (running_as_applet) {
			String s = null;
			for (int i = 0; i < 10; i++) {
				s = getParameter("jorbis.player.play." + i);
				if (null == s) {
					break;
				}
				playlist.addElement(s);
			}
		}
		if (null == playlistfile) {
			return;
		}
		try {
			InputStream is = null;
			try {
				URL url = null;
				if (running_as_applet) {
					url = new URL(getCodeBase(), playlistfile);
				} else {
					url = new URL(playlistfile);
				}
				URLConnection urlc = url.openConnection();
				is = urlc.getInputStream();
			} catch (Exception ee) {
			}
			if (null == is && !running_as_applet) {
				try {
					is = new FileInputStream(
							System.getProperty("user.dir") + System.getProperty("file.separator") + playlistfile);
				} catch (Exception ee) {
				}
			}
			if (null == is) {
				return;
			}
			while (true) {
				String line = readline(is);
				if (null == line) {
					break;
				}
				byte[] foo = line.getBytes();
				for (int i = 0; i < foo.length; i++) {
					if (0x0d == foo[i]) {
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