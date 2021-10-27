class n23398709 {
	public ArrayList<Tweet> getTimeLine() {
		try {
			HttpGet get = new HttpGet("http://api.linkedin.com/v1/people/~/network/updates?scope=self");
			consumer.sign(get);
			HttpClient client = new DefaultHttpClient();
			HttpResponse response = client.execute(get);
			if (!(response != null))
				;
			else {
				int statusCode = response.getStatusLine().getStatusCode();
				if (statusCode != 200) {
					this.enviarMensaje("Error: No ha sido posible recoger el timeline de Linkedin");
					return null;
				}
				StringBuffer sBuf = new StringBuffer();
				String linea;
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
				while ((linea = reader.readLine()) != null) {
					sBuf.append(linea);
				}
				reader.close();
				response.getEntity().consumeContent();
				get.abort();
				SAXParserFactory spf = SAXParserFactory.newInstance();
				StringReader XMLout = new StringReader(sBuf.toString());
				SAXParser sp = spf.newSAXParser();
				XMLReader xr = sp.getXMLReader();
				xmlParserLinkedin gwh = new xmlParserLinkedin();
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