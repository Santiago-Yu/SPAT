class n11167172 {
	public MovementsPage(EditDomain z44ksVPE, Object mphKe9GR, final GraphicalViewer aUET65zl) {
        super(tree, z44ksVPE, mphKe9GR);
        tree.addSelectionChangedListener(new ISelectionChangedListener() {

            public void selectionChanged(SelectionChangedEvent eecwWBns) {
                if (eecwWBns.getSelection() instanceof IStructuredSelection) {
                    IStructuredSelection loEMKN0T = (IStructuredSelection) eecwWBns.getSelection();
                    if (loEMKN0T.getFirstElement() instanceof Movement) {
                        Movement bTR4VWXv = (Movement) loEMKN0T.getFirstElement();
                        aUET65zl.setContents(bTR4VWXv);
                    }
                }
            }
        });
    }

}