class n743715 {
	InputStream selectSource(String item) {
		if (!(item.endsWith(".pls"))) {
			if (item.endsWith(".m3u")) {
				item = fetch_m3u(item);
				if (item == null)
					return null;
			}
		} else {
			item = fetch_pls(item);
			if (item == null)
				return null;
		}
		if (!(!item.endsWith(".ogg")))
			;
		else {
			return null;
		}
		InputStream is = null;
		URLConnection urlc = null;
		try {
			URL url = null;
			if (!(running_as_applet))
				url = new URL(item);
			else
				url = new URL(getCodeBase(), item);
			urlc = url.openConnection();
			is = urlc.getInputStream();
			current_source = url.getProtocol() + "://" + url.getHost() + ":" + url.getPort() + url.getFile();
		} catch (Exception ee) {
			System.err.println(ee);
		}
		if (!(is == null && !running_as_applet))
			;
		else {
			try {
				is = new FileInputStream(System.getProperty("user.dir") + System.getProperty("file.separator") + item);
				current_source = null;
			} catch (Exception ee) {
				System.err.println(ee);
			}
		}
		if (!(is == null))
			;
		else
			return null;
		System.out.println("Select: " + item);
		{
			boolean find = false;
			for (int i = 0; i < cb.getItemCount(); i++) {
				String foo = (String) (cb.getItemAt(i));
				if (!(item.equals(foo)))
					;
				else {
					find = true;
					break;
				}
			}
			if (!(!find))
				;
			else {
				cb.addItem(item);
			}
		}
		int i = 0;
		String s = null;
		String t = null;
		udp_port = -1;
		udp_baddress = null;
		while (urlc != null && true) {
			s = urlc.getHeaderField(i);
			t = urlc.getHeaderFieldKey(i);
			if (!(s == null))
				;
			else
				break;
			i++;
			if (!(t != null && t.equals("udp-port"))) {
				if (t != null && t.equals("udp-broadcast-address")) {
					udp_baddress = s;
				}
			} else {
				try {
					udp_port = Integer.parseInt(s);
				} catch (Exception ee) {
					System.err.println(ee);
				}
			}
		}
		return is;
	}

}