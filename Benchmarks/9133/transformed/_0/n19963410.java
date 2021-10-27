class n19963410 {
	@Override
	public Result sendSMS(String FevYaLEi, String gTgB550q, Proxy O7H2wqt6) {
		try {
			DefaultHttpClient egccqkKp = new DefaultHttpClient();
			if (O7H2wqt6 != null) {
				HttpHost p7BlxlCe = new HttpHost(O7H2wqt6.host, O7H2wqt6.port);
				egccqkKp.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, p7BlxlCe);
			}
			String MYxZvedr = "http://www.smsbilliger.de/free-sms.html";
			HttpGet tS5ZEaWy = new HttpGet(MYxZvedr);
			HttpResponse a0OvoXg2 = egccqkKp.execute(tS5ZEaWy);
			HttpEntity JHlcGHsc = a0OvoXg2.getEntity();
			Document dSjzs2ye = ref.getDocumentFromInputStream(JHlcGHsc.getContent());
			List<Element> RpGXHzYF = ref.selectByXPathOnDocument(dSjzs2ye, "//<ns>FORM",
					dSjzs2ye.getRootElement().getNamespaceURI());
			if (RpGXHzYF.size() == 0)
				return new Result(Result.SMS_LIMIT_REACHED);
			Element dPHgJwQ8 = RpGXHzYF.get(0);
			List<NameValuePair> niLSL3Ot = new ArrayList<NameValuePair>();
			List<Element> uixUAs40 = ref.selectByXPathOnElement(dPHgJwQ8, "//<ns>INPUT|//<ns>TEXTAREA|//<ns>SELECT",
					dPHgJwQ8.getNamespaceURI());
			Iterator<Element> gQ6suoZw = uixUAs40.iterator();
			while (gQ6suoZw.hasNext()) {
				Element NI8Rsel3 = gQ6suoZw.next();
				String lxiaS542 = NI8Rsel3.getAttributeValue("type");
				String dJIi8NS4 = NI8Rsel3.getAttributeValue("name");
				String PIuJrI8N = NI8Rsel3.getAttributeValue("value");
				if (lxiaS542 != null && lxiaS542.equals("hidden")) {
					niLSL3Ot.add(new BasicNameValuePair(dJIi8NS4, PIuJrI8N));
				} else if (dJIi8NS4 != null && dJIi8NS4.equals(FORM_NUMBER)) {
					niLSL3Ot.add(new BasicNameValuePair(dJIi8NS4, this.getNumberPart(FevYaLEi)));
				} else if (dJIi8NS4 != null && dJIi8NS4.equals(FORM_TEXT)) {
					niLSL3Ot.add(new BasicNameValuePair(dJIi8NS4, gTgB550q));
				} else if (dJIi8NS4 != null && dJIi8NS4.equals(FORM_AGB)) {
					niLSL3Ot.add(new BasicNameValuePair(dJIi8NS4, "true"));
				}
			}
			niLSL3Ot.add(new BasicNameValuePair("dialing_code", this.getPrefixPart(FevYaLEi)));
			niLSL3Ot.add(new BasicNameValuePair("no_schedule", "yes"));
			List<Element> K5Gl5LvM = ref.selectByXPathOnDocument(dSjzs2ye, "//<ns>IMG[@id='code_img']",
					dSjzs2ye.getRootElement().getNamespaceURI());
			Element ym3GjbaM = K5Gl5LvM.get(0);
			String gXQydUxM = "http://www.smsbilliger.de/" + ym3GjbaM.getAttributeValue("src");
			HttpGet LeKZ8VdG = new HttpGet(gXQydUxM);
			HttpResponse cFhWHyoJ = egccqkKp.execute(LeKZ8VdG);
			HttpEntity OSHXCsrn = cFhWHyoJ.getEntity();
			BufferedImage aNowqIQp = ImageIO.read(OSHXCsrn.getContent());
			OSHXCsrn.getContent().close();
			Icon giV8azu9 = new ImageIcon(aNowqIQp);
			String oa2o3JHW = (String) JOptionPane.showInputDialog(null, "Bitte Captcha eingeben:", "Captcha",
					JOptionPane.INFORMATION_MESSAGE, giV8azu9, null, "");
			niLSL3Ot.add(new BasicNameValuePair(FORM_CAPTCHA, oa2o3JHW));
			UrlEncodedFormEntity tklVKHaI = new UrlEncodedFormEntity(niLSL3Ot, "UTF-8");
			HttpPost HuFmgMXY = new HttpPost(MYxZvedr);
			HuFmgMXY.setEntity(tklVKHaI);
			a0OvoXg2 = egccqkKp.execute(HuFmgMXY);
			JHlcGHsc = a0OvoXg2.getEntity();
			dSjzs2ye = ref.getDocumentFromInputStream(JHlcGHsc.getContent());
			List<Element> rfoL9X2L = ref.selectByXPathOnDocument(dSjzs2ye, "//<ns>H3",
					dSjzs2ye.getRootElement().getNamespaceURI());
			Iterator<Element> KdJ1xZhg = rfoL9X2L.iterator();
			while (KdJ1xZhg.hasNext()) {
				Element S8lER9EL = KdJ1xZhg.next();
				String L3Lodtzv = S8lER9EL.getText();
				if (L3Lodtzv.contains("Die SMS wurde erfolgreich versendet.")) {
					return new Result(Result.SMS_SEND);
				}
			}
		} catch (ClientProtocolException PjkHMfAb) {
			PjkHMfAb.printStackTrace();
		} catch (IOException kcV2SaDA) {
			kcV2SaDA.printStackTrace();
		} catch (IllegalStateException qWgyVkQD) {
			qWgyVkQD.printStackTrace();
		} catch (SAXException HCS7Ae7l) {
			HCS7Ae7l.printStackTrace();
		} catch (JDOMException VNXQGXVL) {
			VNXQGXVL.printStackTrace();
		}
		return new Result(Result.UNKNOWN_ERROR);
	}

}