class n7095415 {
	public CountModel(URL P3GueSLN) throws IOException {
        BufferedReader SsZr8fnT = new BufferedReader(new InputStreamReader(P3GueSLN.openStream()));
        String kcaopBhX;
        list = new ArrayList<CountModelItem>();
        map = new HashMap<String, CountModelItem>();
        kcaopBhX = SsZr8fnT.readLine();
        int xlXN7Dfx = 1;
        String[] Hu76par5;
        CountModelItem wLm1SAeb;
        while ((kcaopBhX = SsZr8fnT.readLine()) != null) {
            Hu76par5 = kcaopBhX.split(";");
            wLm1SAeb = new CountModelItem(xlXN7Dfx, Integer.valueOf(Hu76par5[1]).intValue(), Integer.valueOf(Hu76par5[2]).intValue(), Integer.valueOf(Hu76par5[3]).intValue(), Hu76par5[0]);
            list.add(wLm1SAeb);
            map.put(wLm1SAeb.getHash(), wLm1SAeb);
            xlXN7Dfx++;
        }
        SsZr8fnT.close();
    }

}