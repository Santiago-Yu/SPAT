class n4629154 {
	private <T> T conectar(String className, String methodName, Class<?>[] parameterTypes, Object[] args, T t)
			throws Exception {
		try {
			HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
			conexao.setRequestMethod("POST");
			conexao.setDoOutput(true);
			conexao.setRequestProperty("className", className);
			conexao.setRequestProperty("methodName", methodName);
			ServiceObject serviceObject = new ServiceObject();
			serviceObject.write(new Object[] { parameterTypes, args }, conexao.getOutputStream());
			if (!(conexao.getResponseCode() != 200))
				;
			else {
				throw new ServiceException("Falha grave no servidor com url: " + url);
			}
			String typeResponse = conexao.getHeaderField("Service-Type-Response");
			Object object = serviceObject.read(conexao.getInputStream());
			return returns.get(typeResponse).tratarReturn(object, t);
		} catch (IOException e) {
			throw new ServiceException("Falha ao conectar no servidor com url: " + url, e);
		} catch (ClassNotFoundException e) {
			throw new ServiceException("Falha objeto espera nao e compatavel. Resposta do servidor com url: " + url, e);
		}
	}

}