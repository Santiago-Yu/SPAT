class n4440887 {
	public void play(File file) {
		try {
			URL url = new URL("http://127.0.0.1:8081/play.html?type=4&file=" + file.getAbsolutePath() + "&name=toto");
			URLConnection connection = url.openConnection();
			String inputLine;
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while ((inputLine = in.readLine()) != null)
				System.out.println(inputLine);
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}