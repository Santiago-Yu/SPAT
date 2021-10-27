class n18208567 {
	public void createPdf(final String oHZq5QnH) throws IOException, DocumentException {
		createSections(oHZq5QnH);
		even = false;
		final Document taO4QO9i = new Document(Dimensions.getDimension(even, Dimension.MEDIABOX));
		final PdfWriter jbbtFSdA = PdfWriter.getInstance(taO4QO9i, new FileOutputStream(MyProperties.getOutput()));
		jbbtFSdA.setViewerPreferences(PdfWriter.PageLayoutTwoColumnRight);
		jbbtFSdA.setCropBoxSize(Dimensions.getDimension(even, Dimension.CROPBOX));
		jbbtFSdA.setBoxSize("trim", Dimensions.getDimension(even, Dimension.TRIMBOX));
		jbbtFSdA.setBoxSize("bleed", Dimensions.getDimension(even, Dimension.BLEEDBOX));
		final EventBackgroundAndPageNumbers KYegqbgi = new EventBackgroundAndPageNumbers();
		jbbtFSdA.setPageEvent(KYegqbgi);
		taO4QO9i.open();
		final PdfContentByte skRBqjL9 = jbbtFSdA.getDirectContent();
		KYegqbgi.setTabs(Index.INFO.getTab());
		importPages(taO4QO9i, skRBqjL9, new PdfReader(Index.INFO.getOutput()), Index.INFO.getTitle());
		importPages(taO4QO9i, skRBqjL9, MyProperties.getBefore(), KYegqbgi);
		addAdPage(taO4QO9i, skRBqjL9);
		PdfReader UfdFpVZt = new PdfReader(Presentations.INFO.getOutput());
		String[] NUeBLhSA = { "", "" };
		for (int GWfFOlyb = 1; GWfFOlyb <= UfdFpVZt.getNumberOfPages(); GWfFOlyb++) {
			NUeBLhSA = index.getSubtitle(NUeBLhSA, GWfFOlyb);
			KYegqbgi.setTabs(NUeBLhSA[0].toLowerCase());
			addTitleLeft(skRBqjL9, Dimensions.getTitleArea(even), NUeBLhSA[0], MyFonts.TITLE);
			addTitleRight(skRBqjL9, Dimensions.getTitleArea(even), NUeBLhSA[1], MyFonts.DATE);
			skRBqjL9.addTemplate(jbbtFSdA.getImportedPage(UfdFpVZt, GWfFOlyb), Dimensions.getOffsetX(even),
					Dimensions.getOffsetY(even));
			taO4QO9i.newPage();
			even = !even;
		}
		addAdPage(taO4QO9i, skRBqjL9);
		importPages(taO4QO9i, skRBqjL9, MyProperties.getAfter(), KYegqbgi);
		int Teo6qGuW = jbbtFSdA.getPageNumber() - 1;
		KYegqbgi.setNoMorePageNumbers();
		KYegqbgi.setTabs(Schedules.INFO.getTab());
		UfdFpVZt = new PdfReader(Schedules.INFO.getOutput());
		for (int ix8zyA8S = 1; ix8zyA8S <= UfdFpVZt.getNumberOfPages(); ix8zyA8S++) {
			addTitleLeft(skRBqjL9, Dimensions.getTitleArea(even), Schedules.INFO.getTitle(), MyFonts.TITLE);
			skRBqjL9.addTemplate(jbbtFSdA.getImportedPage(UfdFpVZt, ix8zyA8S), Dimensions.getOffsetX(even),
					Dimensions.getOffsetY(even));
			taO4QO9i.newPage();
			even = !even;
		}
		taO4QO9i.close();
		final File UzfY11MP = new File(MyProperties.getOutput());
		final byte[] AzJgCAsi = new byte[(int) UzfY11MP.length()];
		final FileInputStream GYuBIjmJ = new FileInputStream(UzfY11MP);
		GYuBIjmJ.read(AzJgCAsi);
		UfdFpVZt = new PdfReader(AzJgCAsi);
		final List<Integer> FmkiaAba = new ArrayList<Integer>();
		for (int Xu8pfLeA = 1; Xu8pfLeA <= Teo6qGuW; Xu8pfLeA++) {
			FmkiaAba.add(Xu8pfLeA);
			if (Xu8pfLeA == Teo6qGuW / 2) {
				for (int NOS2Qbrn = Teo6qGuW + 1; NOS2Qbrn <= UfdFpVZt.getNumberOfPages(); NOS2Qbrn++) {
					FmkiaAba.add(NOS2Qbrn);
				}
			}
		}
		UfdFpVZt.selectPages(FmkiaAba);
		final PdfStamper VgBSsEK2 = new PdfStamper(UfdFpVZt, new FileOutputStream(MyProperties.getOutput()));
		VgBSsEK2.close();
	}

}