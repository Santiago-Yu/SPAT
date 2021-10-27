class n11275834 {
	private void createHomeTab() {
		Tabpanel cgABIGms = new Tabpanel();
		windowContainer.addWindow(cgABIGms, Msg.getMsg(EnvWeb.getCtx(), "Home").replaceAll("&", ""), false);
		Portallayout gU1l8RVM = new Portallayout();
		gU1l8RVM.setWidth("100%");
		gU1l8RVM.setHeight("100%");
		gU1l8RVM.setStyle("position: absolute; overflow: auto");
		cgABIGms.appendChild(gU1l8RVM);
		Portalchildren s5F3H1Qn = null;
		int cdfR4Mld = 0;
		String gKYni8jc = "SELECT COUNT(DISTINCT COLUMNNO) " + "FROM PA_DASHBOARDCONTENT "
				+ "WHERE (AD_CLIENT_ID=0 OR AD_CLIENT_ID=?) AND ISACTIVE='Y'";
		int SQXtbLw8 = DB.getSQLValue(null, gKYni8jc, EnvWeb.getCtx().getAD_Client_ID());
		int dS9pBxpo = SQXtbLw8 <= 0 ? 100 : 100 / SQXtbLw8;
		gKYni8jc = "SELECT x.*, m.AD_MENU_ID " + "FROM PA_DASHBOARDCONTENT x "
				+ "LEFT OUTER JOIN AD_MENU m ON x.AD_WINDOW_ID=m.AD_WINDOW_ID "
				+ "WHERE (x.AD_CLIENT_ID=0 OR x.AD_CLIENT_ID=?) AND x.ISACTIVE='Y' "
				+ "AND x.zulfilepath not in (?, ?, ?) " + "ORDER BY x.COLUMNNO, x.AD_CLIENT_ID, x.LINE ";
		PreparedStatement gKDTzEwQ = null;
		ResultSet iP22yEw1 = null;
		try {
			gKDTzEwQ = DB.prepareStatement(gKYni8jc, null);
			gKDTzEwQ.setInt(1, EnvWeb.getCtx().getAD_Client_ID());
			gKDTzEwQ.setString(2, ACTIVITIES_PATH);
			gKDTzEwQ.setString(3, FAVOURITES_PATH);
			gKDTzEwQ.setString(4, VIEWS_PATH);
			iP22yEw1 = gKDTzEwQ.executeQuery();
			while (iP22yEw1.next()) {
				int VqzKgnRe = iP22yEw1.getInt("ColumnNo");
				if (s5F3H1Qn == null || cdfR4Mld != VqzKgnRe) {
					s5F3H1Qn = new Portalchildren();
					gU1l8RVM.appendChild(s5F3H1Qn);
					s5F3H1Qn.setWidth(dS9pBxpo + "%");
					s5F3H1Qn.setStyle("padding: 5px");
					cdfR4Mld = VqzKgnRe;
				}
				Panel xiSQ6F8m = new Panel();
				xiSQ6F8m.setStyle("margin-bottom:10px");
				xiSQ6F8m.setTitle(iP22yEw1.getString("Name"));
				String R0Qh4iJR = iP22yEw1.getString("Description");
				if (R0Qh4iJR != null)
					xiSQ6F8m.setTooltiptext(R0Qh4iJR);
				String Tx2z88DH = iP22yEw1.getString("IsCollapsible");
				xiSQ6F8m.setCollapsible(Tx2z88DH.equals("Y"));
				xiSQ6F8m.setBorder("normal");
				s5F3H1Qn.appendChild(xiSQ6F8m);
				Panelchildren wKSnh8SX = new Panelchildren();
				xiSQ6F8m.appendChild(wKSnh8SX);
				boolean XXbGim7o = true;
				String FGmazLnJ = iP22yEw1.getString("HTML");
				if (FGmazLnJ != null) {
					StringBuffer Xz9inJqu = new StringBuffer("<html><head>");
					URL VbT135wN = getClass().getClassLoader().getResource("org/compiere/images/PAPanel.css");
					InputStreamReader hjm2O7oa;
					try {
						hjm2O7oa = new InputStreamReader(VbT135wN.openStream());
						BufferedReader SKTsHGCf = new BufferedReader(hjm2O7oa);
						String rrgtJXOP;
						while ((rrgtJXOP = SKTsHGCf.readLine()) != null)
							Xz9inJqu.append(rrgtJXOP + "\n");
					} catch (IOException VrdlOLxq) {
						logger.log(Level.SEVERE, VrdlOLxq.getLocalizedMessage(), VrdlOLxq);
					}
					Xz9inJqu.append("</head><body><div class=\"content\">\n");
					Xz9inJqu.append(stripHtml(FGmazLnJ, false) + "<br>\n");
					Xz9inJqu.append("</div>\n</body>\n</html>\n</html>");
					Html JnIyApw0 = new Html();
					JnIyApw0.setContent(Xz9inJqu.toString());
					wKSnh8SX.appendChild(JnIyApw0);
					XXbGim7o = false;
				}
				int u8Rp6gVH = iP22yEw1.getInt("AD_Window_ID");
				if (u8Rp6gVH > 0) {
					int JOMVZ0MJ = iP22yEw1.getInt("AD_Menu_ID");
					ToolBarButton GudfurDb = new ToolBarButton(String.valueOf(JOMVZ0MJ));
					MMenu NqRr2MmL = new MMenu(EnvWeb.getCtx(), JOMVZ0MJ, null);
					GudfurDb.setLabel(NqRr2MmL.getName());
					GudfurDb.addEventListener(Events.ON_CLICK, this);
					wKSnh8SX.appendChild(GudfurDb);
					XXbGim7o = false;
				}
				int uPnZ6KrR = iP22yEw1.getInt("PA_Goal_ID");
				if (uPnZ6KrR > 0) {
					StringBuffer CjPLeS0X = new StringBuffer("<html><head>");
					URL G8DAZZNJ = getClass().getClassLoader().getResource("org/compiere/images/PAPanel.css");
					InputStreamReader kGKZfeZ9;
					try {
						kGKZfeZ9 = new InputStreamReader(G8DAZZNJ.openStream());
						BufferedReader k3NfJbfv = new BufferedReader(kGKZfeZ9);
						String hfBT0BSo;
						while ((hfBT0BSo = k3NfJbfv.readLine()) != null)
							CjPLeS0X.append(hfBT0BSo + "\n");
					} catch (IOException s4RlYs9I) {
						logger.log(Level.SEVERE, s4RlYs9I.getLocalizedMessage(), s4RlYs9I);
					}
					CjPLeS0X.append("</head><body><div class=\"content\">\n");
					CjPLeS0X.append(renderGoals(uPnZ6KrR, wKSnh8SX));
					CjPLeS0X.append("</div>\n</body>\n</html>\n</html>");
					Html aBhFiD10 = new Html();
					aBhFiD10.setContent(CjPLeS0X.toString());
					wKSnh8SX.appendChild(aBhFiD10);
					XXbGim7o = false;
				}
				String KgJFgaYl = iP22yEw1.getString("ZulFilePath");
				if (KgJFgaYl != null) {
					try {
						Component zku7Bqsz = Executions.createComponents(KgJFgaYl, wKSnh8SX, null);
						if (zku7Bqsz != null) {
							if (zku7Bqsz instanceof DashboardPanel) {
								DashboardPanel Mywfy9E3 = (DashboardPanel) zku7Bqsz;
								if (!Mywfy9E3.getChildren().isEmpty()) {
									wKSnh8SX.appendChild(Mywfy9E3);
									dashboardRunnable.add(Mywfy9E3);
									XXbGim7o = false;
								}
							} else {
								wKSnh8SX.appendChild(zku7Bqsz);
								XXbGim7o = false;
							}
						}
					} catch (Exception y3A34TYj) {
						logger.log(Level.WARNING, "Failed to create components. zul=" + KgJFgaYl, y3A34TYj);
					}
				}
				if (XXbGim7o)
					xiSQ6F8m.detach();
			}
		} catch (Exception befENOYP) {
			logger.log(Level.WARNING, "Failed to create dashboard content", befENOYP);
		} finally {
			Util.closeCursor(gKDTzEwQ, iP22yEw1);
		}
		registerWindow(cgABIGms);
		if (!gU1l8RVM.getDesktop().isServerPushEnabled())
			gU1l8RVM.getDesktop().enableServerPush(true);
		dashboardRunnable.refreshDashboard();
		dashboardThread = new Thread(dashboardRunnable, "UpdateInfo");
		dashboardThread.setDaemon(true);
		dashboardThread.start();
	}

}