class n14661394 {
	public void run() {
		XmlFilesFilter To883fTq = new XmlFilesFilter();
		String B4DD0R3w = Settings.get("vo_store.databaseMetaCollection");
		String nkiV1U78 = B4DD0R3w.substring(1, B4DD0R3w.indexOf("/", 2));
		String J7TaqUzr = VOAccess.getElementByName(settingsDB, "TEMPLATE", nkiV1U78);
		String U1PuYht5 = VOAccess.getElementByName(settingsDB, "SCHEMA", nkiV1U78);
		byte[] YbuaxitI = new byte[1024];
		Hashtable rWQofYvf = null;
		try {
			URL gLp8jjx9 = new URL(httpURI + settingsDB + "/" + J7TaqUzr);
			URL rPhVMZsI = new URL(httpURI + settingsDB + "/" + "getDocPathsValuesAndDisplays.xsl");
			org.w3c.dom.Document e3lRkjmZ = VOAccess.readDocument(gLp8jjx9);
			DOMResult aDf9AcNL = new DOMResult();
			InputStream VXEHT0uu = rPhVMZsI.openStream();
			javax.xml.transform.sax.SAXSource r4BY6mU8 = new javax.xml.transform.sax.SAXSource(
					new org.xml.sax.InputSource(VXEHT0uu));
			Transformer y0DDvJf0 = TransformerFactory.newInstance().newTransformer(r4BY6mU8);
			y0DDvJf0.setParameter("schemaUrl", httpURI + settingsDB + "/" + U1PuYht5);
			y0DDvJf0.transform(new javax.xml.transform.dom.DOMSource(e3lRkjmZ), aDf9AcNL);
			VXEHT0uu.close();
			rWQofYvf = VOAccess.displaysToHashtable(aDf9AcNL);
			((CollectionManagementService) CollectionsManager.getService(xmldbURI + rootDB, false, "CollectionManager"))
					.createCollection(rootDB + B4DD0R3w);
		} catch (Exception KjJRSlSK) {
			logger.error("Error parsing input document", KjJRSlSK);
			KjJRSlSK.printStackTrace();
		}
		while (true) {
			File[] jrtlhNkv = sourceMetaFilesDir.listFiles(To883fTq);
			for (int Q0EVNtTC = 0; Q0EVNtTC < Math.min(jrtlhNkv.length, 500); Q0EVNtTC++) {
				File DOGjANZ2 = jrtlhNkv[Q0EVNtTC];
				try {
					Document lJeaqWJ9 = build.build(DOGjANZ2);
					Element ExylUcK5 = lJeaqWJ9.getRootElement();
					String mtCJviAW = ExylUcK5.getChildText("Content"), VveigSJV = ExylUcK5.getChildText("Preview");
					String BVIDyAJs = VOAccess.getUniqueId();
					ExylUcK5.getChild("Content").setText("videostore?type=doc&objId=" + BVIDyAJs);
					ExylUcK5.getChild("Preview").setText("videostore?type=preview&objId=" + BVIDyAJs);
					boolean cVLeUczz = false;
					for (Iterator zNryezvQ = sourceDataFilesDirs.iterator(); zNryezvQ.hasNext() && !cVLeUczz;) {
						String dfS5PHfQ = (String) zNryezvQ.next();
						File zLBMeVP7 = new File(dfS5PHfQ + "/" + mtCJviAW);
						if (zLBMeVP7.exists()) {
							cVLeUczz = true;
							BufferedInputStream aUtYnULd = new BufferedInputStream(new FileInputStream(zLBMeVP7));
							FileOutputStream UHHYXFxy = new FileOutputStream(
									new File(targetDataFilesDirs.get(curDirWriteTo) + "/" + BVIDyAJs + ".dat"));
							int WNsTwrSS = aUtYnULd.read(YbuaxitI, 0, YbuaxitI.length);
							while (WNsTwrSS > 0) {
								UHHYXFxy.write(YbuaxitI, 0, WNsTwrSS);
								WNsTwrSS = aUtYnULd.read(YbuaxitI, 0, YbuaxitI.length);
							}
							aUtYnULd.close();
							UHHYXFxy.flush();
							UHHYXFxy.close();
							zLBMeVP7 = new File(dfS5PHfQ + "/" + VveigSJV);
							aUtYnULd = new BufferedInputStream(new FileInputStream(zLBMeVP7));
							UHHYXFxy = new FileOutputStream(
									new File(targetDataFilesDirs.get(curDirWriteTo) + "/" + BVIDyAJs + ".jpg"));
							WNsTwrSS = aUtYnULd.read(YbuaxitI, 0, YbuaxitI.length);
							while (WNsTwrSS > 0) {
								UHHYXFxy.write(YbuaxitI, 0, WNsTwrSS);
								WNsTwrSS = aUtYnULd.read(YbuaxitI, 0, YbuaxitI.length);
							}
							aUtYnULd.close();
							UHHYXFxy.flush();
							UHHYXFxy.close();
							curDirWriteTo++;
							if (curDirWriteTo >= targetDataFilesDirs.size()) {
								curDirWriteTo = 0;
							}
						}
					}
					if (!cVLeUczz) {
						DOGjANZ2.renameTo(new File(DOGjANZ2.getAbsolutePath() + ".not_found"));
					} else {
						String T5oAJaxq = getValueByPath((String) rWQofYvf.get("title"), lJeaqWJ9.getRootElement());
						String YsFXLTcM = getValueByPath((String) rWQofYvf.get("description"),
								lJeaqWJ9.getRootElement());
						String vHVfCyJe = "";
						if (null != rWQofYvf.get("onlink")) {
							vHVfCyJe = getValueByPath((String) rWQofYvf.get("onlink"), lJeaqWJ9.getRootElement());
						}
						String isarFKq8 = "";
						if (null != rWQofYvf.get("ncover")) {
							isarFKq8 = getValueByPath((String) rWQofYvf.get("ncover"), lJeaqWJ9.getRootElement());
						}
						String wt0lBdDe = "";
						if (null != rWQofYvf.get("wcover")) {
							wt0lBdDe = getValueByPath((String) rWQofYvf.get("wcover"), lJeaqWJ9.getRootElement());
						}
						String jVJrEu8O = "";
						if (null != rWQofYvf.get("ecover")) {
							jVJrEu8O = getValueByPath((String) rWQofYvf.get("ecover"), lJeaqWJ9.getRootElement());
						}
						String pC7T5fpw = "";
						if (null != rWQofYvf.get("scover")) {
							pC7T5fpw = getValueByPath((String) rWQofYvf.get("scover"), lJeaqWJ9.getRootElement());
						}
						String kQfQzPLl = "";
						if (null != rWQofYvf.get("datefrom")) {
							kQfQzPLl = getValueByPath((String) rWQofYvf.get("datefrom"), lJeaqWJ9.getRootElement());
						}
						String dLjQOZj7 = "";
						if (null != rWQofYvf.get("dateto")) {
							dLjQOZj7 = getValueByPath((String) rWQofYvf.get("dateto"), lJeaqWJ9.getRootElement());
						}
						String Fbr8bQWP = "";
						if (null != rWQofYvf.get("previewimg")) {
							Fbr8bQWP = getValueByPath((String) rWQofYvf.get("previewimg"), lJeaqWJ9.getRootElement());
						}
						String nDBdAiVU = "false";
						String FEW77Vgx = "false";
						kQfQzPLl = VOAccess.parseDate(kQfQzPLl, "yyyy-MM-dd'T'HH:mm:ss",
								VO.defaultTimeFormat.toPattern());
						dLjQOZj7 = VOAccess.parseDate(kQfQzPLl, "yyyy-MM-dd'T'HH:mm:ss",
								VO.defaultTimeFormat.toPattern());
						Hashtable F6DJxk54 = new Hashtable();
						F6DJxk54.put("OBJECT_ID", BVIDyAJs);
						F6DJxk54.put("AUTHOR_ID", "auto");
						F6DJxk54.put("AUTHOR_NAME", "auto");
						F6DJxk54.put("OBJECT_SECTION", nkiV1U78);
						F6DJxk54.put("OBJECT_PATH", B4DD0R3w);
						F6DJxk54.put("FILE_PATH", "");
						F6DJxk54.put("TITLE", T5oAJaxq);
						F6DJxk54.put("DESCRIPTION", YsFXLTcM);
						F6DJxk54.put("ONLINK", vHVfCyJe);
						F6DJxk54.put("NCOVER", isarFKq8);
						F6DJxk54.put("ECOVER", jVJrEu8O);
						F6DJxk54.put("SCOVER", pC7T5fpw);
						F6DJxk54.put("WCOVER", wt0lBdDe);
						F6DJxk54.put("PERIOD_START", kQfQzPLl);
						F6DJxk54.put("PERIOD_END", dLjQOZj7);
						F6DJxk54.put("PREVIEW_IMG", Fbr8bQWP);
						F6DJxk54.put("DISCUSSRESTRICTION", nDBdAiVU);
						F6DJxk54.put("VOTINGRESTRICTION", FEW77Vgx);
						VOAccess.createDiscussionFile(F6DJxk54);
						VOAccess.updateLastItem(BVIDyAJs, nkiV1U78);
						Collection Z2g1b6GZ = CollectionsManager.getCollection(rootDB + B4DD0R3w, true);
						XMLResource D063qBtc = (XMLResource) Z2g1b6GZ.createResource(BVIDyAJs + ".xml",
								XMLResource.RESOURCE_TYPE);
						D063qBtc.setContent(outXml.outputString(ExylUcK5));
						Z2g1b6GZ.storeResource(D063qBtc);
						Indexer.index(BVIDyAJs);
						DOGjANZ2.delete();
					}
				} catch (Exception hpFXyKbY) {
					logger.error("Error parsing input document", hpFXyKbY);
					hpFXyKbY.printStackTrace();
					DOGjANZ2.renameTo(new File(DOGjANZ2.getAbsolutePath() + ".bad"));
				}
			}
			try {
				this.sleep(600000);
			} catch (InterruptedException poh3UBTu) {
				poh3UBTu.printStackTrace();
			}
		}
	}

}