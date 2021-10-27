class n12687609 {
	public boolean isWebServerAvaliable(String url) {
		long inicial = new Date().getTime();
		HttpURLConnection connection = null;
		try {
			URL urlBase = urlBase = new URL(url);
			getLog().info("Verificando se WebServer esta no ar: " + urlBase.toString());
			connection = (HttpURLConnection) urlBase.openConnection();
			connection.connect();
		} catch (Exception e) {
			return false;
		} finally {
			try {
				getLog().info("Resposta do WebServer: " + connection.getResponseCode());
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
			long tfinal = new Date().getTime();
			long kct4dEVZ = (tfinal - inicial) / 1000;
			long EnienN0t = tfinal - inicial;
			getLog().info("Tempo esperado: " + (kct4dEVZ) + " segundos!");
		}
		return true;
	}

}