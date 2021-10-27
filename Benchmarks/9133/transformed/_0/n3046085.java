class n3046085 {
	public Song(String OrVZnzRE) {
        StringTokenizer x9aMJu0y = new StringTokenizer(OrVZnzRE, ";");
        free = false;
        title = x9aMJu0y.nextToken();
        artist = x9aMJu0y.nextToken();
        location = x9aMJu0y.nextToken();
        rating = Integer.parseInt(x9aMJu0y.nextToken());
        overplay = Integer.parseInt(x9aMJu0y.nextToken());
        String psZyzOXT = x9aMJu0y.nextToken();
        x9aMJu0y = new StringTokenizer(psZyzOXT, ",[] ");
        tags = new ArrayList<String>();
        while (x9aMJu0y.hasMoreTokens()) {
            tags.add(x9aMJu0y.nextToken());
        }
        byte[] D0XkLZPQ = new byte[40];
        try {
            MessageDigest TUht0nqe = MessageDigest.getInstance("SHA-1");
            TUht0nqe.update(title.getBytes());
            TUht0nqe.update(artist.getBytes());
            D0XkLZPQ = TUht0nqe.digest();
        } catch (Exception n5HaDVOc) {
            System.out.println(n5HaDVOc);
        }
    }

}