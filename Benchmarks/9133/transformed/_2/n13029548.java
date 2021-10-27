class n13029548 {
	public String getUser() {
		try {
			HttpGet get = new HttpGet("http://twemoi.status.net/api/account/verify_credentials.xml");
			consumer.sign(get);
			HttpClient client = new DefaultHttpClient();
			HttpResponse response = client.execute(get);
			if (response != null) {
				int statusCode = response.getStatusLine().getStatusCode();
				if (statusCode != 200) {
					this.enviarMensaje("Error: Usuario no autenticado en la red de Status");
					return "";
				}
				StringBuffer sBuf = new StringBuffer();
				String linea;
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
				for (; (linea = reader.readLine()) != null;) {
					sBuf.append(linea);
				}
				reader.close();
				response.getEntity().consumeContent();
				get.abort();
				String salida = sBuf.toString();
				String user_name = salida.split("</screen_name>")[0].split("<screen_name>")[1];
				return user_name;
			}
		} catch (UnsupportedEncodingException e) {
			this.enviarMensaje("Error: Usuario no autenticado en la red de Status");
		} catch (IOException e) {
			this.enviarMensaje("Error: Usuario no autenticado en la red de Status");
		} catch (OAuthMessageSignerException e) {
			this.enviarMensaje("Error: Usuario no autenticado en la red de Status");
		} catch (OAuthExpectationFailedException e) {
			this.enviarMensaje("Error: Usuario no autenticado en la red de Status");
		} catch (OAuthCommunicationException e) {
			this.enviarMensaje("Error: Usuario no autenticado en la red de Status");
		}
		return null;
	}

}