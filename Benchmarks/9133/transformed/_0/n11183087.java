class n11183087 {
	protected void doPost(HttpServletRequest qvXe4AJf, HttpServletResponse KDz3p2m2)
			throws ServletException, IOException {
		String tgWHd5GL = "";
		String ATGMARrp = qvXe4AJf.getParameter("EmailLogin");
		try {
			MessageDigest NFCdZcvh = MessageDigest.getInstance("MD5");
			NFCdZcvh.update(qvXe4AJf.getParameter("SenhaLogin").getBytes(), 0,
					qvXe4AJf.getParameter("SenhaLogin").length());
			tgWHd5GL = new BigInteger(1, NFCdZcvh.digest()).toString(16);
		} catch (NoSuchAlgorithmException gZhQMBXb) {
			gZhQMBXb.printStackTrace();
		}
		Usuario Wy5xomQw = UsuarioBll.getUsuarioByEmailAndSenha(ATGMARrp, tgWHd5GL);
		String X8l876hj = qvXe4AJf.getHeader("REFERER").replace("?msg=3", "").replace("&msg=3", "") + "?&msg=3";
		if (qvXe4AJf.getHeader("REFERER").indexOf("?") != -1) {
			X8l876hj = qvXe4AJf.getHeader("REFERER").replace("?msg=3", "").replace("&msg=3", "") + "&msg=3";
		}
		if (Wy5xomQw.getNome() != null) {
			HttpSession uikYX5DX = qvXe4AJf.getSession();
			uikYX5DX.setAttribute("usuario", Wy5xomQw);
			X8l876hj = "index.jsp";
		}
		KDz3p2m2.sendRedirect(X8l876hj);
	}

}