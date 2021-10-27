class n19074021 {
	public void service(HttpServletRequest hvCBAALS, HttpServletResponse HEg9yVpT)
			throws ServletException, IOException {
		long QnXOCBR3 = System.currentTimeMillis();
		String kRpTy6kc = hvCBAALS.getParameter("text");
		String hZFqGXBR = hvCBAALS.getQueryString();
		if (kRpTy6kc == null) {
			String[] N0XzvsiP = new File(ctx.getRealPath("/WEB-INF/fonts/")).list();
			kRpTy6kc = "accepted params: text,font,size,color,background,nocache,aa,break";
			HEg9yVpT.setContentType("text/html");
			PrintWriter dxOHwBCp = HEg9yVpT.getWriter();
			dxOHwBCp.println("<html>");
			dxOHwBCp.println("<body>");
			dxOHwBCp.println("<p>");
			dxOHwBCp.println("Usage: " + hvCBAALS.getServletPath() + "?params[]<BR>");
			dxOHwBCp.println("Acceptable Params are: <UL>");
			dxOHwBCp.println("<LI><B>text</B><BR>");
			dxOHwBCp.println("The body of the image");
			dxOHwBCp.println("<LI><B>font</B><BR>");
			dxOHwBCp.println("Available Fonts (in folder '/WEB-INF/fonts/') <UL>");
			for (int O7iClhb1 = 0; O7iClhb1 < N0XzvsiP.length; O7iClhb1++) {
				if (!"CVS".equals(N0XzvsiP[O7iClhb1])) {
					dxOHwBCp.println("<LI>" + N0XzvsiP[O7iClhb1]);
				}
			}
			dxOHwBCp.println("</UL>");
			dxOHwBCp.println("<LI><B>size</B><BR>");
			dxOHwBCp.println("An integer, i.e. size=100");
			dxOHwBCp.println("<LI><B>color</B><BR>");
			dxOHwBCp.println("in rgb, i.e. color=255,0,0");
			dxOHwBCp.println("<LI><B>background</B><BR>");
			dxOHwBCp.println("in rgb, i.e. background=0,0,255");
			dxOHwBCp.println("transparent, i.e. background=''");
			dxOHwBCp.println("<LI><B>aa</B><BR>");
			dxOHwBCp.println("antialias (does not seem to work), aa=true");
			dxOHwBCp.println("<LI><B>nocache</B><BR>");
			dxOHwBCp.println(
					"if nocache is set, we will write out the image file every hit.  Otherwise, will write it the first time and then read the file");
			dxOHwBCp.println("<LI><B>break</B><BR>");
			dxOHwBCp.println("An integer greater than 0 (zero), i.e. break=20");
			dxOHwBCp.println("</UL>");
			dxOHwBCp.println("</UL>");
			dxOHwBCp.println("Example:<BR>");
			dxOHwBCp.println("&lt;img border=1  src=\"" + hvCBAALS.getServletPath()
					+ "?font=arial.ttf&text=testing&color=255,0,0&size=100\"&gt;<BR>");
			dxOHwBCp.println("<img border=1 src='" + hvCBAALS.getServletPath()
					+ "?font=arial.ttf&text=testing&color=255,0,0&size=100'><BR>");
			dxOHwBCp.println("</body>");
			dxOHwBCp.println("</html>");
			return;
		}
		String RExDst5A = (hvCBAALS.getQueryString() == null) ? "empty"
				: PublicEncryptionFactory.digestString(hZFqGXBR).replace('\\', '_').replace('/', '_');
		RExDst5A = Config.getStringProperty("PATH_TO_TITLE_IMAGES") + RExDst5A + ".png";
		File CxWt8qCy = new File(ctx.getRealPath(RExDst5A));
		if (!CxWt8qCy.exists() || (hvCBAALS.getParameter("nocache") != null)) {
			StringTokenizer Nub6kfGD = null;
			Iterator GSuPMGdI = hm.entrySet().iterator();
			while (GSuPMGdI.hasNext()) {
				Map.Entry CLKRPpKA = (Map.Entry) GSuPMGdI.next();
				String n2qKoWG3 = (String) CLKRPpKA.getKey();
				if (hZFqGXBR.indexOf(n2qKoWG3) > -1) {
					String yQuXOesL = (String) CLKRPpKA.getValue();
					hZFqGXBR = UtilMethods.replace(hZFqGXBR, n2qKoWG3, yQuXOesL);
				}
			}
			Nub6kfGD = new StringTokenizer(hZFqGXBR, "&");
			while (Nub6kfGD.hasMoreTokens()) {
				try {
					String axx6F4eD = Nub6kfGD.nextToken();
					String QGNcabGO = axx6F4eD.split("=")[0];
					String Yrbel87O = axx6F4eD.split("=")[1];
					if ("text".equals(QGNcabGO)) {
						kRpTy6kc = Yrbel87O;
					}
				} catch (Exception apzpeQfD) {
				}
			}
			kRpTy6kc = URLDecoder.decode(kRpTy6kc, "UTF-8");
			Logger.debug(this.getClass(), "building title image:" + CxWt8qCy.getAbsolutePath());
			CxWt8qCy.createNewFile();
			try {
				String vn4LZVZE = "/WEB-INF/fonts/arial.ttf";
				if (hvCBAALS.getParameter("font") != null) {
					vn4LZVZE = "/WEB-INF/fonts/" + hvCBAALS.getParameter("font");
				}
				vn4LZVZE = ctx.getRealPath(vn4LZVZE);
				float jNc4fhS3 = 20.0f;
				if (hvCBAALS.getParameter("size") != null) {
					jNc4fhS3 = Float.parseFloat(hvCBAALS.getParameter("size"));
				}
				Color DKaOoMHG = Color.white;
				if (hvCBAALS.getParameter("background") != null) {
					if (hvCBAALS.getParameter("background").equals("transparent"))
						try {
							DKaOoMHG = new Color(Color.TRANSLUCENT);
						} catch (Exception BNiqTdGE) {
						}
					else
						try {
							Nub6kfGD = new StringTokenizer(hvCBAALS.getParameter("background"), ",");
							int qlmDo6HB = Integer.parseInt(Nub6kfGD.nextToken());
							int S9DorKvr = Integer.parseInt(Nub6kfGD.nextToken());
							int o8ExLxvb = Integer.parseInt(Nub6kfGD.nextToken());
							DKaOoMHG = new Color(qlmDo6HB, S9DorKvr, o8ExLxvb);
						} catch (Exception uLq2g0UR) {
						}
				}
				Color kAi9ynUG = Color.black;
				if (hvCBAALS.getParameter("color") != null) {
					try {
						Nub6kfGD = new StringTokenizer(hvCBAALS.getParameter("color"), ",");
						int OFeEtFit = Integer.parseInt(Nub6kfGD.nextToken());
						int xanmXozb = Integer.parseInt(Nub6kfGD.nextToken());
						int IU9PDsSI = Integer.parseInt(Nub6kfGD.nextToken());
						kAi9ynUG = new Color(OFeEtFit, xanmXozb, IU9PDsSI);
					} catch (Exception I5q8LEgX) {
						Logger.info(this, I5q8LEgX.getMessage());
					}
				}
				int EEedK5pM = 0;
				if (hvCBAALS.getParameter("break") != null) {
					try {
						EEedK5pM = Integer.parseInt(hvCBAALS.getParameter("break"));
					} catch (Exception FE54ztuP) {
					}
				}
				java.util.ArrayList<String> ISlAfGZs = null;
				if (EEedK5pM > 0) {
					ISlAfGZs = new java.util.ArrayList<String>(10);
					ISlAfGZs.ensureCapacity(10);
					int QmockWJ1 = 0;
					String zVVn1O5f = null;
					int ynUSitd7;
					for (;;) {
						try {
							for (; isWhitespace(kRpTy6kc.charAt(QmockWJ1)); ++QmockWJ1)
								;
							if (isWhitespace(kRpTy6kc.charAt(QmockWJ1 + EEedK5pM - 1))) {
								ISlAfGZs.add(kRpTy6kc.substring(QmockWJ1, QmockWJ1 + EEedK5pM));
								QmockWJ1 += EEedK5pM;
							} else {
								for (ynUSitd7 = -1; !isWhitespace(
										kRpTy6kc.charAt(QmockWJ1 + EEedK5pM + ynUSitd7)); ++ynUSitd7)
									;
								ISlAfGZs.add(kRpTy6kc.substring(QmockWJ1, QmockWJ1 + EEedK5pM + ynUSitd7));
								QmockWJ1 += EEedK5pM + ynUSitd7;
							}
						} catch (Exception p67fTDja) {
							if (kRpTy6kc.length() > QmockWJ1)
								ISlAfGZs.add(leftTrim(kRpTy6kc.substring(QmockWJ1)));
							break;
						}
					}
				} else {
					java.util.StringTokenizer EePWksvW = new java.util.StringTokenizer(kRpTy6kc, "|");
					if (EePWksvW.hasMoreTokens()) {
						ISlAfGZs = new java.util.ArrayList<String>(10);
						ISlAfGZs.ensureCapacity(10);
						for (; EePWksvW.hasMoreTokens();)
							ISlAfGZs.add(leftTrim(EePWksvW.nextToken()));
					}
				}
				Font u6cLbgpN = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(vn4LZVZE));
				u6cLbgpN = u6cLbgpN.deriveFont(jNc4fhS3);
				BufferedImage jRmQRHLz = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
				Graphics2D RdkeGdXj = jRmQRHLz.createGraphics();
				if (hvCBAALS.getParameter("aa") != null) {
					RdkeGdXj.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				} else {
					RdkeGdXj.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
				}
				FontRenderContext hbQ0Jc85 = RdkeGdXj.getFontRenderContext();
				Rectangle2D LsHwiAPr = null;
				Rectangle2D UQyLQD4r = null;
				TextLayout VtoPxKsO = null;
				boolean XJIQAYAD = false;
				XJIQAYAD = Boolean.parseBoolean(hvCBAALS.getParameter("textLayout"));
				int i4Iw5QED = 0;
				int M5kIQqtq = 0;
				int PI5sAv9x = 0;
				if (1 < ISlAfGZs.size()) {
					int XCRopWSI = 0;
					int KhLXj7Lt = 0;
					for (; XCRopWSI < ISlAfGZs.size(); ++XCRopWSI) {
						LsHwiAPr = u6cLbgpN.getStringBounds(ISlAfGZs.get(XCRopWSI), hbQ0Jc85);
						VtoPxKsO = new TextLayout(ISlAfGZs.get(XCRopWSI), u6cLbgpN, hbQ0Jc85);
						UQyLQD4r = VtoPxKsO.getBounds();
						if (KhLXj7Lt < Math.ceil(LsHwiAPr.getWidth()))
							KhLXj7Lt = (int) Math.ceil(LsHwiAPr.getWidth());
					}
					i4Iw5QED = KhLXj7Lt;
					int fP7xqg9M = (int) Math.ceil((!XJIQAYAD ? LsHwiAPr.getHeight() : UQyLQD4r.getHeight()));
					M5kIQqtq = fP7xqg9M * ISlAfGZs.size();
					PI5sAv9x = ((int) (fP7xqg9M * 0.2)) * (ISlAfGZs.size() - 1);
				} else {
					LsHwiAPr = u6cLbgpN.getStringBounds(kRpTy6kc, hbQ0Jc85);
					VtoPxKsO = new TextLayout(kRpTy6kc, u6cLbgpN, hbQ0Jc85);
					UQyLQD4r = VtoPxKsO.getBounds();
					i4Iw5QED = (int) LsHwiAPr.getWidth();
					M5kIQqtq = (int) Math.ceil((!XJIQAYAD ? LsHwiAPr.getHeight() : UQyLQD4r.getHeight()));
				}
				jRmQRHLz = new BufferedImage(i4Iw5QED, M5kIQqtq - PI5sAv9x, BufferedImage.TYPE_INT_ARGB);
				RdkeGdXj = jRmQRHLz.createGraphics();
				RdkeGdXj.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				RdkeGdXj.setFont(u6cLbgpN);
				RdkeGdXj.setColor(DKaOoMHG);
				if (!DKaOoMHG.equals(new Color(Color.TRANSLUCENT)))
					RdkeGdXj.fillRect(0, 0, i4Iw5QED, M5kIQqtq);
				RdkeGdXj.setColor(kAi9ynUG);
				if (1 < ISlAfGZs.size()) {
					for (int saV4PFKG = 0; saV4PFKG < ISlAfGZs.size(); ++saV4PFKG) {
						int UfCKXmsW = (int) Math.ceil((!XJIQAYAD ? LsHwiAPr.getY() : UQyLQD4r.getY()));
						RdkeGdXj.drawString(ISlAfGZs.get(saV4PFKG), 0, -UfCKXmsW * (saV4PFKG + 1));
					}
				} else {
					int kMC4cDdt = (int) Math.ceil((!XJIQAYAD ? LsHwiAPr.getY() : UQyLQD4r.getY()));
					RdkeGdXj.drawString(kRpTy6kc, 0, -kMC4cDdt);
				}
				BufferedOutputStream bUlBjYSo = new BufferedOutputStream(new FileOutputStream(CxWt8qCy));
				ImageIO.write(jRmQRHLz, "png", bUlBjYSo);
				bUlBjYSo.close();
			} catch (Exception Kad3nwhr) {
				Logger.info(this, Kad3nwhr.toString());
			}
		}
		HEg9yVpT.setContentType("image/png");
		BufferedInputStream Zfv0tnBc = new BufferedInputStream(new FileInputStream(CxWt8qCy));
		OutputStream GrQYFTUQ = HEg9yVpT.getOutputStream();
		byte[] MHoaIaRu = new byte[4096];
		int uigFa5jp = 0;
		while ((uigFa5jp = Zfv0tnBc.read(MHoaIaRu)) != -1) {
			GrQYFTUQ.write(MHoaIaRu, 0, uigFa5jp);
		}
		GrQYFTUQ.close();
		Zfv0tnBc.close();
		Logger.debug(this.getClass(), "time to build title: " + (System.currentTimeMillis() - QnXOCBR3) + "ms");
		return;
	}

}