class n3843254 {
	public void doGet(HttpServletRequest request_, HttpServletResponse response) throws IOException, ServletException {
		DatabaseAdapter dbDyn = null;
		Writer out = null;
		PreparedStatement st = null;
		try {
			RenderResponse renderResponse = null;
			RenderRequest renderRequest = null;
			ContentTypeTools.setContentType(response, ContentTypeTools.CONTENT_TYPE_UTF8);
			out = response.getWriter();
			AuthSession auth_ = (AuthSession) renderRequest.getUserPrincipal();
			PortletSession session = renderRequest.getPortletSession();
			if (auth_ == null) {
				throw new IllegalStateException("You have not enough right to execute this operation");
			}
			dbDyn = DatabaseAdapter.getInstance();
			Long id_shop = null;
			String index_page = PortletService.url("mill.price.index", renderRequest, renderResponse);
			if (renderRequest.getParameter(ShopPortlet.NAME_ID_SHOP_PARAM) != null) {
				id_shop = PortletService.getLong(renderRequest, ShopPortlet.NAME_ID_SHOP_PARAM);
			} else {
				Long id_ = (Long) session.getAttribute(ShopPortlet.ID_SHOP_SESSION);
				if (id_ == null) {
					response.sendRedirect(index_page);
					return;
				}
				id_shop = id_;
			}
			session.removeAttribute(ShopPortlet.ID_SHOP_SESSION);
			session.setAttribute(ShopPortlet.ID_SHOP_SESSION, id_shop);
			if (auth_.isUserInRole("webmill.edit_price_list")) {
				Long id_item = PortletService.getLong(renderRequest, "id_item");
				if (id_item == null)
					throw new IllegalArgumentException("id_item not initialized");
				if (RequestTools.getString(renderRequest, "action").equals("update")) {
					dbDyn.getConnection().setAutoCommit(false);
					String sql_ = "delete from WM_PRICE_ITEM_DESCRIPTION a " + "where exists "
							+ " ( select null from WM_PRICE_LIST b " + "   where b.id_shop = ? and b.id_item = ? and "
							+ "         a.id_item=b.id_item ) ";
					try {
						st = dbDyn.prepareStatement(sql_);
						RsetTools.setLong(st, 1, id_shop);
						RsetTools.setLong(st, 2, id_item);
						st.executeUpdate();
					} catch (Exception e0001) {
						dbDyn.rollback();
						out.write("Error #1 - " + ExceptionTools.getStackTrace(e0001, 20, "<br>"));
						return;
					} finally {
						DatabaseManager.close(st);
						st = null;
					}
					sql_ = "insert into WM_PRICE_ITEM_DESCRIPTION " + "(ID_PRICE_ITEM_DESCRIPTION, ID_ITEM, TEXT)"
							+ "(select seq_WM_PRICE_ITEM_DESCRIPTION.nextval, ID_ITEM, ? "
							+ " from WM_PRICE_LIST b where b.ID_SHOP = ? and b.ID_ITEM = ? )";
					try {
						int offset = 0;
						int idx = 0;
						byte[] b = StringTools.getBytesUTF(RequestTools.getString(renderRequest, "n"));
						int j = 0;
						st = dbDyn.prepareStatement(sql_);
						while ((idx = StringTools.getStartUTF(b, 2000, offset)) != -1) {
							st.setString(1, new String(b, offset, idx - offset, "utf-8"));
							RsetTools.setLong(st, 2, id_shop);
							RsetTools.setLong(st, 3, id_item);
							st.addBatch();
							if (j > 10)
								break;
							offset = idx;
							j++;
						}
						int[] updateCounts = st.executeBatch();
						if (log.isDebugEnabled())
							log.debug("Number of updated records - " + updateCounts);
						dbDyn.commit();
					} catch (Exception e0) {
						dbDyn.rollback();
						out.write("Error #2 - " + ExceptionTools.getStackTrace(e0, 20, "<br>"));
						return;
					} finally {
						dbDyn.getConnection().setAutoCommit(true);
						if (st != null) {
							DatabaseManager.close(st);
							st = null;
						}
					}
				}
				if (RequestTools.getString(renderRequest, "action").equals("new_image")
						&& renderRequest.getParameter("id_image") != null) {
					Long id_image = PortletService.getLong(renderRequest, "id_image");
					dbDyn.getConnection().setAutoCommit(false);
					String sql_ = "delete from WM_IMAGE_PRICE_ITEMS a " + "where exists "
							+ " ( select null from WM_PRICE_LIST b " + "where b.id_shop = ? and b.id_item = ? and "
							+ "a.id_item=b.id_item ) ";
					try {
						st = dbDyn.prepareStatement(sql_);
						RsetTools.setLong(st, 1, id_shop);
						RsetTools.setLong(st, 2, id_item);
						st.executeUpdate();
					} catch (Exception e0001) {
						dbDyn.rollback();
						out.write("Error #3 - " + ExceptionTools.getStackTrace(e0001, 20, "<br>"));
						return;
					} finally {
						DatabaseManager.close(st);
						st = null;
					}
					sql_ = "insert into WM_IMAGE_PRICE_ITEMS " + "(id_IMAGE_PRICE_ITEMS, id_item, ID_IMAGE_DIR)"
							+ "(select seq_WM_IMAGE_PRICE_ITEMS.nextval, id_item, ? "
							+ " from WM_PRICE_LIST b where b.id_shop = ? and b.id_item = ? )";
					try {
						st = dbDyn.prepareStatement(sql_);
						RsetTools.setLong(st, 1, id_image);
						RsetTools.setLong(st, 2, id_shop);
						RsetTools.setLong(st, 3, id_item);
						int updateCounts = st.executeUpdate();
						if (log.isDebugEnabled())
							log.debug("Number of updated records - " + updateCounts);
						dbDyn.commit();
					} catch (Exception e0) {
						dbDyn.rollback();
						log.error("Error insert image", e0);
						out.write("Error #4 - " + ExceptionTools.getStackTrace(e0, 20, "<br>"));
						return;
					} finally {
						dbDyn.getConnection().setAutoCommit(true);
						DatabaseManager.close(st);
						st = null;
					}
				}
				if (true)
					throw new Exception("Need refactoring");
			}
		} catch (Exception e) {
			log.error(e);
			out.write(ExceptionTools.getStackTrace(e, 20, "<br>"));
		} finally {
			DatabaseManager.close(dbDyn, st);
			dbDyn = null;
			st = null;
		}
	}

}