class n20142708 {
	protected void refreshMods(String GPwRRNPu) {
		while (true) {
			JMenuItem IpqFlXRk = mnMods.getItem(mnMods.getItemCount() - 1);
			if (IpqFlXRk == null)
				break;
			mnMods.remove(mnMods.getItemCount() - 1);
		}
		try {
			log.info("Loading mods from " + GPwRRNPu);
			URL Zm1cpE6G = new URL(GPwRRNPu);
			URLConnection tr1uJfd3 = Zm1cpE6G.openConnection();
			tr1uJfd3.setUseCaches(false);
			SAXReader Z9l0MU2c = new SAXReader();
			Document v7XjTjrZ = Z9l0MU2c.read(tr1uJfd3.getInputStream());
			Element L2O7ndxd = v7XjTjrZ.getRootElement();
			for (Iterator FbQmmcoM = L2O7ndxd.elementIterator("mod"); FbQmmcoM.hasNext();) {
				final Element NJvIUqvB = (Element) FbQmmcoM.next();
				JMenuItem H6Tkomkx = new JMenuItem(NJvIUqvB.element("name").getTextTrim());
				H6Tkomkx.setIcon(Application.icon("applications-other"));
				H6Tkomkx.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent GBiHuVSY) {
						Application.getInstance().openUrl(NJvIUqvB.element("siteUrl").getTextTrim());
					}
				});
				mnMods.add(H6Tkomkx);
			}
		} catch (Throwable ZkzRBoC3) {
			ZkzRBoC3.printStackTrace();
			log.warn("Failed to dynamically add mod links");
		}
	}

}