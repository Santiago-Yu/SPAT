class n5433054 {
	public static String getRefCatastral(String pURL) {
		String result = new String();
		String iniPC1 = "<pc1>";
		String iniPC2 = "<pc2>";
		String finPC1 = "</pc1>";
		String finPC2 = "</pc2>";
		String iniCuerr = "<cuerr>";
		String finCuerr = "</cuerr>";
		String iniDesErr = "<des>";
		String finDesErr = "</des>";
		boolean error = false;
		int ini, fin;
		try {
			URL url = new URL(pURL);
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			String str;
			while ((str = in.readLine()) != null) {
				if (str.contains(iniCuerr)) {
					ini = str.indexOf(iniCuerr) + iniCuerr.length();
					fin = str.indexOf(finCuerr);
					error = (Integer.parseInt(str.substring(ini, fin)) > 0) ? true : error;
				}
				if (error) {
					if (str.contains(iniDesErr)) {
						ini = str.indexOf(iniDesErr) + iniDesErr.length();
						fin = str.indexOf(finDesErr);
						throw (new Exception(str.substring(ini, fin)));
					}
				} else {
					if (str.contains(iniPC1)) {
						ini = str.indexOf(iniPC1) + iniPC1.length();
						fin = str.indexOf(finPC1);
						result = str.substring(ini, fin);
					}
					if (str.contains(iniPC2)) {
						ini = str.indexOf(iniPC2) + iniPC2.length();
						fin = str.indexOf(finPC2);
						result = result.concat(str.substring(ini, fin));
					}
				}
			}
			in.close();
		} catch (Exception e) {
			System.err.println(e);
		}
		return result;
	}

}