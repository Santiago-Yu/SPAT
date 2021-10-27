class n23188198 {
	public ProcessorOutput createOutput(String tzKHAJXW) {
		ProcessorOutput sufLavMP = new ProcessorImpl.CacheableTransformerOutputImpl(getClass(), tzKHAJXW) {

			protected void readImpl(org.orbeon.oxf.pipeline.api.PipelineContext tTc7OmqK,
					final ContentHandler yUjm3qto) {
				ProcessorInput u5NsWTA3 = getInputByName(INPUT_DATA);
				try {
					Grammar NhxeqhBY = (Grammar) readCacheInputAsObject(tTc7OmqK, getInputByName(INPUT_CONFIG),
							new CacheableInputReader() {

								public Object read(org.orbeon.oxf.pipeline.api.PipelineContext zhuIvuS8,
										ProcessorInput tplPYKmF) {
									final Locator[] qWDr4tFU = new Locator[1];
									GrammarReader LvBhqbBg = new XMLSchemaReader(new GrammarReaderController() {

										public void error(Locator[] WwFKJiIt, String qJUY3110, Exception m5PHCo2p) {
											throw new ValidationException(qJUY3110, m5PHCo2p,
													new LocationData(WwFKJiIt[0]));
										}

										public void warning(Locator[] DE9E97IL, String sv5QRfip) {
											throw new ValidationException(sv5QRfip, new LocationData(DE9E97IL[0]));
										}

										public InputSource resolveEntity(String hogoSdeP, String d8Aq3dNd)
												throws SAXException, IOException {
											URL R1Hmbu9u = URLFactory.createURL(
													(qWDr4tFU[0] != null && qWDr4tFU[0].getSystemId() != null)
															? qWDr4tFU[0].getSystemId()
															: null,
													d8Aq3dNd);
											InputSource Yzb3XaKc = new InputSource(R1Hmbu9u.openStream());
											Yzb3XaKc.setSystemId(R1Hmbu9u.toString());
											return Yzb3XaKc;
										}
									});
									readInputAsSAX(zhuIvuS8, tplPYKmF, new ForwardingContentHandler(LvBhqbBg) {

										public void setDocumentLocator(Locator rFcRm86A) {
											super.setDocumentLocator(rFcRm86A);
											qWDr4tFU[0] = rFcRm86A;
										}
									});
									return LvBhqbBg.getResultAsGrammar();
								}
							});
					DocumentDeclaration p1Cp2ipv = new REDocumentDeclaration(NhxeqhBY.getTopLevel(),
							new ExpressionPool());
					Verifier qKUTT7Wj = new Verifier(p1Cp2ipv, new ErrorHandler()) {

						boolean TPpFDucx = false;

						private void generateErrorElement(ValidationException WSW0qPlH) throws SAXException {
							if (decorateOutput && WSW0qPlH != null) {
								if (!TPpFDucx) {
									AttributesImpl mBQ0n9pU = new AttributesImpl();
									mBQ0n9pU.addAttribute("", ValidationProcessor.MESSAGE_ATTRIBUTE,
											ValidationProcessor.MESSAGE_ATTRIBUTE, "CDATA",
											WSW0qPlH.getSimpleMessage());
									mBQ0n9pU.addAttribute("", ValidationProcessor.SYSTEMID_ATTRIBUTE,
											ValidationProcessor.SYSTEMID_ATTRIBUTE, "CDATA",
											WSW0qPlH.getLocationData().getSystemID());
									mBQ0n9pU.addAttribute("", ValidationProcessor.LINE_ATTRIBUTE,
											ValidationProcessor.LINE_ATTRIBUTE, "CDATA",
											Integer.toString(WSW0qPlH.getLocationData().getLine()));
									mBQ0n9pU.addAttribute("", ValidationProcessor.COLUMN_ATTRIBUTE,
											ValidationProcessor.COLUMN_ATTRIBUTE, "CDATA",
											Integer.toString(WSW0qPlH.getLocationData().getCol()));
									yUjm3qto.startElement(ValidationProcessor.ORBEON_ERROR_NS,
											ValidationProcessor.ERROR_ELEMENT, ValidationProcessor.ORBEON_ERROR_PREFIX
													+ ":" + ValidationProcessor.ERROR_ELEMENT,
											mBQ0n9pU);
									yUjm3qto.endElement(ValidationProcessor.ORBEON_ERROR_NS,
											ValidationProcessor.ERROR_ELEMENT, ValidationProcessor.ORBEON_ERROR_PREFIX
													+ ":" + ValidationProcessor.ERROR_ELEMENT);
									TPpFDucx = true;
								}
							} else {
								throw WSW0qPlH;
							}
						}

						public void characters(char[] kQVXvwTh, int T6qNI390, int n4vMdBNw) throws SAXException {
							try {
								super.characters(kQVXvwTh, T6qNI390, n4vMdBNw);
							} catch (ValidationException Zmu7czBP) {
								generateErrorElement(Zmu7czBP);
							}
							yUjm3qto.characters(kQVXvwTh, T6qNI390, n4vMdBNw);
						}

						public void endDocument() throws SAXException {
							try {
								super.endDocument();
							} catch (ValidationException ajU63zgv) {
								generateErrorElement(ajU63zgv);
							}
							yUjm3qto.endDocument();
						}

						public void endElement(String i6VI7EVi, String uA1MpPL2, String sqa3rbO3) throws SAXException {
							try {
								super.endElement(i6VI7EVi, uA1MpPL2, sqa3rbO3);
							} catch (ValidationException W344ceGa) {
								generateErrorElement(W344ceGa);
							}
							yUjm3qto.endElement(i6VI7EVi, uA1MpPL2, sqa3rbO3);
						}

						public void startDocument() throws SAXException {
							try {
								super.startDocument();
							} catch (ValidationException izX1XZRP) {
								generateErrorElement(izX1XZRP);
							}
							yUjm3qto.startDocument();
						}

						public void startElement(String CPSQzn3k, String ZGREHS4P, String vWDSv597, Attributes FgpDnVNa)
								throws SAXException {
							((ErrorHandler) getErrorHandler()).setElement(CPSQzn3k, ZGREHS4P);
							try {
								super.startElement(CPSQzn3k, ZGREHS4P, vWDSv597, FgpDnVNa);
							} catch (ValidationException I4V3EQlC) {
								generateErrorElement(I4V3EQlC);
							}
							yUjm3qto.startElement(CPSQzn3k, ZGREHS4P, vWDSv597, FgpDnVNa);
						}

						public void endPrefixMapping(String tu5aJY7f) {
							try {
								super.endPrefixMapping(tu5aJY7f);
							} catch (ValidationException hZN0jfeY) {
								try {
									generateErrorElement(hZN0jfeY);
								} catch (SAXException rtHuf75d) {
									throw new OXFException(rtHuf75d.getException());
								}
							}
							try {
								yUjm3qto.endPrefixMapping(tu5aJY7f);
							} catch (SAXException vyk7HqTw) {
								throw new OXFException(vyk7HqTw.getException());
							}
						}

						public void processingInstruction(String FjLrgWGi, String Eq5Q9GSv) {
							try {
								super.processingInstruction(FjLrgWGi, Eq5Q9GSv);
							} catch (ValidationException VUDodP0v) {
								try {
									generateErrorElement(VUDodP0v);
								} catch (SAXException y0o4qHyH) {
									throw new OXFException(y0o4qHyH.getException());
								}
							}
							try {
								yUjm3qto.processingInstruction(FjLrgWGi, Eq5Q9GSv);
							} catch (SAXException AXMZsDuK) {
								throw new OXFException(AXMZsDuK.getException());
							}
						}

						public void setDocumentLocator(Locator ensZTR3L) {
							try {
								super.setDocumentLocator(ensZTR3L);
							} catch (ValidationException foJbvICb) {
								try {
									generateErrorElement(foJbvICb);
								} catch (SAXException LIhoDIlP) {
									throw new OXFException(LIhoDIlP.getException());
								}
							}
							yUjm3qto.setDocumentLocator(ensZTR3L);
						}

						public void skippedEntity(String afkDFLBx) {
							try {
								super.skippedEntity(afkDFLBx);
							} catch (ValidationException yx3HDnNV) {
								try {
									generateErrorElement(yx3HDnNV);
								} catch (SAXException sqFhW1se) {
									throw new OXFException(sqFhW1se.getMessage());
								}
							}
							try {
								yUjm3qto.skippedEntity(afkDFLBx);
							} catch (SAXException KeC7MLPH) {
								throw new OXFException(KeC7MLPH.getException());
							}
						}

						public void startPrefixMapping(String vcinDoZW, String SnNKR3uy) {
							try {
								super.startPrefixMapping(vcinDoZW, SnNKR3uy);
							} catch (ValidationException Op8efGIc) {
								try {
									generateErrorElement(Op8efGIc);
								} catch (SAXException LhGstEyF) {
									throw new OXFException(LhGstEyF.getException());
								}
							}
							try {
								yUjm3qto.startPrefixMapping(vcinDoZW, SnNKR3uy);
							} catch (SAXException jrCXYmfn) {
								throw new OXFException(jrCXYmfn.getException());
							}
						}
					};
					readInputAsSAX(tTc7OmqK, getInputByName(INPUT_DATA), qKUTT7Wj);
				} catch (Exception Avuan4QD) {
					throw new OXFException(Avuan4QD);
				}
			}
		};
		addOutput(tzKHAJXW, sufLavMP);
		return sufLavMP;
	}

}