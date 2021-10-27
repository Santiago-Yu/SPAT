class n5433055 {
	public static Coordinate getCoordenadas(String FvQPt6e3) {
		Coordinate jq8JRjzf = new Coordinate();
		String gxdbTKV5;
		String dvmo582h = "<pc1>";
		String wXfgUv8q = "<pc2>";
		String GBJvuin6 = "</pc1>";
		String OM4xKTYZ = "</pc2>";
		String ETc5o1K4 = "<xcen>";
		String aB5uV1Nn = "<ycen>";
		String rvl5dMxa = "</xcen>";
		String OHPGuDMl = "</ycen>";
		String pxzFVtzM = "<cuerr>";
		String pBNd0eP1 = "</cuerr>";
		String EOSV0SL8 = "<des>";
		String v1HZLDzt = "</des>";
		boolean zescyF0V = false;
		int lieldUxZ, XL0DNzbB;
		if (FvQPt6e3.contains("/") || FvQPt6e3.contains("\\") || FvQPt6e3.contains("."))
			gxdbTKV5 = FvQPt6e3;
		else {
			if (FvQPt6e3.length() > 14)
				gxdbTKV5 = baseURL[1].replace("<RC>", FvQPt6e3.substring(0, 14));
			else
				gxdbTKV5 = baseURL[1].replace("<RC>", FvQPt6e3);
		}
		try {
			URL ixU8nqsZ = new URL(gxdbTKV5);
			BufferedReader uQryCThF = new BufferedReader(new InputStreamReader(ixU8nqsZ.openStream()));
			String pgJqqni1;
			while ((pgJqqni1 = uQryCThF.readLine()) != null) {
				if (pgJqqni1.contains(pxzFVtzM)) {
					lieldUxZ = pgJqqni1.indexOf(pxzFVtzM) + pxzFVtzM.length();
					XL0DNzbB = pgJqqni1.indexOf(pBNd0eP1);
					if (Integer.parseInt(pgJqqni1.substring(lieldUxZ, XL0DNzbB)) > 0)
						zescyF0V = true;
				}
				if (zescyF0V) {
					if (pgJqqni1.contains(EOSV0SL8)) {
						lieldUxZ = pgJqqni1.indexOf(EOSV0SL8) + EOSV0SL8.length();
						XL0DNzbB = pgJqqni1.indexOf(v1HZLDzt);
						throw (new Exception(pgJqqni1.substring(lieldUxZ, XL0DNzbB)));
					}
				} else {
					if (pgJqqni1.contains(dvmo582h)) {
						lieldUxZ = pgJqqni1.indexOf(dvmo582h) + dvmo582h.length();
						XL0DNzbB = pgJqqni1.indexOf(GBJvuin6);
						jq8JRjzf.setDescription(pgJqqni1.substring(lieldUxZ, XL0DNzbB));
					}
					if (pgJqqni1.contains(wXfgUv8q)) {
						lieldUxZ = pgJqqni1.indexOf(wXfgUv8q) + wXfgUv8q.length();
						XL0DNzbB = pgJqqni1.indexOf(OM4xKTYZ);
						jq8JRjzf.setDescription(
								jq8JRjzf.getDescription().concat(pgJqqni1.substring(lieldUxZ, XL0DNzbB)));
					}
					if (pgJqqni1.contains(ETc5o1K4)) {
						lieldUxZ = pgJqqni1.indexOf(ETc5o1K4) + ETc5o1K4.length();
						XL0DNzbB = pgJqqni1.indexOf(rvl5dMxa);
						jq8JRjzf.setLongitude(Double.parseDouble(pgJqqni1.substring(lieldUxZ, XL0DNzbB)));
					}
					if (pgJqqni1.contains(aB5uV1Nn)) {
						lieldUxZ = pgJqqni1.indexOf(aB5uV1Nn) + aB5uV1Nn.length();
						XL0DNzbB = pgJqqni1.indexOf(OHPGuDMl);
						jq8JRjzf.setLatitude(Double.parseDouble(pgJqqni1.substring(lieldUxZ, XL0DNzbB)));
					}
				}
			}
			uQryCThF.close();
		} catch (Exception hizdce0J) {
			System.err.println(hizdce0J);
		}
		return jq8JRjzf;
	}

}