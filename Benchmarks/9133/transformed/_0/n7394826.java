class n7394826 {
	public void process(HttpServletRequest H0V4PPXG, HttpServletResponse BDuH61m1)
			throws ServletException, IOException {
		if (H0V4PPXG.getParameter("acao").equals("confirmar")) {
			String NrbvMClO = H0V4PPXG.getParameter("uuid");
			PersistenceManager Y7KXtdbV = PMF.get().getPersistenceManager();
			EmpresaDAO dnopXeaO = new EmpresaDAO(Y7KXtdbV);
			Empresa IT7UvHk3 = dnopXeaO.pesquisar(NrbvMClO);
			if (IT7UvHk3 != null) {
				IT7UvHk3.setAtivo(true);
				dnopXeaO.criar(IT7UvHk3);
			}
			RequestDispatcher o16yKfYa = getServletContext().getRequestDispatcher(Pagina.PAGINA_APRESENTACAO);
			o16yKfYa.forward(H0V4PPXG, BDuH61m1);
		} else if (H0V4PPXG.getParameter("acao").equals("logoff")) {
			HttpSession BgLDc2iI = H0V4PPXG.getSession();
			BgLDc2iI.setAttribute("autorizado", new Boolean("false"));
			HttpServletResponse mTcz0XP1 = (HttpServletResponse) BDuH61m1;
			mTcz0XP1.sendRedirect(Pagina.PAGINA_APRESENTACAO);
		} else if (H0V4PPXG.getParameter("acao").equals("preparar")) {
			Empresa Ai1YxNDY = new Empresa();
			H0V4PPXG.setAttribute("objeto", Ai1YxNDY);
			RequestDispatcher VhTmhMUg = getServletContext().getRequestDispatcher(Pagina.PAGINA_EMPRESA_CADASTRAR);
			VhTmhMUg.forward(H0V4PPXG, BDuH61m1);
		} else if (H0V4PPXG.getParameter("acao").equals("cadastrar")) {
			PersistenceManager Plnn8x2X = PMF.get().getPersistenceManager();
			EmpresaDAO GTLjLilt = new EmpresaDAO(Plnn8x2X);
			String IcOGaSZ9 = H0V4PPXG.getParameter("cnpj");
			String gJBwPnWI = H0V4PPXG.getParameter("nome");
			String X6QPsDNv = H0V4PPXG.getParameter("razao");
			String HmQDleXP = H0V4PPXG.getParameter("bairro");
			String QGGUggkr = H0V4PPXG.getParameter("cidade");
			String FGYHKtpp = H0V4PPXG.getParameter("cep");
			String OqmcicsW = H0V4PPXG.getParameter("email");
			Integer MvqTWPzc = null;
			if (H0V4PPXG.getParameter("numero") != null && !H0V4PPXG.getParameter("numero").equals("")) {
				MvqTWPzc = new Integer(H0V4PPXG.getParameter("numero"));
			}
			String a3xRDt3N = H0V4PPXG.getParameter("complemento");
			String NQhWMD55 = H0V4PPXG.getParameter("endereco");
			String XzQ2CQBM = H0V4PPXG.getParameter("senha");
			boolean SWuQda0k = GTLjLilt.pesquisarEmail(OqmcicsW);
			boolean BIaUbFVl = GTLjLilt.pesquisarCNPJ(IcOGaSZ9);
			String jmQDfy5W = UUID.randomUUID().toString();
			Empresa iitjtbIh = new Empresa(gJBwPnWI, X6QPsDNv, OqmcicsW, OqmcicsW, IcOGaSZ9, NQhWMD55, MvqTWPzc,
					FGYHKtpp, a3xRDt3N, HmQDleXP, QGGUggkr, jmQDfy5W);
			if (!SWuQda0k && !BIaUbFVl) {
				iitjtbIh = GTLjLilt.adicionar(iitjtbIh);
				Usuario mkwlTG8M = new Usuario(gJBwPnWI, OqmcicsW, XzQ2CQBM, iitjtbIh.getId());
				UsuarioDAO p3ajyiOv = new UsuarioDAO(Plnn8x2X);
				p3ajyiOv.adicionar(mkwlTG8M);
				StringBuffer AmGz0V5i = new StringBuffer();
				AmGz0V5i.append("<html>");
				AmGz0V5i.append("<head>");
				AmGz0V5i.append("</head>");
				AmGz0V5i.append("<body>");
				AmGz0V5i.append("<body>");
				AmGz0V5i.append(
						"<div style='font-family: 'Helvetica Neue', Arial, Helvetica, sans-serif; font-size: 13px; margin: 14px';>");
				AmGz0V5i.append("<img src='http://www.appestoque.com.br/img/logo.jpg'/>");
				AmGz0V5i.append(
						"<h2 style='font-family: 'Helvetica Neue', Arial, Helvetica, sans-serif; margin: 0 0 16px; font-size: 18px; font-weight: normal'>Ol?, "
								+ iitjtbIh.getNome() + ".</h2>");
				AmGz0V5i.append("<p>Por favor, confirme sua conta do Appestoque clicando nesse link:<br>");
				AmGz0V5i.append(
						"<a href='" + Constantes.URL + Constantes.URI_CONFIRMAR + "&&uuid=" + iitjtbIh.getUuid() + "'");
				AmGz0V5i.append("target='_blank'>" + Constantes.URL + Constantes.URI_CONFIRMAR + "&&uuid="
						+ iitjtbIh.getUuid() + "</a></p>");
				AmGz0V5i.append(
						"<p>Quando voc? confirmar, voc? ter? acesso total ao Appestoque e todas as notifica??es futuras ser?o enviadas para este endere?o de e-mail.</p>");
				AmGz0V5i.append(
						"<p style='font-family: 'Helvetica Neue', Arial, Helvetica, sans-serif; font-size: 13px; line-height: 18px; border-bottom: 1px solid rgb(238, 238, 238); padding-bottom: 10px; margin: 0 0 10px'>");
				AmGz0V5i.append(
						"<span style='font: italic 13px Georgia, serif; color: rgb(102, 102, 102)'>Equipe do Appestoque</span></p>");
				AmGz0V5i.append(
						"<p style='font-family: 'Helvetica Neue', Arial, Helvetica, sans-serif; margin-top: 5px; font-size: 10px; color: #888888'>");
				AmGz0V5i.append("Se voc? recebeu essa mensagem por engano e n?o criou uma conta do Appestoque, clique");
				AmGz0V5i.append(
						" <a href='mailto:suporte@appestoque.com.br?subject=[Cadastro]Mensagem por engano&&body='target='_blank'>n?o ? minha conta</a>.</p>");
				AmGz0V5i.append(
						"<p style='font-family: 'Helvetica Neue', Arial, Helvetica, sans-serif; margin-top: 5px; font-size: 10px; color: #888888'>");
				AmGz0V5i.append("Por favor n?o responda esta mensagem; ela foi enviada por um endere?o");
				AmGz0V5i.append("de e-mail n?o monitorado. Esta mensagem ? relacionada ao seu uso do");
				AmGz0V5i.append(" Appestoque. Para mais informa??es sobre a sua conta, por");
				AmGz0V5i.append("favor encaminhe um e-mail para o");
				AmGz0V5i.append(
						" <a href='mailto:suporte@appestoque.com.br' target='_blank'>Suporte do Appestoque</a>.</p>");
				AmGz0V5i.append("</div>");
				AmGz0V5i.append("</body>");
				AmGz0V5i.append("</html>");
				Util.enviarEmail(OqmcicsW, Constantes.ASSUNTO_CADASTRO, AmGz0V5i);
				BDuH61m1.sendRedirect(Pagina.PAGINA_APRESENTACAO);
			} else {
				ResourceBundle QjCvLUCS = ResourceBundle.getBundle("i18n", H0V4PPXG.getLocale());
				if (SWuQda0k) {
					H0V4PPXG.setAttribute("mensagem", QjCvLUCS.getString("app.mensagem.email.cadastrado"));
				} else if (BIaUbFVl) {
					H0V4PPXG.setAttribute("mensagem", QjCvLUCS.getString("app.mensagem.cnpj.cadastrado"));
				}
				H0V4PPXG.setAttribute("objeto", iitjtbIh);
				RequestDispatcher MHEQCS19 = getServletContext().getRequestDispatcher(Pagina.PAGINA_EMPRESA_CADASTRAR);
				MHEQCS19.forward(H0V4PPXG, BDuH61m1);
			}
		} else if (H0V4PPXG.getParameter("acao").equals("selecionar")) {
			PersistenceManager pNdf8KIN = PMF.get().getPersistenceManager();
			EmpresaDAO RyJ5Sr6N = new EmpresaDAO(pNdf8KIN);
			Long nTpDCfRb = new Long(H0V4PPXG.getParameter("id"));
			Empresa sQRlvJTZ = RyJ5Sr6N.pesquisar(nTpDCfRb);
			HttpSession H6mjRYr7 = H0V4PPXG.getSession();
			H6mjRYr7.setAttribute("empresa", sQRlvJTZ);
			RequestDispatcher Tnidn7xI = getServletContext().getRequestDispatcher(Pagina.PAGINA_MENU);
			Tnidn7xI.forward(H0V4PPXG, BDuH61m1);
		} else if (H0V4PPXG.getParameter("acao").equals("noticia")) {
			try {
				HttpURLConnection xOpGEJBA = null;
				URL PpFqTvfb = new URL("http://feeds.folha.uol.com.br/folha/dinheiro/rss091.xml");
				xOpGEJBA = (HttpURLConnection) PpFqTvfb.openConnection();
				DocumentBuilderFactory YBQFfe9q = DocumentBuilderFactory.newInstance();
				DocumentBuilder yy3fAmni = YBQFfe9q.newDocumentBuilder();
				Document E1vha6c4 = yy3fAmni.parse(xOpGEJBA.getInputStream());
				E1vha6c4.getDocumentElement().normalize();
				NodeList cnKHqfzO = E1vha6c4.getElementsByTagName("item");
				PrintWriter M1vRomdJ = BDuH61m1.getWriter();
				BDuH61m1.setContentType("text/html");
				for (int BmHqdBOa = 0; BmHqdBOa < 3; BmHqdBOa++) {
					Node WsjSoGbE = cnKHqfzO.item(BmHqdBOa);
					if (WsjSoGbE.getNodeType() == Node.ELEMENT_NODE) {
						Element gC0fDeKd = (Element) WsjSoGbE;
						M1vRomdJ.print(getTagValue("title", gC0fDeKd) + "<br/><br/>");
					}
				}
			} catch (Exception k0hTVFgQ) {
				k0hTVFgQ.printStackTrace();
			}
		} else if (H0V4PPXG.getParameter("acao").equals("pdf")) {
			try {
				ServletOutputStream ixGN1V0i = BDuH61m1.getOutputStream();
				PDF xsuSGttg = new PDF(ixGN1V0i);
				BDuH61m1.setHeader("Content-Disposition", "attachment; filename=qrcode.pdf");
				BDuH61m1.setContentType("application/pdf");
				Page CztkBbnw = new Page(xsuSGttg, Letter.PORTRAIT);
				QRCode d1gYFCLF = null;
				d1gYFCLF = new QRCode();
				d1gYFCLF.setTypeNumber(Mode.MODE_8BIT_BYTE);
				d1gYFCLF.setErrorCorrectLevel(ErrorCorrectLevel.M);
				d1gYFCLF.addData("Andr? Silva Tricano");
				d1gYFCLF.make();
				d1gYFCLF.setPosition(200, 100);
				d1gYFCLF.drawOn(CztkBbnw);
				d1gYFCLF = new QRCode();
				d1gYFCLF.setTypeNumber(Mode.MODE_8BIT_BYTE);
				d1gYFCLF.setErrorCorrectLevel(ErrorCorrectLevel.M);
				d1gYFCLF.addData("Alan Silva Tricano");
				d1gYFCLF.make();
				d1gYFCLF.setPosition(400, 100);
				d1gYFCLF.drawOn(CztkBbnw);
				xsuSGttg.flush();
				ixGN1V0i.close();
			} catch (Exception NUBAdwr2) {
				NUBAdwr2.printStackTrace();
			}
		} else if (H0V4PPXG.getParameter("acao").equals("file")) {
			try {
				File ajKTLgtq = new File("d:\\MyXMLFile.xml");
				DocumentBuilderFactory mjSpe3yk = DocumentBuilderFactory.newInstance();
				DocumentBuilder bYHDtyyT = mjSpe3yk.newDocumentBuilder();
				Document Z0K8LhnX = bYHDtyyT.parse(ajKTLgtq);
				Z0K8LhnX.getDocumentElement().normalize();
				System.out.println("Root element " + Z0K8LhnX.getDocumentElement().getNodeName());
				NodeList QARtUm2t = Z0K8LhnX.getElementsByTagName("employee");
				System.out.println("Information of all employees");
				for (int M8ydnq2R = 0; M8ydnq2R < QARtUm2t.getLength(); M8ydnq2R++) {
					Node CZHOqIcA = QARtUm2t.item(M8ydnq2R);
					if (CZHOqIcA.getNodeType() == Node.ELEMENT_NODE) {
						Element WkXD3Ujs = (Element) CZHOqIcA;
						NodeList CvfFSKUe = WkXD3Ujs.getElementsByTagName("firstname");
						Element J8Bzhe34 = (Element) CvfFSKUe.item(0);
						NodeList eY58PfHC = J8Bzhe34.getChildNodes();
						System.out.println("First Name : " + ((Node) eY58PfHC.item(0)).getNodeValue());
						NodeList pJNiQ0Ro = WkXD3Ujs.getElementsByTagName("lastname");
						Element bNKdRn9K = (Element) pJNiQ0Ro.item(0);
						NodeList I7MXUYFC = bNKdRn9K.getChildNodes();
						System.out.println("Last Name : " + ((Node) I7MXUYFC.item(0)).getNodeValue());
					}
				}
			} catch (Exception ETmWBXcz) {
				ETmWBXcz.printStackTrace();
			}
		}
	}

}