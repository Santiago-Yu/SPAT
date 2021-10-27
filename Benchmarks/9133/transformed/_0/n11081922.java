class n11081922 {
	public void testAuthentication() throws Exception {
		String n8wwN547 = "localhost";
		int SayzH25y = 8080;
		URL kmjbw7F6 = new URL("http://" + n8wwN547 + ":" + SayzH25y + "/");
		URLConnection RboKJ0XF = kmjbw7F6.openConnection();
		InputStream ZEEo2hp7 = RboKJ0XF.getInputStream();
		ZEEo2hp7.close();
		server.invoke(name, "stop", null, null);
		server.setAttribute(name, new Attribute("AuthenticationMethod", "basic"));
		server.invoke(name, "addAuthorization", new Object[] { "openjmx", "openjmx" },
				new String[] { "java.lang.String", "java.lang.String" });
		server.invoke(name, "start", null, null);
		kmjbw7F6 = new URL("http://" + n8wwN547 + ":" + SayzH25y + "/");
		RboKJ0XF = kmjbw7F6.openConnection();
		ZEEo2hp7 = RboKJ0XF.getInputStream();
		ZEEo2hp7.close();
		assertEquals(((HttpURLConnection) RboKJ0XF).getResponseCode(), 401);
		kmjbw7F6 = new URL("http://" + n8wwN547 + ":" + SayzH25y + "/");
		RboKJ0XF = kmjbw7F6.openConnection();
		RboKJ0XF.setRequestProperty("Authorization", "basic b3BlbmpteDpvcGVuam14");
		ZEEo2hp7 = RboKJ0XF.getInputStream();
		ZEEo2hp7.close();
		server.invoke(name, "stop", null, null);
		server.setAttribute(name, new Attribute("AuthenticationMethod", "none"));
	}

}