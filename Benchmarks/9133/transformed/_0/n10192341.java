class n10192341 {
	@SuppressWarnings("unchecked")
	public static void main(String[] iVOFn3l2) throws Exception {
		PositionParser rd7Lj8Kt;
		Database.init("XIDResult");
		rd7Lj8Kt = new PositionParser("01:33:50.904+30:39:35.79");
		String lBWv03QD = "http://simbad.u-strasbg.fr/simbad/sim-script?submit=submit+script&script=";
		String HwuJZpky = "format object \"%IDLIST[%-30*]|-%COO(A)|%COO(D)|%OTYPELIST(S)\"\n";
		String j6H2Bwfd = "";
		HwuJZpky += rd7Lj8Kt.getPosition() + " radius=1m";
		lBWv03QD += URLEncoder.encode(HwuJZpky, "ISO-8859-1");
		URL K3n9h4Hr = new URL(lBWv03QD);
		BufferedReader aDBvG6tN = new BufferedReader(new InputStreamReader(K3n9h4Hr.openStream()));
		String We80U03R;
		boolean bq60DHvW = false;
		JSONObject fOPjaPnd = new JSONObject();
		JSONArray tjl3DWFx = new JSONArray();
		JSONArray UHJBBnGr = new JSONArray();
		JSONObject kqeaED0G = new JSONObject();
		kqeaED0G.put("sTitle", "ID");
		UHJBBnGr.add(kqeaED0G);
		kqeaED0G = new JSONObject();
		kqeaED0G.put("sTitle", "Position");
		UHJBBnGr.add(kqeaED0G);
		kqeaED0G = new JSONObject();
		kqeaED0G.put("sTitle", "Type");
		UHJBBnGr.add(kqeaED0G);
		fOPjaPnd.put("aoColumns", UHJBBnGr);
		int aYfA3PSc = 0;
		while ((We80U03R = aDBvG6tN.readLine()) != null) {
			if (bq60DHvW) {
				String[] QYexi7f8 = We80U03R.trim().split("\\|", -1);
				int hJ5P2XH8 = QYexi7f8.length - 1;
				if (hJ5P2XH8 >= 3) {
					String QfA13jxH = QYexi7f8[hJ5P2XH8];
					hJ5P2XH8--;
					String pIsXIS0Z = QYexi7f8[hJ5P2XH8];
					hJ5P2XH8--;
					String aFcTX1mT = QYexi7f8[hJ5P2XH8];
					String ELUoylG7 = "";
					for (int xdPqKC39 = 0; xdPqKC39 < hJ5P2XH8; xdPqKC39++) {
						ELUoylG7 += QYexi7f8[xdPqKC39];
						if (xdPqKC39 < (hJ5P2XH8 - 1)) {
							ELUoylG7 += "|";
						}
					}
					if (ELUoylG7.length() <= 30) {
						JSONArray M2WyAq2s = new JSONArray();
						M2WyAq2s.add(ELUoylG7.trim());
						M2WyAq2s.add(aFcTX1mT + " " + pIsXIS0Z);
						M2WyAq2s.add(QfA13jxH.trim());
						tjl3DWFx.add(M2WyAq2s);
						aYfA3PSc++;
					}
				}
			} else if (We80U03R.startsWith("::data")) {
				bq60DHvW = true;
			}
		}
		fOPjaPnd.put("aaData", tjl3DWFx);
		fOPjaPnd.put("iTotalRecords", aYfA3PSc);
		fOPjaPnd.put("iTotalDisplayRecords", aYfA3PSc);
		System.out.println(fOPjaPnd.toJSONString());
		aDBvG6tN.close();
	}

}