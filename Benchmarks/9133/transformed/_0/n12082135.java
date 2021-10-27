class n12082135 {
	public static Set<Province> getProvincias(String J32zfR7S) {
		Set<Province> o108NkPw = new HashSet<Province>();
		String G03KjRRh = "<prov>";
		String SaJ7IcPm = "</prov>";
		String WLm1fndJ = "<np>";
		String yejlTBtY = "</np>";
		String lRjMYnZs = "<cpine>";
		String qV5KQdSr = "</cpine>";
		int wonWiZW2, OiZ34QYN;
		try {
			URL A4EcP4zs = new URL(J32zfR7S);
			BufferedReader xYIP70FM = new BufferedReader(new InputStreamReader(A4EcP4zs.openStream()));
			String U4UI0avk;
			Province qJapepIZ;
			while ((U4UI0avk = xYIP70FM.readLine()) != null) {
				if (U4UI0avk.contains(G03KjRRh)) {
					qJapepIZ = new Province();
					while ((U4UI0avk = xYIP70FM.readLine()) != null && !U4UI0avk.contains(SaJ7IcPm)) {
						if (U4UI0avk.contains(WLm1fndJ)) {
							wonWiZW2 = U4UI0avk.indexOf(WLm1fndJ) + WLm1fndJ.length();
							OiZ34QYN = U4UI0avk.indexOf(yejlTBtY);
							qJapepIZ.setDescription(U4UI0avk.substring(wonWiZW2, OiZ34QYN));
						}
						if (U4UI0avk.contains(lRjMYnZs)) {
							wonWiZW2 = U4UI0avk.indexOf(lRjMYnZs) + lRjMYnZs.length();
							OiZ34QYN = U4UI0avk.indexOf(qV5KQdSr);
							qJapepIZ.setCodeProvince(Integer.parseInt(U4UI0avk.substring(wonWiZW2, OiZ34QYN)));
						}
					}
					o108NkPw.add(qJapepIZ);
				}
			}
			xYIP70FM.close();
		} catch (Exception LnfhJrR3) {
			System.err.println(LnfhJrR3);
		}
		return o108NkPw;
	}

}