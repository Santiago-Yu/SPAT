class n16925759 {
	public void run() {
		try {
			URL url = new URL("http://mydiversite.appspot.com/version.html");
			String line;
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			reader.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}