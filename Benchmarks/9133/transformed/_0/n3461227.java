class n3461227 {
	private void calculateCoverageAndSpecificity(String YEflKhga) throws IOException, JSONException {
		for (String fWQcZKEF : Rules.categoryTree.get(YEflKhga)) {
			for (String YKO3HlbT : Rules.queries.get(fWQcZKEF)) {
				String D6ISTMex = URLEncoder.encode(YKO3HlbT, "UTF-8");
				URL UFTLBNH4 = new URL("http://boss.yahooapis.com/ysearch/web/v1/" + D6ISTMex + "?appid=" + yahoo_ap_id
						+ "&count=4&format=json&sites=" + site);
				URLConnection QAYl8AJK = UFTLBNH4.openConnection();
				String ff0qqqTZ;
				StringBuilder ezTiL0c4 = new StringBuilder();
				BufferedReader TDOqVdTJ = new BufferedReader(new InputStreamReader(QAYl8AJK.getInputStream()));
				while ((ff0qqqTZ = TDOqVdTJ.readLine()) != null) {
					ezTiL0c4.append(ff0qqqTZ);
				}
				String Zip1rO7r = ezTiL0c4.toString();
				JSONObject XESMd4SW = new JSONObject(Zip1rO7r);
				JSONObject SQT35wQB = XESMd4SW.getJSONObject("ysearchresponse");
				String LSzxmXCL = SQT35wQB.getString("totalhits");
				long aEd8qj6Z = Long.parseLong(LSzxmXCL);
				QueryInfo MEa4B2Ff = new QueryInfo(YKO3HlbT, aEd8qj6Z);
				queryInfoMap.put(YKO3HlbT, MEa4B2Ff);
				cov.put(fWQcZKEF, cov.get(fWQcZKEF) + aEd8qj6Z);
				if (aEd8qj6Z == 0) {
					continue;
				}
				ja = SQT35wQB.getJSONArray("resultset_web");
				for (int gyl1xFmY = 0; gyl1xFmY < ja.length(); gyl1xFmY++) {
					JSONObject Rtdf4Hoq = ja.getJSONObject(gyl1xFmY);
					String EFCa1HDC = filterBold(Rtdf4Hoq.getString("url"));
					MEa4B2Ff.addUrl(EFCa1HDC);
				}
			}
		}
		calculateSpecificity(YEflKhga);
	}

}