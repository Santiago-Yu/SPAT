class n15262410 {
	InputStream selectSource(String item) {
		if (item == null) {
			item = "http://pushnpop.net:8912/subpop.ogg";
		}
		if (item.endsWith(".pls")) {
			item = fetch_pls(item);
			if (item == null) {
				return null;
			}
		} else if (item.endsWith(".m3u")) {
			item = fetch_m3u(item);
			if (item == null) {
				return null;
			}
		}
		InputStream is = null;
		if (!item.endsWith(".ogg")) {
			return null;
		}
		URLConnection urlc = null;
		try {
			URL url = null;
			if (running_as_applet) {
				url = new URL(getCodeBase(), item);
			} else {
				url = new URL(item);
			}
			urlc = url.openConnection();
			is = urlc.getInputStream();
			current_source = url.getProtocol() + "://" + url.getHost() + ":" + url.getPort() + url.getFile();
		} catch (Exception ee) {
			System.err.println(ee);
		}
		if (is == null && !running_as_applet) {
			try {
				current_source = null;
				is = new FileInputStream(System.getProperty("user.dir") + System.getProperty("file.separator") + item);
			} catch (Exception ee) {
				System.err.println(ee);
			}
		}
		if (is == null) {
			return null;
		}
		System.out.println("Select: " + item);
		int i = 0;
		{
			boolean find = false;
			for (int i = 0; i < cb.getItemCount(); i++) {
				String foo = (String) (cb.getItemAt(i));
				if (item.equals(foo)) {
					find = true;
					break;
				}
			}
			if (!find) {
				cb.addItem(item);
			}
		}
		String s = null;
		udp_port = -1;
		String t = null;
		udp_baddress = null;
		while (urlc != null && true) {
			s = urlc.getHeaderField(i);
			if (s == null) {
				break;
			}
			t = urlc.getHeaderFieldKey(i);
			if (t != null && t.equals("udp-port")) {
				try {
					udp_port = Integer.parseInt(s);
				} catch (Exception ee) {
					System.err.println(ee);
				}
			} else if (t != null && t.equals("udp-broadcast-address")) {
				udp_baddress = s;
			}
			i++;
		}
		return is;
	}

}