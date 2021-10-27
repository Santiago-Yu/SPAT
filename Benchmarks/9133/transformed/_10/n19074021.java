class n19074021 {
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String text = request.getParameter("text");
		long time = System.currentTimeMillis();
		String parsedQueryString = request.getQueryString();
		if (text == null) {
			text = "accepted params: text,font,size,color,background,nocache,aa,break";
			String[] fonts = new File(ctx.getRealPath("/WEB-INF/fonts/")).list();
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println("<p>");
			out.println("Usage: " + request.getServletPath() + "?params[]<BR>");
			out.println("Acceptable Params are: <UL>");
			out.println("<LI><B>text</B><BR>");
			out.println("The body of the image");
			out.println("<LI><B>font</B><BR>");
			out.println("Available Fonts (in folder '/WEB-INF/fonts/') <UL>");
			for (int i = 0; i < fonts.length; i++) {
				if (!"CVS".equals(fonts[i])) {
					out.println("<LI>" + fonts[i]);
				}
			}
			out.println("</UL>");
			out.println("<LI><B>size</B><BR>");
			out.println("An integer, i.e. size=100");
			out.println("<LI><B>color</B><BR>");
			out.println("in rgb, i.e. color=255,0,0");
			out.println("<LI><B>background</B><BR>");
			out.println("in rgb, i.e. background=0,0,255");
			out.println("transparent, i.e. background=''");
			out.println("<LI><B>aa</B><BR>");
			out.println("antialias (does not seem to work), aa=true");
			out.println("<LI><B>nocache</B><BR>");
			out.println(
					"if nocache is set, we will write out the image file every hit.  Otherwise, will write it the first time and then read the file");
			out.println("<LI><B>break</B><BR>");
			out.println("An integer greater than 0 (zero), i.e. break=20");
			out.println("</UL>");
			out.println("</UL>");
			out.println("Example:<BR>");
			out.println("&lt;img border=1  src=\"" + request.getServletPath()
					+ "?font=arial.ttf&text=testing&color=255,0,0&size=100\"&gt;<BR>");
			out.println("<img border=1 src='" + request.getServletPath()
					+ "?font=arial.ttf&text=testing&color=255,0,0&size=100'><BR>");
			out.println("</body>");
			out.println("</html>");
			return;
		}
		String myFile = (request.getQueryString() == null) ? "empty"
				: PublicEncryptionFactory.digestString(parsedQueryString).replace('\\', '_').replace('/', '_');
		myFile = Config.getStringProperty("PATH_TO_TITLE_IMAGES") + myFile + ".png";
		File file = new File(ctx.getRealPath(myFile));
		if (!file.exists() || (request.getParameter("nocache") != null)) {
			Iterator i = hm.entrySet().iterator();
			StringTokenizer st = null;
			while (i.hasNext()) {
				Map.Entry entry = (Map.Entry) i.next();
				String key = (String) entry.getKey();
				if (parsedQueryString.indexOf(key) > -1) {
					String val = (String) entry.getValue();
					parsedQueryString = UtilMethods.replace(parsedQueryString, key, val);
				}
			}
			st = new StringTokenizer(parsedQueryString, "&");
			while (st.hasMoreTokens()) {
				try {
					String x = st.nextToken();
					String key = x.split("=")[0];
					String val = x.split("=")[1];
					if ("text".equals(key)) {
						text = val;
					}
				} catch (Exception e) {
				}
			}
			text = URLDecoder.decode(text, "UTF-8");
			Logger.debug(this.getClass(), "building title image:" + file.getAbsolutePath());
			file.createNewFile();
			try {
				String font_file = "/WEB-INF/fonts/arial.ttf";
				if (request.getParameter("font") != null) {
					font_file = "/WEB-INF/fonts/" + request.getParameter("font");
				}
				float size = 20.0f;
				font_file = ctx.getRealPath(font_file);
				if (request.getParameter("size") != null) {
					size = Float.parseFloat(request.getParameter("size"));
				}
				Color background = Color.white;
				if (request.getParameter("background") != null) {
					if (request.getParameter("background").equals("transparent"))
						try {
							background = new Color(Color.TRANSLUCENT);
						} catch (Exception e) {
						}
					else
						try {
							st = new StringTokenizer(request.getParameter("background"), ",");
							int x = Integer.parseInt(st.nextToken());
							int y = Integer.parseInt(st.nextToken());
							int z = Integer.parseInt(st.nextToken());
							background = new Color(x, y, z);
						} catch (Exception e) {
						}
				}
				Color color = Color.black;
				int intBreak = 0;
				if (request.getParameter("color") != null) {
					try {
						st = new StringTokenizer(request.getParameter("color"), ",");
						int x = Integer.parseInt(st.nextToken());
						int y = Integer.parseInt(st.nextToken());
						int z = Integer.parseInt(st.nextToken());
						color = new Color(x, y, z);
					} catch (Exception e) {
						Logger.info(this, e.getMessage());
					}
				}
				java.util.ArrayList<String> lines = null;
				if (request.getParameter("break") != null) {
					try {
						intBreak = Integer.parseInt(request.getParameter("break"));
					} catch (Exception e) {
					}
				}
				if (intBreak > 0) {
					lines = new java.util.ArrayList<String>(10);
					lines.ensureCapacity(10);
					String line = null;
					int start = 0;
					int offSet;
					for (;;) {
						try {
							for (; isWhitespace(text.charAt(start)); ++start)
								;
							if (isWhitespace(text.charAt(start + intBreak - 1))) {
								lines.add(text.substring(start, start + intBreak));
								start += intBreak;
							} else {
								for (offSet = -1; !isWhitespace(text.charAt(start + intBreak + offSet)); ++offSet)
									;
								lines.add(text.substring(start, start + intBreak + offSet));
								start += intBreak + offSet;
							}
						} catch (Exception e) {
							if (text.length() > start)
								lines.add(leftTrim(text.substring(start)));
							break;
						}
					}
				} else {
					java.util.StringTokenizer tokens = new java.util.StringTokenizer(text, "|");
					if (tokens.hasMoreTokens()) {
						lines = new java.util.ArrayList<String>(10);
						lines.ensureCapacity(10);
						for (; tokens.hasMoreTokens();)
							lines.add(leftTrim(tokens.nextToken()));
					}
				}
				Font font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(font_file));
				font = font.deriveFont(size);
				BufferedImage buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
				Graphics2D g2 = buffer.createGraphics();
				if (request.getParameter("aa") != null) {
					g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				} else {
					g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
				}
				Rectangle2D fontBounds = null;
				FontRenderContext fc = g2.getFontRenderContext();
				TextLayout tl = null;
				Rectangle2D textLayoutBounds = null;
				boolean useTextLayout = false;
				int width = 0;
				useTextLayout = Boolean.parseBoolean(request.getParameter("textLayout"));
				int offSet = 0;
				int height = 0;
				if (1 < lines.size()) {
					int maxWidth = 0;
					int heightMultiplier = 0;
					for (; heightMultiplier < lines.size(); ++heightMultiplier) {
						fontBounds = font.getStringBounds(lines.get(heightMultiplier), fc);
						tl = new TextLayout(lines.get(heightMultiplier), font, fc);
						textLayoutBounds = tl.getBounds();
						if (maxWidth < Math.ceil(fontBounds.getWidth()))
							maxWidth = (int) Math.ceil(fontBounds.getWidth());
					}
					int boundHeigh = (int) Math
							.ceil((!useTextLayout ? fontBounds.getHeight() : textLayoutBounds.getHeight()));
					width = maxWidth;
					height = boundHeigh * lines.size();
					offSet = ((int) (boundHeigh * 0.2)) * (lines.size() - 1);
				} else {
					fontBounds = font.getStringBounds(text, fc);
					tl = new TextLayout(text, font, fc);
					textLayoutBounds = tl.getBounds();
					width = (int) fontBounds.getWidth();
					height = (int) Math.ceil((!useTextLayout ? fontBounds.getHeight() : textLayoutBounds.getHeight()));
				}
				buffer = new BufferedImage(width, height - offSet, BufferedImage.TYPE_INT_ARGB);
				g2 = buffer.createGraphics();
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setFont(font);
				g2.setColor(background);
				if (!background.equals(new Color(Color.TRANSLUCENT)))
					g2.fillRect(0, 0, width, height);
				g2.setColor(color);
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
				if (1 < lines.size()) {
					for (int numLine = 0; numLine < lines.size(); ++numLine) {
						int y = (int) Math.ceil((!useTextLayout ? fontBounds.getY() : textLayoutBounds.getY()));
						g2.drawString(lines.get(numLine), 0, -y * (numLine + 1));
					}
				} else {
					int y = (int) Math.ceil((!useTextLayout ? fontBounds.getY() : textLayoutBounds.getY()));
					g2.drawString(text, 0, -y);
				}
				ImageIO.write(buffer, "png", out);
				out.close();
			} catch (Exception ex) {
				Logger.info(this, ex.toString());
			}
		}
		response.setContentType("image/png");
		OutputStream os = response.getOutputStream();
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		int i = 0;
		byte[] buf = new byte[4096];
		while ((i = bis.read(buf)) != -1) {
			os.write(buf, 0, i);
		}
		os.close();
		bis.close();
		Logger.debug(this.getClass(), "time to build title: " + (System.currentTimeMillis() - time) + "ms");
		return;
	}

}