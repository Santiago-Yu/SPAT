class n4647738{
    private static void tryToMerge(String url) {
        if ("none".equalsIgnoreCase(url)) return;
        Properties nullProps = new Properties();
        FileProperties propsIn = new FileProperties(nullProps, nullProps);
        try {
            propsIn.load(new URL(url).openStream());
        } catch (Exception e) {
        }
        if (propsIn.isEmpty()) return;
        for (Iterator i = propsIn.entrySet().iterator(); i.hasNext(); ) {
            Map.Entry e = (Map.Entry) i.next();
            String propKey = ((String) e.getKey()).trim();
            if (!propKey.startsWith(MERGE_PROP_PREFIX)) continue;
            String settingName = propKey.substring(MERGE_PROP_PREFIX.length());
            if (getVal(settingName) == null) {
                String settingVal = ((String) e.getValue()).trim();
                set(settingName, settingVal);
            }
        }
    }

}