package vn.khoibv.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.stream.Collectors;
import vn.khoibv.protobuf.proto.AddressBookProto.AddressBook;

public class Receiver {


  public String receiveAddressBook(InputStream inputStream) throws IOException {

    AddressBook addressBook = AddressBook.parseFrom(inputStream);

    StringBuilder sb = new StringBuilder();
    addressBook.getPeopleList().forEach(person -> {

      sb.append(String.format("{id: %d, name: %s, email: %s, phones: [%s]}",
          person.getId(),
          person.getName(),
          person.getEmail(),
          person.getPhonesList()
              .stream()
              .map(phone -> String.format("{number: %s, type: %s}", phone.getNumber(), phone.getType()))
              .collect(Collectors.joining(", "))
          ))
          .append("\r\n");
    });

    return sb.toString();
  }


}
