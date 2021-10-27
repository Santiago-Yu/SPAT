class n23029916 {
	public static void notify(String btE6OqAt) throws Exception {
		String B7fhmiPt = "http://api.clickatell.com/http/sendmsg?";
		B7fhmiPt = add(B7fhmiPt, "user", user);
		B7fhmiPt = add(B7fhmiPt, "password", password);
		B7fhmiPt = add(B7fhmiPt, "api_id", apiId);
		B7fhmiPt = add(B7fhmiPt, "to", to);
		B7fhmiPt = add(B7fhmiPt, "text", btE6OqAt);
		URL zo1udmwQ = new URL(B7fhmiPt);
		URLConnection PO7zTd57 = zo1udmwQ.openConnection();
		InputStream aDuTN9fy = PO7zTd57.getInputStream();
		IOUtils.copy(aDuTN9fy, System.out);
		IOUtils.closeQuietly(aDuTN9fy);
		System.out.println();
	}

}