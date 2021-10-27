class n361953{
    private static Manifest getManifest() throws IOException {
        Stack manifests = new Stack();
        for (Enumeration e = Run.class.getClassLoader().getResources(MANIFEST); e.hasMoreElements(); ) manifests.add(e.nextElement());
        while (!manifests.isEmpty()) {
            URL url = (URL) manifests.pop();
            InputStream in = url.openStream();
            Manifest mf = new Manifest(in);
            in.close();
            if (mf.getMainAttributes().getValue(MAIN_CLASS) != null) return mf;
        }
        throw new Error("No " + MANIFEST + " with " + MAIN_CLASS + " found");
    }

}