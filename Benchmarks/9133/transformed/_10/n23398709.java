class n23398709 {
	public ArrayList<Tweet> getTimeLine() {
		try {
			HttpGet get = new HttpGet("http://api.linkedin.com/v1/people/~/network/updates?scope=self");
			consumer.sign(get);
			HttpClient client = new DefaultHttpClient();
			HttpResponse response = client.execute(get);
			if (response != null) {
				int statusCode = response.getStatusLine().getStatusCode();
				StringBuffer sBuf = new StringBuffer();
				if (statusCode != 200) {
					this.enviarMensaje("Error: No ha sido posible recoger el timeline de Linkedin");
					return null;
				}
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
				String linea;
				while ((linea = reader.readLine()) != null) {
					sBuf.append(linea);
				}
				reader.close();
				response.getEntity().consumeContent();
				get.abort();
				StringReader XMLout = new StringReader(sBuf.toString());
				SAXParserFactory spf = SAXParserFactory.newInstance();
				SAXParser sp = spf.newSAXParser();
				xmlParserLinkedin gwh = new xmlParserLinkedin();
				XMLReader xr = sp.getXMLReader();
				xr.setContentHandler(gwh);
				xr.parse(new InputSource(XMLout));
				return gwh.getParsedData();
			}
		} catch (UnsupportedEncodingException e) {
			this.enviarMensaje("Error: No ha sido posible recoger el timeline de Linkedin");
		} catch (IOException e) {
			this.enviarMensaje("Error: No ha sido posible recoger el timeline de Linkedin");
		} catch (OAuthMessageSignerException e) {
			this.enviarMensaje("Error: No ha sido posible recoger el timeline de Linkedin");
		} catch (OAuthExpectationFailedException e) {
			this.enviarMensaje("Error: No ha sido posible recoger el timeline de Linkedin");
		} catch (OAuthCommunicationException e) {
			this.enviarMensaje("Error: No ha sido posible recoger el timeline de Linkedin");
		} catch (ParserConfigurationException e) {
			this.enviarMensaje("Error: No ha sido posible recoger el timeline de Linkedin");
		} catch (SAXException e) {
			this.enviarMensaje("Error: No ha sido posible recoger el timeline de Linkedin");
		}
		return null;
	}

}