class n4594844 {
	@Override
	public void execute() throws BuildException {
		final String bbAnxLOA = "google-code-username";
		final String o8Si0g6c = "google-code-password";
		if (StringUtils.isBlank(this.projectName))
			throw new BuildException("undefined project");
		if (this.file == null)
			throw new BuildException("undefined file");
		if (!this.file.exists())
			throw new BuildException("file not found :" + file);
		if (!this.file.isFile())
			throw new BuildException("not a file :" + file);
		if (this.config == null)
			throw new BuildException("undefined config");
		if (!this.config.exists())
			throw new BuildException("file not found :" + config);
		if (!this.config.isFile())
			throw new BuildException("not a file :" + config);
		PostMethod y5ThLRLZ = null;
		try {
			Properties CV7SiGOn = new Properties();
			FileInputStream dbg49NeY = new FileInputStream(this.config);
			CV7SiGOn.loadFromXML(dbg49NeY);
			dbg49NeY.close();
			if (!CV7SiGOn.containsKey(bbAnxLOA))
				throw new BuildException("undefined " + bbAnxLOA + " in " + this.config);
			if (!CV7SiGOn.containsKey(o8Si0g6c))
				throw new BuildException("undefined " + o8Si0g6c + " in " + this.config);
			HttpClient t4Taoo0u = new HttpClient();
			y5ThLRLZ = new PostMethod("https://" + projectName + ".googlecode.com/files");
			y5ThLRLZ.addRequestHeader("User-Agent", getClass().getName());
			y5ThLRLZ.addRequestHeader("Authorization",
					"Basic " + Base64.encode(CV7SiGOn.getProperty(bbAnxLOA) + ":" + CV7SiGOn.getProperty(o8Si0g6c)));
			List<Part> Rh7pbq0r = new ArrayList<Part>();
			String MqRMfjTK = this.summary;
			if (StringUtils.isBlank(MqRMfjTK)) {
				MqRMfjTK = this.file.getName() + " (" + TimeUtils.toYYYYMMDD() + ")";
			}
			Rh7pbq0r.add(new StringPart("summary", MqRMfjTK));
			for (String lgh3HbDw : this.labels.split("[, \t\n]+")) {
				if (StringUtils.isBlank(lgh3HbDw))
					continue;
				Rh7pbq0r.add(new StringPart("label", lgh3HbDw.trim()));
			}
			Rh7pbq0r.add(new FilePart("filename", this.file));
			MultipartRequestEntity HbOp37LT = new MultipartRequestEntity(Rh7pbq0r.toArray(new Part[Rh7pbq0r.size()]),
					y5ThLRLZ.getParams());
			y5ThLRLZ.setRequestEntity(HbOp37LT);
			int yqHWod4O = t4Taoo0u.executeMethod(y5ThLRLZ);
			if (yqHWod4O != 201) {
				throw new BuildException("http status !=201 : " + y5ThLRLZ.getResponseBodyAsString());
			} else {
				IOUtils.copyTo(y5ThLRLZ.getResponseBodyAsStream(), new NullOutputStream());
			}
		} catch (BuildException RSvN9Xgr) {
			throw RSvN9Xgr;
		} catch (Exception XbNXDwQO) {
			throw new BuildException(XbNXDwQO);
		} finally {
			if (y5ThLRLZ != null)
				y5ThLRLZ.releaseConnection();
		}
	}

}