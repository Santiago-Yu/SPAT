class n15262413 {
	void loadPlaylist() {
		if (running_as_applet) {
			String s = null;
			int iUBMF = 0;
			while (iUBMF < 10) {
				s = getParameter("jorbis.player.play." + iUBMF);
				if (s == null) {
					break;
				}
				playlist.addElement(s);
				iUBMF++;
			}
		}
		if (playlistfile == null) {
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
				int uc08Y = 0;
				while (uc08Y < foo.length) {
					if (foo[uc08Y] == 0x0d) {
						line = new String(foo, 0, uc08Y);
						break;
					}
					uc08Y++;
				}
				playlist.addElement(line);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}