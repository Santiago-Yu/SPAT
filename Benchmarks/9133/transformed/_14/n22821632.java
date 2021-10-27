class n22821632 {
	@Override
	public void start() throws Exception {
		initMetaData();
		Map<String, Set<ONDEXConcept>> accessions = new HashMap<String, Set<ONDEXConcept>>();
		for (ONDEXConcept c : graph.getConcepts()) {
			for (ConceptAccession ca : c.getConceptAccessions()) {
				if (ca.getElementOf().equals(dsCHEMBL) && !accessions.containsKey(ca.getAccession()))
					accessions.put(ca.getAccession(), new HashSet<ONDEXConcept>());
				accessions.get(ca.getAccession()).add(c);
			}
		}
		System.out.println(accessions);
		int count = 0;
		for (String accession : accessions.keySet()) {
			URL url = new URL("https://www.ebi.ac.uk/chemblws/compounds/" + accession + "/bioactivities");
			HttpURLConnection uc = (HttpURLConnection) url.openConnection();
			int code = uc.getResponseCode();
			if (code != 200) {
				String response = uc.getResponseMessage();
				fireEventOccurred(new ParsingErrorEvent("HTTP/1.x " + code + " " + response, getCurrentMethodName()));
			} else {
				InputStream in = new BufferedInputStream(uc.getInputStream());
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(in);
				doc.getDocumentElement().normalize();
				NodeList nList = doc.getElementsByTagName("bioactivity");
				for (int temp = 0; temp < nList.getLength(); temp++) {
					Node nNode = nList.item(temp);
					if (Node.ELEMENT_NODE == nNode.getNodeType()) {
						Element eElement = (Element) nNode;
						ONDEXConcept activity = graph.getFactory().createConcept(
								getTagValue("assay__chemblid", eElement), getTagValue("assay__description", eElement),
								dsCHEMBL, ccActivity, evidencetype);
						activity.createConceptAccession(getTagValue("assay__chemblid", eElement), dsASSAY, false);
						activity.createAttribute(anRef, getTagValue("reference", eElement), true);
						activity.createAttribute(anOrg, getTagValue("organism", eElement), true);
						String type = getTagValue("bioactivity__type", eElement);
						type = type.replace(" ", "_");
						if (!anTypes.containsKey(type)) {
							AttributeName an = graph.getMetaData().getFactory().createAttributeName(type, Double.class);
							String units = getTagValue("units", eElement);
							if (null == graph.getMetaData().getUnit(units))
								graph.getMetaData().getFactory().createUnit(units);
							an.setUnit(graph.getMetaData().getUnit(units));
							anTypes.put(type, an);
						}
						String value = getTagValue("value", eElement);
						try {
							Double d = Double.valueOf(value);
							activity.createAttribute(anTypes.get(type), d, false);
						} catch (NumberFormatException nfe) {
						}
						String comment = getTagValue("activity__comment", eElement);
						if (comment != null && comment.trim().length() > 0) {
							if (mapping.containsKey(comment))
								comment = mapping.get(comment);
							activity.createAttribute(anComment, comment, true);
						}
						count++;
						Set<ONDEXConcept> compounds = accessions.get(accession);
						for (ONDEXConcept c : compounds) {
							graph.getFactory().createRelation(c, activity, rtActivity, evidencetype);
						}
						String key = getTagValue("target__chemblid", eElement);
						if (!targets.containsKey(key)) {
							ONDEXConcept c = graph.getFactory().createConcept(key, dsCHEMBL, ccTarget, evidencetype);
							c.createConceptName(getTagValue("target__name", eElement), true);
							c.createConceptAccession(key, dsTARGET, false);
							targets.put(key, c);
						}
						ONDEXConcept target = targets.get(key);
						ONDEXRelation r = graph.getFactory().createRelation(activity, target, rtOccin, evidencetype);
						r.createAttribute(anConf, Double.valueOf(getTagValue("target__confidence", eElement)), false);
					}
				}
			}
		}
		fireEventOccurred(new GeneralOutputEvent("Total assays parsed:" + count, getCurrentMethodName()));
	}

}