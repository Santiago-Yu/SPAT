class n15382680 {
	public static String obterConteudoSite(String MP3wWNxA) {
		URL seGJWOJk;
		try {
			seGJWOJk = new URL(MP3wWNxA);
			URLConnection yxdDoOh0 = null;
			if (proxy != null)
				yxdDoOh0 = seGJWOJk.openConnection(proxy.getProxy());
			else
				yxdDoOh0 = seGJWOJk.openConnection();
			yxdDoOh0.setDoOutput(true);
			BufferedReader jeM6fbEw = new BufferedReader(
					new InputStreamReader(yxdDoOh0.getInputStream(), Charset.forName("UTF-8")));
			String FkcnL8dF;
			StringBuilder bNFuegcr = new StringBuilder();
			while ((FkcnL8dF = jeM6fbEw.readLine()) != null) {
				bNFuegcr.append(FkcnL8dF);
				bNFuegcr.append("\n");
			}
			jeM6fbEw.close();
			return bNFuegcr.toString();
		} catch (MalformedURLException pr3IhIbR) {
			throw new AlfredException("N?o foi poss¨ªvel obter contato com o site " + MP3wWNxA, pr3IhIbR);
		} catch (IOException q4GVDgfF) {
			throw new AlfredException("N?o foi poss¨ªvel obter contato com o site " + MP3wWNxA, q4GVDgfF);
		}
	}

}