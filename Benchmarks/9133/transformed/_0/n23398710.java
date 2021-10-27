class n23398710 {
	public String getUser() {
		try {
			HttpGet Rj0FRzrN = new HttpGet("http://api.linkedin.com/v1/people/~");
			consumer.sign(Rj0FRzrN);
			HttpClient Jkk8n2h1 = new DefaultHttpClient();
			HttpResponse FnU5BS89 = Jkk8n2h1.execute(Rj0FRzrN);
			if (FnU5BS89 != null) {
				int pGb3TUK8 = FnU5BS89.getStatusLine().getStatusCode();
				if (pGb3TUK8 != 200) {
					this.enviarMensaje("Error: Usuario no autenticado en la red de Linkedin");
				}
				StringBuffer CLRp82zr = new StringBuffer();
				String U4sBfoJF;
				BufferedReader Cs2aPGbz = new BufferedReader(
						new InputStreamReader(FnU5BS89.getEntity().getContent(), "UTF-8"));
				while ((U4sBfoJF = Cs2aPGbz.readLine()) != null) {
					CLRp82zr.append(U4sBfoJF);
				}
				Cs2aPGbz.close();
				FnU5BS89.getEntity().consumeContent();
				Rj0FRzrN.abort();
				String kY9qqYkq = CLRp82zr.toString();
				String wHBBiQzP = kY9qqYkq.split("</first-name>")[0].split("<first-name>")[1];
				String WAflvqsT = kY9qqYkq.split("</last-name>")[0].split("<last-name>")[1];
				return wHBBiQzP + " " + WAflvqsT;
			}
		} catch (UnsupportedEncodingException oayUkkiF) {
			this.enviarMensaje("Error: Usuario no autenticado en la red de Linkedin");
		} catch (IOException VRh2AD1P) {
			this.enviarMensaje("Error: Usuario no autenticado en la red de Linkedin");
		} catch (OAuthMessageSignerException jrTZq4n6) {
			this.enviarMensaje("Error: Usuario no autenticado en la red de Linkedin");
		} catch (OAuthExpectationFailedException uAONhwdS) {
			this.enviarMensaje("Error: Usuario no autenticado en la red de Linkedin");
		} catch (OAuthCommunicationException nZVZxIDd) {
			this.enviarMensaje("Error: Usuario no autenticado en la red de Linkedin");
		}
		return null;
	}

}