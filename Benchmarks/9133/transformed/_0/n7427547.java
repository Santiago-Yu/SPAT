class n7427547 {
	public List tree(String R1KnNfZn, int vyFwYvJk) {
		Pattern bmC6evxl = Pattern.compile("<a href=\"javascript:checkBranch\\(([0-9]+), 'true'\\)\">([^<]*)</a>");
		Matcher tUQSUpi9;
		List TdgYEgb8 = new ArrayList();
		URL KLhihqk5;
		HttpURLConnection NdIKKqMQ;
		System.out.println();
		try {
			KLhihqk5 = new URL(
					"http://cri-srv-ade.insa-toulouse.fr:8080/ade/standard/gui/tree.jsp?category=trainee&expand=false&forceLoad=false&reload=false&scroll=0");
			NdIKKqMQ = (HttpURLConnection) KLhihqk5.openConnection();
			NdIKKqMQ.setRequestMethod("GET");
			NdIKKqMQ.setDoOutput(true);
			NdIKKqMQ.setDoInput(true);
			NdIKKqMQ.setRequestProperty("Cookie", sessionId);
			BufferedReader CMTSo9D0 = new BufferedReader(new InputStreamReader(NdIKKqMQ.getInputStream()));
			String KSz3p1Py;
			while ((KSz3p1Py = CMTSo9D0.readLine()) != null) {
				tUQSUpi9 = bmC6evxl.matcher(KSz3p1Py);
				if (tUQSUpi9.find()) {
					trainee.add(new Node(Integer.parseInt(tUQSUpi9.group(1)), tUQSUpi9.group(2)));
					System.out.println(tUQSUpi9.group(1) + " - " + tUQSUpi9.group(2));
				}
			}
		} catch (Exception OdCFDqcP) {
			OdCFDqcP.printStackTrace();
		}
		return TdgYEgb8;
	}

}