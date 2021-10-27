class n9647574 {
	private void FindAvail() throws ParserConfigurationException, SQLException {
		String availsql = "select xmlquery('$c/coach_status/class[@name=\"" + booking_details.getTclass() + "\"]' ";
		Savepoint sp1;
		availsql += "passing hp_administrator.availability.AVAIL as \"c\") ";
		availsql += " from hp_administrator.availability ";
		availsql += " where date = '" + booking_details.getDate() + "' and train_no like '"
				+ booking_details.getTrain_no() + "'";
		System.out.println(availsql);
		String availxml = "";
		String seatxml = "";
		String navailstr = "";
		String nspavailstr = "";
		String currentcoachstr = "";
		Integer srctill, srcavail, srcmax;
		String srctillstr = "", srcavailstr = "", srcmaxstr = "";
		Integer navailcoach;
		String routesrcstr = "", routedeststr = "";
		Integer nspavailcoach, seatstart, seatcnt, alloccnt;
		Statement stavail, stavailupd, stseatupd, stseat;
		PreparedStatement pstseat;
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		ResultSet rsavail, rsseat;
		Document docavail, docseattmp, docseatfin, docseat;
		DocumentBuilder db = dbf.newDocumentBuilder();
		Node n;
		Element rootavail, rootseat;
		try {
			stavail = conn.createStatement();
			sp1 = conn.setSavepoint();
			rsavail = stavail.executeQuery(availsql);
			if (rsavail.next())
				availxml = rsavail.getString(1);
			System.out.println(availxml);
			StringBuffer StringBuffer1 = new StringBuffer(availxml);
			ByteArrayInputStream Bis1 = new ByteArrayInputStream(StringBuffer1.toString().getBytes("UTF-16"));
			StringWriter sw;
			docavail = db.parse(Bis1);
			OutputFormat formatter;
			formatter = new OutputFormat();
			formatter.setPreserveSpace(true);
			formatter.setEncoding("UTF-8");
			formatter.setOmitXMLDeclaration(true);
			rootavail = docavail.getDocumentElement();
			XMLSerializer serializer;
			Element currentcoach, minseat;
			NodeList coachlist = rootavail.getElementsByTagName("coach");
			NodeList nl, nl1;
			Element routesrc, routedest, nextstn, dest, user, agent;
			int tickpos = 0;
			number_of_tickets_rem = booking_details.getNoOfPersons();
			boolean enterloop;
			firsttime = true;
			for (int i = 0; i < coachlist.getLength(); i++) {
				currentcoach = (Element) coachlist.item(i);
				currentcoachstr = currentcoach.getAttribute("number");
				String coachmaxstr = currentcoach.getAttribute("coachmax");
				routesrc = (Element) currentcoach.getFirstChild();
				Integer coachmax = Integer.parseInt(coachmaxstr.trim());
				routedest = (Element) currentcoach.getLastChild();
				routedest = (Element) routedest.getPreviousSibling().getPreviousSibling().getPreviousSibling();
				routesrcstr = routesrc.getNodeName();
				routedeststr = routedest.getNodeName();
				String seatsql = "select xmlquery('$c/status/class[@type=\"" + booking_details.getTclass()
						+ "\"]/coach[@number=\"" + currentcoachstr + "\"]' ";
				seatsql += " passing hp_administrator.book_tickets.SEAT as \"c\") from hp_administrator.book_tickets ";
				seatsql += " where  date = '" + booking_details.getDate() + "' and train_no like '"
						+ booking_details.getTrain_no() + "' ";
				System.out.println("route  :" + sourcenws);
				System.out.println("route  :" + destnnws);
				System.out.println("route src :" + routesrcstr);
				System.out.println("route dest :" + routedeststr);
				System.out.println(seatsql);
				stseat = conn.createStatement();
				rsseat = stseat.executeQuery(seatsql);
				if (rsseat.next())
					seatxml = rsseat.getString(1);
				StringBuffer StringBuffer2 = new StringBuffer(seatxml);
				ByteArrayInputStream Bis2 = new ByteArrayInputStream(StringBuffer2.toString().getBytes("UTF-16"));
				docseat = db.parse(Bis2);
				enterloop = false;
				rootseat = docseat.getDocumentElement();
				if (routesrcstr.equals(sourcenws) && routedeststr.equals(destnnws)) {
					System.out.println("case 1");
					navailstr = routesrc.getTextContent();
					if (useragent)
						nspavailstr = routesrc.getAttribute("agent");
					else
						nspavailstr = routesrc.getAttribute("user");
					navailcoach = Integer.parseInt(navailstr.trim());
					srctillstr = routesrc.getAttribute(sourcenws + "TILL");
					nspavailcoach = Integer.parseInt(nspavailstr.trim());
					srcmaxstr = routesrc.getAttribute(sourcenws);
					srctill = Integer.parseInt(srctillstr.trim());
					srcavailstr = routesrc.getTextContent();
					srcmax = Integer.parseInt(srcmaxstr.trim());
					seatstart = coachmax - srctill + 1;
					srcavail = Integer.parseInt(srcavailstr.trim());
					seatcnt = srcmax;
					alloccnt = srcmax - srcavail;
					seatstart += alloccnt;
					Element seat, stn;
					seatcnt -= alloccnt;
					NodeList nl3 = rootseat.getElementsByTagName("seat");
					seat = (Element) nl3.item(0);
					if (booking_details.getNoOfPersons() <= navailcoach
							&& booking_details.getNoOfPersons() <= nspavailcoach) {
						coach.clear();
						booking_details.coachlist.clear();
						booking_details.seatlist.clear();
						seatno.clear();
						for (tickpos = 0; tickpos < booking_details.getNoOfPersons(); tickpos++) {
							coach.add(currentcoachstr);
							booking_details.coachlist.add(currentcoachstr);
							while (Integer.parseInt(seat.getFirstChild().getTextContent().trim()) < seatstart) {
								seat = (Element) seat.getNextSibling();
							}
							seatstart++;
							System.out.println(seat.getFirstChild().getTextContent().trim());
							seatno.add(seat.getFirstChild().getTextContent().trim());
							booking_details.seatlist.add(seat.getFirstChild().getTextContent().trim());
							nl3 = seat.getElementsByTagName(sourcenws);
							stn = (Element) nl3.item(0);
							while (!stn.getNodeName().equals(destnnws)) {
								stn.setTextContent("0");
								stn = (Element) stn.getNextSibling();
							}
						}
						number_of_tickets_rem = 0;
						navailcoach -= booking_details.getNoOfPersons();
						nspavailcoach -= booking_details.getNoOfPersons();
						String availupdstr = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL  modify do ";
						if (!firsttime)
							conn.rollback(sp1);
						availupdstr += " replace value of $new/coach_status/class[@name=\""
								+ booking_details.getTclass() + "\"]/coach[@number=\"" + currentcoachstr + "\"]/"
								+ sourcenws + " with \"" + navailcoach + "\"";
						availupdstr += " return  $new')  where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "' ";
						stavailupd = conn.createStatement();
						int updvar = stavailupd.executeUpdate(availupdstr);
						sw = new StringWriter();
						if (updvar > 0)
							System.out.println("upda avail success");
						serializer = new XMLSerializer(sw, formatter);
						serializer.serialize(docseat);
						String seatupdstr = "update hp_administrator.book_tickets set SEAT = xmlquery( 'transform copy $new := $SEAT ";
						seatupdstr += " modify do replace $new/status/class[@type=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + currentcoachstr + "\"] with " + sw.toString();
						seatupdstr += " return $new') where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "'  ";
						System.out.println(seatupdstr);
						stseatupd = conn.createStatement();
						updvar = stseatupd.executeUpdate(seatupdstr);
						String sp = "";
						if (updvar > 0)
							System.out.println("upda seat success");
						availupdstr = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL  modify do ";
						if (useragent)
							sp = "agent";
						else
							sp = "user";
						availupdstr += " replace value of $new/coach_status/class[@name=\""
								+ booking_details.getTclass() + "\"]/coach[@number=\"" + currentcoachstr + "\"]/"
								+ sourcenws + "/@" + sp + " with \"" + nspavailcoach + "\"";
						availupdstr += " return  $new')  where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "' ";
						System.out.println(availupdstr);
						stavailupd = conn.createStatement();
						updvar = stavailupd.executeUpdate(availupdstr);
						if (updvar > 0)
							System.out.println("upda" + sp + " success");
						break;
					}
					while (navailcoach > 0 && nspavailcoach > 0 && number_of_tickets_rem > 0) {
						enterloop = true;
						if (firsttime) {
							sp1 = conn.setSavepoint();
							firsttime = false;
						}
						coach.add(currentcoachstr);
						booking_details.coachlist.add(currentcoachstr);
						number_of_tickets_rem--;
						tickpos++;
						nspavailcoach--;
						navailcoach--;
						while (Integer.parseInt(seat.getFirstChild().getTextContent().trim()) < seatstart) {
							seat = (Element) seat.getNextSibling();
						}
						seatstart++;
						System.out.println(seat.getFirstChild().getTextContent().trim());
						seatno.add(seat.getFirstChild().getTextContent().trim());
						booking_details.seatlist.add(seat.getFirstChild().getTextContent().trim());
						nl3 = seat.getElementsByTagName(sourcenws);
						stn = (Element) nl3.item(0);
						String availupdstr = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL  modify do ";
						while (!stn.getNodeName().equals(destnnws)) {
							stn.setTextContent("0");
							stn = (Element) stn.getNextSibling();
						}
						availupdstr += " replace value of $new/coach_status/class[@name=\""
								+ booking_details.getTclass() + "\"]/coach[@number=\"" + currentcoachstr + "\"]/"
								+ sourcenws + " with \"" + navailcoach + "\"";
						availupdstr += " return  $new')  where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "' ";
						stavailupd = conn.createStatement();
						stavailupd.executeUpdate(availupdstr);
						String sp = "";
						availupdstr = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL  modify do ";
						if (useragent)
							sp = "agent";
						else
							sp = "user";
						availupdstr += " replace value of $new/coach_status/class[@name=\""
								+ booking_details.getTclass() + "\"]/coach[@number=\"" + sp + "\"]/" + sourcenws + "/@"
								+ sp + " with \"" + nspavailcoach + "\"";
						availupdstr += " return  $new')  where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "' ";
						stavailupd = conn.createStatement();
						stavailupd.executeUpdate(availupdstr);
					}
					if (enterloop) {
						sw = new StringWriter();
						serializer = new XMLSerializer(sw, formatter);
						serializer.serialize(docseat);
						String seatupdstr = "update hp_administrator.book_tickets set SEAT = xmlquery( 'transform copy $new := $SEAT ";
						seatupdstr += " modify do replace $new/status/class[@type=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + currentcoachstr + "\"] with " + sw.toString();
						seatupdstr += " return $new') where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "'  ";
						stseatupd = conn.createStatement();
						stseatupd.executeUpdate(seatupdstr);
					}
				} else if (routesrcstr.equals(sourcenws) && !routedeststr.equals(destnnws)) {
					System.out.println("case 2");
					String excesssrcstr = routesrc.getTextContent();
					System.out.println(excesssrcstr);
					NodeList nl2 = currentcoach.getElementsByTagName(destnnws);
					Integer excesssrc = Integer.parseInt(excesssrcstr.trim());
					Element e2 = (Element) nl2.item(0);
					String desttillstr = e2.getAttribute(destnnws + "TILL");
					System.out.println(desttillstr);
					srcmaxstr = routesrc.getAttribute(sourcenws);
					Integer desttillcnt = Integer.parseInt(desttillstr.trim());
					System.out.println(srcmaxstr);
					String spexcesssrcstr = "", spdesttillstr = "";
					srcmax = Integer.parseInt(srcmaxstr.trim());
					if (useragent) {
						spexcesssrcstr = routesrc.getAttribute("agent");
						spdesttillstr = e2.getAttribute("agenttill");
					} else {
						spexcesssrcstr = routesrc.getAttribute("user");
						spdesttillstr = e2.getAttribute("usertill");
					}
					System.out.println(spdesttillstr);
					System.out.println(spexcesssrcstr);
					Integer spdesttillcnt = Integer.parseInt(spdesttillstr.trim());
					Element seat, stn;
					Integer spexcesssrc = Integer.parseInt(spexcesssrcstr.trim());
					if (booking_details.getNoOfPersons() <= desttillcnt
							&& booking_details.getNoOfPersons() <= spdesttillcnt) {
						seatstart = coachmax - desttillcnt + 1;
						NodeList nl3 = rootseat.getElementsByTagName("seat");
						seatcnt = desttillcnt;
						seat = (Element) nl3.item(0);
						coach.clear();
						seatno.clear();
						booking_details.coachlist.clear();
						booking_details.seatlist.clear();
						for (tickpos = 0; tickpos < booking_details.getNoOfPersons(); tickpos++) {
							coach.add(currentcoachstr);
							booking_details.coachlist.add(currentcoachstr);
							while (Integer.parseInt(seat.getFirstChild().getTextContent().trim()) < seatstart) {
								seat = (Element) seat.getNextSibling();
							}
							seatstart++;
							System.out.println(seat.getFirstChild().getTextContent().trim());
							seatno.add(seat.getFirstChild().getTextContent().trim());
							booking_details.seatlist.add(seat.getFirstChild().getTextContent().trim());
							nl3 = seat.getElementsByTagName(sourcenws);
							stn = (Element) nl3.item(0);
							while (!stn.getNodeName().equals(destnnws)) {
								stn.setTextContent("0");
								stn = (Element) stn.getNextSibling();
							}
						}
						number_of_tickets_rem = 0;
						desttillcnt -= booking_details.getNoOfPersons();
						spdesttillcnt -= booking_details.getNoOfPersons();
						String availupd = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL modify do replace value of ";
						if (!firsttime)
							conn.rollback(sp1);
						availupd += "$new/coach_status/class[@name=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + currentcoachstr + "\"]/" + destnnws + "/@" + destnnws
								+ "TILL" + " with \"" + desttillcnt + "\" ";
						availupd += " return  $new')  where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "' ";
						System.out.println(availupd);
						stavailupd = conn.createStatement();
						int upst = stavailupd.executeUpdate(availupd);
						sw = new StringWriter();
						if (upst > 0)
							System.out.println("update avail success");
						serializer = new XMLSerializer(sw, formatter);
						serializer.serialize(docseat);
						String seatupdstr = "update hp_administrator.book_tickets set SEAT = xmlquery( 'transform copy $new := $SEAT ";
						seatupdstr += " modify do replace $new/status/class[@type=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + currentcoachstr + "\"] with " + sw.toString();
						seatupdstr += " return $new') where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "'  ";
						System.out.println(seatupdstr);
						stseatupd = conn.createStatement();
						upst = stseatupd.executeUpdate(seatupdstr);
						String sp = "";
						if (upst > 0)
							System.out.println("update seat success");
						availupd = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL modify do replace value of ";
						if (useragent)
							sp = "agent";
						else
							sp = "user";
						availupd += "$new/coach_status/class[@name=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + currentcoachstr + "\"]/" + destnnws + "/@" + sp + "till"
								+ " with \"" + spdesttillcnt + "\" ";
						availupd += " return  $new')  where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "' ";
						System.out.println(availupd);
						stavailupd = conn.createStatement();
						upst = stavailupd.executeUpdate(availupd);
						if (upst > 0)
							System.out.println("update " + sp + " success");
						break;
					} else if (booking_details.getNoOfPersons() > spdesttillcnt && spdesttillcnt > 0
							&& booking_details.getNoOfPersons() <= spdesttillcnt + spexcesssrc) {
						int diff = 0;
						tickpos = 0;
						if (booking_details.getNoOfPersons() > spdesttillcnt)
							diff = booking_details.getNoOfPersons() - spdesttillcnt;
						seatstart = coachmax - desttillcnt + 1;
						boolean initflg = true;
						NodeList nl3 = rootseat.getElementsByTagName("seat");
						seatcnt = desttillcnt;
						seat = (Element) nl3.item(0);
						coach.clear();
						seatno.clear();
						booking_details.coachlist.clear();
						booking_details.seatlist.clear();
						for (tickpos = 0; tickpos < booking_details.getNoOfPersons(); tickpos++) {
							coach.add(currentcoachstr);
							booking_details.coachlist.add(currentcoachstr);
							while (Integer.parseInt(seat.getFirstChild().getTextContent().trim()) < seatstart) {
								seat = (Element) seat.getNextSibling();
							}
							seatstart++;
							System.out.println(seat.getFirstChild().getTextContent().trim());
							seatno.add(seat.getFirstChild().getTextContent().trim());
							booking_details.seatlist.add(seat.getFirstChild().getTextContent().trim());
							nl3 = seat.getElementsByTagName(sourcenws);
							stn = (Element) nl3.item(0);
							if (spdesttillcnt != 0) {
								desttillcnt--;
								spdesttillcnt--;
							}
							while (!stn.getNodeName().equals(destnnws)) {
								stn.setTextContent("0");
								stn = (Element) stn.getNextSibling();
							}
							System.out.println(
									"desttillcnt=" + desttillcnt + " spdes = " + desttillcnt + "initflg =" + initflg);
							if (spdesttillcnt == 0 && initflg == true) {
								alloccnt = srcmax - excesssrc;
								initflg = false;
								seatstart = 1 + alloccnt;
								seat = (Element) seat.getParentNode().getFirstChild();
							}
						}
						excesssrc -= diff;
						number_of_tickets_rem = 0;
						spexcesssrc -= diff;
						String availupd = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL modify do replace value of ";
						if (!firsttime)
							conn.rollback(sp1);
						availupd += "$new/coach_status/class[@name=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + currentcoachstr + "\"]/" + destnnws + "/@" + destnnws
								+ "TILL" + " with \"" + desttillcnt + "\" ";
						availupd += " return  $new')  where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "' ";
						System.out.println(availupd);
						stavailupd = conn.createStatement();
						int upst = stavailupd.executeUpdate(availupd);
						availupd = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL  modify do ";
						if (upst > 0)
							System.out.println("update avail success");
						availupd += " replace value of $new/coach_status/class[@name=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + currentcoachstr + "\"]/" + sourcenws + " with \"" + excesssrc
								+ "\"";
						availupd += " return  $new')  where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "' ";
						System.out.println(availupd);
						stavailupd = conn.createStatement();
						upst = stavailupd.executeUpdate(availupd);
						sw = new StringWriter();
						if (upst > 0)
							System.out.println("update avail success");
						serializer = new XMLSerializer(sw, formatter);
						serializer.serialize(docseat);
						String seatupdstr = "update hp_administrator.book_tickets set SEAT = xmlquery( 'transform copy $new := $SEAT ";
						seatupdstr += " modify do replace $new/status/class[@type=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + currentcoachstr + "\"] with " + sw.toString();
						seatupdstr += " return $new') where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "'  ";
						System.out.println(seatupdstr);
						stseatupd = conn.createStatement();
						upst = stseatupd.executeUpdate(seatupdstr);
						String sp = "";
						if (upst > 0)
							System.out.println("update seat success");
						availupd = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL modify do replace value of ";
						if (useragent)
							sp = "agent";
						else
							sp = "user";
						availupd += "$new/coach_status/class[@name=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + currentcoachstr + "\"]/" + destnnws + "/@" + sp + "till"
								+ " with \"" + spdesttillcnt + "\" ";
						availupd += " return  $new')  where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "' ";
						System.out.println(availupd);
						stavailupd = conn.createStatement();
						upst = stavailupd.executeUpdate(availupd);
						availupd = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL  modify do ";
						if (upst > 0)
							System.out.println("update " + sp + " success");
						availupd += " replace value of $new/coach_status/class[@name=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + currentcoachstr + "\"]/" + sourcenws + "/@" + sp + " with \""
								+ spexcesssrc + "\"";
						availupd += " return  $new')  where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "' ";
						System.out.println(availupd);
						stavailupd = conn.createStatement();
						upst = stavailupd.executeUpdate(availupd);
						if (upst > 0)
							System.out.println("update " + sp + " success");
						break;
					} else if (booking_details.getNoOfPersons() > spdesttillcnt && spdesttillcnt == 0
							&& booking_details.getNoOfPersons() <= spexcesssrc) {
						alloccnt = srcmax - excesssrc;
						tickpos = 0;
						seatstart = 1 + alloccnt;
						NodeList nl3 = rootseat.getElementsByTagName("seat");
						boolean initflg = true;
						seat = (Element) nl3.item(0);
						coach.clear();
						seatno.clear();
						booking_details.coachlist.clear();
						booking_details.seatlist.clear();
						for (tickpos = 0; tickpos < booking_details.getNoOfPersons(); tickpos++) {
							coach.add(currentcoachstr);
							booking_details.coachlist.add(currentcoachstr);
							while (Integer.parseInt(seat.getFirstChild().getTextContent().trim()) < seatstart) {
								seat = (Element) seat.getNextSibling();
							}
							seatstart++;
							System.out.println(seat.getFirstChild().getTextContent().trim());
							seatno.add(seat.getFirstChild().getTextContent().trim());
							booking_details.seatlist.add(seat.getFirstChild().getTextContent().trim());
							nl3 = seat.getElementsByTagName(sourcenws);
							stn = (Element) nl3.item(0);
							while (!stn.getNodeName().equals(destnnws)) {
								stn.setTextContent("0");
								stn = (Element) stn.getNextSibling();
							}
							System.out.println(
									"desttillcnt=" + desttillcnt + " spdes = " + desttillcnt + "initflg =" + initflg);
						}
						excesssrc -= booking_details.getNoOfPersons();
						;
						spexcesssrc -= booking_details.getNoOfPersons();
						number_of_tickets_rem = 0;
						String availupd = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL  modify do ";
						if (!firsttime)
							conn.rollback(sp1);
						availupd += " replace value of $new/coach_status/class[@name=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + currentcoachstr + "\"]/" + sourcenws + " with \"" + excesssrc
								+ "\"";
						availupd += " return  $new')  where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "' ";
						System.out.println(availupd);
						stavailupd = conn.createStatement();
						int upst = stavailupd.executeUpdate(availupd);
						sw = new StringWriter();
						if (upst > 0)
							System.out.println("update avail success");
						serializer = new XMLSerializer(sw, formatter);
						serializer.serialize(docseat);
						String seatupdstr = "update hp_administrator.book_tickets set SEAT = xmlquery( 'transform copy $new := $SEAT ";
						seatupdstr += " modify do replace $new/status/class[@type=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + currentcoachstr + "\"] with " + sw.toString();
						seatupdstr += " return $new') where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "'  ";
						System.out.println(seatupdstr);
						stseatupd = conn.createStatement();
						upst = stseatupd.executeUpdate(seatupdstr);
						String sp = "";
						if (upst > 0)
							System.out.println("update seat success");
						availupd = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL  modify do ";
						if (useragent)
							sp = "agent";
						else
							sp = "user";
						availupd += " replace value of $new/coach_status/class[@name=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + currentcoachstr + "\"]/" + sourcenws + "/@" + sp + " with \""
								+ spexcesssrc + "\"";
						availupd += " return  $new')  where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "' ";
						System.out.println(availupd);
						stavailupd = conn.createStatement();
						upst = stavailupd.executeUpdate(availupd);
						if (upst > 0)
							System.out.println("update " + sp + " success");
						break;
					}
					NodeList nl3 = rootseat.getElementsByTagName("seat");
					seatstart = 1;
					seat = (Element) nl3.item(0);
					String sp = "";
					if (useragent)
						sp = "agent";
					else
						sp = "user";
					while (spexcesssrc + spdesttillcnt > 0 && number_of_tickets_rem > 0) {
						enterloop = true;
						if (firsttime) {
							sp1 = conn.setSavepoint();
							firsttime = false;
						}
						if (spdesttillcnt > 0) {
							seatstart = coachmax - desttillcnt + 1;
							spdesttillcnt--;
							desttillcnt--;
							String availupd = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL modify do replace value of ";
							availupd += "$new/coach_status/class[@name=\"" + booking_details.getTclass()
									+ "\"]/coach[@number=\"" + currentcoachstr + "\"]/" + destnnws + "/@" + destnnws
									+ "TILL" + " with \"" + desttillcnt + "\" ";
							availupd += " return  $new')  where train_no like '" + booking_details.getTrain_no()
									+ "' and date = '" + booking_details.getDate() + "' ";
							stavailupd = conn.createStatement();
							stavailupd.executeUpdate(availupd);
							availupd = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL modify do replace value of ";
							availupd += "$new/coach_status/class[@name=\"" + booking_details.getTclass()
									+ "\"]/coach[@number=\"" + currentcoachstr + "\"]/" + destnnws + "/@" + sp + "till"
									+ " with \"" + spdesttillcnt + "\" ";
							availupd += " return  $new')  where train_no like '" + booking_details.getTrain_no()
									+ "' and date = '" + booking_details.getDate() + "' ";
							stavailupd = conn.createStatement();
							stavailupd.executeUpdate(availupd);
						} else if (spdesttillcnt == 0) {
							alloccnt = srcmax - excesssrc;
							excesssrc--;
							seatstart = 1 + alloccnt;
							String availupd = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL  modify do ";
							spexcesssrc--;
							availupd += " replace value of $new/coach_status/class[@name=\""
									+ booking_details.getTclass() + "\"]/coach[@number=\"" + currentcoachstr + "\"]/"
									+ sourcenws + " with \"" + excesssrc + "\"";
							availupd += " return  $new')  where train_no like '" + booking_details.getTrain_no()
									+ "' and date = '" + booking_details.getDate() + "' ";
							stavailupd = conn.createStatement();
							stavailupd.executeUpdate(availupd);
							availupd = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL  modify do ";
							availupd += " replace value of $new/coach_status/class[@name=\""
									+ booking_details.getTclass() + "\"]/coach[@number=\"" + currentcoachstr + "\"]/"
									+ sourcenws + "/@" + sp + " with \"" + spexcesssrc + "\"";
							availupd += " return  $new')  where train_no like '" + booking_details.getTrain_no()
									+ "' and date = '" + booking_details.getDate() + "' ";
							stavailupd = conn.createStatement();
							stavailupd.executeUpdate(availupd);
						}
						while (Integer.parseInt(seat.getFirstChild().getTextContent().trim()) < seatstart) {
							seat = (Element) seat.getNextSibling();
						}
						nl3 = seat.getElementsByTagName(sourcenws);
						stn = (Element) nl3.item(0);
						while (!stn.getNodeName().equals(destnnws)) {
							stn.setTextContent("0");
							stn = (Element) stn.getNextSibling();
						}
						coach.add(currentcoachstr);
						booking_details.coachlist.add(currentcoachstr);
						number_of_tickets_rem--;
						tickpos++;
					}
					if (enterloop) {
						sw = new StringWriter();
						serializer = new XMLSerializer(sw, formatter);
						serializer.serialize(docseat);
						String seatupdstr = "update hp_administrator.book_tickets set SEAT = xmlquery( 'transform copy $new := $SEAT ";
						seatupdstr += " modify do replace $new/status/class[@type=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + currentcoachstr + "\"] with " + sw.toString();
						seatupdstr += " return $new') where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "'  ";
						stseatupd = conn.createStatement();
						stseatupd.executeUpdate(seatupdstr);
					}
				} else if (!routesrcstr.equals(sourcenws) && routedeststr.equals(destnnws)) {
					System.out.println("case 3");
					NodeList nl2 = currentcoach.getElementsByTagName(sourcenws);
					Element e2 = (Element) nl2.item(0);
					navailstr = e2.getTextContent();
					System.out.println(navailstr);
					if (useragent)
						nspavailstr = e2.getAttribute("agent");
					else
						nspavailstr = e2.getAttribute("user");
					navailcoach = Integer.parseInt(navailstr.trim());
					System.out.println(nspavailstr);
					srctillstr = e2.getAttribute(sourcenws + "TILL");
					nspavailcoach = Integer.parseInt(nspavailstr.trim());
					System.out.println(srctillstr);
					srcmaxstr = e2.getAttribute(sourcenws);
					srctill = Integer.parseInt(srctillstr.trim());
					System.out.println(srcmaxstr);
					seatstart = coachmax - srctill + 1;
					srcmax = Integer.parseInt(srcmaxstr.trim());
					seatcnt = srcmax;
					alloccnt = srcmax - navailcoach;
					seatstart += alloccnt;
					Element seat, stn;
					seatcnt -= alloccnt;
					NodeList nl3 = rootseat.getElementsByTagName("seat");
					seat = (Element) nl3.item(0);
					if (booking_details.getNoOfPersons() <= navailcoach
							&& booking_details.getNoOfPersons() <= nspavailcoach) {
						coach.clear();
						seatno.clear();
						booking_details.coachlist.clear();
						booking_details.seatlist.clear();
						for (tickpos = 0; tickpos < booking_details.getNoOfPersons(); tickpos++) {
							coach.add(currentcoachstr);
							booking_details.coachlist.add(currentcoachstr);
							while (Integer.parseInt(seat.getFirstChild().getTextContent().trim()) < seatstart) {
								seat = (Element) seat.getNextSibling();
							}
							seatstart++;
							System.out.println(seat.getFirstChild().getTextContent().trim());
							seatno.add(seat.getFirstChild().getTextContent().trim());
							booking_details.seatlist.add(seat.getFirstChild().getTextContent().trim());
							nl3 = seat.getElementsByTagName(sourcenws);
							stn = (Element) nl3.item(0);
							while (!stn.getNodeName().equals(destnnws)) {
								stn.setTextContent("0");
								stn = (Element) stn.getNextSibling();
							}
						}
						number_of_tickets_rem = 0;
						navailcoach -= booking_details.getNoOfPersons();
						String availupdstr = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL  modify do ";
						nspavailcoach -= booking_details.getNoOfPersons();
						availupdstr += " replace value of $new/coach_status/class[@name=\""
								+ booking_details.getTclass() + "\"]/coach[@number=\"" + currentcoachstr + "\"]/"
								+ sourcenws + " with \"" + navailcoach + "\"";
						availupdstr += " return  $new')  where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "' ";
						stavailupd = conn.createStatement();
						stavailupd.executeUpdate(availupdstr);
						sw = new StringWriter();
						serializer = new XMLSerializer(sw, formatter);
						serializer.serialize(docseat);
						String seatupdstr = "update hp_administrator.book_tickets set SEAT = xmlquery( 'transform copy $new := $SEAT ";
						seatupdstr += " modify do replace $new/status/class[@type=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + currentcoachstr + "\"] with " + sw.toString();
						seatupdstr += " return $new') where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "'  ";
						stseatupd = conn.createStatement();
						stseatupd.executeUpdate(seatupdstr);
						String sp = "";
						availupdstr = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL  modify do ";
						if (useragent)
							sp = "agent";
						else
							sp = "user";
						availupdstr += " replace value of $new/coach_status/class[@name=\""
								+ booking_details.getTclass() + "\"]/coach[@number=\"" + currentcoachstr + "\"]/"
								+ sourcenws + "/@" + sp + " with \"" + nspavailcoach + "\"";
						availupdstr += " return  $new')  where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "' ";
						stavailupd = conn.createStatement();
						stavailupd.executeUpdate(availupdstr);
						break;
					}
					while (navailcoach > 0 && nspavailcoach > 0 && number_of_tickets_rem > 0) {
						enterloop = true;
						if (firsttime) {
							sp1 = conn.setSavepoint();
							firsttime = false;
						}
						coach.add(currentcoachstr);
						booking_details.coachlist.add(currentcoachstr);
						number_of_tickets_rem--;
						tickpos++;
						nspavailcoach--;
						navailcoach--;
						while (Integer.parseInt(seat.getFirstChild().getTextContent().trim()) < seatstart) {
							seat = (Element) seat.getNextSibling();
						}
						seatstart++;
						System.out.println(seat.getFirstChild().getTextContent().trim());
						seatno.add(seat.getFirstChild().getTextContent().trim());
						booking_details.seatlist.add(seat.getFirstChild().getTextContent().trim());
						nl3 = seat.getElementsByTagName(sourcenws);
						stn = (Element) nl3.item(0);
						String availupdstr = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL  modify do ";
						while (!stn.getNodeName().equals(destnnws)) {
							stn.setTextContent("0");
							stn = (Element) stn.getNextSibling();
						}
						availupdstr += " replace value of $new/coach_status/class[@name=\""
								+ booking_details.getTclass() + "\"]/coach[@number=\"" + currentcoachstr + "\"]/"
								+ sourcenws + " with \"" + navailcoach + "\"";
						availupdstr += " return  $new')  where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "' ";
						System.out.println(availupdstr);
						stavailupd = conn.createStatement();
						stavailupd.executeUpdate(availupdstr);
						String sp = "";
						availupdstr = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL  modify do ";
						if (useragent)
							sp = "agent";
						else
							sp = "user";
						availupdstr += " replace value of $new/coach_status/class[@name=\""
								+ booking_details.getTclass() + "\"]/coach[@number=\"" + currentcoachstr + "\"]/"
								+ sourcenws + "/@" + sp + " with \"" + nspavailcoach + "\"";
						availupdstr += " return  $new')  where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "' ";
						System.out.println(availupdstr);
						stavailupd = conn.createStatement();
						stavailupd.executeUpdate(availupdstr);
					}
					if (enterloop) {
						sw = new StringWriter();
						serializer = new XMLSerializer(sw, formatter);
						serializer.serialize(docseat);
						String seatupdstr = "update hp_administrator.book_tickets set SEAT = xmlquery( 'transform copy $new := $SEAT ";
						seatupdstr += " modify do replace $new/status/class[@type=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + currentcoachstr + "\"] with " + sw.toString();
						seatupdstr += " return $new') where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "'  ";
						System.out.println("!@#------->" + seatupdstr);
						stseatupd = conn.createStatement();
					}
				} else if (!routesrcstr.equals(sourcenws) && !routedeststr.equals(destnnws)) {
					System.out.println("case 4");
					srcmaxstr = routesrc.getAttribute(sourcenws);
					System.out.println(srcmaxstr);
					Element seat, stn;
					srcmax = Integer.parseInt(srcmaxstr.trim());
					NodeList nl2 = currentcoach.getElementsByTagName(sourcenws);
					Element e2 = (Element) nl2.item(0);
					navailstr = e2.getTextContent();
					nl2 = currentcoach.getElementsByTagName(destnnws);
					Integer excesssrc = Integer.parseInt(navailstr.trim());
					e2 = (Element) nl2.item(0);
					navailstr = e2.getAttribute(destnnws + "TILL");
					String spexcesssrcstr = "", spdesttillstr = "";
					Integer desttillcnt = Integer.parseInt(navailstr.trim());
					if (useragent) {
						spexcesssrcstr = routesrc.getAttribute("agent");
						spdesttillstr = e2.getAttribute("agenttill");
					} else {
						spexcesssrcstr = routesrc.getAttribute("user");
						spdesttillstr = e2.getAttribute("usertill");
					}
					Integer spdesttillcnt = Integer.parseInt(spdesttillstr.trim());
					NodeList nl3 = rootseat.getElementsByTagName("seat");
					Integer spexcesssrc = Integer.parseInt(spexcesssrcstr.trim());
					boolean initflg = true;
					seat = (Element) nl3.item(0);
					if (booking_details.getNoOfPersons() <= spdesttillcnt) {
						seatstart = coachmax - desttillcnt + 1;
						seatcnt = desttillcnt;
						coach.clear();
						seatno.clear();
						booking_details.coachlist.clear();
						booking_details.seatlist.clear();
						for (tickpos = 0; tickpos < booking_details.getNoOfPersons(); tickpos++) {
							coach.add(currentcoachstr);
							booking_details.coachlist.add(currentcoachstr);
							while (Integer.parseInt(seat.getFirstChild().getTextContent().trim()) < seatstart) {
								seat = (Element) seat.getNextSibling();
							}
							seatstart++;
							System.out.println(seat.getFirstChild().getTextContent().trim());
							seatno.add(seat.getFirstChild().getTextContent().trim());
							booking_details.seatlist.add(seat.getFirstChild().getTextContent().trim());
							nl3 = seat.getElementsByTagName(sourcenws);
							stn = (Element) nl3.item(0);
							while (!stn.getNodeName().equals(destnnws)) {
								stn.setTextContent("0");
								stn = (Element) stn.getNextSibling();
							}
						}
						number_of_tickets_rem = 0;
						desttillcnt -= booking_details.getNoOfPersons();
						spdesttillcnt -= booking_details.getNoOfPersons();
						String availupd = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL modify do replace value of ";
						if (!firsttime)
							conn.rollback(sp1);
						availupd += "$new/coach_status/class[@name=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + currentcoachstr + "\"]/" + destnnws + "/@" + destnnws
								+ "TILL" + " with \"" + desttillcnt + "\" ";
						availupd += " return  $new')  where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "' ";
						stavailupd = conn.createStatement();
						stavailupd.executeUpdate(availupd);
						sw = new StringWriter();
						serializer = new XMLSerializer(sw, formatter);
						serializer.serialize(docseat);
						String seatupdstr = "update hp_administrator.book_tickets set SEAT = xmlquery( 'transform copy $new := $SEAT ";
						seatupdstr += " modify do replace $new/status/class[@type=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + currentcoachstr + "\"] with " + sw.toString();
						seatupdstr += " return $new') where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "'  ";
						stseatupd = conn.createStatement();
						stseatupd.executeUpdate(seatupdstr);
						String sp = "";
						availupd = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL modify do replace value of ";
						if (useragent)
							sp = "agent";
						else
							sp = "user";
						availupd += "$new/coach_status/class[@name=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + currentcoachstr + "\"]/" + destnnws + "/@" + sp + "till"
								+ " with \"" + spdesttillcnt + "\" ";
						availupd += " return  $new')  where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "' ";
						stavailupd = conn.createStatement();
						stavailupd.executeUpdate(availupd);
						break;
					} else if (booking_details.getNoOfPersons() > spdesttillcnt && spdesttillcnt > 0
							&& booking_details.getNoOfPersons() <= spdesttillcnt + spexcesssrc) {
						int diff = 0;
						seatstart = coachmax - desttillcnt + 1;
						if (booking_details.getNoOfPersons() > spdesttillcnt)
							diff = booking_details.getNoOfPersons() - spdesttillcnt;
						seatcnt = desttillcnt;
						coach.clear();
						seatno.clear();
						booking_details.coachlist.clear();
						booking_details.seatlist.clear();
						for (tickpos = 0; tickpos < booking_details.getNoOfPersons(); tickpos++) {
							coach.add(currentcoachstr);
							booking_details.coachlist.add(currentcoachstr);
							while (Integer.parseInt(seat.getFirstChild().getTextContent().trim()) < seatstart) {
								seat = (Element) seat.getNextSibling();
							}
							seatstart++;
							System.out.println(seat.getFirstChild().getTextContent().trim());
							seatno.add(seat.getFirstChild().getTextContent().trim());
							booking_details.seatlist.add(seat.getFirstChild().getTextContent().trim());
							nl3 = seat.getElementsByTagName(sourcenws);
							stn = (Element) nl3.item(0);
							if (spdesttillcnt != 0) {
								desttillcnt--;
								spdesttillcnt--;
							}
							while (!stn.getNodeName().equals(destnnws)) {
								stn.setTextContent("0");
								stn = (Element) stn.getNextSibling();
							}
							if (spdesttillcnt == 0 && initflg == true) {
								alloccnt = srcmax - excesssrc;
								initflg = false;
								seatstart = 1 + alloccnt;
							}
						}
						excesssrc -= diff;
						number_of_tickets_rem = 0;
						spexcesssrc -= diff;
						String availupd = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL modify do replace value of ";
						if (!firsttime)
							conn.rollback(sp1);
						availupd += "$new/coach_status/class[@name=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + currentcoachstr + "\"]/" + destnnws + "/@" + destnnws
								+ "TILL" + " with \"" + desttillcnt + "\" ";
						availupd += " return  $new')  where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "' ";
						stavailupd = conn.createStatement();
						stavailupd.executeUpdate(availupd);
						availupd = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL  modify do ";
						availupd += " replace value of $new/coach_status/class[@name=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + currentcoachstr + "\"]/" + sourcenws + " with \"" + excesssrc
								+ "\"";
						availupd += " return  $new')  where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "' ";
						stavailupd = conn.createStatement();
						stavailupd.executeUpdate(availupd);
						sw = new StringWriter();
						serializer = new XMLSerializer(sw, formatter);
						serializer.serialize(docseat);
						String seatupdstr = "update hp_administrator.book_tickets set SEAT = xmlquery( 'transform copy $new := $SEAT ";
						seatupdstr += " modify do replace $new/status/class[@type=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + currentcoachstr + "\"] with " + sw.toString();
						seatupdstr += " return $new') where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "'  ";
						stseatupd = conn.createStatement();
						stseatupd.executeUpdate(seatupdstr);
						String sp = "";
						availupd = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL modify do replace value of ";
						if (useragent)
							sp = "agent";
						else
							sp = "user";
						availupd += "$new/coach_status/class[@name=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + currentcoachstr + "\"]/" + destnnws + "/@" + sp + "till"
								+ " with \"" + spdesttillcnt + "\" ";
						availupd += " return  $new')  where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "' ";
						stavailupd = conn.createStatement();
						stavailupd.executeUpdate(availupd);
						availupd = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL  modify do ";
						availupd += " replace value of $new/coach_status/class[@name=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + currentcoachstr + "\"]/" + sourcenws + "/@" + sp + " with \""
								+ spexcesssrc + "\"";
						availupd += " return  $new')  where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "' ";
						stavailupd = conn.createStatement();
						stavailupd.executeUpdate(availupd);
						break;
					} else if (spdesttillcnt == 0 && booking_details.getNoOfPersons() <= spexcesssrc) {
						alloccnt = srcmax - excesssrc;
						seatstart = 1 + alloccnt;
						coach.clear();
						seatno.clear();
						booking_details.coachlist.clear();
						booking_details.seatlist.clear();
						for (tickpos = 0; tickpos < booking_details.getNoOfPersons(); tickpos++) {
							coach.add(currentcoachstr);
							booking_details.coachlist.add(currentcoachstr);
							while (Integer.parseInt(seat.getFirstChild().getTextContent().trim()) < seatstart) {
								seat = (Element) seat.getNextSibling();
							}
							seatstart++;
							System.out.println(seat.getFirstChild().getTextContent().trim());
							seatno.add(seat.getFirstChild().getTextContent().trim());
							booking_details.seatlist.add(seat.getFirstChild().getTextContent().trim());
							nl3 = seat.getElementsByTagName(sourcenws);
							stn = (Element) nl3.item(0);
							while (!stn.getNodeName().equals(destnnws)) {
								stn.setTextContent("0");
								stn = (Element) stn.getNextSibling();
							}
						}
						excesssrc -= booking_details.getNoOfPersons();
						spexcesssrc -= booking_details.getNoOfPersons();
						number_of_tickets_rem = 0;
						String availupd = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL  modify do ";
						if (!firsttime)
							conn.rollback(sp1);
						availupd += " replace value of $new/coach_status/class[@name=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + currentcoachstr + "\"]/" + sourcenws + " with \"" + excesssrc
								+ "\"";
						availupd += " return  $new')  where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "' ";
						stavailupd = conn.createStatement();
						stavailupd.executeUpdate(availupd);
						sw = new StringWriter();
						serializer = new XMLSerializer(sw, formatter);
						serializer.serialize(docseat);
						String seatupdstr = "update hp_administrator.book_tickets set SEAT = xmlquery( 'transform copy $new := $SEAT ";
						seatupdstr += " modify do replace $new/status/class[@type=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + currentcoachstr + "\"] with " + sw.toString();
						seatupdstr += " return $new') where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "'  ";
						stseatupd = conn.createStatement();
						stseatupd.executeUpdate(seatupdstr);
						String sp = "";
						availupd = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL  modify do ";
						if (useragent)
							sp = "agent";
						else
							sp = "user";
						availupd += " replace value of $new/coach_status/class[@name=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + currentcoachstr + "\"]/" + sourcenws + "/@" + sp + " with \""
								+ spexcesssrc + "\"";
						availupd += " return  $new')  where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "' ";
						stavailupd = conn.createStatement();
						stavailupd.executeUpdate(availupd);
						break;
					}
					String sp = "";
					seatstart = 1;
					if (useragent)
						sp = "agent";
					else
						sp = "user";
					while (spexcesssrc + spdesttillcnt > 0 && number_of_tickets_rem > 0) {
						enterloop = true;
						if (firsttime) {
							sp1 = conn.setSavepoint();
							firsttime = false;
						}
						if (spdesttillcnt > 0) {
							seatstart = coachmax - desttillcnt + 1;
							spdesttillcnt--;
							desttillcnt--;
							String availupd = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL modify do replace value of ";
							availupd += "$new/coach_status/class[@name=\"" + booking_details.getTclass()
									+ "\"]/coach[@number=\"" + currentcoachstr + "\"]/" + destnnws + "/@" + destnnws
									+ "TILL" + " with \"" + desttillcnt + "\" ";
							availupd += " return  $new')  where train_no like '" + booking_details.getTrain_no()
									+ "' and date = '" + booking_details.getDate() + "' ";
							stavailupd = conn.createStatement();
							stavailupd.executeUpdate(availupd);
							availupd = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL modify do replace value of ";
							availupd += "$new/coach_status/class[@name=\"" + booking_details.getTclass()
									+ "\"]/coach[@number=\"" + currentcoachstr + "\"]/" + destnnws + "/@" + sp + "till"
									+ " with \"" + spdesttillcnt + "\" ";
							availupd += " return  $new')  where train_no like '" + booking_details.getTrain_no()
									+ "' and date = '" + booking_details.getDate() + "' ";
							stavailupd = conn.createStatement();
							stavailupd.executeUpdate(availupd);
						} else if (spdesttillcnt == 0) {
							alloccnt = srcmax - excesssrc;
							excesssrc--;
							seatstart = 1 + alloccnt;
							String availupd = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL  modify do ";
							spexcesssrc--;
							availupd += " replace value of $new/coach_status/class[@name=\""
									+ booking_details.getTclass() + "\"]/coach[@number=\"" + currentcoachstr + "\"]/"
									+ sourcenws + "/@" + sp + " with \"" + excesssrc + "\"";
							availupd += " return  $new')  where train_no like '" + booking_details.getTrain_no()
									+ "' and date = '" + booking_details.getDate() + "' ";
							stavailupd = conn.createStatement();
							stavailupd.executeUpdate(availupd);
							availupd = "update hp_administrator.availability set AVAIL = xmlquery( 'transform copy $new := $AVAIL  modify do ";
							availupd += " replace value of $new/coach_status/class[@name=\""
									+ booking_details.getTclass() + "\"]/coach[@number=\"" + currentcoachstr + "\"]/"
									+ sourcenws + " with \"" + spexcesssrc + "\"";
							availupd += " return  $new')  where train_no like '" + booking_details.getTrain_no()
									+ "' and date = '" + booking_details.getDate() + "' ";
							stavailupd = conn.createStatement();
							stavailupd.executeUpdate(availupd);
						}
						while (Integer.parseInt(seat.getFirstChild().getTextContent().trim()) < seatstart) {
							seat = (Element) seat.getNextSibling();
						}
						nl3 = seat.getElementsByTagName(sourcenws);
						stn = (Element) nl3.item(0);
						while (!stn.getNodeName().equals(destnnws)) {
							stn.setTextContent("0");
							stn = (Element) stn.getNextSibling();
						}
						coach.add(currentcoachstr);
						booking_details.coachlist.add(currentcoachstr);
						number_of_tickets_rem--;
						tickpos++;
					}
					if (enterloop) {
						sw = new StringWriter();
						serializer = new XMLSerializer(sw, formatter);
						serializer.serialize(docseat);
						String seatupdstr = "update hp_administrator.book_tickets set SEAT = xmlquery( 'transform copy $new := $SEAT ";
						seatupdstr += " modify do replace $new/status/class[@type=\"" + booking_details.getTclass()
								+ "\"]/coach[@number=\"" + currentcoachstr + "\"] with " + sw.toString();
						seatupdstr += " return $new') where train_no like '" + booking_details.getTrain_no()
								+ "' and date = '" + booking_details.getDate() + "'  ";
						stseatupd = conn.createStatement();
						stseatupd.executeUpdate(seatupdstr);
					}
				}
			}
			availfin = true;
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			conn.rollback();
			e.printStackTrace();
		} catch (SAXException e) {
			conn.rollback();
			e.printStackTrace();
		} catch (IOException e) {
			conn.rollback();
			e.printStackTrace();
		}
	}

}