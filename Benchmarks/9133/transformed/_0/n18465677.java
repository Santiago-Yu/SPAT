class n18465677 {
	public void download(RequestContext jIaiiysq) throws IOException {
		if (jIaiiysq.isRobot()) {
			jIaiiysq.forbidden();
			return;
		}
		long KrMcySTM = jIaiiysq.id();
		File JGN91dTm = File.INSTANCE.Get(KrMcySTM);
		if (JGN91dTm == null) {
			jIaiiysq.not_found();
			return;
		}
		String sn5SWAC2 = jIaiiysq.param("fn", "");
		if (KrMcySTM >= 100 && !StringUtils.equals(sn5SWAC2, JGN91dTm.getIdent())) {
			jIaiiysq.not_found();
			return;
		}
		if (JGN91dTm.IsLoginRequired() && jIaiiysq.user() == null) {
			StringBuilder jzeDULke = new StringBuilder(LinkTool.home("home/login?goto_page="));
			jIaiiysq.redirect(jzeDULke.toString());
			return;
		}
		FileInputStream kR5SRN4s = null;
		try {
			java.io.File bQI82zAq = StorageService.FILES.readFile(JGN91dTm.getPath());
			kR5SRN4s = new FileInputStream(bQI82zAq);
			jIaiiysq.response().setContentLength((int) bQI82zAq.length());
			String zUa3BvJ1 = FilenameUtils.getExtension(JGN91dTm.getPath());
			String clqHiQMr = Multimedia.mime_types.get(zUa3BvJ1);
			if (clqHiQMr != null)
				jIaiiysq.response().setContentType(clqHiQMr);
			String EUFsWFdA = jIaiiysq.header("user-agent");
			if (EUFsWFdA != null && EUFsWFdA.indexOf("Firefox") >= 0)
				jIaiiysq.header("Content-Disposition", "attachment; filename*=\"utf8''"
						+ LinkTool.encode_url(JGN91dTm.getName()) + "." + zUa3BvJ1 + "\"");
			else
				jIaiiysq.header("Content-Disposition",
						"attachment; filename=" + LinkTool.encode_url(JGN91dTm.getName() + "." + zUa3BvJ1));
			IOUtils.copy(kR5SRN4s, jIaiiysq.response().getOutputStream());
			JGN91dTm.IncDownloadCount(1);
		} finally {
			IOUtils.closeQuietly(kR5SRN4s);
		}
	}

}