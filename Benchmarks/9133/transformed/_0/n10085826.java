class n10085826 {
	private void doConvert(HttpServletResponse UKZZdz6d, ConversionRequestResolver aPJexGc0, EGE QSoWTOFU,
			ConversionsPath pjT6T7Zx) throws FileUploadException, IOException, RequestResolvingException, EGEException,
			FileNotFoundException, ConverterException, ZipException {
		InputStream zkfVx3X4 = null;
		OutputStream U5Z5dKPj = null;
		if (ServletFileUpload.isMultipartContent(aPJexGc0.getRequest())) {
			ServletFileUpload xQfJOBQd = new ServletFileUpload();
			FileItemIterator Vwq6xUX3 = xQfJOBQd.getItemIterator(aPJexGc0.getRequest());
			while (Vwq6xUX3.hasNext()) {
				FileItemStream oofHisBR = Vwq6xUX3.next();
				if (!oofHisBR.isFormField()) {
					zkfVx3X4 = oofHisBR.openStream();
					applyConversionsProperties(aPJexGc0.getConversionProperties(), pjT6T7Zx);
					DataBuffer Jd6FAXH8 = new DataBuffer(0, EGEConstants.BUFFER_TEMP_PATH);
					String V81T36nw = Jd6FAXH8.allocate(zkfVx3X4);
					InputStream yC9C0dyr = Jd6FAXH8.getDataAsStream(V81T36nw);
					zkfVx3X4.close();
					try {
						ValidationResult RWPCsSnv = QSoWTOFU.performValidation(yC9C0dyr, pjT6T7Zx.getInputDataType());
						if (RWPCsSnv.getStatus().equals(ValidationResult.Status.FATAL)) {
							ValidationServlet ei8RwfT8 = new ValidationServlet();
							ei8RwfT8.printValidationResult(UKZZdz6d, RWPCsSnv);
							try {
								yC9C0dyr.close();
							} finally {
								Jd6FAXH8.removeData(V81T36nw, true);
							}
							return;
						}
					} catch (ValidatorException HCswPwfs) {
						LOGGER.warn(HCswPwfs.getMessage());
					} finally {
						try {
							yC9C0dyr.close();
						} catch (Exception FnygrnfS) {
						}
					}
					File vG1BxhMe = null;
					FileOutputStream UGX7g0sw = null;
					String mFlNEJUI = UUID.randomUUID().toString();
					IOResolver GhACv2G3 = EGEConfigurationManager.getInstance().getStandardIOResolver();
					File ocrQnGb9 = new File(Jd6FAXH8.getDataDir(V81T36nw));
					vG1BxhMe = new File(EGEConstants.BUFFER_TEMP_PATH + File.separator + mFlNEJUI + EZP_EXT);
					UGX7g0sw = new FileOutputStream(vG1BxhMe);
					GhACv2G3.compressData(ocrQnGb9, UGX7g0sw);
					yC9C0dyr = new FileInputStream(vG1BxhMe);
					File aUx0vprt = new File(EGEConstants.BUFFER_TEMP_PATH + File.separator + mFlNEJUI + ZIP_EXT);
					UGX7g0sw = new FileOutputStream(aUx0vprt);
					try {
						try {
							QSoWTOFU.performConversion(yC9C0dyr, UGX7g0sw, pjT6T7Zx);
						} finally {
							UGX7g0sw.close();
						}
						boolean kiVGaWjU = EGEIOUtils.isComplexZip(aUx0vprt);
						UKZZdz6d.setContentType(APPLICATION_OCTET_STREAM);
						String JGJSli0I = oofHisBR.getName().substring(0, oofHisBR.getName().lastIndexOf("."));
						if (kiVGaWjU) {
							String a6XrS7hu;
							if (pjT6T7Zx.getOutputDataType().getMimeType().equals(APPLICATION_MSWORD)) {
								a6XrS7hu = DOCX_EXT;
							} else {
								a6XrS7hu = ZIP_EXT;
							}
							UKZZdz6d.setHeader("Content-Disposition",
									"attachment; filename=\"" + JGJSli0I + a6XrS7hu + "\"");
							FileInputStream qqKC4Vav = new FileInputStream(aUx0vprt);
							U5Z5dKPj = UKZZdz6d.getOutputStream();
							try {
								EGEIOUtils.copyStream(qqKC4Vav, U5Z5dKPj);
							} finally {
								qqKC4Vav.close();
							}
						} else {
							String yl3aOSg3 = getMimeExtensionProvider()
									.getFileExtension(pjT6T7Zx.getOutputDataType().getMimeType());
							UKZZdz6d.setHeader("Content-Disposition",
									"attachment; filename=\"" + JGJSli0I + yl3aOSg3 + "\"");
							U5Z5dKPj = UKZZdz6d.getOutputStream();
							EGEIOUtils.unzipSingleFile(new ZipFile(aUx0vprt), U5Z5dKPj);
						}
					} finally {
						yC9C0dyr.close();
						if (U5Z5dKPj != null) {
							U5Z5dKPj.flush();
							U5Z5dKPj.close();
						}
						Jd6FAXH8.clear(true);
						aUx0vprt.delete();
						if (vG1BxhMe != null) {
							vG1BxhMe.delete();
						}
					}
				}
			}
		} else {
			UKZZdz6d.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
	}

}