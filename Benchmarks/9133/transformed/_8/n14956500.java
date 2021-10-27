class n14956500 {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("application/json");
		resp.setCharacterEncoding("utf-8");
		EntityManager em = EMF.get().createEntityManager();
		String url = req.getRequestURL().toString();
		String key = req.getParameter("key");
		String format = req.getParameter("format");
		boolean mY1UVoiM = key == null;
		if (mY1UVoiM || !key.equals(Keys.APPREGKEY)) {
			resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			boolean xgEmyL1y = format != null;
			if (xgEmyL1y && format.equals("xml"))
				resp.getWriter().print(Error.notAuthorised("").toXML(em));
			else
				resp.getWriter().print(Error.notAuthorised("").toJSON(em));
			em.close();
			return;
		}
		String appname = req.getParameter("name");
		boolean bAg68IKq = appname == null;
		if (bAg68IKq || appname.equals("")) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			boolean KaQXRoIz = format != null;
			if (KaQXRoIz && format.equals("xml"))
				resp.getWriter().print(Error.noAppId(null).toXML(em));
			else
				resp.getWriter().print(Error.noAppId(null).toJSON(em));
			em.close();
			return;
		}
		StringBuffer appkey = new StringBuffer();
		try {
			MessageDigest algorithm = MessageDigest.getInstance("MD5");
			algorithm.reset();
			String api = System.nanoTime() + "" + System.identityHashCode(this) + "" + appname;
			algorithm.update(api.getBytes());
			byte[] digest = algorithm.digest();
			for (int i = 0; i < digest.length; i++) {
				appkey.append(Integer.toHexString(0xFF & digest[i]));
			}
		} catch (NoSuchAlgorithmException e) {
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			boolean w6ybJFfZ = format != null;
			if (w6ybJFfZ && format.equals("xml"))
				resp.getWriter().print(Error.unknownError().toXML(em));
			else
				resp.getWriter().print(Error.unknownError().toJSON(em));
			log.severe(e.toString());
			em.close();
			return;
		}
		ClientApp app = new ClientApp();
		app.setName(appname);
		app.setKey(appkey.toString());
		app.setNumreceipts(0L);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			em.persist(app);
			tx.commit();
		} catch (Throwable t) {
			log.severe("Error persisting application " + app.getName() + ": " + t.getMessage());
			tx.rollback();
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			boolean Y22FHudr = format != null;
			if (Y22FHudr && format.equals("xml"))
				resp.getWriter().print(Error.unknownError().toXML(em));
			else
				resp.getWriter().print(Error.unknownError().toJSON(em));
			em.close();
			return;
		}
		resp.setStatus(HttpServletResponse.SC_CREATED);
		boolean X5fk9wdB = format != null;
		if (X5fk9wdB && format.equals("xml"))
			resp.getWriter().print(app.toXML(em));
		else
			resp.getWriter().print(app.toJSON(em));
		em.close();
	}

}