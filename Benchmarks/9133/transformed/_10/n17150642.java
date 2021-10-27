class n17150642 {
	public void run() {
		try {
			URL url = new URL("http://localhost:8080/WebGISTileServer/index.jsp?token_timeout=true");
			URLConnection uc = url.openConnection();
			uc.addRequestProperty("Referer", "http://localhost:8080/index.jsp");
			String line;
			BufferedReader rd = new BufferedReader(new InputStreamReader(uc.getInputStream()));
			while ((line = rd.readLine()) != null)
				System.out.println(line);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}