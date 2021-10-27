class n2285441 {
	static synchronized Person lookup(PhoneNumber HcbTGRRy, String kkWGnWM3) {
		Vector<Person> sYHzGYww = new Vector<Person>(5);
		if (HcbTGRRy.isFreeCall()) {
			Person EOLbfbIx = new Person("", "FreeCall");
			EOLbfbIx.addNumber(HcbTGRRy);
			sYHzGYww.add(EOLbfbIx);
		} else if (HcbTGRRy.isSIPNumber() || HcbTGRRy.isQuickDial()) {
			Person DooFvoIA = new Person();
			DooFvoIA.addNumber(HcbTGRRy);
			sYHzGYww.add(DooFvoIA);
		} else if (ReverseLookup.rlsMap.containsKey(HcbTGRRy.getCountryCode())) {
			nummer = HcbTGRRy.getAreaNumber();
			rls_list = ReverseLookup.rlsMap.get(HcbTGRRy.getCountryCode());
			Debug.info("Begin reverselookup for: " + nummer);
			if (nummer.startsWith(HcbTGRRy.getCountryCode()))
				nummer = nummer.substring(HcbTGRRy.getCountryCode().length());
			city = "";
			for (int CSwZBzuk = 0; CSwZBzuk < rls_list.size(); CSwZBzuk++) {
				yield();
				rls = rls_list.get(CSwZBzuk);
				if (!kkWGnWM3.equals("") && !kkWGnWM3.equals(rls.getName())) {
					Debug.warning("This lookup should be done using a specific site, skipping");
					continue;
				}
				prefix = rls.getPrefix();
				ac_length = rls.getAreaCodeLength();
				if (!nummer.startsWith(prefix))
					nummer = prefix + nummer;
				urlstr = rls.getURL();
				if (urlstr.contains("$AREACODE")) {
					urlstr = urlstr.replaceAll("\\$AREACODE",
							nummer.substring(prefix.length(), ac_length + prefix.length()));
					urlstr = urlstr.replaceAll("\\$NUMBER", nummer.substring(prefix.length() + ac_length));
				} else if (urlstr.contains("$PFXAREACODE")) {
					urlstr = urlstr.replaceAll("\\$PFXAREACODE", nummer.substring(0, prefix.length() + ac_length));
					urlstr = urlstr.replaceAll("\\$NUMBER", nummer.substring(prefix.length() + ac_length));
				} else
					urlstr = urlstr.replaceAll("\\$NUMBER", nummer);
				Debug.info("Reverse lookup using: " + urlstr);
				url = null;
				data = new String[dataLength];
				try {
					url = new URL(urlstr);
					if (url != null) {
						try {
							con = url.openConnection();
							con.setConnectTimeout(5000);
							con.setReadTimeout(15000);
							con.addRequestProperty("User-Agent", userAgent);
							con.connect();
							header = "";
							charSet = "";
							for (int WfVBiXR5 = 0;; WfVBiXR5++) {
								String W5G4FEr8 = con.getHeaderFieldKey(WfVBiXR5);
								String qJcsOY98 = con.getHeaderField(WfVBiXR5);
								if (W5G4FEr8 == null && qJcsOY98 == null) {
									break;
								}
								if ("content-type".equalsIgnoreCase(W5G4FEr8)) {
									String[] DDhSwQdx = qJcsOY98.split(";", 2);
									for (int dEGtigVj = 0; dEGtigVj < DDhSwQdx.length; dEGtigVj++) {
										if (DDhSwQdx[dEGtigVj].trim().toLowerCase().startsWith("charset=")) {
											String[] GDukaYzU = DDhSwQdx[dEGtigVj].split("=");
											charSet = GDukaYzU[1].trim();
										}
									}
								}
								header += W5G4FEr8 + ": " + qJcsOY98 + " | ";
							}
							Debug.debug("Header of " + rls.getName() + ":" + header);
							Debug.debug("CHARSET : " + charSet);
							BufferedReader DktzXpm3;
							if (charSet.equals("")) {
								DktzXpm3 = new BufferedReader(
										new InputStreamReader(con.getInputStream(), "ISO-8859-1"));
							} else {
								DktzXpm3 = new BufferedReader(new InputStreamReader(con.getInputStream(), charSet));
							}
							int H73c0vS0 = 0;
							while (null != ((str = DktzXpm3.readLine()))) {
								data[H73c0vS0] = str;
								yield();
								if (H73c0vS0 >= dataLength) {
									System.err.println("Result > " + dataLength + " Lines");
									break;
								}
								H73c0vS0++;
							}
							DktzXpm3.close();
							Debug.info("Begin processing response from " + rls.getName());
							for (int Jis4MPEr = 0; Jis4MPEr < rls.size(); Jis4MPEr++) {
								yield();
								firstname = "";
								lastname = "";
								company = "";
								street = "";
								zipcode = "";
								city = "";
								Person QYBMzI2s = null;
								patterns = rls.getEntry(Jis4MPEr);
								Pattern bOOA7TSZ = null;
								Pattern dDJdWt7G = null;
								Pattern Tvf7XHAy = null;
								Pattern AwdoQlXF = null;
								Pattern iblaWRcg = null;
								Pattern UqSMUzyV = null;
								Matcher j0KKyNH7 = null;
								Matcher RTtjNVPm = null;
								Matcher hc7FpCyK = null;
								Matcher rQay8bQA = null;
								Matcher xSrduFrm = null;
								Matcher WruP04fX = null;
								if (!patterns[ReverseLookupSite.NAME].equals("")
										&& (patterns[ReverseLookupSite.FIRSTNAME].equals("")
												&& patterns[ReverseLookupSite.LASTNAME].equals(""))) {
									bOOA7TSZ = Pattern.compile(patterns[ReverseLookupSite.NAME]);
								}
								if (!patterns[ReverseLookupSite.STREET].equals("")) {
									dDJdWt7G = Pattern.compile(patterns[ReverseLookupSite.STREET]);
								}
								if (!patterns[ReverseLookupSite.CITY].equals("")) {
									Tvf7XHAy = Pattern.compile(patterns[ReverseLookupSite.CITY]);
								}
								if (!patterns[ReverseLookupSite.ZIPCODE].equals("")) {
									AwdoQlXF = Pattern.compile(patterns[ReverseLookupSite.ZIPCODE]);
								}
								if (!patterns[ReverseLookupSite.FIRSTNAME].equals("")) {
									iblaWRcg = Pattern.compile(patterns[ReverseLookupSite.FIRSTNAME]);
								}
								if (!patterns[ReverseLookupSite.LASTNAME].equals("")) {
									UqSMUzyV = Pattern.compile(patterns[ReverseLookupSite.LASTNAME]);
								}
								for (int rsaGdXB0 = 0; rsaGdXB0 < dataLength; rsaGdXB0++) {
									if (data[rsaGdXB0] != null) {
										int XjBJDf6i = 160;
										data[rsaGdXB0] = data[rsaGdXB0]
												.replaceAll(new Character((char) XjBJDf6i).toString(), " ");
										if (UqSMUzyV != null) {
											WruP04fX = UqSMUzyV.matcher(data[rsaGdXB0]);
											if (WruP04fX.find()) {
												str = "";
												for (int anqYNjUo = 1; anqYNjUo <= WruP04fX.groupCount(); anqYNjUo++) {
													if (WruP04fX.group(anqYNjUo) != null)
														str = str + WruP04fX.group(anqYNjUo).trim() + " ";
												}
												lastname = JFritzUtils.removeLeadingSpaces(HTMLUtil.stripEntities(str));
												lastname = lastname.trim();
												lastname = lastname.replaceAll(",", "");
												lastname = lastname.replaceAll("%20", " ");
												lastname = JFritzUtils.replaceSpecialCharsUTF(lastname);
												lastname = JFritzUtils
														.removeLeadingSpaces(HTMLUtil.stripEntities(lastname));
												lastname = JFritzUtils.removeDuplicateWhitespace(lastname);
												if ("lastname".equals(patterns[ReverseLookupSite.FIRSTOCCURANCE])) {
													QYBMzI2s = new Person();
													QYBMzI2s.addNumber(HcbTGRRy.getIntNumber(), "home");
													sYHzGYww.add(QYBMzI2s);
												}
												if (QYBMzI2s != null) {
													QYBMzI2s.setLastName(lastname);
												}
											}
										}
										yield();
										if (iblaWRcg != null) {
											xSrduFrm = iblaWRcg.matcher(data[rsaGdXB0]);
											if (xSrduFrm.find()) {
												str = "";
												for (int M0SkRun2 = 1; M0SkRun2 <= xSrduFrm.groupCount(); M0SkRun2++) {
													if (xSrduFrm.group(M0SkRun2) != null)
														str = str + xSrduFrm.group(M0SkRun2).trim() + " ";
												}
												firstname = JFritzUtils
														.removeLeadingSpaces(HTMLUtil.stripEntities(str));
												firstname = firstname.trim();
												firstname = firstname.replaceAll(",", "");
												firstname = firstname.replaceAll("%20", " ");
												firstname = JFritzUtils.replaceSpecialCharsUTF(firstname);
												firstname = JFritzUtils
														.removeLeadingSpaces(HTMLUtil.stripEntities(firstname));
												firstname = JFritzUtils.removeDuplicateWhitespace(firstname);
												if ("firstname".equals(patterns[ReverseLookupSite.FIRSTOCCURANCE])) {
													QYBMzI2s = new Person();
													QYBMzI2s.addNumber(HcbTGRRy.getIntNumber(), "home");
													sYHzGYww.add(QYBMzI2s);
												}
												if (QYBMzI2s != null) {
													QYBMzI2s.setFirstName(firstname);
												}
											}
										}
										yield();
										if (bOOA7TSZ != null) {
											j0KKyNH7 = bOOA7TSZ.matcher(data[rsaGdXB0]);
											if (j0KKyNH7.find()) {
												str = "";
												for (int EcP3vyFc = 1; EcP3vyFc <= j0KKyNH7.groupCount(); EcP3vyFc++) {
													if (j0KKyNH7.group(EcP3vyFc) != null)
														str = str + j0KKyNH7.group(EcP3vyFc).trim() + " ";
												}
												String[] caPm3B8o;
												caPm3B8o = str.split(" ", 2);
												lastname = JFritzUtils
														.removeLeadingSpaces(HTMLUtil.stripEntities(caPm3B8o[0]));
												lastname = lastname.trim();
												lastname = lastname.replaceAll(",", "");
												lastname = lastname.replaceAll("%20", " ");
												lastname = JFritzUtils.replaceSpecialCharsUTF(lastname);
												lastname = JFritzUtils
														.removeLeadingSpaces(HTMLUtil.stripEntities(lastname));
												lastname = JFritzUtils.removeDuplicateWhitespace(lastname);
												if (caPm3B8o[1].length() > 0) {
													firstname = HTMLUtil.stripEntities(caPm3B8o[1]);
													if ((firstname.indexOf("  ") > -1)
															&& (firstname.indexOf("  u.") == -1)) {
														company = JFritzUtils.removeLeadingSpaces(
																firstname.substring(firstname.indexOf("  ")).trim());
														firstname = JFritzUtils.removeLeadingSpaces(
																firstname.substring(0, firstname.indexOf("  ")).trim());
													} else {
														firstname = JFritzUtils.removeLeadingSpaces(
																firstname.replaceAll("  u. ", " und "));
													}
												}
												firstname = firstname.replaceAll("%20", " ");
												firstname = JFritzUtils.replaceSpecialCharsUTF(firstname);
												firstname = JFritzUtils
														.removeLeadingSpaces(HTMLUtil.stripEntities(firstname));
												firstname = JFritzUtils.removeDuplicateWhitespace(firstname);
												firstname = firstname.trim();
												company = company.replaceAll("%20", " ");
												company = JFritzUtils.replaceSpecialCharsUTF(company);
												company = JFritzUtils
														.removeLeadingSpaces(HTMLUtil.stripEntities(company));
												company = JFritzUtils.removeDuplicateWhitespace(company);
												company = company.trim();
												if ("name".equals(patterns[ReverseLookupSite.FIRSTOCCURANCE])) {
													QYBMzI2s = new Person();
													if (company.length() > 0) {
														QYBMzI2s.addNumber(HcbTGRRy.getIntNumber(), "business");
													} else {
														QYBMzI2s.addNumber(HcbTGRRy.getIntNumber(), "home");
													}
													sYHzGYww.add(QYBMzI2s);
												}
												if (QYBMzI2s != null) {
													QYBMzI2s.setFirstName(firstname);
													QYBMzI2s.setLastName(lastname);
													QYBMzI2s.setCompany(company);
												}
											}
										}
										yield();
										if (dDJdWt7G != null) {
											RTtjNVPm = dDJdWt7G.matcher(data[rsaGdXB0]);
											if (RTtjNVPm.find()) {
												str = "";
												for (int hsV50scg = 1; hsV50scg <= RTtjNVPm.groupCount(); hsV50scg++) {
													if (RTtjNVPm.group(hsV50scg) != null)
														str = str + RTtjNVPm.group(hsV50scg).trim() + " ";
												}
												street = str.replaceAll("%20", " ");
												street = JFritzUtils.replaceSpecialCharsUTF(street);
												street = JFritzUtils
														.removeLeadingSpaces(HTMLUtil.stripEntities(street));
												street = JFritzUtils.removeDuplicateWhitespace(street);
												street = street.trim();
												if ("street".equals(patterns[ReverseLookupSite.FIRSTOCCURANCE])) {
													QYBMzI2s = new Person();
													QYBMzI2s.addNumber(HcbTGRRy.getIntNumber(), "home");
													sYHzGYww.add(QYBMzI2s);
												}
												if (QYBMzI2s != null) {
													QYBMzI2s.setStreet(street);
												}
											}
										}
										yield();
										if (Tvf7XHAy != null) {
											hc7FpCyK = Tvf7XHAy.matcher(data[rsaGdXB0]);
											if (hc7FpCyK.find()) {
												str = "";
												for (int d3X6OQXh = 1; d3X6OQXh <= hc7FpCyK.groupCount(); d3X6OQXh++) {
													if (hc7FpCyK.group(d3X6OQXh) != null)
														str = str + hc7FpCyK.group(d3X6OQXh).trim() + " ";
												}
												city = str.replaceAll("%20", " ");
												city = JFritzUtils.replaceSpecialCharsUTF(city);
												city = JFritzUtils.removeLeadingSpaces(HTMLUtil.stripEntities(city));
												city = JFritzUtils.removeDuplicateWhitespace(city);
												city = city.trim();
												if ("city".equals(patterns[ReverseLookupSite.FIRSTOCCURANCE])) {
													QYBMzI2s = new Person();
													QYBMzI2s.addNumber(HcbTGRRy.getIntNumber(), "home");
													sYHzGYww.add(QYBMzI2s);
												}
												if (QYBMzI2s != null) {
													QYBMzI2s.setCity(city);
												}
											}
										}
										yield();
										if (AwdoQlXF != null) {
											rQay8bQA = AwdoQlXF.matcher(data[rsaGdXB0]);
											if (rQay8bQA.find()) {
												str = "";
												for (int ySbSdAT6 = 1; ySbSdAT6 <= rQay8bQA.groupCount(); ySbSdAT6++) {
													if (rQay8bQA.group(ySbSdAT6) != null)
														str = str + rQay8bQA.group(ySbSdAT6).trim() + " ";
												}
												zipcode = str.replaceAll("%20", " ");
												zipcode = JFritzUtils.replaceSpecialCharsUTF(zipcode);
												zipcode = JFritzUtils
														.removeLeadingSpaces(HTMLUtil.stripEntities(zipcode));
												zipcode = JFritzUtils.removeDuplicateWhitespace(zipcode);
												zipcode = zipcode.trim();
												if ("zipcode".equals(patterns[ReverseLookupSite.FIRSTOCCURANCE])) {
													QYBMzI2s = new Person();
													QYBMzI2s.addNumber(HcbTGRRy.getIntNumber(), "home");
													sYHzGYww.add(QYBMzI2s);
												}
												if (QYBMzI2s != null) {
													QYBMzI2s.setPostalCode(zipcode);
												}
											}
										}
									}
								}
								if (!firstname.equals("") || !lastname.equals("") || !company.equals(""))
									break;
							}
							yield();
							if (!firstname.equals("") || !lastname.equals("") || !company.equals("")) {
								if (city.equals("")) {
									if (HcbTGRRy.getCountryCode().equals(ReverseLookup.GERMANY_CODE))
										city = ReverseLookupGermany.getCity(nummer);
									else if (HcbTGRRy.getCountryCode().equals(ReverseLookup.AUSTRIA_CODE))
										city = ReverseLookupAustria.getCity(nummer);
									else if (HcbTGRRy.getCountryCode().startsWith(ReverseLookup.USA_CODE))
										city = ReverseLookupUnitedStates.getCity(nummer);
									else if (HcbTGRRy.getCountryCode().startsWith(ReverseLookup.TURKEY_CODE))
										city = ReverseLookupTurkey.getCity(nummer);
								}
								return sYHzGYww.get(0);
							}
						} catch (IOException eCKJlh4h) {
							Debug.error("Error while retrieving " + urlstr);
						}
					}
				} catch (MalformedURLException SU9x2G8c) {
					Debug.error("URL invalid: " + urlstr);
				}
			}
			yield();
			Debug.warning("No match for " + nummer + " found");
			if (city.equals("")) {
				if (HcbTGRRy.getCountryCode().equals(ReverseLookup.GERMANY_CODE))
					city = ReverseLookupGermany.getCity(nummer);
				else if (HcbTGRRy.getCountryCode().equals(ReverseLookup.AUSTRIA_CODE))
					city = ReverseLookupAustria.getCity(nummer);
				else if (HcbTGRRy.getCountryCode().startsWith(ReverseLookup.USA_CODE))
					city = ReverseLookupUnitedStates.getCity(nummer);
				else if (HcbTGRRy.getCountryCode().startsWith(ReverseLookup.TURKEY_CODE))
					city = ReverseLookupTurkey.getCity(nummer);
			}
			Person u0jK609X = new Person("", "", "", "", "", city, "", "");
			u0jK609X.addNumber(HcbTGRRy.getAreaNumber(), "home");
			return u0jK609X;
		} else {
			Debug.warning("No reverse lookup sites for: " + HcbTGRRy.getCountryCode());
			Person ajMx0Pgy = new Person();
			ajMx0Pgy.addNumber(HcbTGRRy.getAreaNumber(), "home");
			if (HcbTGRRy.getCountryCode().equals(ReverseLookup.GERMANY_CODE))
				city = ReverseLookupGermany.getCity(HcbTGRRy.getIntNumber());
			else if (HcbTGRRy.getCountryCode().equals(ReverseLookup.AUSTRIA_CODE))
				city = ReverseLookupAustria.getCity(HcbTGRRy.getIntNumber());
			else if (HcbTGRRy.getCountryCode().startsWith(ReverseLookup.USA_CODE))
				city = ReverseLookupUnitedStates.getCity(HcbTGRRy.getIntNumber());
			else if (HcbTGRRy.getCountryCode().startsWith(ReverseLookup.TURKEY_CODE))
				city = ReverseLookupTurkey.getCity(HcbTGRRy.getIntNumber());
			ajMx0Pgy.setCity(city);
			return ajMx0Pgy;
		}
		return new Person("not found", "Person");
	}

}