class n10058360{
    void startzm() {
        URL myzzurl;
        InputStream myzstream;
        byte zmemimage[];
        boolean joined;
        zmemimage = null;
        try {
            System.err.println(zcodefile);
            myzzurl = new URL(zcodefile);
            myzstream = myzzurl.openStream();
            zmemimage = suckstream(myzstream);
        } catch (MalformedURLException booga) {
            try {
                myzstream = new FileInputStream(zcodefile);
                zmemimage = suckstream(myzstream);
            } catch (IOException booga2) {
                add("North", new Label("Malformed URL"));
                failed = true;
            }
        } catch (IOException booga) {
            add("North", new Label("I/O Error"));
        }
        if (zmemimage != null) {
            switch(zmemimage[0]) {
                case 3:
                    zm = new ZMachine3(screen, status_line, zmemimage);
                    break;
                case 5:
                    remove(status_line);
                    zm = new ZMachine5(screen, zmemimage);
                    break;
                case 8:
                    remove(status_line);
                    zm = new ZMachine8(screen, zmemimage);
                    break;
                default:
                    add("North", new Label("Not a valid V3,V5, or V8 story file"));
            }
            if (zm != null) zm.start();
        }
        joined = false;
        if (zmemimage != null) {
            while (!joined) {
                try {
                    zm.join();
                    joined = true;
                } catch (InterruptedException booga) {
                }
            }
        }
        System.exit(0);
    }

}