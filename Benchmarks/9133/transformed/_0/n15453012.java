class n15453012 {
	public ArrayList parseFile(File XJ15ZAK8) throws IOException {
		String KFduCdw8;
		String YarVqHVp;
		String kYu1DmIB;
		String o5mpN64T = null;
		Integer sYHVSomA = new Integer(0);
		String[] VpJTTufV;
		int HARscEZ4 = 0;
		double Ozt7O4q9, a1bpJ3g4, FYmQsFWY;
		double du2dffcF = 1.0;
		double YVcrBycm = 1.0;
		double YCc77YRX = 1.0;
		double fm6LP7yG = 1.0;
		double b85LF6ha = 1.0;
		double Rb3yfjJE = 1.0;
		boolean Vlq8ekIW = false;
		boolean uTV3DPZE = false;
		boolean wnE1D8lB = false;
		boolean bXKCFYnS = false;
		boolean ajTEOwV3 = false;
		ArrayList WE8VQPKz = new ArrayList();
		ArrayList bot0NFFO = new ArrayList();
		ArrayList RNkfQzu9 = new ArrayList();
		ArrayList O2U876qo = new ArrayList();
		ArrayList IEgXaooD = new ArrayList();
		ArrayList rr8gwksm = new ArrayList();
		ArrayList jusQgqW6 = new ArrayList();
		ArrayList wc8fgltp = new ArrayList();
		URL UjG9AsyX = XJ15ZAK8.toURI().toURL();
		InputStream TYfYYtsq = UjG9AsyX.openStream();
		InputStreamReader o6fVWmfj = new InputStreamReader(TYfYYtsq);
		BufferedReader tr4TgP3q = new BufferedReader(o6fVWmfj);
		while ((KFduCdw8 = tr4TgP3q.readLine()) != null) {
			VpJTTufV = KFduCdw8.split("\\s+");
			HARscEZ4 = VpJTTufV.length;
			YarVqHVp = (String) VpJTTufV[0];
			if (((String) VpJTTufV[0]).length() == 0) {
				uTV3DPZE = false;
				Vlq8ekIW = false;
				continue;
			}
			if ((HARscEZ4 == 4) && (!YarVqHVp.startsWith("---"))) {
				if ((Double.parseDouble(VpJTTufV[1]) == 0.) && (Double.parseDouble(VpJTTufV[2]) == 0.)
						&& (Double.parseDouble(VpJTTufV[3]) == 0.)) {
					wnE1D8lB = true;
				} else {
					wnE1D8lB = false;
				}
				if (VpJTTufV[1].equals("NaN") || VpJTTufV[2].equals("NaN") || VpJTTufV[3].equals("NaN")) {
					bXKCFYnS = true;
				} else {
					bXKCFYnS = false;
				}
			}
			if (YarVqHVp.startsWith("start")) {
				kYu1DmIB = KFduCdw8;
			}
			if (YarVqHVp.indexOf("WS") > 0) {
				if (o5mpN64T != null) {
					dumpData(o5mpN64T, WE8VQPKz, IEgXaooD, rr8gwksm, jusQgqW6, wc8fgltp, RNkfQzu9, O2U876qo, bot0NFFO);
				}
				o5mpN64T = VpJTTufV[0];
				uTV3DPZE = false;
				Vlq8ekIW = false;
				wnE1D8lB = false;
				bXKCFYnS = false;
				ajTEOwV3 = false;
				WE8VQPKz.clear();
				bot0NFFO.clear();
				RNkfQzu9.clear();
				O2U876qo.clear();
				IEgXaooD.clear();
				rr8gwksm.clear();
				jusQgqW6.clear();
				wc8fgltp.clear();
			}
			if (YarVqHVp.startsWith("Area"))
				;
			if (YarVqHVp.startsWith("Ampl"))
				;
			if (YarVqHVp.startsWith("Mean"))
				;
			if (YarVqHVp.startsWith("Sigma")) {
				WE8VQPKz.add(new Double(Double.parseDouble(VpJTTufV[3])));
				WE8VQPKz.add(new Double(Double.parseDouble(VpJTTufV[1])));
				WE8VQPKz.add(new Double(Double.parseDouble(VpJTTufV[5])));
			}
			if (YarVqHVp.startsWith("Offset"))
				;
			if (YarVqHVp.startsWith("Slope"))
				;
			if ((YarVqHVp.equals("Position")) && (((String) VpJTTufV[2]).equals("Raw"))) {
				uTV3DPZE = true;
				continue;
			}
			if ((YarVqHVp.equals("Position")) && (((String) VpJTTufV[2]).equals("Fit"))) {
				Vlq8ekIW = true;
				continue;
			}
			if ((YarVqHVp.contains("Harp"))) {
				bot0NFFO.clear();
				RNkfQzu9.clear();
				O2U876qo.clear();
				IEgXaooD.clear();
				rr8gwksm.clear();
				jusQgqW6.clear();
				wc8fgltp.clear();
				ajTEOwV3 = true;
				uTV3DPZE = true;
				o5mpN64T = VpJTTufV[0];
				continue;
			}
			if (YarVqHVp.startsWith("---"))
				continue;
			if (ajTEOwV3 == true) {
				if (((String) VpJTTufV[0]).length() != 0) {
					if (YarVqHVp.startsWith("PVLogger")) {
						try {
							sYHVSomA = new Integer(Integer.parseInt(VpJTTufV[2]));
						} catch (NumberFormatException d2spwkwB) {
						}
					} else {
						rr8gwksm.add(new Double(Double.parseDouble(VpJTTufV[0])));
						bot0NFFO.add(new Double(Double.parseDouble(VpJTTufV[1])));
						jusQgqW6.add(new Double(Double.parseDouble(VpJTTufV[2])));
						RNkfQzu9.add(new Double(Double.parseDouble(VpJTTufV[3])));
						wc8fgltp.add(new Double(Double.parseDouble(VpJTTufV[4])));
						O2U876qo.add(new Double(Double.parseDouble(VpJTTufV[5])));
					}
				}
				continue;
			}
			if (uTV3DPZE && (!wnE1D8lB) && (!bXKCFYnS)) {
				IEgXaooD.add(new Double(Double.parseDouble(VpJTTufV[0]) / Math.sqrt(2.0)));
				rr8gwksm.add(new Double(Double.parseDouble(VpJTTufV[0]) / Math.sqrt(2.0)));
				jusQgqW6.add(new Double(Double.parseDouble(VpJTTufV[0]) / Math.sqrt(2.0)));
				wc8fgltp.add(new Double(Double.parseDouble(VpJTTufV[0])));
				RNkfQzu9.add(new Double(Double.parseDouble(VpJTTufV[1])));
				O2U876qo.add(new Double(Double.parseDouble(VpJTTufV[2])));
				bot0NFFO.add(new Double(Double.parseDouble(VpJTTufV[3])));
			}
			if (YarVqHVp.startsWith("PVLogger")) {
				try {
					sYHVSomA = new Integer(Integer.parseInt(VpJTTufV[2]));
				} catch (NumberFormatException gxUrvCCU) {
				}
			}
		}
		dumpData(o5mpN64T, WE8VQPKz, IEgXaooD, rr8gwksm, jusQgqW6, wc8fgltp, RNkfQzu9, O2U876qo, bot0NFFO);
		wiredata.add((Integer) sYHVSomA);
		return wiredata;
	}

}