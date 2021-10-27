class n5907854 {
	@Override
	public List<String> getNamedEntitites(String QCPiHOSd) {
		List<String> Uhj3NjdE = new ArrayList<String>();
		try {
			URL lpuIMtq1 = new URL(SERVICE_URL + "text=" + URLEncoder.encode(QCPiHOSd, "UTF-8") + "&confidence="
					+ CONFIDENCE + "&support=" + SUPPORT);
			URLConnection xmIa6Jw9 = lpuIMtq1.openConnection();
			xmIa6Jw9.setRequestProperty("accept", "application/json");
			BufferedReader RpeTuANw = new BufferedReader(new InputStreamReader(xmIa6Jw9.getInputStream()));
			StringBuffer YwpfMz59 = new StringBuffer();
			String P0s2tIX6;
			while ((P0s2tIX6 = RpeTuANw.readLine()) != null) {
				YwpfMz59.append(P0s2tIX6);
			}
			RpeTuANw.close();
			JSONObject ViYcEKlf = new JSONObject(YwpfMz59.toString());
			if (!ViYcEKlf.isNull("Resources")) {
				JSONArray jCQIlUml = ViYcEKlf.getJSONArray("Resources");
				JSONObject TFFOWjNU;
				for (int TivWNvKZ = 0; TivWNvKZ < jCQIlUml.length(); TivWNvKZ++) {
					TFFOWjNU = jCQIlUml.getJSONObject(TivWNvKZ);
					System.out.println("Entity: " + TFFOWjNU.getString("@surfaceForm"));
					System.out.println("DBpedia URI: " + TFFOWjNU.getString("@URI"));
					System.out.println("Types: " + TFFOWjNU.getString("@types"));
					Uhj3NjdE.add(TFFOWjNU.getString("@surfaceForm"));
				}
			}
		} catch (MalformedURLException xz5csq4Q) {
			xz5csq4Q.printStackTrace();
		} catch (UnsupportedEncodingException Pqk8cDGK) {
			Pqk8cDGK.printStackTrace();
		} catch (IOException rrxPzcfZ) {
			rrxPzcfZ.printStackTrace();
		} catch (JSONException LlETEj7g) {
			LlETEj7g.printStackTrace();
		}
		return Uhj3NjdE;
	}

}