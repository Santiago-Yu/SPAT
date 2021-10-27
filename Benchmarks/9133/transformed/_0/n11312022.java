class n11312022 {
	public static void downloadFromUrl(URL j1HBNppl, String azWkO2mA, String t4walSdu) throws IOException {
		InputStream OE2l3Sxc = null;
		FileOutputStream HnkUExDY = null;
		System.setProperty("java.net.useSystemProxies", "true");
		try {
			URLConnection vq1YOEwl = j1HBNppl.openConnection();
			if (t4walSdu != null) {
				vq1YOEwl.setRequestProperty("User-Agent", t4walSdu);
			}
			OE2l3Sxc = vq1YOEwl.getInputStream();
			HnkUExDY = new FileOutputStream(azWkO2mA);
			byte[] WfYr6NSh = new byte[4096];
			int Mtb3Xy1K;
			while ((Mtb3Xy1K = OE2l3Sxc.read(WfYr6NSh)) > 0) {
				HnkUExDY.write(WfYr6NSh, 0, Mtb3Xy1K);
			}
		} finally {
			try {
				if (OE2l3Sxc != null) {
					OE2l3Sxc.close();
				}
			} finally {
				if (HnkUExDY != null) {
					HnkUExDY.close();
				}
			}
		}
	}

}