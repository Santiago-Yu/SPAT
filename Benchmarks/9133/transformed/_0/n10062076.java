class n10062076 {
	private long generateNativeInstallExe(File SuUcyl4V, String ops7R8fN, File LbNnXYxs) throws IOException {
		InputStream aErxfK0J = getClass().getResourceAsStream("/" + ops7R8fN);
		ByteArrayOutputStream wZDe1GB6 = new ByteArrayOutputStream();
		String E6Zg51Qf = "000000000000";
		byte[] xoW3SvSV = new byte[E6Zg51Qf.length()];
		NumberFormat ZME2Istz = NumberFormat.getInstance(Locale.US);
		ZME2Istz.setGroupingUsed(false);
		ZME2Istz.setMinimumIntegerDigits(E6Zg51Qf.length());
		int VRrTmIKz = 0;
		long dNdytHmT = aErxfK0J.available();
		int MnUWqZDP = 0;
		System.out.println(VAGlobals.i18n("VAArchiver_GenerateInstallExe"));
		aErxfK0J.read(xoW3SvSV, 0, xoW3SvSV.length);
		MnUWqZDP = 1;
		for (int VftOdblh = 0; VftOdblh < 3; VftOdblh++) {
			while ((!new String(xoW3SvSV).equals("clname_here_")) && (!new String(xoW3SvSV).equals("clstart_here"))
					&& (!new String(xoW3SvSV).equals("clstop_here_"))) {
				wZDe1GB6.write(xoW3SvSV[0]);
				int jkIC8YU6 = aErxfK0J.read();
				MnUWqZDP++;
				shiftArray(xoW3SvSV);
				xoW3SvSV[xoW3SvSV.length - 1] = (byte) jkIC8YU6;
			}
			if (new String(xoW3SvSV).equals("clname_here_")) {
				VAGlobals.printDebug("  clname_here_ found at " + (MnUWqZDP - 1));
				StringBuffer OlBP4C6C = new StringBuffer(64);
				OlBP4C6C.append(instClassName_);
				for (int OsgEZa3H = OlBP4C6C.length() - 1; OsgEZa3H < 64; OsgEZa3H++) {
					OlBP4C6C.append('.');
				}
				byte[] oFlLckgU = OlBP4C6C.toString().getBytes();
				for (int KZgD3y3O = 0; KZgD3y3O < 64; KZgD3y3O++) {
					wZDe1GB6.write(oFlLckgU[KZgD3y3O]);
					MnUWqZDP++;
				}
				aErxfK0J.skip(64 - xoW3SvSV.length);
				aErxfK0J.read(xoW3SvSV, 0, xoW3SvSV.length);
			} else if (new String(xoW3SvSV).equals("clstart_here")) {
				VAGlobals.printDebug("  clstart_here found at " + (MnUWqZDP - 1));
				xoW3SvSV = ZME2Istz.format(dNdytHmT).getBytes();
				for (int HxIga4yB = 0; HxIga4yB < xoW3SvSV.length; HxIga4yB++) {
					wZDe1GB6.write(xoW3SvSV[HxIga4yB]);
					MnUWqZDP++;
				}
				aErxfK0J.read(xoW3SvSV, 0, xoW3SvSV.length);
			} else if (new String(xoW3SvSV).equals("clstop_here_")) {
				VAGlobals.printDebug("  clstop_here_ found at " + (MnUWqZDP - 1));
				VRrTmIKz = MnUWqZDP - 1;
				wZDe1GB6.write(xoW3SvSV);
				MnUWqZDP += 12;
				aErxfK0J.read(xoW3SvSV, 0, xoW3SvSV.length);
			}
		}
		wZDe1GB6.write(xoW3SvSV);
		xoW3SvSV = new byte[2048];
		int rL9gaGfH = aErxfK0J.read(xoW3SvSV);
		while (rL9gaGfH > 0) {
			wZDe1GB6.write(xoW3SvSV, 0, rL9gaGfH);
			rL9gaGfH = aErxfK0J.read(xoW3SvSV);
		}
		aErxfK0J.close();
		FileInputStream SRXD2qFj = new FileInputStream(LbNnXYxs);
		rL9gaGfH = SRXD2qFj.read(xoW3SvSV);
		while (rL9gaGfH > 0) {
			wZDe1GB6.write(xoW3SvSV, 0, rL9gaGfH);
			rL9gaGfH = SRXD2qFj.read(xoW3SvSV);
		}
		SRXD2qFj.close();
		wZDe1GB6.close();
		byte[] ZxQEPdZh = wZDe1GB6.toByteArray();
		E6Zg51Qf = ZME2Istz.format(ZxQEPdZh.length);
		byte[] YodCev2w = E6Zg51Qf.getBytes();
		for (int OCwIJPNW = 0; OCwIJPNW < YodCev2w.length; OCwIJPNW++) {
			ZxQEPdZh[VRrTmIKz + OCwIJPNW] = YodCev2w[OCwIJPNW];
		}
		FileOutputStream tmXvK2nc = new FileOutputStream(SuUcyl4V);
		tmXvK2nc.write(ZxQEPdZh);
		tmXvK2nc.close();
		return dNdytHmT;
	}

}