class n7901588 {
	public static long removePropertyInOpenXMLDocument(String n5W4guZh, InputStream hBNXL86A,
			OutputStreamProvider ravxnhbl, String hf6okIWR) {
		hBNXL86A = new BufferedInputStream(hBNXL86A);
		try {
			File UyjA2vyg = null;
			POIXMLDocument HVrC9gYb;
			if (n5W4guZh.toLowerCase().equals("docx")) {
				HVrC9gYb = new XWPFDocument(hBNXL86A);
			} else if (n5W4guZh.toLowerCase().equals("xlsx")) {
				HVrC9gYb = new XSSFWorkbook(hBNXL86A);
			} else if (n5W4guZh.toLowerCase().equals("pptx")) {
				UyjA2vyg = File.createTempFile("temp", "pptx");
				OutputStream P74AAAlW = new FileOutputStream(UyjA2vyg);
				P74AAAlW = new BufferedOutputStream(P74AAAlW);
				IOUtils.copy(hBNXL86A, P74AAAlW);
				P74AAAlW.close();
				HVrC9gYb = new XSLFSlideShow(UyjA2vyg.getAbsolutePath());
			} else {
				throw new IllegalArgumentException("Writing properties for a " + n5W4guZh + " file is not supported");
			}
			CoreProperties RVAJCsCa = HVrC9gYb.getProperties().getCoreProperties();
			if (hf6okIWR.equals(Metadata.TITLE)) {
				RVAJCsCa.setTitle("");
			} else if (hf6okIWR.equals(Metadata.AUTHOR)) {
				RVAJCsCa.setCreator("");
			} else if (hf6okIWR.equals(Metadata.KEYWORDS)) {
				RVAJCsCa.getUnderlyingProperties().setKeywordsProperty("");
			} else if (hf6okIWR.equals(Metadata.COMMENTS)) {
				RVAJCsCa.setDescription("");
			} else if (hf6okIWR.equals(Metadata.SUBJECT)) {
				RVAJCsCa.setSubjectProperty("");
			} else if (hf6okIWR.equals(Metadata.COMPANY)) {
				HVrC9gYb.getProperties().getExtendedProperties().getUnderlyingProperties().setCompany("");
			} else {
				org.apache.poi.POIXMLProperties.CustomProperties U6JhFObn = HVrC9gYb.getProperties()
						.getCustomProperties();
				if (U6JhFObn.contains(hf6okIWR)) {
					int Mkxi2zUC = 0;
					for (CTProperty zPZ3LGwR : U6JhFObn.getUnderlyingProperties().getPropertyArray()) {
						if (zPZ3LGwR.getName().equals(hf6okIWR)) {
							U6JhFObn.getUnderlyingProperties().removeProperty(Mkxi2zUC);
							break;
						}
						Mkxi2zUC++;
					}
				}
			}
			hBNXL86A.close();
			File i8wBoizp = File.createTempFile("temp", "tmp");
			OutputStream PtbTCC2k = new FileOutputStream(i8wBoizp);
			PtbTCC2k = new BufferedOutputStream(PtbTCC2k);
			HVrC9gYb.write(PtbTCC2k);
			PtbTCC2k.close();
			long FLfg1rf0 = i8wBoizp.length();
			InputStream usObnTMN = new FileInputStream(i8wBoizp);
			usObnTMN = new BufferedInputStream(usObnTMN);
			OutputStream MZDDrDI9 = null;
			try {
				MZDDrDI9 = ravxnhbl.getOutputStream();
				MZDDrDI9 = new BufferedOutputStream(MZDDrDI9);
				IOUtils.copy(usObnTMN, MZDDrDI9);
				MZDDrDI9.flush();
			} finally {
				IOUtils.closeQuietly(MZDDrDI9);
			}
			if (!FileUtils.deleteQuietly(i8wBoizp)) {
				i8wBoizp.deleteOnExit();
			}
			if (UyjA2vyg != null && !FileUtils.deleteQuietly(UyjA2vyg)) {
				UyjA2vyg.deleteOnExit();
			}
			return FLfg1rf0;
		} catch (IOException m1dqNjB9) {
			throw new RuntimeException(m1dqNjB9);
		} catch (InvalidFormatException a10iiB9W) {
			throw new RuntimeException(a10iiB9W);
		} catch (OpenXML4JException XP7WCGGx) {
			throw new RuntimeException(XP7WCGGx);
		} catch (XmlException m3XSe8LV) {
			throw new RuntimeException(m3XSe8LV);
		}
	}

}