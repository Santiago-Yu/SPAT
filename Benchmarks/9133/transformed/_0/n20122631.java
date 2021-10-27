class n20122631 {
	public void insertQuotation(final String IIwluf2S, final Source CMGrx1ov)
			throws ConfigHandlerError, com.sun.star.uno.Exception {
		final XTextDocument pPUjbLHP = (XTextDocument) this.docController.getXInterface(XTextDocument.class,
				this.docController.getXFrame().getController().getModel());
		final XMultiServiceFactory DafezGDr = (XMultiServiceFactory) this.docController
				.getXInterface(XMultiServiceFactory.class, pPUjbLHP);
		final XText RJqrWlMv = pPUjbLHP.getText();
		final XTextViewCursor Z5oIQCCE = ((XTextViewCursorSupplier) this.docController
				.getXInterface(XTextViewCursorSupplier.class, this.docController.getXFrame().getController()))
						.getViewCursor();
		final XTextRange F8RIB9I4 = Z5oIQCCE.getStart();
		if (CMGrx1ov.getSourceType() == SourceType.QUOTE || CMGrx1ov.getSourceType() == SourceType.WEBQUOTE
				|| CMGrx1ov.getSourceType() == SourceType.WEBQUOTE) {
			final XPropertySet f3lXZH6I = (XPropertySet) this.docController.getXInterface(XPropertySet.class, Z5oIQCCE);
			if (this.docController.getTemplateController().isIndentation()) {
				RJqrWlMv.insertControlCharacter(Z5oIQCCE, ControlCharacter.PARAGRAPH_BREAK, false);
				f3lXZH6I.setPropertyValue("ParaStyleName", new String("Quotations"));
			}
			f3lXZH6I.setPropertyValue("CharStyleName", new String("Citation"));
			final Object dwc9fzcq = DafezGDr.createInstance("com.sun.star.text.Bookmark");
			this.sourceUtils.setNameToObject(dwc9fzcq,
					this.docController.getLanguageController().__("Quote: ") + CMGrx1ov.getShortinfo());
			final XTextContent VJbYuwVT = (XTextContent) this.docController.getXInterface(XTextContent.class, dwc9fzcq);
			RJqrWlMv.insertTextContent(F8RIB9I4, VJbYuwVT, false);
			this.sourceUtils.insertBibliographyEntry(DafezGDr, F8RIB9I4, CMGrx1ov, IIwluf2S);
			if (this.docController.getTemplateController().isIndentation()) {
				RJqrWlMv.insertControlCharacter(Z5oIQCCE, ControlCharacter.PARAGRAPH_BREAK, false);
				f3lXZH6I.setPropertyValue("ParaStyleName",
						new String(this.docController.getLanguageController().__("Default")));
			}
			f3lXZH6I.setPropertyValue("CharStyleName",
					new String(this.docController.getLanguageController().__("Default")));
		} else if (CMGrx1ov.getSourceType() == SourceType.IMAGE || CMGrx1ov.getSourceType() == SourceType.TABLE) {
			RJqrWlMv.insertControlCharacter(F8RIB9I4, ControlCharacter.PARAGRAPH_BREAK, false);
			final XTextFrame AEXA016x = this.sourceUtils.getTextFrame(CMGrx1ov.getShortinfo(), DafezGDr);
			RJqrWlMv.insertTextContent(F8RIB9I4, AEXA016x, false);
			final XText CzK9AzBj = AEXA016x.getText();
			final XTextCursor wQCaaejI = CzK9AzBj.createTextCursor();
			final Size CdmLpVTW = new Size();
			XPropertySet Tb09OGNz = null;
			final Size sWQeOAyw = this.sourceUtils.getPageTextAreaSize(pPUjbLHP, Z5oIQCCE);
			if (CMGrx1ov.getSourceType() == SourceType.IMAGE) {
				try {
					this.sourceUtils.setNameToObject(AEXA016x,
							this.docController.getLanguageController().__("Caption illustration: ")
									+ CMGrx1ov.getShortinfo());
					final XNameContainer KuNW2eK4 = (XNameContainer) this.docController.getXInterface(
							XNameContainer.class, DafezGDr.createInstance("com.sun.star.drawing.BitmapTable"));
					final XTextContent McTs37Tw = (XTextContent) this.docController.getXInterface(XTextContent.class,
							DafezGDr.createInstance("com.sun.star.text.TextGraphicObject"));
					this.sourceUtils.setNameToObject(McTs37Tw,
							this.docController.getLanguageController().__("Illustration: ") + CMGrx1ov.getShortinfo());
					final String luYAnmks = this.docController.getPathUtils().getFileURLFromSystemPath(
							((Image) CMGrx1ov).getFile().getPath(), ((Image) CMGrx1ov).getFile().getPath());
					Tb09OGNz = (XPropertySet) this.docController.getXInterface(XPropertySet.class, McTs37Tw);
					Tb09OGNz.setPropertyValue("AnchorType", com.sun.star.text.TextContentAnchorType.AT_PARAGRAPH);
					Tb09OGNz.setPropertyValue("GraphicURL", luYAnmks);
					final MessageDigest y8Tno42z = MessageDigest.getInstance("MD5");
					y8Tno42z.update(luYAnmks.getBytes(), 0, luYAnmks.length());
					final String MK6OTYBs = new BigInteger(1, y8Tno42z.digest()).toString(16);
					KuNW2eK4.insertByName(MK6OTYBs, luYAnmks);
					final String w69qk0VJ = (String) (KuNW2eK4.getByName(MK6OTYBs));
					Tb09OGNz.setPropertyValue("GraphicURL", w69qk0VJ);
					float VCUurzwX = (float) this.sourceUtils.getImageSize(((Image) CMGrx1ov).getFile()).Height
							/ (float) this.sourceUtils.getImageSize(((Image) CMGrx1ov).getFile()).Width;
					final Size VLTkw55P = new Size(
							this.sourceUtils.getImageSize(((Image) CMGrx1ov).getFile()).Width * 26,
							this.sourceUtils.getImageSize(((Image) CMGrx1ov).getFile()).Height * 26);
					if (VLTkw55P.Width >= sWQeOAyw.Width) {
						CdmLpVTW.Width = sWQeOAyw.Width;
						CdmLpVTW.Height = (int) (sWQeOAyw.Width * VCUurzwX);
					} else {
						CdmLpVTW.Width = VLTkw55P.Width;
						CdmLpVTW.Height = VLTkw55P.Height;
					}
					CzK9AzBj.insertTextContent(wQCaaejI, McTs37Tw, false);
					KuNW2eK4.removeByName(MK6OTYBs);
				} catch (final NoSuchAlgorithmException zNOBPDbz) {
					new ASTError(zNOBPDbz).severe();
				}
				this.sourceUtils.insertCaption(AEXA016x, CMGrx1ov,
						this.docController.getLanguageController().__("Illustration"), DafezGDr);
			} else if (CMGrx1ov.getSourceType() == SourceType.TABLE) {
				this.sourceUtils.setNameToObject(AEXA016x,
						this.docController.getLanguageController().__("Caption table: ") + CMGrx1ov.getShortinfo());
				Tb09OGNz = this.sourceUtils.createTextEmbeddedObjectCalc(DafezGDr);
				this.sourceUtils.setNameToObject(Tb09OGNz,
						this.docController.getLanguageController().__("Table: ") + CMGrx1ov.getShortinfo());
				CzK9AzBj.insertTextContent(wQCaaejI,
						(XTextContent) this.docController.getXInterface(XTextContent.class, Tb09OGNz), false);
				final XEmbeddedObjectSupplier2 xf3NqxHU = (XEmbeddedObjectSupplier2) this.docController
						.getXInterface(XEmbeddedObjectSupplier2.class, Tb09OGNz);
				final XEmbeddedObject V7qodWK2 = xf3NqxHU.getExtendedControlOverEmbeddedObject();
				long aepeBcRe = xf3NqxHU.getAspect();
				final Size oLCPr8yu = V7qodWK2.getVisualAreaSize(aepeBcRe);
				final XComponent mzfYxPlE = xf3NqxHU.getEmbeddedObject();
				XSpreadsheets MCfGEExT = ((XSpreadsheetDocument) this.docController
						.getXInterface(XSpreadsheetDocument.class, mzfYxPlE)).getSheets();
				final XIndexAccess ugQD2oUX = (XIndexAccess) this.docController.getXInterface(XIndexAccess.class,
						MCfGEExT);
				final XSpreadsheet SCJ3vBBp = (XSpreadsheet) this.docController.getXInterface(XSpreadsheet.class,
						ugQD2oUX.getByIndex(0));
				final XSheetLinkable YluQ7A4M = (XSheetLinkable) this.docController.getXInterface(XSheetLinkable.class,
						SCJ3vBBp);
				YluQ7A4M.link(
						this.docController.getPathUtils().getFileURLFromSystemPath(
								((Table) CMGrx1ov).getFile().getPath(), ((Table) CMGrx1ov).getFile().getPath()),
						"", "", "", com.sun.star.sheet.SheetLinkMode.NORMAL);
				final CellRangeAddress CKNxBPpP = this.sourceUtils.getUsedArea(SCJ3vBBp);
				final Size o1GWlJ5t = this.sourceUtils.calcCellRangeSize(MCfGEExT, CKNxBPpP);
				if ((o1GWlJ5t.Width != oLCPr8yu.Width) || (o1GWlJ5t.Height != oLCPr8yu.Height)) {
					CdmLpVTW.Height = (o1GWlJ5t.Height > sWQeOAyw.Height) ? sWQeOAyw.Height : o1GWlJ5t.Height;
					CdmLpVTW.Width = (o1GWlJ5t.Width > sWQeOAyw.Width) ? sWQeOAyw.Width : o1GWlJ5t.Width;
					V7qodWK2.setVisualAreaSize(aepeBcRe, CdmLpVTW);
				}
				this.sourceUtils.insertCaption(AEXA016x, CMGrx1ov,
						this.docController.getLanguageController().__("Table"), DafezGDr);
			}
			Tb09OGNz.setPropertyValue("Width", CdmLpVTW.Width);
			Tb09OGNz.setPropertyValue("Height", CdmLpVTW.Height);
			final XShape foVFgjm2 = (XShape) this.docController.getXInterface(XShape.class, AEXA016x);
			foVFgjm2.setSize(CdmLpVTW);
		}
		final XTextFieldsSupplier Nx9C3NXc = (XTextFieldsSupplier) this.docController
				.getXInterface(XTextFieldsSupplier.class, DafezGDr);
		final XRefreshable LQInN5vi = (XRefreshable) this.docController.getXInterface(XRefreshable.class,
				Nx9C3NXc.getTextFields());
		LQInN5vi.refresh();
	}

}