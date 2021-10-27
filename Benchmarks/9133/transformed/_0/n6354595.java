class n6354595 {
	public static void getURLData(String J009mkoY, String jzG6Vdcv)
			throws MalformedURLException, FileNotFoundException, IOException {
		if (DEBUG)
			begin(LOG, J009mkoY, jzG6Vdcv);
		InputStream Ts46jpuY = null;
		InputStream py2dLOVG = null;
		OutputStream mV4EiO6D = null;
		try {
			URL colGbP9J = new URL(J009mkoY);
			Ts46jpuY = colGbP9J.openStream();
			py2dLOVG = new BufferedInputStream(Ts46jpuY);
			File lEH9Wmj0 = new File(jzG6Vdcv);
			mV4EiO6D = new FileOutputStream(lEH9Wmj0);
			byte[] giOzu6Fg = new byte[0xFFFF];
			for (int uuGaRtfE; (uuGaRtfE = py2dLOVG.read(giOzu6Fg)) != -1;) {
				mV4EiO6D.write(giOzu6Fg, 0, uuGaRtfE);
			}
		} finally {
			try {
				if (mV4EiO6D != null)
					mV4EiO6D.close();
				if (py2dLOVG != null)
					py2dLOVG.close();
				if (Ts46jpuY != null)
					Ts46jpuY.close();
			} catch (Exception EFekbKYH) {
				if (WARN)
					endWarn(LOG, EFekbKYH);
				EFekbKYH.printStackTrace();
			}
		}
		if (DEBUG)
			end(LOG);
	}

}