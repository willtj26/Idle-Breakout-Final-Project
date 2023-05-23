#!/usr/local/bin/python3

#notes
#  'e' is empty
#  'r' is red
#  'b' is black

IMAGE_EMPTY = "images/connect4_white.png"
IMAGE_RED = "images/connect4_red.png"
IMAGE_BLACK = "images/connect4_black.png"
IMAGE_WIDTH = "100"

import cgi, cgitb
import sys

def game_over(gameboard, winner):
    print ("{}".format(winner))
    sys.exit()


def boardInterior(gameboard):
    print ("\t<tr>")
    for index in range(0,42):
        print ("\t\t<td align='center'>")
        imageTag(gameboard[index])
        print ("\t\t</td>")
        if (index % 7 == 6):
            print ("\t</tr><tr>")
    print ("\t</tr>")

def boardHeader(gameboard):
    print ("\t<tr>")
    for col in range(1,8):
        print ("\t\t<td align='center'>")
        if gameboard[col-1] == 'e':
            print ("<input type='submit' name='column' value='{}'>".format(
               "Column " + str(col))) 
        else:
            print ("Filled")
        print ("</td>")

    print ("\t</tr>")

def whogoes(color, player):
    print ("\t<tr>")
    print ("\t\t<td colspan='7' align='center' bgcolor='antiquewhite'>")
    print ("It's {}'s turn to place a {} chit.".format(player,color))
    print ("</td>")
    print ("\t</tr>")

def imageTag(colorLetter):
    if (colorLetter == 'r'):
        print ("<img width='{}' src='{}'>".format(IMAGE_WIDTH,IMAGE_RED))
    elif (colorLetter == 'b'):
        print ("<img width='{}' src='{}'>".format(IMAGE_WIDTH,IMAGE_BLACK))
    else:
        print ("<img width='{}' src='{}'>".format(IMAGE_WIDTH,IMAGE_EMPTY))

def get_winner(gameboard):
    result = winnerInRow(gameboard)
    if result != 'e':
        return result
    result = winnerInCol(gameboard)
    if result != 'e':
        return result
    result = winnerInDownRightDiag(gameboard)
    if result != 'e':
        return result
    
    return winnerInDownLeftDiag(gameboard)

def winnerInRow(gameboard):
    for rowStart in range(0,42,7):
        for colStart in range(0, 4):
            spot = rowStart + colStart
            if fourTheSame(gameboard, spot, spot+1, spot+2, spot+3):
                return gameboard[spot]
    return 'e'

def winnerInCol(gameboard):
    for colStart in range(0,7):
        for rowStart in (0, 7, 14):
            spot = rowStart + colStart
            if fourTheSame(gameboard, spot, spot+7, spot+14, spot+21):
                return gameboard[spot]
    return 'e'

def winnerInDownRightDiag(gameboard):
    for colStart in (0, 1, 2, 3):
        for rowStart in (0, 7, 14):
            spot = rowStart + colStart
            if fourTheSame(gameboard, spot, spot+8, spot+16, spot+24):
                return gameboard[spot]
    return 'e'

def winnerInDownLeftDiag(gameboard):
    for colStart in (3, 4, 5, 6):
        for rowStart in (0, 7, 14):
            spot = rowStart + colStart
            if fourTheSame(gameboard, spot, spot+6, spot+12, spot+18):
                return gameboard[spot]
    return 'e'

def fourTheSame(gameboard, a, b, c, d):
    if gameboard[a] == gameboard[b] and \
       gameboard[b] == gameboard[c] and \
       gameboard[c] == gameboard[d] and \
       gameboard[a] != 'e':
        return True
    return False


def filled(gameboard):
    for col in range(1,8):
        if gameboard[col-1] == 'e':
            return False
    return True # not filled

##########################
#main procedure is below
###########################
cgitb.enable()
print ("Content-type: text/html\n")

form = cgi.FieldStorage() 

#pull stuff from the form 
color = form.getvalue('color')
gameBoardStr = form.getvalue('gameBoardStr')
column = form.getvalue('column')
player1 = form.getvalue('player1')
player2 = form.getvalue('player2')

#print ("<h2>State Information</h2>")
#print ("<br> color = {}".format(color))
#print ("<br> column = {}".format(column))
#print ("<br> Player 1 = {}".format(player1))
#print ("<br> Player 2 = {}".format(player2))
#print ("<br> gameBoardStr = {}".format(gameBoardStr))
#if gameBoardStr is not None:
#    print ("<br> len is {})".format(len(gameBoardStr)))

if (column == None):   # No button pushed, initialize things
#   print ("Initializing game") 
   gameboard=['e']*42
   color = 'red'  
else:                  # Column button pressed
   gameboard = gameBoardStr.split(':')
   # place the chit
   columnParts =  column.split()
   columnIndex = int(columnParts[1]) - 1
   # drop the chit
   bottom = columnIndex + (5 * 7) # 5 is the bottom row, there are 7 columns
   for row in range(5, -1, -1):
      pos = columnIndex + (row * 7)
      if (gameboard[pos] == 'e'):
          gameboard[pos] = color[0] #first letter
          break

# swap colors for next turn and set the current player
if (color == "red"):
   currentplayer = player1
   color = "black"
else:
   currentplayer = player2
   color = "red"


print ("<form method='POST'>")

# convert new gameboard list to a string
gameBoardStr = ':'.join(gameboard)

# save the state information back to the form
print ("<input type='hidden' name='gameBoardStr' value='{}'/>".format(gameBoardStr)) 
print ("<input type='hidden' name='color' value='{}'/>".format(color)) 
print ("<input type='hidden' name='player1' value='{}'/>".format(player1)) 
print ("<input type='hidden' name='player2' value='{}'/>".format(player2)) 

# did someone win?
winner = get_winner(gameboard)
if winner != 'e':
    print ("There's a winner {}, game over".format(winner))
# is the board filled?
elif filled(gameboard):
    print ("Board is filled, game over")
# print the board

print ("<table align='center' cellpadding='0' cellspacing='0'>")
whogoes(color, currentplayer)
boardHeader(gameboard)
boardInterior(gameboard)
print ("</table>")
print ("</form >")

print ("<center> <a href='.'>Restart with new players</a> </center> ") 