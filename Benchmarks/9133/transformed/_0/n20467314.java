class n20467314 {
	public List<String> makeQuery(String Bwbqn9f8) {
		List<String> PeVXODum = new ArrayList<String>();
		try {
			Bwbqn9f8 = URLUTF8Encoder.encode(Bwbqn9f8);
			URL OBcduhmo = new URL(
					"http://ajax.googleapis.com/ajax/services/search/web?start=0&rsz=large&v=1.0&q=" + Bwbqn9f8);
			URLConnection zdsQyWd7 = OBcduhmo.openConnection();
			zdsQyWd7.addRequestProperty("Referer", "http://poo.sk");
			String RA7ScdPG;
			StringBuilder EPlnVBMU = new StringBuilder();
			BufferedReader QaISYVbb = new BufferedReader(new InputStreamReader(zdsQyWd7.getInputStream()));
			while ((RA7ScdPG = QaISYVbb.readLine()) != null) {
				EPlnVBMU.append(RA7ScdPG);
			}
			String dN7tT0HE = EPlnVBMU.toString();
			JSONObject oNN2xyb8 = new JSONObject(dN7tT0HE);
			Long I2UmT7QA = Long.decode(
					oNN2xyb8.getJSONObject("responseData").getJSONObject("cursor").getString("estimatedResultCount"));
			LOG.info("Found " + I2UmT7QA + " potential pages");
			JSONArray l7ss2BB6 = oNN2xyb8.getJSONObject("responseData").getJSONArray("results");
			for (int Jj63TVVO = 0; Jj63TVVO < l7ss2BB6.length(); Jj63TVVO++) {
				JSONObject yWR3eA8D = l7ss2BB6.getJSONObject(Jj63TVVO);
				PeVXODum.add(yWR3eA8D.getString("url"));
			}
		} catch (Exception wllhDIMi) {
			LOG.error("Couldnt query Google for some reason check exception below");
			wllhDIMi.printStackTrace();
		}
		return PeVXODum;
	}

}