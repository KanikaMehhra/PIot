
from MyClasses.Color import Color
from MyClasses.Emoji import Emoji
from time import sleep

color=Color()

noColor=color.getNoColorColor()
red=color.getRedColor()
green=color.getGreenColor()
blue=color.getBlueColor()

happyEmoji=Emoji([
    ['b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'],
    ['b', 'o', 'o', 'f', 'f', 'o', 'o', 'b'],
    ['b', 'o', 'o', 'f', 'f', 'o', 'o', 'b'],
    ['b', 'f', 'f', 'f', 'f', 'f', 'f', 'b'],
    ['b', 'o', 'f', 'f', 'f', 'f', 'o', 'b'],
    ['b', 'o', 'o', 'o', 'o', 'o', 'o', 'b'],
    ['b', 'f', 'o', 'o', 'o', 'o', 'f', 'b'],
    ['b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'],
], red, green, blue)

sadEmoji=Emoji([
    ['b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'],
    ['b', 'o', 'o', 'f', 'f', 'o', 'o', 'b'],
    ['b', 'o', 'o', 'f', 'f', 'o', 'o', 'b'],
    ['b', 'f', 'f', 'f', 'f', 'f', 'f', 'b'],
    ['b', 'f', 'o', 'o', 'o', 'o', 'f', 'b'],
    ['b', 'o', 'o', 'o', 'o', 'o', 'o', 'b'],
    ['b', 'o', 'f', 'f', 'f', 'f', 'o', 'b'],
    ['b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'],
],red,green,blue)


while True:
    happyEmoji.drawEmoji()
    sleep(2)
    sadEmoji.drawEmoji()

