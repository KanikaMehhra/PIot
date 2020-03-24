
from MyClasses.Color import Color
from MyClasses.Emoji import Emoji

color=Color()

noColor=color.getNoColorColor()
red=color.getRedColor()
green=color.getGreenColor()
blue=color.getBlueColor()


happyEmoji=Emoji([
    ['b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'],
    ['b', 'o', 'o', 'o', 'o', 'o', 'b', 'b'],
    ['o', 'f', 'f', 'f', 'f', 'f', 'o', 'b'],
    ['o', 'f', 'f', 'f', 'f', 'f', 'o', 'b'],
    ['o', 'f', 'f', 'f', 'f', 'f', 'o', 'b'],
    ['o', 'f', 'f', 'f', 'f', 'f', 'o', 'b'],
    ['b', 'o', 'o', 'o', 'o', 'o', 'b', 'b'],
    ['b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'],
], red, green, blue)

while True:
    happyEmoji.drawEmoji()
