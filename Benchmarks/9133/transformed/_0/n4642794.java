class n4642794 {
	public void render(RenderRequest clVyy75B, RenderResponse oYakoovg) throws PortletException {
		Writer WZSxcSJm = null;
		PreparedStatement bghCB6yK = null;
		DatabaseAdapter dtFUuKau = null;
		try {
			WZSxcSJm = oYakoovg.getWriter();
			if (log.isDebugEnabled())
				log.debug("Start commit new image");
			AuthSession n2VMviMk = (AuthSession) clVyy75B.getUserPrincipal();
			if (n2VMviMk == null || !n2VMviMk.isUserInRole("webmill.upload_image")) {
				throw new PortletSecurityException("You have not enough right");
			}
			dtFUuKau = DatabaseAdapter.getInstance();
			if (log.isDebugEnabled())
				log.debug("urlString - " + clVyy75B.getParameter("url_download"));
			String rNOPOQ0L = clVyy75B.getParameter("url_download").trim();
			if (rNOPOQ0L == null)
				throw new IllegalArgumentException("id_firm not initialized");
			if (log.isDebugEnabled())
				log.debug("result url_download " + rNOPOQ0L);
			String Xh7lglMG[] = { ".jpg", ".jpeg", ".gif", ".png" };
			int anS5oB29;
			for (anS5oB29 = 0; anS5oB29 < Xh7lglMG.length; anS5oB29++) {
				if ((Xh7lglMG[anS5oB29] != null) && rNOPOQ0L.toLowerCase().endsWith(Xh7lglMG[anS5oB29].toLowerCase()))
					break;
			}
			if (anS5oB29 == Xh7lglMG.length)
				throw new UploadFileException("Unsupported file extension. Error #20.03");
			if (log.isDebugEnabled())
				log.debug("id_main - " + PortletService.getLong(clVyy75B, "id_main"));
			Long fSJ9Edp9 = PortletService.getLong(clVyy75B, "id_main");
			if (fSJ9Edp9 == null)
				throw new IllegalArgumentException("id_firm not initialized");
			String ZiJoqAaW = RequestTools.getString(clVyy75B, "d");
			CustomSequenceType fK5tIWbL = new CustomSequenceType();
			fK5tIWbL.setSequenceName("seq_image_number_file");
			fK5tIWbL.setTableName("MAIN_FORUM_THREADS");
			fK5tIWbL.setColumnName("ID_THREAD");
			Long vP7OzlCs = dtFUuKau.getSequenceNextValue(fK5tIWbL);
			String iwdun3uB = portletConfig.getPortletContext().getRealPath("/") + File.separatorChar + "image";
			String UdKLvb5E = iwdun3uB + File.separatorChar;
			if (log.isDebugEnabled())
				log.debug("filename - " + UdKLvb5E);
			URL zRulLNbh = new URL(rNOPOQ0L);
			File kStuuyXC = new File(zRulLNbh.getFile());
			if (log.isDebugEnabled())
				log.debug("fileUrl - " + kStuuyXC);
			String LXRJgr9S = StringTools.appendString("" + vP7OzlCs, '0', 7, true) + "-" + kStuuyXC.getName();
			if (log.isDebugEnabled())
				log.debug("newFileName " + LXRJgr9S);
			UdKLvb5E += LXRJgr9S;
			if (log.isDebugEnabled())
				log.debug("file to write " + UdKLvb5E);
			InputStream R7Z75Hji = zRulLNbh.openStream();
			FileOutputStream ZVORoZ9x = new FileOutputStream(new File(UdKLvb5E));
			byte MinSy2gq[] = new byte[1000];
			int cY1RymMH = 0;
			while ((cY1RymMH = R7Z75Hji.read(MinSy2gq)) != -1) {
				ZVORoZ9x.write(MinSy2gq, 0, cY1RymMH);
			}
			ZVORoZ9x.close();
			ZVORoZ9x = null;
			R7Z75Hji.close();
			R7Z75Hji = null;
			zRulLNbh = null;
			WZSxcSJm.write(DateUtils.getCurrentDate("dd-MMMM-yyyy HH:mm:ss:SS", clVyy75B.getLocale()) + "<br>");
			bghCB6yK = dtFUuKau.prepareStatement("insert into WM_IMAGE_DIR "
					+ "( id_image_dir, ID_FIRM, is_group, id, id_main, name_file, description )"
					+ "(select seq_WM_IMAGE_DIR.nextval, ID_FIRM, 0, ?, ?, ?, ? "
					+ " from WM_AUTH_USER where user_login = ? )");
			RsetTools.setLong(bghCB6yK, 1, vP7OzlCs);
			RsetTools.setLong(bghCB6yK, 2, fSJ9Edp9);
			bghCB6yK.setString(3, "/image/" + LXRJgr9S);
			bghCB6yK.setString(4, ZiJoqAaW);
			bghCB6yK.setString(5, n2VMviMk.getUserLogin());
			bghCB6yK.executeUpdate();
			dtFUuKau.commit();
			WZSxcSJm.write("???????? ?????? ?????? ??? ??????<br>" + "???????? ???? " + LXRJgr9S + "<br>"
					+ DateUtils.getCurrentDate("dd-MMMM-yyyy HH:mm:ss:SS", clVyy75B.getLocale()) + "<br>" + "<br>"
					+ "<p><a href=\"" + PortletService.url("mill.image.index", clVyy75B, oYakoovg)
					+ "\">????????? ?????? ????????</a></p><br>" + "<p><a href=\""
					+ PortletService.url(ContainerConstants.CTX_TYPE_INDEX, clVyy75B, oYakoovg)
					+ "\">?? ??????? ????????</a></p>");
		} catch (Exception EgvJERG2) {
			try {
				dtFUuKau.rollback();
			} catch (Exception mEI1ahoW) {
			}
			final String C5kWqAIS = "Error upload image from url";
			log.error(C5kWqAIS, EgvJERG2);
			throw new PortletException(C5kWqAIS, EgvJERG2);
		} finally {
			DatabaseManager.close(dtFUuKau, bghCB6yK);
			dtFUuKau = null;
			bghCB6yK = null;
		}
	}

}