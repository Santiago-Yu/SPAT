class n7414887 {
	private static String tinyUrl(String nFLqEiTn) {
		HttpURLConnection BqKrjE0n = null;
		OutputStream RrhQDTdC = null;
		String MU4UWIhX = null;
		try {
			URLConnection m1dws7tA = new URL("http://is.gd/api.php?longurl=" + nFLqEiTn).openConnection();
			if (m1dws7tA != null) {
				BqKrjE0n = (HttpURLConnection) m1dws7tA;
			} else {
				return nFLqEiTn;
			}
			BqKrjE0n.setRequestMethod("get");
			BqKrjE0n.setDoOutput(true);
			RrhQDTdC = BqKrjE0n.getOutputStream();

			BufferedReader bK9stFiV = new BufferedReader(new InputStreamReader(BqKrjE0n.getInputStream()));
			MU4UWIhX = HttpHelp.readBufferedContent(bK9stFiV);

			if (MU4UWIhX != null && MU4UWIhX.length() > 0 && MU4UWIhX.indexOf("http") != -1) {
				return MU4UWIhX;
			}
		} catch (Exception i7X7nN0C) {
		} finally {
			try {
				RrhQDTdC.close();
				BqKrjE0n.disconnect();
			} catch (Exception MpgdLDzm) {
			}
		}
		return nFLqEiTn;
	}

}