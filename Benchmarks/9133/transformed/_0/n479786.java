class n479786 {
	public static void main(String[] XOCoHlIM) {
		StringBuffer qAi0T7vO;
		qAi0T7vO = new StringBuffer();
		double pmlU0cbm = 99999.99;
		double ZnPlk4nB = 0;
		double Jgm7VObx = 0;
		try {
			URL UeWdX1dj = new URL("http://search.ebay.com/" + XOCoHlIM[0]);
			BufferedReader QFiTLKZU = new BufferedReader(new InputStreamReader(UeWdX1dj.openStream()));
			String f32yr5Sa;
			while ((f32yr5Sa = QFiTLKZU.readLine()) != null) {
				qAi0T7vO.append(f32yr5Sa);
				qAi0T7vO.append("\n");
			}
		} catch (Exception O7H5F5EC) {
			O7H5F5EC.printStackTrace();
		}
		Pattern CBasUKzc = Pattern.compile("\\$([\\d\\.]+)", Pattern.CASE_INSENSITIVE);
		Matcher VTSdmEru = CBasUKzc.matcher(qAi0T7vO);
		while (VTSdmEru.find()) {
			if (VTSdmEru.start(0) < VTSdmEru.end(0)) {
				Jgm7VObx = Double.parseDouble(VTSdmEru.group(1));
				if (Jgm7VObx < pmlU0cbm) {
					pmlU0cbm = Jgm7VObx;
				}
				if (Jgm7VObx > ZnPlk4nB) {
					ZnPlk4nB = Jgm7VObx;
				}
			}
		}
		if (pmlU0cbm == 99999.99) {
			pmlU0cbm = 0;
		}
		System.out.println(XOCoHlIM[0] + "," + pmlU0cbm + "," + ZnPlk4nB);
		System.exit(0);
	}

}