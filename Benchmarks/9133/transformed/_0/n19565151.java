class n19565151 {
	private long generateNativeInstallExe(File m4VTqcfL, String sqEvf1mw, File GB4yK51h) throws IOException {
		InputStream IaybOOQh = getClass().getResourceAsStream("/" + sqEvf1mw);
		System.out.println("generateNativeInstallExe = /" + sqEvf1mw);
		System.out.println("reader length=" + IaybOOQh.available());
		ByteArrayOutputStream ofvZHPc4 = new ByteArrayOutputStream();
		String W9mzq0GX = "000000000000";
		byte[] MgBiRUvK = new byte[W9mzq0GX.length()];
		NumberFormat x88uuafy = NumberFormat.getInstance(Locale.US);
		x88uuafy.setGroupingUsed(false);
		x88uuafy.setMinimumIntegerDigits(W9mzq0GX.length());
		int Oxg1yRiw = 0;
		long getty4HT = IaybOOQh.available();
		int f7CyWAo6 = 0;
		System.out.println(VAGlobals.i18n("VAArchiver_GenerateInstallExe"));
		IaybOOQh.read(MgBiRUvK, 0, MgBiRUvK.length);
		f7CyWAo6 = 1;
		for (int DbRPDBZm = 0; DbRPDBZm < 3; DbRPDBZm++) {
			while ((!new String(MgBiRUvK).equals("clname_here_")) && (!new String(MgBiRUvK).equals("clstart_here"))
					&& (!new String(MgBiRUvK).equals("clstop_here_"))) {
				ofvZHPc4.write(MgBiRUvK[0]);
				int uTmzaM0T = IaybOOQh.read();
				f7CyWAo6++;
				shiftArray(MgBiRUvK);
				MgBiRUvK[MgBiRUvK.length - 1] = (byte) uTmzaM0T;
			}
			if (new String(MgBiRUvK).equals("clname_here_")) {
				System.err.println("  clname_here_ found at " + (f7CyWAo6 - 1));
				StringBuffer yBYcJQ1g = new StringBuffer(64);
				yBYcJQ1g.append(instClassName_);
				for (int AyyA0aHz = yBYcJQ1g.length() - 1; AyyA0aHz < 64; AyyA0aHz++) {
					yBYcJQ1g.append('.');
				}
				byte[] AAklX6sR = yBYcJQ1g.toString().getBytes();
				for (int NPZpjBjR = 0; NPZpjBjR < 64; NPZpjBjR++) {
					ofvZHPc4.write(AAklX6sR[NPZpjBjR]);
					f7CyWAo6++;
				}
				IaybOOQh.skip(64 - MgBiRUvK.length);
				IaybOOQh.read(MgBiRUvK, 0, MgBiRUvK.length);
			} else if (new String(MgBiRUvK).equals("clstart_here")) {
				System.err.println("  clstart_here found at " + (f7CyWAo6 - 1));
				MgBiRUvK = x88uuafy.format(getty4HT).getBytes();
				for (int vkCv8hfg = 0; vkCv8hfg < MgBiRUvK.length; vkCv8hfg++) {
					ofvZHPc4.write(MgBiRUvK[vkCv8hfg]);
					f7CyWAo6++;
				}
				IaybOOQh.read(MgBiRUvK, 0, MgBiRUvK.length);
			} else if (new String(MgBiRUvK).equals("clstop_here_")) {
				System.err.println("  clstop_here_ found at " + (f7CyWAo6 - 1));
				Oxg1yRiw = f7CyWAo6 - 1;
				ofvZHPc4.write(MgBiRUvK);
				f7CyWAo6 += 12;
				IaybOOQh.read(MgBiRUvK, 0, MgBiRUvK.length);
			}
		}
		ofvZHPc4.write(MgBiRUvK);
		MgBiRUvK = new byte[2048];
		int EcWbMNbv = IaybOOQh.read(MgBiRUvK);
		while (EcWbMNbv > 0) {
			ofvZHPc4.write(MgBiRUvK, 0, EcWbMNbv);
			EcWbMNbv = IaybOOQh.read(MgBiRUvK);
		}
		IaybOOQh.close();
		FileInputStream fK4remBN = new FileInputStream(GB4yK51h);
		EcWbMNbv = fK4remBN.read(MgBiRUvK);
		while (EcWbMNbv > 0) {
			ofvZHPc4.write(MgBiRUvK, 0, EcWbMNbv);
			EcWbMNbv = fK4remBN.read(MgBiRUvK);
		}
		fK4remBN.close();
		ofvZHPc4.close();
		byte[] StibpOeZ = ofvZHPc4.toByteArray();
		W9mzq0GX = x88uuafy.format(StibpOeZ.length);
		byte[] gYQy1xio = W9mzq0GX.getBytes();
		for (int Gah2sxMm = 0; Gah2sxMm < gYQy1xio.length; Gah2sxMm++) {
			StibpOeZ[Oxg1yRiw + Gah2sxMm] = gYQy1xio[Gah2sxMm];
		}
		FileOutputStream ID9STJZC = new FileOutputStream(m4VTqcfL);
		ID9STJZC.write(StibpOeZ);
		ID9STJZC.close();
		return getty4HT;
	}

}