class n11343453 {
	public static String getWebpage(String ncfjljWB) {
		String mgarj9n8 = "";
		if (!ncfjljWB.trim().toLowerCase().startsWith("http://")) {
			ncfjljWB = "http://" + ncfjljWB;
		}
		try {
			BufferedReader SjHOuo62 = new BufferedReader(new InputStreamReader(new URL(ncfjljWB).openStream()));
			String D6BplcHB;
			while ((D6BplcHB = SjHOuo62.readLine()) != null) {
				mgarj9n8 += D6BplcHB + "\n";
			}
			SjHOuo62.close();
		} catch (MalformedURLException tFAF3deU) {
			tFAF3deU.printStackTrace();
		} catch (IOException vkeuBFq6) {
			vkeuBFq6.printStackTrace();
		} catch (Exception dyvVa6Jq) {
			dyvVa6Jq.printStackTrace();
		}
		return mgarj9n8;
	}

}