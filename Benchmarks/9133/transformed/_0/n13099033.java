class n13099033 {
	public void process(HttpServletRequest Jl51m607, HttpServletResponse ygxzZ600)
			throws IOException, ServletException {
		String SCjaTnuu = Jl51m607.getRequestURL().toString();
		URL GZ8B69LF = new URL(SCjaTnuu);
		domain = GZ8B69LF.getHost();
		pathinfo = Jl51m607.getPathInfo();
		String blU9dMxa = Jl51m607.getHeader("user-agent");
		UserAgent pxZQCKpq = UserAgent.parseUserAgentString(blU9dMxa);
		String Su3fgQ6j = pxZQCKpq.getBrowser().getName();
		String[] Up9GLkIE = domain.split("\\.");
		shot_domain = Up9GLkIE[1] + "." + Up9GLkIE[2];
		if (Su3fgQ6j.equalsIgnoreCase("Robot/Spider") || Su3fgQ6j.equalsIgnoreCase("Lynx")
				|| Su3fgQ6j.equalsIgnoreCase("Downloading Tool")) {
			JSONObject jQGFaC4W = CsvReader.CsvReader("domainparUpdated.csv", shot_domain);
			log.info(jQGFaC4W.toString());
		} else {
			String HLxrGJHZ;
			String nZZzrrJ1;
			String pT7L2an5;
			String lnKRgqVs;
			String Y6CBgYnS;
			String sCMY6HKJ;
			String LUmamMMV;
			String VoNdKjg3;
			String KbMZPbAy;
			String jimfV1fA;
			String f0WWMHbI;
			String ubcoYMs1;
			String w7FHCgXz;
			String PDWFmHSI;
			String iognxgF9;
			String HE4qoarM = null;
			String QzQh7CmK = null;
			String kka0vEJK = null;
			String tDTO1MXZ = null;
			int CN686DVe = 0;
			String yV9aW3aJ = "0";
			boolean mOh6dRAZ = false;
			Cookie[] iMrINbmE = Jl51m607.getCookies();
			if (iMrINbmE != null) {
				for (int V6EFPxkB = 0; V6EFPxkB < iMrINbmE.length; V6EFPxkB++) {
					if (iMrINbmE[V6EFPxkB].getName().equals("count")) {
						yV9aW3aJ = iMrINbmE[V6EFPxkB].getValue();
						if (yV9aW3aJ != null && yV9aW3aJ.length() > 0) {
							log.info("Check count " + yV9aW3aJ + " path " + iMrINbmE[V6EFPxkB].getPath());
							CN686DVe = Integer.parseInt(yV9aW3aJ);
							CN686DVe++;
						} else {
							CN686DVe = 1;
						}
						log.info("New count " + CN686DVe);
						LongLivedCookie MDHvqcok = new LongLivedCookie("count", Integer.toString(CN686DVe));
						ygxzZ600.addCookie(MDHvqcok);
						mOh6dRAZ = true;
					}
					if (iMrINbmE[V6EFPxkB].getName().equals("countrycode")) {
						HE4qoarM = iMrINbmE[V6EFPxkB].getValue();
					}
					if (iMrINbmE[V6EFPxkB].getName().equals("city")) {
						QzQh7CmK = iMrINbmE[V6EFPxkB].getValue();
					}
					if (iMrINbmE[V6EFPxkB].getName().equals("videos")) {
						tDTO1MXZ = iMrINbmE[V6EFPxkB].getValue();
						log.info("Welcome videos " + tDTO1MXZ);
					}
					if (iMrINbmE[V6EFPxkB].getName().equals("gmclick")) {
						log.info("gmclick exist!!");
						kka0vEJK = iMrINbmE[V6EFPxkB].getValue();
						if (CN686DVe % 20 == 0 && CN686DVe > 0) {
							log.info("Cancell gmclick -> " + kka0vEJK + " intcount " + CN686DVe + " path "
									+ iMrINbmE[V6EFPxkB].getPath());
							Cookie ttiDMClL = new Cookie("gmclick", "0");
							ttiDMClL.setPath("/");
							ttiDMClL.setMaxAge(0);
							ygxzZ600.addCookie(ttiDMClL);
						}
					}
				}
				if (!mOh6dRAZ) {
					LongLivedCookie JQJrLgsv = new LongLivedCookie("count", "0");
					ygxzZ600.addCookie(JQJrLgsv);
					log.info(" Not First visit count Don't Exist!!");
				}
				if (tDTO1MXZ == null) {
					LongLivedCookie LuOy7cor = new LongLivedCookie("videos", "0");
					ygxzZ600.addCookie(LuOy7cor);
					log.info("Not First visit VIDEOS Don't Exist!!");
				}
			} else {
				LongLivedCookie RrgYJrSl = new LongLivedCookie("count", yV9aW3aJ);
				ygxzZ600.addCookie(RrgYJrSl);
				LongLivedCookie Kk2mO3Po = new LongLivedCookie("videos", "0");
				ygxzZ600.addCookie(Kk2mO3Po);
				log.info("First visit count = " + CN686DVe + " videos 0");
			}
			String[] ZmazkdGO = CommUtils.CsvParsing(domain, "domainpar.csv");
			HLxrGJHZ = ZmazkdGO[0];
			nZZzrrJ1 = ZmazkdGO[1];
			pT7L2an5 = ZmazkdGO[2];
			lnKRgqVs = ZmazkdGO[3];
			Y6CBgYnS = ZmazkdGO[4];
			sCMY6HKJ = ZmazkdGO[5];
			LUmamMMV = ZmazkdGO[6];
			VoNdKjg3 = ZmazkdGO[7];
			KbMZPbAy = ZmazkdGO[8];
			jimfV1fA = ZmazkdGO[9];
			f0WWMHbI = ZmazkdGO[10];
			ubcoYMs1 = ZmazkdGO[11];
			w7FHCgXz = ZmazkdGO[12];
			PDWFmHSI = ZmazkdGO[13];
			iognxgF9 = ZmazkdGO[14];
			String RUBt6nCb = Jl51m607.getRemoteHost();
			if ((HE4qoarM == null) || (QzQh7CmK == null)) {
				String h9x3SJ8E = "http://api.ipinfodb.com/v2/ip_query.php?key=abbb04fd823793c5343a046e5d56225af37861b9020e9bc86313eb20486b6133&ip="
						+ RUBt6nCb + "&output=json";
				String LQriJ0Gx = "";
				URL H1Aw6SI1 = new URL(h9x3SJ8E);
				BufferedReader tbhJQZkM = new BufferedReader(new InputStreamReader(H1Aw6SI1.openStream(), "UTF8"));
				StringBuffer g5lZyv8G = new StringBuffer();
				String K0kQPSyu;
				while ((K0kQPSyu = tbhJQZkM.readLine()) != null) {
					g5lZyv8G.append(K0kQPSyu);
				}
				tbhJQZkM.close();
				LQriJ0Gx = g5lZyv8G.toString();
				try {
					JSONObject wTibbyJC = new JSONObject(LQriJ0Gx);
					log.info("Status -> " + wTibbyJC.get("Status").toString());
					log.info("City -> " + wTibbyJC.get("City").toString());
					QzQh7CmK = wTibbyJC.get("City").toString();
					HE4qoarM = wTibbyJC.get("CountryCode").toString();
					log.info("countrycode -> " + HE4qoarM);
					if ((QzQh7CmK.length() == 0) || (QzQh7CmK == null)) {
						LongLivedCookie IIg0Xvlu = new LongLivedCookie("city", "Helsinki");
						ygxzZ600.addCookie(IIg0Xvlu);
						QzQh7CmK = "Helsinki";
					} else {
						LongLivedCookie B6Eck64e = new LongLivedCookie("city", QzQh7CmK);
						ygxzZ600.addCookie(B6Eck64e);
					}
					if (HE4qoarM.length() == 0 || (HE4qoarM == null) || HE4qoarM.equals("RD")) {
						LongLivedCookie o7eDOjym = new LongLivedCookie("countrycode", "FI");
						ygxzZ600.addCookie(o7eDOjym);
						HE4qoarM = "FI";
					} else {
						LongLivedCookie ajFQW3Wb = new LongLivedCookie("countrycode", HE4qoarM);
						ygxzZ600.addCookie(ajFQW3Wb);
					}
				} catch (JSONException tyQI9CJE) {
					log.severe(tyQI9CJE.getMessage());
				} finally {
					if ((HE4qoarM == null) || (QzQh7CmK == null)) {
						log.severe("need use finally!!!");
						HE4qoarM = "FI";
						QzQh7CmK = "Helsinki";
						LongLivedCookie EJRoJtbW = new LongLivedCookie("city", "Helsinki");
						ygxzZ600.addCookie(EJRoJtbW);
						LongLivedCookie bq2iyygo = new LongLivedCookie("countrycode", "FI");
						ygxzZ600.addCookie(bq2iyygo);
					}
				}
			}
			JSONArray lSqOSnqg = new JSONArray();
			JSONArray vpxeB7qt = new JSONArray();
			Map<String, Object> OVKg9g8K = new HashMap<String, Object>();
			Map<String, Object> JPiafK9c = new HashMap<String, Object>();
			JPiafK9c.put("img", Y6CBgYnS);
			JPiafK9c.put("color", lnKRgqVs);
			JPiafK9c.put("title", HLxrGJHZ);
			JPiafK9c.put("locale", nZZzrrJ1);
			JPiafK9c.put("domain", domain);
			JPiafK9c.put("facebookid", pT7L2an5);
			JPiafK9c.put("ip", RUBt6nCb);
			JPiafK9c.put("countrycode", HE4qoarM);
			JPiafK9c.put("city", QzQh7CmK);
			OVKg9g8K.put("theme", JPiafK9c);
			lSqOSnqg.put(OVKg9g8K);
			String[] VsNcZXQE = { "mem0", "mem20", "mem40", "mem60", "mem80", "mem100", "mem120", "mem140", "mem160",
					"mem180" };
			List wDrJqqLp = Arrays.asList(VsNcZXQE);
			Collections.shuffle(wDrJqqLp);
			Map<String, Object> hlBCum4I = new HashMap<String, Object>();
			hlBCum4I.put("memlist", wDrJqqLp);
			vpxeB7qt.put(hlBCum4I);
			log.info(vpxeB7qt.toString());
			ygxzZ600.setContentType("text/html");
			ygxzZ600.setCharacterEncoding("UTF-8");
			PrintWriter kE9vYUcZ = ygxzZ600.getWriter();
			kE9vYUcZ.println(
					"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
			kE9vYUcZ.println(
					"<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:fb=\"http://www.facebook.com/2008/fbml\">");
			kE9vYUcZ.println("<head>");
			kE9vYUcZ.println("<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">");
			kE9vYUcZ.println("<meta name=\"gwt:property\" content=\"locale=" + nZZzrrJ1 + "\">");
			kE9vYUcZ.println("<link type=\"text/css\" rel=\"stylesheet\" href=\"NewTube.css\">");
			kE9vYUcZ.println("<title>" + HLxrGJHZ + "</title>");
			kE9vYUcZ.println(
					"<script type=\"text/javascript\" language=\"javascript\" src=\"newtube/newtube.nocache.js\"></script>");
			kE9vYUcZ.println(
					"<script type='text/javascript'>var jsonStartParams = " + lSqOSnqg.toString() + ";</script>");
			kE9vYUcZ.println("<script type='text/javascript'>var girlsphones = "
					+ CommUtils.CsvtoJson("girlsphones.csv").toString() + ";</script>");
			kE9vYUcZ.println("<script type='text/javascript'>");
			kE9vYUcZ.println("var mem = " + vpxeB7qt.toString() + ";");
			kE9vYUcZ.println("</script>");
			kE9vYUcZ.println("</head>");
			kE9vYUcZ.println("<body>");
			kE9vYUcZ.println("<div id='fb-root'></div>");
			kE9vYUcZ.println("<script>");
			kE9vYUcZ.println("window.fbAsyncInit = function() {");
			kE9vYUcZ.println("FB.init({appId: '" + pT7L2an5 + "', status: true, cookie: true,xfbml: true});};");
			kE9vYUcZ.println("(function() {");
			kE9vYUcZ.println("var e = document.createElement('script'); e.async = true;");
			kE9vYUcZ.println("e.src = document.location.protocol +");
			kE9vYUcZ.println("'//connect.facebook.net/" + nZZzrrJ1 + "/all.js';");
			kE9vYUcZ.println("document.getElementById('fb-root').appendChild(e);");
			kE9vYUcZ.println("}());");
			kE9vYUcZ.println("</script>");
			kE9vYUcZ.println("<div id=\"start\"></div>");
			kE9vYUcZ.println("<div id=\"seo_content\">");
			BufferedReader VwQB7Hen = new BufferedReader(
					new InputStreamReader(new FileInputStream(domain + ".html"), "UTF8"));
			String qGB0P02I = null;
			while ((qGB0P02I = VwQB7Hen.readLine()) != null) {
				kE9vYUcZ.println(qGB0P02I);
			}
			VwQB7Hen.close();
			if (HE4qoarM != null && !HE4qoarM.equalsIgnoreCase("US") && !HE4qoarM.equalsIgnoreCase("IE")
					&& !HE4qoarM.equalsIgnoreCase("UK") && CN686DVe > 2 && CN686DVe < 51) {
				kE9vYUcZ.println("<script type=\"text/javascript\"><!--");
				kE9vYUcZ.println("google_ad_client = \"" + sCMY6HKJ + "\";");
				kE9vYUcZ.println("google_ad_slot = \"" + LUmamMMV + "\";");
				kE9vYUcZ.println("google_ad_width = " + VoNdKjg3 + ";");
				kE9vYUcZ.println("google_ad_height = " + KbMZPbAy + ";");
				kE9vYUcZ.println("//-->");
				kE9vYUcZ.println("</script>");
				kE9vYUcZ.println("<script type=\"text/javascript\"");
				kE9vYUcZ.println("src=\"" + sCMY6HKJ + ".js\">");
				kE9vYUcZ.println("</script>");
				kE9vYUcZ.println("<script type=\"text/javascript\"><!--");
				kE9vYUcZ.println("google_ad_client = \"" + sCMY6HKJ + "\";");
				kE9vYUcZ.println("google_ad_slot = \"" + jimfV1fA + "\";");
				kE9vYUcZ.println("google_ad_width = " + f0WWMHbI + ";");
				kE9vYUcZ.println("google_ad_height = " + ubcoYMs1 + ";");
				kE9vYUcZ.println("//-->");
				kE9vYUcZ.println("</script>");
				kE9vYUcZ.println("<script type=\"text/javascript\"");
				kE9vYUcZ.println("src=\"" + sCMY6HKJ + ".js\">");
				kE9vYUcZ.println("</script>");
				kE9vYUcZ.println("<script type=\"text/javascript\"><!--");
				kE9vYUcZ.println("google_ad_client = \"" + sCMY6HKJ + "\";");
				kE9vYUcZ.println("google_ad_slot = \"" + w7FHCgXz + "\";");
				kE9vYUcZ.println("google_ad_width = " + PDWFmHSI + ";");
				kE9vYUcZ.println("google_ad_height = " + iognxgF9 + ";");
				kE9vYUcZ.println("//-->");
				kE9vYUcZ.println("</script>");
				kE9vYUcZ.println("<script type=\"text/javascript\"");
				kE9vYUcZ.println("src=\"" + sCMY6HKJ + ".js\">");
				kE9vYUcZ.println("</script>");
			}
			if (HE4qoarM != null && !HE4qoarM.equalsIgnoreCase("US") && !HE4qoarM.equalsIgnoreCase("IE")
					&& !HE4qoarM.equalsIgnoreCase("UK") && CN686DVe > 50) {
				kE9vYUcZ.println("<script type=\"text/javascript\"><!--");
				kE9vYUcZ.println("google_ad_client = \"" + "pub-9496078135369870" + "\";");
				kE9vYUcZ.println("google_ad_slot = \"" + "8683942065" + "\";");
				kE9vYUcZ.println("google_ad_width = " + "160" + ";");
				kE9vYUcZ.println("google_ad_height = " + "600" + ";");
				kE9vYUcZ.println("//-->");
				kE9vYUcZ.println("</script>");
				kE9vYUcZ.println("<script type=\"text/javascript\"");
				kE9vYUcZ.println("src=\"pub-9496078135369870" + "" + ".js\">");
				kE9vYUcZ.println("</script>");
				kE9vYUcZ.println("<script type=\"text/javascript\"><!--");
				kE9vYUcZ.println("google_ad_client = \"" + "pub-9496078135369870" + "\";");
				kE9vYUcZ.println("google_ad_slot = \"" + "0941291340" + "\";");
				kE9vYUcZ.println("google_ad_width = " + "728" + ";");
				kE9vYUcZ.println("google_ad_height = " + "90" + ";");
				kE9vYUcZ.println("//-->");
				kE9vYUcZ.println("</script>");
				kE9vYUcZ.println("<script type=\"text/javascript\"");
				kE9vYUcZ.println("src=\"" + "pub-9496078135369870" + ".js\">");
				kE9vYUcZ.println("</script>");
				kE9vYUcZ.println("<script type=\"text/javascript\"><!--");
				kE9vYUcZ.println("google_ad_client = \"" + "pub-9496078135369870" + "\";");
				kE9vYUcZ.println("google_ad_slot = \"" + "4621616265" + "\";");
				kE9vYUcZ.println("google_ad_width = " + "468" + ";");
				kE9vYUcZ.println("google_ad_height = " + "60" + ";");
				kE9vYUcZ.println("//-->");
				kE9vYUcZ.println("</script>");
				kE9vYUcZ.println("<script type=\"text/javascript\"");
				kE9vYUcZ.println("src=\"" + "pub-9496078135369870" + ".js\">");
				kE9vYUcZ.println("</script>");
			}
			kE9vYUcZ.println("</div>");
			kE9vYUcZ.println("</body></html>");
			kE9vYUcZ.close();
		}
	}

}