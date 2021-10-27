class n1684606 {
	private void generateSchema() {
		ConsoleOutputWindow KtpncGEl = DefaultXPontusWindowImpl.getInstance().getConsole();
		MessagesWindowDockable E5E0nPr2 = (MessagesWindowDockable) KtpncGEl
				.getDockableById(MessagesWindowDockable.DOCKABLE_ID);
		ByteArrayOutputStream vc61XVLK = new ByteArrayOutputStream();
		IDocumentContainer itCfGtgb = (IDocumentContainer) DefaultXPontusWindowImpl.getInstance()
				.getDocumentTabContainer().getCurrentDockable();
		try {
			SchemaGenerationModel AQJjqz8Y = view.getModel();
			boolean iIcd3x0h = transformationIsValid(AQJjqz8Y);
			if (!iIcd3x0h) {
				return;
			}
			DefaultXPontusWindowImpl.getInstance().getStatusBar().setMessage("Generating schema...");
			view.setVisible(false);
			InputFormat YNtRPaTf = null;
			OutputFormat XNfAxJaI = null;
			if (AQJjqz8Y.getInputType().equalsIgnoreCase("RELAX NG Grammar")) {
				YNtRPaTf = new SAXParseInputFormat();
			} else if (AQJjqz8Y.getInputType().equalsIgnoreCase("RELAX NG Compact Grammar")) {
				YNtRPaTf = new CompactParseInputFormat();
			} else if (AQJjqz8Y.getInputType().equalsIgnoreCase("DTD")) {
				YNtRPaTf = new DtdInputFormat();
			} else if (AQJjqz8Y.getInputType().equalsIgnoreCase("XML")) {
				YNtRPaTf = new XmlInputFormat();
			}
			if (AQJjqz8Y.getOutputType().equalsIgnoreCase("DTD")) {
				XNfAxJaI = new DtdOutputFormat();
			} else if (AQJjqz8Y.getOutputType().equalsIgnoreCase("Relax NG Grammar")) {
				XNfAxJaI = new RngOutputFormat();
			} else if (AQJjqz8Y.getOutputType().equalsIgnoreCase("XML Schema")) {
				XNfAxJaI = new XsdOutputFormat();
			} else if (AQJjqz8Y.getOutputType().equalsIgnoreCase("Relax NG Compact Grammar")) {
				XNfAxJaI = new RncOutputFormat();
			}
			ErrorHandlerImpl JW9Pc9aK = new ErrorHandlerImpl(vc61XVLK);
			SchemaCollection MibyZvh2 = null;
			if (!view.getModel().isUseExternalDocument()) {
				JTextComponent H5E0X57g = DefaultXPontusWindowImpl.getInstance().getDocumentTabContainer()
						.getCurrentEditor();
				if (H5E0X57g == null) {
					XPontusComponentsUtils.showErrorMessage("No document opened!!!");
					DefaultXPontusWindowImpl.getInstance().getStatusBar()
							.setMessage("Error generating schema, Please see the messages window!");
					return;
				}
				String HMgyP2OW = AQJjqz8Y.getOutputType().toLowerCase();
				File GrAI94vT = File.createTempFile("schemageneratorhandler",
						+System.currentTimeMillis() + "." + HMgyP2OW);
				OutputStream KTNvsVvX = new FileOutputStream(GrAI94vT);
				CharsetDetector GSFM8ac3 = new CharsetDetector();
				GSFM8ac3.setText(H5E0X57g.getText().getBytes());
				Writer dYMjcgco = new OutputStreamWriter(KTNvsVvX, "UTF-8");
				IOUtils.copy(GSFM8ac3.detect().getReader(), dYMjcgco);
				IOUtils.closeQuietly(dYMjcgco);
				try {
					MibyZvh2 = YNtRPaTf.load(UriOrFile.toUri(GrAI94vT.getAbsolutePath()), new String[0],
							AQJjqz8Y.getOutputType().toLowerCase(), JW9Pc9aK);
				} catch (Exception FOq5RV6m) {
					FOq5RV6m.printStackTrace();
					StrBuilder a3Jeh6nu = new StrBuilder();
					a3Jeh6nu.append("\nError loading input document!\n");
					a3Jeh6nu.append("Maybe the input type is invalid?\n");
					a3Jeh6nu.append("Please check again the input type list or trying validating your document\n");
					throw new Exception(a3Jeh6nu.toString());
				}
				GrAI94vT.deleteOnExit();
			} else {
				try {
					MibyZvh2 = YNtRPaTf.load(UriOrFile.toUri(view.getModel().getInputURI()), new String[0],
							AQJjqz8Y.getOutputType().toLowerCase(), JW9Pc9aK);
				} catch (Exception OusCX3bI) {
					StrBuilder PNYq1Jfy = new StrBuilder();
					PNYq1Jfy.append("\nError loading input document!\n");
					PNYq1Jfy.append("Maybe the input type is invalid?\n");
					PNYq1Jfy.append("Please check again the input type list or trying validating your document\n");
					throw new Exception(PNYq1Jfy.toString());
				}
			}
			OutputDirectory l0pQIGaB = new LocalOutputDirectory(MibyZvh2.getMainUri(),
					new File(view.getModel().getOutputURI()), AQJjqz8Y.getOutputType().toLowerCase(),
					DEFAULT_OUTPUT_ENCODING, DEFAULT_LINE_LENGTH, DEFAULT_INDENT);
			XNfAxJaI.output(MibyZvh2, l0pQIGaB, new String[0], AQJjqz8Y.getInputType().toLowerCase(), JW9Pc9aK);
			E5E0nPr2.println("Schema generated sucessfully!");
			DefaultXPontusWindowImpl.getInstance().getStatusBar().setMessage("Schema generated sucessfully!");
			if (AQJjqz8Y.isOpenInEditor()) {
				XPontusComponentsUtils.showWarningMessage(
						"The document will NOT be opened in the editor sorry for that!\n You need to open it yourself.");
			}
		} catch (Exception AmiDvXEg) {
			DefaultXPontusWindowImpl.getInstance().getStatusBar()
					.setMessage("Error generating schema, Please see the messages window!");
			StringWriter AxpcsfJA = new StringWriter();
			PrintWriter j0JDgJjA = new PrintWriter(AxpcsfJA);
			AmiDvXEg.printStackTrace(j0JDgJjA);
			StrBuilder GrI00ecM = new StrBuilder();
			GrI00ecM.append("Error generating schema");
			GrI00ecM.appendNewLine();
			GrI00ecM.append(new String(vc61XVLK.toByteArray()));
			GrI00ecM.appendNewLine();
			if (AmiDvXEg instanceof SAXParseException) {
				SAXParseException ZUralhIH = (SAXParseException) AmiDvXEg;
				GrI00ecM.append("Error around line " + ZUralhIH.getLineNumber());
				GrI00ecM.append(", column " + ZUralhIH.getColumnNumber());
				GrI00ecM.appendNewLine();
			}
			GrI00ecM.append(AxpcsfJA.toString());
			E5E0nPr2.println(GrI00ecM.toString(), OutputDockable.RED_STYLE);
			logger.error(GrI00ecM.toString());
			try {
				j0JDgJjA.flush();
				j0JDgJjA.close();
				AxpcsfJA.flush();
				AxpcsfJA.close();
			} catch (IOException B8fRtrGE) {
				logger.error(B8fRtrGE.getMessage());
			}
		} finally {
			KtpncGEl.setFocus(MessagesWindowDockable.DOCKABLE_ID);
			Toolkit.getDefaultToolkit().beep();
		}
	}

}