class n23248619 {
	public static void main(String[] s1Zqtn3j) {
		try {
			Transaction zjax9B3i = session.beginTransaction();
			URL UNFMypP1 = new URL("http://www.cs.huji.ac.il/~keren_ha/J2EE/keren.jpg");
			HttpURLConnection Oy2aGwAm = (HttpURLConnection) UNFMypP1.openConnection();
			Oy2aGwAm.connect();
			Users Xt6fCTqW = new Users("kerenhaas@gmail.com", "123456", "keren", null, "sokolov 14 Raanana",
					Hibernate.createBlob(Oy2aGwAm.getInputStream(), Oy2aGwAm.getContentLength()), "about keren",
					"admin", false);
			session.save(Xt6fCTqW);
			session.flush();
			session.refresh(Xt6fCTqW);
			URL YzI8AXVC = new URL("http://www.cs.huji.ac.il/~keren_ha/J2EE/alex.jpg");
			HttpURLConnection C68pIP8D = (HttpURLConnection) YzI8AXVC.openConnection();
			Users ytKpCT0a = new Users("alex.uretsky@mail.huji.ac.il", "123456", "alex", null, null,
					Hibernate.createBlob(C68pIP8D.getInputStream(), C68pIP8D.getContentLength()), null, "admin", false);
			session.save(ytKpCT0a);
			session.flush();
			session.refresh(ytKpCT0a);
			URL vZX8C1FJ = new URL("http://www.cs.huji.ac.il/~keren_ha/J2EE/julia.jpg");
			HttpURLConnection chaSHXPd = (HttpURLConnection) vZX8C1FJ.openConnection();
			chaSHXPd.connect();
			Users A547NEgr = new Users("juliasht@gmail.com", "123456", "julia", null, null,
					Hibernate.createBlob(chaSHXPd.getInputStream(), chaSHXPd.getContentLength()), null, "admin", false);
			session.save(A547NEgr);
			session.flush();
			session.refresh(A547NEgr);
			URL WkWCeauI = new URL("http://www.cs.huji.ac.il/~keren_ha/J2EE/meir.jpg");
			HttpURLConnection dQC9fFHN = (HttpURLConnection) WkWCeauI.openConnection();
			dQC9fFHN.connect();
			Users RRZ1y3Cu = new Users("meir.spielrein@mail.huji.ac.il", "123456", "meir", null, null,
					Hibernate.createBlob(dQC9fFHN.getInputStream(), dQC9fFHN.getContentLength()), null, "admin", false);
			session.save(RRZ1y3Cu);
			session.flush();
			session.refresh(RRZ1y3Cu);
			URL zSWW85GX = new URL("http://www.cs.huji.ac.il/~keren_ha/J2EE/miki.jpg");
			HttpURLConnection xvNGjejT = (HttpURLConnection) zSWW85GX.openConnection();
			xvNGjejT.connect();
			Users uP9ssjbx = new Users("miki.shifman@mail.huji.ac.il", "123456", "miki", null, null,
					Hibernate.createBlob(xvNGjejT.getInputStream(), xvNGjejT.getContentLength()), null, "admin", false);
			session.save(uP9ssjbx);
			session.flush();
			session.refresh(uP9ssjbx);
			URL p4NADoK4 = new URL("http://www.cs.huji.ac.il/~keren_ha/J2EE/tamar.jpg");
			HttpURLConnection ifl62d4v = (HttpURLConnection) p4NADoK4.openConnection();
			ifl62d4v.connect();
			Users Peu1jAmr = new Users("taamar@gmail.com", "123456", "tami", null, null,
					Hibernate.createBlob(ifl62d4v.getInputStream(), ifl62d4v.getContentLength()), null, "admin", false);
			session.save(Peu1jAmr);
			session.flush();
			session.refresh(Peu1jAmr);
			Lists NXzXbDdB = new Lists("Complexity", "Basic");
			session.save(NXzXbDdB);
			Lists jTTuXRvX = new Lists("Complexity", "Medium");
			session.save(jTTuXRvX);
			Lists nCIYMHmY = new Lists("Complexity", "High");
			session.save(nCIYMHmY);
			Lists LQZsj1Gb = new Lists("Complexity", "Chef");
			session.save(LQZsj1Gb);
			Lists NG49Hpoo = new Lists("DishType", "Appetizers");
			session.save(NG49Hpoo);
			Lists hVdTU16H = new Lists("DishType", "First Course");
			session.save(hVdTU16H);
			Lists rqYlyOvi = new Lists("DishType", "Main Course");
			session.save(rqYlyOvi);
			Lists KxJWkrF2 = new Lists("DishType", "Dessert");
			session.save(KxJWkrF2);
			Lists Atorfub4 = new Lists("DishType", "Cocktails");
			session.save(Atorfub4);
			System.out.println("2 : " + session.isOpen());
			Lists P4s0wwAO = new Lists("Cuisine", "Italian");
			session.save(P4s0wwAO);
			Lists se4je1ZM = new Lists("Cuisine", "Chinese");
			session.save(se4je1ZM);
			Lists u4dZqZFt = new Lists("Cuisine", "Indian");
			session.save(u4dZqZFt);
			Lists zazHXLAv = new Lists("Cuisine", "French");
			session.save(zazHXLAv);
			Lists p0yZH2qw = new Lists("Cuisine", "Thai");
			session.save(p0yZH2qw);
			Lists i03NnHwe = new Lists("Cuisine", "Arabic");
			session.save(i03NnHwe);
			Lists I3buycMt = new Lists("Cuisine", "Israeli");
			session.save(I3buycMt);
			Lists qpwKMUdP = new Lists("Cuisine", "Other");
			session.save(qpwKMUdP);
			Ingredients sd3won04 = new Ingredients("flour");
			session.save(sd3won04);
			Ingredients dZcyhsv8 = new Ingredients("white sugar");
			session.save(dZcyhsv8);
			Ingredients VwRjxiuA = new Ingredients("baking powder");
			session.save(VwRjxiuA);
			Ingredients E2MdanzC = new Ingredients("ground nutmeg");
			session.save(E2MdanzC);
			Ingredients spy7tYQM = new Ingredients("salt");
			session.save(spy7tYQM);
			Ingredients OZkVIth8 = new Ingredients("pepper");
			session.save(OZkVIth8);
			Ingredients ODUs2vM9 = new Ingredients("egg");
			session.save(ODUs2vM9);
			Ingredients RQHjAS5O = new Ingredients("milk");
			session.save(RQHjAS5O);
			Ingredients uHFc334K = new Ingredients("butter");
			session.save(uHFc334K);
			Ingredients yGU6OM0C = new Ingredients("ground cinnamon");
			session.save(yGU6OM0C);
			Ingredients FdOL1fDG = new Ingredients("strawberries");
			session.save(FdOL1fDG);
			Ingredients jkF7nqAb = new Ingredients("bisquick");
			session.save(jkF7nqAb);
			Ingredients yy66mukj = new Ingredients("Whipped Cream");
			session.save(yy66mukj);
			Ingredients WyfIec9m = new Ingredients("potato");
			session.save(WyfIec9m);
			Ingredients qNgsclsC = new Ingredients("carrot");
			session.save(qNgsclsC);
			Ingredients ERuQRz6p = new Ingredients("onion");
			session.save(ERuQRz6p);
			Ingredients p0cr9OJY = new Ingredients("ketchup");
			session.save(p0cr9OJY);
			Ingredients F8SaP5yo = new Ingredients("mustard");
			session.save(F8SaP5yo);
			Ingredients VBeQH4Od = new Ingredients("Cooking Cream");
			session.save(VBeQH4Od);
			Ingredients JyW3eHUi = new Ingredients("bread");
			session.save(JyW3eHUi);
			Ingredients E7jctsDs = new Ingredients("caviar");
			session.save(E7jctsDs);
			Ingredients eWjEDrXB = new Ingredients("foigra");
			session.save(eWjEDrXB);
			Ingredients OVOHo2Ej = new Ingredients("vodka");
			session.save(OVOHo2Ej);
			Ingredients kjKW18sF = new Ingredients("orangeJuice");
			session.save(kjKW18sF);
			Ingredients n1YIiJdU = new Ingredients("ribs");
			session.save(n1YIiJdU);
			Ingredients feIeZM3b = new Ingredients("tomato");
			session.save(feIeZM3b);
			Ingredients lxOnqLTV = new Ingredients("cucumber");
			session.save(lxOnqLTV);
			Ingredients BnDY8CUt = new Ingredients("olive oil");
			session.save(BnDY8CUt);
			Ingredients a1FV3rbt = new Ingredients("chicken Breast");
			session.save(a1FV3rbt);
			Ingredients v4R3fkn9 = new Ingredients("apple");
			session.save(v4R3fkn9);
			Ingredients p9nrpnqr = new Ingredients("vanilla");
			session.save(p9nrpnqr);
			String SvbrO2fM;
			SvbrO2fM = "These muffins are delicious! The cinnamon sugar topping flavors them perfectly. This is my 10 year old brother's favorite recipe";
			Recipes x3Ufm5eI = addRecipe(NXzXbDdB, SvbrO2fM, "French Breakfast Muffins", Xt6fCTqW, 10, 25, 12, KxJWkrF2,
					"http://www.cs.huji.ac.il/~keren_ha/J2EE/muffins.jpg",
					Arrays.asList(
							"Preheat oven to 350 degrees F (175 degrees C). Grease muffin cups or line with paper muffin liners.",
							"In a medium mixing bowl, stir together flour, 1/2 cup sugar, baking powder, nutmeg and salt. Make a well in the center of the mixture. Stir together egg, milk and 1/3 cup melted butter. Add egg mixture to flour mixture; stir until just moistened (batter may be lumpy). Spoon batter into prepared muffin cups.",
							"Bake in preheated oven for 20 to 25 minutes. Meanwhile, combine 1/4 cup sugar, cinnamon When muffins are finished baking, dip tops of muffins in the melted butter, and then in the cinnamon sugar mixture. Serve warm."));
			createRecipeIngredients(x3Ufm5eI, sd3won04, 1.5, "cups");
			createRecipeIngredients(x3Ufm5eI, dZcyhsv8, 0.5, "cups");
			createRecipeIngredients(x3Ufm5eI, VwRjxiuA, 1.5, "teaspoons");
			createRecipeIngredients(x3Ufm5eI, E2MdanzC, 0.25, "teaspoons");
			createRecipeIngredients(x3Ufm5eI, spy7tYQM, 0.125, "teaspoons");
			createRecipeIngredients(x3Ufm5eI, ODUs2vM9, 1, "lightly beaten");
			createRecipeIngredients(x3Ufm5eI, RQHjAS5O, 0.5, "cups");
			createRecipeIngredients(x3Ufm5eI, uHFc334K, 0.33, "cups");
			createRecipeIngredients(x3Ufm5eI, yGU6OM0C, 0.25, "cups");
			createRecipeIngredients(x3Ufm5eI, yGU6OM0C, 0.5, "teaspoon");
			createRecipeIngredients(x3Ufm5eI, dZcyhsv8, 0.33, "cups");
			session.flush();
			session.refresh(x3Ufm5eI);
			SvbrO2fM = "This dish leaves even the biggest pasta lover satisfied. Fresh vegetables make this dish wonderful and it's easy to add meat to if you wish.";
			Recipes in3g6Eix = addRecipe(jTTuXRvX, SvbrO2fM, "Veggie Pasta Minus the Pasta", ytKpCT0a, 30, 40, 6,
					rqYlyOvi,
					"http://2.bp.blogspot.com/_wAVccjOeYzc/R4KYRa5MkLI/AAAAAAAAGz8/WeosqyuyjoQ/s400/vegetarian-tofu-curry-recipe+(13).JPG",
					Arrays.asList(
							"Preheat an oven to 350 degrees F (175 degrees C). Arrange the tomatoes on a baking sheet with the cut sides facing up. ",
							"Roast the tomatoes in the preheated oven until cooked through and slightly browned on the underside, about 15 minutes. ",
							"Place squash halves face down in glass baking dish with the water; cover with plastic wrap. Microwave on High for 8 minutes. Leave covered and set aside. Once the squash is cool enough to handle, scrape in strands into a large bowl with a fork; season with salt and pepper and toss with 1 tablespoon olive oil. ",
							"Heat the remaining 2 tablespoons olive oil in a large skillet over medium-low heat; cook and stir the garlic, basil, and Italian seasoning in the oil until the garlic is softened, about 10 minutes. Add the onion, green bell pepper, eggplant, and carrot to the garlic; increase heat to medium. Continue cooking and stirring until the vegetables are nearly tender, 10 to 15 minutes. Mix the tomatoes and white wine into the vegetable mixture; cook another 2 to 3 minutes. Transfer the vegetables to the bowl with the spaghetti squash; gently toss together."));
			createRecipeIngredients(in3g6Eix, sd3won04, 1.5, "cups");
			createRecipeIngredients(in3g6Eix, dZcyhsv8, 0.5, "cups");
			createRecipeIngredients(in3g6Eix, VwRjxiuA, 1.5, "teaspoons");
			createRecipeIngredients(in3g6Eix, E2MdanzC, 0.25, "teaspoons");
			createRecipeIngredients(in3g6Eix, spy7tYQM, 0.125, "teaspoons");
			createRecipeIngredients(in3g6Eix, ODUs2vM9, 1, "lightly beaten");
			createRecipeIngredients(in3g6Eix, RQHjAS5O, 0.5, "cups");
			createRecipeIngredients(in3g6Eix, uHFc334K, 0.33, "cups");
			createRecipeIngredients(in3g6Eix, yGU6OM0C, 0.25, "cups");
			createRecipeIngredients(in3g6Eix, yGU6OM0C, 0.5, "teaspoon");
			createRecipeIngredients(in3g6Eix, dZcyhsv8, 0.33, "cups");
			createComment(in3g6Eix, 1, A547NEgr,
					"This dish was extremely disappointing. I was very optimistic looking at the ingredient list, but after putting it all together, there was a profound lack of flavor. We eat a good deal of vegetable dishes, but this is not one we will be repeating.");
			createComment(in3g6Eix, 4, ytKpCT0a, "Very good, I also think to use less butter.");
			session.flush();
			session.refresh(in3g6Eix);
			SvbrO2fM = "A finger licking good strawberry cake!";
			Recipes tnxTEN4k = addRecipe(NXzXbDdB, SvbrO2fM, "Strawberry short cake", ytKpCT0a, 60, 70, 12, KxJWkrF2,
					"http://static.open.salon.com/files/coconut_strawberry_cake1226877577.jpg",
					Arrays.asList("Sprinkle strawberries with 2/3 cups sugar. Let stand 1 hour ",
							"Heat over to 425 degrees.", "Mix all ingredients and place in the over",
							"Slice it and eat up!"));
			createRecipeIngredients(tnxTEN4k, FdOL1fDG, 1.5, "cups");
			createRecipeIngredients(tnxTEN4k, dZcyhsv8, 0.66, "cups");
			createRecipeIngredients(tnxTEN4k, jkF7nqAb, 2, "boxese");
			createRecipeIngredients(tnxTEN4k, dZcyhsv8, 3, "tablespoons");
			createRecipeIngredients(tnxTEN4k, RQHjAS5O, 0.5, "cups");
			createRecipeIngredients(tnxTEN4k, yy66mukj, 0.75, "cups");
			createComment(tnxTEN4k, 5, A547NEgr, "Best cake I ever had!!! Kudos!!");
			session.flush();
			session.refresh(tnxTEN4k);
			SvbrO2fM = "My secret Barbecue Beef Short Ribs recipe revealed!";
			Recipes WNxO4sC0 = addRecipe(nCIYMHmY, SvbrO2fM, "Short Ribs", RRZ1y3Cu, 70, 500, 6, rqYlyOvi,
					"http://farm2.static.flickr.com/1310/1237575824_9068241a81.jpg",
					Arrays.asList("Put the potatoes and carrots in a large slow cooker",
							"Top with the onion wedges then the beef", "Combine the ketchup, , mustrard and salt",
							"Put ofver the beef", "Cook on LOW for 8 to 10 hours"));
			createRecipeIngredients(WNxO4sC0, WyfIec9m, 10, "pieces");
			createRecipeIngredients(WNxO4sC0, qNgsclsC, 1, "cups");
			createRecipeIngredients(WNxO4sC0, ERuQRz6p, 2, "units");
			createRecipeIngredients(WNxO4sC0, n1YIiJdU, 3.5, "pounds");
			createRecipeIngredients(WNxO4sC0, p0cr9OJY, 1, "cups");
			createRecipeIngredients(WNxO4sC0, F8SaP5yo, 0.5, "teaspoon");
			createComment(WNxO4sC0, 4, Xt6fCTqW, "My whole family loved it!");
			createComment(WNxO4sC0, 5, ytKpCT0a,
					"This was outstanding, will definitely use this recipe often. I used chicken legs as that was what I had and it worked great. thanks!!!!");
			session.flush();
			session.refresh(WNxO4sC0);
			SvbrO2fM = "a simple, yet yasty, Salad";
			Recipes LGI9UYDa = addRecipe(NXzXbDdB, SvbrO2fM, "Garden Salad", ytKpCT0a, 10, 15, 6, hVdTU16H,
					"http://ww-recipes.net/wp-content/uploads/2008/09/weight-watchers-arabic-salad-recipe.jpg",
					Arrays.asList("Slice the tomatoes to cubes", "Slice the cucumbers to julian strips",
							"add a pinch salt and pepper", "top with olive oil"));
			createRecipeIngredients(LGI9UYDa, feIeZM3b, 3, "pieces");
			createRecipeIngredients(LGI9UYDa, lxOnqLTV, 3, "pieces");
			createRecipeIngredients(LGI9UYDa, BnDY8CUt, 2, "tablespoons");
			createRecipeIngredients(LGI9UYDa, spy7tYQM, 1, "pinch");
			createRecipeIngredients(LGI9UYDa, OZkVIth8, 1, "pinch");
			createComment(LGI9UYDa, 5, A547NEgr, "Delicious and so easy to make!");
			session.flush();
			session.refresh(LGI9UYDa);
			SvbrO2fM = "Creme Brule - the full recipe! no shortcuts ;) ";
			Recipes julQVrhP = addRecipe(nCIYMHmY, SvbrO2fM, "Creme brule", uP9ssjbx, 30, 200, 6, KxJWkrF2,
					"http://www.cookingforengineers.com/hello/259/958/640/IMG_3335_sharp.jpg",
					Arrays.asList("bring the cooking cream to boiling temperature", "insert vanilla stick",
							"whisk eggs with sugar", "add cream to eggs CAREFULLY",
							"put in over for 30 minutes, then to the fridge for 4 hours"));
			createRecipeIngredients(julQVrhP, VBeQH4Od, 2, "cartons");
			createRecipeIngredients(julQVrhP, ODUs2vM9, 3, "yolks");
			createRecipeIngredients(julQVrhP, dZcyhsv8, 2, "tablespoons");
			createRecipeIngredients(julQVrhP, p9nrpnqr, 1, "stick");
			createComment(julQVrhP, 4, A547NEgr, "Delicious and so easy to make!");
			session.flush();
			session.refresh(julQVrhP);
			SvbrO2fM = "some toasts with foigra to get the meal started";
			Recipes Z1ID3sFM = addRecipe(NXzXbDdB, SvbrO2fM, "foigra on toast", ytKpCT0a, 15, 15, 6, NG49Hpoo,
					"http://www.italiq-expos.com/news/images/Gastronomie/Foie-gras/assiette-foie-gras.jpg",
					Arrays.asList("cut bread into oval slices", "place in toaster until a golden brown color in formed",
							"speard some foigra pate on the toasts", "optional - add some baluga caviar on top"));
			createRecipeIngredients(Z1ID3sFM, JyW3eHUi, 6, "slices");
			createRecipeIngredients(Z1ID3sFM, eWjEDrXB, 1, "can");
			createRecipeIngredients(Z1ID3sFM, E7jctsDs, 1, "minijar");
			createComment(Z1ID3sFM, 5, A547NEgr, "Delicious and so easy to make!");
			session.flush();
			session.refresh(Z1ID3sFM);
			SvbrO2fM = "delicious diatetic chicken steak";
			Recipes p6JqzQV8 = addRecipe(jTTuXRvX, SvbrO2fM, "chicken steak", RRZ1y3Cu, 15, 20, 2, rqYlyOvi,
					"http://4.bp.blogspot.com/_jhlSdMizhlU/RdOVtm-0QAI/AAAAAAAAABg/81W-JvXOACI/s400/Chicken_Steak.jpg",
					Arrays.asList("Heat a frying pan with some (preferably olive) oil",
							"when the oil is hot, place the chicken and onions in the middle",
							"fry on both sides on medium flame until it starts to turn golden",
							"season with salt and pepper"));
			createRecipeIngredients(p6JqzQV8, a1FV3rbt, 2, "pieces");
			createRecipeIngredients(p6JqzQV8, ERuQRz6p, 1, "piece");
			createRecipeIngredients(p6JqzQV8, spy7tYQM, 1, "pinch");
			createRecipeIngredients(p6JqzQV8, OZkVIth8, 1, "pinch");
			createComment(p6JqzQV8, 5, A547NEgr, "Delicious and so easy to make!");
			session.flush();
			session.refresh(p6JqzQV8);
			Favorites S0Q1JLP0 = new Favorites(Xt6fCTqW, x3Ufm5eI, null);
			session.save(S0Q1JLP0);
			Favorites Ot8tosKP = new Favorites(Xt6fCTqW, in3g6Eix, null);
			session.save(Ot8tosKP);
			Favorites EXkSmTWU = new Favorites(Xt6fCTqW, tnxTEN4k, null);
			session.save(EXkSmTWU);
			Favorites Y9JRRveq = new Favorites(Xt6fCTqW, WNxO4sC0, null);
			session.save(Y9JRRveq);
			Favorites x6zH0Ifi = new Favorites(ytKpCT0a, WNxO4sC0, null);
			session.save(x6zH0Ifi);
			Favorites jaVBJGfz = new Favorites(ytKpCT0a, in3g6Eix, null);
			session.save(jaVBJGfz);
			RecentlyViewed bz6tMtm4 = new RecentlyViewed(Xt6fCTqW, x3Ufm5eI, new Date());
			session.save(bz6tMtm4);
			RecentlyViewed yCTo1CvM = new RecentlyViewed(Xt6fCTqW, in3g6Eix, new Date());
			session.save(yCTo1CvM);
			Friends iIzKSskH = new Friends(Xt6fCTqW, ytKpCT0a, true);
			session.save(iIzKSskH);
			Friends QWvqN867 = new Friends(ytKpCT0a, Xt6fCTqW, true);
			session.save(QWvqN867);
			Friends ayhfulQw = new Friends(Xt6fCTqW, A547NEgr, false);
			session.save(ayhfulQw);
			Friends rOi9VgD6 = new Friends(Xt6fCTqW, RRZ1y3Cu, true);
			session.save(rOi9VgD6);
			Friends dDVgnIAx = new Friends(RRZ1y3Cu, Xt6fCTqW, true);
			session.save(dDVgnIAx);
			Friends o8xT18BF = new Friends(Peu1jAmr, Xt6fCTqW, false);
			session.save(o8xT18BF);
			zjax9B3i.commit();
		} catch (Exception jMK474Ft) {
			jMK474Ft.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
	}

}