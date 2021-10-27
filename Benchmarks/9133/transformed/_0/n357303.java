class n357303 {
	public static String post(String vzR4JOJI, String nq2WH4Mb) {
		try {
			URL c1y2PP8x = new URL(vzR4JOJI);
			HttpURLConnection RJVqQw2O = (HttpURLConnection) c1y2PP8x.openConnection();
			RJVqQw2O.setRequestMethod("POST");
			RJVqQw2O.setDoInput(true);
			RJVqQw2O.setDoOutput(true);
			RJVqQw2O.setUseCaches(true);
			RJVqQw2O.setAllowUserInteraction(true);
			RJVqQw2O.setFollowRedirects(true);
			RJVqQw2O.setInstanceFollowRedirects(true);
			RJVqQw2O.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			DataOutputStream MQm0f9MA = new DataOutputStream(RJVqQw2O.getOutputStream());
			MQm0f9MA.writeBytes(nq2WH4Mb);
			MQm0f9MA.flush();
			MQm0f9MA.close();
			BufferedReader vhehzHMA = new BufferedReader(new InputStreamReader(RJVqQw2O.getInputStream()));
			String A8t3zRzI = "";
			String ABuJUdrL = "";
			while ((A8t3zRzI = vhehzHMA.readLine()) != null) {
				ABuJUdrL += A8t3zRzI;
			}
			vhehzHMA.close();
			return ABuJUdrL;
		} catch (MalformedURLException kRzuUTZL) {
			System.out.println("Internal Error. Malformed URL.");
			kRzuUTZL.printStackTrace();
		} catch (IOException APapFP5k) {
			System.out.println("Internal I/O Error.");
			APapFP5k.printStackTrace();
		}
		return "";
	}

}