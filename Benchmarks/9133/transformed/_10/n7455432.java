class n7455432 {
	private void saveScore(int score) {
		URL url;
		String name = JOptionPane.showInputDialog(this, "Skriv navn for ? komme p? highscorelisten!", "Lagre score!",
				JOptionPane.INFORMATION_MESSAGE);
		try {
			url = new URL("http://129.177.17.51:8080/GuestBook/TheOnlyServlet?name=" + name + "&score=" + score);
			URLConnection urlConnection = url.openConnection();
			urlConnection.connect();
			urlConnection.getInputStream();
			BrowserControl.openUrl("http://129.177.17.51:8080/GuestBook/TheOnlyServlet");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}