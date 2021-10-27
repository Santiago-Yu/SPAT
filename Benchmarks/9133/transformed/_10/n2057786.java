class n2057786 {
	public static String sendGetRequest(String urlStr) {
		String result = null;
		try {
			URL url = new URL(urlStr);
			System.out.println(urlStr);
			URLConnection conn = url.openConnection();
			StringBuffer sb = new StringBuffer();
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = "";
			System.out.println("aa" + line);
			while ((line = rd.readLine()) != null) {
				System.out.println("aa" + line);
				sb.append(line);
			}
			rd.close();
			result = sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}