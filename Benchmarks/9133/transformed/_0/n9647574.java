class n9647574 {
	private void FindAvail() throws ParserConfigurationException, SQLException {
		Savepoint SwLiP2GM;
		String AnldNsai = "select xmlquery('$c/coach_status/class[@name=\"" + booking_details.getTclass() + "\"]' ";
		AnldNsai += "passing hp_administrator.availability.AVAIL as \"c\") ";
		AnldNsai += " from hp_administrator.availability ";
		AnldNsai += " where date = '" + booking_details.getDate() + "' and train_no like '"
				+ booking_details.getTrain_no() + "'";
		System.out.println(AnldNsai);
		String AblMT8Oa = "";
		String dzQCXdKk = "";
		String xh0qzZui = "";
		String WkRhfchJ = "";
		String zvZGViUM = "";
		String TSBbNLst = "", I6FO9hSp = "", HGa88hIt = "";
		Integer kowGjaQa, ahmu6s2A, yrUxvwL0;
		Integer CR0wS6Db;
		Integer NErWFyLd, OfIqEG4M, xzihFFzL, IXgY2A9l;
		String XKcCE8TT = "", NfV6aWm0 = "";
		PreparedStatement Ejt2rd4M;
		Statement YbxqvH5j, mCqBbKAT, hE1bsebO, cwl1X3xp;
		ResultSet gNr16fgw, KZQvoL4K;
		DocumentBuilderFactory NVoubeCr = DocumentBuilderFactory.newInstance();
		DocumentBuilder ETcsMlSO = NVoubeCr.newDocumentBuilder();
		Document t5p9Fqbm, z4lkxqPs, nYTkN2B8, kh1uBgqV;
		Element RhNseOTU, rPqsaYfi;
		Node amlYSoat;
		try {
			YbxqvH5j = conn.createStatement();
			SwLiP2GM = conn.setSavepoint();
			gNr16fgw = YbxqvH5j.executeQuery(AnldNsai);
			if (gNr16fgw.next())
				AblMT8Oa = gNr16fgw.getString(1);
			System.out.println(AblMT8Oa);
			StringBuffer VkJqXQli = new StringBuffer(AblMT8Oa);
			ByteArrayInputStream HeBJQVLL = new ByteArrayInputStream(VkJqXQli.toString().getBytes("UTF-16"));
			t5p9Fqbm = ETcsMlSO.parse(HeBJQVLL);
			StringWriter r3Idbc8Q;
			OutputFormat br1HxdfO;
			br1HxdfO = new OutputFormat();
			br1HxdfO.setPreserveSpace(true);
			br1HxdfO.setEncoding("UTF-8");
			br1HxdfO.setOmitXMLDeclaration(true);
			XMLSerializer vDg4XIPb;
			RhNseOTU = t5p9Fqbm.getDocumentElement();
			NodeList y3f7YE29 = RhNseOTU.getElementsByTagName("coach");
			Element U6jc9Urq, SKWmKAy9;
			Element yWYgf6zy, RVNL8F2I, zfQjggn4, hYNOJHzy, HRqoMNuu, LEpGovR1;
			NodeList kMHOjdTT, LPszbcPY;
			number_of_tickets_rem = booking_details.getNoOfPersons();
			int naIcAGk4 = 0;
			firsttime = true;
			boolean U3A5O4Vr;
			for (int JDQMIs4i = 0; JDQMIs4i < y3f7YE29.getLength(); JDQMIs4i++) {
				U6jc9Urq = (Element) y3f7YE29.item(JDQMIs4i);
				zvZGViUM = U6jc9Urq.getAttribute("number");
				String rmoZPPTy = U6jc9Urq.getAttribute("coachmax");
				Integer BlpAQzOw = Integer.parseInt(rmoZPPTy.trim());
				yWYgf6zy = (Element) U6jc9Urq.getFirstChild();
				RVNL8F2I = (Element) U6jc9Urq.getLastChild();
				RVNL8F2I = (Element) RVNL8F2I.getPreviousSibling().getPreviousSibling().getPreviousSibling();
				XKcCE8TT = yWYgf6zy.getNodeName();
				NfV6aWm0 = RVNL8F2I.getNodeName();
				String qYMMfm3U = "select xmlquery('$c/status/class[@type=\"" + booking_details.getTclass()
						+ "\"]/coach[@number=\"" + zvZGViUM + "\"]' ";
				qYMMfm3U += " passing hp_administrator.book_tickets.SEAT as \"c\") from hp_administrator.book_tickets ";
				qYMMfm3U += " where  date = '" + booking_details.getDate() + "' and train_no like '"
						+ booking_details.getTrain_no() + "' ";
				System.out.println("route  :" + sourcenws);
				System.out.println("route  :" + destnnws);
				System.out.println("route src :" + XKcCE8TT);
				System.out.println("route dest :" + NfV6aWm0);
				System.out.println(qYMMfm3U);
				cwl1X3xp = conn.createStatement();
				KZQvoL4K = cwl1X3xp.executeQuery(qYMMfm3U);
				if (KZQvoL4K.next())
					dzQCXdKk = KZQvoL4K.getString(1);
				StringBuffer rXK31PwY = new StringBuffer(dzQCXdKk);
				ByteArrayInputStream pBFyTMV7 = new ByteArrayInputStream(rXK31PwY.toString().getBytes("UTF-16"));
				kh1uBgqV = ETcsMlSO.parse(pBFyTMV7);
				rPqsaYfi = kh1uBgqV.getDocumentElement();
				U3A5O4Vr = false;
				if (XKcCE8TT.equals(sourcenws) && NfV6aWm0.equals(destnnws)) {
					System.out.println("case 1");
					xh0qzZui = yWYgf6zy.getTextContent();
					CR0wS6Db = Integer.parseInt(xh0qzZui.trim());
					if (useragent)
						WkRhfchJ = yWYgf6zy.getAttribute("agent");
					else
						WkRhfchJ = yWYgf6zy.getAttribute("user");
					NErWFyLd = Integer.parseInt(WkRhfchJ.trim());
					TSBbNLst = yWYgf6zy.getAttribute(sourcenws + "TILL");
					kowGjaQa = Integer.parseInt(TSBbNLst.trim());
					HGa88hIt = yWYgf6zy.getAttribute(sourcenws);
					yrUxvwL0 = Integer.parseInt(HGa88hIt.trim());
					I6FO9hSp = yWYgf6zy.getTextContent();
					ahmu6s2A = Integer.parseInt(I6FO9hSp.trim());
					OfIqEG4M = BlpAQzOw - kowGjaQa + 1;
					xzihFFzL = yrUxvwL0;
					IXgY2A9l = yrUxvwL0 - ahmu6s2A;
					OfIqEG4M += IXgY2A9l;
					xzihFFzL -= IXgY2A9l;
					Element UjSGsf2s, FLCc4Til;
					NodeList YwKci8pb = rPqsaYfi.getElementsByTagName("seat");
					UjSGsf2s = (Element) YwKci8pb.item(0);
					if (booking_details.getNoOfPersons() <= CR0wS6Db && booking_details.getNoOfPersons() <= NErWFyLd) {
						coach.clear();
						booking_details.coachlist.clear();
						booking_details.seatlist.clear();
						seatno.clear();
						for (naIcAGk4 = 0; naIcAGk4 < booking_details.getNoOfPersons(); naIcAGk4++) {
							coach.add(zvZGViUM);
							booking_details.coachlist.add(zvZGViUM);
							while (Integer.parseInt(UjSGsf2s.getFirstChild().getTextContent().trim()) < OfIqEG4M) {
								UjSGsf2s = (Element) UjSGsf2s.getNextSibling();
							}
							OfIqEG4M++;
							System.out.println(UjSGsf2s.getFirstChild().getTextContent().trim());
							seatno.add(UjSGsf2s.getFirstChild().getTextContent().trim());
							booking_details.seatlist.add(UjSGsf2s.getFirstChild().getTextContent().trim());
							YwKci8pb = UjSGsf2s.getElementsByTagName(sourcenws);
							FLCc4Til = (Element) YwKci8pb.item(0);
							while (!FLCc4Til.getNodeName().equals(destnnws)) {
								FLCc4Til.setTextContent("0");
								FLCc4Til = (Element) FLCc4Til.getNextSibling();
							}
						}
						number_of_tickets_rem = 0;
						CR0wS6Db -= booking_details.getNoOfPersons();
						NErWFyLd -= booking_details.getNoOfPersons();
						if (!firsttime)
							conn.rollback(SwLiP2GM);
						String SAZWczA3 = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL  modify do ";
						SAZWczA3 += " replace value of $new/coach_status/class[@name=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + zvZGViUM + "\"]/" + sourcenws + " with \"" + CR0wS6Db + "\"";
						SAZWczA3 += " return  $new')  where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "' ";
						mCqBbKAT = conn.createStatement();
						int swau1zSA = mCqBbKAT.executeUpdate(SAZWczA3);
						if (swau1zSA > 0)
							System.out.println("upda avail success");
						r3Idbc8Q = new StringWriter();
						vDg4XIPb = new XMLSerializer(r3Idbc8Q, br1HxdfO);
						vDg4XIPb.serialize(kh1uBgqV);
						String Dm66YnNm = "update hp_administrator.book_tickets set SEAT = xmlquery( 'transform copy $new := $SEAT ";
						Dm66YnNm += " modify do replace $new/status/class[@type=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + zvZGViUM + "\"] with " + r3Idbc8Q.toString();
						Dm66YnNm += " return $new') where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "'  ";
						System.out.println(Dm66YnNm);
						hE1bsebO = conn.createStatement();
						swau1zSA = hE1bsebO.executeUpdate(Dm66YnNm);
						if (swau1zSA > 0)
							System.out.println("upda seat success");
						String iNxmSdIG = "";
						if (useragent)
							iNxmSdIG = "agent";
						else
							iNxmSdIG = "user";
						SAZWczA3 = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL  modify do ";
						SAZWczA3 += " replace value of $new/coach_status/class[@name=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + zvZGViUM + "\"]/" + sourcenws + "/@" + iNxmSdIG + " with \""
								+ NErWFyLd + "\"";
						SAZWczA3 += " return  $new')  where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "' ";
						System.out.println(SAZWczA3);
						mCqBbKAT = conn.createStatement();
						swau1zSA = mCqBbKAT.executeUpdate(SAZWczA3);
						if (swau1zSA > 0)
							System.out.println("upda" + iNxmSdIG + " success");
						break;
					}
					while (CR0wS6Db > 0 && NErWFyLd > 0 && number_of_tickets_rem > 0) {
						if (firsttime) {
							SwLiP2GM = conn.setSavepoint();
							firsttime = false;
						}
						U3A5O4Vr = true;
						coach.add(zvZGViUM);
						booking_details.coachlist.add(zvZGViUM);
						naIcAGk4++;
						number_of_tickets_rem--;
						CR0wS6Db--;
						NErWFyLd--;
						while (Integer.parseInt(UjSGsf2s.getFirstChild().getTextContent().trim()) < OfIqEG4M) {
							UjSGsf2s = (Element) UjSGsf2s.getNextSibling();
						}
						OfIqEG4M++;
						System.out.println(UjSGsf2s.getFirstChild().getTextContent().trim());
						seatno.add(UjSGsf2s.getFirstChild().getTextContent().trim());
						booking_details.seatlist.add(UjSGsf2s.getFirstChild().getTextContent().trim());
						YwKci8pb = UjSGsf2s.getElementsByTagName(sourcenws);
						FLCc4Til = (Element) YwKci8pb.item(0);
						while (!FLCc4Til.getNodeName().equals(destnnws)) {
							FLCc4Til.setTextContent("0");
							FLCc4Til = (Element) FLCc4Til.getNextSibling();
						}
						String tmZgLwg4 = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL  modify do ";
						tmZgLwg4 += " replace value of $new/coach_status/class[@name=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + zvZGViUM + "\"]/" + sourcenws + " with \"" + CR0wS6Db + "\"";
						tmZgLwg4 += " return  $new')  where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "' ";
						mCqBbKAT = conn.createStatement();
						mCqBbKAT.executeUpdate(tmZgLwg4);
						String P7Nn3loc = "";
						if (useragent)
							P7Nn3loc = "agent";
						else
							P7Nn3loc = "user";
						tmZgLwg4 = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL  modify do ";
						tmZgLwg4 += " replace value of $new/coach_status/class[@name=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + P7Nn3loc + "\"]/" + sourcenws + "/@" + P7Nn3loc + " with \""
								+ NErWFyLd + "\"";
						tmZgLwg4 += " return  $new')  where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "' ";
						mCqBbKAT = conn.createStatement();
						mCqBbKAT.executeUpdate(tmZgLwg4);
					}
					if (U3A5O4Vr) {
						r3Idbc8Q = new StringWriter();
						vDg4XIPb = new XMLSerializer(r3Idbc8Q, br1HxdfO);
						vDg4XIPb.serialize(kh1uBgqV);
						String vlmqYVhq = "update hp_administrator.book_tickets set SEAT = xmlquery( 'transform copy $new := $SEAT ";
						vlmqYVhq += " modify do replace $new/status/class[@type=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + zvZGViUM + "\"] with " + r3Idbc8Q.toString();
						vlmqYVhq += " return $new') where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "'  ";
						hE1bsebO = conn.createStatement();
						hE1bsebO.executeUpdate(vlmqYVhq);
					}
				} else if (XKcCE8TT.equals(sourcenws) && !NfV6aWm0.equals(destnnws)) {
					System.out.println("case 2");
					String rGTTrBAc = yWYgf6zy.getTextContent();
					System.out.println(rGTTrBAc);
					Integer K7C6cRlV = Integer.parseInt(rGTTrBAc.trim());
					NodeList a7SdC7Ro = U6jc9Urq.getElementsByTagName(destnnws);
					Element C80ebUQw = (Element) a7SdC7Ro.item(0);
					String FD7wFGt6 = C80ebUQw.getAttribute(destnnws + "TILL");
					System.out.println(FD7wFGt6);
					Integer dGXtvcHS = Integer.parseInt(FD7wFGt6.trim());
					HGa88hIt = yWYgf6zy.getAttribute(sourcenws);
					System.out.println(HGa88hIt);
					yrUxvwL0 = Integer.parseInt(HGa88hIt.trim());
					String QibekHgA = "", jGZ8ro14 = "";
					if (useragent) {
						QibekHgA = yWYgf6zy.getAttribute("agent");
						jGZ8ro14 = C80ebUQw.getAttribute("agenttill");
					} else {
						QibekHgA = yWYgf6zy.getAttribute("user");
						jGZ8ro14 = C80ebUQw.getAttribute("usertill");
					}
					System.out.println(jGZ8ro14);
					System.out.println(QibekHgA);
					Integer TJafIPTI = Integer.parseInt(jGZ8ro14.trim());
					Integer Z0iGq0d7 = Integer.parseInt(QibekHgA.trim());
					Element hQ8mjV1V, JJEgmcFD;
					if (booking_details.getNoOfPersons() <= dGXtvcHS && booking_details.getNoOfPersons() <= TJafIPTI) {
						OfIqEG4M = BlpAQzOw - dGXtvcHS + 1;
						xzihFFzL = dGXtvcHS;
						NodeList waju8Tm8 = rPqsaYfi.getElementsByTagName("seat");
						hQ8mjV1V = (Element) waju8Tm8.item(0);
						coach.clear();
						seatno.clear();
						booking_details.coachlist.clear();
						booking_details.seatlist.clear();
						for (naIcAGk4 = 0; naIcAGk4 < booking_details.getNoOfPersons(); naIcAGk4++) {
							coach.add(zvZGViUM);
							booking_details.coachlist.add(zvZGViUM);
							while (Integer.parseInt(hQ8mjV1V.getFirstChild().getTextContent().trim()) < OfIqEG4M) {
								hQ8mjV1V = (Element) hQ8mjV1V.getNextSibling();
							}
							OfIqEG4M++;
							System.out.println(hQ8mjV1V.getFirstChild().getTextContent().trim());
							seatno.add(hQ8mjV1V.getFirstChild().getTextContent().trim());
							booking_details.seatlist.add(hQ8mjV1V.getFirstChild().getTextContent().trim());
							waju8Tm8 = hQ8mjV1V.getElementsByTagName(sourcenws);
							JJEgmcFD = (Element) waju8Tm8.item(0);
							while (!JJEgmcFD.getNodeName().equals(destnnws)) {
								JJEgmcFD.setTextContent("0");
								JJEgmcFD = (Element) JJEgmcFD.getNextSibling();
							}
						}
						number_of_tickets_rem = 0;
						dGXtvcHS -= booking_details.getNoOfPersons();
						TJafIPTI -= booking_details.getNoOfPersons();
						if (!firsttime)
							conn.rollback(SwLiP2GM);
						String TSewMpfv = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL modify do replace value of ";
						TSewMpfv += "$new/coach_status/class[@name=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + zvZGViUM + "\"]/" + destnnws + "/@" + destnnws + "TILL"
								+ " with \"" + dGXtvcHS + "\" ";
						TSewMpfv += " return  $new')  where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "' ";
						System.out.println(TSewMpfv);
						mCqBbKAT = conn.createStatement();
						int R6zTlnzh = mCqBbKAT.executeUpdate(TSewMpfv);
						if (R6zTlnzh > 0)
							System.out.println("update avail success");
						r3Idbc8Q = new StringWriter();
						vDg4XIPb = new XMLSerializer(r3Idbc8Q, br1HxdfO);
						vDg4XIPb.serialize(kh1uBgqV);
						String sC3hmrp6 = "update hp_administrator.book_tickets set SEAT = xmlquery( 'transform copy $new := $SEAT ";
						sC3hmrp6 += " modify do replace $new/status/class[@type=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + zvZGViUM + "\"] with " + r3Idbc8Q.toString();
						sC3hmrp6 += " return $new') where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "'  ";
						System.out.println(sC3hmrp6);
						hE1bsebO = conn.createStatement();
						R6zTlnzh = hE1bsebO.executeUpdate(sC3hmrp6);
						if (R6zTlnzh > 0)
							System.out.println("update seat success");
						String l5eMcqfB = "";
						if (useragent)
							l5eMcqfB = "agent";
						else
							l5eMcqfB = "user";
						TSewMpfv = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL modify do replace value of ";
						TSewMpfv += "$new/coach_status/class[@name=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + zvZGViUM + "\"]/" + destnnws + "/@" + l5eMcqfB + "till"
								+ " with \"" + TJafIPTI + "\" ";
						TSewMpfv += " return  $new')  where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "' ";
						System.out.println(TSewMpfv);
						mCqBbKAT = conn.createStatement();
						R6zTlnzh = mCqBbKAT.executeUpdate(TSewMpfv);
						if (R6zTlnzh > 0)
							System.out.println("update " + l5eMcqfB + " success");
						break;
					} else if (booking_details.getNoOfPersons() > TJafIPTI && TJafIPTI > 0
							&& booking_details.getNoOfPersons() <= TJafIPTI + Z0iGq0d7) {
						int CHESoO79 = 0;
						if (booking_details.getNoOfPersons() > TJafIPTI)
							CHESoO79 = booking_details.getNoOfPersons() - TJafIPTI;
						naIcAGk4 = 0;
						boolean eND3ans2 = true;
						OfIqEG4M = BlpAQzOw - dGXtvcHS + 1;
						xzihFFzL = dGXtvcHS;
						NodeList GfpQawiU = rPqsaYfi.getElementsByTagName("seat");
						hQ8mjV1V = (Element) GfpQawiU.item(0);
						coach.clear();
						seatno.clear();
						booking_details.coachlist.clear();
						booking_details.seatlist.clear();
						for (naIcAGk4 = 0; naIcAGk4 < booking_details.getNoOfPersons(); naIcAGk4++) {
							coach.add(zvZGViUM);
							booking_details.coachlist.add(zvZGViUM);
							while (Integer.parseInt(hQ8mjV1V.getFirstChild().getTextContent().trim()) < OfIqEG4M) {
								hQ8mjV1V = (Element) hQ8mjV1V.getNextSibling();
							}
							OfIqEG4M++;
							System.out.println(hQ8mjV1V.getFirstChild().getTextContent().trim());
							seatno.add(hQ8mjV1V.getFirstChild().getTextContent().trim());
							booking_details.seatlist.add(hQ8mjV1V.getFirstChild().getTextContent().trim());
							GfpQawiU = hQ8mjV1V.getElementsByTagName(sourcenws);
							JJEgmcFD = (Element) GfpQawiU.item(0);
							while (!JJEgmcFD.getNodeName().equals(destnnws)) {
								JJEgmcFD.setTextContent("0");
								JJEgmcFD = (Element) JJEgmcFD.getNextSibling();
							}
							if (TJafIPTI != 0) {
								dGXtvcHS--;
								TJafIPTI--;
							}
							System.out.println(
									"desttillcnt=" + dGXtvcHS + " spdes = " + dGXtvcHS + "initflg =" + eND3ans2);
							if (TJafIPTI == 0 && eND3ans2 == true) {
								IXgY2A9l = yrUxvwL0 - K7C6cRlV;
								OfIqEG4M = 1 + IXgY2A9l;
								eND3ans2 = false;
								hQ8mjV1V = (Element) hQ8mjV1V.getParentNode().getFirstChild();
							}
						}
						K7C6cRlV -= CHESoO79;
						Z0iGq0d7 -= CHESoO79;
						number_of_tickets_rem = 0;
						if (!firsttime)
							conn.rollback(SwLiP2GM);
						String y33lwBwf = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL modify do replace value of ";
						y33lwBwf += "$new/coach_status/class[@name=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + zvZGViUM + "\"]/" + destnnws + "/@" + destnnws + "TILL"
								+ " with \"" + dGXtvcHS + "\" ";
						y33lwBwf += " return  $new')  where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "' ";
						System.out.println(y33lwBwf);
						mCqBbKAT = conn.createStatement();
						int v6bun6SR = mCqBbKAT.executeUpdate(y33lwBwf);
						if (v6bun6SR > 0)
							System.out.println("update avail success");
						y33lwBwf = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL  modify do ";
						y33lwBwf += " replace value of $new/coach_status/class[@name=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + zvZGViUM + "\"]/" + sourcenws + " with \"" + K7C6cRlV + "\"";
						y33lwBwf += " return  $new')  where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "' ";
						System.out.println(y33lwBwf);
						mCqBbKAT = conn.createStatement();
						v6bun6SR = mCqBbKAT.executeUpdate(y33lwBwf);
						if (v6bun6SR > 0)
							System.out.println("update avail success");
						r3Idbc8Q = new StringWriter();
						vDg4XIPb = new XMLSerializer(r3Idbc8Q, br1HxdfO);
						vDg4XIPb.serialize(kh1uBgqV);
						String sLQ9FBn4 = "update hp_administrator.book_tickets set SEAT = xmlquery( 'transform copy $new := $SEAT ";
						sLQ9FBn4 += " modify do replace $new/status/class[@type=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + zvZGViUM + "\"] with " + r3Idbc8Q.toString();
						sLQ9FBn4 += " return $new') where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "'  ";
						System.out.println(sLQ9FBn4);
						hE1bsebO = conn.createStatement();
						v6bun6SR = hE1bsebO.executeUpdate(sLQ9FBn4);
						if (v6bun6SR > 0)
							System.out.println("update seat success");
						String g35b5GZX = "";
						if (useragent)
							g35b5GZX = "agent";
						else
							g35b5GZX = "user";
						y33lwBwf = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL modify do replace value of ";
						y33lwBwf += "$new/coach_status/class[@name=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + zvZGViUM + "\"]/" + destnnws + "/@" + g35b5GZX + "till"
								+ " with \"" + TJafIPTI + "\" ";
						y33lwBwf += " return  $new')  where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "' ";
						System.out.println(y33lwBwf);
						mCqBbKAT = conn.createStatement();
						v6bun6SR = mCqBbKAT.executeUpdate(y33lwBwf);
						if (v6bun6SR > 0)
							System.out.println("update " + g35b5GZX + " success");
						y33lwBwf = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL  modify do ";
						y33lwBwf += " replace value of $new/coach_status/class[@name=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + zvZGViUM + "\"]/" + sourcenws + "/@" + g35b5GZX + " with \""
								+ Z0iGq0d7 + "\"";
						y33lwBwf += " return  $new')  where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "' ";
						System.out.println(y33lwBwf);
						mCqBbKAT = conn.createStatement();
						v6bun6SR = mCqBbKAT.executeUpdate(y33lwBwf);
						if (v6bun6SR > 0)
							System.out.println("update " + g35b5GZX + " success");
						break;
					} else if (booking_details.getNoOfPersons() > TJafIPTI && TJafIPTI == 0
							&& booking_details.getNoOfPersons() <= Z0iGq0d7) {
						IXgY2A9l = yrUxvwL0 - K7C6cRlV;
						OfIqEG4M = 1 + IXgY2A9l;
						naIcAGk4 = 0;
						boolean TEhNgCCb = true;
						NodeList BffCdaSt = rPqsaYfi.getElementsByTagName("seat");
						hQ8mjV1V = (Element) BffCdaSt.item(0);
						coach.clear();
						seatno.clear();
						booking_details.coachlist.clear();
						booking_details.seatlist.clear();
						for (naIcAGk4 = 0; naIcAGk4 < booking_details.getNoOfPersons(); naIcAGk4++) {
							coach.add(zvZGViUM);
							booking_details.coachlist.add(zvZGViUM);
							while (Integer.parseInt(hQ8mjV1V.getFirstChild().getTextContent().trim()) < OfIqEG4M) {
								hQ8mjV1V = (Element) hQ8mjV1V.getNextSibling();
							}
							OfIqEG4M++;
							System.out.println(hQ8mjV1V.getFirstChild().getTextContent().trim());
							seatno.add(hQ8mjV1V.getFirstChild().getTextContent().trim());
							booking_details.seatlist.add(hQ8mjV1V.getFirstChild().getTextContent().trim());
							BffCdaSt = hQ8mjV1V.getElementsByTagName(sourcenws);
							JJEgmcFD = (Element) BffCdaSt.item(0);
							while (!JJEgmcFD.getNodeName().equals(destnnws)) {
								JJEgmcFD.setTextContent("0");
								JJEgmcFD = (Element) JJEgmcFD.getNextSibling();
							}
							System.out.println(
									"desttillcnt=" + dGXtvcHS + " spdes = " + dGXtvcHS + "initflg =" + TEhNgCCb);
						}
						K7C6cRlV -= booking_details.getNoOfPersons();
						Z0iGq0d7 -= booking_details.getNoOfPersons();
						;
						number_of_tickets_rem = 0;
						if (!firsttime)
							conn.rollback(SwLiP2GM);
						String h6s2JweW = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL  modify do ";
						h6s2JweW += " replace value of $new/coach_status/class[@name=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + zvZGViUM + "\"]/" + sourcenws + " with \"" + K7C6cRlV + "\"";
						h6s2JweW += " return  $new')  where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "' ";
						System.out.println(h6s2JweW);
						mCqBbKAT = conn.createStatement();
						int obYTmMCB = mCqBbKAT.executeUpdate(h6s2JweW);
						if (obYTmMCB > 0)
							System.out.println("update avail success");
						r3Idbc8Q = new StringWriter();
						vDg4XIPb = new XMLSerializer(r3Idbc8Q, br1HxdfO);
						vDg4XIPb.serialize(kh1uBgqV);
						String aAp1lcmv = "update hp_administrator.book_tickets set SEAT = xmlquery( 'transform copy $new := $SEAT ";
						aAp1lcmv += " modify do replace $new/status/class[@type=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + zvZGViUM + "\"] with " + r3Idbc8Q.toString();
						aAp1lcmv += " return $new') where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "'  ";
						System.out.println(aAp1lcmv);
						hE1bsebO = conn.createStatement();
						obYTmMCB = hE1bsebO.executeUpdate(aAp1lcmv);
						if (obYTmMCB > 0)
							System.out.println("update seat success");
						String yq0hmYay = "";
						if (useragent)
							yq0hmYay = "agent";
						else
							yq0hmYay = "user";
						h6s2JweW = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL  modify do ";
						h6s2JweW += " replace value of $new/coach_status/class[@name=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + zvZGViUM + "\"]/" + sourcenws + "/@" + yq0hmYay + " with \""
								+ Z0iGq0d7 + "\"";
						h6s2JweW += " return  $new')  where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "' ";
						System.out.println(h6s2JweW);
						mCqBbKAT = conn.createStatement();
						obYTmMCB = mCqBbKAT.executeUpdate(h6s2JweW);
						if (obYTmMCB > 0)
							System.out.println("update " + yq0hmYay + " success");
						break;
					}
					NodeList TFoTJndj = rPqsaYfi.getElementsByTagName("seat");
					hQ8mjV1V = (Element) TFoTJndj.item(0);
					OfIqEG4M = 1;
					String htj9BTHK = "";
					if (useragent)
						htj9BTHK = "agent";
					else
						htj9BTHK = "user";
					while (Z0iGq0d7 + TJafIPTI > 0 && number_of_tickets_rem > 0) {
						if (firsttime) {
							SwLiP2GM = conn.setSavepoint();
							firsttime = false;
						}
						U3A5O4Vr = true;
						if (TJafIPTI > 0) {
							OfIqEG4M = BlpAQzOw - dGXtvcHS + 1;
							dGXtvcHS--;
							TJafIPTI--;
							String z6NCGPzT = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL modify do replace value of ";
							z6NCGPzT += "$new/coach_status/class[@name=\"" + booking_details.getTclass()
									+ "\"]/coach[@number=\"" + zvZGViUM + "\"]/" + destnnws + "/@" + destnnws + "TILL"
									+ " with \"" + dGXtvcHS + "\" ";
							z6NCGPzT += " return  $new')  where train_no like '" + booking_details.getTrain_no()
									+ "' and date = '" + booking_details.getDate() + "' ";
							mCqBbKAT = conn.createStatement();
							mCqBbKAT.executeUpdate(z6NCGPzT);
							z6NCGPzT = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL modify do replace value of ";
							z6NCGPzT += "$new/coach_status/class[@name=\"" + booking_details.getTclass()
									+ "\"]/coach[@number=\"" + zvZGViUM + "\"]/" + destnnws + "/@" + htj9BTHK + "till"
									+ " with \"" + TJafIPTI + "\" ";
							z6NCGPzT += " return  $new')  where train_no like '" + booking_details.getTrain_no()
									+ "' and date = '" + booking_details.getDate() + "' ";
							mCqBbKAT = conn.createStatement();
							mCqBbKAT.executeUpdate(z6NCGPzT);
						} else if (TJafIPTI == 0) {
							IXgY2A9l = yrUxvwL0 - K7C6cRlV;
							OfIqEG4M = 1 + IXgY2A9l;
							K7C6cRlV--;
							Z0iGq0d7--;
							String W1C34LGA = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL  modify do ";
							W1C34LGA += " replace value of $new/coach_status/class[@name=\""
									+ booking_details.getTclass() + "\"]/coach[@number=\"" + zvZGViUM + "\"]/"
									+ sourcenws + " with \"" + K7C6cRlV + "\"";
							W1C34LGA += " return  $new')  where train_no like '" + booking_details.getTrain_no()
									+ "' and date = '" + booking_details.getDate() + "' ";
							mCqBbKAT = conn.createStatement();
							mCqBbKAT.executeUpdate(W1C34LGA);
							W1C34LGA = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL  modify do ";
							W1C34LGA += " replace value of $new/coach_status/class[@name=\""
									+ booking_details.getTclass() + "\"]/coach[@number=\"" + zvZGViUM + "\"]/"
									+ sourcenws + "/@" + htj9BTHK + " with \"" + Z0iGq0d7 + "\"";
							W1C34LGA += " return  $new')  where train_no like '" + booking_details.getTrain_no()
									+ "' and date = '" + booking_details.getDate() + "' ";
							mCqBbKAT = conn.createStatement();
							mCqBbKAT.executeUpdate(W1C34LGA);
						}
						while (Integer.parseInt(hQ8mjV1V.getFirstChild().getTextContent().trim()) < OfIqEG4M) {
							hQ8mjV1V = (Element) hQ8mjV1V.getNextSibling();
						}
						TFoTJndj = hQ8mjV1V.getElementsByTagName(sourcenws);
						JJEgmcFD = (Element) TFoTJndj.item(0);
						while (!JJEgmcFD.getNodeName().equals(destnnws)) {
							JJEgmcFD.setTextContent("0");
							JJEgmcFD = (Element) JJEgmcFD.getNextSibling();
						}
						coach.add(zvZGViUM);
						booking_details.coachlist.add(zvZGViUM);
						naIcAGk4++;
						number_of_tickets_rem--;
					}
					if (U3A5O4Vr) {
						r3Idbc8Q = new StringWriter();
						vDg4XIPb = new XMLSerializer(r3Idbc8Q, br1HxdfO);
						vDg4XIPb.serialize(kh1uBgqV);
						String EGlg1sah = "update hp_administrator.book_tickets set SEAT = xmlquery( 'transform copy $new := $SEAT ";
						EGlg1sah += " modify do replace $new/status/class[@type=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + zvZGViUM + "\"] with " + r3Idbc8Q.toString();
						EGlg1sah += " return $new') where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "'  ";
						hE1bsebO = conn.createStatement();
						hE1bsebO.executeUpdate(EGlg1sah);
					}
				} else if (!XKcCE8TT.equals(sourcenws) && NfV6aWm0.equals(destnnws)) {
					System.out.println("case 3");
					NodeList ypGlkx3F = U6jc9Urq.getElementsByTagName(sourcenws);
					Element qvpxYNv6 = (Element) ypGlkx3F.item(0);
					xh0qzZui = qvpxYNv6.getTextContent();
					System.out.println(xh0qzZui);
					CR0wS6Db = Integer.parseInt(xh0qzZui.trim());
					if (useragent)
						WkRhfchJ = qvpxYNv6.getAttribute("agent");
					else
						WkRhfchJ = qvpxYNv6.getAttribute("user");
					System.out.println(WkRhfchJ);
					NErWFyLd = Integer.parseInt(WkRhfchJ.trim());
					TSBbNLst = qvpxYNv6.getAttribute(sourcenws + "TILL");
					System.out.println(TSBbNLst);
					kowGjaQa = Integer.parseInt(TSBbNLst.trim());
					HGa88hIt = qvpxYNv6.getAttribute(sourcenws);
					System.out.println(HGa88hIt);
					yrUxvwL0 = Integer.parseInt(HGa88hIt.trim());
					OfIqEG4M = BlpAQzOw - kowGjaQa + 1;
					xzihFFzL = yrUxvwL0;
					IXgY2A9l = yrUxvwL0 - CR0wS6Db;
					OfIqEG4M += IXgY2A9l;
					xzihFFzL -= IXgY2A9l;
					Element fLvTRMbQ, dmUGsp9e;
					NodeList Sh9dvIIU = rPqsaYfi.getElementsByTagName("seat");
					fLvTRMbQ = (Element) Sh9dvIIU.item(0);
					if (booking_details.getNoOfPersons() <= CR0wS6Db && booking_details.getNoOfPersons() <= NErWFyLd) {
						coach.clear();
						seatno.clear();
						booking_details.coachlist.clear();
						booking_details.seatlist.clear();
						for (naIcAGk4 = 0; naIcAGk4 < booking_details.getNoOfPersons(); naIcAGk4++) {
							coach.add(zvZGViUM);
							booking_details.coachlist.add(zvZGViUM);
							while (Integer.parseInt(fLvTRMbQ.getFirstChild().getTextContent().trim()) < OfIqEG4M) {
								fLvTRMbQ = (Element) fLvTRMbQ.getNextSibling();
							}
							OfIqEG4M++;
							System.out.println(fLvTRMbQ.getFirstChild().getTextContent().trim());
							seatno.add(fLvTRMbQ.getFirstChild().getTextContent().trim());
							booking_details.seatlist.add(fLvTRMbQ.getFirstChild().getTextContent().trim());
							Sh9dvIIU = fLvTRMbQ.getElementsByTagName(sourcenws);
							dmUGsp9e = (Element) Sh9dvIIU.item(0);
							while (!dmUGsp9e.getNodeName().equals(destnnws)) {
								dmUGsp9e.setTextContent("0");
								dmUGsp9e = (Element) dmUGsp9e.getNextSibling();
							}
						}
						number_of_tickets_rem = 0;
						CR0wS6Db -= booking_details.getNoOfPersons();
						NErWFyLd -= booking_details.getNoOfPersons();
						String HwItMRpZ = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL  modify do ";
						HwItMRpZ += " replace value of $new/coach_status/class[@name=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + zvZGViUM + "\"]/" + sourcenws + " with \"" + CR0wS6Db + "\"";
						HwItMRpZ += " return  $new')  where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "' ";
						mCqBbKAT = conn.createStatement();
						mCqBbKAT.executeUpdate(HwItMRpZ);
						r3Idbc8Q = new StringWriter();
						vDg4XIPb = new XMLSerializer(r3Idbc8Q, br1HxdfO);
						vDg4XIPb.serialize(kh1uBgqV);
						String tt9sZUdT = "update hp_administrator.book_tickets set SEAT = xmlquery( 'transform copy $new := $SEAT ";
						tt9sZUdT += " modify do replace $new/status/class[@type=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + zvZGViUM + "\"] with " + r3Idbc8Q.toString();
						tt9sZUdT += " return $new') where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "'  ";
						hE1bsebO = conn.createStatement();
						hE1bsebO.executeUpdate(tt9sZUdT);
						String K86Be3Jd = "";
						if (useragent)
							K86Be3Jd = "agent";
						else
							K86Be3Jd = "user";
						HwItMRpZ = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL  modify do ";
						HwItMRpZ += " replace value of $new/coach_status/class[@name=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + zvZGViUM + "\"]/" + sourcenws + "/@" + K86Be3Jd + " with \""
								+ NErWFyLd + "\"";
						HwItMRpZ += " return  $new')  where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "' ";
						mCqBbKAT = conn.createStatement();
						mCqBbKAT.executeUpdate(HwItMRpZ);
						break;
					}
					while (CR0wS6Db > 0 && NErWFyLd > 0 && number_of_tickets_rem > 0) {
						if (firsttime) {
							SwLiP2GM = conn.setSavepoint();
							firsttime = false;
						}
						U3A5O4Vr = true;
						coach.add(zvZGViUM);
						booking_details.coachlist.add(zvZGViUM);
						naIcAGk4++;
						number_of_tickets_rem--;
						CR0wS6Db--;
						NErWFyLd--;
						while (Integer.parseInt(fLvTRMbQ.getFirstChild().getTextContent().trim()) < OfIqEG4M) {
							fLvTRMbQ = (Element) fLvTRMbQ.getNextSibling();
						}
						OfIqEG4M++;
						System.out.println(fLvTRMbQ.getFirstChild().getTextContent().trim());
						seatno.add(fLvTRMbQ.getFirstChild().getTextContent().trim());
						booking_details.seatlist.add(fLvTRMbQ.getFirstChild().getTextContent().trim());
						Sh9dvIIU = fLvTRMbQ.getElementsByTagName(sourcenws);
						dmUGsp9e = (Element) Sh9dvIIU.item(0);
						while (!dmUGsp9e.getNodeName().equals(destnnws)) {
							dmUGsp9e.setTextContent("0");
							dmUGsp9e = (Element) dmUGsp9e.getNextSibling();
						}
						String nWfBUdtD = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL  modify do ";
						nWfBUdtD += " replace value of $new/coach_status/class[@name=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + zvZGViUM + "\"]/" + sourcenws + " with \"" + CR0wS6Db + "\"";
						nWfBUdtD += " return  $new')  where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "' ";
						System.out.println(nWfBUdtD);
						mCqBbKAT = conn.createStatement();
						mCqBbKAT.executeUpdate(nWfBUdtD);
						String fUFoQIa9 = "";
						if (useragent)
							fUFoQIa9 = "agent";
						else
							fUFoQIa9 = "user";
						nWfBUdtD = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL  modify do ";
						nWfBUdtD += " replace value of $new/coach_status/class[@name=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + zvZGViUM + "\"]/" + sourcenws + "/@" + fUFoQIa9 + " with \""
								+ NErWFyLd + "\"";
						nWfBUdtD += " return  $new')  where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "' ";
						System.out.println(nWfBUdtD);
						mCqBbKAT = conn.createStatement();
						mCqBbKAT.executeUpdate(nWfBUdtD);
					}
					if (U3A5O4Vr) {
						r3Idbc8Q = new StringWriter();
						vDg4XIPb = new XMLSerializer(r3Idbc8Q, br1HxdfO);
						vDg4XIPb.serialize(kh1uBgqV);
						String tsk0yHjz = "update hp_administrator.book_tickets set SEAT = xmlquery( 'transform copy $new := $SEAT ";
						tsk0yHjz += " modify do replace $new/status/class[@type=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + zvZGViUM + "\"] with " + r3Idbc8Q.toString();
						tsk0yHjz += " return $new') where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "'  ";
						System.out.println("!@#------->" + tsk0yHjz);
						hE1bsebO = conn.createStatement();
					}
				} else if (!XKcCE8TT.equals(sourcenws) && !NfV6aWm0.equals(destnnws)) {
					System.out.println("case 4");
					HGa88hIt = yWYgf6zy.getAttribute(sourcenws);
					System.out.println(HGa88hIt);
					yrUxvwL0 = Integer.parseInt(HGa88hIt.trim());
					Element Atcadz5K, j3P4dy3W;
					NodeList MaMpxPUz = U6jc9Urq.getElementsByTagName(sourcenws);
					Element P1K8Xb9e = (Element) MaMpxPUz.item(0);
					xh0qzZui = P1K8Xb9e.getTextContent();
					Integer O9r00pgg = Integer.parseInt(xh0qzZui.trim());
					MaMpxPUz = U6jc9Urq.getElementsByTagName(destnnws);
					P1K8Xb9e = (Element) MaMpxPUz.item(0);
					xh0qzZui = P1K8Xb9e.getAttribute(destnnws + "TILL");
					Integer TT15Z8Xa = Integer.parseInt(xh0qzZui.trim());
					String t65A5iF4 = "", nRHXVIyH = "";
					if (useragent) {
						t65A5iF4 = yWYgf6zy.getAttribute("agent");
						nRHXVIyH = P1K8Xb9e.getAttribute("agenttill");
					} else {
						t65A5iF4 = yWYgf6zy.getAttribute("user");
						nRHXVIyH = P1K8Xb9e.getAttribute("usertill");
					}
					Integer F8MQvK8T = Integer.parseInt(nRHXVIyH.trim());
					Integer MBBIMlOe = Integer.parseInt(t65A5iF4.trim());
					NodeList V3iEYsb9 = rPqsaYfi.getElementsByTagName("seat");
					Atcadz5K = (Element) V3iEYsb9.item(0);
					boolean wEsQ65KE = true;
					if (booking_details.getNoOfPersons() <= F8MQvK8T) {
						OfIqEG4M = BlpAQzOw - TT15Z8Xa + 1;
						xzihFFzL = TT15Z8Xa;
						coach.clear();
						seatno.clear();
						booking_details.coachlist.clear();
						booking_details.seatlist.clear();
						for (naIcAGk4 = 0; naIcAGk4 < booking_details.getNoOfPersons(); naIcAGk4++) {
							coach.add(zvZGViUM);
							booking_details.coachlist.add(zvZGViUM);
							while (Integer.parseInt(Atcadz5K.getFirstChild().getTextContent().trim()) < OfIqEG4M) {
								Atcadz5K = (Element) Atcadz5K.getNextSibling();
							}
							OfIqEG4M++;
							System.out.println(Atcadz5K.getFirstChild().getTextContent().trim());
							seatno.add(Atcadz5K.getFirstChild().getTextContent().trim());
							booking_details.seatlist.add(Atcadz5K.getFirstChild().getTextContent().trim());
							V3iEYsb9 = Atcadz5K.getElementsByTagName(sourcenws);
							j3P4dy3W = (Element) V3iEYsb9.item(0);
							while (!j3P4dy3W.getNodeName().equals(destnnws)) {
								j3P4dy3W.setTextContent("0");
								j3P4dy3W = (Element) j3P4dy3W.getNextSibling();
							}
						}
						number_of_tickets_rem = 0;
						TT15Z8Xa -= booking_details.getNoOfPersons();
						F8MQvK8T -= booking_details.getNoOfPersons();
						if (!firsttime)
							conn.rollback(SwLiP2GM);
						String h2XsYWwA = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL modify do replace value of ";
						h2XsYWwA += "$new/coach_status/class[@name=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + zvZGViUM + "\"]/" + destnnws + "/@" + destnnws + "TILL"
								+ " with \"" + TT15Z8Xa + "\" ";
						h2XsYWwA += " return  $new')  where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "' ";
						mCqBbKAT = conn.createStatement();
						mCqBbKAT.executeUpdate(h2XsYWwA);
						r3Idbc8Q = new StringWriter();
						vDg4XIPb = new XMLSerializer(r3Idbc8Q, br1HxdfO);
						vDg4XIPb.serialize(kh1uBgqV);
						String xfC5hae9 = "update hp_administrator.book_tickets set SEAT = xmlquery( 'transform copy $new := $SEAT ";
						xfC5hae9 += " modify do replace $new/status/class[@type=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + zvZGViUM + "\"] with " + r3Idbc8Q.toString();
						xfC5hae9 += " return $new') where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "'  ";
						hE1bsebO = conn.createStatement();
						hE1bsebO.executeUpdate(xfC5hae9);
						String PWHT79ws = "";
						if (useragent)
							PWHT79ws = "agent";
						else
							PWHT79ws = "user";
						h2XsYWwA = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL modify do replace value of ";
						h2XsYWwA += "$new/coach_status/class[@name=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + zvZGViUM + "\"]/" + destnnws + "/@" + PWHT79ws + "till"
								+ " with \"" + F8MQvK8T + "\" ";
						h2XsYWwA += " return  $new')  where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "' ";
						mCqBbKAT = conn.createStatement();
						mCqBbKAT.executeUpdate(h2XsYWwA);
						break;
					} else if (booking_details.getNoOfPersons() > F8MQvK8T && F8MQvK8T > 0
							&& booking_details.getNoOfPersons() <= F8MQvK8T + MBBIMlOe) {
						int JP5Yhipj = 0;
						if (booking_details.getNoOfPersons() > F8MQvK8T)
							JP5Yhipj = booking_details.getNoOfPersons() - F8MQvK8T;
						OfIqEG4M = BlpAQzOw - TT15Z8Xa + 1;
						xzihFFzL = TT15Z8Xa;
						coach.clear();
						seatno.clear();
						booking_details.coachlist.clear();
						booking_details.seatlist.clear();
						for (naIcAGk4 = 0; naIcAGk4 < booking_details.getNoOfPersons(); naIcAGk4++) {
							coach.add(zvZGViUM);
							booking_details.coachlist.add(zvZGViUM);
							while (Integer.parseInt(Atcadz5K.getFirstChild().getTextContent().trim()) < OfIqEG4M) {
								Atcadz5K = (Element) Atcadz5K.getNextSibling();
							}
							OfIqEG4M++;
							System.out.println(Atcadz5K.getFirstChild().getTextContent().trim());
							seatno.add(Atcadz5K.getFirstChild().getTextContent().trim());
							booking_details.seatlist.add(Atcadz5K.getFirstChild().getTextContent().trim());
							V3iEYsb9 = Atcadz5K.getElementsByTagName(sourcenws);
							j3P4dy3W = (Element) V3iEYsb9.item(0);
							while (!j3P4dy3W.getNodeName().equals(destnnws)) {
								j3P4dy3W.setTextContent("0");
								j3P4dy3W = (Element) j3P4dy3W.getNextSibling();
							}
							if (F8MQvK8T != 0) {
								TT15Z8Xa--;
								F8MQvK8T--;
							}
							if (F8MQvK8T == 0 && wEsQ65KE == true) {
								IXgY2A9l = yrUxvwL0 - O9r00pgg;
								OfIqEG4M = 1 + IXgY2A9l;
								wEsQ65KE = false;
							}
						}
						O9r00pgg -= JP5Yhipj;
						MBBIMlOe -= JP5Yhipj;
						number_of_tickets_rem = 0;
						if (!firsttime)
							conn.rollback(SwLiP2GM);
						String tRzXIWj0 = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL modify do replace value of ";
						tRzXIWj0 += "$new/coach_status/class[@name=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + zvZGViUM + "\"]/" + destnnws + "/@" + destnnws + "TILL"
								+ " with \"" + TT15Z8Xa + "\" ";
						tRzXIWj0 += " return  $new')  where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "' ";
						mCqBbKAT = conn.createStatement();
						mCqBbKAT.executeUpdate(tRzXIWj0);
						tRzXIWj0 = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL  modify do ";
						tRzXIWj0 += " replace value of $new/coach_status/class[@name=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + zvZGViUM + "\"]/" + sourcenws + " with \"" + O9r00pgg + "\"";
						tRzXIWj0 += " return  $new')  where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "' ";
						mCqBbKAT = conn.createStatement();
						mCqBbKAT.executeUpdate(tRzXIWj0);
						r3Idbc8Q = new StringWriter();
						vDg4XIPb = new XMLSerializer(r3Idbc8Q, br1HxdfO);
						vDg4XIPb.serialize(kh1uBgqV);
						String dCPApjtV = "update hp_administrator.book_tickets set SEAT = xmlquery( 'transform copy $new := $SEAT ";
						dCPApjtV += " modify do replace $new/status/class[@type=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + zvZGViUM + "\"] with " + r3Idbc8Q.toString();
						dCPApjtV += " return $new') where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "'  ";
						hE1bsebO = conn.createStatement();
						hE1bsebO.executeUpdate(dCPApjtV);
						String dp67Itx6 = "";
						if (useragent)
							dp67Itx6 = "agent";
						else
							dp67Itx6 = "user";
						tRzXIWj0 = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL modify do replace value of ";
						tRzXIWj0 += "$new/coach_status/class[@name=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + zvZGViUM + "\"]/" + destnnws + "/@" + dp67Itx6 + "till"
								+ " with \"" + F8MQvK8T + "\" ";
						tRzXIWj0 += " return  $new')  where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "' ";
						mCqBbKAT = conn.createStatement();
						mCqBbKAT.executeUpdate(tRzXIWj0);
						tRzXIWj0 = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL  modify do ";
						tRzXIWj0 += " replace value of $new/coach_status/class[@name=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + zvZGViUM + "\"]/" + sourcenws + "/@" + dp67Itx6 + " with \""
								+ MBBIMlOe + "\"";
						tRzXIWj0 += " return  $new')  where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "' ";
						mCqBbKAT = conn.createStatement();
						mCqBbKAT.executeUpdate(tRzXIWj0);
						break;
					} else if (F8MQvK8T == 0 && booking_details.getNoOfPersons() <= MBBIMlOe) {
						IXgY2A9l = yrUxvwL0 - O9r00pgg;
						OfIqEG4M = 1 + IXgY2A9l;
						coach.clear();
						seatno.clear();
						booking_details.coachlist.clear();
						booking_details.seatlist.clear();
						for (naIcAGk4 = 0; naIcAGk4 < booking_details.getNoOfPersons(); naIcAGk4++) {
							coach.add(zvZGViUM);
							booking_details.coachlist.add(zvZGViUM);
							while (Integer.parseInt(Atcadz5K.getFirstChild().getTextContent().trim()) < OfIqEG4M) {
								Atcadz5K = (Element) Atcadz5K.getNextSibling();
							}
							OfIqEG4M++;
							System.out.println(Atcadz5K.getFirstChild().getTextContent().trim());
							seatno.add(Atcadz5K.getFirstChild().getTextContent().trim());
							booking_details.seatlist.add(Atcadz5K.getFirstChild().getTextContent().trim());
							V3iEYsb9 = Atcadz5K.getElementsByTagName(sourcenws);
							j3P4dy3W = (Element) V3iEYsb9.item(0);
							while (!j3P4dy3W.getNodeName().equals(destnnws)) {
								j3P4dy3W.setTextContent("0");
								j3P4dy3W = (Element) j3P4dy3W.getNextSibling();
							}
						}
						O9r00pgg -= booking_details.getNoOfPersons();
						MBBIMlOe -= booking_details.getNoOfPersons();
						number_of_tickets_rem = 0;
						if (!firsttime)
							conn.rollback(SwLiP2GM);
						String FnLnTM84 = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL  modify do ";
						FnLnTM84 += " replace value of $new/coach_status/class[@name=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + zvZGViUM + "\"]/" + sourcenws + " with \"" + O9r00pgg + "\"";
						FnLnTM84 += " return  $new')  where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "' ";
						mCqBbKAT = conn.createStatement();
						mCqBbKAT.executeUpdate(FnLnTM84);
						r3Idbc8Q = new StringWriter();
						vDg4XIPb = new XMLSerializer(r3Idbc8Q, br1HxdfO);
						vDg4XIPb.serialize(kh1uBgqV);
						String VrcanNM6 = "update hp_administrator.book_tickets set SEAT = xmlquery( 'transform copy $new := $SEAT ";
						VrcanNM6 += " modify do replace $new/status/class[@type=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + zvZGViUM + "\"] with " + r3Idbc8Q.toString();
						VrcanNM6 += " return $new') where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "'  ";
						hE1bsebO = conn.createStatement();
						hE1bsebO.executeUpdate(VrcanNM6);
						String aIJJO2Im = "";
						if (useragent)
							aIJJO2Im = "agent";
						else
							aIJJO2Im = "user";
						FnLnTM84 = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL  modify do ";
						FnLnTM84 += " replace value of $new/coach_status/class[@name=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + zvZGViUM + "\"]/" + sourcenws + "/@" + aIJJO2Im + " with \""
								+ MBBIMlOe + "\"";
						FnLnTM84 += " return  $new')  where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "' ";
						mCqBbKAT = conn.createStatement();
						mCqBbKAT.executeUpdate(FnLnTM84);
						break;
					}
					OfIqEG4M = 1;
					String PVyhXynt = "";
					if (useragent)
						PVyhXynt = "agent";
					else
						PVyhXynt = "user";
					while (MBBIMlOe + F8MQvK8T > 0 && number_of_tickets_rem > 0) {
						if (firsttime) {
							SwLiP2GM = conn.setSavepoint();
							firsttime = false;
						}
						U3A5O4Vr = true;
						if (F8MQvK8T > 0) {
							OfIqEG4M = BlpAQzOw - TT15Z8Xa + 1;
							TT15Z8Xa--;
							F8MQvK8T--;
							String UUODqGFY = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL modify do replace value of ";
							UUODqGFY += "$new/coach_status/class[@name=\"" + booking_details.getTclass()
									+ "\"]/coach[@number=\"" + zvZGViUM + "\"]/" + destnnws + "/@" + destnnws + "TILL"
									+ " with \"" + TT15Z8Xa + "\" ";
							UUODqGFY += " return  $new')  where train_no like '" + booking_details.getTrain_no()
									+ "' and date = '" + booking_details.getDate() + "' ";
							mCqBbKAT = conn.createStatement();
							mCqBbKAT.executeUpdate(UUODqGFY);
							UUODqGFY = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL modify do replace value of ";
							UUODqGFY += "$new/coach_status/class[@name=\"" + booking_details.getTclass()
									+ "\"]/coach[@number=\"" + zvZGViUM + "\"]/" + destnnws + "/@" + PVyhXynt + "till"
									+ " with \"" + F8MQvK8T + "\" ";
							UUODqGFY += " return  $new')  where train_no like '" + booking_details.getTrain_no()
									+ "' and date = '" + booking_details.getDate() + "' ";
							mCqBbKAT = conn.createStatement();
							mCqBbKAT.executeUpdate(UUODqGFY);
						} else if (F8MQvK8T == 0) {
							IXgY2A9l = yrUxvwL0 - O9r00pgg;
							OfIqEG4M = 1 + IXgY2A9l;
							O9r00pgg--;
							MBBIMlOe--;
							String qDVB8bUB = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL  modify do ";
							qDVB8bUB += " replace value of $new/coach_status/class[@name=\""
									+ booking_details.getTclass() + "\"]/coach[@number=\"" + zvZGViUM + "\"]/"
									+ sourcenws + "/@" + PVyhXynt + " with \"" + O9r00pgg + "\"";
							qDVB8bUB += " return  $new')  where train_no like '" + booking_details.getTrain_no()
									+ "' and date = '" + booking_details.getDate() + "' ";
							mCqBbKAT = conn.createStatement();
							mCqBbKAT.executeUpdate(qDVB8bUB);
							qDVB8bUB = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL  modify do ";
							qDVB8bUB += " replace value of $new/coach_status/class[@name=\""
									+ booking_details.getTclass() + "\"]/coach[@number=\"" + zvZGViUM + "\"]/"
									+ sourcenws + " with \"" + MBBIMlOe + "\"";
							qDVB8bUB += " return  $new')  where train_no like '" + booking_details.getTrain_no()
									+ "' and date = '" + booking_details.getDate() + "' ";
							mCqBbKAT = conn.createStatement();
							mCqBbKAT.executeUpdate(qDVB8bUB);
						}
						while (Integer.parseInt(Atcadz5K.getFirstChild().getTextContent().trim()) < OfIqEG4M) {
							Atcadz5K = (Element) Atcadz5K.getNextSibling();
						}
						V3iEYsb9 = Atcadz5K.getElementsByTagName(sourcenws);
						j3P4dy3W = (Element) V3iEYsb9.item(0);
						while (!j3P4dy3W.getNodeName().equals(destnnws)) {
							j3P4dy3W.setTextContent("0");
							j3P4dy3W = (Element) j3P4dy3W.getNextSibling();
						}
						coach.add(zvZGViUM);
						booking_details.coachlist.add(zvZGViUM);
						naIcAGk4++;
						number_of_tickets_rem--;
					}
					if (U3A5O4Vr) {
						r3Idbc8Q = new StringWriter();
						vDg4XIPb = new XMLSerializer(r3Idbc8Q, br1HxdfO);
						vDg4XIPb.serialize(kh1uBgqV);
						String DZGKU7pC = "update hp_administrator.book_tickets set SEAT = xmlquery( 'transform copy $new := $SEAT ";
						DZGKU7pC += " modify do replace $new/status/class[@type=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + zvZGViUM + "\"] with " + r3Idbc8Q.toString();
						DZGKU7pC += " return $new') where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "'  ";
						hE1bsebO = conn.createStatement();
						hE1bsebO.executeUpdate(DZGKU7pC);
					}
				}
			}
			availfin = true;
		} catch (SQLException fZOZt7RA) {
			conn.rollback();
			fZOZt7RA.printStackTrace();
		} catch (UnsupportedEncodingException AvTkOVBN) {
			conn.rollback();
			AvTkOVBN.printStackTrace();
		} catch (SAXException G8VosEnz) {
			conn.rollback();
			G8VosEnz.printStackTrace();
		} catch (IOException OJinhEpc) {
			conn.rollback();
			OJinhEpc.printStackTrace();
		}
	}

}