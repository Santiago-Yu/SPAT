class n20231243 {
	@Override
	public String fetchURL(String urlString) throws ServiceException {
		try {
			URL url = new URL(urlString);
			String content = "";
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				content += line + "\n";
			}
			reader.close();
			return content;
		} catch (MalformedURLException e) {
			throw new ServiceException(e.getMessage());
		} catch (IOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

}