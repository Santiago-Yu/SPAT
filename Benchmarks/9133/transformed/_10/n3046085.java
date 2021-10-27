class n3046085 {
	public Song(String s) {
        free = false;
        StringTokenizer tokenizer = new StringTokenizer(s, ";");
        title = tokenizer.nextToken();
        artist = tokenizer.nextToken();
        location = tokenizer.nextToken();
        rating = Integer.parseInt(tokenizer.nextToken());
        overplay = Integer.parseInt(tokenizer.nextToken());
        String temp = tokenizer.nextToken();
        tags=new ArrayList<String>();
        tokenizer = new StringTokenizer(temp, ",[] ");
        byte[] bytes = new byte[40];
        while (tokenizer.hasMoreTokens()) {
			tags.add(tokenizer.nextToken());
		}
        try {
            MessageDigest hasher = MessageDigest.getInstance("SHA-1");
            hasher.update(title.getBytes());
            hasher.update(artist.getBytes());
            bytes = hasher.digest();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}