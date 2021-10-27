class n9727295{
    public synchronized List<AnidbSearchResult> getAnimeTitles() throws Exception {
        URL url = new URL("http", host, "/api/animetitles.dat.gz");
        ResultCache cache = getCache();
        @SuppressWarnings("unchecked") List<AnidbSearchResult> anime = (List) cache.getSearchResult(null, Locale.ROOT);
        if (anime != null) {
            return anime;
        }
        Pattern pattern = Pattern.compile("^(?!#)(\\d+)[|](\\d)[|]([\\w-]+)[|](.+)$");
        Map<Integer, String> primaryTitleMap = new HashMap<Integer, String>();
        Map<Integer, Map<String, String>> officialTitleMap = new HashMap<Integer, Map<String, String>>();
        Map<Integer, Map<String, String>> synonymsTitleMap = new HashMap<Integer, Map<String, String>>();
        Scanner scanner = new Scanner(new GZIPInputStream(url.openStream()), "UTF-8");
        try {
            while (scanner.hasNextLine()) {
                Matcher matcher = pattern.matcher(scanner.nextLine());
                if (matcher.matches()) {
                    int aid = Integer.parseInt(matcher.group(1));
                    String type = matcher.group(2);
                    String language = matcher.group(3);
                    String title = matcher.group(4);
                    if (type.equals("1")) {
                        primaryTitleMap.put(aid, title);
                    } else if (type.equals("2") || type.equals("4")) {
                        Map<Integer, Map<String, String>> titleMap = (type.equals("4") ? officialTitleMap : synonymsTitleMap);
                        Map<String, String> languageTitleMap = titleMap.get(aid);
                        if (languageTitleMap == null) {
                            languageTitleMap = new HashMap<String, String>();
                            titleMap.put(aid, languageTitleMap);
                        }
                        languageTitleMap.put(language, title);
                    }
                }
            }
        } finally {
            scanner.close();
        }
        anime = new ArrayList<AnidbSearchResult>(primaryTitleMap.size());
        for (Entry<Integer, String> entry : primaryTitleMap.entrySet()) {
            Map<String, String> localizedTitles = new HashMap<String, String>();
            if (synonymsTitleMap.containsKey(entry.getKey())) {
                localizedTitles.putAll(synonymsTitleMap.get(entry.getKey()));
            }
            if (officialTitleMap.containsKey(entry.getKey())) {
                localizedTitles.putAll(officialTitleMap.get(entry.getKey()));
            }
            anime.add(new AnidbSearchResult(entry.getKey(), entry.getValue(), localizedTitles));
        }
        return cache.putSearchResult(null, Locale.ROOT, anime);
    }

}