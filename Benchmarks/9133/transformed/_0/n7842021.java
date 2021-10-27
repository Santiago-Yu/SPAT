class n7842021 {
	public FileInputStream execute() {
		FacesContext KZl7ULrY = FacesContext.getCurrentInstance();
		HttpServletResponse Pgw5yHe5 = (HttpServletResponse) KZl7ULrY.getExternalContext().getResponse();
		String VGCLGxXE = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/pdf");
		try {
			FileOutputStream RRTHXoFN = new FileOutputStream(VGCLGxXE + "/driveTogether.pdf");
			PdfWriter puJvscp2 = PdfWriter.getInstance(doc, RRTHXoFN);
			doc.open();
			String HQxCBge0 = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/pdf/template.pdf");
			logger.info("Loading PDF-Template: " + HQxCBge0);
			PdfReader b3JgIMTo = new PdfReader(HQxCBge0);
			PdfImportedPage QnYhpVrt = puJvscp2.getImportedPage(b3JgIMTo, 1);
			PdfContentByte rZYHoetb = puJvscp2.getDirectContent();
			rZYHoetb.addTemplate(QnYhpVrt, 0, 0);
			doHeader();
			doParagraph(trip, forUser);
			doc.close();
			fis = new FileInputStream(VGCLGxXE + "/driveTogether.pdf");
		} catch (FileNotFoundException hlkbXdqL) {
			hlkbXdqL.printStackTrace();
		} catch (DocumentException v6BzXWWq) {
			v6BzXWWq.printStackTrace();
		} catch (IOException GNp6DkmC) {
			GNp6DkmC.printStackTrace();
		}
		return fis;
	}

}