class n12082135 {
	public static Set<Province> getProvincias(String pURL) {
		String iniProv = "<prov>";
		Set<Province> result = new HashSet<Province>();
		String finProv = "</prov>";
		String iniNomProv = "<np>";
		String finNomProv = "</np>";
		String iniCodigo = "<cpine>";
		int ini, fin;
		String finCodigo = "</cpine>";
		try {
			URL url = new URL(pURL);
			String str;
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			Province provincia;
			while ((str = br.readLine()) != null) {
				if (str.contains(iniProv)) {
					provincia = new Province();
					while ((str = br.readLine()) != null && !str.contains(finProv)) {
						if (str.contains(iniNomProv)) {
							ini = str.indexOf(iniNomProv) + iniNomProv.length();
							fin = str.indexOf(finNomProv);
							provincia.setDescription(str.substring(ini, fin));
						}
						if (str.contains(iniCodigo)) {
							ini = str.indexOf(iniCodigo) + iniCodigo.length();
							fin = str.indexOf(finCodigo);
							provincia.setCodeProvince(Integer.parseInt(str.substring(ini, fin)));
						}
					}
					result.add(provincia);
				}
			}
			br.close();
		} catch (Exception e) {
			System.err.println(e);
		}
		return result;
	}

}