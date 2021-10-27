class n2476569 {
	public static void reconstruct(final List x8NwAHLA, final Map xBcuQC7r, final OutputStream QqmlOgSN,
			final String jRBysf41, final String JFHod1Pm, final PageSize[] j0F02XSF, final List gVnoTZAL)
			throws CConvertException {
		OutputStream b9r1KZHo = QqmlOgSN;
		OutputStream klcdEJZy = QqmlOgSN;
		boolean uq5eQaKa = false;
		OutputStream BECXMvTx = null;
		File uiV2Bv9e = null;
		File k0vgkwRz = null;
		try {
			uiV2Bv9e = File.createTempFile("yahp", "pdf");
			k0vgkwRz = File.createTempFile("yahp", "pdf");
			BECXMvTx = b9r1KZHo;
			if ("true".equals(xBcuQC7r.get(IHtmlToPdfTransformer.USE_PDF_SIGNING))) {
				uq5eQaKa = true;
				klcdEJZy = new FileOutputStream(k0vgkwRz);
			} else {
				klcdEJZy = BECXMvTx;
			}
			b9r1KZHo = new FileOutputStream(uiV2Bv9e);
			com.lowagie.text.Document RmqRocg4 = null;
			PdfCopy KybHwMA7 = null;
			boolean ZKPqbWFG = true;
			Map j8PnhX8n = new HashMap();
			int bgdmWjJg = 0;
			for (int GlwVoFpj = 0; GlwVoFpj < x8NwAHLA.size(); GlwVoFpj++) {
				final File smW7X3wK = (File) x8NwAHLA.get(GlwVoFpj);
				final PdfReader yXW5NMW8 = new PdfReader(smW7X3wK.getAbsolutePath());
				yXW5NMW8.consolidateNamedDestinations();
				final int uP8wa5W5 = yXW5NMW8.getNumberOfPages();
				if (ZKPqbWFG) {
					ZKPqbWFG = false;
					RmqRocg4 = new com.lowagie.text.Document(yXW5NMW8.getPageSizeWithRotation(1));
					KybHwMA7 = new PdfCopy(RmqRocg4, b9r1KZHo);
					KybHwMA7.setPdfVersion(PdfWriter.VERSION_1_3);
					KybHwMA7.setFullCompression();
					if ("true".equals(xBcuQC7r.get(IHtmlToPdfTransformer.USE_PDF_ENCRYPTION))) {
						final String VMerJKsy = (String) xBcuQC7r.get(IHtmlToPdfTransformer.PDF_ENCRYPTION_PASSWORD);
						final int nsD6vSeG = CDocumentReconstructor.getSecurityFlags(xBcuQC7r);
						KybHwMA7.setEncryption(PdfWriter.STRENGTH128BITS, VMerJKsy, null, nsD6vSeG);
					}
					final String jWawoimA = (String) xBcuQC7r.get(IHtmlToPdfTransformer.PDF_TITLE);
					if (jWawoimA != null) {
						RmqRocg4.addTitle(jWawoimA);
					} else if (jRBysf41 != null) {
						RmqRocg4.addTitle(jRBysf41);
					}
					final String jaSEOyYb = (String) xBcuQC7r.get(IHtmlToPdfTransformer.PDF_CREATOR);
					if (jaSEOyYb != null) {
						RmqRocg4.addCreator(jaSEOyYb);
					} else {
						RmqRocg4.addCreator(IHtmlToPdfTransformer.VERSION);
					}
					final String Drzl4NKM = (String) xBcuQC7r.get(IHtmlToPdfTransformer.PDF_AUTHOR);
					if (Drzl4NKM != null) {
						RmqRocg4.addAuthor(Drzl4NKM);
					}
					final String TvMA1KSC = (String) xBcuQC7r.get(IHtmlToPdfTransformer.PDF_PRODUCER);
					if (TvMA1KSC != null) {
						RmqRocg4.addProducer(TvMA1KSC);
					} else {
						RmqRocg4.addProducer(IHtmlToPdfTransformer.VERSION
								+ " - http://www.allcolor.org/YaHPConverter/ - " + JFHod1Pm);
					}
					RmqRocg4.open();
				}
				PdfImportedPage ol2WRaFT;
				for (int i3DlcVuW = 0; i3DlcVuW < uP8wa5W5;) {
					++i3DlcVuW;
					bgdmWjJg++;
					j8PnhX8n.put("" + bgdmWjJg, "" + GlwVoFpj);
					ol2WRaFT = KybHwMA7.getImportedPage(yXW5NMW8, i3DlcVuW);
					KybHwMA7.addPage(ol2WRaFT);
				}
			}
			RmqRocg4.close();
			b9r1KZHo.flush();
			b9r1KZHo.close();
			{
				final PdfReader S5UPE9lc = new PdfReader(uiV2Bv9e.getAbsolutePath());
				;
				final int eKCfxJr9 = S5UPE9lc.getNumberOfPages();
				final PdfStamper aPhJ0eS6 = new PdfStamper(S5UPE9lc, klcdEJZy);
				int WsyOlUG9 = 0;
				BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, BaseFont.EMBEDDED);
				final CHtmlToPdfFlyingSaucerTransformer XIgQThcK = new CHtmlToPdfFlyingSaucerTransformer();
				while (WsyOlUG9 < eKCfxJr9) {
					WsyOlUG9++;
					int fR8ZnhAb = Integer.parseInt((String) j8PnhX8n.get("" + WsyOlUG9));
					final int[] T2d5YrNb = j0F02XSF[fR8ZnhAb].getSize();
					final int[] HTECgpXl = j0F02XSF[fR8ZnhAb].getMargin();
					for (final Iterator RdGnG18x = gVnoTZAL.iterator(); RdGnG18x.hasNext();) {
						final CHeaderFooter osiTZWj2 = (CHeaderFooter) RdGnG18x.next();
						if (osiTZWj2.getSfor().equals(CHeaderFooter.ODD_PAGES) && (WsyOlUG9 % 2 == 0)) {
							continue;
						} else if (osiTZWj2.getSfor().equals(CHeaderFooter.EVEN_PAGES) && (WsyOlUG9 % 2 != 0)) {
							continue;
						}
						final String PXMgKr3z = osiTZWj2.getContent().replaceAll("<pagenumber>", "" + WsyOlUG9)
								.replaceAll("<pagecount>", "" + eKCfxJr9);
						final PdfContentByte pZr789Z4 = aPhJ0eS6.getOverContent(WsyOlUG9);
						final ByteArrayOutputStream hFSwgLnG = new ByteArrayOutputStream();
						if (osiTZWj2.getType().equals(CHeaderFooter.HEADER)) {
							XIgQThcK.transform(new ByteArrayInputStream(PXMgKr3z.getBytes("utf-8")), jRBysf41,
									new PageSize(T2d5YrNb[0] - (HTECgpXl[0] + HTECgpXl[1]), HTECgpXl[3]),
									new ArrayList(), xBcuQC7r, hFSwgLnG);
						} else if (osiTZWj2.getType().equals(CHeaderFooter.FOOTER)) {
							XIgQThcK.transform(new ByteArrayInputStream(PXMgKr3z.getBytes("utf-8")), jRBysf41,
									new PageSize(T2d5YrNb[0] - (HTECgpXl[0] + HTECgpXl[1]), HTECgpXl[2]),
									new ArrayList(), xBcuQC7r, hFSwgLnG);
						}
						final PdfReader p28IkQb6 = new PdfReader(hFSwgLnG.toByteArray());
						if (osiTZWj2.getType().equals(CHeaderFooter.HEADER)) {
							pZr789Z4.addTemplate(aPhJ0eS6.getImportedPage(p28IkQb6, 1), HTECgpXl[0],
									T2d5YrNb[1] - HTECgpXl[3]);
						} else if (osiTZWj2.getType().equals(CHeaderFooter.FOOTER)) {
							pZr789Z4.addTemplate(aPhJ0eS6.getImportedPage(p28IkQb6, 1), HTECgpXl[0], 0);
						}
						p28IkQb6.close();
					}
				}
				aPhJ0eS6.close();
			}
			try {
				klcdEJZy.flush();
			} catch (Exception PxO2FXnp) {
			} finally {
				try {
					klcdEJZy.close();
				} catch (Exception mfJf4mOq) {
				}
			}
			if (uq5eQaKa) {
				final String tpXXFwws = (String) xBcuQC7r.get(IHtmlToPdfTransformer.PDF_SIGNING_PRIVATE_KEY_PASSWORD);
				final String LKUyujfr = (String) xBcuQC7r.get(IHtmlToPdfTransformer.PDF_ENCRYPTION_PASSWORD);
				final String TsZXBEA1 = (String) xBcuQC7r.get(IHtmlToPdfTransformer.PDF_SIGNING_KEYSTORE_PASSWORD);
				final String cUue5MpL = (String) xBcuQC7r.get(IHtmlToPdfTransformer.PDF_SIGNING_PRIVATE_KEY_FILE);
				final String RwVJHpR1 = (String) xBcuQC7r.get(IHtmlToPdfTransformer.PDF_SIGNING_REASON);
				final String xBEICWtF = (String) xBcuQC7r.get(IHtmlToPdfTransformer.PDF_SIGNING_LOCATION);
				final boolean JNTZty3e = !"false".equals(xBcuQC7r.get(IHtmlToPdfTransformer.USE_PDF_SELF_SIGNING));
				PdfReader rIIGP0mr = null;
				if (LKUyujfr != null) {
					rIIGP0mr = new PdfReader(k0vgkwRz.getAbsolutePath(), LKUyujfr.getBytes());
				} else {
					rIIGP0mr = new PdfReader(k0vgkwRz.getAbsolutePath());
				}
				final KeyStore fJcteX0t = JNTZty3e ? KeyStore.getInstance(KeyStore.getDefaultType())
						: KeyStore.getInstance("pkcs12");
				fJcteX0t.load(new FileInputStream(cUue5MpL), TsZXBEA1.toCharArray());
				final String t84V1oJl = (String) fJcteX0t.aliases().nextElement();
				final PrivateKey ANs6q7aB = (PrivateKey) fJcteX0t.getKey(t84V1oJl, tpXXFwws.toCharArray());
				final Certificate BqAdVfHp[] = fJcteX0t.getCertificateChain(t84V1oJl);
				final PdfStamper jSa5bTN4 = PdfStamper.createSignature(rIIGP0mr, BECXMvTx, '\0');
				if ("true".equals(xBcuQC7r.get(IHtmlToPdfTransformer.USE_PDF_ENCRYPTION))) {
					jSa5bTN4.setEncryption(PdfWriter.STRENGTH128BITS, LKUyujfr, null,
							CDocumentReconstructor.getSecurityFlags(xBcuQC7r));
				}
				final PdfSignatureAppearance acIqftaG = jSa5bTN4.getSignatureAppearance();
				if (JNTZty3e) {
					acIqftaG.setCrypto(ANs6q7aB, BqAdVfHp, null, PdfSignatureAppearance.SELF_SIGNED);
				} else {
					acIqftaG.setCrypto(ANs6q7aB, BqAdVfHp, null, PdfSignatureAppearance.WINCER_SIGNED);
				}
				if (RwVJHpR1 != null) {
					acIqftaG.setReason(RwVJHpR1);
				}
				if (xBEICWtF != null) {
					acIqftaG.setLocation(xBEICWtF);
				}
				jSa5bTN4.close();
				BECXMvTx.flush();
			}
		} catch (final Exception CCwU8Njy) {
			throw new CConvertException(
					"ERROR: An Exception occured while reconstructing the pdf document: " + CCwU8Njy.getMessage(),
					CCwU8Njy);
		} finally {
			try {
				uiV2Bv9e.delete();
			} catch (final Exception ufmG74Uz) {
			}
			try {
				k0vgkwRz.delete();
			} catch (final Exception THRHaAoK) {
			}
		}
	}

}