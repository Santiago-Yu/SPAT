class n14956500 {
	@Override
	public void doPost(HttpServletRequest WIdIZxtJ, HttpServletResponse KFjAURu6) throws IOException {
		KFjAURu6.setContentType("application/json");
		KFjAURu6.setCharacterEncoding("utf-8");
		EntityManager sFCu3XpM = EMF.get().createEntityManager();
		String ZFQfyn68 = WIdIZxtJ.getRequestURL().toString();
		String m1CXFTyH = WIdIZxtJ.getParameter("key");
		String BppdStQU = WIdIZxtJ.getParameter("format");
		if (m1CXFTyH == null || !m1CXFTyH.equals(Keys.APPREGKEY)) {
			KFjAURu6.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			if (BppdStQU != null && BppdStQU.equals("xml"))
				KFjAURu6.getWriter().print(Error.notAuthorised("").toXML(sFCu3XpM));
			else
				KFjAURu6.getWriter().print(Error.notAuthorised("").toJSON(sFCu3XpM));
			sFCu3XpM.close();
			return;
		}
		String pFE6O0Va = WIdIZxtJ.getParameter("name");
		if (pFE6O0Va == null || pFE6O0Va.equals("")) {
			KFjAURu6.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			if (BppdStQU != null && BppdStQU.equals("xml"))
				KFjAURu6.getWriter().print(Error.noAppId(null).toXML(sFCu3XpM));
			else
				KFjAURu6.getWriter().print(Error.noAppId(null).toJSON(sFCu3XpM));
			sFCu3XpM.close();
			return;
		}
		StringBuffer HQuk0F2F = new StringBuffer();
		try {
			MessageDigest nuIJL33w = MessageDigest.getInstance("MD5");
			nuIJL33w.reset();
			String Dxbtx74k = System.nanoTime() + "" + System.identityHashCode(this) + "" + pFE6O0Va;
			nuIJL33w.update(Dxbtx74k.getBytes());
			byte[] vT2WttMO = nuIJL33w.digest();
			for (int bZo6EUSR = 0; bZo6EUSR < vT2WttMO.length; bZo6EUSR++) {
				HQuk0F2F.append(Integer.toHexString(0xFF & vT2WttMO[bZo6EUSR]));
			}
		} catch (NoSuchAlgorithmException YZWtZQfb) {
			KFjAURu6.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			if (BppdStQU != null && BppdStQU.equals("xml"))
				KFjAURu6.getWriter().print(Error.unknownError().toXML(sFCu3XpM));
			else
				KFjAURu6.getWriter().print(Error.unknownError().toJSON(sFCu3XpM));
			log.severe(YZWtZQfb.toString());
			sFCu3XpM.close();
			return;
		}
		ClientApp j4Xiq0Pe = new ClientApp();
		j4Xiq0Pe.setName(pFE6O0Va);
		j4Xiq0Pe.setKey(HQuk0F2F.toString());
		j4Xiq0Pe.setNumreceipts(0L);
		EntityTransaction b2PJZsLP = sFCu3XpM.getTransaction();
		b2PJZsLP.begin();
		try {
			sFCu3XpM.persist(j4Xiq0Pe);
			b2PJZsLP.commit();
		} catch (Throwable s5vetwz2) {
			log.severe("Error persisting application " + j4Xiq0Pe.getName() + ": " + s5vetwz2.getMessage());
			b2PJZsLP.rollback();
			KFjAURu6.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			if (BppdStQU != null && BppdStQU.equals("xml"))
				KFjAURu6.getWriter().print(Error.unknownError().toXML(sFCu3XpM));
			else
				KFjAURu6.getWriter().print(Error.unknownError().toJSON(sFCu3XpM));
			sFCu3XpM.close();
			return;
		}
		KFjAURu6.setStatus(HttpServletResponse.SC_CREATED);
		if (BppdStQU != null && BppdStQU.equals("xml"))
			KFjAURu6.getWriter().print(j4Xiq0Pe.toXML(sFCu3XpM));
		else
			KFjAURu6.getWriter().print(j4Xiq0Pe.toJSON(sFCu3XpM));
		sFCu3XpM.close();
	}

}