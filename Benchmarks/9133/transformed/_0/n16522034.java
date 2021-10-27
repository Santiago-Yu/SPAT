class n16522034 {
	public int doEndTag() throws JspException {
		JspWriter gkr5w9gr = pageContext.getOut();
		HttpURLConnection ju9UqyvN = null;
		try {
			URL ScFDdSmm = new URL(((HttpServletRequest) pageContext.getRequest()).getRequestURL().toString());
			URL ftPImFAy = new URL(ScFDdSmm, url);
			ju9UqyvN = (HttpURLConnection) ftPImFAy.openConnection();
			BufferedReader uheeNlZ6 = new BufferedReader(
					new InputStreamReader(ju9UqyvN.getInputStream(), "ISO-8859-1"));
			String Ql4IrvXq = uheeNlZ6.readLine();
			while (Ql4IrvXq != null) {
				gkr5w9gr.write(Ql4IrvXq + "\n");
				Ql4IrvXq = uheeNlZ6.readLine();
			}
			uheeNlZ6.close();
		} catch (Exception EUXRgAmY) {
			try {
				gkr5w9gr.write("Erro ao incluir o conte?do da URL \"" + url + "\"");
			} catch (IOException Qtojts77) {
			}
		} finally {
			if (ju9UqyvN != null) {
				ju9UqyvN.disconnect();
			}
		}
		return super.doEndTag();
	}

}