class n23248618 {
	public static Recipes addRecipe(Lists jcOVEI0a, String v45PgJpw, String wM1FL11s, Users qLmjjeuO, int G72sBe6P,
			int F7QmEGzj, int lQpQHf2D, Lists ZLx3F24j, String llgWnEi4, Iterable<String> WRPp8hOK) throws Exception {
		URL qwZI46CN = new URL(llgWnEi4);
		HttpURLConnection hHI06MyI = (HttpURLConnection) qwZI46CN.openConnection();
		hHI06MyI.connect();
		Recipes bZaZ8YGr = new Recipes(qLmjjeuO, wM1FL11s, v45PgJpw, G72sBe6P, F7QmEGzj, lQpQHf2D, jcOVEI0a, ZLx3F24j,
				Hibernate.createBlob(hHI06MyI.getInputStream(), hHI06MyI.getContentLength()), new Date(), 0);
		session.save(bZaZ8YGr);
		for (String SErvTgBI : WRPp8hOK) {
			createRecipeInstructions(bZaZ8YGr, SErvTgBI);
		}
		return bZaZ8YGr;
	}

}