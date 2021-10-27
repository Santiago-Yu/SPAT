class n23398709 {
	public ArrayList<Tweet> getTimeLine() {
		try {
			HttpGet RnLqXw5D = new HttpGet("http://api.linkedin.com/v1/people/~/network/updates?scope=self");
			consumer.sign(RnLqXw5D);
			HttpClient I7kQ0ZJc = new DefaultHttpClient();
			HttpResponse YuCr0EEx = I7kQ0ZJc.execute(RnLqXw5D);
			if (YuCr0EEx != null) {
				int TOoFURvZ = YuCr0EEx.getStatusLine().getStatusCode();
				if (TOoFURvZ != 200) {
					this.enviarMensaje("Error: No ha sido posible recoger el timeline de Linkedin");
					return null;
				}
				StringBuffer OIvXLtbE = new StringBuffer();
				String FP8GnZYA;
				BufferedReader nIi7gim9 = new BufferedReader(
						new InputStreamReader(YuCr0EEx.getEntity().getContent(), "UTF-8"));
				while ((FP8GnZYA = nIi7gim9.readLine()) != null) {
					OIvXLtbE.append(FP8GnZYA);
				}
				nIi7gim9.close();
				YuCr0EEx.getEntity().consumeContent();
				RnLqXw5D.abort();
				SAXParserFactory HM84FYtt = SAXParserFactory.newInstance();
				StringReader Auts9Bkl = new StringReader(OIvXLtbE.toString());
				SAXParser z1yVDVjP = HM84FYtt.newSAXParser();
				XMLReader x5vb8Kyk = z1yVDVjP.getXMLReader();
				xmlParserLinkedin WKjUvZhP = new xmlParserLinkedin();
				x5vb8Kyk.setContentHandler(WKjUvZhP);
				x5vb8Kyk.parse(new InputSource(Auts9Bkl));
				return WKjUvZhP.getParsedData();
			}
		} catch (UnsupportedEncodingException xHOsrqe4) {
			this.enviarMensaje("Error: No ha sido posible recoger el timeline de Linkedin");
		} catch (IOException asaCbrPG) {
			this.enviarMensaje("Error: No ha sido posible recoger el timeline de Linkedin");
		} catch (OAuthMessageSignerException dvQlDhmE) {
			this.enviarMensaje("Error: No ha sido posible recoger el timeline de Linkedin");
		} catch (OAuthExpectationFailedException IrcRRzUZ) {
			this.enviarMensaje("Error: No ha sido posible recoger el timeline de Linkedin");
		} catch (OAuthCommunicationException DBJI4Trs) {
			this.enviarMensaje("Error: No ha sido posible recoger el timeline de Linkedin");
		} catch (ParserConfigurationException qCIeNg04) {
			this.enviarMensaje("Error: No ha sido posible recoger el timeline de Linkedin");
		} catch (SAXException z0d32yCg) {
			this.enviarMensaje("Error: No ha sido posible recoger el timeline de Linkedin");
		}
		return null;
	}

}