//#include <CapacitiveSensor.h>
//#include <Adafruit_NeoPixel.h>
//#ifdef __AVR__
//  #include <avr/power.h>
//#endif
//#define PIN 13
//
//#define NUMPIXELS 30  
//
//Adafruit_NeoPixel pixels = Adafruit_NeoPixel(NUMPIXELS, PIN, NEO_GRB + NEO_KHZ800);
//
//int delayval = 500;
#define BTNCOUNT 36
#define LEDCOUNT 7
unsigned int capSensePin[] = {22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 42, 44, 
                              46, 48, 50, 52, 23, 25, 27, 29, 31, 33, 35, 37,
                              39, 41, 43, 45, 47, 49, 51,  9, 10, 11, 12, 13};
unsigned int ledPin[] = {2, 3, 4, 5, 6, 7, 8};

//int ON = 100;//velocity of MIDI notes, must be between 0 and 127
//int OFF = 0;
unsigned int LINE = 3;
//int noteON = 144;//144 = 10010000 in binary, note on command  

String pianoKeys[] = {"C3", "C3#", "D3", "D3#", "E3", "F3", "F3#", "G3", "G3#", "A3", "A3#", "B3",
                      "C4", "C4#", "D4", "D4#", "E4", "F4", "F4#", "G4", "G4#", "A4", "A4#", "B4",
                      "C5", "C5#", "D5", "D5#", "E5", "F5", "F5#", "G5", "G5#", "A5", "A5#", "B5"};
  
static unsigned int lastInput[BTNCOUNT] = {0};

unsigned int lastKey = 99;
unsigned long changeTime;
void setup() {
  //  Set MIDI baud rate:
  Serial.begin(9600);
  //for (int i = 0; i < 7; ++i) {
  //    newInput[i] =  (unsigned int)readCapacitivePin(capSensePin[i]);
  //   lastInput[i] = newInput[i];
  //}
  for(unsigned int i = 0; i < LEDCOUNT; i++){
    pinMode(ledPin[i],OUTPUT);
  }
  changeTime = millis();
}
void loop() {
  //  if ( (millis() % 200) == 0) {
  if ((millis() - changeTime) > 250) {
  /**   1 **********
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
    
    static unsigned int lastInput8 = 0;
    unsigned int newInput8 = (unsigned int)readCapacitivePin(capSensePin[7]);
    if (lastInput8 < newInput8 && newInput8 > LINE && lastInput8 <= LINE) {
      changeTime = millis();
      Serial.println(pianoKeys[7]);
    }
    lastInput8 = newInput8;
    
    static unsigned int lastInput9 = 0;
    unsigned int newInput9 = (unsigned int)readCapacitivePin(capSensePin[8]);
    if (lastInput9 < newInput9 && newInput9 > LINE && lastInput9 <= LINE) {
      changeTime = millis();
      Serial.println(pianoKeys[8]);
    }
    lastInput9 = newInput9;
        
    static unsigned int lastInput10 = 0;
    unsigned int newInput10 = (unsigned int)readCapacitivePin(capSensePin[9]);
    if (lastInput10 < newInput10 && newInput10 > LINE && lastInput10 <= LINE) {
      changeTime = millis();
      Serial.println(pianoKeys[9]);
    }
    lastInput10 = newInput10;
    
    static unsigned int lastInput11 = 0;
    unsigned int newInput11 = (unsigned int)readCapacitivePin(capSensePin[10]);
    if (lastInput11 < newInput11 && newInput11 > LINE && lastInput11 <= LINE) {
      changeTime = millis();
      Serial.println(pianoKeys[10]);
    }
    lastInput11 = newInput11;
    */
    /*** 2 ***/
    startReg();
    /*** 3 ***/
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
void startReg(){
  unsigned int newInput[BTNCOUNT] = {0};
  for(int i = 0; i < BTNCOUNT; i ++){
    newInput[i] = (unsigned int)readCapacitivePin(capSensePin[i]);
    if (lastInput[i] < newInput[i] && newInput[i] > LINE && lastInput[i] <= LINE) {
      changeTime = millis();
//      Serial.print(newInput[i]);
//      Serial.print(lastInput[i]);
      ledLight(newInput[i]);
      Serial.println(pianoKeys[i]);
    }
    lastInput[i] = newInput[i];
  }
}
void ledLight(unsigned int key){
  for(unsigned int i = 0; i < LEDCOUNT; i++){
    if(i>0)
      digitalWrite(ledPin[(key+i-1)%LEDCOUNT],LOW);
    digitalWrite(ledPin[(key+i)%LEDCOUNT],HIGH);
    delay(50);
  }
  digitalWrite(ledPin[(key+LEDCOUNT-1)%LEDCOUNT],LOW);
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
//void startShow(int i) {
//  switch(i%9){
//    case 0: colorWipe(pixels.Color(0, 0, 0), 50);    // Black/off
//            break;
//    case 1: colorWipe(pixels.Color(255, 0, 0), 50);  // Red
//            break;
//    case 2: colorWipe(pixels.Color(0, 255, 0), 50);  // Green
//            break;
//    case 3: colorWipe(pixels.Color(0, 0, 255), 50);  // Blue
//            break;
//    case 4: theaterChase(pixels.Color(127, 127, 127), 50); // White
//            break;
//    case 5: theaterChase(pixels.Color(127,   0,   0), 50); // Red
//            break;
//    case 6: theaterChase(pixels.Color(  0,   0, 127), 50); // Blue
//            break;
//    case 7: rainbow(20);
//            break;
//    case 8: rainbowCycle(20);
//            break;
//    case 9: theaterChaseRainbow(50);
//            break;
//  }
//}
//void colorWipe(uint32_t c, uint8_t wait) {
//  for(uint16_t i=0; i<pixels.numPixels(); i++) {
//    pixels.setPixelColor(i, c);
//    pixels.show();
//    delay(wait);
//  }
//}
//void rainbow(uint8_t wait) {
//  uint16_t i, j;
//
//  for(j=0; j<256; j++) {
//    for(i=0; i<pixels.numPixels(); i++) {
//      pixels.setPixelColor(i, Wheel((i+j) & 255));
//    }
//    pixels.show();
//    delay(wait);
//  }
//}
//void rainbowCycle(uint8_t wait) {
//  uint16_t i, j;
//
//  for(j=0; j<256*5; j++) { // 5 cycles of all colors on wheel
//    for(i=0; i< pixels.numPixels(); i++) {
//      pixels.setPixelColor(i, Wheel(((i * 256 / pixels.numPixels()) + j) & 255));
//    }
//    pixels.show();
//    delay(wait);
//  }
//}
//void theaterChase(uint32_t c, uint8_t wait) {
//  for (int j=0; j<10; j++) {  //do 10 cycles of chasing
//    for (int q=0; q < 3; q++) {
//      for (int i=0; i < pixels.numPixels(); i=i+3) {
//        pixels.setPixelColor(i+q, c);    //turn every third pixel on
//      }
//      pixels.show();
//
//      delay(wait);
//
//      for (int i=0; i < pixels.numPixels(); i=i+3) {
//        pixels.setPixelColor(i+q, 0);        //turn every third pixel off
//      }
//    }
//  }
//}
//
////Theatre-style crawling lights with rainbow effect
//void theaterChaseRainbow(uint8_t wait) {
//  for (int j=0; j < 256; j++) {     // cycle all 256 colors in the wheel
//    for (int q=0; q < 3; q++) {
//      for (int i=0; i < pixels.numPixels(); i=i+3) {
//        pixels.setPixelColor(i+q, Wheel( (i+j) % 255));    //turn every third pixel on
//      }
//      pixels.show();
//
//      delay(wait);
//
//      for (int i=0; i < pixels.numPixels(); i=i+3) {
//        pixels.setPixelColor(i+q, 0);        //turn every third pixel off
//      }
//    }
//  }
//}
//
//// Input a value 0 to 255 to get a color value.
//// The colours are a transition r - g - b - back to r.
//uint32_t Wheel(byte WheelPos) {
//  WheelPos = 255 - WheelPos;
//  if(WheelPos < 85) {
//    return pixels.Color(255 - WheelPos * 3, 0, WheelPos * 3);
//  }
//  if(WheelPos < 170) {
//    WheelPos -= 85;
//    return pixels.Color(0, WheelPos * 3, 255 - WheelPos * 3);
//  }
//  WheelPos -= 170;
//  return pixels.Color(WheelPos * 3, 255 - WheelPos * 3, 0);
//}




