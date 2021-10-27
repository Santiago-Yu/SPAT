class n12734324 {
	public static String post(String bcbMU34J, Map N2JAEHSM, String hQRJVQ5N) {
		String TM9xs4Qd = "";
		try {
			URL aUK5CJoT = new URL(bcbMU34J);
			URLConnection dVjjU7Ca = aUK5CJoT.openConnection();
			dVjjU7Ca.setDoOutput(true);
			OutputStreamWriter BhJ2nPZA = new OutputStreamWriter(dVjjU7Ca.getOutputStream());
			String nK3KdNOH = "";
			int Xy9Vvzsu = N2JAEHSM.size();
			Iterator We4iKdH0 = N2JAEHSM.entrySet().iterator();
			for (int CxQcwfxT = 0; CxQcwfxT < Xy9Vvzsu; CxQcwfxT++) {
				Map.Entry nTm75yDA = (Map.Entry) We4iKdH0.next();
				String riK7XJot = (String) nTm75yDA.getKey();
				String eZ0VoVye = (String) nTm75yDA.getValue();
				if (CxQcwfxT > 0)
					nK3KdNOH += "&";
				nK3KdNOH += URLEncoder.encode(riK7XJot, "UTF-8") + "=" + URLEncoder.encode(eZ0VoVye, "UTF-8");
			}
			BhJ2nPZA.write(nK3KdNOH);
			BhJ2nPZA.flush();
			BufferedReader APZenUaj = new BufferedReader(new InputStreamReader(dVjjU7Ca.getInputStream()));
			String oQb61Ike;
			while ((oQb61Ike = APZenUaj.readLine()) != null)
				TM9xs4Qd += oQb61Ike + hQRJVQ5N;
			BhJ2nPZA.close();
			APZenUaj.close();
		} catch (Exception szJU4W88) {
			System.err.println(szJU4W88);
		}
		return TM9xs4Qd;
	}

}