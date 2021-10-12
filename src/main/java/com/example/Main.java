package com.example;

import java.io.File;
import java.io.IOException;

public class Main {
    private static String MONGODB_DATABASE_NAME = "benchmark";
    private static String MONGODB_COLLECTION_NAME = "benchmark";
    private static String COUCHDB_COLLECTION_NAME = "benchmark";

    private static String MONGODB_URI = "mongodb://root:example@localhost:27017/";

    public static void main(String[] args) throws IOException {

        String homeDirectory = System.getProperty("user.dir");
        System.out.println("homeDirectory = " + homeDirectory);
        Process process;

        var mongoshScript = new File(".\\mongosh-script.js").getCanonicalPath();
        System.out.println("mongoshScript = " + mongoshScript);

        var currentTime = System.nanoTime();

        process = Runtime.getRuntime()
                .exec(new File(".").getCanonicalPath() + "\\mongosh\\bin\\mongosh.exe -u root -p example -f " + mongoshScript + " mongodb://localhost:27017/");

        var newTime = System.nanoTime();
        float eslapsedTime = newTime - currentTime;
        System.out.println("eslapsedTime = " + eslapsedTime / 1000000);
    }
}
