package org.jukka;

public class Main {

    public static String ROOT = "../";

    public static void main(String[] args) {
        try {
            Env env = new Env(ROOT);
            String schemaPath = env.getSchemaLocation() + "/schema.json";
            String avroFile = env.getOutputLocation() + "/user.avro";
            AvroReader reader = new AvroReader();
            reader.read(schemaPath,avroFile);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}