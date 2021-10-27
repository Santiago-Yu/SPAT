class n17874921 {
	public static boolean buildCFItem2ItemStats(String outFileName, String movieAvgFileName, String custAvgFileName) {
		try {
			File infile = new File(completePath + fSep + "SmartGRAPE" + fSep + movieAvgFileName);
			FileChannel inC = new FileInputStream(infile).getChannel();
			int size = (int) inC.size();
			TShortFloatHashMap movieAverages = new TShortFloatHashMap(17770, 1);
			ByteBuffer map = inC.map(FileChannel.MapMode.READ_ONLY, 0, size);
			inC.close();
			while (map.hasRemaining()) {
				movieAverages.put(map.getShort(), map.getFloat());
			}
			infile = new File(completePath + fSep + "SmartGRAPE" + fSep + custAvgFileName);
			map = null;
			inC = new FileInputStream(infile).getChannel();
			size = (int) inC.size();
			TIntFloatHashMap custAverages = new TIntFloatHashMap(480189, 1);
			map = inC.map(FileChannel.MapMode.READ_ONLY, 0, size);
			inC.close();
			while (map.hasRemaining()) {
				custAverages.put(map.getInt(), map.getFloat());
			}
			File outfile = new File(completePath + fSep + "SmartGRAPE" + fSep + outFileName);
			FileChannel outC = new FileOutputStream(outfile, true).getChannel();
			short[] movies = CustomersAndRatingsPerMovie.keys();
			Arrays.sort(movies);
			int noMovies = movies.length;
			for (int i = 0; i < noMovies - 1; i++) {
				short movie1 = movies[i];
				TIntByteHashMap testMovieCustAndRatingsMap = (TIntByteHashMap) CustomersAndRatingsPerMovie.get(movie1);
				int[] customers1 = testMovieCustAndRatingsMap.keys();
				Arrays.sort(customers1);
				System.out.println("Processing movie: " + movie1);
				for (int j = i + 1; j < noMovies; j++) {
					short movie2 = movies[j];
					TIntByteHashMap otherMovieCustAndRatingsMap = (TIntByteHashMap) CustomersAndRatingsPerMovie
							.get(movie2);
					int[] customers2 = otherMovieCustAndRatingsMap.keys();
					int count = 0;
					TIntArrayList intersectSet = CustOverLapForTwoMoviesCustom(customers1, customers2);
					float pearsonCorr = 0;
					float diffRating = 0;
					float adjustedCosineCorr = 0;
					float cosineCorr = 0;
					float sumY = 0;
					float sumX = 0;
					float sumX2 = 0;
					float sumXY = 0;
					float sumXYPearson = 0;
					float sumY2 = 0;
					float sumY2Pearson = 0;
					float sumX2Pearson = 0;
					float sumX2ACos = 0;
					float sumXYACos = 0;
					float sumY2ACos = 0;
					if ((intersectSet.size() == 0) || (intersectSet == null)) {
						diffRating = 0;
						count = 0;
					} else {
						count = intersectSet.size();
						for (int l = 0; l < count; l++) {
							int commonCust = intersectSet.getQuick(l);
							byte ratingX = testMovieCustAndRatingsMap.get(commonCust);
							byte ratingY = otherMovieCustAndRatingsMap.get(commonCust);
							sumX += ratingX;
							sumX2 += ratingX * ratingX;
							sumY += ratingY;
							sumY2 += ratingY * ratingY;
							sumXY += ratingX * ratingY;
							diffRating += ratingX - ratingY;
							sumXYPearson += (ratingX - movieAverages.get(movie1))
									* (ratingY - movieAverages.get(movie2));
							sumX2Pearson += Math.pow((ratingX - movieAverages.get(movie1)), 2);
							sumY2Pearson += Math.pow((ratingY - movieAverages.get(movie2)), 2);
							float custAverage = custAverages.get(commonCust);
							sumXYACos += (ratingX - custAverage) * (ratingY - custAverage);
							sumX2ACos += Math.pow((ratingX - custAverage), 2);
							sumY2ACos += Math.pow((ratingY - custAverage), 2);
						}
					}
					double pearsonDenominator = Math.sqrt(sumX2Pearson) * Math.sqrt(sumY2Pearson);
					double adjCosineDenominator = Math.sqrt(sumX2ACos) * Math.sqrt(sumY2ACos);
					if (pearsonDenominator == 0.0) {
						pearsonCorr = 0;
					} else {
						pearsonCorr = new Double(sumXYPearson / pearsonDenominator).floatValue();
					}
					double cosineDenominator = Math.sqrt(sumX2) * Math.sqrt(sumY2);
					if (adjCosineDenominator == 0.0) {
						adjustedCosineCorr = 0;
					} else {
						adjustedCosineCorr = new Double(sumXYACos / adjCosineDenominator).floatValue();
					}
					ByteBuffer buf = ByteBuffer.allocate(44);
					if (cosineDenominator == 0.0) {
						cosineCorr = 0;
					} else {
						cosineCorr = new Double(sumXY / cosineDenominator).floatValue();
					}
					buf.putShort(movie1);
					buf.putShort(movie2);
					buf.putInt(count);
					buf.putFloat(diffRating);
					buf.putFloat(sumXY);
					buf.putFloat(sumX);
					buf.putFloat(sumY);
					buf.putFloat(sumX2);
					buf.putFloat(sumY2);
					buf.putFloat(pearsonCorr);
					buf.putFloat(adjustedCosineCorr);
					buf.putFloat(cosineCorr);
					buf.flip();
					outC.write(buf);
					buf.clear();
				}
			}
			outC.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}