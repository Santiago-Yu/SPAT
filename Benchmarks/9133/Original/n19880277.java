class n19880277{
    private void postUrl() throws Exception {
        String authors = "";
        for (String auth : plugin.getDescription().getAuthors()) {
            authors = authors + " " + auth;
        }
        authors = authors.trim();
        String url = String.format("http://bukkitstats.randomappdev.com/ping.aspx?snam=%s&sprt=%s&shsh=%s&sver=%s&spcnt=%s&pnam=%s&pmcla=%s&paut=%s&pweb=%s&pver=%s", URLEncoder.encode(plugin.getServer().getName(), "UTF-8"), plugin.getServer().getPort(), hash, URLEncoder.encode(Bukkit.getVersion(), "UTF-8"), plugin.getServer().getOnlinePlayers().length, URLEncoder.encode(plugin.getDescription().getName(), "UTF-8"), URLEncoder.encode(plugin.getDescription().getMain(), "UTF-8"), URLEncoder.encode(authors, "UTF-8"), URLEncoder.encode(plugin.getDescription().getWebsite(), "UTF-8"), URLEncoder.encode(plugin.getDescription().getVersion(), "UTF-8"));
        new URL(url).openConnection().getInputStream();
    }

}