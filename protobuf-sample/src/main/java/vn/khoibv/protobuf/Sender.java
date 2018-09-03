package vn.khoibv.protobuf;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;
import vn.khoibv.protobuf.proto.AddressBookProto.AddressBook;
import vn.khoibv.protobuf.proto.AddressBookProto.Person;
import vn.khoibv.protobuf.proto.AddressBookProto.Person.PhoneNumber;
import vn.khoibv.protobuf.proto.AddressBookProto.Person.PhoneType;

public class Sender {

  Random random = new Random(12345);

  public Person createPerson(int index) {
    Person.Builder builder = Person.newBuilder();

    builder
        .setId(index)
        .setName(String.format("User %03d", index))                         // name: User 001
        .setEmail(String.format("user%03d@mail.com", index))                // mail: user001@mail.com
        .addPhones(PhoneNumber.newBuilder()
            .setNumber(String.format("%04d-%03d-%04d", index, index, index))// mobile: 0001-001-0001
            .setType(PhoneType.MOBILE))
        .addPhones(PhoneNumber.newBuilder()
            .setNumber(String.format("%04d-%03d", index, index))            // work: 0001-001
            .setType(PhoneType.WORK));

    int randomNumber = random.nextInt(1_000_000);

    // 50% persons have home number
    if (randomNumber % 2 == 0) {
      builder.addPhones(PhoneNumber.newBuilder()
          .setNumber(String.format("%07d", randomNumber))                   // home: 1234567
          .setType(PhoneType.HOME));
    }

    return builder.build();
  }

  /**
   * Create sample address book and save to output stream
   *
   * @param outputStream Output to save
   */
  public void createAddressBook(int addressCount, OutputStream outputStream)
      throws IOException {

    AddressBook.Builder builder = AddressBook.newBuilder();

    for (int i = 1; i <= addressCount; i++) {
      builder.addPeople(this.createPerson(i));
    }

    builder.build().writeTo(outputStream);
  }

}
