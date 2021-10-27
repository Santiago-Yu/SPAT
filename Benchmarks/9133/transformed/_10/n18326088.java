class n18326088 {
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		String year = req.getParameter("year").toString();
		String round = req.getParameter("round").toString();
		resp.getWriter().println("<html><body>");
		resp.getWriter().println("Searching for : " + year + ", " + round + "<br/>");
		StringBuffer sb = new StringBuffer("http://www.dfb.de/bliga/bundes/archiv/");
		sb.append(year).append("/xml/blm_e_").append(round).append("_").append(year.substring(2, 4)).append(".xml");
		resp.getWriter().println(sb.toString() + "<br/><br/>");
		try {
			URL url = new URL(sb.toString());
			StringBuffer xml = new StringBuffer();
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				xml.append(line);
			}
			Document document = DocumentHelper.parseText(xml.toString());
			int index = 1;
			List termine = document.selectNodes("//ergx/termin");
			for (Object termin : termine) {
				Element terminNode = (Element) termin;
				resp.getWriter().println("Termin " + index + " : " + terminNode.element("datum").getText() + "<br/>");
				resp.getWriter().println("Heim:" + terminNode.element("teama").getText() + "<br/>");
				resp.getWriter().println("Gast:" + terminNode.element("teamb").getText() + "<br/>");
				resp.getWriter().println("Ergebnis:" + terminNode.element("punkte_a").getText() + ":"
						+ terminNode.element("punkte_b").getText() + "<br/>");
				resp.getWriter().println("<br/>");
				index++;
			}
			resp.getWriter().println();
			resp.getWriter().println("</body></html>");
			reader.close();
		} catch (MalformedURLException ex) {
			throw new RuntimeException(ex);
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		} catch (DocumentException ex) {
			throw new RuntimeException(ex);
		}
	}

}