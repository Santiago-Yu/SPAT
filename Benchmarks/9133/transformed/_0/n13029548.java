class n13029548 {
	public String getUser() {
		try {
			HttpGet S0HKA683 = new HttpGet("http://twemoi.status.net/api/account/verify_credentials.xml");
			consumer.sign(S0HKA683);
			HttpClient MdnWHB16 = new DefaultHttpClient();
			HttpResponse zN5QYVuG = MdnWHB16.execute(S0HKA683);
			if (zN5QYVuG != null) {
				int Jl0Qx9AY = zN5QYVuG.getStatusLine().getStatusCode();
				if (Jl0Qx9AY != 200) {
					this.enviarMensaje("Error: Usuario no autenticado en la red de Status");
					return "";
				}
				StringBuffer erDPjKHy = new StringBuffer();
				String zsPc8Caj;
				BufferedReader nodhlhcQ = new BufferedReader(
						new InputStreamReader(zN5QYVuG.getEntity().getContent(), "UTF-8"));
				while ((zsPc8Caj = nodhlhcQ.readLine()) != null) {
					erDPjKHy.append(zsPc8Caj);
				}
				nodhlhcQ.close();
				zN5QYVuG.getEntity().consumeContent();
				S0HKA683.abort();
				String SWHwWjYm = erDPjKHy.toString();
				String NvTugmcA = SWHwWjYm.split("</screen_name>")[0].split("<screen_name>")[1];
				return NvTugmcA;
			}
		} catch (UnsupportedEncodingException AcDLmKYZ) {
			this.enviarMensaje("Error: Usuario no autenticado en la red de Status");
		} catch (IOException zfOjZpdS) {
			this.enviarMensaje("Error: Usuario no autenticado en la red de Status");
		} catch (OAuthMessageSignerException Uhz25D3n) {
			this.enviarMensaje("Error: Usuario no autenticado en la red de Status");
		} catch (OAuthExpectationFailedException RBEOuW83) {
			this.enviarMensaje("Error: Usuario no autenticado en la red de Status");
		} catch (OAuthCommunicationException n3LzY044) {
			this.enviarMensaje("Error: Usuario no autenticado en la red de Status");
		}
		return null;
	}

}