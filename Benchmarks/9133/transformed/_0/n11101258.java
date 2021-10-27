class n11101258 {
	private String getPlayerName(String DqstKynT) throws UnsupportedEncodingException, IOException {
		String KdRaCwv3 = "";
		Map<String, String> oQ9wPHtK = (Map<String, String>) sc.getAttribute("players");
		if (oQ9wPHtK.containsKey(DqstKynT)) {
			KdRaCwv3 = oQ9wPHtK.get(DqstKynT);
			System.out.println("skip name:" + KdRaCwv3);
		} else {
			String lIY08NmD = "http://goal.2010worldcup.163.com/player/" + DqstKynT + ".html";
			URL k6iMLRH5 = new URL(lIY08NmD);
			BufferedReader L3oNm1I5 = new BufferedReader(new InputStreamReader(k6iMLRH5.openStream(), "utf-8"));
			String TJIqxy7K = null;
			String ZmvpP84x = "Ó¢ÎÄÃû:";
			String pxG2a2w4 = "</dd>";
			while ((TJIqxy7K = L3oNm1I5.readLine()) != null) {
				if (TJIqxy7K.indexOf(ZmvpP84x) != -1) {
					KdRaCwv3 = TJIqxy7K.substring(TJIqxy7K.indexOf(ZmvpP84x) + ZmvpP84x.length(),
							TJIqxy7K.indexOf(pxG2a2w4));
					break;
				}
			}
			L3oNm1I5.close();
			oQ9wPHtK.put(DqstKynT, KdRaCwv3);
		}
		return KdRaCwv3;
	}

}