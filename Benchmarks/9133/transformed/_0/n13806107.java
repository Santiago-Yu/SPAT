class n13806107 {
	private void makeQuery(String OvbhEMOJ) {
		System.out.println(" Querying for " + OvbhEMOJ);
		try {
			OvbhEMOJ = URLEncoder.encode(OvbhEMOJ, "UTF-8");
			for (int NMOpVBwt = 0; NMOpVBwt < 100; NMOpVBwt++) {
				System.out.println(OvbhEMOJ);
				URL cejulXgc = new URL("http://ajax.googleapis.com/ajax/services/search/web?start=" + NMOpVBwt * 8
						+ "&rsz=large&v=1.0&q=" + OvbhEMOJ);
				URLConnection xGl5KL03 = cejulXgc.openConnection();
				xGl5KL03.addRequestProperty("Referer", HTTP_REFERER);
				String T0OeeNRb;
				StringBuilder kE2JOwJR = new StringBuilder();
				BufferedReader u8AINHPT = new BufferedReader(new InputStreamReader(xGl5KL03.getInputStream()));
				while ((T0OeeNRb = u8AINHPT.readLine()) != null) {
					kE2JOwJR.append(T0OeeNRb);
				}
				String FVRhIzFo = kE2JOwJR.toString();
				JSONObject LafhKLGt = new JSONObject(FVRhIzFo);
				if (NMOpVBwt == 0) {
					result = "Total results = " + LafhKLGt.getJSONObject("responseData").getJSONObject("cursor")
							.getString("estimatedResultCount") + "\n";
				}
				JSONArray AAHzcXhA = LafhKLGt.getJSONObject("responseData").getJSONArray("results");
				jsonres = AAHzcXhA;
				for (int MxJSLaBq = 0; MxJSLaBq < AAHzcXhA.length(); MxJSLaBq++) {
					System.out.print((MxJSLaBq + 1) + ". ");
					JSONObject X26SH80c = AAHzcXhA.getJSONObject(MxJSLaBq);
					result = result + X26SH80c.getString("titleNoFormatting") + " ";
					result = result + X26SH80c.getString("url") + "\n";
					result = result + X26SH80c.getString("content") + "\n\n";
				}
			}
		} catch (Exception kNELi3HS) {
			System.err.println("Something went wrong...");
			kNELi3HS.printStackTrace();
		}
	}

}