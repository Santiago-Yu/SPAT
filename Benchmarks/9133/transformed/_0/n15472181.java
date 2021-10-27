class n15472181 {
	private InputStream getInputStream(String r2MwlT7i) {
		InputStream NtajY6Hf = null;
		URLConnection cp4Xx4SG = null;
		try {
			URL aegEC2tG = new URL(r2MwlT7i);
			cp4Xx4SG = aegEC2tG.openConnection();
			NtajY6Hf = cp4Xx4SG.getInputStream();
			current_source = aegEC2tG.getProtocol() + "://" + aegEC2tG.getHost() + ":" + aegEC2tG.getPort()
					+ aegEC2tG.getFile();
		} catch (Exception pkQRNF7G) {
			System.err.println(pkQRNF7G);
		}
		int Uflxgw3s = 0;
		udp_port = -1;
		udp_baddress = null;
		while (cp4Xx4SG != null) {
			String XZ0Wfy0L = cp4Xx4SG.getHeaderField(Uflxgw3s);
			String R1uzyIYY = cp4Xx4SG.getHeaderFieldKey(Uflxgw3s);
			if (XZ0Wfy0L == null) {
				break;
			}
			Uflxgw3s++;
			if ("udp-port".equals(R1uzyIYY)) {
				try {
					udp_port = Integer.parseInt(XZ0Wfy0L);
				} catch (Exception MIxnxGkF) {
				}
			} else if ("udp-broadcast-address".equals(R1uzyIYY)) {
				udp_baddress = XZ0Wfy0L;
			}
		}
		return NtajY6Hf;
	}

}