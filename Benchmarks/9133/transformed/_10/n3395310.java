class n3395310 {
	private void execute(File file) throws IOException {
		if (file == null)
			throw new RuntimeException("undefined file");
		if (!file.exists())
			throw new RuntimeException("file not found :" + file);
		if (!file.isFile())
			throw new RuntimeException("not a file :" + file);
		String login = cfg.getProperty(GC_USERNAME);
		String password = null;
		PostMethod post = null;
		if (cfg.containsKey(GC_PASSWORD)) {
			password = cfg.getProperty(GC_PASSWORD);
		} else {
			password = new String(Base64.decode(cfg.getProperty(GC_PASSWORD64)));
		}
		try {
			post = new PostMethod("https://" + projectName + ".googlecode.com/files");
			HttpClient client = new HttpClient();
			post.addRequestHeader("User-Agent", getClass().getName());
			post.addRequestHeader("Authorization", "Basic " + Base64.encode(login + ":" + password));
			String s = this.summary;
			List<Part> parts = new ArrayList<Part>();
			if (StringUtils.isBlank(s)) {
				s = file.getName() + " (" + TimeUtils.toYYYYMMDD() + ")";
			}
			parts.add(new StringPart("summary", s));
			for (String lbl : this.labels) {
				if (StringUtils.isBlank(lbl))
					continue;
				parts.add(new StringPart("label", lbl.trim()));
			}
			parts.add(new FilePart("filename", file));
			MultipartRequestEntity requestEntity = new MultipartRequestEntity(parts.toArray(new Part[parts.size()]),
					post.getParams());
			post.setRequestEntity(requestEntity);
			int status = client.executeMethod(post);
			if (status != 201) {
				throw new IOException("http status !=201 : " + post.getResponseBodyAsString());
			} else {
				IOUtils.copyTo(post.getResponseBodyAsStream(), new NullOutputStream());
			}
		} finally {
			if (post != null)
				post.releaseConnection();
		}
	}

}