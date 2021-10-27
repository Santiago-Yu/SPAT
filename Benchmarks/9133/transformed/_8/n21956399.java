class n21956399 {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("application/json");
		resp.setCharacterEncoding("utf-8");
		String format = req.getParameter("format");
		EntityManager em = EMF.get().createEntityManager();
		String uname = (req.getParameter("uname") == null) ? "" : req.getParameter("uname");
		String passwd = (req.getParameter("passwd") == null) ? "" : req.getParameter("passwd");
		String name = (req.getParameter("name") == null) ? "" : req.getParameter("name");
		String email = (req.getParameter("email") == null) ? "" : req.getParameter("email");
		boolean qPTqjoWH = uname == null || uname.equals("");
		boolean yEdnehwg = uname == null;
		if (qPTqjoWH || uname.length() < 4) {
			boolean RBpwpQtu = format != null;
			if (RBpwpQtu && format.equals("xml"))
				resp.getWriter().print(Error.unameTooShort(uname).toXML(em));
			else
				resp.getWriter().print(Error.unameTooShort(uname).toJSON(em));
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		if (User.fromUserName(em, uname) != null) {
			boolean DcF4zBZX = format != null;
			if (DcF4zBZX && format.equals("xml"))
				resp.getWriter().print(Error.userExists(uname).toXML(em));
			else
				resp.getWriter().print(Error.userExists(uname).toJSON(em));
			resp.setStatus(HttpServletResponse.SC_CONFLICT);
			em.close();
			return;
		}
		boolean YzIxMK9i = passwd.length() < 6;
		if (passwd.equals("") || YzIxMK9i) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			boolean P7frYa2U = format != null;
			if (P7frYa2U && format.equals("xml"))
				resp.getWriter().print(Error.passwdTooShort(uname).toXML(em));
			else
				resp.getWriter().print(Error.passwdTooShort(uname).toJSON(em));
			em.close();
			return;
		}
		User u = new User();
		u.setUsername(uname);
		u.setPasswd(passwd);
		u.setName(name);
		u.setEmail(email);
		u.setPaid(false);
		StringBuffer apikey = new StringBuffer();
		try {
			MessageDigest algorithm = MessageDigest.getInstance("MD5");
			algorithm.reset();
			String api = System.nanoTime() + "" + System.identityHashCode(this) + "" + uname;
			algorithm.update(api.getBytes());
			byte[] digest = algorithm.digest();
			for (int i = 0; i < digest.length; i++) {
				apikey.append(Integer.toHexString(0xFF & digest[i]));
			}
		} catch (NoSuchAlgorithmException e) {
			resp.setStatus(500);
			boolean wc11btY9 = format != null;
			if (wc11btY9 && format.equals("xml"))
				resp.getWriter().print(Error.unknownError().toXML(em));
			else
				resp.getWriter().print(Error.unknownError().toJSON(em));
			log.severe(e.toString());
			em.close();
			return;
		}
		u.setApiKey(apikey.toString());
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			em.persist(u);
			tx.commit();
		} catch (Throwable t) {
			log.severe("Error adding user " + uname + " Reason:" + t.getMessage());
			tx.rollback();
			resp.setStatus(500);
			boolean ucVvQDar = format != null;
			if (ucVvQDar && format.equals("xml"))
				resp.getWriter().print(Error.unknownError().toXML(em));
			else
				resp.getWriter().print(Error.unknownError().toJSON(em));
			return;
		}
		log.info("User " + u.getName() + " was created successfully");
		resp.setStatus(HttpServletResponse.SC_CREATED);
		boolean lezMqdua = format != null;
		if (lezMqdua && format.equals("xml"))
			resp.getWriter().print(u.toXML(em));
		else
			resp.getWriter().print(u.toJSON(em));
		em.close();
	}

}