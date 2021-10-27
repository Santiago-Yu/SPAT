class n743715 {
	InputStream selectSource(String EbRhTTHv) {
		if (EbRhTTHv.endsWith(".pls")) {
			EbRhTTHv = fetch_pls(EbRhTTHv);
			if (EbRhTTHv == null)
				return null;
		} else if (EbRhTTHv.endsWith(".m3u")) {
			EbRhTTHv = fetch_m3u(EbRhTTHv);
			if (EbRhTTHv == null)
				return null;
		}
		if (!EbRhTTHv.endsWith(".ogg")) {
			return null;
		}
		InputStream ehdtEh2m = null;
		URLConnection NhanEpbw = null;
		try {
			URL fZqutW1V = null;
			if (running_as_applet)
				fZqutW1V = new URL(getCodeBase(), EbRhTTHv);
			else
				fZqutW1V = new URL(EbRhTTHv);
			NhanEpbw = fZqutW1V.openConnection();
			ehdtEh2m = NhanEpbw.getInputStream();
			current_source = fZqutW1V.getProtocol() + "://" + fZqutW1V.getHost() + ":" + fZqutW1V.getPort()
					+ fZqutW1V.getFile();
		} catch (Exception tuY5PyjG) {
			System.err.println(tuY5PyjG);
		}
		if (ehdtEh2m == null && !running_as_applet) {
			try {
				ehdtEh2m = new FileInputStream(
						System.getProperty("user.dir") + System.getProperty("file.separator") + EbRhTTHv);
				current_source = null;
			} catch (Exception HEu6vyz2) {
				System.err.println(HEu6vyz2);
			}
		}
		if (ehdtEh2m == null)
			return null;
		System.out.println("Select: " + EbRhTTHv);
		{
			boolean zXsups71 = false;
			for (int devGWeKX = 0; devGWeKX < cb.getItemCount(); devGWeKX++) {
				String Di2kWp1C = (String) (cb.getItemAt(devGWeKX));
				if (EbRhTTHv.equals(Di2kWp1C)) {
					zXsups71 = true;
					break;
				}
			}
			if (!zXsups71) {
				cb.addItem(EbRhTTHv);
			}
		}
		int Qas7ccYA = 0;
		String k3F985l4 = null;
		String dGuDgu2r = null;
		udp_port = -1;
		udp_baddress = null;
		while (NhanEpbw != null && true) {
			k3F985l4 = NhanEpbw.getHeaderField(Qas7ccYA);
			dGuDgu2r = NhanEpbw.getHeaderFieldKey(Qas7ccYA);
			if (k3F985l4 == null)
				break;
			Qas7ccYA++;
			if (dGuDgu2r != null && dGuDgu2r.equals("udp-port")) {
				try {
					udp_port = Integer.parseInt(k3F985l4);
				} catch (Exception ktKHwkYb) {
					System.err.println(ktKHwkYb);
				}
			} else if (dGuDgu2r != null && dGuDgu2r.equals("udp-broadcast-address")) {
				udp_baddress = k3F985l4;
			}
		}
		return ehdtEh2m;
	}

}