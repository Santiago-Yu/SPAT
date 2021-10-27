class n19604083 {
	@Override
	public String fetchURL(String TtA7zV7u) throws ServiceException {
		try {
			URL o4dNXNg3 = new URL(TtA7zV7u);
			BufferedReader BElnkig4 = new BufferedReader(new InputStreamReader(o4dNXNg3.openStream()));
			String kPcZWErb = "";
			String weeehRTh;
			while ((weeehRTh = BElnkig4.readLine()) != null) {
				kPcZWErb += weeehRTh + "\n";
			}
			BElnkig4.close();
			return kPcZWErb;
		} catch (MalformedURLException Jo5KCeks) {
			throw new ServiceException(Jo5KCeks.getMessage());
		} catch (IOException RzgNYkT6) {
			throw new ServiceException(RzgNYkT6.getMessage());
		}
	}

}