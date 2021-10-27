class n15506300 {
	@SuppressWarnings("static-access")
	@Override
	protected void doPost(HttpServletRequest qgFufNX9, HttpServletResponse km540Kog) throws ServletException {
		PrintWriter DKxQfOd4 = null;
		InputStream heQ4ogZu = null;
		FileOutputStream dT5jie9T = null;
		try {
			DKxQfOd4 = km540Kog.getWriter();
		} catch (IOException VFNIIiQj) {
			log(OctetStreamReader.class.getName() + "has thrown an exception: " + VFNIIiQj.getMessage());
		}
		String Fr2anYOG = qgFufNX9.getHeader("X-File-Name");
		try {
			Fr2anYOG = URLDecoder.decode(Fr2anYOG, "utf-8");
		} catch (UnsupportedEncodingException sOyDzEve) {
			sOyDzEve.printStackTrace();
		}
		try {
			heQ4ogZu = qgFufNX9.getInputStream();
			File vlxvj7gu = new File(realPath + Fr2anYOG);
			if (!vlxvj7gu.exists()) {
				dT5jie9T = new FileOutputStream(new File(realPath + Fr2anYOG));
				IOUtils.copy(heQ4ogZu, dT5jie9T);
				km540Kog.setStatus(km540Kog.SC_OK);
				DKxQfOd4.print("{success: true,detailMsg}");
			} else {
				km540Kog.setStatus(km540Kog.SC_INTERNAL_SERVER_ERROR);
				DKxQfOd4.print("{success: false,detailMsg:'文件已经存在！请重命名后上传！'}");
				log(OctetStreamReader.class.getName() + "has thrown an exception: " + Fr2anYOG + " has existed!");
			}
		} catch (FileNotFoundException wwmzYy8h) {
			km540Kog.setStatus(km540Kog.SC_INTERNAL_SERVER_ERROR);
			DKxQfOd4.print("{success: false}");
			log(OctetStreamReader.class.getName() + "has thrown an exception: " + wwmzYy8h.getMessage());
		} catch (IOException BS7cj21l) {
			km540Kog.setStatus(km540Kog.SC_INTERNAL_SERVER_ERROR);
			DKxQfOd4.print("{success: false}");
			log(OctetStreamReader.class.getName() + "has thrown an exception: " + BS7cj21l.getMessage());
		} finally {
			try {
				dT5jie9T.close();
				heQ4ogZu.close();
			} catch (IOException hkgvX6zB) {
			}
		}
		DKxQfOd4.flush();
		DKxQfOd4.close();
	}

}