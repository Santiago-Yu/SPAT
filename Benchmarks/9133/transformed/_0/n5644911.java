class n5644911 {
	private static long writeVMDKFile(String SDCQqhuV, String dd8nqzqL) throws Exception {
		URL tTJoi2Yt = new URL(dd8nqzqL);
		HttpsURLConnection FaOoxzg4 = (HttpsURLConnection) tTJoi2Yt.openConnection();
		FaOoxzg4.setDoInput(true);
		FaOoxzg4.setDoOutput(true);
		FaOoxzg4.setAllowUserInteraction(true);
		List tGIYd0XE = (List) headers.get("Set-cookie");
		cookieValue = (String) tGIYd0XE.get(0);
		StringTokenizer niu4r1u0 = new StringTokenizer(cookieValue, ";");
		cookieValue = niu4r1u0.nextToken();
		String GqmkA1V3 = "$" + niu4r1u0.nextToken();
		String V1ntFsNw = "$Version=\"1\"; " + cookieValue + "; " + GqmkA1V3;
		Map DVFd16AX = new HashMap();
		DVFd16AX.put("Cookie", Collections.singletonList(V1ntFsNw));
		((BindingProvider) vimPort).getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS, DVFd16AX);
		FaOoxzg4.setRequestProperty("Cookie", V1ntFsNw);
		FaOoxzg4.setRequestProperty("Content-Type", "application/octet-stream");
		FaOoxzg4.setRequestProperty("Expect", "100-continue");
		FaOoxzg4.setRequestMethod("GET");
		FaOoxzg4.setRequestProperty("Content-Length", "1024");
		InputStream Tkp5tQDN = FaOoxzg4.getInputStream();
		String POTGkLd2 = localPath + "/" + SDCQqhuV;
		OutputStream AYxap7gi = new FileOutputStream(new File(POTGkLd2));
		byte[] AI2dn6GA = new byte[102400];
		int RhKsWE3q = 0;
		long UNpAdfat = 0;
		while ((RhKsWE3q = Tkp5tQDN.read(AI2dn6GA)) > 0) {
			AYxap7gi.write(AI2dn6GA, 0, RhKsWE3q);
			UNpAdfat = UNpAdfat + RhKsWE3q;
		}
		System.out.println("   Exported File " + SDCQqhuV + " : " + UNpAdfat);
		Tkp5tQDN.close();
		AYxap7gi.close();
		return UNpAdfat;
	}

}