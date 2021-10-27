class n10363910 {
	private String getPayLoadWithCookie(String A56RTH3b) {
		StringBuffer Vn5WgPFL = new StringBuffer();
		if (this.cookie != null) {
			try {
				Log.debug("Requesting url ==> " + A56RTH3b);
				URLConnection ICNYrgAV = new URL(A56RTH3b).openConnection();
				ICNYrgAV.setDoOutput(true);
				ICNYrgAV.addRequestProperty("Cookie", this.cookie);
				BufferedReader Bk7mCuJ0 = new BufferedReader(new InputStreamReader(ICNYrgAV.getInputStream()));
				String fD8Alqqk = "";
				while ((fD8Alqqk = Bk7mCuJ0.readLine()) != null) {
					Vn5WgPFL.append(fD8Alqqk + "\n");
				}
			} catch (MalformedURLException dzD1LBAA) {
				dzD1LBAA.printStackTrace();
			} catch (IOException ebg4BOyF) {
				ebg4BOyF.printStackTrace();
			}
		}
		return Vn5WgPFL.toString();
	}

}