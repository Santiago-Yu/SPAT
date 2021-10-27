class n12082137 {
	public static Set<Municipality> getMunicipios(String NqYicIj2) {
		Set<Municipality> FVChg6ZQ = new HashSet<Municipality>();
		String WSUS4o9y = "<cuerr>";
		String hgKFaLrA = "</cuerr>";
		String iI1Wy8Ek = "<des>";
		String hbDXBRKh = "</des>";
		String ZC0QFaG5 = "<muni>";
		String qkjbl9a0 = "</muni>";
		String u2e3d2fQ = "<nm>";
		String BeUVpWGH = "</nm>";
		String T8ybDKU6 = "<carto>";
		String ZO10n6W9 = "<cd>";
		String OKtjycg3 = "</cd>";
		String q3z1LmZ9 = "<cmc>";
		String P5xE3yCH = "</cmc>";
		String WKRqxQrU = "<cp>";
		String dafCRWgY = "</cp>";
		String KbVQXBeo = "<cm>";
		String p3l6XBX3 = "</cm>";
		boolean c0uLClBD = false;
		int UL0Hxu29, Y4oXAuHa;
		try {
			URL yKRC3iPy = new URL(NqYicIj2);
			BufferedReader mST3SHZ6 = new BufferedReader(new InputStreamReader(yKRC3iPy.openStream()));
			String huAggwzu;
			Municipality g6EbEUOV;
			while ((huAggwzu = mST3SHZ6.readLine()) != null) {
				if (huAggwzu.contains(WSUS4o9y)) {
					UL0Hxu29 = huAggwzu.indexOf(WSUS4o9y) + WSUS4o9y.length();
					Y4oXAuHa = huAggwzu.indexOf(hgKFaLrA);
					if (Integer.parseInt(huAggwzu.substring(UL0Hxu29, Y4oXAuHa)) > 0)
						c0uLClBD = true;
				}
				if (c0uLClBD) {
					if (huAggwzu.contains(iI1Wy8Ek)) {
						UL0Hxu29 = huAggwzu.indexOf(iI1Wy8Ek) + iI1Wy8Ek.length();
						Y4oXAuHa = huAggwzu.indexOf(hbDXBRKh);
						throw (new Exception(huAggwzu.substring(UL0Hxu29, Y4oXAuHa)));
					}
				} else {
					if (huAggwzu.contains(ZC0QFaG5)) {
						g6EbEUOV = new Municipality();
						g6EbEUOV.setCodemunicipalityine(0);
						g6EbEUOV.setCodemunicipalitydgc(0);
						while ((huAggwzu = mST3SHZ6.readLine()) != null && !huAggwzu.contains(qkjbl9a0)) {
							if (huAggwzu.contains(u2e3d2fQ)) {
								UL0Hxu29 = huAggwzu.indexOf(u2e3d2fQ) + u2e3d2fQ.length();
								Y4oXAuHa = huAggwzu.indexOf(BeUVpWGH);
								g6EbEUOV.setMuniName(huAggwzu.substring(UL0Hxu29, Y4oXAuHa).trim());
							}
							if (huAggwzu.contains(T8ybDKU6)) {
								if (huAggwzu.contains("URBANA"))
									g6EbEUOV.setIsurban(true);
								if (huAggwzu.contains("RUSTICA"))
									g6EbEUOV.setIsrustic(true);
							}
							if (huAggwzu.contains(ZO10n6W9)) {
								UL0Hxu29 = huAggwzu.indexOf(ZO10n6W9) + ZO10n6W9.length();
								Y4oXAuHa = huAggwzu.indexOf(OKtjycg3);
								g6EbEUOV.setCodemunicipalitydgc(g6EbEUOV.getCodemunicipalitydgc()
										+ Integer.parseInt(huAggwzu.substring(UL0Hxu29, Y4oXAuHa)) * 1000);
							}
							if (huAggwzu.contains(q3z1LmZ9)) {
								UL0Hxu29 = huAggwzu.indexOf(q3z1LmZ9) + q3z1LmZ9.length();
								Y4oXAuHa = huAggwzu.indexOf(P5xE3yCH);
								g6EbEUOV.setCodemunicipalitydgc(g6EbEUOV.getCodemunicipalitydgc()
										+ Integer.parseInt(huAggwzu.substring(UL0Hxu29, Y4oXAuHa)));
							}
							if (huAggwzu.contains(WKRqxQrU)) {
								UL0Hxu29 = huAggwzu.indexOf(WKRqxQrU) + WKRqxQrU.length();
								Y4oXAuHa = huAggwzu.indexOf(dafCRWgY);
								g6EbEUOV.setCodemunicipalityine(g6EbEUOV.getCodemunicipalityine()
										+ Integer.parseInt(huAggwzu.substring(UL0Hxu29, Y4oXAuHa)) * 1000);
							}
							if (huAggwzu.contains(KbVQXBeo)) {
								UL0Hxu29 = huAggwzu.indexOf(KbVQXBeo) + KbVQXBeo.length();
								Y4oXAuHa = huAggwzu.indexOf(p3l6XBX3);
								g6EbEUOV.setCodemunicipalityine(g6EbEUOV.getCodemunicipalityine()
										+ Integer.parseInt(huAggwzu.substring(UL0Hxu29, Y4oXAuHa)));
							}
							g6EbEUOV.setDescription();
						}
						FVChg6ZQ.add(g6EbEUOV);
					}
				}
			}
			mST3SHZ6.close();
		} catch (Exception V0Lbm3nn) {
			System.err.println(V0Lbm3nn);
		}
		return FVChg6ZQ;
	}

}