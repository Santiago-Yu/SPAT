class n6306609 {
	public UploadHubList(String IlDkn24T, String L17JWHCu, String DRPlsONS, String kKvXGHyK, String gr2KrX5p) throws SocketException, IOException {
        FTPClient lEg8P9kp = new FTPClient();
        System.out.println("\t.");
        lEg8P9kp.connect(IlDkn24T);
        System.out.println("\t..");
        lEg8P9kp.login(L17JWHCu, DRPlsONS);
        System.out.print(lEg8P9kp.getReplyString());
        System.out.println("\t...");
        lEg8P9kp.storeFile(kKvXGHyK, new FileInputStream(gr2KrX5p));
        System.out.print(lEg8P9kp.getReplyString());
    }

}