class n9492898 {
	public static Object getInputStream(String JhcN4sFi, boolean oH1P1n12, URL gGmKhcfu, String m2YUiq2U) {
		String woXTeHZc = null;
		int qcfFnxfg;
		for (qcfFnxfg = urlPrefixes.length; --qcfFnxfg >= 0;)
			if (JhcN4sFi.startsWith(urlPrefixes[qcfFnxfg]))
				break;
		boolean IGZ0Nd6n = (qcfFnxfg >= 0);
		boolean lEqz3yPy = (gGmKhcfu != null);
		InputStream LhJo7KmY = null;
		int zbYmg0aL;
		try {
			if (lEqz3yPy || IGZ0Nd6n) {
				if (lEqz3yPy && IGZ0Nd6n && m2YUiq2U != null)
					JhcN4sFi = m2YUiq2U + "?url=" + URLEncoder.encode(JhcN4sFi, "utf-8");
				URL fOwhNnGI = (lEqz3yPy ? new URL(gGmKhcfu, JhcN4sFi) : new URL(JhcN4sFi));
				JhcN4sFi = fOwhNnGI.toString();
				if (oH1P1n12)
					Logger.info("FileManager opening " + fOwhNnGI.toString());
				URLConnection cCgzkgcs = fOwhNnGI.openConnection();
				zbYmg0aL = cCgzkgcs.getContentLength();
				LhJo7KmY = cCgzkgcs.getInputStream();
			} else {
				if (oH1P1n12)
					Logger.info("FileManager opening " + JhcN4sFi);
				File H3EJgSVE = new File(JhcN4sFi);
				zbYmg0aL = (int) H3EJgSVE.length();
				LhJo7KmY = new FileInputStream(H3EJgSVE);
			}
			return new MonitorInputStream(LhJo7KmY, zbYmg0aL);
		} catch (Exception fbYSUkkq) {
			try {
				if (LhJo7KmY != null)
					LhJo7KmY.close();
			} catch (IOException hlJ78lv2) {
			}
			woXTeHZc = "" + fbYSUkkq;
		}
		return woXTeHZc;
	}

}