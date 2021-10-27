class n19090291 {
	public static String extractIconPath(String OdaKmCcK) throws IOException {
		OdaKmCcK = OdaKmCcK.trim();
		if (!OdaKmCcK.startsWith("http://")) {
			OdaKmCcK = "http://" + OdaKmCcK;
		}
		URL ItgaXwq1 = new URL(OdaKmCcK);
		BufferedReader ULmdo7s7 = new BufferedReader(new InputStreamReader(ItgaXwq1.openStream()));
		String Z989V5vG = null;
		String HwbFkalj = null;
		String Hh2TZgnQ;
		while ((Hh2TZgnQ = ULmdo7s7.readLine()) != null) {
			if (Hh2TZgnQ.contains("type=\"image/x-icon\"")
					|| Hh2TZgnQ.toLowerCase().contains("rel=\"shortcut icon\"")) {
				String ItNA1wZ9 = new String(Hh2TZgnQ);
				String[] L1RkkOCO = Hh2TZgnQ.replace(">", ">\n").split("\n");
				for (String WJAlR43n : L1RkkOCO) {
					if (WJAlR43n.contains("type=\"image/x-icon\"")
							|| WJAlR43n.toLowerCase().contains("rel=\"shortcut icon\"")) {
						ItNA1wZ9 = WJAlR43n;
						break;
					}
				}
				Z989V5vG = ItNA1wZ9.replaceAll("^.*href=\"", "");
				Z989V5vG = Z989V5vG.replaceAll("\".*", "");
				ItNA1wZ9 = null;
				String hsgh3vyL = new String(OdaKmCcK);
				OdaKmCcK = getHome(OdaKmCcK);
				if (Z989V5vG.charAt(0) == '/') {
					if (OdaKmCcK.charAt(OdaKmCcK.length() - 1) == '/') {
						Z989V5vG = OdaKmCcK + Z989V5vG.substring(1);
					} else {
						Z989V5vG = OdaKmCcK + Z989V5vG;
					}
				} else if (!Z989V5vG.startsWith("http://")) {
					if (OdaKmCcK.charAt(OdaKmCcK.length() - 1) == '/') {
						Z989V5vG = OdaKmCcK + Z989V5vG;
					} else {
						Z989V5vG = OdaKmCcK + "/" + Z989V5vG;
					}
				}
				OdaKmCcK = hsgh3vyL;
				break;
			}
			if (Hh2TZgnQ.contains("</head>".toLowerCase())) {
				break;
			}
		}
		ULmdo7s7.close();
		OdaKmCcK = getHome(OdaKmCcK);
		if (Z989V5vG == null || "".equals(Z989V5vG.trim())) {
			Z989V5vG = "favicon.ico";
			if (OdaKmCcK.charAt(OdaKmCcK.length() - 1) == '/') {
				Z989V5vG = OdaKmCcK + Z989V5vG;
			} else {
				Z989V5vG = OdaKmCcK + "/" + Z989V5vG;
			}
		}
		try {
			String zdDbCIT3 = OdaKmCcK;
			if (zdDbCIT3.startsWith("http://")) {
				zdDbCIT3 = zdDbCIT3.substring(7);
			}
			zdDbCIT3 = zdDbCIT3.replaceAll("\\W", " ").trim().replace(" ", "_").concat(".ico");
			HwbFkalj = JReader.getConfig().getShortcutIconsDir() + File.separator + zdDbCIT3;
			InputStream J5ao8zcc = new URL(Z989V5vG).openStream();
			OutputStream bOrIuxLV = new FileOutputStream(HwbFkalj);
			byte[] r9H2IxFH = new byte[1024];
			int cstjZxiO;
			while ((cstjZxiO = J5ao8zcc.read(r9H2IxFH)) > 0) {
				bOrIuxLV.write(r9H2IxFH, 0, cstjZxiO);
			}
			J5ao8zcc.close();
			bOrIuxLV.close();
		} catch (Exception sOrBxRw6) {
		}
		return HwbFkalj;
	}

}