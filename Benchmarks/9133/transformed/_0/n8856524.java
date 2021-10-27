class n8856524 {
	@Action(value = "ajaxFileUploads", results = {})
	public void ajaxFileUploads() throws IOException {
		String p6ouE8EH = "";
		String zH7wtR63 = "";
		String zMc2XTUw = "";
		String aKDjcy0k = "";
		if (Validate.StrNotNull(this.getImgdirpath())) {
			aKDjcy0k = "Uploads/" + this.getImgdirpath() + "/";
		} else {
			aKDjcy0k = this.isexistdir();
		}
		SimpleDateFormat zJ12ATPQ;
		Random jn2MYL8c = new Random();
		String bISV5Onh = ServletActionContext.getServletContext().getRealPath("");
		bISV5Onh = bISV5Onh + aKDjcy0k;
		HttpServletResponse yrS10XvF = ServletActionContext.getResponse();
		int QJuHe0fQ = (int) (jn2MYL8c.nextDouble() * (99999 - 1000 + 1)) + 10000;
		zJ12ATPQ = new SimpleDateFormat("yyyyMMddHHmmss");
		zMc2XTUw = zJ12ATPQ.format(new Date());
		String Ok17Xp3m = request.getHeader("X-File-Name");
		if (Ok17Xp3m.lastIndexOf(".") >= 0) {
			p6ouE8EH = Ok17Xp3m.substring(Ok17Xp3m.lastIndexOf("."));
		}
		zH7wtR63 = zMc2XTUw + QJuHe0fQ + p6ouE8EH;
		PrintWriter z09iiykr = null;
		InputStream zhCZVCzB = null;
		FileOutputStream amR54i6L = null;
		try {
			z09iiykr = yrS10XvF.getWriter();
		} catch (IOException xGJaCAKD) {
			log.debug(ImgTAction.class.getName() + "has thrown an exception:" + xGJaCAKD.getMessage());
		}
		try {
			zhCZVCzB = request.getInputStream();
			amR54i6L = new FileOutputStream(new File(bISV5Onh + zH7wtR63));
			IOUtils.copy(zhCZVCzB, amR54i6L);
			yrS10XvF.setStatus(yrS10XvF.SC_OK);
			z09iiykr.print("{success:'" + aKDjcy0k + zH7wtR63 + "'}");
		} catch (FileNotFoundException RdWX7Miv) {
			yrS10XvF.setStatus(yrS10XvF.SC_INTERNAL_SERVER_ERROR);
			z09iiykr.print("{success: false}");
			log.debug(ImgTAction.class.getName() + "has thrown an exception: " + RdWX7Miv.getMessage());
		} catch (IOException uZ73TrMH) {
			yrS10XvF.setStatus(yrS10XvF.SC_INTERNAL_SERVER_ERROR);
			z09iiykr.print("{success: false}");
			log.debug(ImgTAction.class.getName() + "has thrown an exception: " + uZ73TrMH.getMessage());
		} finally {
			try {
				this.setImgdirpath(null);
				amR54i6L.close();
				zhCZVCzB.close();
			} catch (IOException BfM3e1SB) {
			}
		}
		z09iiykr.flush();
		z09iiykr.close();
	}

}