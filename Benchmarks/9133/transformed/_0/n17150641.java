class n17150641 {
	public static void main(String[] szHPFtJ9) throws Exception {
		for (int EsT7Xhd2 = 0; EsT7Xhd2 < 8; EsT7Xhd2++) {
			new Thread() {

				public void run() {
					try {
						URL ZUAD2oct = new URL("http://localhost:8080/WebGISTileServer/index.jsp?token_timeout=true");
						URLConnection jjmwqHGX = ZUAD2oct.openConnection();
						jjmwqHGX.addRequestProperty("Referer", "http://localhost:8080/index.jsp");
						BufferedReader W4ngeGG4 = new BufferedReader(new InputStreamReader(jjmwqHGX.getInputStream()));
						String GbEsGKZA;
						while ((GbEsGKZA = W4ngeGG4.readLine()) != null)
							System.out.println(GbEsGKZA);
					} catch (Exception Ri65Qf2h) {
						Ri65Qf2h.printStackTrace();
					}
				}
			}.start();
		}
	}

}