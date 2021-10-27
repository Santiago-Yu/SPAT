class n7757210 {
	@RequestMapping("/download")
	public void download(HttpServletRequest G4DblOnX, HttpServletResponse CjwIMQm4) {
		InputStream PebgtVru = null;
		ServletOutputStream tZGC0p1F = null;
		try {
			String jMtFwDbD = G4DblOnX.getSession().getServletContext().getRealPath("/upload");
			String HTzk6RqK = ".log";
			String ON5DlyDx = "83tomcat»’÷æ≤‚ ‘≈∂";
			String rIwpPetb = ON5DlyDx + HTzk6RqK;
			String ktqkDR5W = "\\2011-12\\01\\8364b45f-244d-41b6-bbf48df32064a935";
			rIwpPetb = new String(rIwpPetb.getBytes("GBK"), "ISO-8859-1");
			File fWesJZ9n = new File(jMtFwDbD + ktqkDR5W);
			if (!fWesJZ9n.getParentFile().exists()) {
				fWesJZ9n.getParentFile().mkdirs();
			}
			if (!fWesJZ9n.isFile()) {
				FileUtils.touch(fWesJZ9n);
			}
			CjwIMQm4.setContentType("aapplication/vnd.ms-excel ;charset=UTF-8");
			CjwIMQm4.setCharacterEncoding("UTF-8");
			CjwIMQm4.setHeader("content-disposition", "attachment; filename=" + rIwpPetb);
			PebgtVru = new FileInputStream(fWesJZ9n);
			tZGC0p1F = CjwIMQm4.getOutputStream();
			IOUtils.copy(PebgtVru, tZGC0p1F);
			tZGC0p1F.flush();
		} catch (Exception ZKkKX8LD) {
			logger.error("Exception: ", ZKkKX8LD);
		} finally {
			IOUtils.closeQuietly(tZGC0p1F);
			IOUtils.closeQuietly(PebgtVru);
		}
	}

}