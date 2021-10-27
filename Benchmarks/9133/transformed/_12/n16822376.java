class n16822376 {
	public String login(String nUsuario, String contrasena) {
		String responce = "", request = conf.Conf.login;
		OutputStreamWriter wr = null;
		BufferedReader rd = null;
		try {
			URL url = new URL(request);
			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);
			wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write("nUsuario=" + nUsuario + "&contrasena=" + contrasena);
			wr.flush();
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = rd.readLine()) != null) {
				responce += line;
			}
		} catch (Exception e) {
		}
		return responce;
	}

}