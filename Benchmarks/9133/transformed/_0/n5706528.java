class n5706528 {
	public void run() {
		try {
			URL HrMNs2OC = new URL(myListURL);
			BufferedReader XA8AZKsk = new BufferedReader(new InputStreamReader(HrMNs2OC.openStream()));
			String G1xT4LUw = null;
			Pattern PO7JavYi = Pattern.compile(".*DIR.*<a href=.(.*)/.>(.*)</a>.*");
			Pattern WoDt07Tg = Pattern.compile(".*<li><a href=./(.*)#breadcrumbs. class=.folder.>(.*)</a></li>.*");
			Pattern oOcoeObI = Pattern.compile(
					".*<a href=.(.*).bz2. class=.default.>(.*).osm(.*).bz2</a>&nbsp;<span class=\"file-size\">(.*)</span>.*");
			while ((G1xT4LUw = XA8AZKsk.readLine()) != null) {
				Matcher e4jj8s4d = PO7JavYi.matcher(G1xT4LUw);
				if (e4jj8s4d.matches()) {
					String AGxyRRBh = myListURL + e4jj8s4d.group(1) + "/";
					String EivgVAE8 = e4jj8s4d.group(2);
					if (EivgVAE8.equalsIgnoreCase("Parent Directory")) {
						continue;
					}
					DownloadMenu.this
							.add(new DownloadMenu(DownloadMenu.this.myMainFrame, AGxyRRBh, EivgVAE8, myLoadChildren));
					continue;
				}
				e4jj8s4d = WoDt07Tg.matcher(G1xT4LUw);
				if (e4jj8s4d.matches()) {
					String gEVxJgHf = myListURL.substring(0, myListURL.indexOf(".com/") + ".com/".length())
							+ e4jj8s4d.group(1);
					String mhUWHKOW = e4jj8s4d.group(2);
					DownloadMenu.this
							.add(new DownloadMenu(DownloadMenu.this.myMainFrame, gEVxJgHf, mhUWHKOW, myLoadChildren));
					continue;
				}
				e4jj8s4d = oOcoeObI.matcher(G1xT4LUw);
				if (e4jj8s4d.matches()) {
					String RWrspx7b = myListURL.substring(0, myListURL.indexOf(".com") + ".com".length())
							+ e4jj8s4d.group(1) + ".bz2";
					final int GkynNTFk = 3;
					final int DViiLN5p = 2;
					String PAE0W6Xz = e4jj8s4d.group(GkynNTFk);
					String H3yg6pBl = e4jj8s4d.group(DViiLN5p);
					if (PAE0W6Xz.length() > 0) {
						if (PAE0W6Xz.startsWith(".")) {
							PAE0W6Xz = PAE0W6Xz.substring(1);
						}
						H3yg6pBl += "-" + PAE0W6Xz;
					}
					JMenuItem yyNM5Rb7 = new JMenuItem(H3yg6pBl);
					yyNM5Rb7.addActionListener(new DownloadActionListener(RWrspx7b, H3yg6pBl));
					yyNM5Rb7.putClientProperty("URL", RWrspx7b);
					add(yyNM5Rb7);
					continue;
				}
				int f2rSxizj = G1xT4LUw.indexOf("<a href=\"");
				if (f2rSxizj < 0) {
					continue;
				}
				f2rSxizj += "<a href=\"".length();
				int MZsdgVBG = G1xT4LUw.indexOf("</a");
				if (MZsdgVBG < 0) {
					continue;
				}
				int vG9veD99 = G1xT4LUw.indexOf(".osm.bz2\">");
				if (vG9veD99 < 0) {
					continue;
				}
				vG9veD99 += ".osm.bz2".length();
				String INeSr3pg = G1xT4LUw.substring(f2rSxizj, vG9veD99);
				if (!INeSr3pg.contains(".osm"))
					continue;
				if (!INeSr3pg.startsWith("http"))
					INeSr3pg = myListURL + INeSr3pg;
				vG9veD99 += "\">".length();
				String uozjheua = G1xT4LUw.substring(vG9veD99, MZsdgVBG);
				JMenuItem D1pWHWDZ = new JMenuItem(uozjheua);
				D1pWHWDZ.addActionListener(new DownloadActionListener(INeSr3pg, uozjheua));
				D1pWHWDZ.putClientProperty("URL", INeSr3pg);
				add(D1pWHWDZ);
			}
		} catch (Exception ITr6kkDs) {
			LOG.log(Level.SEVERE, "[Exception] Problem in " + getClass().getName(), ITr6kkDs);
		}
		LOG.info("Done with async download of list of downloadable maps for " + getText() + "...");
		remove(isLoadingMenuItem);
		if (myTreeNode != null) {
			myTreeNode.doneLoading();
		}
	}

}