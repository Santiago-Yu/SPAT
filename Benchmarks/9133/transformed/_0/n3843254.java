class n3843254 {
	public void doGet(HttpServletRequest VbAVECmN, HttpServletResponse I9nVThQO) throws IOException, ServletException {
		Writer jXThBhMD = null;
		DatabaseAdapter sjrtOxeq = null;
		PreparedStatement tCz68FqE = null;
		try {
			RenderRequest Ol4chipD = null;
			RenderResponse FVnNIGLV = null;
			ContentTypeTools.setContentType(I9nVThQO, ContentTypeTools.CONTENT_TYPE_UTF8);
			jXThBhMD = I9nVThQO.getWriter();
			AuthSession xX9EsSGT = (AuthSession) Ol4chipD.getUserPrincipal();
			if (xX9EsSGT == null) {
				throw new IllegalStateException("You have not enough right to execute this operation");
			}
			PortletSession T7eQhVss = Ol4chipD.getPortletSession();
			sjrtOxeq = DatabaseAdapter.getInstance();
			String hIjDNuNe = PortletService.url("mill.price.index", Ol4chipD, FVnNIGLV);
			Long sYuFLXhC = null;
			if (Ol4chipD.getParameter(ShopPortlet.NAME_ID_SHOP_PARAM) != null) {
				sYuFLXhC = PortletService.getLong(Ol4chipD, ShopPortlet.NAME_ID_SHOP_PARAM);
			} else {
				Long P7aycvU1 = (Long) T7eQhVss.getAttribute(ShopPortlet.ID_SHOP_SESSION);
				if (P7aycvU1 == null) {
					I9nVThQO.sendRedirect(hIjDNuNe);
					return;
				}
				sYuFLXhC = P7aycvU1;
			}
			T7eQhVss.removeAttribute(ShopPortlet.ID_SHOP_SESSION);
			T7eQhVss.setAttribute(ShopPortlet.ID_SHOP_SESSION, sYuFLXhC);
			if (xX9EsSGT.isUserInRole("webmill.edit_price_list")) {
				Long nIG8vuGW = PortletService.getLong(Ol4chipD, "id_item");
				if (nIG8vuGW == null)
					throw new IllegalArgumentException("id_item not initialized");
				if (RequestTools.getString(Ol4chipD, "action").equals("update")) {
					sjrtOxeq.getConnection().setAutoCommit(false);
					String tyerCjYO = "delete from WM_PRICE_ITEM_DESCRIPTION a " + "where exists "
							+ " ( select null from WM_PRICE_LIST b " + "   where b.id_shop = ? and b.id_item = ? and "
							+ "         a.id_item=b.id_item ) ";
					try {
						tCz68FqE = sjrtOxeq.prepareStatement(tyerCjYO);
						RsetTools.setLong(tCz68FqE, 1, sYuFLXhC);
						RsetTools.setLong(tCz68FqE, 2, nIG8vuGW);
						tCz68FqE.executeUpdate();
					} catch (Exception F65Gmmge) {
						sjrtOxeq.rollback();
						jXThBhMD.write("Error #1 - " + ExceptionTools.getStackTrace(F65Gmmge, 20, "<br>"));
						return;
					} finally {
						DatabaseManager.close(tCz68FqE);
						tCz68FqE = null;
					}
					tyerCjYO = "insert into WM_PRICE_ITEM_DESCRIPTION " + "(ID_PRICE_ITEM_DESCRIPTION, ID_ITEM, TEXT)"
							+ "(select seq_WM_PRICE_ITEM_DESCRIPTION.nextval, ID_ITEM, ? "
							+ " from WM_PRICE_LIST b where b.ID_SHOP = ? and b.ID_ITEM = ? )";
					try {
						int ieHSZuck = 0;
						int qlAt2iu4 = 0;
						int sfWio0NB = 0;
						byte[] x2A5rY1n = StringTools.getBytesUTF(RequestTools.getString(Ol4chipD, "n"));
						tCz68FqE = sjrtOxeq.prepareStatement(tyerCjYO);
						while ((ieHSZuck = StringTools.getStartUTF(x2A5rY1n, 2000, qlAt2iu4)) != -1) {
							tCz68FqE.setString(1, new String(x2A5rY1n, qlAt2iu4, ieHSZuck - qlAt2iu4, "utf-8"));
							RsetTools.setLong(tCz68FqE, 2, sYuFLXhC);
							RsetTools.setLong(tCz68FqE, 3, nIG8vuGW);
							tCz68FqE.addBatch();
							qlAt2iu4 = ieHSZuck;
							if (sfWio0NB > 10)
								break;
							sfWio0NB++;
						}
						int[] EJrZieFy = tCz68FqE.executeBatch();
						if (log.isDebugEnabled())
							log.debug("Number of updated records - " + EJrZieFy);
						sjrtOxeq.commit();
					} catch (Exception HPGMFSxd) {
						sjrtOxeq.rollback();
						jXThBhMD.write("Error #2 - " + ExceptionTools.getStackTrace(HPGMFSxd, 20, "<br>"));
						return;
					} finally {
						sjrtOxeq.getConnection().setAutoCommit(true);
						if (tCz68FqE != null) {
							DatabaseManager.close(tCz68FqE);
							tCz68FqE = null;
						}
					}
				}
				if (RequestTools.getString(Ol4chipD, "action").equals("new_image")
						&& Ol4chipD.getParameter("id_image") != null) {
					Long ZmserBwr = PortletService.getLong(Ol4chipD, "id_image");
					sjrtOxeq.getConnection().setAutoCommit(false);
					String PzoHYmrX = "delete from WM_IMAGE_PRICE_ITEMS a " + "where exists "
							+ " ( select null from WM_PRICE_LIST b " + "where b.id_shop = ? and b.id_item = ? and "
							+ "a.id_item=b.id_item ) ";
					try {
						tCz68FqE = sjrtOxeq.prepareStatement(PzoHYmrX);
						RsetTools.setLong(tCz68FqE, 1, sYuFLXhC);
						RsetTools.setLong(tCz68FqE, 2, nIG8vuGW);
						tCz68FqE.executeUpdate();
					} catch (Exception Hcef2GIP) {
						sjrtOxeq.rollback();
						jXThBhMD.write("Error #3 - " + ExceptionTools.getStackTrace(Hcef2GIP, 20, "<br>"));
						return;
					} finally {
						DatabaseManager.close(tCz68FqE);
						tCz68FqE = null;
					}
					PzoHYmrX = "insert into WM_IMAGE_PRICE_ITEMS " + "(id_IMAGE_PRICE_ITEMS, id_item, ID_IMAGE_DIR)"
							+ "(select seq_WM_IMAGE_PRICE_ITEMS.nextval, id_item, ? "
							+ " from WM_PRICE_LIST b where b.id_shop = ? and b.id_item = ? )";
					try {
						tCz68FqE = sjrtOxeq.prepareStatement(PzoHYmrX);
						RsetTools.setLong(tCz68FqE, 1, ZmserBwr);
						RsetTools.setLong(tCz68FqE, 2, sYuFLXhC);
						RsetTools.setLong(tCz68FqE, 3, nIG8vuGW);
						int y0O8fMy1 = tCz68FqE.executeUpdate();
						if (log.isDebugEnabled())
							log.debug("Number of updated records - " + y0O8fMy1);
						sjrtOxeq.commit();
					} catch (Exception uqLJmFZn) {
						sjrtOxeq.rollback();
						log.error("Error insert image", uqLJmFZn);
						jXThBhMD.write("Error #4 - " + ExceptionTools.getStackTrace(uqLJmFZn, 20, "<br>"));
						return;
					} finally {
						sjrtOxeq.getConnection().setAutoCommit(true);
						DatabaseManager.close(tCz68FqE);
						tCz68FqE = null;
					}
				}
				if (true)
					throw new Exception("Need refactoring");
			}
		} catch (Exception m97rU2qE) {
			log.error(m97rU2qE);
			jXThBhMD.write(ExceptionTools.getStackTrace(m97rU2qE, 20, "<br>"));
		} finally {
			DatabaseManager.close(sjrtOxeq, tCz68FqE);
			tCz68FqE = null;
			sjrtOxeq = null;
		}
	}

}