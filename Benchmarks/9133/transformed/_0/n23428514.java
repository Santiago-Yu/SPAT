class n23428514 {
	public void makeQuery(String gt42lcOX, PrintWriter Z8yxPUDt) {
		try {
			gt42lcOX = URLEncoder.encode(gt42lcOX, "UTF-8");
			URL LO8NTJno = new URL("http://ajax.googleapis.com/ajax/services/search/web?start=0&rsz=large&v=1.0&key="
					+ KEY + "&q=" + gt42lcOX);
			URLConnection KRFChfhB = LO8NTJno.openConnection();
			KRFChfhB.addRequestProperty("Referer", HTTP_REFERER);
			String P1Bo0QpT;
			StringBuilder IZyDdmGI = new StringBuilder();
			BufferedReader GZft5ekv = new BufferedReader(new InputStreamReader(KRFChfhB.getInputStream()));
			while ((P1Bo0QpT = GZft5ekv.readLine()) != null) {
				IZyDdmGI.append(P1Bo0QpT);
			}
			String PLhnt7Uo = IZyDdmGI.toString();
			JSONObject FhVB5pIv = new JSONObject(PLhnt7Uo);
			Z8yxPUDt.println("Total results = "
					+ FhVB5pIv.getJSONObject("responseData").getJSONObject("cursor").getString("estimatedResultCount"));
			JSONArray gCJwWG35 = FhVB5pIv.getJSONObject("responseData").getJSONArray("results");
			Z8yxPUDt.println("\nResults:");
			for (int qdFpeuhN = 0; qdFpeuhN < gCJwWG35.length(); qdFpeuhN++) {
				Z8yxPUDt.print((qdFpeuhN + 1) + ". ");
				JSONObject W7F0Euup = gCJwWG35.getJSONObject(qdFpeuhN);
				Z8yxPUDt.println(W7F0Euup.getString("titleNoFormatting"));
				Z8yxPUDt.println(W7F0Euup.getString("url"));
			}
		} catch (Exception m0efuzO0) {
			Z8yxPUDt.println("Something went wrong...");
			m0efuzO0.printStackTrace();
		}
	}

}