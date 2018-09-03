package vn.khoibv.protobuf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.Duration;

public class MainApp {


  public static void main(String[] args) throws IOException {

    // Create data and save to output file
    final String sendingFile = "data.out";
    try (OutputStream fos = new FileOutputStream(new File(sendingFile))) {

      long start = System.nanoTime();
      new Sender().createAddressBook(999, fos);
      long end = System.nanoTime();

      System.out.println(String.format("Elapsed time to serialize: %s (millis)", Duration.ofNanos(end - start).toMillis()));
    }

    // Bring outputted binary data over network
    // TODO:

    // And now retrieve data from binary
    final String receivedFile = sendingFile;
    try (InputStream fis = new FileInputStream(receivedFile)) {

      long start = System.nanoTime();
      String receivedData = new Receiver().receiveAddressBook(fis);
      long end = System.nanoTime();

      System.out.println(receivedData);

      System.out.println(String.format("Elapsed time to deserialize: %s (millis)", Duration.ofNanos(end - start).toMillis()));
    }


  }


}
