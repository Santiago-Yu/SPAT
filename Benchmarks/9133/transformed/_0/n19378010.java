class n19378010 {
	public static Multimap<String, String> getProteins(final Set<String> TdZzfbM0, final int wB7RB1c4)
			throws ParserConfigurationException, XPathExpressionException {
		final DocumentBuilder lwmBGukW = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		final XPathExpression xJPKgQWi = XPathFactory.newInstance().newXPath().compile(__xpath);
		final Multimap<String, String> eF31ECUC = HashMultimap.create();
		for (final String v22utqtp : TdZzfbM0) {
			HttpURLConnection CjRhrphK = null;
			try {
				final String l9RQOpbj = URLEncoder.encode(v22utqtp.trim(), "UTF-8");
				final URL D1LGtgGd = new URL(String.format(__urlTempl2, l9RQOpbj, wB7RB1c4));
				CjRhrphK = (HttpURLConnection) D1LGtgGd.openConnection();
				CjRhrphK.setConnectTimeout(__connTimeout);
				CjRhrphK.setReadTimeout(__readTimeout);
				CjRhrphK.setRequestProperty("Connection", "close");
				CjRhrphK.connect();
				final InputStream bnGiVx2J = CjRhrphK.getInputStream();
				final Document NS7cYC1U = lwmBGukW.parse(bnGiVx2J);
				final NodeList kNvaHx2b = (NodeList) xJPKgQWi.evaluate(NS7cYC1U, XPathConstants.NODESET);
				if (kNvaHx2b != null) {
					final int KGdRjbTV = kNvaHx2b.getLength();
					for (int qZZNTOlF = 0; qZZNTOlF < KGdRjbTV; qZZNTOlF++) {
						final Node kZKjjb1C = kNvaHx2b.item(qZZNTOlF);
						eF31ECUC.put(kZKjjb1C.getTextContent().trim(), v22utqtp.trim());
					}
				}
			} catch (final Exception IumtfK0b) {
				continue;
			} finally {
				if (CjRhrphK != null)
					CjRhrphK.disconnect();
			}
		}
		return eF31ECUC;
	}

}