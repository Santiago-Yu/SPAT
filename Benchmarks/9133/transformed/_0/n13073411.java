class n13073411 {
	public void render(RenderRequest E9bpLfQR, RenderResponse TA9V3OYp) throws PortletException {
		Writer td1lxU3V = null;
		PreparedStatement MukV36dm = null;
		DatabaseAdapter i40UZ0MI = null;
		try {
			AuthSession IPIZrHC0 = (AuthSession) E9bpLfQR.getUserPrincipal();
			if (IPIZrHC0 == null || !IPIZrHC0.isUserInRole("webmill.upload_image")) {
				throw new PortletSecurityException("You have not enough right");
			}
			if (log.isDebugEnabled())
				log.debug("Start commit new image from file");
			i40UZ0MI = DatabaseAdapter.getInstance();
			String cWJuwjHs = PortletService.url("mill.image.index", E9bpLfQR, TA9V3OYp);
			if (log.isDebugEnabled())
				log.debug("right to commit image - " + IPIZrHC0.isUserInRole("webmill.upload_image"));
			PortletSession ejNFChtP = E9bpLfQR.getPortletSession(true);
			if ((ejNFChtP.getAttribute("MILL.IMAGE.ID_MAIN") == null)
					|| (ejNFChtP.getAttribute("MILL.IMAGE.DESC_IMAGE") == null)) {
				td1lxU3V.write("Not all parametrs initialized");
				return;
			}
			Long JHfFJkrX = (Long) ejNFChtP.getAttribute("MILL.IMAGE.ID_MAIN");
			String pgTuJaDj = ((String) ejNFChtP.getAttribute("MILL.IMAGE.DESC_IMAGE"));
			if (log.isDebugEnabled())
				log.debug("image description " + pgTuJaDj);
			CustomSequenceType m5ZrEoY5 = new CustomSequenceType();
			m5ZrEoY5.setSequenceName("seq_image_number_file");
			m5ZrEoY5.setTableName("MAIN_FORUM_THREADS");
			m5ZrEoY5.setColumnName("ID_THREAD");
			Long Qb2nRg1I = i40UZ0MI.getSequenceNextValue(m5ZrEoY5);
			String HgTVLKnt = portletConfig.getPortletContext().getRealPath("/") + File.separatorChar + "image";
			String w6t7GZK1 = HgTVLKnt + File.separator + StringTools.appendString("" + Qb2nRg1I, '0', 7, true) + "-";
			if (log.isDebugEnabled())
				log.debug("image fileName " + w6t7GZK1);
			String z2fuqD7f = "";
			String wpT0tWYT[] = { ".jpg", ".jpeg", ".gif", ".png" };
			try {
				if (true)
					throw new UploadFileException("Todo need fix");
			} catch (UploadFileException ZDfjXNN2) {
				log.error("Error save image to disk", ZDfjXNN2);
				td1lxU3V.write("<html><head></head<body>" + "Error while processing this page:<br>"
						+ ExceptionTools.getStackTrace(ZDfjXNN2, 20, "<br>") + "<br>" + "<p><a href=\"" + cWJuwjHs
						+ "\">continue</a></p>" + "</body></html>");
				return;
			}
			if (log.isDebugEnabled())
				log.debug("newFileName " + z2fuqD7f);
			UserInfo BPcTwsAB = IPIZrHC0.getUserInfo();
			CustomSequenceType In1RKwPa = new CustomSequenceType();
			In1RKwPa.setSequenceName("seq_WM_image_dir");
			In1RKwPa.setTableName("WM_IMAGE_DIR");
			In1RKwPa.setColumnName("ID_IMAGE_DIR");
			Long hASCMQd7 = i40UZ0MI.getSequenceNextValue(In1RKwPa);
			MukV36dm = i40UZ0MI.prepareStatement("insert into WM_IMAGE_DIR "
					+ "( ID_IMAGE_DIR, ID_FIRM, is_group, id, id_main, name_file, description )"
					+ "(?, ?, 0, ?, ?, ?, ?");
			RsetTools.setLong(MukV36dm, 1, hASCMQd7);
			RsetTools.setLong(MukV36dm, 2, BPcTwsAB.getCompanyId());
			RsetTools.setLong(MukV36dm, 3, Qb2nRg1I);
			RsetTools.setLong(MukV36dm, 4, JHfFJkrX);
			MukV36dm.setString(5, "/image/" + z2fuqD7f);
			MukV36dm.setString(6, pgTuJaDj);
			MukV36dm.executeUpdate();
			i40UZ0MI.commit();
			if (log.isDebugEnabled())
				log.debug("redirect to indexPage - " + cWJuwjHs);
			td1lxU3V.write("Image successful uploaded");
			return;
		} catch (Exception dPnqf6J0) {
			try {
				i40UZ0MI.rollback();
			} catch (SQLException qaSuOsZb) {
			}
			final String wq7ZfaVW = "Error upload image";
			log.error(wq7ZfaVW, dPnqf6J0);
			throw new PortletException(wq7ZfaVW, dPnqf6J0);
		} finally {
			DatabaseManager.close(i40UZ0MI, MukV36dm);
			i40UZ0MI = null;
			MukV36dm = null;
		}
	}

}