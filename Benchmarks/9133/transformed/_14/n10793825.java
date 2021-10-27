class n10793825 {
	public String getRec(String attribute, String url) {
		String arr[] = new String[3];
		String[] subarr = new String[6];
		String mdPrefix = "";
		String mdPrefixValue = "";
		String iden = "";
		String idenValue = "";
		String s = "";
		String arguments = attribute.substring(attribute.indexOf("?") + 1);
		System.out.println("attributes" + arguments);
		java.util.StringTokenizer st = new java.util.StringTokenizer(arguments, "&");
		int i = 0;
		int j = 0;
		int count = 0;
		int argCount = 0;
		java.util.Vector v1 = new java.util.Vector(1, 1);
		java.util.Vector v901 = new java.util.Vector(1, 1);
		java.util.Vector v902 = new java.util.Vector(1, 1);
		java.util.Vector v903 = new java.util.Vector(1, 1);
		java.util.Vector v904 = new java.util.Vector(1, 1);
		java.util.Vector v905 = new java.util.Vector(1, 1);
		java.util.Vector v906 = new java.util.Vector(1, 1);
		java.util.Vector v907 = new java.util.Vector(1, 1);
		java.util.Vector v908 = new java.util.Vector(1, 1);
		java.util.Vector v3 = new java.util.Vector(1, 1);
		java.util.Vector vData = new java.util.Vector(1, 1);
		java.util.Vector vSet = new java.util.Vector(1, 1);
		java.util.Vector v856 = new java.util.Vector(1, 1);
		Resdate dt = new Resdate();
		try {
			while (st.hasMoreElements()) {
				arr[i] = st.nextElement().toString();
				java.util.StringTokenizer subSt = new java.util.StringTokenizer(arr[i], "=");
				while (subSt.hasMoreElements()) {
					subarr[j] = subSt.nextElement().toString();
					System.out.println(" arga are... " + subarr[j]);
					j++;
				}
				i++;
				count++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Namespace oains = Namespace.getNamespace("http://www.openarchives.org/OAI/2.0/");
		Element root = new Element("OAI-PMH", oains);
		Namespace xsi = Namespace.getNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance");
		Attribute schemaLocation = new Attribute("schemaLocation",
				"http://www.openarchives.org/OAI/2.0/ http://www.openarchives.org/OAI/2.0/OAI-PMH.xsd", xsi);
		root.setAttribute(schemaLocation);
		root.addNamespaceDeclaration(xsi);
		Document doc = new Document(root);
		Element responseDate = new Element("responseDate", oains);
		root.addContent(responseDate);
		responseDate.setText(dt.getDate());
		Element request = new Element("request", oains);
		request.setAttribute("verb", "GetRecord");
		int idenCount = 0, mdfCount = 0;
		for (int k = 2; k < j; k += 2) {
			System.out.println(" arg key " + subarr[k]);
			if (subarr[k].equals("metadataPrefix")) {
				mdPrefix = "metadataPrefix";
				mdfCount++;
				mdPrefixValue = subarr[k + 1];
				request.setAttribute(mdPrefix, mdPrefixValue);
				System.out.println(subarr[k] + "=");
				System.out.println(mdPrefixValue);
				argCount++;
			} else if (subarr[k].equals("identifier")) {
				iden = "identifier";
				idenCount++;
				idenValue = subarr[k + 1];
				request.setAttribute(iden, idenValue);
				System.out.println(subarr[k] + "=");
				System.out.println(idenValue);
				argCount++;
			}
		}
		request.setText(url);
		root.addContent(request);
		System.out.println("count" + argCount);
		if (1 == mdfCount && 1 == idenCount
				&& (mdPrefixValue.equals("marc21") || mdPrefixValue.equals("oai_dc") || mdPrefixValue.equals("mods"))) {
			try {
				v1 = ((ejb.bprocess.OAIPMH.ListGetRecordsHome) ejb.bprocess.util.HomeFactory.getInstance()
						.getRemoteHome("ListGetRecords")).create().getRecord(idenValue, mdPrefixValue);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			if (0 == v1.size()) {
				System.out.println("vector size is empty");
				Errors e1 = new Errors();
				Element errorXML = e1.describeError(3, attribute, url, "GetRecord");
				root.addContent(errorXML);
			} else {
				Element GetRecord = new Element("GetRecord", oains);
				root.addContent(GetRecord);
				Element Record = new Element("record", oains);
				Element metadata = new Element("metadata", oains);
				Element head = new Element("header", oains);
				System.out.println("size i  s " + v1.size());
				for (int v = 0; v < v1.size(); v = v + 13) {
					vSet = (java.util.Vector) v1.elementAt(v + 1);
					Element ident = new Element("identifier", oains);
					ident.setText(idenValue);
					head.addContent(ident);
					Element dates = new Element("datestamp", oains);
					dates.setText(v1.elementAt(v).toString().substring(0, 10));
					head.addContent(dates);
					for (int t = 0; t < vSet.size(); t++) {
						Element setSpec = new Element("setSpec", oains);
						System.out.println("set elem" + vSet.elementAt(t).toString());
						setSpec.setText(vSet.elementAt(t).toString());
						head.addContent(setSpec);
					}
					Element marcroot = new Element("record", "marc", "http://www.loc.gov/MARC21/slim");
					Namespace xsimarc = Namespace.getNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance");
					marcroot.addNamespaceDeclaration(xsimarc);
					Attribute schemaLocationmarc = new Attribute("schemaLocation",
							"http://www.loc.gov/MARC21/slim http://www.loc.gov/standards/marcxml/schema/MARC21slim.xsd",
							xsimarc);
					marcroot.setAttribute(schemaLocationmarc);
					marcroot.setAttribute("type", "Bibliographic");
					v3 = (java.util.Vector) v1.elementAt(v + 10);
					java.util.Vector vL = (java.util.Vector) v3.elementAt(0);
					org.jdom.Element lead = new org.jdom.Element("leader", "marc", "http://www.loc.gov/MARC21/slim");
					lead.setText(vL.elementAt(0).toString());
					marcroot.addContent(lead);
					java.util.Vector vC = (java.util.Vector) v3.elementAt(1);
					for (int u = 0; u < vC.size(); u = u + 2) {
						org.jdom.Element ct = new org.jdom.Element("controlfield", "marc",
								"http://www.loc.gov/MARC21/slim");
						ct.setAttribute("tag", vC.elementAt(u).toString());
						ct.setText(vC.elementAt(u + 1).toString());
						marcroot.addContent(ct);
					}
					v901 = (java.util.Vector) v1.elementAt(v + 2);
					for (int k = 0; k < v901.size(); k++) {
						org.jdom.Element datafield = new org.jdom.Element("datafield", "marc",
								"http://www.loc.gov/MARC21/slim");
						datafield.setAttribute("tag", "901");
						datafield.setAttribute("ind1", "0");
						datafield.setAttribute("ind2", "0");
						java.util.Vector vecSub = new java.util.Vector(1, 1);
						vecSub = (java.util.Vector) v901.elementAt(k);
						System.out.println("in getrec sub ");
						System.out.println("sub 901 size" + vecSub.size());
						for (int k1 = 0; k1 < vecSub.size(); k1 = k1 + 2) {
							org.jdom.Element subfield = new org.jdom.Element("subfield", "marc",
									"http://www.loc.gov/MARC21/slim");
							subfield.setAttribute("code", vecSub.elementAt(k1).toString());
							subfield.setText(vecSub.elementAt(k1 + 1).toString());
							datafield.addContent(subfield);
						}
						marcroot.addContent(datafield);
					}
					v902 = (java.util.Vector) v1.elementAt(v + 3);
					for (int l = 0; l < v902.size(); l++) {
						Element datafield1 = new Element("datafield", "marc", "http://www.loc.gov/MARC21/slim");
						datafield1.setAttribute("tag", "902");
						datafield1.setAttribute("ind1", "0");
						datafield1.setAttribute("ind2", "0");
						java.util.Vector vecSub1 = new java.util.Vector(1, 1);
						vecSub1 = (java.util.Vector) v902.elementAt(l);
						for (int b = 0; b < vecSub1.size(); b = b + 2) {
							Element subfield = new Element("subfield", "marc", "http://www.loc.gov/MARC21/slim");
							subfield.setAttribute("code", vecSub1.elementAt(b).toString());
							subfield.setText(vecSub1.elementAt(b + 1).toString());
							datafield1.addContent(subfield);
						}
						marcroot.addContent(datafield1);
					}
					v903 = (java.util.Vector) v1.elementAt(v + 4);
					Element datafield1 = new Element("datafield", "marc", "http://www.loc.gov/MARC21/slim");
					datafield1.setAttribute("tag", "903");
					datafield1.setAttribute("ind1", "0");
					datafield1.setAttribute("ind2", "0");
					for (int l = 0; l < v903.size(); l++) {
						Element subfield = new Element("subfield", "marc", "http://www.loc.gov/MARC21/slim");
						subfield.setAttribute("code", "a");
						subfield.setText(v903.elementAt(l).toString());
						datafield1.addContent(subfield);
					}
					marcroot.addContent(datafield1);
					v904 = (java.util.Vector) v1.elementAt(v + 5);
					Element datafield21 = new Element("datafield", "marc", "http://www.loc.gov/MARC21/slim");
					datafield21.setAttribute("tag", "904");
					datafield21.setAttribute("ind1", "0");
					datafield21.setAttribute("ind2", "0");
					for (int l = 0; l < v904.size(); l++) {
						Element subfield = new Element("subfield", "marc", "http://www.loc.gov/MARC21/slim");
						subfield.setAttribute("code", "a");
						subfield.setText(v904.elementAt(l).toString());
						datafield21.addContent(subfield);
					}
					marcroot.addContent(datafield21);
					v905 = (java.util.Vector) v1.elementAt(v + 6);
					Element datafield31 = new Element("datafield", "marc", "http://www.loc.gov/MARC21/slim");
					datafield31.setAttribute("tag", "905");
					datafield31.setAttribute("ind1", "0");
					datafield31.setAttribute("ind2", "0");
					for (int l = 0; l < v905.size(); l++) {
						Element subfield = new Element("subfield", "marc", "http://www.loc.gov/MARC21/slim");
						subfield.setAttribute("code", "a");
						subfield.setText(v905.elementAt(l).toString());
						datafield31.addContent(subfield);
					}
					marcroot.addContent(datafield31);
					v906 = (java.util.Vector) v1.elementAt(v + 7);
					Element datafield4 = new Element("datafield", "marc", "http://www.loc.gov/MARC21/slim");
					datafield4.setAttribute("tag", "906");
					datafield4.setAttribute("ind1", "0");
					datafield4.setAttribute("ind2", "0");
					for (int l = 0; l < v906.size(); l++) {
						Element subfield = new Element("subfield", "marc", "http://www.loc.gov/MARC21/slim");
						subfield.setAttribute("code", "a");
						subfield.setText(v906.elementAt(l).toString());
						datafield4.addContent(subfield);
					}
					marcroot.addContent(datafield4);
					v907 = (java.util.Vector) v1.elementAt(v + 8);
					for (int l = 0; l < v907.size(); l++) {
						Element datafield5 = new Element("datafield", "marc", "http://www.loc.gov/MARC21/slim");
						datafield5.setAttribute("tag", "907");
						datafield5.setAttribute("ind1", "0");
						datafield5.setAttribute("ind2", "0");
						java.util.Vector vecSub1 = new java.util.Vector(1, 1);
						vecSub1 = (java.util.Vector) v907.elementAt(l);
						for (int b = 0; b < vecSub1.size(); b = b + 2) {
							Element subfield = new Element("subfield", "marc", "http://www.loc.gov/MARC21/slim");
							subfield.setAttribute("code", vecSub1.elementAt(b).toString());
							subfield.setText(vecSub1.elementAt(b + 1).toString());
							datafield5.addContent(subfield);
						}
						marcroot.addContent(datafield5);
					}
					v908 = (java.util.Vector) v1.elementAt(v + 9);
					for (int l = 0; l < v908.size(); l++) {
						Element datafield6 = new Element("datafield", "marc", "http://www.loc.gov/MARC21/slim");
						datafield6.setAttribute("tag", "908");
						datafield6.setAttribute("ind1", "0");
						datafield6.setAttribute("ind2", "0");
						java.util.Vector vecSub1 = new java.util.Vector(1, 1);
						vecSub1 = (java.util.Vector) v908.elementAt(l);
						for (int b = 0; b < vecSub1.size(); b = b + 2) {
							Element subfield = new Element("subfield", "marc", "http://www.loc.gov/MARC21/slim");
							subfield.setAttribute("code", vecSub1.elementAt(b).toString());
							subfield.setText(vecSub1.elementAt(b + 1).toString());
							datafield6.addContent(subfield);
						}
						marcroot.addContent(datafield6);
					}
					vData = (java.util.Vector) v1.elementAt(v + 11);
					for (int m = 0; m < vData.size(); m = m + 2) {
						Element datafield2 = new Element("datafield", "marc", "http://www.loc.gov/MARC21/slim");
						datafield2.setAttribute("tag", vData.elementAt(m).toString());
						datafield2.setAttribute("ind1", "0");
						datafield2.setAttribute("ind2", "0");
						java.util.Vector vSub = new java.util.Vector(1, 1);
						vSub = (java.util.Vector) vData.elementAt(m + 1);
						for (int n = 0; n < vSub.size(); n = n + 2) {
							Element subfield = new Element("subfield", "marc", "http://www.loc.gov/MARC21/slim");
							subfield.setAttribute("code", vSub.elementAt(n).toString());
							subfield.setText(vSub.elementAt(n + 1).toString());
							datafield2.addContent(subfield);
						}
						marcroot.addContent(datafield2);
					}
					v856 = (java.util.Vector) v1.elementAt(v + 12);
					for (int l = 0; l < v856.size(); l = l + 2) {
						Element datafield3 = new Element("datafield", "marc", "http://www.loc.gov/MARC21/slim");
						datafield3.setAttribute("tag", "856");
						datafield3.setAttribute("ind1", "0");
						datafield3.setAttribute("ind2", "0");
						Element subfield1 = new Element("subfield", "marc", "http://www.loc.gov/MARC21/slim");
						subfield1.setAttribute("code", v856.elementAt(l).toString());
						subfield1.setText(v856.elementAt(l + 1).toString());
						datafield3.addContent(subfield1);
						marcroot.addContent(datafield3);
					}
					if (mdPrefixValue.equals("oai_dc")) {
						try {
							Transformer transformer = TransformerFactory.newInstance().newTransformer(
									new StreamSource(ejb.bprocess.util.NewGenLibRoot.getRoot() + java.io.File.separator
											+ "StyleSheets" + java.io.File.separator + "MARC21slim2OAIDC.xsl"));
							Document docmarc = new Document(marcroot);
							JDOMSource in = new JDOMSource(docmarc);
							JDOMResult out = new JDOMResult();
							transformer.transform(in, out);
							Document doc2 = out.getDocument();
							org.jdom.output.XMLOutputter out1 = new org.jdom.output.XMLOutputter();
							out1.setTextTrim(true);
							out1.setIndent("  ");
							out1.setNewlines(true);
							String s1 = out1.outputString(doc2);
							System.out.println("dublin core is" + s1);
							Element dcroot1 = doc2.getRootElement();
							Namespace xsi1 = Namespace.getNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance");
							Namespace oainsdc = Namespace.getNamespace("http://www.openarchives.org/OAI/2.0/oai_dc/");
							Element dcroot = new Element("dc", "oai_dc", "http://www.openarchives.org/OAI/2.0/oai_dc/");
							Namespace dcns = Namespace.getNamespace("dc", "http://purl.org/dc/elements/1.1/");
							dcroot.addNamespaceDeclaration(dcns);
							dcroot.addNamespaceDeclaration(xsi1);
							Attribute schemaLocationdc = new Attribute("schemaLocation",
									"http://www.openarchives.org/OAI/2.0/oai_dc/ http://www.openarchives.org/OAI/2.0/oai_dc.xsd",
									xsi1);
							dcroot.setAttribute(schemaLocationdc);
							java.util.List dcList = doc2.getRootElement().getChildren();
							for (int g = 0; g < dcList.size(); g++) {
								Element dcElem1 = (org.jdom.Element) dcList.get(g);
								Element dcElem = new Element(dcElem1.getName(), "dc",
										"http://purl.org/dc/elements/1.1/");
								dcElem.setText(dcElem1.getText());
								dcroot.addContent(dcElem);
							}
							metadata.addContent(dcroot);
						} catch (TransformerException e) {
							e.printStackTrace();
						}
					} else if (mdPrefixValue.equals("mods")) {
						try {
							java.util.Properties systemSettings = System.getProperties();
							java.util.prefs.Preferences prefs = java.util.prefs.Preferences.systemRoot();
							if (prefs.getBoolean("useproxy", false)) {
								systemSettings.put("proxySet", "true");
								systemSettings.put("proxyHost", prefs.get("proxyservername", ""));
								systemSettings.put("proxyPort", prefs.get("proxyport", ""));
								systemSettings.put("http.proxyHost", prefs.get("proxyservername", ""));
								systemSettings.put("http.proxyPort", prefs.get("proxyport", ""));
							}
							String urltext = "";
							Transformer transformer = null;
							urltext = "http://www.loc.gov/standards/mods/v3/MARC21slim2MODS3.xsl";
							java.net.URL url1 = new java.net.URL(urltext);
							java.net.URLConnection urlconn = url1.openConnection();
							urlconn.setDoInput(true);
							transformer = TransformerFactory.newInstance()
									.newTransformer(new StreamSource(urlconn.getInputStream()));
							Document docmarc = new Document(marcroot);
							JDOMSource in = new JDOMSource(docmarc);
							JDOMResult out = new JDOMResult();
							transformer.transform(in, out);
							Document doc2 = out.getDocument();
							org.jdom.output.XMLOutputter out1 = new org.jdom.output.XMLOutputter();
							out1.setTextTrim(true);
							out1.setIndent("  ");
							out1.setNewlines(true);
							String s1 = out1.outputString(doc2);
							Namespace xsi1 = Namespace.getNamespace("xlink", "http://www.w3.org/1999/xlink");
							Namespace oainsdc = Namespace.getNamespace("http://www.openarchives.org/OAI/2.0/oai_dc/");
							Element mroot = new Element("mods", "http://www.loc.gov/mods/v3");
							Namespace dcns = Namespace.getNamespace("http://www.loc.gov/mods/v3");
							mroot.addNamespaceDeclaration(xsi1);
							Attribute schemaLocationdc = new Attribute("schemaLocation",
									"http://www.loc.gov/mods/v3 http://www.loc.gov/standards/mods/v3/mods-3-0.xsd",
									xsi1);
							mroot.setAttribute(schemaLocationdc);
							java.util.List dcList = doc2.getRootElement().getChildren();
							for (int g = 0; g < dcList.size(); g++) {
								Element mElem1 = (org.jdom.Element) dcList.get(g);
								Element mElem = new Element(mElem1.getName(), "http://www.loc.gov/mods/v3");
								if (mElem1.hasChildren()) {
									java.util.List mList1 = mElem1.getChildren();
									for (int f = 0; f < mList1.size(); f++) {
										Element mElem2 = (org.jdom.Element) mList1.get(f);
										Element mElem3 = new Element(mElem2.getName(), "http://www.loc.gov/mods/v3");
										if (mElem2.hasChildren()) {
											java.util.List mList2 = mElem2.getChildren();
											for (int h = 0; h < mList2.size(); h++) {
												Element mElem4 = (org.jdom.Element) mList1.get(h);
												Element mElem5 = new Element(mElem4.getName(),
														"http://www.loc.gov/mods/v3");
												mElem5.setText(mElem4.getText());
												mElem3.addContent(mElem5);
											}
										}
										if (false == mElem2.hasChildren()) {
											mElem3.setText(mElem2.getText());
										}
										mElem.addContent(mElem3);
									}
								}
								if (false == mElem1.hasChildren()) {
									mElem.setText(mElem1.getText());
								}
								mroot.addContent(mElem);
							}
							metadata.addContent(mroot);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					if (mdPrefixValue.equals("marc21")) {
						metadata.addContent(marcroot);
					} else if (mdPrefixValue.equals("oai_dc")) {
					}
				}
				Record.addContent(head);
				Record.addContent(metadata);
				GetRecord.addContent(Record);
			}
		} else if (argCount <= 2) {
			if (idenCount < 1 && mdfCount < 1) {
				Errors e1 = new Errors();
				Element errorXML = e1.describeError(2, "missing arguments: identifier,metadataprefix", url,
						"GetRecord");
				root.addContent(errorXML);
			} else if (idenCount < 1) {
				Errors e1 = new Errors();
				Element errorXML = e1.describeError(2, "missing argument: identifier", url, "GetRecord");
				root.addContent(errorXML);
			} else if (mdfCount < 1) {
				Errors e1 = new Errors();
				Element errorXML = e1.describeError(2, "missing argument: metadataprefix", url, "GetRecord");
				root.addContent(errorXML);
			} else if (argCount > 2) {
				Errors e1 = new Errors();
				Element errorXML = e1.describeError(2, "more number of arguments", url, "GetRecord");
				root.addContent(errorXML);
			} else {
				System.out.println("no format");
				Errors e1 = new Errors();
				Element errorXML = e1.describeError(6, "", url, "GetRecord");
				root.addContent(errorXML);
			}
		}
		XMLOutputter out = new XMLOutputter();
		out.setIndent(" ");
		out.setNewlines(true);
		s = out.outputString(doc);
		return s;
	}

}