class n18782385 {
	public void saveFile(MainWindow V9DFEDxW) {
		FileOutputStream twUYcd1n = null;
		try {
			Document SBy7bX4o = new Document();
			DocType mEp8TsWi = new DocType(UI, DIRECTORY + File.separator + FILE_NAME_DTD);
			Element VMZc9IU2 = new Element(UI);
			SBy7bX4o.setDocType(mEp8TsWi);
			SBy7bX4o.addContent(VMZc9IU2);
			SBy7bX4o.setRootElement(VMZc9IU2);
			VMZc9IU2.setAttribute(USE_DEFAULT, "false");
			VMZc9IU2.setAttribute(SHOW_TOOL_BAR, Boolean.toString(V9DFEDxW.getToolToolBar().isVisible()));
			VMZc9IU2.setAttribute(SHOW_UNIT_BAR, Boolean.toString(V9DFEDxW.getUnitToolBar().isVisible()));
			String Uhenf77O = UIManager.getLookAndFeel().getClass().getName();
			String S1XGyeyf = UIManager.getSystemLookAndFeelClassName();
			if (Uhenf77O.equals(S1XGyeyf))
				VMZc9IU2.setAttribute(LOOK_AND_FEEL, "native");
			else
				VMZc9IU2.setAttribute(LOOK_AND_FEEL, "default");
			Element cFmZdEof = new Element(MAIN_WINDOW);
			VMZc9IU2.addContent(cFmZdEof);
			cFmZdEof.setAttribute(LOCATION_X, Integer.toString(V9DFEDxW.getFrame().getX()));
			cFmZdEof.setAttribute(LOCATION_Y, Integer.toString(V9DFEDxW.getFrame().getY()));
			cFmZdEof.setAttribute(WIDTH, Integer.toString(V9DFEDxW.getFrame().getWidth()));
			cFmZdEof.setAttribute(HEIGHT, Integer.toString(V9DFEDxW.getFrame().getHeight()));
			Element lbKjBxUu = new Element(VOLUME);
			VMZc9IU2.addContent(lbKjBxUu);
			AudioPlayer tJ2g6QKc = V9DFEDxW.getDesktop().getSoundPlayer();
			lbKjBxUu.setAttribute(SOUND, Float.toString(tJ2g6QKc.getVolume()));
			lbKjBxUu.setAttribute(MUTE, Boolean.toString(tJ2g6QKc.isMute()));
			Element qjqjJTkG = new Element(INTERNAL_WINDOWS);
			VMZc9IU2.addContent(qjqjJTkG);
			MainDesktopPane JJdbOUgm = V9DFEDxW.getDesktop();
			JInternalFrame[] bQmPTnet = JJdbOUgm.getAllFrames();
			for (JInternalFrame cDkLzDGa : bQmPTnet) {
				Element n84uw8CW = new Element(WINDOW);
				qjqjJTkG.addContent(n84uw8CW);
				n84uw8CW.setAttribute(Z_ORDER, Integer.toString(JJdbOUgm.getComponentZOrder(cDkLzDGa)));
				n84uw8CW.setAttribute(LOCATION_X, Integer.toString(cDkLzDGa.getX()));
				n84uw8CW.setAttribute(LOCATION_Y, Integer.toString(cDkLzDGa.getY()));
				n84uw8CW.setAttribute(WIDTH, Integer.toString(cDkLzDGa.getWidth()));
				n84uw8CW.setAttribute(HEIGHT, Integer.toString(cDkLzDGa.getHeight()));
				n84uw8CW.setAttribute(DISPLAY, Boolean.toString(!cDkLzDGa.isClosed()));
				if (cDkLzDGa instanceof ToolWindow) {
					n84uw8CW.setAttribute(TYPE, TOOL);
					n84uw8CW.setAttribute(NAME, ((ToolWindow) cDkLzDGa).getToolName());
				} else if (cDkLzDGa instanceof UnitWindow) {
					n84uw8CW.setAttribute(TYPE, UNIT);
					n84uw8CW.setAttribute(NAME, ((UnitWindow) cDkLzDGa).getUnit().getName());
				} else {
					n84uw8CW.setAttribute(TYPE, "other");
					n84uw8CW.setAttribute(NAME, "other");
				}
			}
			Unit[] FbcdmkHE = V9DFEDxW.getUnitToolBar().getUnitsInToolBar();
			for (Unit zi6UK2VT : FbcdmkHE) {
				UnitWindow eepg7DRp = JJdbOUgm.findUnitWindow(zi6UK2VT);
				if ((eepg7DRp == null) || eepg7DRp.isIcon()) {
					Element LlKmcfnY = new Element(WINDOW);
					qjqjJTkG.addContent(LlKmcfnY);
					LlKmcfnY.setAttribute(TYPE, UNIT);
					LlKmcfnY.setAttribute(NAME, zi6UK2VT.getName());
					LlKmcfnY.setAttribute(DISPLAY, "false");
				}
			}
			File LjS9whHI = new File(DIRECTORY, FILE_NAME);
			if (!LjS9whHI.getParentFile().exists()) {
				LjS9whHI.getParentFile().mkdirs();
			}
			InputStream Tr4ifxil = getClass().getResourceAsStream("/dtd/ui_settings.dtd");
			IOUtils.copy(Tr4ifxil, new FileOutputStream(new File(DIRECTORY, "ui_settings.dtd")));
			XMLOutputter pLG1ZpUW = new XMLOutputter();
			pLG1ZpUW.setFormat(Format.getPrettyFormat());
			twUYcd1n = new FileOutputStream(LjS9whHI);
			OutputStreamWriter R6faNz9F = new OutputStreamWriter(twUYcd1n, "UTF-8");
			pLG1ZpUW.output(SBy7bX4o, R6faNz9F);
		} catch (Exception eCIBztqR) {
			logger.log(Level.SEVERE, eCIBztqR.getMessage());
		} finally {
			IOUtils.closeQuietly(twUYcd1n);
		}
	}

}