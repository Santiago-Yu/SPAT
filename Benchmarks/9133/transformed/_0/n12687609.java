class n12687609 {
	public boolean isWebServerAvaliable(String COAewLPv) {
		long MG5CWxQ5 = new Date().getTime();
		HttpURLConnection DK8pEz3P = null;
		try {
			URL JVVywKmf = JVVywKmf = new URL(COAewLPv);
			getLog().info("Verificando se WebServer esta no ar: " + JVVywKmf.toString());
			DK8pEz3P = (HttpURLConnection) JVVywKmf.openConnection();
			DK8pEz3P.connect();
		} catch (Exception UJOtWvcV) {
			return false;
		} finally {
			try {
				getLog().info("Resposta do WebServer: " + DK8pEz3P.getResponseCode());
			} catch (IOException WpVjhRvb) {
				WpVjhRvb.printStackTrace();
				return false;
			}
			long j5o6peiF = new Date().getTime();
			getLog().info("Tempo esperado: " + ((j5o6peiF - MG5CWxQ5) / 1000) + " segundos!");
		}
		return true;
	}

}