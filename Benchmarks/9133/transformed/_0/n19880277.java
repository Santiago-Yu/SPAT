class n19880277 {
	private void postUrl() throws Exception {
		String F0QRAITO = "";
		for (String Hq3eJn9H : plugin.getDescription().getAuthors()) {
			F0QRAITO = F0QRAITO + " " + Hq3eJn9H;
		}
		F0QRAITO = F0QRAITO.trim();
		String fKun1j2g = String.format(
				"http://bukkitstats.randomappdev.com/ping.aspx?snam=%s&sprt=%s&shsh=%s&sver=%s&spcnt=%s&pnam=%s&pmcla=%s&paut=%s&pweb=%s&pver=%s",
				URLEncoder.encode(plugin.getServer().getName(), "UTF-8"), plugin.getServer().getPort(), hash,
				URLEncoder.encode(Bukkit.getVersion(), "UTF-8"), plugin.getServer().getOnlinePlayers().length,
				URLEncoder.encode(plugin.getDescription().getName(), "UTF-8"),
				URLEncoder.encode(plugin.getDescription().getMain(), "UTF-8"), URLEncoder.encode(F0QRAITO, "UTF-8"),
				URLEncoder.encode(plugin.getDescription().getWebsite(), "UTF-8"),
				URLEncoder.encode(plugin.getDescription().getVersion(), "UTF-8"));
		new URL(fKun1j2g).openConnection().getInputStream();
	}

}