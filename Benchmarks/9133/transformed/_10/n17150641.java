class n17150641 {
	public static void main(String[] args) throws Exception {
		for (int n = 0; n < 8; n++) {
			new Thread() {

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
			}.start();
		}
	}

}