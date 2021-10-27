class n7363810 {
	public RandomAccessFileOrArray(URL dC7tqJsA) throws IOException {
        InputStream VzTe7Nft = dC7tqJsA.openStream();
        try {
            this.arrayIn = InputStreamToArray(VzTe7Nft);
        } finally {
            try {
                VzTe7Nft.close();
            } catch (IOException sffAwxsM) {
            }
        }
    }

}