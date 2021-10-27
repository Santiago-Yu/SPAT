class n655442{
    protected static boolean isLatestVersion(double myVersion, String referenceAddress) {
        Scanner scanner = null;
        try {
            URL url = new URL(referenceAddress);
            InputStream iS = url.openStream();
            scanner = new Scanner(iS);
            String firstLine = scanner.nextLine();
            double latestVersion = Double.valueOf(firstLine.trim());
            return myVersion >= latestVersion;
        } catch (Exception e) {
            displaySimpleAlert(null, "Cannot check latest version...check internet connection?");
            return false;
        }
    }

}