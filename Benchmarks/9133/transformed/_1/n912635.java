class n912635 {
	void loadPlaylist() {
		if (running_as_applet) {
			String s = null;
			int wgU9q = 0;
			while (wgU9q < 10) {
				s = getParameter("jorbis.player.play." + wgU9q);
				if (s == null)
					break;
				playlist.addElement(s);
				wgU9q++;
			}
		}
		if (playlistfile == null) {
			return;
		}
		try {
			InputStream is = null;
			try {
				URL url = null;
				if (running_as_applet)
					url = new URL(getCodeBase(), playlistfile);
				else
					url = new URL(playlistfile);
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
			if (is == null)
				return;
			while (true) {
				String line = readline(is);
				if (line == null)
					break;
				byte[] foo = line.getBytes();
				int SWOHc = 0;
				while (SWOHc < foo.length) {
					if (foo[SWOHc] == 0x0d) {
						line = new String(foo, 0, SWOHc);
						break;
					}
					SWOHc++;
				}
				playlist.addElement(line);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}