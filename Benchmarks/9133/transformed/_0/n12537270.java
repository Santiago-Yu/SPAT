class n12537270 {
	public Vector parse(String wd2TFJfY) {
		addMessage("Parsing: " + wd2TFJfY);
		links.removeAllElements();
		URLConnection V9yLIxDN = null;
		Reader GRFFPCrs = null;
		EditorKit oZ8CI1Ba = new HTMLEditorKit();
		Document z2JszskW = oZ8CI1Ba.createDefaultDocument();
		z2JszskW.putProperty("IgnoreCharsetDirective", Boolean.TRUE);
		URL ctDfIPWU = null;
		try {
			ctDfIPWU = new URL(wd2TFJfY);
		} catch (MalformedURLException VSCd4W9M) {
			System.out.println("Malformed URL");
			return links;
		}
		try {
			V9yLIxDN = new URL(wd2TFJfY).openConnection();
			GRFFPCrs = new InputStreamReader(V9yLIxDN.getInputStream());
		} catch (Exception cVBSYnQt) {
			cVBSYnQt.printStackTrace();
			return links;
		}
		try {
			oZ8CI1Ba.read(GRFFPCrs, z2JszskW, 0);
			ElementIterator iq6uFIUZ = new ElementIterator(z2JszskW);
			javax.swing.text.Element K8DdBxMn;
			while ((K8DdBxMn = iq6uFIUZ.next()) != null) {
				SimpleAttributeSet eZQtahtx = (SimpleAttributeSet) K8DdBxMn.getAttributes().getAttribute(HTML.Tag.A);
				if (eZQtahtx != null) {
					if (eZQtahtx.toString().indexOf("script") >= 0)
						continue;
					String JMj6ttym = "";
					try {
						JMj6ttym = eZQtahtx.getAttribute(HTML.Attribute.HREF).toString();
					} catch (Exception HOQeHxGD) {
						continue;
					}
					int CqiBRUtX = 0;
					if ((CqiBRUtX = JMj6ttym.indexOf('#')) >= 0)
						JMj6ttym = JMj6ttym.substring(0, CqiBRUtX);
					URL RByMCj4V = new URL(ctDfIPWU, JMj6ttym);
					if (!ctDfIPWU.getHost().equals(RByMCj4V.getHost()))
						continue;
					String Q9iKSZW9 = RByMCj4V.toString();
					if (!Q9iKSZW9.startsWith("http"))
						continue;
					if (Q9iKSZW9.endsWith(".pdf")) {
						continue;
					}
					for (int MDrcfIru = 0; MDrcfIru < leaveSuffix.length; MDrcfIru++) {
						if ((Q9iKSZW9.endsWith(leaveSuffix[MDrcfIru])))
							continue;
					}
					boolean HF4o9Kvj = false;
					for (int r5AW1L6i = 0; r5AW1L6i < suffix.length; r5AW1L6i++) {
						if ((Q9iKSZW9.endsWith(suffix[r5AW1L6i])))
							HF4o9Kvj = true;
					}
					if (!HF4o9Kvj) {
						try {
							V9yLIxDN = RByMCj4V.openConnection();
						} catch (Exception YXPikAdn) {
						}
						String QgeO4hac = null;
						if (QgeO4hac == null)
							QgeO4hac = V9yLIxDN.getContentType();
						if (QgeO4hac.equals("application/pdf")) {
							continue;
						} else if (!QgeO4hac.equals("text/html")) {
							continue;
						}
					}
					if (!links.contains(RByMCj4V.toString())) {
						links.addElement(RByMCj4V.toString());
					}
				}
			}
		} catch (Exception rBx3BZcQ) {
			rBx3BZcQ.printStackTrace();
		}
		return links;
	}

}