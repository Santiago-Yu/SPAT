class n15639580 {
	public ScoreModel(URL oMuCo2NH) throws IOException {
        BufferedReader UW1uPt7K = new BufferedReader(new InputStreamReader(oMuCo2NH.openStream()));
        String Mk63ge3x;
        list = new ArrayList<ScoreModelItem>();
        map = new HashMap<String, ScoreModelItem>();
        Mk63ge3x = UW1uPt7K.readLine();
        int RRvm2xAS = 1;
        String[] e83YYjHw;
        ScoreModelItem rkxyaUYP;
        while ((Mk63ge3x = UW1uPt7K.readLine()) != null) {
            e83YYjHw = Mk63ge3x.split(";");
            rkxyaUYP = new ScoreModelItem(RRvm2xAS, Double.valueOf(e83YYjHw[3]), Double.valueOf(e83YYjHw[4]), Double.valueOf(e83YYjHw[2]), Double.valueOf(e83YYjHw[5]), e83YYjHw[1]);
            list.add(rkxyaUYP);
            map.put(rkxyaUYP.getHash(), rkxyaUYP);
            RRvm2xAS++;
        }
        UW1uPt7K.close();
    }

}