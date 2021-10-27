class n21601084 {
	public static void main(String[] mQQWg1LV) throws Exception {
		HttpClient N7MUazK0 = new DefaultHttpClient();
		InputStream kEWwgkmI = CheckAvailability.class.getResourceAsStream("/isbns.txt");
		BufferedReader ldl4KUdK = new BufferedReader(new InputStreamReader(kEWwgkmI));
		String UeLOIBMq = null;
		HttpGet DXGDvCPj = null;
		while ((UeLOIBMq = ldl4KUdK.readLine().split(" ")[0]) != null) {
			System.out.println("Target url: \n\t" + String.format(isbnSearchUrl, UeLOIBMq));
			DXGDvCPj = new HttpGet(String.format(isbnSearchUrl, UeLOIBMq));
			HttpResponse ORJGUfWh = N7MUazK0.execute(DXGDvCPj);
			Scanner wn9oevdl = new Scanner(ORJGUfWh.getEntity().getContent());
			String TIz0IhcV = wn9oevdl
					.findWithinHorizon("((\\d*) hold[s]? on first copy returned of (\\d*) )?[cC]opies", 0);
			if (TIz0IhcV != null) {
				MatchResult Vq8mbkd8 = wn9oevdl.match();
				if (Vq8mbkd8.groupCount() == 3) {
					if (Vq8mbkd8.group(2) == null) {
						System.out.println(UeLOIBMq + ": copies available");
					} else {
						System.out.println(
								UeLOIBMq + ": " + Vq8mbkd8.group(2) + " holds on " + Vq8mbkd8.group(3) + " copies");
					}
				}
			} else {
				System.out.println(UeLOIBMq + ": no match");
			}
			DXGDvCPj.abort();
		}
	}

}