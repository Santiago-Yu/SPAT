class n3440660{
    public static SlimModCollection parseSlimModification(URL url) {
        try {
            Scanner scanner = new Scanner(url.openStream());
            return parseSlimModification(scanner);
        } catch (IOException e) {
            throw new IllegalStateException("Error reading slim file: " + e.getMessage(), e);
        }
    }

}