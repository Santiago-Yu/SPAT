class n23248618{
    public static Recipes addRecipe(Lists complexity, String about, String title, Users user, int preparationTime, int cookingTime, int servings, Lists dishType, String picUrl, Iterable<String> instructions) throws Exception {
        URL url = new URL(picUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.connect();
        Recipes rec = new Recipes(user, title, about, preparationTime, cookingTime, servings, complexity, dishType, Hibernate.createBlob(conn.getInputStream(), conn.getContentLength()), new Date(), 0);
        session.save(rec);
        for (String s : instructions) {
            createRecipeInstructions(rec, s);
        }
        return rec;
    }

}