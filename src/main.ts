
import * as avro from 'avsc'
import * as fs from 'fs'
import * as path from 'path'
import dotenv from 'dotenv'


dotenv.config()

const schemaLocation:string = process.env.SCHEMA_LOCATION as string
const outputLocation:string = process.env.OUTPUT_LOCATION as string
const inputLocation:string = process.env.INPUT_LOCATION as string

const schemaPath = path.join(schemaLocation, 'schema.json')
const schema = JSON.parse(fs.readFileSync(schemaPath, 'utf-8'))
const user = fs.readFileSync(path.join(inputLocation,"user.json"),'utf-8')

const type = avro.Type.forSchema(schema)

const avroFilePath = path.join(outputLocation, 'user.avro');
const avroFileStream = fs.createWriteStream(avroFilePath, { flags: 'w' });

const encoder = new avro.streams.BlockEncoder(type);

encoder.pipe(avroFileStream);
encoder.write(JSON.parse(user));
encoder.end();


console.log('Data successfully written to user.avro');
