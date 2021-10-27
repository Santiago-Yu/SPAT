class n7275980 {
	public static void main(String[] eL1A5CDH) throws IOException {
		PostParameter lw9ltfNQ = new PostParameter("v", Utils.encode("1.0"));
		PostParameter yApvHlYJ = new PostParameter("api_key", Utils.encode(RenRenConstant.apiKey));
		PostParameter up3owpNB = new PostParameter("method", Utils.encode("notifications.send"));
		PostParameter lFYigCpu = new PostParameter("call_id", System.nanoTime());
		PostParameter rD2dGG0H = new PostParameter("session_key",
				Utils.encode("5.22af9ee9ad842c7eb52004ece6e96b10.86400.1298646000-350727914"));
		PostParameter u67dz34T = new PostParameter("to_ids", Utils.encode("350727914"));
		PostParameter HZriOYNT = new PostParameter("notification", "又到了要睡觉的时间了。");
		PostParameter Tm3z34dG = new PostParameter("format", Utils.encode("JSON"));
		RenRenPostParameters ybDkUIzc = new RenRenPostParameters(Utils.encode(RenRenConstant.secret));
		ybDkUIzc.addParameter(lw9ltfNQ);
		ybDkUIzc.addParameter(yApvHlYJ);
		ybDkUIzc.addParameter(up3owpNB);
		ybDkUIzc.addParameter(lFYigCpu);
		ybDkUIzc.addParameter(rD2dGG0H);
		ybDkUIzc.addParameter(u67dz34T);
		ybDkUIzc.addParameter(HZriOYNT);
		ybDkUIzc.addParameter(Tm3z34dG);
		System.out.println(RenRenConstant.apiUrl + "?" + ybDkUIzc.generateUrl());
		URL CsIqldwG = new URL(RenRenConstant.apiUrl + "?" + ybDkUIzc.generateUrl());
		HttpURLConnection C2OaJmCy = (HttpURLConnection) CsIqldwG.openConnection();
		C2OaJmCy.setDoOutput(true);
		C2OaJmCy.setRequestMethod("POST");
		System.out.println("Sending request...");
		C2OaJmCy.connect();
		System.out.println("Response: " + C2OaJmCy.getResponseCode() + " " + C2OaJmCy.getResponseMessage());
		BufferedReader HohIhMfA = new BufferedReader(new InputStreamReader(C2OaJmCy.getInputStream()));
		String NcxDoqIi = null;
		while ((NcxDoqIi = HohIhMfA.readLine()) != null) {
			System.out.println(NcxDoqIi);
		}
	}

}