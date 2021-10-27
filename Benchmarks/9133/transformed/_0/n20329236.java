class n20329236 {
	private void createTab2(TabLayoutPanel nGnk8bU5) {
		ScrollingGraphicalViewer L0ZUBKXZ;
		try {
			L0ZUBKXZ = new ScrollingGraphicalViewer();
			L0ZUBKXZ.createControl();
			ScalableFreeformRootEditPart gZdclw87 = new ScalableFreeformRootEditPart();
			L0ZUBKXZ.setRootEditPart(gZdclw87);
			L0ZUBKXZ.setEditDomain(new EditDomain());
			L0ZUBKXZ.setEditPartFactory(new org.drawx.gef.sample.client.tool.example.editparts.MyEditPartFactory());
			CanvasModel Xh478Lsj = new CanvasModel();
			for (int OKZ46IJB = 0; OKZ46IJB < 1; OKZ46IJB++) {
				MyConnectionModel ZhOZbSva = new MyConnectionModel();
				OrangeModel kvX2h9Uu = new OrangeModel(new Point(30, 230));
				OrangeModel tQKUfSC0 = new OrangeModel(new Point(0, 0));
				Xh478Lsj.addChild(kvX2h9Uu);
				Xh478Lsj.addChild(tQKUfSC0);
				kvX2h9Uu.addSourceConnection(ZhOZbSva);
				tQKUfSC0.addTargetConnection(ZhOZbSva);
				L0ZUBKXZ.setContents(Xh478Lsj);
			}
			DiagramEditor hY5frwZv = new DiagramEditor(L0ZUBKXZ);
			L0ZUBKXZ.setContextMenu(new MyContextMenuProvider(L0ZUBKXZ, hY5frwZv.getActionRegistry()));
			VerticalPanel tu2PfNGG = new VerticalPanel();
			addToolbox(L0ZUBKXZ.getEditDomain(), L0ZUBKXZ, tu2PfNGG);
			tu2PfNGG.add(L0ZUBKXZ.getControl().getWidget());
			nGnk8bU5.add(tu2PfNGG, "Fixed Size Canvas(+Overview)");
			addOverview(L0ZUBKXZ, tu2PfNGG);
			L0ZUBKXZ.getControl().setSize(400, 300);
		} catch (Throwable k06dCPTs) {
			k06dCPTs.printStackTrace();
		}
	}

}