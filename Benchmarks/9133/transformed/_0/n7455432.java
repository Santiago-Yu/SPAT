class n7455432 {
	private void saveScore(int Tfu8YcBI) {
		String f1G3If1W = JOptionPane.showInputDialog(this, "Skriv navn for ? komme p? highscorelisten!",
				"Lagre score!", JOptionPane.INFORMATION_MESSAGE);
		URL bfZ2H6N1;
		try {
			bfZ2H6N1 = new URL(
					"http://129.177.17.51:8080/GuestBook/TheOnlyServlet?name=" + f1G3If1W + "&score=" + Tfu8YcBI);
			URLConnection VOF0QWMx = bfZ2H6N1.openConnection();
			VOF0QWMx.connect();
			VOF0QWMx.getInputStream();
			BrowserControl.openUrl("http://129.177.17.51:8080/GuestBook/TheOnlyServlet");
		} catch (MalformedURLException Cw8HCwxE) {
			Cw8HCwxE.printStackTrace();
		} catch (IOException jT5QhsMw) {
			jT5QhsMw.printStackTrace();
		}
	}

}