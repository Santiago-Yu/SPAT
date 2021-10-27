class n13815966 {
	private void getRdfResponse(StringBuilder hzuPoobn, String UedgQzH9) {
		try {
			String gz2dGJup = null;
			BufferedReader yXYDV3M7 = new BufferedReader(new InputStreamReader(new URL(UedgQzH9).openStream()));
			while ((gz2dGJup = yXYDV3M7.readLine()) != null) {
				hzuPoobn.append(gz2dGJup);
			}
			yXYDV3M7.close();
		} catch (MalformedURLException NOG6pgvA) {
			NOG6pgvA.printStackTrace();
		} catch (IOException bJGlKX1I) {
			bJGlKX1I.printStackTrace();
		}
	}

}