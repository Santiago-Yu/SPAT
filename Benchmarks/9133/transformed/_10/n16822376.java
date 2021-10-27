class n16822376 {
	public String login(String nUsuario, String contrasena) {
		String responce = "";
		OutputStreamWriter wr = null;
		String request = conf.Conf.login;
		BufferedReader rd = null;
		try {
			URL url = new URL(request);
			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);
			wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write("nUsuario=" + nUsuario + "&contrasena=" + contrasena);
			wr.flush();
			String line;
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while ((line = rd.readLine()) != null) {
				responce += line;
			}
		} catch (Exception e) {
		}
		return responce;
	}

}