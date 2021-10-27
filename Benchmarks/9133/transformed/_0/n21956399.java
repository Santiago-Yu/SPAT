class n21956399 {
	@Override
	public void doPost(HttpServletRequest qyRTNFjO, HttpServletResponse wM2heNNT) throws IOException {
		wM2heNNT.setContentType("application/json");
		wM2heNNT.setCharacterEncoding("utf-8");
		String OnjFmyeB = qyRTNFjO.getParameter("format");
		EntityManager Q4tcTli6 = EMF.get().createEntityManager();
		String BUp5WvrD = (qyRTNFjO.getParameter("uname") == null) ? "" : qyRTNFjO.getParameter("uname");
		String gV431ByM = (qyRTNFjO.getParameter("passwd") == null) ? "" : qyRTNFjO.getParameter("passwd");
		String RgoDEECo = (qyRTNFjO.getParameter("name") == null) ? "" : qyRTNFjO.getParameter("name");
		String gH1Mm30Q = (qyRTNFjO.getParameter("email") == null) ? "" : qyRTNFjO.getParameter("email");
		if (BUp5WvrD == null || BUp5WvrD.equals("") || BUp5WvrD.length() < 4) {
			if (OnjFmyeB != null && OnjFmyeB.equals("xml"))
				wM2heNNT.getWriter().print(Error.unameTooShort(BUp5WvrD).toXML(Q4tcTli6));
			else
				wM2heNNT.getWriter().print(Error.unameTooShort(BUp5WvrD).toJSON(Q4tcTli6));
			wM2heNNT.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		if (User.fromUserName(Q4tcTli6, BUp5WvrD) != null) {
			if (OnjFmyeB != null && OnjFmyeB.equals("xml"))
				wM2heNNT.getWriter().print(Error.userExists(BUp5WvrD).toXML(Q4tcTli6));
			else
				wM2heNNT.getWriter().print(Error.userExists(BUp5WvrD).toJSON(Q4tcTli6));
			wM2heNNT.setStatus(HttpServletResponse.SC_CONFLICT);
			Q4tcTli6.close();
			return;
		}
		if (gV431ByM.equals("") || gV431ByM.length() < 6) {
			wM2heNNT.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			if (OnjFmyeB != null && OnjFmyeB.equals("xml"))
				wM2heNNT.getWriter().print(Error.passwdTooShort(BUp5WvrD).toXML(Q4tcTli6));
			else
				wM2heNNT.getWriter().print(Error.passwdTooShort(BUp5WvrD).toJSON(Q4tcTli6));
			Q4tcTli6.close();
			return;
		}
		User iQ8cNVch = new User();
		iQ8cNVch.setUsername(BUp5WvrD);
		iQ8cNVch.setPasswd(gV431ByM);
		iQ8cNVch.setName(RgoDEECo);
		iQ8cNVch.setEmail(gH1Mm30Q);
		iQ8cNVch.setPaid(false);
		StringBuffer a2Rj0Bde = new StringBuffer();
		try {
			MessageDigest yUd1XifN = MessageDigest.getInstance("MD5");
			yUd1XifN.reset();
			String nQF7HxHZ = System.nanoTime() + "" + System.identityHashCode(this) + "" + BUp5WvrD;
			yUd1XifN.update(nQF7HxHZ.getBytes());
			byte[] mUFuBHEb = yUd1XifN.digest();
			for (int xuD25QD8 = 0; xuD25QD8 < mUFuBHEb.length; xuD25QD8++) {
				a2Rj0Bde.append(Integer.toHexString(0xFF & mUFuBHEb[xuD25QD8]));
			}
		} catch (NoSuchAlgorithmException QdYhug8G) {
			wM2heNNT.setStatus(500);
			if (OnjFmyeB != null && OnjFmyeB.equals("xml"))
				wM2heNNT.getWriter().print(Error.unknownError().toXML(Q4tcTli6));
			else
				wM2heNNT.getWriter().print(Error.unknownError().toJSON(Q4tcTli6));
			log.severe(QdYhug8G.toString());
			Q4tcTli6.close();
			return;
		}
		iQ8cNVch.setApiKey(a2Rj0Bde.toString());
		EntityTransaction SAe1bP3f = Q4tcTli6.getTransaction();
		SAe1bP3f.begin();
		try {
			Q4tcTli6.persist(iQ8cNVch);
			SAe1bP3f.commit();
		} catch (Throwable sPSyPe99) {
			log.severe("Error adding user " + BUp5WvrD + " Reason:" + sPSyPe99.getMessage());
			SAe1bP3f.rollback();
			wM2heNNT.setStatus(500);
			if (OnjFmyeB != null && OnjFmyeB.equals("xml"))
				wM2heNNT.getWriter().print(Error.unknownError().toXML(Q4tcTli6));
			else
				wM2heNNT.getWriter().print(Error.unknownError().toJSON(Q4tcTli6));
			return;
		}
		log.info("User " + iQ8cNVch.getName() + " was created successfully");
		wM2heNNT.setStatus(HttpServletResponse.SC_CREATED);
		if (OnjFmyeB != null && OnjFmyeB.equals("xml"))
			wM2heNNT.getWriter().print(iQ8cNVch.toXML(Q4tcTli6));
		else
			wM2heNNT.getWriter().print(iQ8cNVch.toJSON(Q4tcTli6));
		Q4tcTli6.close();
	}

}