class n22821632 {
	@Override
	public void start() throws Exception {
		initMetaData();
		Map<String, Set<ONDEXConcept>> peOyRAhs = new HashMap<String, Set<ONDEXConcept>>();
		for (ONDEXConcept N3XEVwlJ : graph.getConcepts()) {
			for (ConceptAccession gWDEQuqd : N3XEVwlJ.getConceptAccessions()) {
				if (gWDEQuqd.getElementOf().equals(dsCHEMBL) && !peOyRAhs.containsKey(gWDEQuqd.getAccession()))
					peOyRAhs.put(gWDEQuqd.getAccession(), new HashSet<ONDEXConcept>());
				peOyRAhs.get(gWDEQuqd.getAccession()).add(N3XEVwlJ);
			}
		}
		System.out.println(peOyRAhs);
		int cjwCq0lc = 0;
		for (String LW1EsmQy : peOyRAhs.keySet()) {
			URL Jjx0qrbg = new URL("https://www.ebi.ac.uk/chemblws/compounds/" + LW1EsmQy + "/bioactivities");
			HttpURLConnection S5LzfE9m = (HttpURLConnection) Jjx0qrbg.openConnection();
			int Qy9p9hRr = S5LzfE9m.getResponseCode();
			if (Qy9p9hRr != 200) {
				String BfNHa4l3 = S5LzfE9m.getResponseMessage();
				fireEventOccurred(
						new ParsingErrorEvent("HTTP/1.x " + Qy9p9hRr + " " + BfNHa4l3, getCurrentMethodName()));
			} else {
				InputStream VjPNnGOx = new BufferedInputStream(S5LzfE9m.getInputStream());
				DocumentBuilderFactory EgMEkfjH = DocumentBuilderFactory.newInstance();
				DocumentBuilder vtUPSRDp = EgMEkfjH.newDocumentBuilder();
				Document MMCFqOhw = vtUPSRDp.parse(VjPNnGOx);
				MMCFqOhw.getDocumentElement().normalize();
				NodeList pn1kIniR = MMCFqOhw.getElementsByTagName("bioactivity");
				for (int MgD9la0x = 0; MgD9la0x < pn1kIniR.getLength(); MgD9la0x++) {
					Node MuKJX9AH = pn1kIniR.item(MgD9la0x);
					if (MuKJX9AH.getNodeType() == Node.ELEMENT_NODE) {
						Element XuHudv0m = (Element) MuKJX9AH;
						ONDEXConcept u8def3z9 = graph.getFactory().createConcept(
								getTagValue("assay__chemblid", XuHudv0m), getTagValue("assay__description", XuHudv0m),
								dsCHEMBL, ccActivity, evidencetype);
						u8def3z9.createConceptAccession(getTagValue("assay__chemblid", XuHudv0m), dsASSAY, false);
						u8def3z9.createAttribute(anRef, getTagValue("reference", XuHudv0m), true);
						u8def3z9.createAttribute(anOrg, getTagValue("organism", XuHudv0m), true);
						String EuWF2u2b = getTagValue("bioactivity__type", XuHudv0m);
						EuWF2u2b = EuWF2u2b.replace(" ", "_");
						if (!anTypes.containsKey(EuWF2u2b)) {
							AttributeName ietchpUy = graph.getMetaData().getFactory().createAttributeName(EuWF2u2b,
									Double.class);
							String vG9JoxoI = getTagValue("units", XuHudv0m);
							if (graph.getMetaData().getUnit(vG9JoxoI) == null)
								graph.getMetaData().getFactory().createUnit(vG9JoxoI);
							ietchpUy.setUnit(graph.getMetaData().getUnit(vG9JoxoI));
							anTypes.put(EuWF2u2b, ietchpUy);
						}
						String rOtfY7se = getTagValue("value", XuHudv0m);
						try {
							Double nnbx3tTR = Double.valueOf(rOtfY7se);
							u8def3z9.createAttribute(anTypes.get(EuWF2u2b), nnbx3tTR, false);
						} catch (NumberFormatException y4FL9j7a) {
						}
						String OWXO6Dom = getTagValue("activity__comment", XuHudv0m);
						if (OWXO6Dom != null && OWXO6Dom.trim().length() > 0) {
							if (mapping.containsKey(OWXO6Dom))
								OWXO6Dom = mapping.get(OWXO6Dom);
							u8def3z9.createAttribute(anComment, OWXO6Dom, true);
						}
						cjwCq0lc++;
						Set<ONDEXConcept> vhztMStm = peOyRAhs.get(LW1EsmQy);
						for (ONDEXConcept CuPmo7RB : vhztMStm) {
							graph.getFactory().createRelation(CuPmo7RB, u8def3z9, rtActivity, evidencetype);
						}
						String KtLa0mgf = getTagValue("target__chemblid", XuHudv0m);
						if (!targets.containsKey(KtLa0mgf)) {
							ONDEXConcept uBbsg16E = graph.getFactory().createConcept(KtLa0mgf, dsCHEMBL, ccTarget,
									evidencetype);
							uBbsg16E.createConceptName(getTagValue("target__name", XuHudv0m), true);
							uBbsg16E.createConceptAccession(KtLa0mgf, dsTARGET, false);
							targets.put(KtLa0mgf, uBbsg16E);
						}
						ONDEXConcept c57PZ75i = targets.get(KtLa0mgf);
						ONDEXRelation O96qA9CO = graph.getFactory().createRelation(u8def3z9, c57PZ75i, rtOccin,
								evidencetype);
						O96qA9CO.createAttribute(anConf, Double.valueOf(getTagValue("target__confidence", XuHudv0m)),
								false);
					}
				}
			}
		}
		fireEventOccurred(new GeneralOutputEvent("Total assays parsed:" + cjwCq0lc, getCurrentMethodName()));
	}

}