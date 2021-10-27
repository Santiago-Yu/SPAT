class n12082150 {
	public static Set<Address> getDatosCatastrales(String WmyFPs8x) {
		Set<Address> MhL3RvLc = new HashSet<Address>();
		String Zg3zpeWW = "<cuerr>";
		String k75evqJP = "</cuerr>";
		String OVSifm90 = "<des>";
		String Ux0dd4ih = "</des>";
		String XDUOEcON = "<rcdnp>";
		String EweaFPYV = "</rcdnp>";
		String bgnKaAhh = "<bi>";
		String v8jG9sDR = "</bi>";
		String Xy2zOhLw = "<pc1>";
		String jCYNF3JI = "<pc2>";
		String YE0vCOfd = "</pc1>";
		String k2eb9cPW = "</pc2>";
		String d9uyTDVw = "<car>";
		String jbvhoGEQ = "</car>";
		String jUW0I6NA = "<cc1>";
		String yqQss71e = "</cc1>";
		String sM8HK8d1 = "<cc2>";
		String HupYZN2b = "</cc2>";
		String HiYXweWv = "<ldt>";
		String bq8ZQ4U5 = "<bq>";
		String lokqKjNg = "</bq>";
		String JfOn77af = "<es>";
		String dlalptAf = "</es>";
		String I3rOfnfa = "<pt>";
		String RXUVKUbE = "</pt>";
		String bSspFt1o = "<pu>";
		String WrL60yAm = "</pu>";
		boolean QlI049f7 = false;
		int dm9suJ49, UjWwnEkr;
		int zKKZ2vmA = 0;
		try {
			URL R15cenE1 = new URL(WmyFPs8x);
			BufferedReader vHYQdXkM = new BufferedReader(new InputStreamReader(R15cenE1.openStream()));
			String Bz84Og6m;
			while ((Bz84Og6m = vHYQdXkM.readLine()) != null) {
				if (Bz84Og6m.contains(Zg3zpeWW)) {
					dm9suJ49 = Bz84Og6m.indexOf(Zg3zpeWW) + Zg3zpeWW.length();
					UjWwnEkr = Bz84Og6m.indexOf(k75evqJP);
					if (Integer.parseInt(Bz84Og6m.substring(dm9suJ49, UjWwnEkr)) > 0)
						QlI049f7 = true;
				}
				if (QlI049f7) {
					if (Bz84Og6m.contains(OVSifm90)) {
						dm9suJ49 = Bz84Og6m.indexOf(OVSifm90) + OVSifm90.length();
						UjWwnEkr = Bz84Og6m.indexOf(Ux0dd4ih);
						throw (new Exception(Bz84Og6m.substring(dm9suJ49, UjWwnEkr)));
					}
				} else {
					if (Bz84Og6m.contains(XDUOEcON) || Bz84Og6m.contains(bgnKaAhh)) {
						Address Ww3sqBfg = new Address();
						while ((Bz84Og6m = vHYQdXkM.readLine()) != null && !Bz84Og6m.contains(EweaFPYV)
								&& !Bz84Og6m.contains(v8jG9sDR)) {
							if (Bz84Og6m.contains(Xy2zOhLw) && Bz84Og6m.contains(YE0vCOfd)) {
								dm9suJ49 = Bz84Og6m.indexOf(Xy2zOhLw) + Xy2zOhLw.length();
								UjWwnEkr = Bz84Og6m.indexOf(YE0vCOfd);
								Ww3sqBfg.setDescription(Bz84Og6m.substring(dm9suJ49, UjWwnEkr));
							}
							if (Bz84Og6m.contains(jCYNF3JI) && Bz84Og6m.contains(k2eb9cPW)) {
								dm9suJ49 = Bz84Og6m.indexOf(jCYNF3JI) + jCYNF3JI.length();
								UjWwnEkr = Bz84Og6m.indexOf(k2eb9cPW);
								Ww3sqBfg.setDescription(
										Ww3sqBfg.getDescription().concat(Bz84Og6m.substring(dm9suJ49, UjWwnEkr)));
							}
							if (Bz84Og6m.contains(HiYXweWv) && Bz84Og6m.contains("-")) {
								zKKZ2vmA = Integer.parseInt(
										Bz84Og6m.substring(Bz84Og6m.lastIndexOf("-") - 5, Bz84Og6m.lastIndexOf("-")));
							}
							if (Bz84Og6m.contains(d9uyTDVw) && Bz84Og6m.contains(jbvhoGEQ)) {
								dm9suJ49 = Bz84Og6m.indexOf(d9uyTDVw) + d9uyTDVw.length();
								UjWwnEkr = Bz84Og6m.indexOf(jbvhoGEQ);
								Ww3sqBfg.setDescription(
										Ww3sqBfg.getDescription().concat(Bz84Og6m.substring(dm9suJ49, UjWwnEkr)));
							}
							if (Bz84Og6m.contains(jUW0I6NA) && Bz84Og6m.contains(yqQss71e)) {
								dm9suJ49 = Bz84Og6m.indexOf(jUW0I6NA) + jUW0I6NA.length();
								UjWwnEkr = Bz84Og6m.indexOf(yqQss71e);
								Ww3sqBfg.setDescription(
										Ww3sqBfg.getDescription().concat(Bz84Og6m.substring(dm9suJ49, UjWwnEkr)));
							}
							if (Bz84Og6m.contains(sM8HK8d1) && Bz84Og6m.contains(HupYZN2b)) {
								dm9suJ49 = Bz84Og6m.indexOf(sM8HK8d1) + sM8HK8d1.length();
								UjWwnEkr = Bz84Og6m.indexOf(HupYZN2b);
								Ww3sqBfg.setDescription(
										Ww3sqBfg.getDescription().concat(Bz84Og6m.substring(dm9suJ49, UjWwnEkr)));
							}
							if (Bz84Og6m.contains(bq8ZQ4U5) && Bz84Og6m.contains(lokqKjNg)) {
								dm9suJ49 = Bz84Og6m.indexOf(bq8ZQ4U5) + bq8ZQ4U5.length();
								UjWwnEkr = Bz84Og6m.indexOf(lokqKjNg);
								Ww3sqBfg.setBlock(Bz84Og6m.substring(dm9suJ49, UjWwnEkr));
							}
							if (Bz84Og6m.contains(JfOn77af) && Bz84Og6m.contains(dlalptAf)) {
								dm9suJ49 = Bz84Og6m.indexOf(JfOn77af) + JfOn77af.length();
								UjWwnEkr = Bz84Og6m.indexOf(dlalptAf);
								Ww3sqBfg.setStairs(Bz84Og6m.substring(dm9suJ49, UjWwnEkr));
							}
							if (Bz84Og6m.contains(I3rOfnfa) && Bz84Og6m.contains(RXUVKUbE)) {
								dm9suJ49 = Bz84Og6m.indexOf(I3rOfnfa) + I3rOfnfa.length();
								UjWwnEkr = Bz84Og6m.indexOf(RXUVKUbE);
								Ww3sqBfg.setFloor(Bz84Og6m.substring(dm9suJ49, UjWwnEkr));
							}
							if (Bz84Og6m.contains(bSspFt1o) && Bz84Og6m.contains(WrL60yAm)) {
								dm9suJ49 = Bz84Og6m.indexOf(bSspFt1o) + bSspFt1o.length();
								UjWwnEkr = Bz84Og6m.indexOf(WrL60yAm);
								Ww3sqBfg.setDoor(Bz84Og6m.substring(dm9suJ49, UjWwnEkr));
							}
						}
						MhL3RvLc.add(Ww3sqBfg);
					}
				}
			}
			vHYQdXkM.close();
			if (MhL3RvLc.size() == 1) {
				Object RVg49pQm[] = MhL3RvLc.toArray();
				Coordinate XF5D50Wb = ConversorCoordenadas.getCoordenadas(((Address) RVg49pQm[0]).getDescription());
				XF5D50Wb.setPostcode(zKKZ2vmA);
				for (Address QOhixe2b : MhL3RvLc)
					QOhixe2b.setCoodinate(XF5D50Wb);
			}
		} catch (Exception H4c7w2Tj) {
			System.err.println(H4c7w2Tj);
		}
		return MhL3RvLc;
	}

}