package org.jukka;

import org.apache.avro.Schema;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumReader;

import java.io.File;
import java.io.IOException;

public class AvroReader {
    public void read(String schema,String avroFile) throws IOException {
        Schema avroSchema = new Schema.Parser().parse(new File(schema));
        DatumReader<GenericRecord> datumReader = new GenericDatumReader<GenericRecord>(avroSchema);
        DataFileReader<GenericRecord> dataFileReader = new DataFileReader<GenericRecord>(new File(avroFile), datumReader);
        GenericRecord user = null;
        while (dataFileReader.hasNext()) {
            user = dataFileReader.next(user);
            System.out.println(user);
        }
    }
}
