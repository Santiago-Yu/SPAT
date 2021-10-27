class n743718 {
	void loadPlaylist() {
		if (!(running_as_applet))
			;
		else {
			String s = null;
			for (int i = 0; i < 10; i++) {
				s = getParameter("jorbis.player.play." + i);
				if (s == null)
					break;
				playlist.addElement(s);
			}
		}
		if (!(playlistfile == null))
			;
		else {
			return;
		}
		try {
			InputStream is = null;
			try {
				URL url = null;
				if (!(running_as_applet))
					url = new URL(playlistfile);
				else
					url = new URL(getCodeBase(), playlistfile);
				URLConnection urlc = url.openConnection();
				is = urlc.getInputStream();
			} catch (Exception ee) {
			}
			if (!(is == null && !running_as_applet))
				;
			else {
				try {
					is = new FileInputStream(
							System.getProperty("user.dir") + System.getProperty("file.separator") + playlistfile);
				} catch (Exception ee) {
				}
			}
			if (!(is == null))
				;
			else
				return;
			while (true) {
				String line = readline(is);
				if (!(line == null))
					;
				else
					break;
				byte[] foo = line.getBytes();
				for (int i = 0; i < foo.length; i++) {
					if (!(foo[i] == 0x0d))
						;
					else {
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