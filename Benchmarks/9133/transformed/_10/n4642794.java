class n4642794 {
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		PreparedStatement ps = null;
		Writer out = null;
		DatabaseAdapter dbDyn = null;
		try {
			out = renderResponse.getWriter();
			if (log.isDebugEnabled())
				log.debug("Start commit new image");
			AuthSession auth_ = (AuthSession) renderRequest.getUserPrincipal();
			if (auth_ == null || !auth_.isUserInRole("webmill.upload_image")) {
				throw new PortletSecurityException("You have not enough right");
			}
			dbDyn = DatabaseAdapter.getInstance();
			if (log.isDebugEnabled())
				log.debug("urlString - " + renderRequest.getParameter("url_download"));
			String urlString = renderRequest.getParameter("url_download").trim();
			if (urlString == null)
				throw new IllegalArgumentException("id_firm not initialized");
			String ext[] = { ".jpg", ".jpeg", ".gif", ".png" };
			if (log.isDebugEnabled())
				log.debug("result url_download " + urlString);
			int i;
			for (i = 0; i < ext.length; i++) {
				if ((ext[i] != null) && urlString.toLowerCase().endsWith(ext[i].toLowerCase()))
					break;
			}
			if (log.isDebugEnabled())
				log.debug("id_main - " + PortletService.getLong(renderRequest, "id_main"));
			if (i == ext.length)
				throw new UploadFileException("Unsupported file extension. Error #20.03");
			Long id_main = PortletService.getLong(renderRequest, "id_main");
			String desc = RequestTools.getString(renderRequest, "d");
			if (id_main == null)
				throw new IllegalArgumentException("id_firm not initialized");
			CustomSequenceType seq = new CustomSequenceType();
			seq.setSequenceName("seq_image_number_file");
			seq.setTableName("MAIN_FORUM_THREADS");
			seq.setColumnName("ID_THREAD");
			Long currID = dbDyn.getSequenceNextValue(seq);
			String storage_ = portletConfig.getPortletContext().getRealPath("/") + File.separatorChar + "image";
			String fileName = storage_ + File.separatorChar;
			URL url = new URL(urlString);
			if (log.isDebugEnabled())
				log.debug("filename - " + fileName);
			File fileUrl = new File(url.getFile());
			if (log.isDebugEnabled())
				log.debug("fileUrl - " + fileUrl);
			String newFileName = StringTools.appendString("" + currID, '0', 7, true) + "-" + fileUrl.getName();
			if (log.isDebugEnabled())
				log.debug("newFileName " + newFileName);
			fileName += newFileName;
			if (log.isDebugEnabled())
				log.debug("file to write " + fileName);
			FileOutputStream fos = new FileOutputStream(new File(fileName));
			InputStream is = url.openStream();
			int count = 0;
			byte bytes[] = new byte[1000];
			while ((count = is.read(bytes)) != -1) {
				fos.write(bytes, 0, count);
			}
			fos.close();
			fos = null;
			is.close();
			url = null;
			is = null;
			out.write(DateUtils.getCurrentDate("dd-MMMM-yyyy HH:mm:ss:SS", renderRequest.getLocale()) + "<br>");
			ps = dbDyn.prepareStatement("insert into WM_IMAGE_DIR "
					+ "( id_image_dir, ID_FIRM, is_group, id, id_main, name_file, description )"
					+ "(select seq_WM_IMAGE_DIR.nextval, ID_FIRM, 0, ?, ?, ?, ? "
					+ " from WM_AUTH_USER where user_login = ? )");
			RsetTools.setLong(ps, 1, currID);
			RsetTools.setLong(ps, 2, id_main);
			ps.setString(3, "/image/" + newFileName);
			ps.setString(4, desc);
			ps.setString(5, auth_.getUserLogin());
			ps.executeUpdate();
			dbDyn.commit();
			out.write("???????? ?????? ?????? ??? ??????<br>" + "???????? ???? " + newFileName + "<br>"
					+ DateUtils.getCurrentDate("dd-MMMM-yyyy HH:mm:ss:SS", renderRequest.getLocale()) + "<br>" + "<br>"
					+ "<p><a href=\"" + PortletService.url("mill.image.index", renderRequest, renderResponse)
					+ "\">????????? ?????? ????????</a></p><br>" + "<p><a href=\""
					+ PortletService.url(ContainerConstants.CTX_TYPE_INDEX, renderRequest, renderResponse)
					+ "\">?? ??????? ????????</a></p>");
		} catch (Exception e) {
			final String es = "Error upload image from url";
			try {
				dbDyn.rollback();
			} catch (Exception e1) {
			}
			log.error(es, e);
			throw new PortletException(es, e);
		} finally {
			DatabaseManager.close(dbDyn, ps);
			ps = null;
			dbDyn = null;
		}
	}

}