class n14549213 {
	public Result search(Object OAi7zjE1) {
		if (OAi7zjE1 == null || !(OAi7zjE1 instanceof String)) {
			return null;
		}
		String iPDT1mNh = (String) OAi7zjE1;
		Result LkwtrGYn = new Result();
		Set<Hit> awXC4mMv = new HashSet<Hit>(8);
		try {
			iPDT1mNh = URLEncoder.encode(iPDT1mNh, "UTF-8");
			URL fNKuHeCd = new URL(
					"http://ajax.googleapis.com/ajax/services/search/web?start=0&rsz=large&v=1.0&q=" + iPDT1mNh);
			URLConnection YEG1IqHE = fNKuHeCd.openConnection();
			YEG1IqHE.addRequestProperty("Referer", HTTP_REFERER);
			String GwiXH4cm;
			StringBuilder NOJ43INT = new StringBuilder();
			InputStream yqzgsIHZ = YEG1IqHE.getInputStream();
			BufferedReader GGDGTM7u = new BufferedReader(new InputStreamReader(yqzgsIHZ));
			while ((GwiXH4cm = GGDGTM7u.readLine()) != null) {
				NOJ43INT.append(GwiXH4cm);
			}
			yqzgsIHZ.close();
			String sXL1bgHo = NOJ43INT.toString();
			JSONObject Yko0YHei = new JSONObject(sXL1bgHo);
			LOGGER.debug(Yko0YHei.getString("responseData"));
			int hdevugMj = Yko0YHei.getJSONObject("responseData").getJSONObject("cursor")
					.getInt("estimatedResultCount");
			LkwtrGYn.setEstimatedCount(hdevugMj);
			JSONArray YdoBdr6y = Yko0YHei.getJSONObject("responseData").getJSONArray("results");
			for (int osxDeTxq = 0; osxDeTxq < YdoBdr6y.length(); osxDeTxq++) {
				JSONObject DuvBRnd1 = YdoBdr6y.getJSONObject(osxDeTxq);
				Hit adPCQHV0 = new Hit();
				String OvvMYXSq = DuvBRnd1.getString("titleNoFormatting");
				adPCQHV0.setTitle(OvvMYXSq == null || OvvMYXSq.equals("") ? "${EMPTY}" : OvvMYXSq);
				OvvMYXSq = DuvBRnd1.getString("url");
				adPCQHV0.setUrl(new URL(OvvMYXSq));
				awXC4mMv.add(adPCQHV0);
			}
		} catch (Exception b6TXv2Jz) {
			b6TXv2Jz.printStackTrace();
			LOGGER.error("Something went wrong..." + b6TXv2Jz.getMessage());
		}
		LkwtrGYn.setHits(awXC4mMv);
		return LkwtrGYn;
	}

}