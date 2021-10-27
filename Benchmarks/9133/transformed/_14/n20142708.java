class n20142708 {
	protected void refreshMods(String modsUrl) {
		while (true) {
			JMenuItem mi = mnMods.getItem(mnMods.getItemCount() - 1);
			if (null == mi)
				break;
			mnMods.remove(mnMods.getItemCount() - 1);
		}
		try {
			log.info("Loading mods from " + modsUrl);
			URL url = new URL(modsUrl);
			URLConnection conn = url.openConnection();
			conn.setUseCaches(false);
			SAXReader reader = new SAXReader();
			Document document = reader.read(conn.getInputStream());
			Element root = document.getRootElement();
			for (Iterator i = root.elementIterator("mod"); i.hasNext();) {
				final Element mod = (Element) i.next();
				JMenuItem mi = new JMenuItem(mod.element("name").getTextTrim());
				mi.setIcon(Application.icon("applications-other"));
				mi.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						Application.getInstance().openUrl(mod.element("siteUrl").getTextTrim());
					}
				});
				mnMods.add(mi);
			}
		} catch (Throwable t) {
			t.printStackTrace();
			log.warn("Failed to dynamically add mod links");
		}
	}

}