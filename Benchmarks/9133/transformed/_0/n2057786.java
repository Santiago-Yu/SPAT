class n2057786 {
	public static String sendGetRequest(String sqNZsP3v) {
		String BymXfiuv = null;
		try {
			URL r4J2ZwDY = new URL(sqNZsP3v);
			System.out.println(sqNZsP3v);
			URLConnection MpgHXEdP = r4J2ZwDY.openConnection();
			BufferedReader gC9VlPsx = new BufferedReader(new InputStreamReader(MpgHXEdP.getInputStream()));
			StringBuffer xl7f0tHy = new StringBuffer();
			String eZE9CZdm = "";
			System.out.println("aa" + eZE9CZdm);
			while ((eZE9CZdm = gC9VlPsx.readLine()) != null) {
				System.out.println("aa" + eZE9CZdm);
				xl7f0tHy.append(eZE9CZdm);
			}
			gC9VlPsx.close();
			BymXfiuv = xl7f0tHy.toString();
		} catch (Exception vJzuHrVG) {
			vJzuHrVG.printStackTrace();
		}
		return BymXfiuv;
	}

}