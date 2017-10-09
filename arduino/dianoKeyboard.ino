#include <CapacitiveSensor.h>

unsigned int capSensePin[] = {3, 4, 5, 6, 7, 8, 9};

//int ON = 100;//velocity of MIDI notes, must be between 0 and 127
//int OFF = 0;
unsigned int LINE = 2;
//int noteON = 144;//144 = 10010000 in binary, note on command

String pianoKeys[] = {"C3", "D3", "E3", "F3", "G3", "A3", "B3"};

static unsigned int lastInput[] = {0, 0, 0, 0, 0, 0, 0};
unsigned int newInput[] = {0, 0, 0, 0, 0, 0, 0};
unsigned int lastKey = 99;
unsigned long changeTime;
void setup() {
  //  Set MIDI baud rate:
  Serial.begin(31250);
  for (int i = 0; i < 7; ++i) {
      newInput[i] =  (unsigned int)readCapacitivePin(capSensePin[i]);
      lastInput[i] = newInput[i];
  }
  changeTime = millis();
}
void loop() {
  //if ( (millis() % 500) == 0) {
  if((millis() - changeTime) > 100){
    for (int i = 0; i < 7; ++i) {
      newInput[i] =  (unsigned int)readCapacitivePin(capSensePin[i]);
      if (lastInput[i] < newInput[i] && newInput[i] > LINE){
        changeTime = millis();
        Serial.println(pianoKeys[i]);
        lastInput[i] = newInput[i];
        if(lastKey == 99){
          lastKey = i;
          break;
        }
        if(lastKey > i){
          lastInput[lastKey] = (unsigned int)readCapacitivePin(capSensePin[lastKey]);
        }else if(lastKey < i){
          lastInput[lastKey] = newInput[lastKey];
        }
        lastKey = i;
        break;
      }
    }
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




