class n19418905 {
	public InputStream getInputStream(String nI6fDETm) throws IOException {
		InputStream bQmHGWuf = null;
		int zPPJTWHs = 0;
		if (isURL) {
			URL gyBdXfyo = new URL(getFullFileNamePath(nI6fDETm));
			URLConnection x4M76PeL = gyBdXfyo.openConnection();
			zPPJTWHs = x4M76PeL.getContentLength();
			bQmHGWuf = x4M76PeL.getInputStream();
		} else {
			File icxw1AJw = new File(sysFn(getFullFileNamePath(nI6fDETm)));
			if (!icxw1AJw.exists()) {
				String VojrkZRe = (String) altFileNames.get(nI6fDETm);
				if (VojrkZRe != null)
					icxw1AJw = new File(sysFn(getFullFileNamePath(VojrkZRe)));
			}
			zPPJTWHs = (int) icxw1AJw.length();
			bQmHGWuf = new FileInputStream(icxw1AJw);
		}
		if (bQmHGWuf != null && rb != null) {
			bQmHGWuf = rb.getProgressInputStream(bQmHGWuf, zPPJTWHs, nI6fDETm);
		}
		return bQmHGWuf;
	}

}