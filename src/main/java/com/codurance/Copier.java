package com.codurance;

public class Copier {

  private final Source source;
  private final Destination destination;

  public Copier(Source source, Destination destination) {
    this.source = source;
    this.destination = destination;
  }

  public void copy() {
    char character = source.getChar();
    while(character != '\n'){
      character = source.getChar();
      if (character != '\n')
        destination.setChar(character);
    }
  }
}
