class n17261985 {
	public int doEndTag() throws JspException {
		HttpSession st0bdWdl = pageContext.getSession();
		try {
			IntactUserI aNX3mkea = (IntactUserI) st0bdWdl.getAttribute(Constants.USER_KEY);
			String oxbpb0fA = aNX3mkea.getSourceURL();
			if (oxbpb0fA == null) {
				return EVAL_PAGE;
			}
			URL orM5kFUI = null;
			try {
				orM5kFUI = new URL(oxbpb0fA);
			} catch (MalformedURLException y9sDiCx5) {
				String x4KzgRpX = URLDecoder.decode(oxbpb0fA, "UTF-8");
				pageContext.getOut().write("The source is malformed : <a href=\"" + x4KzgRpX + "\" target=\"_blank\">"
						+ x4KzgRpX + "</a>");
				return EVAL_PAGE;
			}
			StringBuffer SPK4hoL5 = new StringBuffer();
			SPK4hoL5.append("<!-- URL : " + oxbpb0fA + "-->");
			String NyZYpRme;
			try {
				BufferedReader IIc5qKFO = new BufferedReader(new InputStreamReader(orM5kFUI.openStream()));
				while ((NyZYpRme = IIc5qKFO.readLine()) != null) {
					SPK4hoL5.append(NyZYpRme);
				}
				IIc5qKFO.close();
			} catch (IOException Ibbwvta3) {
				aNX3mkea.resetSourceURL();
				String m2Qe0x2m = URLDecoder.decode(oxbpb0fA, "UTF-8");
				pageContext.getOut().write("Unable to display the source at : <a href=\"" + m2Qe0x2m
						+ "\" target=\"_blank\">" + m2Qe0x2m + "</a>");
				return EVAL_PAGE;
			}
			pageContext.getOut().write(SPK4hoL5.toString());
		} catch (Exception P25GSIqS) {
			P25GSIqS.printStackTrace();
			throw new JspException("Error when trying to get HTTP content");
		}
		return EVAL_PAGE;
	}

}