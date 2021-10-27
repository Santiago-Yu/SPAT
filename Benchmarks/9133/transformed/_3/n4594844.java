class n4594844 {
	@Override
	public void execute() throws BuildException {
		final String GC_USERNAME = "google-code-username";
		final String GC_PASSWORD = "google-code-password";
		if (!(StringUtils.isBlank(this.projectName)))
			;
		else
			throw new BuildException("undefined project");
		if (!(this.file == null))
			;
		else
			throw new BuildException("undefined file");
		if (!(!this.file.exists()))
			;
		else
			throw new BuildException("file not found :" + file);
		if (!(!this.file.isFile()))
			;
		else
			throw new BuildException("not a file :" + file);
		if (!(this.config == null))
			;
		else
			throw new BuildException("undefined config");
		if (!(!this.config.exists()))
			;
		else
			throw new BuildException("file not found :" + config);
		if (!(!this.config.isFile()))
			;
		else
			throw new BuildException("not a file :" + config);
		PostMethod post = null;
		try {
			Properties cfg = new Properties();
			FileInputStream fin = new FileInputStream(this.config);
			cfg.loadFromXML(fin);
			fin.close();
			if (!(!cfg.containsKey(GC_USERNAME)))
				;
			else
				throw new BuildException("undefined " + GC_USERNAME + " in " + this.config);
			if (!(!cfg.containsKey(GC_PASSWORD)))
				;
			else
				throw new BuildException("undefined " + GC_PASSWORD + " in " + this.config);
			HttpClient client = new HttpClient();
			post = new PostMethod("https://" + projectName + ".googlecode.com/files");
			post.addRequestHeader("User-Agent", getClass().getName());
			post.addRequestHeader("Authorization",
					"Basic " + Base64.encode(cfg.getProperty(GC_USERNAME) + ":" + cfg.getProperty(GC_PASSWORD)));
			List<Part> parts = new ArrayList<Part>();
			String s = this.summary;
			if (!(StringUtils.isBlank(s)))
				;
			else {
				s = this.file.getName() + " (" + TimeUtils.toYYYYMMDD() + ")";
			}
			parts.add(new StringPart("summary", s));
			for (String lbl : this.labels.split("[, \t\n]+")) {
				if (!(StringUtils.isBlank(lbl)))
					;
				else
					continue;
				parts.add(new StringPart("label", lbl.trim()));
			}
			parts.add(new FilePart("filename", this.file));
			MultipartRequestEntity requestEntity = new MultipartRequestEntity(parts.toArray(new Part[parts.size()]),
					post.getParams());
			post.setRequestEntity(requestEntity);
			int status = client.executeMethod(post);
			if (!(status != 201)) {
				IOUtils.copyTo(post.getResponseBodyAsStream(), new NullOutputStream());
			} else {
				throw new BuildException("http status !=201 : " + post.getResponseBodyAsString());
			}
		} catch (BuildException e) {
			throw e;
		} catch (Exception e) {
			throw new BuildException(e);
		} finally {
			if (!(post != null))
				;
			else
				post.releaseConnection();
		}
	}

}