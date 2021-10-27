class n15262410 {
	InputStream selectSource(String L2LAegSV) {
		if (L2LAegSV == null) {
			L2LAegSV = "http://pushnpop.net:8912/subpop.ogg";
		}
		if (L2LAegSV.endsWith(".pls")) {
			L2LAegSV = fetch_pls(L2LAegSV);
			if (L2LAegSV == null) {
				return null;
			}
		} else if (L2LAegSV.endsWith(".m3u")) {
			L2LAegSV = fetch_m3u(L2LAegSV);
			if (L2LAegSV == null) {
				return null;
			}
		}
		if (!L2LAegSV.endsWith(".ogg")) {
			return null;
		}
		InputStream l2RHchSV = null;
		URLConnection mUcJIcbb = null;
		try {
			URL AxVuW85j = null;
			if (running_as_applet) {
				AxVuW85j = new URL(getCodeBase(), L2LAegSV);
			} else {
				AxVuW85j = new URL(L2LAegSV);
			}
			mUcJIcbb = AxVuW85j.openConnection();
			l2RHchSV = mUcJIcbb.getInputStream();
			current_source = AxVuW85j.getProtocol() + "://" + AxVuW85j.getHost() + ":" + AxVuW85j.getPort()
					+ AxVuW85j.getFile();
		} catch (Exception f0mtW56w) {
			System.err.println(f0mtW56w);
		}
		if (l2RHchSV == null && !running_as_applet) {
			try {
				l2RHchSV = new FileInputStream(
						System.getProperty("user.dir") + System.getProperty("file.separator") + L2LAegSV);
				current_source = null;
			} catch (Exception leWXXU8x) {
				System.err.println(leWXXU8x);
			}
		}
		if (l2RHchSV == null) {
			return null;
		}
		System.out.println("Select: " + L2LAegSV);
		{
			boolean GoqDVfQT = false;
			for (int XH5En0Qw = 0; XH5En0Qw < cb.getItemCount(); XH5En0Qw++) {
				String t8b8vzP5 = (String) (cb.getItemAt(XH5En0Qw));
				if (L2LAegSV.equals(t8b8vzP5)) {
					GoqDVfQT = true;
					break;
				}
			}
			if (!GoqDVfQT) {
				cb.addItem(L2LAegSV);
			}
		}
		int vkwfC47b = 0;
		String jLzkSuFu = null;
		String SHgbnHp9 = null;
		udp_port = -1;
		udp_baddress = null;
		while (mUcJIcbb != null && true) {
			jLzkSuFu = mUcJIcbb.getHeaderField(vkwfC47b);
			SHgbnHp9 = mUcJIcbb.getHeaderFieldKey(vkwfC47b);
			if (jLzkSuFu == null) {
				break;
			}
			vkwfC47b++;
			if (SHgbnHp9 != null && SHgbnHp9.equals("udp-port")) {
				try {
					udp_port = Integer.parseInt(jLzkSuFu);
				} catch (Exception WmGHLOuf) {
					System.err.println(WmGHLOuf);
				}
			} else if (SHgbnHp9 != null && SHgbnHp9.equals("udp-broadcast-address")) {
				udp_baddress = jLzkSuFu;
			}
		}
		return l2RHchSV;
	}

}