class n18675737 {
	private void post(String pycj8G7T, Document f1o6xvVX, Set<String> e7ZxgxxB)
			throws HttpException, IOException, TransformerException {
		PostMethod ggUbiMyF = null;
		try {
			ggUbiMyF = new PostMethod("http://www.blogger.com/feeds/" + this.blogId + "/posts/default");
			ggUbiMyF.addRequestHeader("GData-Version", String.valueOf(GDataVersion));
			ggUbiMyF.addRequestHeader("Authorization", "GoogleLogin auth=" + this.AuthToken);
			Document vsM7zomU = this.domBuilder.newDocument();
			Element axkzdyE1 = vsM7zomU.createElementNS(Atom.NS, "entry");
			vsM7zomU.appendChild(axkzdyE1);
			axkzdyE1.setAttribute("xmlns", Atom.NS);
			Element AvagL85S = vsM7zomU.createElementNS(Atom.NS, "title");
			axkzdyE1.appendChild(AvagL85S);
			AvagL85S.setAttribute("type", "text");
			AvagL85S.appendChild(vsM7zomU.createTextNode(pycj8G7T));
			Element caN49smk = vsM7zomU.createElementNS(Atom.NS, "content");
			axkzdyE1.appendChild(caN49smk);
			caN49smk.setAttribute("type", "xhtml");
			caN49smk.appendChild(vsM7zomU.importNode(f1o6xvVX.getDocumentElement(), true));
			for (String Jg5Yjego : e7ZxgxxB) {
				Element fWhhsNXP = vsM7zomU.createElementNS(Atom.NS, "category");
				fWhhsNXP.setAttribute("scheme", "http://www.blogger.com/atom/ns#");
				fWhhsNXP.setAttribute("term", Jg5Yjego);
				axkzdyE1.appendChild(fWhhsNXP);
			}
			StringWriter Y3i7EGGo = new StringWriter();
			this.xml2ascii.transform(new DOMSource(vsM7zomU), new StreamResult(Y3i7EGGo));
			ggUbiMyF.setRequestEntity(new StringRequestEntity(Y3i7EGGo.toString(), "application/atom+xml", "UTF-8"));
			int lAR5hMBv = getHttpClient().executeMethod(ggUbiMyF);
			if (lAR5hMBv == 201) {
				IOUtils.copyTo(ggUbiMyF.getResponseBodyAsStream(), System.out);
			} else {
				throw new HttpException("post returned http-code=" + lAR5hMBv + " expected 201 (CREATE)");
			}
		} catch (TransformerException mGGbfAtb) {
			throw mGGbfAtb;
		} catch (HttpException ZDH4cINL) {
			throw ZDH4cINL;
		} catch (IOException WubJQsdF) {
			throw WubJQsdF;
		} finally {
			if (ggUbiMyF != null)
				ggUbiMyF.releaseConnection();
		}
	}

}