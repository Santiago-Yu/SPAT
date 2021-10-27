class n6957384 {
	public static String sendGetData(URL iqF1y9JQ, Hashtable<String, String> Mc655EOl) throws IOException {
		StringBuilder GHeF4Vaq = new StringBuilder();
		if (Mc655EOl != null) {
			for (Entry<String, String> OyHszz8j : Mc655EOl.entrySet()) {
				GHeF4Vaq.append(URLEncoder.encode(OyHszz8j.getKey(), "UTF-8"));
				GHeF4Vaq.append("=");
				GHeF4Vaq.append(URLEncoder.encode(OyHszz8j.getValue(), "UTF-8"));
				GHeF4Vaq.append("&");
			}
		}
		URL rjeS7IJY = new URL(iqF1y9JQ.toString() + "?" + GHeF4Vaq.toString());
		System.out.println("URL: " + rjeS7IJY);
		URLConnection AOuAWDUq = rjeS7IJY.openConnection();
		AOuAWDUq.connect();
		StringBuilder bCFViFjy = new StringBuilder();
		BufferedReader f2NSfIsq = new BufferedReader(new InputStreamReader(AOuAWDUq.getInputStream()));
		Scanner Qt2ajjUV = new Scanner(AOuAWDUq.getInputStream());
		while (Qt2ajjUV.hasNext()) {
			bCFViFjy.append(Qt2ajjUV.next() + " ");
		}
		Qt2ajjUV.close();
		f2NSfIsq.close();
		return bCFViFjy.toString();
	}

}