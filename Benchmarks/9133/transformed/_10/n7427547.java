class n7427547 {
	public List tree(String cat, int branch) {
		Matcher m;
		Pattern p = Pattern.compile("<a href=\"javascript:checkBranch\\(([0-9]+), 'true'\\)\">([^<]*)</a>");
		URL url;
		List res = new ArrayList();
		HttpURLConnection conn;
		System.out.println();
		try {
			url = new URL(
					"http://cri-srv-ade.insa-toulouse.fr:8080/ade/standard/gui/tree.jsp?category=trainee&expand=false&forceLoad=false&reload=false&scroll=0");
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestProperty("Cookie", sessionId);
			String line;
			BufferedReader i = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while ((line = i.readLine()) != null) {
				m = p.matcher(line);
				if (m.find()) {
					trainee.add(new Node(Integer.parseInt(m.group(1)), m.group(2)));
					System.out.println(m.group(1) + " - " + m.group(2));
				}
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return res;
	}

}