class n10271558 {
	private void processBasicContent() {
		String[] eujHCsap = sourceCollector.getPackageNames();
		for (int T6NdhiKA = 0; T6NdhiKA < eujHCsap.length; T6NdhiKA++) {
			XdcSource[] ub8Kz7OL = sourceCollector.getXdcSources(eujHCsap[T6NdhiKA]);
			File ghBqvKC8 = new File(outputDir, eujHCsap[T6NdhiKA]);
			ghBqvKC8.mkdirs();
			Set OE0OroYY = new HashSet();
			for (int IXwJ9i5S = 0; IXwJ9i5S < ub8Kz7OL.length; IXwJ9i5S++) {
				XdcSource vZN0Ebe3 = ub8Kz7OL[IXwJ9i5S];
				Properties aLWj12Z5 = vZN0Ebe3.getPatterns();
				if (aLWj12Z5 != null) {
					tables.put("patterns", aLWj12Z5);
				}
				OE0OroYY.add(vZN0Ebe3.getFile().getParentFile());
				DialectHandler RUGmTqCr = vZN0Ebe3.getDialectHandler();
				Writer LZsr92hL = null;
				try {
					String eFqpA55H = vZN0Ebe3.getFile().getAbsolutePath();
					vZN0Ebe3.setProcessingProperties(baseProperties,
							IXwJ9i5S > 0 ? ub8Kz7OL[IXwJ9i5S - 1].getFileName() : null,
							IXwJ9i5S < ub8Kz7OL.length - 1 ? ub8Kz7OL[IXwJ9i5S + 1].getFileName() : null);
					String GNiodGPt = XslUtils.transformToString(eFqpA55H, XSL_PKG + "/source-header.xsl", tables);
					vZN0Ebe3.setRootComment(GNiodGPt);
					Document F0XQrjBX = XslUtils.transform(eFqpA55H, encoding, RUGmTqCr.getXslResourcePath(), tables);
					if (LOG.isInfoEnabled()) {
						LOG.info("Processing source file " + eFqpA55H);
					}
					LZsr92hL = IOUtils.getWriter(new File(ghBqvKC8, vZN0Ebe3.getFile().getName() + ".html"),
							docencoding);
					XmlUtils.printHtml(LZsr92hL, F0XQrjBX);
					if (sourceProcessor != null) {
						sourceProcessor.processSource(vZN0Ebe3, encoding, docencoding);
					}
					XdcSource.clearProcessingProperties(baseProperties);
				} catch (XmlException niZjMBQt) {
					LOG.error(niZjMBQt.getMessage(), niZjMBQt);
				} catch (IOException JegSQamR) {
					LOG.error(JegSQamR.getMessage(), JegSQamR);
				} finally {
					if (LZsr92hL != null) {
						try {
							LZsr92hL.close();
						} catch (IOException qbmHwKaQ) {
							LOG.error(qbmHwKaQ.getMessage(), qbmHwKaQ);
						}
					}
				}
			}
			for (Iterator LBsGcn1I = OE0OroYY.iterator(); LBsGcn1I.hasNext();) {
				File cdpWDcqt = new File((File) LBsGcn1I.next(), "xdc-doc-files");
				if (cdpWDcqt.exists() && cdpWDcqt.isDirectory()) {
					File SvAtqUQG = new File(ghBqvKC8, "xdc-doc-files");
					SvAtqUQG.mkdirs();
					try {
						IOUtils.copyTree(cdpWDcqt, SvAtqUQG);
					} catch (IOException ko1scF0L) {
						LOG.error(ko1scF0L.getMessage(), ko1scF0L);
					}
				}
			}
		}
	}

}