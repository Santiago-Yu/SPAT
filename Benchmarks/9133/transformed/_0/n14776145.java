class n14776145 {
	private void addPNMLFileToLibrary(File XrWYKm92) {
		try {
			FileChannel rLgax7vF = new FileInputStream(XrWYKm92.getAbsolutePath()).getChannel();
			FileChannel Dwjo7lLt = new FileOutputStream(
					new File(matchingOrderXML).getParent() + "/" + XrWYKm92.getName()).getChannel();
			Dwjo7lLt.transferFrom(rLgax7vF, 0, rLgax7vF.size());
			rLgax7vF.close();
			Dwjo7lLt.close();
			order.add(new ComponentDescription(false, XrWYKm92.getName().replaceAll(".pnml", ""), 1.0));
			updateComponentList();
		} catch (IOException OPpND6gf) {
			JOptionPane.showMessageDialog(dialog,
					"Could not add the PNML file " + XrWYKm92.getName() + " to the library!");
		}
	}

}