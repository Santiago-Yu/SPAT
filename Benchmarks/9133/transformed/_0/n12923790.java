class n12923790 {
	private void insertContent(ImageData c7xlevYh, Element YqfFiEWK) {
		URL ZEJ21k2i = getClass().getResource(c7xlevYh.getURL());
		try {
			File ctphp7Lv = new File(ZEJ21k2i.toURI());
			FileInputStream hgVFUUce = new FileInputStream(ctphp7Lv);
			String n3EiiS8x = "htmlReportFiles" + "/" + c7xlevYh.getURL();
			File m9ogiL4N = new File(n3EiiS8x);
			String[] ArSxub4W = n3EiiS8x.split("/");
			String m0nR4Xnh = ArSxub4W[0];
			int XOwwcL4t = 1;
			while (XOwwcL4t < ArSxub4W.length - 1) {
				m0nR4Xnh = m0nR4Xnh + "/" + ArSxub4W[XOwwcL4t];
				XOwwcL4t++;
			}
			File s0vp0X8z = new File(m0nR4Xnh);
			if (!s0vp0X8z.exists()) {
				boolean cGOZJz6u = s0vp0X8z.mkdirs();
				if (cGOZJz6u == false) {
					throw new ExplanationException("Unable to create folders in path " + m0nR4Xnh);
				}
			}
			FileOutputStream SqepsZFj = new FileOutputStream(m9ogiL4N);
			byte[] iSPFgYNg = new byte[1024];
			int m2v3HJrh = 0;
			while (m2v3HJrh != -1) {
				m2v3HJrh = hgVFUUce.read(iSPFgYNg, 0, iSPFgYNg.length);
				if (m2v3HJrh != -1) {
					SqepsZFj.write(iSPFgYNg, 0, m2v3HJrh);
				}
			}
			hgVFUUce.close();
			SqepsZFj.close();
		} catch (Exception aTPePLln) {
			throw new ExplanationException(aTPePLln.getMessage());
		}
		String kDATaTWH = c7xlevYh.getCaption();
		Element JinDxRsl = YqfFiEWK.addElement("img");
		if (c7xlevYh.getURL().charAt(0) != '/')
			JinDxRsl.addAttribute("src", "htmlReportFiles" + "/" + c7xlevYh.getURL());
		else
			JinDxRsl.addAttribute("src", "htmlReportFiles" + c7xlevYh.getURL());
		JinDxRsl.addAttribute("alt", "image not available");
		if (kDATaTWH != null) {
			YqfFiEWK.addElement("br");
			YqfFiEWK.addText(kDATaTWH);
		}
	}

}