class n11664406 {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String version = req.getParameter("version");
		String cdn = req.getParameter("cdn");
		String dependencies = req.getParameter("dependencies");
		String optimize = req.getParameter("optimize");
		String cacheFile = null;
		boolean isCached = false;
		String result = null;
		if (!version.equals("1.3.2")) {
			result = "invalid version: " + version;
		}
		Boolean isError = true;
		if (!cdn.equals("google") && !cdn.equals("aol")) {
			result = "invalide CDN type: " + cdn;
		}
		if (!optimize.equals("comments") && !optimize.equals("shrinksafe") && !optimize.equals("none")
				&& !optimize.equals("shrinksafe.keepLines")) {
			result = "invalid optimize type: " + optimize;
		}
		if (!dependencies.matches("^[\\w\\-\\,\\s\\.]+$")) {
			result = "invalid dependency list: " + dependencies;
		}
		try {
			MessageDigest md = null;
			try {
				md = MessageDigest.getInstance("SHA");
			} catch (NoSuchAlgorithmException e) {
				result = e.getMessage();
			}
			if (result == null) {
				md.update(dependencies.getBytes());
				String digest = (new BASE64Encoder()).encode(md.digest()).replace('+', '~').replace('/', '_')
						.replace('=', '_');
				cacheFile = cachePath + "/" + version + "/" + cdn + "/" + digest + "/" + optimize + ".js";
				File file = new File(cacheFile);
				if (file.exists()) {
					isError = false;
					isCached = true;
				}
			}
			if (result == null && !isCached) {
				BuilderContextAction contextAction = new BuilderContextAction(builderPath, version, cdn, dependencies,
						optimize);
				ContextFactory.getGlobal().call(contextAction);
				Exception exception = contextAction.getException();
				if (exception != null) {
					result = exception.getMessage();
				} else {
					result = contextAction.getResult();
					FileUtil.writeToFile(cacheFile, result, null, true);
					isError = false;
				}
			}
		} catch (Exception e) {
			result = e.getMessage();
		}
		res.setCharacterEncoding("utf-8");
		if (isError) {
			result = result.replaceAll("\\\"", "\\\"");
			PrintWriter writer = res.getWriter();
			result = "<html><head><script type=\"text/javascript\">alert(\"" + result
					+ "\");</script></head><body></body></html>";
			writer.append(result);
		} else {
			res.setHeader("Content-Type", "application/x-javascript");
			res.setHeader("Content-disposition", "attachment; filename=dojo.js");
			res.setHeader("Content-Encoding", "gzip");
			File file = new File(cacheFile);
			OutputStream out = res.getOutputStream();
			BufferedInputStream in = new java.io.BufferedInputStream(new DataInputStream(new FileInputStream(file)));
			int bytesRead = 0;
			byte[] bytes = new byte[64000];
			while (bytesRead != -1) {
				bytesRead = in.read(bytes);
				if (bytesRead != -1) {
					out.write(bytes, 0, bytesRead);
				}
			}
		}
	}

}