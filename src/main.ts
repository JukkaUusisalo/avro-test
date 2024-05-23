import * as avro from 'avsc';
import * as fs from 'fs';
import * as path from 'path';

const schemaPath = path.join(__dirname, 'schema.json');
const schema = JSON.parse(fs.readFileSync(schemaPath, 'utf-8'));

const type = avro.Type.forSchema(schema);

const user = {
    name: 'John Doe',
    age: 30,
    email: 'john.doe@example.com'
};

const buffer = type.toBuffer(user);

const outputPath = path.join(__dirname, 'user.avro');
fs.writeFileSync(outputPath, buffer);

console.log('Data successfully written to user.avro');
