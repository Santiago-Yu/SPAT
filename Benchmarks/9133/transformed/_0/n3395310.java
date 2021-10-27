class n3395310 {
	private void execute(File tu2BXfvn) throws IOException {
		if (tu2BXfvn == null)
			throw new RuntimeException("undefined file");
		if (!tu2BXfvn.exists())
			throw new RuntimeException("file not found :" + tu2BXfvn);
		if (!tu2BXfvn.isFile())
			throw new RuntimeException("not a file :" + tu2BXfvn);
		String LVXWlCvJ = cfg.getProperty(GC_USERNAME);
		String STylnAT5 = null;
		if (cfg.containsKey(GC_PASSWORD)) {
			STylnAT5 = cfg.getProperty(GC_PASSWORD);
		} else {
			STylnAT5 = new String(Base64.decode(cfg.getProperty(GC_PASSWORD64)));
		}
		PostMethod D64S9uGM = null;
		try {
			HttpClient i2oq0W1E = new HttpClient();
			D64S9uGM = new PostMethod("https://" + projectName + ".googlecode.com/files");
			D64S9uGM.addRequestHeader("User-Agent", getClass().getName());
			D64S9uGM.addRequestHeader("Authorization", "Basic " + Base64.encode(LVXWlCvJ + ":" + STylnAT5));
			List<Part> gSOntI1A = new ArrayList<Part>();
			String NBdyaCZj = this.summary;
			if (StringUtils.isBlank(NBdyaCZj)) {
				NBdyaCZj = tu2BXfvn.getName() + " (" + TimeUtils.toYYYYMMDD() + ")";
			}
			gSOntI1A.add(new StringPart("summary", NBdyaCZj));
			for (String FZaxTaNj : this.labels) {
				if (StringUtils.isBlank(FZaxTaNj))
					continue;
				gSOntI1A.add(new StringPart("label", FZaxTaNj.trim()));
			}
			gSOntI1A.add(new FilePart("filename", tu2BXfvn));
			MultipartRequestEntity PkMHCPWA = new MultipartRequestEntity(gSOntI1A.toArray(new Part[gSOntI1A.size()]),
					D64S9uGM.getParams());
			D64S9uGM.setRequestEntity(PkMHCPWA);
			int IyHqnrId = i2oq0W1E.executeMethod(D64S9uGM);
			if (IyHqnrId != 201) {
				throw new IOException("http status !=201 : " + D64S9uGM.getResponseBodyAsString());
			} else {
				IOUtils.copyTo(D64S9uGM.getResponseBodyAsStream(), new NullOutputStream());
			}
		} finally {
			if (D64S9uGM != null)
				D64S9uGM.releaseConnection();
		}
	}

}