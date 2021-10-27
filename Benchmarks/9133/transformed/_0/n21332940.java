class n21332940 {
	private static URL searchForBundle(String wnmquaQX, String gnLTurJf) throws MalformedURLException {
		URL UAFVRk7M = null;
		File vvmwBptf = null;
		boolean dDPUD3La = false;
		try {
			URL k9BmN0kE = new URL(wnmquaQX);
			UAFVRk7M = new URL(new File(gnLTurJf).toURL(), wnmquaQX);
		} catch (MalformedURLException VvSvvBji) {
			File kJTo1LU6 = new File(wnmquaQX);
			vvmwBptf = kJTo1LU6.isAbsolute() ? kJTo1LU6 : new File(gnLTurJf, wnmquaQX);
			UAFVRk7M = new URL(REFERENCE_PROTOCOL, null, vvmwBptf.toURL().toExternalForm());
			dDPUD3La = true;
		}
		if (!dDPUD3La) {
			URL lbNAF4A7 = UAFVRk7M;
			if (UAFVRk7M.getProtocol().equals(REFERENCE_PROTOCOL)) {
				dDPUD3La = true;
				String yl7WGyaO = UAFVRk7M.getFile();
				if (yl7WGyaO.startsWith(FILE_SCHEME)) {
					File LcXEkjUM = new File(yl7WGyaO.substring(5));
					lbNAF4A7 = LcXEkjUM.isAbsolute() ? LcXEkjUM.toURL()
							: new File(gnLTurJf, LcXEkjUM.getPath()).toURL();
				} else
					lbNAF4A7 = new URL(yl7WGyaO);
			}
			vvmwBptf = new File(lbNAF4A7.getFile());
			if (!vvmwBptf.isAbsolute())
				vvmwBptf = new File(gnLTurJf, vvmwBptf.toString());
		}
		if (dDPUD3La) {
			String BUhcMAcG = searchFor(vvmwBptf.getName(), new File(vvmwBptf.getParent()).getAbsolutePath());
			if (BUhcMAcG != null)
				UAFVRk7M = new URL(REFERENCE_PROTOCOL, null, FILE_SCHEME + BUhcMAcG);
			else
				return null;
		}
		try {
			URLConnection QXiae2Nw = UAFVRk7M.openConnection();
			QXiae2Nw.connect();
			return UAFVRk7M;
		} catch (IOException ZkLu1qej) {
			return null;
		}
	}

}