class n6548989 {
	private void createHomeTab() {
		Tabpanel C2iZUeqc = new Tabpanel();
		windowContainer.addWindow(C2iZUeqc, Msg.getMsg(EnvWeb.getCtx(), "Home").replaceAll("&", ""), false);
		Portallayout RfRY7rxI = new Portallayout();
		RfRY7rxI.setWidth("100%");
		RfRY7rxI.setHeight("100%");
		RfRY7rxI.setStyle("position: absolute; overflow: auto");
		C2iZUeqc.appendChild(RfRY7rxI);
		Portalchildren Y4mVwhuT = null;
		int A7labCKW = 0;
		String ovpE1OUu = "SELECT COUNT(DISTINCT COLUMNNO) " + "FROM PA_DASHBOARDCONTENT "
				+ "WHERE (AD_CLIENT_ID=0 OR AD_CLIENT_ID=?) AND ISACTIVE='Y'";
		int RSfrBN08 = DB.getSQLValue(null, ovpE1OUu, EnvWeb.getCtx().getAD_Client_ID());
		int e3i2d2g4 = RSfrBN08 <= 0 ? 100 : 100 / RSfrBN08;
		ovpE1OUu = "SELECT x.*, m.AD_MENU_ID " + "FROM PA_DASHBOARDCONTENT x "
				+ "LEFT OUTER JOIN AD_MENU m ON x.AD_WINDOW_ID=m.AD_WINDOW_ID "
				+ "WHERE (x.AD_CLIENT_ID=0 OR x.AD_CLIENT_ID=?) AND x.ISACTIVE='Y' "
				+ "ORDER BY x.COLUMNNO, x.AD_CLIENT_ID, x.LINE ";
		PreparedStatement AZ8zV73j = null;
		ResultSet l9uwvIoV = null;
		try {
			AZ8zV73j = DB.prepareStatement(ovpE1OUu, null);
			AZ8zV73j.setInt(1, EnvWeb.getCtx().getAD_Client_ID());
			l9uwvIoV = AZ8zV73j.executeQuery();
			while (l9uwvIoV.next()) {
				int QZzXHRun = l9uwvIoV.getInt("ColumnNo");
				if (Y4mVwhuT == null || A7labCKW != QZzXHRun) {
					Y4mVwhuT = new Portalchildren();
					RfRY7rxI.appendChild(Y4mVwhuT);
					Y4mVwhuT.setWidth(e3i2d2g4 + "%");
					Y4mVwhuT.setStyle("padding: 5px");
					A7labCKW = QZzXHRun;
				}
				Panel sdpvXco6 = new Panel();
				sdpvXco6.setStyle("margin-bottom:10px");
				sdpvXco6.setTitle(l9uwvIoV.getString("Name"));
				String F1B96Zp3 = l9uwvIoV.getString("Description");
				if (F1B96Zp3 != null)
					sdpvXco6.setTooltiptext(F1B96Zp3);
				String UWx1zmm7 = l9uwvIoV.getString("IsCollapsible");
				sdpvXco6.setCollapsible(UWx1zmm7.equals("Y"));
				sdpvXco6.setBorder("normal");
				Y4mVwhuT.appendChild(sdpvXco6);
				Panelchildren IFyIjbDD = new Panelchildren();
				sdpvXco6.appendChild(IFyIjbDD);
				boolean I8Lb8M0v = true;
				String hgrbPwC5 = l9uwvIoV.getString("HTML");
				if (hgrbPwC5 != null) {
					StringBuffer jiEKkgi2 = new StringBuffer("<html><head>");
					URL HlRvt18W = getClass().getClassLoader().getResource("org/compiere/images/PAPanel.css");
					InputStreamReader EoeckV5A;
					try {
						EoeckV5A = new InputStreamReader(HlRvt18W.openStream());
						BufferedReader rwLhTn0V = new BufferedReader(EoeckV5A);
						String shMAGMty;
						while ((shMAGMty = rwLhTn0V.readLine()) != null)
							jiEKkgi2.append(shMAGMty + "\n");
					} catch (IOException eH74nEtR) {
						logger.log(Level.SEVERE, eH74nEtR.getLocalizedMessage(), eH74nEtR);
					}
					jiEKkgi2.append("</head><body><div class=\"content\">\n");
					jiEKkgi2.append(stripHtml(hgrbPwC5, false) + "<br>\n");
					jiEKkgi2.append("</div>\n</body>\n</html>\n</html>");
					Html DFc1nWp1 = new Html();
					DFc1nWp1.setContent(jiEKkgi2.toString());
					IFyIjbDD.appendChild(DFc1nWp1);
					I8Lb8M0v = false;
				}
				int RNBKZlzR = l9uwvIoV.getInt("AD_Window_ID");
				if (RNBKZlzR > 0) {
					int ETupHNai = l9uwvIoV.getInt("AD_Menu_ID");
					ToolBarButton FqzLBKWS = new ToolBarButton(String.valueOf(ETupHNai));
					MMenu cvoCzRvW = new MMenu(EnvWeb.getCtx(), ETupHNai, null);
					FqzLBKWS.setLabel(cvoCzRvW.getName());
					FqzLBKWS.addEventListener(Events.ON_CLICK, this);
					IFyIjbDD.appendChild(FqzLBKWS);
					I8Lb8M0v = false;
				}
				int zWhTcFeR = l9uwvIoV.getInt("PA_Goal_ID");
				if (zWhTcFeR > 0) {
					StringBuffer RLgVYl8Q = new StringBuffer("<html><head>");
					URL yX4pzfaC = getClass().getClassLoader().getResource("org/compiere/images/PAPanel.css");
					InputStreamReader W3o3XxUR;
					try {
						W3o3XxUR = new InputStreamReader(yX4pzfaC.openStream());
						BufferedReader vHG3LEhZ = new BufferedReader(W3o3XxUR);
						String C0XbxhQg;
						while ((C0XbxhQg = vHG3LEhZ.readLine()) != null)
							RLgVYl8Q.append(C0XbxhQg + "\n");
					} catch (IOException BidXuE6P) {
						logger.log(Level.SEVERE, BidXuE6P.getLocalizedMessage(), BidXuE6P);
					}
					RLgVYl8Q.append("</head><body><div class=\"content\">\n");
					RLgVYl8Q.append(renderGoals(zWhTcFeR, IFyIjbDD));
					RLgVYl8Q.append("</div>\n</body>\n</html>\n</html>");
					Html AWWmeDs7 = new Html();
					AWWmeDs7.setContent(RLgVYl8Q.toString());
					IFyIjbDD.appendChild(AWWmeDs7);
					I8Lb8M0v = false;
				}
				String zDt2bBy0 = l9uwvIoV.getString("ZulFilePath");
				if (zDt2bBy0 != null) {
					try {
						Component EXWJLjh7 = Executions.createComponents(zDt2bBy0, IFyIjbDD, null);
						if (EXWJLjh7 != null) {
							if (EXWJLjh7 instanceof DashboardPanel) {
								DashboardPanel gNqce1Mt = (DashboardPanel) EXWJLjh7;
								if (!gNqce1Mt.getChildren().isEmpty()) {
									IFyIjbDD.appendChild(gNqce1Mt);
									dashboardRunnable.add(gNqce1Mt);
									I8Lb8M0v = false;
								}
							} else {
								IFyIjbDD.appendChild(EXWJLjh7);
								I8Lb8M0v = false;
							}
						}
					} catch (Exception pgyMfO6Z) {
						logger.log(Level.WARNING, "Failed to create components. zul=" + zDt2bBy0, pgyMfO6Z);
					}
				}
				if (I8Lb8M0v)
					sdpvXco6.detach();
			}
		} catch (Exception qXJqC74U) {
			logger.log(Level.WARNING, "Failed to create dashboard content", qXJqC74U);
		} finally {
			Util.closeCursor(AZ8zV73j, l9uwvIoV);
		}
		registerWindow(C2iZUeqc);
		if (!RfRY7rxI.getDesktop().isServerPushEnabled())
			RfRY7rxI.getDesktop().enableServerPush(true);
		dashboardRunnable.refreshDashboard();
		dashboardThread = new Thread(dashboardRunnable, "UpdateInfo");
		dashboardThread.setDaemon(true);
		dashboardThread.start();
	}

}