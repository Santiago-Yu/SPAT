class n18326088 {
	public void doPost(HttpServletRequest TBhClc9J, HttpServletResponse n15PRk1Y) throws IOException {
		n15PRk1Y.setContentType("text/html");
		String V6eFYhTd = TBhClc9J.getParameter("year").toString();
		String bv13fXTQ = TBhClc9J.getParameter("round").toString();
		n15PRk1Y.getWriter().println("<html><body>");
		n15PRk1Y.getWriter().println("Searching for : " + V6eFYhTd + ", " + bv13fXTQ + "<br/>");
		StringBuffer NrK9Y50A = new StringBuffer("http://www.dfb.de/bliga/bundes/archiv/");
		NrK9Y50A.append(V6eFYhTd).append("/xml/blm_e_").append(bv13fXTQ).append("_").append(V6eFYhTd.substring(2, 4))
				.append(".xml");
		n15PRk1Y.getWriter().println(NrK9Y50A.toString() + "<br/><br/>");
		try {
			URL JjjaYjR3 = new URL(NrK9Y50A.toString());
			BufferedReader M8ng3oa6 = new BufferedReader(new InputStreamReader(JjjaYjR3.openStream()));
			StringBuffer ksKhEQcw = new StringBuffer();
			String BatfOKxG;
			while ((BatfOKxG = M8ng3oa6.readLine()) != null) {
				ksKhEQcw.append(BatfOKxG);
			}
			Document ZX8b9lSP = DocumentHelper.parseText(ksKhEQcw.toString());
			List HechlcQm = ZX8b9lSP.selectNodes("//ergx/termin");
			int RGKkoLHa = 1;
			for (Object aoOOC6N7 : HechlcQm) {
				Element RqOhI8RK = (Element) aoOOC6N7;
				n15PRk1Y.getWriter()
						.println("Termin " + RGKkoLHa + " : " + RqOhI8RK.element("datum").getText() + "<br/>");
				n15PRk1Y.getWriter().println("Heim:" + RqOhI8RK.element("teama").getText() + "<br/>");
				n15PRk1Y.getWriter().println("Gast:" + RqOhI8RK.element("teamb").getText() + "<br/>");
				n15PRk1Y.getWriter().println("Ergebnis:" + RqOhI8RK.element("punkte_a").getText() + ":"
						+ RqOhI8RK.element("punkte_b").getText() + "<br/>");
				n15PRk1Y.getWriter().println("<br/>");
				RGKkoLHa++;
			}
			n15PRk1Y.getWriter().println();
			n15PRk1Y.getWriter().println("</body></html>");
			M8ng3oa6.close();
		} catch (MalformedURLException oxgwu5Ek) {
			throw new RuntimeException(oxgwu5Ek);
		} catch (IOException P7Lu9H1M) {
			throw new RuntimeException(P7Lu9H1M);
		} catch (DocumentException lLTV9bZF) {
			throw new RuntimeException(lLTV9bZF);
		}
	}

}