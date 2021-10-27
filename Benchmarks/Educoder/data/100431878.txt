    public void readUNI(Vector<String> descriptions, String source) {
        InputStream is = null;
        try {
            URL url = new URL(source);
            is = url.openStream();
            Scanner scanner = new Scanner(is);
            scanner.nextLine();
            String line = "";
            String id = "";
            String desc = "";
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                Scanner linescanner = new Scanner(line);
                linescanner.useDelimiter("\t");
                id = linescanner.next();
                linescanner.next();
                desc = linescanner.next();
                linescanner.useDelimiter("\n");
                linescanner.next();
                descriptions.add(id + " " + desc);
            }
        } catch (MalformedURLException e) {
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) try {
                is.close();
            } catch (IOException e) {
            }
        }
    }
