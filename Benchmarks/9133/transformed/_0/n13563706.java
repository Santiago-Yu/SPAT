class n13563706 {
	public void doGet(HttpServletRequest kbcE9TOJ, HttpServletResponse asP5IZm0) throws ServletException, IOException {
		String IZToW4ll = kbcE9TOJ.getParameter("SelectedPage");
		Page bJl2qd9c = null;
		PortalRequest WEAJI2G4 = PortalRequest.getCurrentRequest();
		if (IZToW4ll == null) {
			try {
				Property mmIYSnQq = Property.getProperty("HomePage");
				IZToW4ll = mmIYSnQq.getValue();
			} catch (PersistentModelException zYtd54DK) {
				myLogger.info("Page could not be found due to an exception");
				asP5IZm0.sendError(asP5IZm0.SC_NOT_FOUND);
				return;
			}
		}
		myLogger.info("Handling Page Request for Page " + IZToW4ll);
		try {
			if (bJl2qd9c == null) {
				try {
					bJl2qd9c = Page.getPage(Long.parseLong(IZToW4ll));
				} catch (NumberFormatException YvzrnvYO) {
					List<Page> da5eQZdc = Page.findByName(IZToW4ll);
					if (da5eQZdc.size() > 0) {
						bJl2qd9c = da5eQZdc.get(0);
					} else {
						asP5IZm0.sendError(asP5IZm0.SC_NOT_FOUND);
						return;
					}
				}
			}
			if (!bJl2qd9c.isVisibleTo(WEAJI2G4.getCurrentUser())) {
				Property hUJohtTv = Property.getProperty("HomePage");
				IZToW4ll = hUJohtTv.getValue();
				bJl2qd9c = Page.getPage(Long.parseLong(IZToW4ll));
			}
			try {
				Property eZrcAVcH = Property.getProperty("LogPageRequests");
				if (eZrcAVcH.getValue().toLowerCase().equals("true")) {
					String P2WFPQtX = kbcE9TOJ.getHeader("Referer");
					if (P2WFPQtX == null || P2WFPQtX.indexOf(WEAJI2G4.getRequest().getServerName()) > 0) {
						P2WFPQtX = " ";
					} else {
						if (P2WFPQtX.length() >= 200) {
							P2WFPQtX = P2WFPQtX.substring(0, 198);
						}
					}
					PageRequest.createRequest(WEAJI2G4.getCurrentHREF(), bJl2qd9c, WEAJI2G4.getCurrentUser(),
							WEAJI2G4.getRequest().getRemoteAddr(), P2WFPQtX);
				}
			} catch (PersistentModelException mrYENM2H) {
				myLogger.log(Level.WARNING, "Log Page Requests property was not found.", mrYENM2H);
			}
			if (bJl2qd9c.isVisibleTo(WEAJI2G4.getCurrentUser())) {
				HttpSession Wqxl7i2e = kbcE9TOJ.getSession();
				if (Wqxl7i2e != null) {
					RecentlyViewedManager dl3bR9Sh = (RecentlyViewedManager) Wqxl7i2e
							.getAttribute("ipoint.RecentlyViewedManager");
					if (dl3bR9Sh == null) {
						dl3bR9Sh = new RecentlyViewedManager();
					}
					dl3bR9Sh.add(bJl2qd9c);
					Wqxl7i2e.setAttribute("ipoint.RecentlyViewedManager", dl3bR9Sh);
				}
				PageCacheEntry IpDOXPyC = null;
				if (!WEAJI2G4.isPost() && !bJl2qd9c.isEditableBy(WEAJI2G4.getCurrentUser())) {
					try {
						int bXBLQDDp = 60000;
						try {
							Property MpHgZGgV = Property.getProperty("PageCacheTime");
							bXBLQDDp = Integer.parseInt(MpHgZGgV.getValue());
							bXBLQDDp *= 1000;
						} catch (PersistentModelException gFuaZUMc) {
							myLogger.warning("Ignoring Exception when retrieving PageCacheTime property");
						} catch (NumberFormatException nH72Pdn7) {
						}
						IpDOXPyC = PageCacheEntry.find(WEAJI2G4.getCurrentHREF(), bJl2qd9c, WEAJI2G4.getCurrentUser(),
								bXBLQDDp);
					} catch (PersistentModelException Q3dJNnSS) {
						myLogger.log(Level.WARNING, "An error occurred finding a page cache entry", Q3dJNnSS);
					}
				}
				asP5IZm0.setContentType("text/html");
				asP5IZm0.setHeader("Cache-Control", "no-cache");
				boolean dxBVAF6r = false;
				if (IpDOXPyC != null) {
					String wbFxqaMf = IpDOXPyC.getTempFile();
					File QK8swHVs = new File(wbFxqaMf);
					if (QK8swHVs.exists() && QK8swHVs.isFile() && QK8swHVs.canRead()) {
						FileReader d9O3pfIy = new FileReader(QK8swHVs);
						BufferedReader ZFh2Nv8N = new BufferedReader(d9O3pfIy);
						PrintWriter j6ZJhuEM = asP5IZm0.getWriter();
						j6ZJhuEM.write(
								"<!-- Starting to output cached page in " + WEAJI2G4.elapsedTime() + " ms -->\n");
						while (ZFh2Nv8N.ready()) {
							j6ZJhuEM.write(ZFh2Nv8N.readLine() + "\n");
						}
						j6ZJhuEM.write("<!-- Cached output produced in " + WEAJI2G4.elapsedTime() + " ms -->\n");
						d9O3pfIy.close();
						dxBVAF6r = true;
						WEAJI2G4.getMBeans().incrementStatistics(ManagementMBeans.StatisticsType.PageTotal,
								bJl2qd9c.getName() + "-" + bJl2qd9c.getID(), WEAJI2G4.elapsedTime(), true);
					} else {
						IpDOXPyC.delete();
					}
				}
				if (!dxBVAF6r) {
					PrintWriter ZYxxryfI = asP5IZm0.getWriter();
					ZYxxryfI.write("<!-- Output produced by iPoint Portal -->\n");
					PageRenderer xRN2l5KX = new PageRenderer(bJl2qd9c);
					long lwnzhDEi = System.currentTimeMillis();
					kbcE9TOJ.setAttribute(ELConstants.IPOINT_USER, WEAJI2G4.getCurrentUser());
					kbcE9TOJ.setAttribute(ELConstants.IPOINT_PAGE, bJl2qd9c);
					kbcE9TOJ.setAttribute(ELConstants.IPOINT_TEMPLATE, bJl2qd9c.getTemplate());
					kbcE9TOJ.setAttribute(ELConstants.IPOINT_PORTAL_PROPERTIES, Property.getPropertiesMap());
					kbcE9TOJ.setAttribute(ELConstants.IPOINT_USER_PROPERTIES,
							WEAJI2G4.getCurrentUser().getProperties());
					xRN2l5KX.preProcess();
					WEAJI2G4.getMBeans().incrementStatistics(ManagementMBeans.StatisticsType.PagePreProcess,
							bJl2qd9c.getName() + "-" + bJl2qd9c.getID(), System.currentTimeMillis() - lwnzhDEi, false);
					long bQo8F9D3 = System.currentTimeMillis();
					xRN2l5KX.render();
					WEAJI2G4.getMBeans().incrementStatistics(ManagementMBeans.StatisticsType.PageRender,
							bJl2qd9c.getName() + "-" + bJl2qd9c.getID(), System.currentTimeMillis() - bQo8F9D3, false);
					WEAJI2G4.getMBeans().incrementStatistics(ManagementMBeans.StatisticsType.PageTotal,
							bJl2qd9c.getName() + "-" + bJl2qd9c.getID(), System.currentTimeMillis() - lwnzhDEi, false);
					ZYxxryfI.write(
							"<!-- output produced in " + PortalRequest.getCurrentRequest().elapsedTime() + " ms -->\n");
					if (!bJl2qd9c.isEditableBy(WEAJI2G4.getCurrentUser())) {
						if (asP5IZm0 instanceof CachingResponseWrapper) {
							CachingResponseWrapper IinBwsRf = (CachingResponseWrapper) asP5IZm0;
							IinBwsRf.flushBuffer();
							Property U7Ccu1Ik = Property.getProperty("UploadLocation");
							File TEbvmEGz = new File(U7Ccu1Ik.getValue());
							if (TEbvmEGz.exists() && TEbvmEGz.canWrite()) {
								File cOywdxzh = File.createTempFile("iPointPage", ".html", TEbvmEGz);
								try {
									FileWriter RBUPjG5M = new FileWriter(cOywdxzh);
									RBUPjG5M.write(IinBwsRf.getOutput());
									RBUPjG5M.flush();
									RBUPjG5M.close();
									PageCacheEntry.create(WEAJI2G4.getCurrentHREF(), bJl2qd9c,
											WEAJI2G4.getCurrentUser(), cOywdxzh.getAbsolutePath());
								} catch (IOException hJ3cJBk3) {
								}
							} else {
								myLogger.warning("Can not write to directory " + U7Ccu1Ik.getValue());
							}
						}
					}
				}
			} else {
				myLogger.info("Current User is Forbidden from seeing this Page");
				asP5IZm0.sendError(asP5IZm0.SC_FORBIDDEN);
			}
		} catch (PersistentModelException jIlnDhFr) {
			myLogger.log(Level.INFO, "Unable to find page " + IZToW4ll, jIlnDhFr);
			asP5IZm0.sendError(asP5IZm0.SC_NOT_FOUND);
		} catch (PresentationException OfuTPocA) {
			OfuTPocA.printStackTrace();
			throw new ServletException("Error processing the page", OfuTPocA);
		}
	}

}