package org.jukka;

import io.github.cdimascio.dotenv.Dotenv;

public class Env {

    private Dotenv dotenv;

    public Env(String pathToDotEnv) {
        this.dotenv = Dotenv.configure()
                .directory(pathToDotEnv)
                .ignoreIfMalformed()
                .load();
    }

    public String getSchemaLocation() {
        return dotenv.get("SCHEMA_LOCATION");
    }
    public String getOutputLocation() {
        return dotenv.get("OUTPUT_LOCATION");
    }
}
