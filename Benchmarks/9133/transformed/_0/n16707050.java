class n16707050 {
	public RandomAccessFileOrArray(URL B9VJ6Ry1) throws IOException {
        InputStream re71F6IJ = B9VJ6Ry1.openStream();
        try {
            this.arrayIn = InputStreamToArray(re71F6IJ);
        } finally {
            try {
                re71F6IJ.close();
            } catch (IOException aaflF0ij) {
            }
        }
    }

}