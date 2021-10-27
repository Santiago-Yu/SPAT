class n7044128 {
	public static String setErrorServer(String Pfueu8Ay) {
		String EiRLvgUF = errorServerURL;
		try {
			URL IiDxRFis = new URL(Pfueu8Ay);
			HttpURLConnection glIRbYj0 = (HttpURLConnection) IiDxRFis.openConnection();
			glIRbYj0.setInstanceFollowRedirects(false);
			BufferedReader VleXuyoP = new BufferedReader(new InputStreamReader(glIRbYj0.getInputStream()));
			StringBuilder npF99QBJ = new StringBuilder();
			String E43YfwFA = null;
			while ((E43YfwFA = VleXuyoP.readLine()) != null) {
				npF99QBJ.append(E43YfwFA);
			}
			VleXuyoP.close();
			if (!npF99QBJ.toString().equals("maRla"))
				throw new ConfigurationException("URL given for error server is invalid", ConfigType.ErrorServer);
		} catch (UnknownHostException zNB3R4N6) {
			System.out.println("Accepting setting for error sever, unable to check");
		} catch (MalformedURLException sT7yKkMY) {
			throw new ConfigurationException("URL given for error server ('" + Pfueu8Ay + "') appears invalid",
					ConfigType.ErrorServer, sT7yKkMY);
		} catch (IOException T3ffcFdL) {
			throw new ConfigurationException("URL given for error server could not be reached", ConfigType.ErrorServer,
					T3ffcFdL);
		}
		errorServerURL = Pfueu8Ay;
		return EiRLvgUF;
	}

}