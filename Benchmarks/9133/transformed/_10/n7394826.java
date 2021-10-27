class n7394826 {
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("acao").equals("confirmar")) {
			String uuid = request.getParameter("uuid");
			PersistenceManager pm = PMF.get().getPersistenceManager();
			EmpresaDAO empresaDAO = new EmpresaDAO(pm);
			Empresa empresa = empresaDAO.pesquisar(uuid);
			if (empresa != null) {
				empresa.setAtivo(true);
				empresaDAO.criar(empresa);
			}
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(Pagina.PAGINA_APRESENTACAO);
			dispatcher.forward(request, response);
		} else if (request.getParameter("acao").equals("logoff")) {
			HttpSession session = request.getSession();
			session.setAttribute("autorizado", new Boolean("false"));
			HttpServletResponse servletResponse = (HttpServletResponse) response;
			servletResponse.sendRedirect(Pagina.PAGINA_APRESENTACAO);
		} else if (request.getParameter("acao").equals("preparar")) {
			Empresa objeto = new Empresa();
			request.setAttribute("objeto", objeto);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(Pagina.PAGINA_EMPRESA_CADASTRAR);
			dispatcher.forward(request, response);
		} else if (request.getParameter("acao").equals("cadastrar")) {
			PersistenceManager pm = PMF.get().getPersistenceManager();
			String cnpj = request.getParameter("cnpj");
			EmpresaDAO empresaDAO = new EmpresaDAO(pm);
			String nome = request.getParameter("nome");
			String razao = request.getParameter("razao");
			String bairro = request.getParameter("bairro");
			String cidade = request.getParameter("cidade");
			String cep = request.getParameter("cep");
			Integer numero = null;
			String email = request.getParameter("email");
			if (request.getParameter("numero") != null && !request.getParameter("numero").equals("")) {
				numero = new Integer(request.getParameter("numero"));
			}
			String complemento = request.getParameter("complemento");
			String endereco = request.getParameter("endereco");
			String senha = request.getParameter("senha");
			boolean emailEncontrado = empresaDAO.pesquisarEmail(email);
			boolean cnpjEncontrado = empresaDAO.pesquisarCNPJ(cnpj);
			String uuid = UUID.randomUUID().toString();
			Empresa empresa = new Empresa(nome, razao, email, email, cnpj, endereco, numero, cep, complemento, bairro,
					cidade, uuid);
			if (!emailEncontrado && !cnpjEncontrado) {
				empresa = empresaDAO.adicionar(empresa);
				UsuarioDAO usuarioDAO = new UsuarioDAO(pm);
				Usuario usuario = new Usuario(nome, email, senha, empresa.getId());
				usuarioDAO.adicionar(usuario);
				StringBuffer corpo = new StringBuffer();
				corpo.append("<html>");
				corpo.append("<head>");
				corpo.append("</head>");
				corpo.append("<body>");
				corpo.append("<body>");
				corpo.append(
						"<div style='font-family: 'Helvetica Neue', Arial, Helvetica, sans-serif; font-size: 13px; margin: 14px';>");
				corpo.append("<img src='http://www.appestoque.com.br/img/logo.jpg'/>");
				corpo.append(
						"<h2 style='font-family: 'Helvetica Neue', Arial, Helvetica, sans-serif; margin: 0 0 16px; font-size: 18px; font-weight: normal'>Ol?, "
								+ empresa.getNome() + ".</h2>");
				corpo.append("<p>Por favor, confirme sua conta do Appestoque clicando nesse link:<br>");
				corpo.append(
						"<a href='" + Constantes.URL + Constantes.URI_CONFIRMAR + "&&uuid=" + empresa.getUuid() + "'");
				corpo.append("target='_blank'>" + Constantes.URL + Constantes.URI_CONFIRMAR + "&&uuid="
						+ empresa.getUuid() + "</a></p>");
				corpo.append(
						"<p>Quando voc? confirmar, voc? ter? acesso total ao Appestoque e todas as notifica??es futuras ser?o enviadas para este endere?o de e-mail.</p>");
				corpo.append(
						"<p style='font-family: 'Helvetica Neue', Arial, Helvetica, sans-serif; font-size: 13px; line-height: 18px; border-bottom: 1px solid rgb(238, 238, 238); padding-bottom: 10px; margin: 0 0 10px'>");
				corpo.append(
						"<span style='font: italic 13px Georgia, serif; color: rgb(102, 102, 102)'>Equipe do Appestoque</span></p>");
				corpo.append(
						"<p style='font-family: 'Helvetica Neue', Arial, Helvetica, sans-serif; margin-top: 5px; font-size: 10px; color: #888888'>");
				corpo.append("Se voc? recebeu essa mensagem por engano e n?o criou uma conta do Appestoque, clique");
				corpo.append(
						" <a href='mailto:suporte@appestoque.com.br?subject=[Cadastro]Mensagem por engano&&body='target='_blank'>n?o ? minha conta</a>.</p>");
				corpo.append(
						"<p style='font-family: 'Helvetica Neue', Arial, Helvetica, sans-serif; margin-top: 5px; font-size: 10px; color: #888888'>");
				corpo.append("Por favor n?o responda esta mensagem; ela foi enviada por um endere?o");
				corpo.append("de e-mail n?o monitorado. Esta mensagem ? relacionada ao seu uso do");
				corpo.append(" Appestoque. Para mais informa??es sobre a sua conta, por");
				corpo.append("favor encaminhe um e-mail para o");
				corpo.append(
						" <a href='mailto:suporte@appestoque.com.br' target='_blank'>Suporte do Appestoque</a>.</p>");
				corpo.append("</div>");
				corpo.append("</body>");
				corpo.append("</html>");
				Util.enviarEmail(email, Constantes.ASSUNTO_CADASTRO, corpo);
				response.sendRedirect(Pagina.PAGINA_APRESENTACAO);
			} else {
				ResourceBundle bundle = ResourceBundle.getBundle("i18n", request.getLocale());
				if (emailEncontrado) {
					request.setAttribute("mensagem", bundle.getString("app.mensagem.email.cadastrado"));
				} else if (cnpjEncontrado) {
					request.setAttribute("mensagem", bundle.getString("app.mensagem.cnpj.cadastrado"));
				}
				request.setAttribute("objeto", empresa);
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher(Pagina.PAGINA_EMPRESA_CADASTRAR);
				dispatcher.forward(request, response);
			}
		} else if (request.getParameter("acao").equals("selecionar")) {
			PersistenceManager pm = PMF.get().getPersistenceManager();
			Long id = new Long(request.getParameter("id"));
			EmpresaDAO dao = new EmpresaDAO(pm);
			Empresa empresa = dao.pesquisar(id);
			HttpSession session = request.getSession();
			session.setAttribute("empresa", empresa);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(Pagina.PAGINA_MENU);
			dispatcher.forward(request, response);
		} else if (request.getParameter("acao").equals("noticia")) {
			try {
				URL url = new URL("http://feeds.folha.uol.com.br/folha/dinheiro/rss091.xml");
				HttpURLConnection httpSource = null;
				httpSource = (HttpURLConnection) url.openConnection();
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(httpSource.getInputStream());
				doc.getDocumentElement().normalize();
				NodeList nList = doc.getElementsByTagName("item");
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
				for (int temp = 0; temp < 3; temp++) {
					Node nNode = nList.item(temp);
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) nNode;
						out.print(getTagValue("title", eElement) + "<br/><br/>");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (request.getParameter("acao").equals("pdf")) {
			try {
				ServletOutputStream servletOutputStream = response.getOutputStream();
				PDF pdf = new PDF(servletOutputStream);
				response.setHeader("Content-Disposition", "attachment; filename=qrcode.pdf");
				response.setContentType("application/pdf");
				QRCode qr = null;
				Page page = new Page(pdf, Letter.PORTRAIT);
				qr = new QRCode();
				qr.setTypeNumber(Mode.MODE_8BIT_BYTE);
				qr.setErrorCorrectLevel(ErrorCorrectLevel.M);
				qr.addData("Andr? Silva Tricano");
				qr.make();
				qr.setPosition(200, 100);
				qr.drawOn(page);
				qr = new QRCode();
				qr.setTypeNumber(Mode.MODE_8BIT_BYTE);
				qr.setErrorCorrectLevel(ErrorCorrectLevel.M);
				qr.addData("Alan Silva Tricano");
				qr.make();
				qr.setPosition(400, 100);
				qr.drawOn(page);
				pdf.flush();
				servletOutputStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (request.getParameter("acao").equals("file")) {
			try {
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				File file = new File("d:\\MyXMLFile.xml");
				DocumentBuilder db = dbf.newDocumentBuilder();
				Document doc = db.parse(file);
				doc.getDocumentElement().normalize();
				System.out.println("Root element " + doc.getDocumentElement().getNodeName());
				NodeList nodeLst = doc.getElementsByTagName("employee");
				System.out.println("Information of all employees");
				for (int s = 0; s < nodeLst.getLength(); s++) {
					Node fstNode = nodeLst.item(s);
					if (fstNode.getNodeType() == Node.ELEMENT_NODE) {
						Element fstElmnt = (Element) fstNode;
						NodeList fstNmElmntLst = fstElmnt.getElementsByTagName("firstname");
						Element fstNmElmnt = (Element) fstNmElmntLst.item(0);
						NodeList fstNm = fstNmElmnt.getChildNodes();
						System.out.println("First Name : " + ((Node) fstNm.item(0)).getNodeValue());
						NodeList lstNmElmntLst = fstElmnt.getElementsByTagName("lastname");
						Element lstNmElmnt = (Element) lstNmElmntLst.item(0);
						NodeList lstNm = lstNmElmnt.getChildNodes();
						System.out.println("Last Name : " + ((Node) lstNm.item(0)).getNodeValue());
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}