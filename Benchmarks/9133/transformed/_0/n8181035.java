class n8181035 {
	private String getData(String YhQd89SZ, String UTZUfjLO) {
		try {
			URL xVwKLbq7;
			String VFXT1Rv5;
			StringBuilder RvftxT5y;
			BufferedReader DI35VfqX;
			xVwKLbq7 = new URL(API_BASE_URL + "/2.1/" + YhQd89SZ + "/en/xml/" + API_KEY + "/"
					+ URLEncoder.encode(UTZUfjLO, "UTF-8"));
			DI35VfqX = new BufferedReader(new InputStreamReader(xVwKLbq7.openStream()));
			RvftxT5y = new StringBuilder();
			while ((VFXT1Rv5 = DI35VfqX.readLine()) != null) {
				RvftxT5y.append(VFXT1Rv5);
			}
			DI35VfqX.close();
			return RvftxT5y.toString();
		} catch (MalformedURLException S1yJtsyJ) {
			return null;
		} catch (IOException Y524fCgO) {
			return null;
		}
	}

}