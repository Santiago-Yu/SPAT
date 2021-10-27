class n21601084 {
	public static void main(String[] args) throws Exception {
		HttpClient httpclient = new DefaultHttpClient();
		InputStream is = CheckAvailability.class.getResourceAsStream("/isbns.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String isbn = null;
		HttpGet get = null;
		for (; (isbn = br.readLine().split(" ")[0]) != null;) {
			System.out.println("Target url: \n\t" + String.format(isbnSearchUrl, isbn));
			get = new HttpGet(String.format(isbnSearchUrl, isbn));
			HttpResponse resp = httpclient.execute(get);
			Scanner s = new Scanner(resp.getEntity().getContent());
			String pattern = s.findWithinHorizon("((\\d*) hold[s]? on first copy returned of (\\d*) )?[cC]opies", 0);
			if (pattern != null) {
				MatchResult match = s.match();
				if (match.groupCount() == 3) {
					if (match.group(2) == null) {
						System.out.println(isbn + ": copies available");
					} else {
						System.out.println(isbn + ": " + match.group(2) + " holds on " + match.group(3) + " copies");
					}
				}
			} else {
				System.out.println(isbn + ": no match");
			}
			get.abort();
		}
	}

}