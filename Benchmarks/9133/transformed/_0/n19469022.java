class n19469022 {
	public List<String> addLine(String fCheHvNK, String siDSge0s, int VvbJ8mpp) {
		List<String> HRKgM6Lc = new ArrayList<String>();
		try {
			URL DGeAJYE1 = new URL(siDSge0s + VvbJ8mpp);
			BufferedReader OsneJgXA = new BufferedReader(new InputStreamReader(DGeAJYE1.openStream()));
			String wxYRwuwJ;
			System.out.println(OsneJgXA.readLine());
			while ((wxYRwuwJ = OsneJgXA.readLine()) != null) {
				String BJA62wgF = "<text>";
				String BcjzVNRi = "</text>";
				if (wxYRwuwJ.contains(BJA62wgF) && !wxYRwuwJ.contains("@") && !wxYRwuwJ.contains("http")) {
					String tnzO0B8l = wxYRwuwJ.replace(BJA62wgF, "").replace(BcjzVNRi, "").replace("'", "").trim();
					final Tweets A7aELBwC = new Tweets(fCheHvNK, tnzO0B8l, VvbJ8mpp, false);
					int tgG6qdsZ = A7aELBwC.save();
					A7aELBwC.setId((long) tgG6qdsZ);
					Thread hRpjPewv = new Thread(new Runnable() {

						@Override
						public void run() {
							Main.addRow(A7aELBwC);
						}
					});
					hRpjPewv.start();
					System.out.println(tnzO0B8l);
				}
			}
			OsneJgXA.close();
		} catch (MalformedURLException GyQvu7nb) {
			Log.put(GyQvu7nb.toString());
			System.out.println(GyQvu7nb.toString());
		} catch (IOException z7YuWTxM) {
			Log.put(z7YuWTxM.toString());
			System.out.println(z7YuWTxM.toString());
		} catch (Exception V3sIJCZr) {
			Log.put(V3sIJCZr.toString());
			System.out.println(V3sIJCZr.toString());
		}
		return HRKgM6Lc;
	}

}