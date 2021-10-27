class n23198240 {
	protected void doPost(HttpServletRequest osCbB1Zw, HttpServletResponse Gpi1ttBH)
			throws ServletException, IOException {
		UsuarioBll CKPWEd7r = new UsuarioBll();
		String U2w1DlUf = "";
		try {
			MessageDigest SmL5d5u4 = MessageDigest.getInstance("MD5");
			SmL5d5u4.update(osCbB1Zw.getParameter("Senha").getBytes(), 0, osCbB1Zw.getParameter("Senha").length());
			U2w1DlUf = new BigInteger(1, SmL5d5u4.digest()).toString(16);
		} catch (NoSuchAlgorithmException DlAPnJlv) {
			DlAPnJlv.printStackTrace();
		}
		String[] p7sKdeJR = osCbB1Zw.getParameter("Nascimento").split("/");
		Calendar xGXoPEtp = Calendar.getInstance();
		xGXoPEtp.set(Integer.parseInt(p7sKdeJR[2]), Integer.parseInt(p7sKdeJR[1]) - 1, Integer.parseInt(p7sKdeJR[0]));
		Telefone KBeCEl4Y = new Telefone();
		Usuario Kiiwwi24 = new Usuario();
		Kiiwwi24.setNome(osCbB1Zw.getParameter("Nome"));
		KBeCEl4Y.setTelefone(osCbB1Zw.getParameter("Telefone").replaceAll("\\D", ""));
		KBeCEl4Y.setTelefoneTipo(TelefoneTipoBll
				.getTelefoneTipoByTelefoneTipoID(Integer.parseInt(osCbB1Zw.getParameter("TipoTelefone"))));
		Kiiwwi24.setTelefone(KBeCEl4Y);
		Kiiwwi24.setEmail(osCbB1Zw.getParameter("Email"));
		Kiiwwi24.setCpf(osCbB1Zw.getParameter("CPF").replaceAll("\\D", ""));
		Kiiwwi24.setNascimento(xGXoPEtp);
		Endereco azzgJo1q = new Endereco();
		azzgJo1q.setCep(Integer.parseInt(osCbB1Zw.getParameter("CEP").replaceAll("\\D", "")));
		azzgJo1q.setNumero(osCbB1Zw.getParameter("Numero"));
		azzgJo1q.setComplemento(osCbB1Zw.getParameter("Complemento"));
		Kiiwwi24.setEndereco(azzgJo1q);
		Kiiwwi24.setSenha(U2w1DlUf);
		String beuEXkU3 = "?msg=0";
		if (CKPWEd7r.addNewUsuario(Kiiwwi24)) {
			beuEXkU3 = "?msg=1";
			Usuario goTKAsNS = UsuarioBll.getUsuarioByEmailAndSenha(Kiiwwi24.getEmail(), Kiiwwi24.getSenha());
			HttpSession lz0v55ei = osCbB1Zw.getSession();
			lz0v55ei.setAttribute("usuario", goTKAsNS);
		}
		Gpi1ttBH.sendRedirect("templates/verde-rosa/cadastro.jsp" + beuEXkU3);
	}

}