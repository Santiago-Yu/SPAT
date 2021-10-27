class n6890417 {
	public static void main(String[] a3Rxz8TR) throws IOException {
		PostParameter g88CwpKo = new PostParameter("v", Utils.encode("1.0"));
		PostParameter Vz9bbGa9 = new PostParameter("api_key", Utils.encode(RenRenConstant.apiKey));
		PostParameter tlxRxTQ4 = new PostParameter("method", Utils.encode("feed.publishTemplatizedAction"));
		PostParameter JuQ7CNPV = new PostParameter("call_id", System.nanoTime());
		PostParameter H5yyfU2u = new PostParameter("session_key",
				Utils.encode("5.b2ca405eef80b4da1f68d0df64e471be.86400.1298372400-350727914"));
		PostParameter KPtbC9wY = new PostParameter("format", Utils.encode("JSON"));
		PostParameter uiu9nD1r = new PostParameter("template_id", Utils.encode("1"));
		PostParameter WfXBnK1Z = new PostParameter("title_data", Utils.encode("\"conteng\":\"xkt\""));
		PostParameter qkAWgLb0 = new PostParameter("body_data", Utils.encode("\"conteng\":\"xkt\""));
		RenRenPostParameters vDqZjX9F = new RenRenPostParameters(Utils.encode(RenRenConstant.secret));
		vDqZjX9F.addParameter(g88CwpKo);
		vDqZjX9F.addParameter(Vz9bbGa9);
		vDqZjX9F.addParameter(tlxRxTQ4);
		vDqZjX9F.addParameter(JuQ7CNPV);
		vDqZjX9F.addParameter(H5yyfU2u);
		vDqZjX9F.addParameter(KPtbC9wY);
		vDqZjX9F.addParameter(uiu9nD1r);
		vDqZjX9F.addParameter(WfXBnK1Z);
		vDqZjX9F.addParameter(qkAWgLb0);
		System.out.println(RenRenConstant.apiUrl + "?" + vDqZjX9F.generateUrl());
		URL rgX7ZWmg = new URL(RenRenConstant.apiUrl + "?" + vDqZjX9F.generateUrl());
		HttpURLConnection FEpVnrnC = (HttpURLConnection) rgX7ZWmg.openConnection();
		FEpVnrnC.setDoOutput(true);
		FEpVnrnC.setRequestMethod("POST");
		System.out.println("Sending request...");
		FEpVnrnC.connect();
		System.out.println("Response: " + FEpVnrnC.getResponseCode() + " " + FEpVnrnC.getResponseMessage());
		BufferedReader aiLGSxX1 = new BufferedReader(new InputStreamReader(FEpVnrnC.getInputStream()));
		String vL1Dt8P0 = null;
		while ((vL1Dt8P0 = aiLGSxX1.readLine()) != null) {
			System.out.println(vL1Dt8P0);
		}
	}

}