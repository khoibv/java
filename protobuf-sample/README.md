# Protobuf sample
Using `protobuf` with Java

## Compile proto file
- `protoc -I=$SRC_DIR --java_out=$DST_DIR $SRC_DIR/addressbook.proto`

## Run example
- `mvn exec:java`

