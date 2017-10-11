#include <CapacitiveSensor.h>

unsigned int capSensePin[] = {3, 4, 5, 6, 7, 8, 9};

//int ON = 100;//velocity of MIDI notes, must be between 0 and 127
//int OFF = 0;
unsigned int LINE = 2;
//int noteON = 144;//144 = 10010000 in binary, note on command

String pianoKeys[] = {"C3", "D3", "E3", "F3", "G3", "A3", "B3"};

//static unsigned int lastInput[] = {0, 0, 0, 0, 0, 0, 0};
//unsigned int newInput[] = {0, 0, 0, 0, 0, 0, 0};
unsigned int lastKey = 99;
unsigned long changeTime;
void setup() {
  //  Set MIDI baud rate:
  Serial.begin(9600);
  //for (int i = 0; i < 7; ++i) {
  //    newInput[i] =  (unsigned int)readCapacitivePin(capSensePin[i]);
  //   lastInput[i] = newInput[i];
  //}
  changeTime = millis();
}
void loop() {
  //  if ( (millis() % 200) == 0) {
  if ((millis() - changeTime) > 250) {
    static unsigned int lastInput1 = 0;
    unsigned int newInput1 = (unsigned int)readCapacitivePin(capSensePin[0]);
    if (lastInput1 < newInput1 && newInput1 > LINE && lastInput1 <= LINE) {
      changeTime = millis();
      Serial.println(pianoKeys[0]);
    }
    lastInput1 = newInput1;

    static unsigned int lastInput2 = 0;
    unsigned int newInput2 = (unsigned int)readCapacitivePin(capSensePin[1]);
    if (lastInput2 < newInput2 && newInput2 > LINE && lastInput2 <= LINE) {
      changeTime = millis();
      Serial.println(pianoKeys[1]);
    }
    lastInput2 = newInput2;

    static unsigned int lastInput3 = 0;
    unsigned int newInput3 = (unsigned int)readCapacitivePin(capSensePin[2]);
    if (lastInput3 < newInput3 && newInput3 > LINE && lastInput3 <= LINE) {
      changeTime = millis();
      Serial.println(pianoKeys[2]);
    }
    lastInput3 = newInput3;

    static unsigned int lastInput4 = 0;
    unsigned int newInput4 = (unsigned int)readCapacitivePin(capSensePin[3]);
    if (lastInput4 < newInput4 && newInput4 > LINE && lastInput4 <= LINE) {
      changeTime = millis();
      Serial.println(pianoKeys[3]);
    }
    lastInput4 = newInput4;

    static unsigned int lastInput5 = 0;
    unsigned int newInput5 = (unsigned int)readCapacitivePin(capSensePin[4]);
    if (lastInput5 < newInput5 && newInput5 > LINE && lastInput5 <= LINE) {
      changeTime = millis();
      Serial.println(pianoKeys[4]);
    }
    lastInput5 = newInput5;

    static unsigned int lastInput6 = 0;
    unsigned int newInput6 = (unsigned int)readCapacitivePin(capSensePin[5]);
    if (lastInput6 < newInput6 && newInput6 > LINE && lastInput6 <= LINE) {
      changeTime = millis();
      Serial.println(pianoKeys[5]);
    }
    lastInput6 = newInput6;

    static unsigned int lastInput7 = 0;
    unsigned int newInput7 = (unsigned int)readCapacitivePin(capSensePin[6]);
    if (lastInput7 < newInput7 && newInput7 > LINE && lastInput7 <= LINE) {
      changeTime = millis();
      Serial.println(pianoKeys[6]);
    }
    lastInput7 = newInput7;
    //    for (int i = 0; i < 7; ++i) {
    //      newInput[i] =  (unsigned int)readCapacitivePin(capSensePin[i]);
    //      if (lastInput[i] < newInput[i] && newInput[i] > LINE){
    //        changeTime = millis();
    //        Serial.println(pianoKeys[i]);
    //        lastInput[i] = newInput[i];
    //        if(lastKey == 99){
    //          lastKey = i;
    //          break;
    //        }
    //        if(lastKey > i){
    //          lastInput[lastKey] = (unsigned int)readCapacitivePin(capSensePin[lastKey]);
    //        }else if(lastKey < i){
    //          lastInput[lastKey] = newInput[lastKey];
    //        }
    //        lastKey = i;
    //        break;
    //      }
    //    }
  }
}
//void MIDImessage(int command, int MIDInote, int MIDIvelocity) {
//  Serial.write(command);//send note on or note off command
//  Serial.write(MIDInote);//send pitch data
//  Serial.write(MIDIvelocity);//send velocity data
//}
uint8_t readCapacitivePin(int pinToMeasure) {
  // Variables used to translate from Arduino to AVR pin naming
  volatile uint8_t* port;
  volatile uint8_t* ddr;
  volatile uint8_t* pin;
  // Here we translate the input pin number from
  // Arduino pin number to the AVR PORT, PIN, DDR,
  // and which bit of those registers we care about.
  byte bitmask;
  port = portOutputRegister(digitalPinToPort(pinToMeasure));
  ddr = portModeRegister(digitalPinToPort(pinToMeasure));
  bitmask = digitalPinToBitMask(pinToMeasure);
  pin = portInputRegister(digitalPinToPort(pinToMeasure));
  // Discharge the pin first by setting it low and output
  *port &= ~(bitmask);
  *ddr |= bitmask;
  delay(1);
  // Make the pin an input with the internal pull-up on
  *ddr &= ~(bitmask);
  *port |= bitmask;

  // Now see how long the pin to get pulled up. This manual unrolling of the loop
  // decreases the number of hardware cycles between each read of the pin,
  // thus increasing sensitivity.
  uint8_t cycles = 17;
  if (*pin & bitmask) {
    cycles = 0;
  }
  else if (*pin & bitmask) {
    cycles = 1;
  }
  else if (*pin & bitmask) {
    cycles = 2;
  }
  else if (*pin & bitmask) {
    cycles = 3;
  }
  else if (*pin & bitmask) {
    cycles = 4;
  }
  else if (*pin & bitmask) {
    cycles = 5;
  }
  else if (*pin & bitmask) {
    cycles = 6;
  }
  else if (*pin & bitmask) {
    cycles = 7;
  }
  else if (*pin & bitmask) {
    cycles = 8;
  }
  else if (*pin & bitmask) {
    cycles = 9;
  }
  else if (*pin & bitmask) {
    cycles = 10;
  }
  else if (*pin & bitmask) {
    cycles = 11;
  }
  else if (*pin & bitmask) {
    cycles = 12;
  }
  else if (*pin & bitmask) {
    cycles = 13;
  }
  else if (*pin & bitmask) {
    cycles = 14;
  }
  else if (*pin & bitmask) {
    cycles = 15;
  }
  else if (*pin & bitmask) {
    cycles = 16;
  }

  // Discharge the pin again by setting it low and output
  // It's important to leave the pins low if you want to
  // be able to touch more than 1 sensor at a time - if
  // the sensor is left pulled high, when you touch
  // two sensors, your body will transfer the charge between
  // sensors.
  *port &= ~(bitmask);
  *ddr |= bitmask;

  return cycles;
}




