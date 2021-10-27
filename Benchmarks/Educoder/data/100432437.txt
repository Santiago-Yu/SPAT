    public static void init(Locale lng) {
        try {
            Locale toLoad = lng != null ? lng : DEFAULT_LOCALE;
            URL url = ClassLoader.getSystemResource("locales/" + toLoad.getISO3Language() + ".properties");
            if (url == null) {
                url = ClassLoader.getSystemResource("locales/" + DEFAULT_LOCALE.getISO3Language() + ".properties");
            }
            PROPS.clear();
            PROPS.load(url.openStream());
        } catch (IOException ioe) {
            try {
                URL url = ClassLoader.getSystemResource("locales/" + DEFAULT_LOCALE.getISO3Language() + ".properties");
                PROPS.clear();
                PROPS.load(url.openStream());
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(99);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(99);
        }
    }
