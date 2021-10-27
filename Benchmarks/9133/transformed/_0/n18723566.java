class n18723566 {
	public String performRequest(TreeMap<String, String> wKCC1xw3, boolean rD8caAyQ) {
		wKCC1xw3.put("format", "json");
		try {
			URL KLCC9l1u = new URL(getApiUrl(wKCC1xw3, rD8caAyQ));
			HttpURLConnection Zm5snklS = (HttpURLConnection) KLCC9l1u.openConnection();
			Zm5snklS.setRequestMethod("GET");
			Zm5snklS.connect();
			Reader v6na5J6Q = new BufferedReader(new InputStreamReader(Zm5snklS.getInputStream()));
			String KMYMpls3 = "";
			while (v6na5J6Q.ready()) {
				KMYMpls3 += (char) v6na5J6Q.read();
			}
			KMYMpls3 = KMYMpls3.replaceFirst("jsonVimeoApi\\(", "");
			KMYMpls3 = KMYMpls3.substring(0, KMYMpls3.length() - 2);
			return KMYMpls3;
		} catch (MalformedURLException FCrTuEeR) {
			FCrTuEeR.printStackTrace();
		} catch (IOException n0FR1YgC) {
			n0FR1YgC.printStackTrace();
		}
		return null;
	}

}