class n3541461 {
	public static String get(String strUrl) {
		if (NoMuleRuntime.DEBUG)
			System.out.println("GET : " + strUrl);
		try {
			URL url = new URL(strUrl);
			URLConnection conn = url.openConnection();
			String s = "";
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String sRet = "";
			while ((s = in.readLine()) != null) {
				sRet += s;
			}
			NoMuleRuntime.showDebug("ANSWER: " + sRet);
			return sRet;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

}