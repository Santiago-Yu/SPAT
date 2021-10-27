class n8974345 {
	public String sruRead(String ZxkgCaUP) {
		out('\n');
		out("    trying: ");
		out(ZxkgCaUP);
		out('\n');
		numTests++;
		URL OaV6FOZT = null;
		try {
			OaV6FOZT = new URL(ZxkgCaUP);
		} catch (java.net.MalformedURLException ODPltDl4) {
			out("</pre><pre class='red'>");
			out("test failed: using URL: ");
			out(ODPltDl4.getMessage());
			out('\n');
			out("</pre><pre>");
			return null;
		}
		HttpURLConnection Vkop3XbK = null;
		try {
			Vkop3XbK = (HttpURLConnection) OaV6FOZT.openConnection();
		} catch (IOException quO36D95) {
			out("</pre><pre class='red'>");
			out("test failed: using URL: ");
			out(quO36D95.getMessage());
			out('\n');
			out("</pre><pre>");
			return null;
		}
		String dE8KJOjZ = Vkop3XbK.getContentType();
		if (dE8KJOjZ == null || (dE8KJOjZ.indexOf("text/xml") < 0 && dE8KJOjZ.indexOf("application/xml") < 0)) {
			out("  ** Warning: Content-Type not set to text/xml or application/xml");
			out('\n');
			out("    Content-type: ");
			out(dE8KJOjZ);
			out('\n');
			numWarns++;
		}
		InputStream dgAtawFA = null;
		try {
			dgAtawFA = Vkop3XbK.getInputStream();
		} catch (java.io.IOException qjGMM50G) {
			out("</pre><pre class='red'>");
			out("test failed: opening URL: ");
			out(qjGMM50G.getMessage());
			out('\n');
			out("</pre><pre>");
			return null;
		}
		BufferedReader IBUjunaR = new BufferedReader(new InputStreamReader(dgAtawFA));
		boolean vjUHOJQy = true;
		String JRkbeb20 = null, V8eMa08r = null;
		StringBuffer jcikM3vL = new StringBuffer(), MTxjBNQp = null;
		Transformer veRomgPE = null;
		try {
			V8eMa08r = IBUjunaR.readLine();
		} catch (java.io.IOException KZcr2Jn5) {
			out("</pre><pre class='red'>");
			out("test failed: reading first line of response: ");
			out(KZcr2Jn5.getMessage());
			out('\n');
			out("</pre><pre>");
			return null;
		}
		if (V8eMa08r == null) {
			out("</pre><pre class='red'>");
			out("test failed: No input read from URL");
			out('\n');
			out("</pre><pre>");
			return null;
		}
		if (!V8eMa08r.startsWith("<?xml ")) {
			vjUHOJQy = false;
			jcikM3vL.append(V8eMa08r);
		}
		if (vjUHOJQy) {
			int MRaTkPfs = V8eMa08r.indexOf('>');
			if (MRaTkPfs + 2 < V8eMa08r.length()) {
				V8eMa08r = V8eMa08r.substring(MRaTkPfs + 1);
				MRaTkPfs = V8eMa08r.indexOf('<');
				if (MRaTkPfs > 0)
					V8eMa08r = V8eMa08r.substring(MRaTkPfs);
			} else
				try {
					V8eMa08r = IBUjunaR.readLine();
					while (V8eMa08r.length() == 0)
						V8eMa08r = IBUjunaR.readLine();
				} catch (java.io.IOException fV7cYgIK) {
					out("</pre><pre class='red'>");
					out("test failed: reading response: ");
					out(fV7cYgIK.getMessage());
					out('\n');
					out("</pre><pre>");
					return null;
				}
			if (V8eMa08r.startsWith("<?xml-stylesheet ")) {
				MRaTkPfs = V8eMa08r.indexOf("href=");
				JRkbeb20 = (V8eMa08r.substring(V8eMa08r.indexOf("href=") + 6));
				JRkbeb20 = JRkbeb20.substring(0, JRkbeb20.indexOf('"'));
				veRomgPE = (Transformer) transformers.get(JRkbeb20);
				if (stylesheets.get(JRkbeb20) == null)
					try {
						out("        reading stylesheet: ");
						out(JRkbeb20);
						out('\n');
						out("           from source: ");
						out(OaV6FOZT.toString());
						out('\n');
						StreamSource VAHK1Cn1 = new StreamSource(OaV6FOZT.toString());
						TransformerFactory sHMAqNHx = TransformerFactory.newInstance();
						Source V3aPoOL8 = sHMAqNHx.getAssociatedStylesheet(VAHK1Cn1, null, null, null);
						veRomgPE = sHMAqNHx.newTransformer(V3aPoOL8);
						transformers.put(JRkbeb20, veRomgPE);
					} catch (Exception CFfOlTHl) {
						CFfOlTHl.printStackTrace();
						out("</pre><pre class='red'>");
						out("unable to load stylesheet: ");
						out(CFfOlTHl.getMessage());
						out('\n');
						out("</pre><pre>");
					}
				stylesheets.put(JRkbeb20, JRkbeb20);
			} else
				jcikM3vL.append(V8eMa08r);
		}
		try {
			while ((V8eMa08r = IBUjunaR.readLine()) != null)
				jcikM3vL.append(V8eMa08r);
		} catch (java.io.IOException KVgzr5Yx) {
			out("</pre><pre class='red'>");
			out("test failed: reading response: ");
			out(KVgzr5Yx.getMessage());
			out('\n');
			out("</pre><pre>");
			return null;
		}
		String TKqx9uCY = jcikM3vL.toString();
		if (veRomgPE != null) {
			StreamSource svWLf1o5 = new StreamSource(new StringReader(TKqx9uCY));
			StringWriter JRGlvy8P = new StringWriter();
			try {
				veRomgPE.transform(svWLf1o5, new StreamResult(JRGlvy8P));
				out("        successfully applied stylesheet '");
				out(JRkbeb20);
				out("'");
				out('\n');
			} catch (javax.xml.transform.TransformerException yH45xkW2) {
				out("</pre><pre class='red'>");
				out("unable to apply stylesheet '");
				out(JRkbeb20);
				out("'to response: ");
				out(yH45xkW2.getMessage());
				out('\n');
				out("</pre><pre>");
				yH45xkW2.printStackTrace();
			}
		}
		return TKqx9uCY;
	}

}