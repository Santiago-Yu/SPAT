class n19963410 {
	@Override
	public Result sendSMS(String number, String text, Proxy proxy) {
		try {
			DefaultHttpClient client = new DefaultHttpClient();
			String target = "http://www.smsbilliger.de/free-sms.html";
			if (proxy != null) {
				HttpHost prox = new HttpHost(proxy.host, proxy.port);
				client.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, prox);
			}
			HttpGet get = new HttpGet(target);
			HttpResponse response = client.execute(get);
			HttpEntity e = response.getEntity();
			Document doc = ref.getDocumentFromInputStream(e.getContent());
			List<Element> forms = ref.selectByXPathOnDocument(doc, "//<ns>FORM",
					doc.getRootElement().getNamespaceURI());
			if (forms.size() == 0)
				return new Result(Result.SMS_LIMIT_REACHED);
			List<NameValuePair> formparas = new ArrayList<NameValuePair>();
			Element form = forms.get(0);
			List<Element> inputs = ref.selectByXPathOnElement(form, "//<ns>INPUT|//<ns>TEXTAREA|//<ns>SELECT",
					form.getNamespaceURI());
			Iterator<Element> it = inputs.iterator();
			while (it.hasNext()) {
				Element input = it.next();
				String type = input.getAttributeValue("type");
				String name = input.getAttributeValue("name");
				String value = input.getAttributeValue("value");
				if (type != null && type.equals("hidden")) {
					formparas.add(new BasicNameValuePair(name, value));
				} else if (name != null && name.equals(FORM_NUMBER)) {
					formparas.add(new BasicNameValuePair(name, this.getNumberPart(number)));
				} else if (name != null && name.equals(FORM_TEXT)) {
					formparas.add(new BasicNameValuePair(name, text));
				} else if (name != null && name.equals(FORM_AGB)) {
					formparas.add(new BasicNameValuePair(name, "true"));
				}
			}
			formparas.add(new BasicNameValuePair("dialing_code", this.getPrefixPart(number)));
			formparas.add(new BasicNameValuePair("no_schedule", "yes"));
			List<Element> captchas = ref.selectByXPathOnDocument(doc, "//<ns>IMG[@id='code_img']",
					doc.getRootElement().getNamespaceURI());
			Element captcha = captchas.get(0);
			String url = "http://www.smsbilliger.de/" + captcha.getAttributeValue("src");
			HttpGet imgcall = new HttpGet(url);
			HttpResponse imgres = client.execute(imgcall);
			HttpEntity imge = imgres.getEntity();
			BufferedImage img = ImageIO.read(imge.getContent());
			imge.getContent().close();
			Icon icon = new ImageIcon(img);
			String result = (String) JOptionPane.showInputDialog(null, "Bitte Captcha eingeben:", "Captcha",
					JOptionPane.INFORMATION_MESSAGE, icon, null, "");
			formparas.add(new BasicNameValuePair(FORM_CAPTCHA, result));
			HttpPost post = new HttpPost(target);
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparas, "UTF-8");
			post.setEntity(entity);
			response = client.execute(post);
			e = response.getEntity();
			doc = ref.getDocumentFromInputStream(e.getContent());
			List<Element> fonts = ref.selectByXPathOnDocument(doc, "//<ns>H3", doc.getRootElement().getNamespaceURI());
			Iterator<Element> it2 = fonts.iterator();
			while (it2.hasNext()) {
				Element font = it2.next();
				String txt = font.getText();
				if (txt.contains("Die SMS wurde erfolgreich versendet.")) {
					return new Result(Result.SMS_SEND);
				}
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (JDOMException e) {
			e.printStackTrace();
		}
		return new Result(Result.UNKNOWN_ERROR);
	}

}