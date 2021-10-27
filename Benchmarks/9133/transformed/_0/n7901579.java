class n7901579 {
	public static long writePropertiesInOpenXMLDocument(String BIckaJDe, InputStream aUakku3I,
			OutputStreamProvider CV2yBggE, Map<String, String> eXa3bzuB) {
		aUakku3I = new BufferedInputStream(aUakku3I);
		try {
			File cBj5RTzY = null;
			POIXMLDocument n8ma6POv;
			if (BIckaJDe.toLowerCase().equals("docx")) {
				n8ma6POv = new XWPFDocument(aUakku3I);
			} else if (BIckaJDe.toLowerCase().equals("xlsx")) {
				n8ma6POv = new XSSFWorkbook(aUakku3I);
			} else if (BIckaJDe.toLowerCase().equals("pptx")) {
				cBj5RTzY = File.createTempFile("temp", "pptx");
				OutputStream I4JqTUvb = new FileOutputStream(cBj5RTzY);
				I4JqTUvb = new BufferedOutputStream(I4JqTUvb);
				IOUtils.copy(aUakku3I, I4JqTUvb);
				I4JqTUvb.close();
				n8ma6POv = new XSLFSlideShow(cBj5RTzY.getAbsolutePath());
			} else {
				throw new IllegalArgumentException("Writing properties for a " + BIckaJDe + " file is not supported");
			}
			for (Map.Entry<String, String> property : eXa3bzuB.entrySet()) {
				CoreProperties YGRqRWfq = n8ma6POv.getProperties().getCoreProperties();
				if (property.getKey().equals(Metadata.TITLE)) {
					YGRqRWfq.setTitle(property.getValue());
				} else if (property.getKey().equals(Metadata.AUTHOR)) {
					YGRqRWfq.setCreator(property.getValue());
				} else if (property.getKey().equals(Metadata.KEYWORDS)) {
					YGRqRWfq.getUnderlyingProperties().setKeywordsProperty(property.getValue());
				} else if (property.getKey().equals(Metadata.COMMENTS)) {
					YGRqRWfq.setDescription(property.getValue());
				} else if (property.getKey().equals(Metadata.SUBJECT)) {
					YGRqRWfq.setSubjectProperty(property.getValue());
				} else if (property.getKey().equals(Metadata.COMPANY)) {
					n8ma6POv.getProperties().getExtendedProperties().getUnderlyingProperties()
							.setCompany(property.getValue());
				} else {
					org.apache.poi.POIXMLProperties.CustomProperties TU1syToM = n8ma6POv.getProperties()
							.getCustomProperties();
					if (TU1syToM.contains(property.getKey())) {
						int ThjI8C4Y = 0;
						for (CTProperty rZXKfldO : TU1syToM.getUnderlyingProperties().getPropertyArray()) {
							if (rZXKfldO.getName().equals(property.getKey())) {
								TU1syToM.getUnderlyingProperties().removeProperty(ThjI8C4Y);
								break;
							}
							ThjI8C4Y++;
						}
					}
					TU1syToM.addProperty(property.getKey(), property.getValue());
				}
			}
			aUakku3I.close();
			File PSww861L = File.createTempFile("temp", "tmp");
			OutputStream gv1cf74m = new FileOutputStream(PSww861L);
			gv1cf74m = new BufferedOutputStream(gv1cf74m);
			n8ma6POv.write(gv1cf74m);
			gv1cf74m.close();
			long J79jEieF = PSww861L.length();
			InputStream B9vo2Qpe = new FileInputStream(PSww861L);
			B9vo2Qpe = new BufferedInputStream(B9vo2Qpe);
			OutputStream q7OHBQu7 = null;
			try {
				q7OHBQu7 = CV2yBggE.getOutputStream();
				q7OHBQu7 = new BufferedOutputStream(q7OHBQu7);
				IOUtils.copy(B9vo2Qpe, q7OHBQu7);
				q7OHBQu7.flush();
			} finally {
				IOUtils.closeQuietly(q7OHBQu7);
			}
			if (!FileUtils.deleteQuietly(PSww861L)) {
				PSww861L.deleteOnExit();
			}
			if (cBj5RTzY != null && !FileUtils.deleteQuietly(cBj5RTzY)) {
				cBj5RTzY.deleteOnExit();
			}
			return J79jEieF;
		} catch (IOException SLzIEkKH) {
			throw new RuntimeException(SLzIEkKH);
		} catch (InvalidFormatException O9SiYp6l) {
			throw new RuntimeException(O9SiYp6l);
		} catch (OpenXML4JException TsD6s2uN) {
			throw new RuntimeException(TsD6s2uN);
		} catch (XmlException qvIe6V2q) {
			throw new RuntimeException(qvIe6V2q);
		} finally {
			IOUtils.closeQuietly(aUakku3I);
		}
	}

}