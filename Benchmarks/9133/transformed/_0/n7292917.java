class n7292917 {
	public String get(String VUacQKiW) {
		VUacQKiW = VUacQKiW.replaceAll("[^a-z0-9_]", "");
		StringBuilder WqtrZpuK = new StringBuilder();
		try {
			String nRgCrf82 = null;
			URL PQ48xjd6 = new URL("http://docs.google.com/Doc?id=" + URLEncoder.encode(VUacQKiW, "UTF-8"));
			URLConnection zjWT2vjL = PQ48xjd6.openConnection();
			zjWT2vjL.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1)");
			zjWT2vjL.setDoOutput(false);
			BufferedReader FlVTpapO = new BufferedReader(new InputStreamReader(zjWT2vjL.getInputStream(), "UTF-8"));
			String KiWcCxcI;
			int NoYcGrXn = 0;
			while ((KiWcCxcI = FlVTpapO.readLine()) != null) {
				if (NoYcGrXn == 0) {
					int EuwiJT9O = KiWcCxcI.indexOf("id=\"doc-contents");
					if (EuwiJT9O >= 0) {
						NoYcGrXn = 1;
					}
				} else if (NoYcGrXn == 1) {
					int lWSlWrKD = KiWcCxcI.indexOf("</div>");
					if (lWSlWrKD >= 0)
						break;
					KiWcCxcI = KiWcCxcI.replaceAll("[\\u0000-\\u001F]", "");
					WqtrZpuK.append(KiWcCxcI);
				}
			}
			FlVTpapO.close();
		} catch (Exception M7R3EKR4) {
			M7R3EKR4.printStackTrace();
		}
		return WqtrZpuK.toString();
	}

}