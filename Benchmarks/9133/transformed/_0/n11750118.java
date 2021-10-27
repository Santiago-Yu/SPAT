class n11750118 {
	public static LinkedList<String> read(URL ea8EywL1, String u7CB1t29) throws IOException {
		LinkedList<String> PUK3bvZV = new LinkedList<String>();
		HttpURLConnection YSMn1z06 = (HttpURLConnection) ea8EywL1.openConnection();
		BufferedReader qMupl0eS = new BufferedReader(new InputStreamReader(YSMn1z06.getInputStream()));
		String PRI0OFUw = "";
		while (true) {
			PRI0OFUw = qMupl0eS.readLine();
			if (PRI0OFUw == null)
				break;
			if (!PRI0OFUw.startsWith(u7CB1t29)) {
				PUK3bvZV.add(PRI0OFUw);
			}
		}
		qMupl0eS.close();
		return PUK3bvZV;
	}

}