class n13262955 {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String servletPath = req.getServletPath(), requestURI = req.getRequestURI();
		String resource = requestURI.substring(requestURI.indexOf(servletPath) + servletPath.length());
		URL url = ClassResource.get(resourceDirectory + resource);
		try {
			File file = null;
			JarEntry jarEntry = null;
			JarFile jarFile = null;
			if (!url.toExternalForm().startsWith("jar:")) {
				file = new File(url.toURI());
			} else {
				jarFile = ((JarURLConnection) url.openConnection()).getJarFile();
				String[] jarURL = url.toExternalForm().split("!");
				jarEntry = jarFile.getJarEntry(jarURL[1].substring(1));
			}
			if (file != null && file.isDirectory()) {
				PrintWriter writer = resp.getWriter();
				resp.setContentType("text/html");
				DevelUtils.writePageBegin(writer);
				DevelUtils.writeTitleAndHeaderEnd(writer, "Makumba resources");
				if (SourceViewServlet.redirected(req, resp, servletPath)) {
					return;
				}
				String relativeDirectory = file.getName();
				if (file.getAbsolutePath().indexOf(resourceDirectory) != -1) {
					relativeDirectory = file.getAbsolutePath()
							.substring(file.getAbsolutePath().indexOf(resourceDirectory));
				}
				SourceViewServlet.printDirlistingHeader(writer, file.getCanonicalPath(), relativeDirectory);
				if (!(relativeDirectory.equals(resourceDirectory))) {
					writer.println("<b><a href=\"../\">../</a></b> (up one level)");
				}
				SourceViewServlet.processDirectory(writer, file, null);
				String[] list = file.list();
				Arrays.sort(list);
				for (int i = 0; i < list.length; i++) {
					String s = list[i];
					File f = new File(file.getAbsolutePath() + File.separator + s);
					if (f.isFile()) {
						writer.println("<b><a href=\"" + s + "\">" + s + "</a></b>");
					}
				}
				writer.println("</pre>");
				DevelUtils.writePageEnd(writer);
				resp.setHeader("Last-Modified", dfLastModified.format(new Date()));
				return;
			} else if (jarEntry != null && jarEntry.isDirectory()) {
				Enumeration<JarEntry> entries = jarFile.entries();
				ArrayList<String> files = new ArrayList<String>();
				ArrayList<String> directories = new ArrayList<String>();
				PrintWriter writer = resp.getWriter();
				resp.setContentType("text/html");
				DevelUtils.writePageBegin(writer);
				DevelUtils.writeTitleAndHeaderEnd(writer, "Makumba resources");
				if (SourceViewServlet.redirected(req, resp, servletPath)) {
					return;
				}
				String relativeDirectory = jarEntry.getName();
				SourceViewServlet.printDirlistingHeader(writer, url.toExternalForm(), relativeDirectory);
				if (!relativeDirectory.equals(resourceDirectory)
						&& !relativeDirectory.equals(resourceDirectory + "/")) {
					writer.println("<b><a href=\"../\">../</a></b> (up one level)");
				}
				while (entries.hasMoreElements()) {
					JarEntry entry = (JarEntry) entries.nextElement();
					if (entry.getName().startsWith(relativeDirectory)) {
						String s = entry.getName().substring(relativeDirectory.length());
						while (s.length() > 0 && s.startsWith("/")) {
							s = s.substring(1);
						}
						if (s.indexOf("/") == -1) {
							if (s.length() > 0) {
								files.add(s);
							}
						} else if (s.indexOf("/") == s.lastIndexOf("/") && s.endsWith("/")) {
							if (s.endsWith("/")) {
								s = s.substring(0, s.length() - 1);
							}
							if (s.length() > 0) {
								directories.add(s);
							}
						}
					}
				}
				for (String string : directories) {
					writer.println("<b><a href=\"" + string + "/\">" + string + "/</a></b>");
				}
				for (String string : files) {
					writer.println("<b><a href=\"" + string + "\">" + string + "</a></b>");
				}
				writer.println("</pre>");
				DevelUtils.writePageEnd(writer);
				resp.setHeader("Last-Modified", dfLastModified.format(new Date()));
				return;
			} else {
				final Date lastModified;
				if (url.toExternalForm().startsWith("jar:")) {
					JarFile jf = ((JarURLConnection) url.openConnection()).getJarFile();
					String[] jarURL = url.toExternalForm().split("!");
					lastModified = new Date(jf.getJarEntry(jarURL[1].substring(1)).getTime());
				} else {
					lastModified = new Date(new File(url.toURI()).lastModified());
				}
				resp.setHeader("Last-Modified", dfLastModified.format(lastModified));
				resp.setContentType(getContentType(url));
				Object cachedResource = NamedResources.getStaticCache(makumbaResources).getResource(resource);
				ServletOutputStream outputStream = resp.getOutputStream();
				if (isBinary(url)) {
					for (int i = 0; i < ((byte[]) cachedResource).length; i++) {
						outputStream.write(((byte[]) cachedResource)[i]);
					}
				} else {
					outputStream.print(cachedResource.toString());
				}
			}
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

}