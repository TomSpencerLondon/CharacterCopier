package com.codurance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CopierShould {

  @Test
  void get_chars_from_source_and_set_in_destination() {
    String text = "source text\n";
    Source sourceStub = new SourceStub(text);
    DestinationMock destinationMock = new DestinationMock();
    destinationMock.expect(text);
    Copier copier = new Copier(sourceStub, destinationMock);
    copier.copy();
    destinationMock.verify();
  }

  private static class SourceStub implements Source {

    private final String text;
    private int currentIndex = 0;

    public SourceStub(String text) {
      this.text = text;
    }

    @Override
    public char getChar() {
      return text.charAt(currentIndex++);
    }
  }

  private static class DestinationMock implements Destination {

    private String expectedText;
    private String copiedText = "";

    public void expect(String text) {
      expectedText = text.substring(0, text.indexOf("\n"));
    }

    public void verify() {
      assertEquals(expectedText, copiedText);
    }

    @Override
    public void setChar(char character) {
      copiedText += character;
    }
  }
}
