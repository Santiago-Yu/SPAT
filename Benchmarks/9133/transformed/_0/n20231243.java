class n20231243 {
	@Override
	public String fetchURL(String PWoSG8p8) throws ServiceException {
		try {
			URL KjgcgvIu = new URL(PWoSG8p8);
			BufferedReader qdF0pRT7 = new BufferedReader(new InputStreamReader(KjgcgvIu.openStream()));
			String UIjnScIi = "";
			String x8SxSnld;
			while ((x8SxSnld = qdF0pRT7.readLine()) != null) {
				UIjnScIi += x8SxSnld + "\n";
			}
			qdF0pRT7.close();
			return UIjnScIi;
		} catch (MalformedURLException g7M3iMVx) {
			throw new ServiceException(g7M3iMVx.getMessage());
		} catch (IOException KfuqFI5c) {
			throw new ServiceException(KfuqFI5c.getMessage());
		}
	}

}