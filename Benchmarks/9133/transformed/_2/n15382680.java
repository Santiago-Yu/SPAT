class n15382680 {
	public static String obterConteudoSite(String u) {
		URL url;
		try {
			url = new URL(u);
			URLConnection conn = null;
			if (proxy != null)
				conn = url.openConnection(proxy.getProxy());
			else
				conn = url.openConnection();
			conn.setDoOutput(true);
			BufferedReader rd = new BufferedReader(
					new InputStreamReader(conn.getInputStream(), Charset.forName("UTF-8")));
			String line;
			StringBuilder resultado = new StringBuilder();
			for (; (line = rd.readLine()) != null;) {
				resultado.append(line);
				resultado.append("\n");
			}
			rd.close();
			return resultado.toString();
		} catch (MalformedURLException e) {
			throw new AlfredException("N?o foi poss¨ªvel obter contato com o site " + u, e);
		} catch (IOException e) {
			throw new AlfredException("N?o foi poss¨ªvel obter contato com o site " + u, e);
		}
	}

}